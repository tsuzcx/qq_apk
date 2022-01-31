package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.a.b.a.a;
import java.util.Map;

final class g$4
  implements Runnable
{
  g$4(g paramg, long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(35719);
    if (this.qZr.li(this.qZp))
    {
      g localg = this.qZr;
      long l1 = this.qZp;
      long l2 = this.eCv;
      boolean bool = this.qZq;
      h localh;
      if (bool) {
        if (localg.qZg.containsKey(Long.valueOf(l1))) {
          localh = (h)localg.qZg.get(Long.valueOf(l1));
        }
      }
      for (;;)
      {
        if (localh.qZJ.raN == 0L) {
          localh.qZJ.raN = l2;
        }
        if (!bool) {
          break;
        }
        localg.qZg.put(Long.valueOf(l1), localh);
        AppMethodBeat.o(35719);
        return;
        localh = new h("timeline");
        continue;
        if (localg.qZf.containsKey(Long.valueOf(l1))) {
          localh = (h)localg.qZf.get(Long.valueOf(l1));
        } else {
          localh = new h("timeline");
        }
      }
      localg.qZf.put(Long.valueOf(l1), localh);
    }
    AppMethodBeat.o(35719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.g.4
 * JD-Core Version:    0.7.0.1
 */