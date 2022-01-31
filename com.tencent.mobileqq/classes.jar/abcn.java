import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.ForwardRecentActivity;

public class abcn
  extends BroadcastReceiver
{
  public abcn(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!this.a.isFinishing()) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abcn
 * JD-Core Version:    0.7.0.1
 */