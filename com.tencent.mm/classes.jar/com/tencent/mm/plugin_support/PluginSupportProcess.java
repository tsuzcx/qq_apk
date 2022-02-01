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
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin_support.b.b;
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
  private List<com.tencent.mm.plugin_support.b.a> BI;
  private final long XMR;
  private Handler mHandler;
  private Runnable mRunnable;
  
  PluginSupportProcess()
  {
    AppMethodBeat.i(231237);
    this.XMR = 300000L;
    this.BI = new ArrayList();
    this.mRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231238);
        if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG) && (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGc, 0) == 0))
        {
          AppMethodBeat.o(231238);
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
            AppMethodBeat.o(231238);
            return;
          }
        }
        PluginSupportProcess.this.mHandler.postDelayed(PluginSupportProcess.this.mRunnable, 300000L);
        AppMethodBeat.o(231238);
      }
    };
    AppMethodBeat.o(231237);
  }
  
  private boolean hasRunningActivity()
  {
    AppMethodBeat.i(231239);
    List localList = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getRunningTasks(1);
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(231239);
      return false;
    }
    AppMethodBeat.o(231239);
    return true;
  }
  
  private boolean isNeadToKillself()
  {
    AppMethodBeat.i(231245);
    if (this.BI != null)
    {
      Iterator localIterator = this.BI.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin_support.b.a locala = (com.tencent.mm.plugin_support.b.a)localIterator.next();
        if ((locala != null) && (locala.isBusy()))
        {
          AppMethodBeat.o(231245);
          return false;
        }
      }
    }
    AppMethodBeat.o(231245);
    return true;
  }
  
  private void killSupport()
  {
    AppMethodBeat.i(231242);
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin_support/PluginSupportProcess", "killSupport", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin_support/PluginSupportProcess", "killSupport", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(231242);
  }
  
  public void configure(g paramg) {}
  
  public void dependency()
  {
    AppMethodBeat.i(231253);
    dependsOnRoot();
    AppMethodBeat.o(231253);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(231259);
    if (!MMApplicationContext.isSupportProcess())
    {
      Log.e("PluginSupportProcess", "no support!");
      AppMethodBeat.o(231259);
      return;
    }
    this.BI.add(new d());
    this.BI.add(new b());
    this.BI.add(new com.tencent.mm.plugin_support.b.c());
    this.mHandler = new Handler(Looper.getMainLooper());
    this.mHandler.postDelayed(this.mRunnable, 300000L);
    AppMethodBeat.o(231259);
  }
  
  public void installed()
  {
    AppMethodBeat.i(231252);
    alias(com.tencent.mm.plugin_support.a.a.class);
    AppMethodBeat.o(231252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin_support.PluginSupportProcess
 * JD-Core Version:    0.7.0.1
 */