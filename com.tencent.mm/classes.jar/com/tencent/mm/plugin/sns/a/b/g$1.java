package com.tencent.mm.plugin.sns.a.b;

import com.tencent.mm.plugin.sns.a.b.a.a;
import java.util.Map;

final class g$1
  implements Runnable
{
  g$1(g paramg, long paramLong, boolean paramBoolean) {}
  
  public final void run()
  {
    g localg;
    long l;
    boolean bool;
    h localh;
    if (this.olj.fF(this.olh))
    {
      localg = this.olj;
      l = this.olh;
      bool = this.oli;
      if (!bool) {
        break label130;
      }
      if (!localg.okX.containsKey(Long.valueOf(l))) {
        break label116;
      }
      localh = (h)localg.okX.get(Long.valueOf(l));
    }
    for (;;)
    {
      localh.olp = 1;
      localh.olx.omu += 1;
      if (!bool) {
        break;
      }
      localg.okX.put(Long.valueOf(l), localh);
      return;
      label116:
      localh = new h("timeline");
      continue;
      label130:
      if (localg.okW.containsKey(Long.valueOf(l))) {
        localh = (h)localg.okW.get(Long.valueOf(l));
      } else {
        localh = new h("timeline");
      }
    }
    localg.okW.put(Long.valueOf(l), localh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.g.1
 * JD-Core Version:    0.7.0.1
 */