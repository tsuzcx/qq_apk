import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;

public class adkp
  implements DialogInterface.OnClickListener
{
  public adkp(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NotificationActivity.a(this.a, NotificationActivity.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adkp
 * JD-Core Version:    0.7.0.1
 */