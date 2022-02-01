package com.tencent.mm.plugin.music.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.music.cache.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class a
  implements b
{
  public final void fdP()
  {
    AppMethodBeat.i(292974);
    feY();
    AppMethodBeat.o(292974);
  }
  
  public final void feY()
  {
    AppMethodBeat.i(63039);
    long l1 = ((Long)h.aHG().aHp().get(ar.a.Vpl, Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < fnz.longValue())
    {
      Log.e("MicroMsg.PieceCacheCleanController", "don't scanMusic because the time is in one day");
      AppMethodBeat.o(63039);
      return;
    }
    h.aHG().aHp().set(ar.a.Vpl, Long.valueOf(l2));
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63037);
        a.feZ();
        AppMethodBeat.o(63037);
      }
    }, "ScanMusicThread", 1);
    AppMethodBeat.o(63039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a
 * JD-Core Version:    0.7.0.1
 */