import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aaoy
  extends BroadcastReceiver
{
  aaoy(aaor paramaaor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      aaor.a(this.a, paramIntent);
      aaor.d(this.a);
      aaor.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaoy
 * JD-Core Version:    0.7.0.1
 */