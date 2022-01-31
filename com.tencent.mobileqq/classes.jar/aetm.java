import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aetm
  extends BroadcastReceiver
{
  private aetm(aert paramaert) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
      aert.a(this.a, 1);
    }
    while (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
      return;
    }
    aert.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aetm
 * JD-Core Version:    0.7.0.1
 */