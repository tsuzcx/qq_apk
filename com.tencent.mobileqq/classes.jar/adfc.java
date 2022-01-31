import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.NotificationActivity.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class adfc
  implements DialogInterface.OnClickListener
{
  public adfc(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new NotificationActivity.1.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adfc
 * JD-Core Version:    0.7.0.1
 */