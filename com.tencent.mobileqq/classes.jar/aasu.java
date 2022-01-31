import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.qphone.base.util.QLog;

public class aasu
  extends BroadcastReceiver
{
  public aasu(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!this.a.isFinishing())
    {
      this.a.finish();
      QLog.i("ForwardOption.ForwardEntranceActivity", 1, "ForwardRecentActivity has finished by broadcastReceiver.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aasu
 * JD-Core Version:    0.7.0.1
 */