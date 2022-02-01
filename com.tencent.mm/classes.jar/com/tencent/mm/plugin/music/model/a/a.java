package com.tencent.mm.plugin.music.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class a
  implements com.tencent.mm.plugin.music.cache.b
{
  public final void dst()
  {
    AppMethodBeat.i(221211);
    dti();
    AppMethodBeat.o(221211);
  }
  
  public final void dti()
  {
    AppMethodBeat.i(63039);
    long l1 = ((Long)g.ajC().ajl().get(al.a.Iyx, Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < dcT.longValue())
    {
      ad.e("MicroMsg.PieceCacheCleanController", "don't scanMusic because the time is in one day");
      AppMethodBeat.o(63039);
      return;
    }
    g.ajC().ajl().set(al.a.Iyx, Long.valueOf(l2));
    com.tencent.mm.sdk.g.b.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63037);
        a.dtj();
        AppMethodBeat.o(63037);
      }
    }, "ScanMusicThread");
    AppMethodBeat.o(63039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a
 * JD-Core Version:    0.7.0.1
 */