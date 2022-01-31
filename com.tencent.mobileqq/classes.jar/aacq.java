import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.qphone.base.util.QLog;

final class aacq
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
        if ("android.intent.action.SCREEN_OFF".equals(paramContext))
        {
          if (QLog.isColorLevel()) {
            bfnq.c("GameCenterBroadcastReceiver", "mScreenOff = true");
          }
          GameCenterCheck.b();
          return;
        }
        if (!"android.intent.action.BATTERY_CHANGED".equals(paramContext)) {
          break;
        }
        aacp.a = paramIntent.getIntExtra("level", 0) * 100 / paramIntent.getIntExtra("scale", 100);
      } while (!QLog.isColorLevel());
      bfnq.c("GameCenterBroadcastReceiver", "battery cap= " + aacp.a);
      return;
    } while ((!"android.intent.action.ACTION_POWER_CONNECTED".equals(paramContext)) && (!"android.intent.action.ACTION_POWER_DISCONNECTED".equals(paramContext)));
    int i = paramIntent.getIntExtra("status", -1);
    if ((i == 2) || (i == 5)) {
      bool = true;
    }
    aacp.b = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacq
 * JD-Core Version:    0.7.0.1
 */