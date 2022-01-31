package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import java.util.Set;

final class b$2
  implements Runnable
{
  b$2(b paramb, b.b paramb1) {}
  
  public final void run()
  {
    AppMethodBeat.i(36100);
    b localb = this.rdk;
    b.b localb1 = this.rdj;
    localb.bLQ.remove(localb1);
    int i = b.rcV - 1;
    b.rcV = i;
    if (i <= 0)
    {
      g.RM();
      g.RK().eHt.b(208, localb);
    }
    AppMethodBeat.o(36100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b.2
 * JD-Core Version:    0.7.0.1
 */