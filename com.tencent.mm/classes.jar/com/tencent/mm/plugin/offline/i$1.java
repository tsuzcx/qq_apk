package com.tencent.mm.plugin.offline;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class i$1
  implements am.a
{
  i$1(i parami) {}
  
  public final boolean tC()
  {
    if (!g.DK())
    {
      localam = this.mKq.mKp;
      l = this.mKq.mKo;
      localam.S(l, l);
      return false;
    }
    this.mKq.dx(5, 5);
    am localam = this.mKq.mKp;
    i locali = this.mKq;
    long l = a.brc();
    if (l <= 0L) {}
    for (l = locali.mKo;; l = 1000L * l)
    {
      localam.S(l, l);
      return false;
      y.i("MicroMsg.OfflineTokensMgr", "OfflineTokensMgr updateInterval:" + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.i.1
 * JD-Core Version:    0.7.0.1
 */