import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.qphone.base.util.QLog;

public class aeep
  extends BroadcastReceiver
{
  public aeep(JumpActivity paramJumpActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!this.a.isFinishing())
    {
      QLog.i("JumpAction", 1, "JumpActivity has finished by broadcastReceiver.");
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aeep
 * JD-Core Version:    0.7.0.1
 */