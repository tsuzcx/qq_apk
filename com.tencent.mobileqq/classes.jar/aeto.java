import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aeto
  extends BroadcastReceiver
{
  private aeto(aerv paramaerv) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
      aerv.a(this.a, 1);
    }
    while (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
      return;
    }
    aerv.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeto
 * JD-Core Version:    0.7.0.1
 */