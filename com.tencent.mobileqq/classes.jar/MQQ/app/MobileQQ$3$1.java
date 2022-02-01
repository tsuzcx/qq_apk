package mqq.app;

import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class MobileQQ$3$1
  implements Runnable
{
  MobileQQ$3$1(MobileQQ.3 param3) {}
  
  public void run()
  {
    if (MobileQQ.access$600(this.this$1.this$0))
    {
      MobileQQ.access$100(this.this$1.this$0).msfSub.stopMsfService();
      MobileQQ.killProcess(BaseApplication.getContext(), "com.tencent.mobileqq:MSF");
    }
    if (QLog.isColorLevel())
    {
      QLog.i("mqq", 2, String.format("Application(%s) exit.", new Object[] { MobileQQ.processName }));
      QLog.i("mqq", 2, "===========================================================");
    }
    System.exit(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.MobileQQ.3.1
 * JD-Core Version:    0.7.0.1
 */