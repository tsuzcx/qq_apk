import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aipd
  extends BroadcastReceiver
{
  private aipd(ainh paramainh) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
      ainh.a(this.a, 1);
    }
    while (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
      return;
    }
    ainh.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipd
 * JD-Core Version:    0.7.0.1
 */