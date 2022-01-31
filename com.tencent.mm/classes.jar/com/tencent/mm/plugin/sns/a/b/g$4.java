package com.tencent.mm.plugin.sns.a.b;

import com.tencent.mm.plugin.sns.a.b.a.a;
import java.util.Map;

final class g$4
  implements Runnable
{
  g$4(g paramg, long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public final void run()
  {
    g localg;
    long l1;
    long l2;
    boolean bool;
    h localh;
    if (this.olj.fF(this.olh))
    {
      localg = this.olj;
      l1 = this.olh;
      l2 = this.dET;
      bool = this.oli;
      if (!bool) {
        break label136;
      }
      if (!localg.okX.containsKey(Long.valueOf(l1))) {
        break label122;
      }
      localh = (h)localg.okX.get(Long.valueOf(l1));
    }
    for (;;)
    {
      if (localh.olx.omz == 0L) {
        localh.olx.omz = l2;
      }
      if (!bool) {
        break;
      }
      localg.okX.put(Long.valueOf(l1), localh);
      return;
      label122:
      localh = new h("timeline");
      continue;
      label136:
      if (localg.okW.containsKey(Long.valueOf(l1))) {
        localh = (h)localg.okW.get(Long.valueOf(l1));
      } else {
        localh = new h("timeline");
      }
    }
    localg.okW.put(Long.valueOf(l1), localh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.g.4
 * JD-Core Version:    0.7.0.1
 */