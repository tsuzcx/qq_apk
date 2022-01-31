import com.tencent.mobileqq.businessCard.helpers.CameraHelper;

public class abvn
  extends Thread
{
  public abvn(CameraHelper paramCameraHelper) {}
  
  public void a()
  {
    try
    {
      CameraHelper.a().c();
      return;
    }
    finally {}
  }
  
  public void run()
  {
    try
    {
      for (;;)
      {
        Thread.sleep(3000L);
        try
        {
          a();
        }
        catch (RuntimeException localRuntimeException) {}
      }
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abvn
 * JD-Core Version:    0.7.0.1
 */