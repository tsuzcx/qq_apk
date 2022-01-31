package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

final class g$3
  implements Runnable
{
  g$3(g paramg, long paramLong1, long paramLong2) {}
  
  public final void run()
  {
    AppMethodBeat.i(35718);
    if (this.qZr.li(this.qZp))
    {
      g localg = this.qZr;
      long l = this.qZt;
      if (!localg.qZe.contains(Long.valueOf(l))) {
        localg.qZe.add(Long.valueOf(l));
      }
    }
    AppMethodBeat.o(35718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.g.3
 * JD-Core Version:    0.7.0.1
 */