import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.qphone.base.util.QLog;

public class aejs
  implements DialogInterface.OnClickListener
{
  public aejs(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NotificationActivity.a(this.a, "0X800B654");
    bdla.a(this.a.app, "dc00898", "", "", "0X800AA17", "0X800AA17", 0, 0, "", "", NotificationActivity.d(this.a), "");
    paramDialogInterface = this.a.getIntent();
    if (paramDialogInterface != null) {
      if (paramDialogInterface.getBooleanExtra("keyFromLoginView", false))
      {
        bdla.a(this.a.app, "dc00898", "", "", "0X800B293", "0X800B293", 0, 0, "", "", NotificationActivity.a(this.a), "");
        paramInt = 2098;
      }
    }
    for (;;)
    {
      if (MiniAppSecurityUtil.checkMiniAppForLogin(NotificationActivity.b(this.a))) {
        MiniAppLauncher.startMiniApp(this.a, NotificationActivity.b(this.a), paramInt, null);
      }
      for (;;)
      {
        this.a.finish();
        return;
        if (!paramDialogInterface.getBooleanExtra("keyFromAddAccount", false)) {
          break label206;
        }
        bdla.a(this.a.app, "dc00898", "", "", "0X800B295", "0X800B295", 0, 0, "", "", NotificationActivity.a(this.a), "");
        paramInt = 2119;
        break;
        QLog.e("NotificationActivity", 1, "MiniAppLauncher.startMiniApp error: fake app!");
      }
      label206:
      paramInt = 2098;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aejs
 * JD-Core Version:    0.7.0.1
 */