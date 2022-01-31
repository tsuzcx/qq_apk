import com.tencent.mobileqq.app.ThreadManager;
import eipc.EIPCThreadEngine;

public final class aghl
  extends EIPCThreadEngine
{
  public void excute(Runnable paramRunnable)
  {
    ThreadManager.executeOnSubThread(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aghl
 * JD-Core Version:    0.7.0.1
 */