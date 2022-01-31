package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

public final class d
  implements b.b
{
  private static d uGa = null;
  
  public static d cYf()
  {
    AppMethodBeat.i(51691);
    if (uGa == null) {
      uGa = new d();
    }
    d locald = uGa;
    AppMethodBeat.o(51691);
    return locald;
  }
  
  public final boolean al(Activity paramActivity)
  {
    AppMethodBeat.i(51690);
    Object localObject = ((ActivityManager.RunningTaskInfo)((ActivityManager)ah.getContext().getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
    if (localObject != null) {}
    for (localObject = ((ComponentName)localObject).getClassName();; localObject = "")
    {
      ab.d("MicroMsg.WalletGuardFilter", "coveredPage: ".concat(String.valueOf(localObject)));
      if ((localObject == null) || (((String)localObject).equals(paramActivity.getClass().getName())) || (!((String)localObject).contains(ah.dsO())) || ((!((String)localObject).contains("plugin.mall")) && (!((String)localObject).contains("plugin.card")) && (!((String)localObject).contains("plugin.wallet")) && (!((String)localObject).contains("plugin.wallet_index")) && (!((String)localObject).contains("plugin.webview")) && (!((String)localObject).contains("plugin.offline")) && (!((String)localObject).contains("plugin.recharge")))) {
        break;
      }
      AppMethodBeat.o(51690);
      return false;
    }
    AppMethodBeat.o(51690);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.d
 * JD-Core Version:    0.7.0.1
 */