import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;

public class aboi
  implements DialogInterface.OnClickListener
{
  public aboi(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      axqy.b(null, "P_CliOper", "Safe_StartAppCheck", "", "DIALOG_PACKAGE_INVALID", "LeftButton", 0, 0, "", "", "", "");
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
 * Qualified Name:     aboi
 * JD-Core Version:    0.7.0.1
 */