package com.tencent.mm.plugin.sandbox;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.w.b;
import com.tencent.mm.sandbox.monitor.ExceptionMonitorService;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sandbox.updater.Updater;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class SubCoreSandBox
  implements ar, com.tencent.mm.plugin.w.c
{
  public static boolean nGl = false;
  public static boolean nGm = false;
  
  public SubCoreSandBox()
  {
    y.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox constructor at: " + System.currentTimeMillis());
  }
  
  public final String Iq(String paramString)
  {
    return com.tencent.mm.sandbox.monitor.c.Iq(paramString);
  }
  
  public final com.tencent.mm.plugin.w.a a(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return Updater.c(paramContext, paramOnCancelListener);
  }
  
  public final com.tencent.mm.plugin.w.a b(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return Updater.d(paramContext, paramOnCancelListener);
  }
  
  public final void bh(boolean paramBoolean)
  {
    y.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountPostReset at: " + System.currentTimeMillis());
  }
  
  public final void bi(boolean paramBoolean)
  {
    y.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onSdcardMount at: " + System.currentTimeMillis());
  }
  
  public final void bkr()
  {
    Updater.EW(16);
  }
  
  public final b bks()
  {
    return new com.tencent.mm.sandbox.a.a(2);
  }
  
  public final com.tencent.mm.plugin.w.a dP(Context paramContext)
  {
    return Updater.fn(paramContext);
  }
  
  public final void dQ(Context paramContext)
  {
    Updater.dQ(paramContext);
  }
  
  public final void e(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Updater.e(paramString1, paramInt, paramString2, paramString3);
  }
  
  public final void gf(int paramInt)
  {
    y.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox clearPluginData at: " + System.currentTimeMillis());
  }
  
  public final void hB(boolean paramBoolean)
  {
    nGl = true;
    nGm = paramBoolean;
  }
  
  public final void onAccountRelease()
  {
    y.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountRelease at: " + System.currentTimeMillis());
  }
  
  public final void s(Context paramContext, Intent paramIntent)
  {
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, ExceptionMonitorService.class);
      ae.getContext().startService(paramIntent);
    }
  }
  
  public final void t(Context paramContext, Intent paramIntent)
  {
    paramIntent.setClass(paramContext, AppUpdaterUI.class);
    paramContext.startActivity(paramIntent);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    y.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox getBaseDBFactories at: " + System.currentTimeMillis());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sandbox.SubCoreSandBox
 * JD-Core Version:    0.7.0.1
 */