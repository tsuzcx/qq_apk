import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.qphone.base.util.QLog;

public class aboa
  implements DialogInterface.OnClickListener
{
  public aboa(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axqy.a(this.a.app, "dc00898", "", "", "0X800AA17", "0X800AA17", 0, 0, "", "", NotificationActivity.b(this.a), "");
    if (MiniAppSecurityUtil.checkMiniAppForLogin(NotificationActivity.c(this.a))) {
      MiniAppLauncher.startMiniApp(this.a, NotificationActivity.c(this.a), 2089, null);
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
 * Qualified Name:     aboa
 * JD-Core Version:    0.7.0.1
 */