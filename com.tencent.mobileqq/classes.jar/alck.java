import android.os.Process;
import com.tencent.open.agent.QuickLoginAuthorityActivity;

public class alck
  extends Thread
{
  public alck(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(1000L);
      Process.killProcess(Process.myPid());
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alck
 * JD-Core Version:    0.7.0.1
 */