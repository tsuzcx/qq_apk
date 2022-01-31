package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class d
  implements b.b
{
  private static d qQS = null;
  
  public static d bYu()
  {
    if (qQS == null) {
      qQS = new d();
    }
    return qQS;
  }
  
  public final boolean Q(Activity paramActivity)
  {
    Object localObject = ((ActivityManager.RunningTaskInfo)((ActivityManager)ae.getContext().getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
    if (localObject != null) {}
    for (localObject = ((ComponentName)localObject).getClassName();; localObject = "")
    {
      y.d("MicroMsg.WalletGuardFilter", "coveredPage: " + (String)localObject);
      if ((localObject == null) || (((String)localObject).equals(paramActivity.getClass().getName())) || (!((String)localObject).contains(ae.cqQ())) || ((!((String)localObject).contains("plugin.mall")) && (!((String)localObject).contains("plugin.card")) && (!((String)localObject).contains("plugin.wallet")) && (!((String)localObject).contains("plugin.wallet_index")) && (!((String)localObject).contains("plugin.webview")) && (!((String)localObject).contains("plugin.offline")) && (!((String)localObject).contains("plugin.recharge")))) {
        break;
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.d
 * JD-Core Version:    0.7.0.1
 */