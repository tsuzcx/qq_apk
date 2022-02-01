package com.tencent.mm.plugin_support;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin_support.b.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PluginSupportProcess
  extends f
  implements com.tencent.mm.plugin_support.a.a
{
  private final long QRl;
  private Handler mHandler;
  private Runnable mRunnable;
  private List<com.tencent.mm.plugin_support.b.a> vjj;
  
  PluginSupportProcess()
  {
    AppMethodBeat.i(246423);
    this.QRl = 300000L;
    this.vjj = new ArrayList();
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(246439);
        if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG) && (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtz, 0) == 0))
        {
          AppMethodBeat.o(246439);
          return;
        }
        boolean bool1 = PluginSupportProcess.access$000(PluginSupportProcess.this);
        Log.i("PluginSupportProcess", "needKill:".concat(String.valueOf(bool1)));
        if (bool1)
        {
          boolean bool2 = PluginSupportProcess.access$100(PluginSupportProcess.this);
          Log.i("PluginSupportProcess", "hasRunningActivity:".concat(String.valueOf(bool1)));
          if (!bool2)
          {
            PluginSupportProcess.access$200(PluginSupportProcess.this);
            AppMethodBeat.o(246439);
            return;
          }
        }
        PluginSupportProcess.this.mHandler.postDelayed(PluginSupportProcess.this.mRunnable, 300000L);
        AppMethodBeat.o(246439);
      }
    };
    AppMethodBeat.o(246423);
  }
  
  private boolean hasRunningActivity()
  {
    AppMethodBeat.i(246428);
    List localList = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getRunningTasks(1);
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(246428);
      return false;
    }
    AppMethodBeat.o(246428);
    return true;
  }
  
  private boolean isNeadToKillself()
  {
    AppMethodBeat.i(246431);
    if (this.vjj != null)
    {
      Iterator localIterator = this.vjj.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin_support.b.a locala = (com.tencent.mm.plugin_support.b.a)localIterator.next();
        if ((locala != null) && (locala.isBusy()))
        {
          AppMethodBeat.o(246431);
          return false;
        }
      }
    }
    AppMethodBeat.o(246431);
    return true;
  }
  
  private void killSupport()
  {
    AppMethodBeat.i(246429);
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin_support/PluginSupportProcess", "killSupport", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin_support/PluginSupportProcess", "killSupport", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(246429);
  }
  
  public void configure(g paramg) {}
  
  public void dependency()
  {
    AppMethodBeat.i(246425);
    dependsOnRoot();
    AppMethodBeat.o(246425);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(246427);
    if (!MMApplicationContext.isSupportProcess())
    {
      Log.e("PluginSupportProcess", "no support!");
      AppMethodBeat.o(246427);
      return;
    }
    this.vjj.add(new d());
    this.vjj.add(new com.tencent.mm.plugin_support.b.b());
    this.vjj.add(new com.tencent.mm.plugin_support.b.c());
    this.mHandler = new Handler(Looper.getMainLooper());
    this.mHandler.postDelayed(this.mRunnable, 300000L);
    AppMethodBeat.o(246427);
  }
  
  public void installed()
  {
    AppMethodBeat.i(246424);
    alias(com.tencent.mm.plugin_support.a.a.class);
    AppMethodBeat.o(246424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin_support.PluginSupportProcess
 * JD-Core Version:    0.7.0.1
 */