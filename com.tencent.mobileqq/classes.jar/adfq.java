import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;

public class adfq
  implements DialogInterface.OnClickListener
{
  public adfq(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      azmj.b(null, "P_CliOper", "Safe_StartAppCheck", "", "DIALOG_PACKAGE_INVALID", "LeftButton", 0, 0, "", "", "", "");
      this.a.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adfq
 * JD-Core Version:    0.7.0.1
 */