import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.qphone.base.util.QLog;

public class aeag
  extends BroadcastReceiver
{
  public aeag(SubLoginActivity paramSubLoginActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("Q.subaccount.SubLoginActivity", 1, "AutoLoginReceiver onReceive");
    SubLoginActivity.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeag
 * JD-Core Version:    0.7.0.1
 */