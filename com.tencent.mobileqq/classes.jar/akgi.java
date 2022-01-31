import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public class akgi
  extends ThreadPoolExecutor
{
  private static int a;
  
  public akgi(int paramInt, long paramLong)
  {
    super(paramInt, 2147483647, paramLong, TimeUnit.SECONDS, new LinkedBlockingQueue(), new akgj(), new ThreadPoolExecutor.CallerRunsPolicy());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akgi
 * JD-Core Version:    0.7.0.1
 */