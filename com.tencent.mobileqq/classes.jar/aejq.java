import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.qphone.base.util.QLog;

public class aejq
  implements DialogInterface.OnClickListener
{
  public aejq(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdla.a(this.a.app, "dc00898", "", "", "0X800B42C", "0X800B42C", 0, 0, "", "", "", "");
    if (NotificationActivity.b(this.a)) {
      if (MiniAppSecurityUtil.checkMiniAppForLogin(NotificationActivity.b(this.a))) {
        MiniAppLauncher.startMiniApp(this.a, NotificationActivity.b(this.a), NotificationActivity.b(this.a), null);
      }
    }
    for (;;)
    {
      this.a.finish();
      return;
      QLog.e("NotificationActivity", 1, "MiniAppLauncher.startMiniApp error: fake app!");
      continue;
      paramDialogInterface = aozj.a().a(NotificationActivity.b(this.a), NotificationActivity.c(this.a));
      Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      this.a.startActivity(localIntent.putExtra("url", paramDialogInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aejq
 * JD-Core Version:    0.7.0.1
 */