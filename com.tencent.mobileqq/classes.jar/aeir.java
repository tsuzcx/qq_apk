import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aeir
  extends BroadcastReceiver
{
  private aeir(aegy paramaegy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
      aegy.a(this.a, 1);
    }
    while (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
      return;
    }
    aegy.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeir
 * JD-Core Version:    0.7.0.1
 */