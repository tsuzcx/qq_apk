import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;

public class adkc
  implements DialogInterface.OnClickListener
{
  public adkc(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    azqs.a(this.a.app, "dc00898", "", NotificationActivity.d(this.a), "0X800AA32", "0X800AA32", 0, 0, "", "", "", NotificationActivity.a(this.a));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adkc
 * JD-Core Version:    0.7.0.1
 */