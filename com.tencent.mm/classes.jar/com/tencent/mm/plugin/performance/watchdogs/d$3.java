package com.tencent.mm.plugin.performance.watchdogs;

import android.widget.Toast;
import com.tencent.matrix.memorydump.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.threadpool.i;
import java.util.concurrent.atomic.AtomicBoolean;

final class d$3
  implements a.a
{
  d$3(u paramu, String paramString, long paramLong) {}
  
  public final void dC(boolean paramBoolean)
  {
    AppMethodBeat.i(301022);
    if (paramBoolean)
    {
      Log.i("MicroMsg.MemoryWatchDog", "dump heap success");
      com.tencent.mm.plugin.report.service.h.OAn.b(18573, new Object[] { ah.v(this.MOn.jKT()), this.MOo, Integer.valueOf(0), Integer.valueOf(32), Long.valueOf(this.MOp), BuildInfo.BUILD_TAG, BuildInfo.REV });
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(300987);
          Toast.makeText(MMApplicationContext.getContext(), "Java Heap reaches 350M. Please contact @aurorani. HPROF file is in {external_cache}/cache/hprofs", 1).show();
          AppMethodBeat.o(300987);
        }
      });
    }
    for (;;)
    {
      d.gzy().set(false);
      AppMethodBeat.o(301022);
      return;
      Log.e("MicroMsg.MemoryWatchDog", "dump heap failed");
      com.tencent.mm.plugin.report.service.h.OAn.b(18573, new Object[] { "[dump failed]", this.MOo, Integer.valueOf(2), Integer.valueOf(32), Long.valueOf(this.MOp), BuildInfo.BUILD_TAG, BuildInfo.REV });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.d.3
 * JD-Core Version:    0.7.0.1
 */