import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;
import com.tencent.qphone.base.util.QLog;

public class abpd
  extends BroadcastReceiver
{
  public abpd(ARMapLoadingActivity paramARMapLoadingActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, String.format("onReceive action=%s", new Object[] { paramContext }));
    }
    if ("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED".equals(paramContext)) {
      if (paramIntent.getBooleanExtra("pre_start_thread", false)) {
        ARMapLoadingActivity.a(this.a, true);
      }
    }
    while (!"com.tencent.mobileqq.armap.ACTION_START_ARMAP_COMPLETED".equals(paramContext))
    {
      return;
      ARMapLoadingActivity.a(this.a).removeMessages(108);
      ARMapLoadingActivity.a(this.a).l = System.currentTimeMillis();
      ARMapLoadingActivity.a(this.a, false);
      ARMapLoadingActivity.a(this.a);
      return;
    }
    ARMapLoadingActivity.a(this.a).removeMessages(109);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abpd
 * JD-Core Version:    0.7.0.1
 */