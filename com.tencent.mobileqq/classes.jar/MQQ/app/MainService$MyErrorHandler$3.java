package mqq.app;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class MainService$MyErrorHandler$3
  implements Runnable
{
  MainService$MyErrorHandler$3(MainService.MyErrorHandler paramMyErrorHandler, String paramString1, AppRuntime paramAppRuntime, Constants.LogoutReason paramLogoutReason, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5) {}
  
  public void run()
  {
    Object localObject = this.val$uin;
    boolean bool;
    if ((localObject != null) && (((String)localObject).equals(this.val$app.getAccount())))
    {
      if ((this.val$reason == Constants.LogoutReason.expired) && (!this.val$app.isLogin())) {
        bool = false;
      } else {
        bool = true;
      }
      if ((this.val$reason != Constants.LogoutReason.tips) && (this.val$app.isLogin()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "kickPC in popupNotification  do logout");
        }
        this.val$app.logout(this.val$reason, true);
      }
      if ((bool) && (MainService.access$000(this.this$1.this$0) != null) && (MainService.access$000(this.this$1.this$0).getQQProcessName().equalsIgnoreCase(MainService.access$000(this.this$1.this$0).getPackageName())))
      {
        localObject = new Intent(this.val$action);
        ((Intent)localObject).setPackage(MainService.access$000(this.this$1.this$0).getPackageName());
        ((Intent)localObject).putExtra("title", this.val$title);
        ((Intent)localObject).putExtra("msg", this.val$msg);
        ((Intent)localObject).putExtra("reason", this.val$reason);
        ((Intent)localObject).putExtra("isSameDevice", this.val$isSameDevice);
        ((Intent)localObject).addFlags(268435456);
        if (!this.val$app.isClearTaskBySystem) {
          if (this.val$isSameDevice)
          {
            String str = this.val$action;
            if ((str != null) && (str.equalsIgnoreCase("mqq.intent.action.ACCOUNT_KICKED")) && (this.val$app.isBackgroundStop)) {}
          }
          else
          {
            if (this.val$app.onReceiveUnhandledKickedMsg(this.val$action, (Intent)localObject)) {
              break label360;
            }
          }
        }
      }
    }
    try
    {
      MainService.access$000(this.this$1.this$0).startActivity((Intent)localObject);
      if (!QLog.isColorLevel()) {
        break label360;
      }
      QLog.d("mqq", 2, "kicked start notification......");
    }
    catch (Exception localException)
    {
      label320:
      break label320;
    }
    this.val$app.runOnUiThread(new MainService.MyErrorHandler.3.1(this));
    break label360;
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "kicked samedevice and set kickIntent ");
    }
    this.val$app.setKickIntent((Intent)localObject);
    label360:
    localObject = new Intent(this.val$action);
    ((Intent)localObject).putExtra("reason", this.val$reason);
    ((Intent)localObject).putExtra("title", this.val$title);
    ((Intent)localObject).putExtra("msg", this.val$msg);
    ((Intent)localObject).putExtra("reason", this.val$reason);
    ((Intent)localObject).putExtra("isSameDevice", this.val$isSameDevice);
    ((Intent)localObject).putExtra("needNotify", false);
    ((Intent)localObject).setPackage(MainService.access$000(this.this$1.this$0).getPackageName());
    if ("QQConnectLogin.pre_auth".equals(this.val$serviceCmd)) {
      ((Intent)localObject).putExtra("serviceCmd", this.val$serviceCmd);
    }
    MainService.access$000(this.this$1.this$0).sendBroadcast((Intent)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("kicked....kickPC...... in popupNotification end isNeedNotify = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("mqq", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.MainService.MyErrorHandler.3
 * JD-Core Version:    0.7.0.1
 */