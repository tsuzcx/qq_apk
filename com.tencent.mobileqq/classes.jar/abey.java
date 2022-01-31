import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotificationActivity;

public class abey
  extends BroadcastReceiver
{
  public abey(NotificationActivity paramNotificationActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equals("com.tencent.mobileqq.closeNotification")) && (NotificationActivity.a(this.a) == 5)) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abey
 * JD-Core Version:    0.7.0.1
 */