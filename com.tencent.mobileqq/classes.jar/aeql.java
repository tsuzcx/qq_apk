import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.qphone.base.util.QLog;

public class aeql
  implements DialogInterface.OnClickListener
{
  public aeql(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bcst.a(this.a.app, "dc00898", "", "", "0X800AA17", "0X800AA17", 0, 0, "", "", NotificationActivity.b(this.a), "");
    if (MiniAppSecurityUtil.checkMiniAppForLogin(NotificationActivity.c(this.a))) {
      MiniAppLauncher.startMiniApp(this.a, NotificationActivity.c(this.a), 2098, null);
    }
    for (;;)
    {
      this.a.finish();
      return;
      QLog.e("NotificationActivity", 1, "MiniAppLauncher.startMiniApp error: fake app!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aeql
 * JD-Core Version:    0.7.0.1
 */