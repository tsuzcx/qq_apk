package com.tencent.mm.plugin.sandbox;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.q.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver;
import com.tencent.mm.sandbox.monitor.ExceptionMonitorService;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sandbox.updater.Updater;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class SubCoreSandBox
  implements az, com.tencent.mm.plugin.q.c
{
  public static boolean yyA = false;
  public static boolean yyz = false;
  
  public SubCoreSandBox()
  {
    AppMethodBeat.i(28049);
    ae.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox constructor at: " + System.currentTimeMillis());
    AppMethodBeat.o(28049);
  }
  
  public final void Y(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(28063);
    if (paramContext != null)
    {
      if (!ak.coh()) {
        break label100;
      }
      ae.i("MicroMsg.CrashSecondReport", "reportCrash() process:mm");
      g.yxI.idkeyStat(1185L, 0L, 1L, true);
      paramIntent.putExtra("exceptionProcess", "mm");
    }
    for (;;)
    {
      String str = com.tencent.mm.sandbox.monitor.a.bh(paramIntent);
      ae.i("MicroMsg.SubCoreSandBox", "startExceptionMonitorService() crashPreventPath:%s", new Object[] { str });
      paramIntent.putExtra("exceptionPreventPath", str);
      try
      {
        paramIntent.setClass(paramContext, ExceptionMonitorService.class);
        ak.getContext().startService(paramIntent);
        com.tencent.mm.sandbox.monitor.a.o(paramIntent, str);
        AppMethodBeat.o(28063);
        return;
        label100:
        if (ak.foA())
        {
          ae.i("MicroMsg.CrashSecondReport", "reportCrash() process:push");
          g.yxI.idkeyStat(1185L, 1L, 1L, true);
          paramIntent.putExtra("exceptionProcess", "push");
          continue;
        }
        ae.i("MicroMsg.CrashSecondReport", "reportCrash() process:other");
        g.yxI.idkeyStat(1185L, 2L, 1L, true);
        paramIntent.putExtra("exceptionProcess", "other");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.SubCoreSandBox", "startExceptionMonitorService() %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          paramIntent.setClass(paramContext, ExceptionMonitorBroadcastReceiver.class);
          ak.getContext().sendBroadcast(paramIntent);
        }
      }
    }
  }
  
  public final void Z(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(28064);
    paramIntent.setClass(paramContext, AppUpdaterUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahE(), "com/tencent/mm/plugin/sandbox/SubCoreSandBox", "startAppUpdateUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/sandbox/SubCoreSandBox", "startAppUpdateUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(28064);
  }
  
  public final String arX(String paramString)
  {
    AppMethodBeat.i(28062);
    paramString = com.tencent.mm.sandbox.monitor.c.arX(paramString);
    AppMethodBeat.o(28062);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.q.a c(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(28056);
    paramContext = Updater.e(paramContext, paramOnCancelListener);
    AppMethodBeat.o(28056);
    return paramContext;
  }
  
  public void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(28051);
    ae.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox clearPluginData at: " + System.currentTimeMillis());
    AppMethodBeat.o(28051);
  }
  
  public final com.tencent.mm.plugin.q.a d(Context paramContext, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(28057);
    paramContext = Updater.f(paramContext, paramOnCancelListener);
    AppMethodBeat.o(28057);
    return paramContext;
  }
  
  public final void dru()
  {
    AppMethodBeat.i(28055);
    Updater.aaK(16);
    AppMethodBeat.o(28055);
  }
  
  public final b drv()
  {
    AppMethodBeat.i(28061);
    com.tencent.mm.sandbox.a.a locala = new com.tencent.mm.sandbox.a.a(2);
    AppMethodBeat.o(28061);
    return locala;
  }
  
  public final com.tencent.mm.plugin.q.a fW(Context paramContext)
  {
    AppMethodBeat.i(28058);
    paramContext = Updater.iz(paramContext);
    AppMethodBeat.o(28058);
    return paramContext;
  }
  
  public final void fX(Context paramContext)
  {
    AppMethodBeat.i(28059);
    Updater.fX(paramContext);
    AppMethodBeat.o(28059);
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    AppMethodBeat.i(28050);
    ae.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox getBaseDBFactories at: " + System.currentTimeMillis());
    AppMethodBeat.o(28050);
    return null;
  }
  
  public final void h(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(28060);
    Updater.h(paramString1, paramInt, paramString2, paramString3);
    AppMethodBeat.o(28060);
  }
  
  public final void oH(boolean paramBoolean)
  {
    yyz = true;
    yyA = paramBoolean;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(28052);
    ae.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountPostReset at: " + System.currentTimeMillis());
    AppMethodBeat.o(28052);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(28054);
    ae.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountRelease at: " + System.currentTimeMillis());
    AppMethodBeat.o(28054);
  }
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(28053);
    ae.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onSdcardMount at: " + System.currentTimeMillis());
    AppMethodBeat.o(28053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sandbox.SubCoreSandBox
 * JD-Core Version:    0.7.0.1
 */