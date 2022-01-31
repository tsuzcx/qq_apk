import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TimJumpLoginManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;

public class adrw
  implements DialogInterface.OnClickListener
{
  public adrw(TimJumpLoginManager paramTimJumpLoginManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.tencent.tim", "com.tencent.mobileqq.activity.SplashActivity"));
    localIntent.setFlags(268435456);
    TimJumpLoginManager.a(this.a).getApp().startActivity(localIntent);
    paramDialogInterface.dismiss();
    ReportController.b(TimJumpLoginManager.a(this.a), "dc00898", "", "", "0X80085DA", "0X80085DA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adrw
 * JD-Core Version:    0.7.0.1
 */