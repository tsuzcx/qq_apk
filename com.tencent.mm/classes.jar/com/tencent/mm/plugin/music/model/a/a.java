package com.tencent.mm.plugin.music.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.cache.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a
  implements b
{
  public final void bVP()
  {
    AppMethodBeat.i(104908);
    long l1 = ((Long)g.RL().Ru().get(ac.a.yFH, Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < cfj.longValue())
    {
      ab.e("MicroMsg.PieceCacheCleanController", "don't scanMusic because the time is in one day");
      AppMethodBeat.o(104908);
      return;
    }
    g.RL().Ru().set(ac.a.yFH, Long.valueOf(l2));
    d.f(new a.1(this), "ScanMusicThread");
    AppMethodBeat.o(104908);
  }
  
  public final void bVa()
  {
    AppMethodBeat.i(156833);
    bVP();
    AppMethodBeat.o(156833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a
 * JD-Core Version:    0.7.0.1
 */