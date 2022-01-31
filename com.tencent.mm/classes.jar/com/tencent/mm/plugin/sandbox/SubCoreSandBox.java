package com.tencent.mm.plugin.sandbox;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sandbox.updater.Updater;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public class SubCoreSandBox
  implements at, com.tencent.mm.plugin.p.c
{
  public static boolean qto = false;
  public static boolean qtp = false;
  
  public SubCoreSandBox()
  {
    AppMethodBeat.i(24382);
    ab.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox constructor at: " + System.currentTimeMillis());
    AppMethodBeat.o(24382);
  }
  
  public final String Uc(String paramString)
  {
    AppMethodBeat.i(24395);
    paramString = com.tencent.mm.sandbox.monitor.c.Uc(paramString);
    AppMethodBeat.o(24395);
    return paramString;
  }
  
  public final void bSs()
  {
    AppMethodBeat.i(24388);
    Updater.MX(16);
    AppMethodBeat.o(24388);
  }
  
  public final b bSt()
  {
    AppMethodBeat.i(24394);
    com.tencent.mm.sandbox.a.a locala = new com.tencent.mm.sandbox.a.a(2);
    AppMethodBeat.o(24394);
    return locala;
  }
  
  public final com.tencent.mm.plugin.p.a c(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(24389);
    paramContext = Updater.e(paramContext, paramOnCancelListener);
    AppMethodBeat.o(24389);
    return paramContext;
  }
  
  public void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(24384);
    ab.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox clearPluginData at: " + System.currentTimeMillis());
    AppMethodBeat.o(24384);
  }
  
  public final com.tencent.mm.plugin.p.a d(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(24390);
    paramContext = Updater.f(paramContext, paramOnCancelListener);
    AppMethodBeat.o(24390);
    return paramContext;
  }
  
  public final void e(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(24393);
    Updater.e(paramString1, paramInt, paramString2, paramString3);
    AppMethodBeat.o(24393);
  }
  
  public final com.tencent.mm.plugin.p.a eB(Context paramContext)
  {
    AppMethodBeat.i(24391);
    paramContext = Updater.gA(paramContext);
    AppMethodBeat.o(24391);
    return paramContext;
  }
  
  public final void eC(Context paramContext)
  {
    AppMethodBeat.i(24392);
    Updater.eC(paramContext);
    AppMethodBeat.o(24392);
  }
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    AppMethodBeat.i(24383);
    ab.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox getBaseDBFactories at: " + System.currentTimeMillis());
    AppMethodBeat.o(24383);
    return null;
  }
  
  public final void ju(boolean paramBoolean)
  {
    qto = true;
    qtp = paramBoolean;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24385);
    ab.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountPostReset at: " + System.currentTimeMillis());
    AppMethodBeat.o(24385);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(24387);
    ab.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountRelease at: " + System.currentTimeMillis());
    AppMethodBeat.o(24387);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(24386);
    ab.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onSdcardMount at: " + System.currentTimeMillis());
    AppMethodBeat.o(24386);
  }
  
  public final void v(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(24396);
    if (paramContext != null)
    {
      paramIntent.setClass(paramContext, ExceptionMonitorBroadcastReceiver.class);
      ah.getContext().sendBroadcast(paramIntent);
    }
    AppMethodBeat.o(24396);
  }
  
  public final void w(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(24397);
    paramIntent.setClass(paramContext, AppUpdaterUI.class);
    paramContext.startActivity(paramIntent);
    AppMethodBeat.o(24397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sandbox.SubCoreSandBox
 * JD-Core Version:    0.7.0.1
 */