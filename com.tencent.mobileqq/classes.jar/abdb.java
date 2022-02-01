import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class abdb
  extends BroadcastReceiver
{
  abdb(abcu paramabcu) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      abcu.a(this.a, paramIntent);
      abcu.d(this.a);
      abcu.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abdb
 * JD-Core Version:    0.7.0.1
 */