package com.tencent.mm.plugin.performance;

import android.graphics.BitmapFactory.Options;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

final class PluginPerformance$3
  implements a
{
  PluginPerformance$3(PluginPerformance paramPluginPerformance, g paramg) {}
  
  public final void a(final BitmapFactory.Options paramOptions, final int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(202078);
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.PluginPerformance", "WARNING: bitmap decode oversize \n(%s B/%s B), [w:%s, h:%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(20971520L), Integer.valueOf(paramOptions.outWidth), Integer.valueOf(paramOptions.outHeight) });
    Throwable localThrowable = new Throwable();
    com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.PluginPerformance", localThrowable, "bitmap stacktrace", new Object[0]);
    if (paramInt > 52428800) {
      com.tencent.mm.plugin.report.service.h.IzE.a(18613, new Object[] { this.fcw.mProcessName, android.util.Log.getStackTraceString(localThrowable).replace('\n', ';').replace("\t", ""), Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.el(1230, i);
      if (WeChatEnvironment.hasDebugger()) {
        com.tencent.e.h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200571);
            Toast.makeText(MMApplicationContext.getContext(), String.format("WARNING: large bitmap decode \n(%s B), [w:%s, h:%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramOptions.outWidth), Integer.valueOf(paramOptions.outHeight) }), 1).show();
            AppMethodBeat.o(200571);
          }
        });
      }
      AppMethodBeat.o(202078);
      return;
      if (paramInt > 31457280) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.PluginPerformance.3
 * JD-Core Version:    0.7.0.1
 */