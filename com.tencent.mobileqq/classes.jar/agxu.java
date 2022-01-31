import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.qphone.base.util.QLog;

public class agxu
  extends BroadcastReceiver
{
  public agxu(SendHbActivity paramSendHbActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.qwallet.report".equals(paramIntent.getAction()))
    {
      int i = paramIntent.getIntExtra("type", 0);
      QLog.i("SendHbActivity", 2, "onReceive type = " + i);
      if (999 == i) {
        break label53;
      }
    }
    label53:
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getBundleExtra("params");
      } while (paramContext == null);
      QLog.i("SendHbActivity", 2, "onReceive bundle = " + paramContext.toString());
      paramContext = paramContext.getString("from");
    } while ((this.a.isFinishing()) || (!"video".equals(paramContext)));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agxu
 * JD-Core Version:    0.7.0.1
 */