import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.ForwardRecentActivity;

public class actm
  extends BroadcastReceiver
{
  public actm(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!this.a.isFinishing()) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     actm
 * JD-Core Version:    0.7.0.1
 */