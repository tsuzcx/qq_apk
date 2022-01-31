import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.QPSingleUpdTimerTask;
import com.tencent.qqprotect.singleupdate.QPUpdateManager;
import mqq.app.MobileQQ;

public class alye
  implements Runnable
{
  public alye(QPSingleUpdTimerTask paramQPSingleUpdTimerTask) {}
  
  public void run()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sMobileQQ.waitAppRuntime(null);
      if (localQQAppInterface != null)
      {
        ((QPUpdateManager)localQQAppInterface.getManager(193)).a();
        return;
      }
      QLog.w("QPUpdate", 1, "qqprotect failed to start update because QQAppInterface is null");
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alye
 * JD-Core Version:    0.7.0.1
 */