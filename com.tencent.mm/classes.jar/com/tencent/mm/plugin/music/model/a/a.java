package com.tencent.mm.plugin.music.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.cache.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class a
  implements b
{
  public final void etC()
  {
    AppMethodBeat.i(258339);
    euF();
    AppMethodBeat.o(258339);
  }
  
  public final void euF()
  {
    AppMethodBeat.i(63039);
    long l1 = ((Long)g.aAh().azQ().get(ar.a.Obi, Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < duR.longValue())
    {
      Log.e("MicroMsg.PieceCacheCleanController", "don't scanMusic because the time is in one day");
      AppMethodBeat.o(63039);
      return;
    }
    g.aAh().azQ().set(ar.a.Obi, Long.valueOf(l2));
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63037);
        a.euG();
        AppMethodBeat.o(63037);
      }
    }, "ScanMusicThread", 1);
    AppMethodBeat.o(63039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a
 * JD-Core Version:    0.7.0.1
 */