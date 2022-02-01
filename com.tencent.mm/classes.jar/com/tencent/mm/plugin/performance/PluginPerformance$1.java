package com.tencent.mm.plugin.performance;

import android.graphics.BitmapFactory.Options;
import android.util.Log;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;

final class PluginPerformance$1
  implements a
{
  PluginPerformance$1(PluginPerformance paramPluginPerformance, g paramg) {}
  
  public final void a(final BitmapFactory.Options paramOptions, final int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(124898);
    ac.e("MicroMsg.PluginPerformance", "WARNING: bitmap decode oversize \n(%s B/%s B), [w:%s, h:%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(20971520L), Integer.valueOf(paramOptions.outWidth), Integer.valueOf(paramOptions.outHeight) });
    Throwable localThrowable = new Throwable();
    ac.printErrStackTrace("MicroMsg.PluginPerformance", localThrowable, "bitmap stacktrace", new Object[0]);
    if (paramInt > 52428800) {
      com.tencent.mm.plugin.report.service.h.wUl.f(18613, new Object[] { this.cIA.mProcessName, Log.getStackTraceString(localThrowable).replace('\n', ';').replace("\t", "") });
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.wUl.dB(1230, i);
      if (bt.eWo()) {
        com.tencent.e.h.JZN.aQ(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(124897);
            Toast.makeText(ai.getContext(), String.format("WARNING: large bitmap decode \n(%s B), [w:%s, h:%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramOptions.outWidth), Integer.valueOf(paramOptions.outHeight) }), 1).show();
            AppMethodBeat.o(124897);
          }
        });
      }
      AppMethodBeat.o(124898);
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
 * Qualified Name:     com.tencent.mm.plugin.performance.PluginPerformance.1
 * JD-Core Version:    0.7.0.1
 */