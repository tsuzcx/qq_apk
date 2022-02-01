import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity;
import com.tencent.qphone.base.util.QLog;

public class afhz
  extends BroadcastReceiver
{
  public afhz(ConfessHalfScreenActivity paramConfessHalfScreenActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_CONFESS_FINISH_EVENT".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_QQBrowserActivity", 2, "Confess finish action! ");
      }
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhz
 * JD-Core Version:    0.7.0.1
 */