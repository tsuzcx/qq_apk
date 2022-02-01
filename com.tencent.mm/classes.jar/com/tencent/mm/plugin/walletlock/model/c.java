package com.tencent.mm.plugin.walletlock.model;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;

public final class c
  implements b.b
{
  private static c WhF = null;
  
  public static c inl()
  {
    AppMethodBeat.i(129896);
    if (WhF == null) {
      WhF = new c();
    }
    c localc = WhF;
    AppMethodBeat.o(129896);
    return localc;
  }
  
  public final boolean bB(Activity paramActivity)
  {
    AppMethodBeat.i(129895);
    Object localObject = ((ActivityManager.RunningTaskInfo)((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
    if (localObject != null) {}
    for (localObject = ((ComponentName)localObject).getClassName();; localObject = "")
    {
      Log.d("MicroMsg.WalletGuardFilter", "coveredPage: ".concat(String.valueOf(localObject)));
      if ((localObject == null) || (((String)localObject).equals(paramActivity.getClass().getName())) || (!((String)localObject).contains(MMApplicationContext.getSourcePackageName())) || ((!((String)localObject).contains("plugin.mall")) && (!((String)localObject).contains("plugin.card")) && (!((String)localObject).contains("plugin.wallet")) && (!((String)localObject).contains("plugin.wallet_index")) && (!((String)localObject).contains("plugin.webview")) && (!((String)localObject).contains("plugin.offline")) && (!((String)localObject).contains("plugin.recharge")))) {
        break;
      }
      AppMethodBeat.o(129895);
      return false;
    }
    AppMethodBeat.o(129895);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.model.c
 * JD-Core Version:    0.7.0.1
 */