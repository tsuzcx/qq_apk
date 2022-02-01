package com.tencent.mm.plugin.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bd;

final class a$1
  implements Runnable
{
  a$1(a parama, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(231418);
    k.amw(this.FjJ);
    if (k.gJe() != null) {
      h.IzE.a(17162, new Object[] { Integer.valueOf(this.FjK), k.gJe().RFY, k.gJe().RFX, k.gJe().RFZ });
    }
    AppMethodBeat.o(231418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.x.a.1
 * JD-Core Version:    0.7.0.1
 */