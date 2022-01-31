import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;

public class adjz
  implements DialogInterface.OnClickListener
{
  public adjz(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    azqs.a(this.a.app, "dc00898", "", "", "0X800AA16", "0X800AA16", 0, 0, "", "", NotificationActivity.b(this.a), "");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adjz
 * JD-Core Version:    0.7.0.1
 */