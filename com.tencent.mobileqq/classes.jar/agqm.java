import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class agqm
  extends BroadcastReceiver
{
  private agqm(agot paramagot) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
      agot.a(this.a, 1);
    }
    while (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
      return;
    }
    agot.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqm
 * JD-Core Version:    0.7.0.1
 */