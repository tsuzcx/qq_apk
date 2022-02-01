import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.qphone.base.util.QLog;

public class adja
  extends BroadcastReceiver
{
  public adja(AddAccountActivity paramAddAccountActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("AddAccountActivity", 1, "AutoLoginReceiver onReceive");
    AddAccountActivity.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adja
 * JD-Core Version:    0.7.0.1
 */