import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aayy
  extends BroadcastReceiver
{
  aayy(aayr paramaayr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      aayr.a(this.a, paramIntent);
      aayr.d(this.a);
      aayr.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aayy
 * JD-Core Version:    0.7.0.1
 */