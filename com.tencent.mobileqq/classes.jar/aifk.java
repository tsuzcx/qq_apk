import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aifk
  extends BroadcastReceiver
{
  private aifk(aido paramaido) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
      aido.a(this.a, 1);
    }
    while (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
      return;
    }
    aido.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifk
 * JD-Core Version:    0.7.0.1
 */