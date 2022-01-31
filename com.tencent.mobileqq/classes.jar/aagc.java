import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;
import com.tencent.qphone.base.util.QLog;

public class aagc
  implements Runnable
{
  public aagc(AREngine paramAREngine) {}
  
  public void run()
  {
    if ((AREngine.e(this.a)) && (AREngine.e(this.a) == 2)) {
      if (AREngine.a(this.a) != null) {
        AREngine.b(this.a, 5);
      }
    }
    try
    {
      AVGestureWrapper.clearCache();
      ARWorldCupGameLogicManager.a().e();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        QLog.i("AREngine_AREngine", 2, "AVGestureWrapper.clearCache failed. UnsatisfiedLinkError. err = " + localUnsatisfiedLinkError.getMessage());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("AREngine_AREngine", 2, "AVGestureWrapper.clearCache failed. err = " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aagc
 * JD-Core Version:    0.7.0.1
 */