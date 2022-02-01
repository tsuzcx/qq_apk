package mqq.app;

import com.tencent.qphone.base.remote.SimpleAccount;

class AppRuntime$1
  implements Runnable
{
  AppRuntime$1(AppRuntime paramAppRuntime, SimpleAccount paramSimpleAccount) {}
  
  public void run()
  {
    this.this$0.getApplication().createNewRuntime(this.val$newAccount, true, true, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.AppRuntime.1
 * JD-Core Version:    0.7.0.1
 */