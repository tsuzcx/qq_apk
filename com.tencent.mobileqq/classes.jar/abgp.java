import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import java.lang.ref.WeakReference;

public class abgp
  extends BroadcastReceiver
{
  WeakReference<PayBridgeActivity> a;
  
  public abgp(PayBridgeActivity paramPayBridgeActivity)
  {
    this.a = new WeakReference(paramPayBridgeActivity);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("action_launch_completed".equals(paramIntent.getAction())) && ("qwallet_plugin.apk".equals(paramIntent.getStringExtra("plugin_apk"))) && (this.a != null))
    {
      paramContext = (PayBridgeActivity)this.a.get();
      if (paramContext != null) {
        paramContext.b = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abgp
 * JD-Core Version:    0.7.0.1
 */