import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class aglb
  extends QQBroadcastReceiver
{
  public aglb(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramAppRuntime = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.d("ScanTorchActivity", 2, new Object[] { "onReceive, action=", paramAppRuntime });
      }
      if ("com.tencent.mobileqq__alive".equals(paramAppRuntime))
      {
        ScanTorchActivity.a(this.a);
        return;
      }
    } while (!"tencent.ar.worldcup.finishScanTorch".equals(paramAppRuntime));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aglb
 * JD-Core Version:    0.7.0.1
 */