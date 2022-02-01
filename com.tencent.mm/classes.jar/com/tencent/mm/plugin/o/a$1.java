package com.tencent.mm.plugin.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bf;

final class a$1
  implements Runnable
{
  a$1(a parama, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(212682);
    k.aeJ(this.zEK);
    if (k.fQy() != null) {
      h.CyF.a(17162, new Object[] { Integer.valueOf(this.zEL), k.fQy().KEG, k.fQy().KEF, k.fQy().KEH });
    }
    AppMethodBeat.o(212682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.o.a.1
 * JD-Core Version:    0.7.0.1
 */