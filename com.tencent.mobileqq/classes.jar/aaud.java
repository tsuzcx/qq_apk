import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public final class aaud
  extends BroadcastReceiver
  implements Runnable
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.PROXY_CHANGE".equals(paramIntent.getAction()))
    {
      ArkAppCenter.b("ArkApp", "receive broadcast proxy change.");
      ThreadManager.executeOnSubThread(this);
    }
  }
  
  public void run()
  {
    if (AppNetConnInfo.isWifiConn())
    {
      ArkAppContainer.setArkHttpProxy();
      return;
    }
    ArkAppContainer.clearArkHttpProxy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaud
 * JD-Core Version:    0.7.0.1
 */