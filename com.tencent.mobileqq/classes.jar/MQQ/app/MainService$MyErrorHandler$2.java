package mqq.app;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class MainService$MyErrorHandler$2
  implements Runnable
{
  MainService$MyErrorHandler$2(MainService.MyErrorHandler paramMyErrorHandler, String paramString1, AppRuntime paramAppRuntime, Constants.LogoutReason paramLogoutReason, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.val$uin.equals(this.val$app.getAccount()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked....kickPC...... in popupNotification start");
      }
      if ((this.val$reason != Constants.LogoutReason.tips) && (this.val$app.isLogin()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "kickPC in popupNotification  do logout");
        }
        this.val$app.logout(this.val$reason, true);
      }
      localIntent = new Intent(this.val$action);
      localIntent.putExtra("title", this.val$title);
      localIntent.putExtra("msg", this.val$msg);
      localIntent.putExtra("reason", this.val$reason);
      localIntent.putExtra("data", this.val$data);
      localIntent.addFlags(268435456);
    }
    try
    {
      MainService.access$000(this.this$1.this$0).startActivity(localIntent);
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      label157:
      break label157;
    }
    this.val$app.runOnUiThread(new MainService.MyErrorHandler.2.1(this));
    Intent localIntent = new Intent(this.val$action);
    localIntent.putExtra("reason", this.val$reason);
    MainService.access$000(this.this$1.this$0).sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.MainService.MyErrorHandler.2
 * JD-Core Version:    0.7.0.1
 */