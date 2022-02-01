package com.tencent.mm.plugin.music.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.music.cache.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class a
  implements b
{
  public final void gmQ()
  {
    AppMethodBeat.i(369746);
    gof();
    AppMethodBeat.o(369746);
  }
  
  public final void gof()
  {
    AppMethodBeat.i(63039);
    long l1 = ((Long)h.baE().ban().get(at.a.acQN, Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < hrK.longValue())
    {
      Log.e("MicroMsg.PieceCacheCleanController", "don't scanMusic because the time is in one day");
      AppMethodBeat.o(63039);
      return;
    }
    h.baE().ban().set(at.a.acQN, Long.valueOf(l2));
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63037);
        a.gog();
        AppMethodBeat.o(63037);
      }
    }, "ScanMusicThread", 1);
    AppMethodBeat.o(63039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a
 * JD-Core Version:    0.7.0.1
 */