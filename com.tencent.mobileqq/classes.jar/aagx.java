import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;
import com.tencent.qphone.base.util.QLog;

class aagx
  implements Runnable
{
  aagx(aagw paramaagw) {}
  
  public void run()
  {
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
 * Qualified Name:     aagx
 * JD-Core Version:    0.7.0.1
 */