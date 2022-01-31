import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.qphone.base.util.QLog;

public class abig
  extends BroadcastReceiver
{
  public abig(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.gesturelock.unlock", 2, "GesturePWDUnlockActivity finish onReceive");
      }
      if ((paramIntent.getLongExtra("timeid", 0L) > this.a.a) && (!this.a.isFinishing())) {
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abig
 * JD-Core Version:    0.7.0.1
 */