package com.tencent.mm.plugin.performance;

import android.graphics.BitmapFactory.Options;
import android.util.Log;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bv;

final class PluginPerformance$2
  implements a
{
  PluginPerformance$2(PluginPerformance paramPluginPerformance, com.tencent.mm.kernel.b.g paramg) {}
  
  public final void a(final BitmapFactory.Options paramOptions, final int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(215404);
    ae.e("MicroMsg.PluginPerformance", "WARNING: bitmap decode oversize \n(%s B/%s B), [w:%s, h:%s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(20971520L), Integer.valueOf(paramOptions.outWidth), Integer.valueOf(paramOptions.outHeight) });
    Throwable localThrowable = new Throwable();
    ae.printErrStackTrace("MicroMsg.PluginPerformance", localThrowable, "bitmap stacktrace", new Object[0]);
    if (paramInt > 52428800) {
      com.tencent.mm.plugin.report.service.g.yxI.f(18613, new Object[] { this.cUt.mProcessName, Log.getStackTraceString(localThrowable).replace('\n', ';').replace("\t", "") });
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.dD(1230, i);
      if (bv.fpT()) {
        h.MqF.aM(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215403);
            Toast.makeText(ak.getContext(), String.format("WARNING: large bitmap decode \n(%s B), [w:%s, h:%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramOptions.outWidth), Integer.valueOf(paramOptions.outHeight) }), 1).show();
            AppMethodBeat.o(215403);
          }
        });
      }
      AppMethodBeat.o(215404);
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
 * Qualified Name:     com.tencent.mm.plugin.performance.PluginPerformance.2
 * JD-Core Version:    0.7.0.1
 */