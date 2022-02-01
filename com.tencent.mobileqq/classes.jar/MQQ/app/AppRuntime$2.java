package mqq.app;

import com.tencent.qphone.base.util.QLog;

class AppRuntime$2
  implements Runnable
{
  AppRuntime$2(AppRuntime paramAppRuntime, Constants.LogoutReason paramLogoutReason) {}
  
  public void run()
  {
    this.this$0.getApplication().dispatchAccountEvent(this.val$reason, 0, false, null);
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "real logout");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.AppRuntime.2
 * JD-Core Version:    0.7.0.1
 */