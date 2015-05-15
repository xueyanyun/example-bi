package bi;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.exceptions.JedisConnectionException;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
    	
    	
    	Jedis jedis = new Jedis("10.1.70.4", 3030, 0);
    	//String set = jedis.set("1", "1");
    	
    	try {    	
	    	Pipeline pipeline = jedis.pipelined();
	    	for (int i = 0; i < 1000000; i++) {
	    		pipeline.set(String.valueOf(i), String.valueOf(i));
			}
	    	pipeline.sync();
	    	System.out.println("1");
    	}catch (JedisConnectionException e) {
    		e.printStackTrace();
    		if (jedis.isConnected()) {
    			System.out.println("connetctd");
    			String result = jedis.get("100");
        		System.out.println(result);
			}
    		else {
				System.out.println("broken");
				jedis.connect();
				if (jedis.isConnected()) {
					System.out.println("re connect");
				}
			}
		}
    	
/**/
    	


//    	set = jedis.set("2", "2");
//    	System.out.println(set);
    	
    	
    	/*
    	 * 解决方案：
    	 * （1） 
    	 * 
    	 * */
    	

    	

    	
    }
}
