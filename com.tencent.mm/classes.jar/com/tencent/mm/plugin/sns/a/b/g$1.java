package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.a.b.a.a;
import java.util.Map;

final class g$1
  implements Runnable
{
  g$1(g paramg, long paramLong, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(35716);
    if (this.qZr.li(this.qZp))
    {
      g localg = this.qZr;
      long l = this.qZp;
      boolean bool = this.qZq;
      h localh;
      if (bool) {
        if (localg.qZg.containsKey(Long.valueOf(l))) {
          localh = (h)localg.qZg.get(Long.valueOf(l));
        }
      }
      for (;;)
      {
        localh.qZB = 1;
        localh.qZJ.raI += 1;
        if (!bool) {
          break;
        }
        localg.qZg.put(Long.valueOf(l), localh);
        AppMethodBeat.o(35716);
        return;
        localh = new h("timeline");
        continue;
        if (localg.qZf.containsKey(Long.valueOf(l))) {
          localh = (h)localg.qZf.get(Long.valueOf(l));
        } else {
          localh = new h("timeline");
        }
      }
      localg.qZf.put(Long.valueOf(l), localh);
    }
    AppMethodBeat.o(35716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.g.1
 * JD-Core Version:    0.7.0.1
 */