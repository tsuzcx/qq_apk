import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;

public class aeju
  implements DialogInterface.OnClickListener
{
  public aeju(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NotificationActivity.a(this.a, "0X800B657");
    bdla.a(this.a.app, "dc00898", "", "", "0X800AA16", "0X800AA16", 0, 0, "", "", NotificationActivity.d(this.a), "");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aeju
 * JD-Core Version:    0.7.0.1
 */