package com.tencent.mm.wlogcat;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.e.i;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wlogcat.a.a;
import com.tencent.mm.wlogcat.b.b.3;
import com.tencent.mm.wlogcat.b.c;
import com.tencent.mm.xlog.app.XLogSetup;

public class PluginLogcat
  extends f
  implements a
{
  public void configure(g paramg) {}
  
  public void dependency()
  {
    AppMethodBeat.i(189357);
    dependsOnRoot();
    AppMethodBeat.o(189357);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(189360);
    paramg = c.ijM();
    if (Log.getImpl().getClass() != Xlog.class) {
      Log.e("MicroMsg.StartupLogcatCatcher", "impl is not xlog!");
    }
    int i;
    for (;;)
    {
      paramg = com.tencent.mm.wlogcat.b.b.ijJ();
      if (Log.getImpl().getClass() == Xlog.class) {
        break;
      }
      Log.e("MicroMsg.LogcatCatcher", "impl is not xlog!");
      AppMethodBeat.o(189360);
      return;
      Log.i("MicroMsg.StartupLogcatCatcher", "Log.consoleLogOpen:" + XLogSetup.isLogcatOpen);
      if (!XLogSetup.isLogcatOpen.booleanValue())
      {
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtJ, 0);
        Log.i("MicroMsg.StartupLogcatCatcher", "is need work :".concat(String.valueOf(i)));
        if (i != 0) {
          com.tencent.e.h.ZvG.d(paramg.YYe, "LogcatCatcher");
        }
      }
    }
    Log.i("MicroMsg.LogcatCatcher", "Log.consoleLogOpen:" + XLogSetup.isLogcatOpen);
    if (!XLogSetup.isLogcatOpen.booleanValue())
    {
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtI, 0);
      Log.i("MicroMsg.LogcatCatcher", "work clicfg_logcat:%d", new Object[] { Integer.valueOf(i) });
      if ((i == 1) && (!d.RAH))
      {
        int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vtL, 0);
        if ((!d.RAG) && (j == 0))
        {
          Log.i("MicroMsg.LogcatCatcher", "id alpha false");
          AppMethodBeat.o(189360);
          return;
        }
        Log.i("MicroMsg.LogcatCatcher", "is need work :".concat(String.valueOf(i)));
        if (i != 0)
        {
          paramg.YYn.start();
          paramg.YYo = new Handler(paramg.YYn.getLooper());
          paramg.YYo.post(new b.3(paramg));
        }
      }
    }
    AppMethodBeat.o(189360);
  }
  
  public void installed()
  {
    AppMethodBeat.i(189354);
    alias(a.class);
    AppMethodBeat.o(189354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wlogcat.PluginLogcat
 * JD-Core Version:    0.7.0.1
 */