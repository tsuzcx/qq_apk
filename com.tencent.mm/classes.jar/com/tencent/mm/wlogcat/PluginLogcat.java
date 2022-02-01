package com.tencent.mm.wlogcat;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wlogcat.a.a;
import com.tencent.mm.wlogcat.b.b;
import com.tencent.mm.wlogcat.b.b.3;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.threadpool.i;

public class PluginLogcat
  extends f
  implements a
{
  public void configure(g paramg) {}
  
  public void dependency()
  {
    AppMethodBeat.i(231315);
    dependsOnRoot();
    AppMethodBeat.o(231315);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(231326);
    paramg = com.tencent.mm.wlogcat.b.c.jPU();
    if (Log.getImpl().getClass() != Xlog.class) {
      Log.e("MicroMsg.StartupLogcatCatcher", "impl is not xlog!");
    }
    int i;
    for (;;)
    {
      paramg = b.jPR();
      if (Log.getImpl().getClass() == Xlog.class) {
        break;
      }
      Log.e("MicroMsg.LogcatCatcher", "impl is not xlog!");
      AppMethodBeat.o(231326);
      return;
      Log.i("MicroMsg.StartupLogcatCatcher", "Log.consoleLogOpen:" + XLogSetup.isLogcatOpen);
      if (!XLogSetup.isLogcatOpen.booleanValue())
      {
        i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGn, 0);
        Log.i("MicroMsg.StartupLogcatCatcher", "is need work :".concat(String.valueOf(i)));
        if (i != 0) {
          com.tencent.threadpool.h.ahAA.g(paramg.agWp, "LogcatCatcher");
        }
      }
    }
    Log.i("MicroMsg.LogcatCatcher", "Log.consoleLogOpen:" + XLogSetup.isLogcatOpen);
    if (!XLogSetup.isLogcatOpen.booleanValue())
    {
      i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGm, 0);
      Log.i("MicroMsg.LogcatCatcher", "work clicfg_logcat:%d", new Object[] { Integer.valueOf(i) });
      if ((i == 1) && (!d.Yxl))
      {
        int j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yGp, 0);
        if ((!d.Yxk) && (j == 0))
        {
          Log.i("MicroMsg.LogcatCatcher", "id alpha false");
          AppMethodBeat.o(231326);
          return;
        }
        Log.i("MicroMsg.LogcatCatcher", "is need work :".concat(String.valueOf(i)));
        if (i != 0)
        {
          paramg.agWy.start();
          paramg.agWz = new Handler(paramg.agWy.getLooper());
          paramg.agWz.post(new b.3(paramg));
        }
      }
    }
    AppMethodBeat.o(231326);
  }
  
  public void installed()
  {
    AppMethodBeat.i(231313);
    alias(a.class);
    AppMethodBeat.o(231313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wlogcat.PluginLogcat
 * JD-Core Version:    0.7.0.1
 */