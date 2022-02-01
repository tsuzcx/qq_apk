package com.tencent.mm.wlogcat;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wlogcat.b.a.3;
import com.tencent.mm.xlog.app.XLogSetup;

public class PluginLogcat
  extends f
  implements com.tencent.mm.wlogcat.a.a
{
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void dependency()
  {
    AppMethodBeat.i(218625);
    dependsOnRoot();
    AppMethodBeat.o(218625);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(218626);
    paramg = com.tencent.mm.wlogcat.b.a.fWH();
    if (ae.fon().getClass() != Xlog.class)
    {
      ae.e("MicroMsg.LogcatCatcher", "impl is not xlog!");
      AppMethodBeat.o(218626);
      return;
    }
    ae.i("MicroMsg.LogcatCatcher", "Log.consoleLogOpen:" + XLogSetup.isLogcatOpen);
    if (!XLogSetup.isLogcatOpen.booleanValue())
    {
      int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qwg, 0);
      ae.i("MicroMsg.LogcatCatcher", "is need work :".concat(String.valueOf(i)));
      if (i != 0)
      {
        paramg.LXP.start();
        paramg.LXQ = new Handler(paramg.LXP.getLooper());
        paramg.LXQ.post(new a.3(paramg));
      }
    }
    AppMethodBeat.o(218626);
  }
  
  public void installed()
  {
    AppMethodBeat.i(218624);
    alias(com.tencent.mm.wlogcat.a.a.class);
    AppMethodBeat.o(218624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wlogcat.PluginLogcat
 * JD-Core Version:    0.7.0.1
 */