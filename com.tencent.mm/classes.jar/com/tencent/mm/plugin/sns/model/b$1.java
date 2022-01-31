package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import java.util.Set;

final class b$1
  implements Runnable
{
  b$1(b paramb, b.b paramb1) {}
  
  public final void run()
  {
    AppMethodBeat.i(36099);
    b localb = this.rdk;
    b.b localb1 = this.rdj;
    localb.bLQ.add(localb1);
    int i = b.rcV + 1;
    b.rcV = i;
    if (i <= 1)
    {
      g.RM();
      g.RK().eHt.a(208, localb);
    }
    AppMethodBeat.o(36099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b.1
 * JD-Core Version:    0.7.0.1
 */