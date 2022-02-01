package com.tencent.mm.wlogcat;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
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
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void dependency()
  {
    AppMethodBeat.i(224049);
    dependsOnRoot();
    AppMethodBeat.o(224049);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(224050);
    paramg = c.hil();
    if (Log.getImpl().getClass() != Xlog.class) {
      Log.e("MicroMsg.StartupLogcatCatcher", "impl is not xlog!");
    }
    int i;
    for (;;)
    {
      paramg = com.tencent.mm.wlogcat.b.b.hii();
      if (Log.getImpl().getClass() == Xlog.class) {
        break;
      }
      Log.e("MicroMsg.LogcatCatcher", "impl is not xlog!");
      AppMethodBeat.o(224050);
      return;
      Log.i("MicroMsg.StartupLogcatCatcher", "Log.consoleLogOpen:" + XLogSetup.isLogcatOpen);
      if (!XLogSetup.isLogcatOpen.booleanValue())
      {
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rNP, 0);
        Log.i("MicroMsg.StartupLogcatCatcher", "is need work :".concat(String.valueOf(i)));
        if (i != 0) {
          h.RTc.b(paramg.RwD, "LogcatCatcher");
        }
      }
    }
    Log.i("MicroMsg.LogcatCatcher", "Log.consoleLogOpen:" + XLogSetup.isLogcatOpen);
    if (!XLogSetup.isLogcatOpen.booleanValue())
    {
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rNO, 0);
      Log.i("MicroMsg.LogcatCatcher", "work clicfg_logcat:%d", new Object[] { Integer.valueOf(i) });
      if ((i == 1) && (!d.KyS))
      {
        int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rNR, 0);
        if ((!d.KyR) && (j == 0))
        {
          Log.i("MicroMsg.LogcatCatcher", "id alpha false");
          AppMethodBeat.o(224050);
          return;
        }
        Log.i("MicroMsg.LogcatCatcher", "is need work :".concat(String.valueOf(i)));
        if (i != 0)
        {
          paramg.RwM.start();
          paramg.RwN = new Handler(paramg.RwM.getLooper());
          paramg.RwN.post(new b.3(paramg));
        }
      }
    }
    AppMethodBeat.o(224050);
  }
  
  public void installed()
  {
    AppMethodBeat.i(224048);
    alias(a.class);
    AppMethodBeat.o(224048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wlogcat.PluginLogcat
 * JD-Core Version:    0.7.0.1
 */