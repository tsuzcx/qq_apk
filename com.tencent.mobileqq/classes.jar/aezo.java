import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.qphone.base.util.QLog;

public class aezo
  implements DialogInterface.OnClickListener
{
  public aezo(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdll.a(this.a.app, "dc00898", "", "", "0X800AA17", "0X800AA17", 0, 0, "", "", NotificationActivity.b(this.a), "");
    paramDialogInterface = this.a.getIntent();
    if (paramDialogInterface != null)
    {
      if (paramDialogInterface.getBooleanExtra("keyFromLoginView", false)) {
        bdll.a(this.a.app, "dc00898", "", "", "0X800B293", "0X800B293", 0, 0, "", "", NotificationActivity.a(this.a), "");
      }
    }
    else
    {
      if (!MiniAppSecurityUtil.checkMiniAppForLogin(NotificationActivity.c(this.a))) {
        break label180;
      }
      MiniAppLauncher.startMiniApp(this.a, NotificationActivity.c(this.a), 2098, null);
    }
    for (;;)
    {
      this.a.finish();
      return;
      if (!paramDialogInterface.getBooleanExtra("keyFromAddAccount", false)) {
        break;
      }
      bdll.a(this.a.app, "dc00898", "", "", "0X800B295", "0X800B295", 0, 0, "", "", NotificationActivity.a(this.a), "");
      break;
      label180:
      QLog.e("NotificationActivity", 1, "MiniAppLauncher.startMiniApp error: fake app!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aezo
 * JD-Core Version:    0.7.0.1
 */