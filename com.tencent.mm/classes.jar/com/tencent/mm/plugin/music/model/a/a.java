package com.tencent.mm.plugin.music.model.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.cache.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class a
  implements b
{
  public final void bmH()
  {
    long l1 = ((Long)g.DP().Dz().get(ac.a.uvA, Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < gNB.longValue())
    {
      y.e("MicroMsg.PieceCacheCleanController", "don't scanMusic because the time is in one day");
      return;
    }
    g.DP().Dz().c(ac.a.uvA, Long.valueOf(l2));
    com.tencent.mm.sdk.f.e.a(new a.1(this), "ScanMusicThread", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.a.a
 * JD-Core Version:    0.7.0.1
 */