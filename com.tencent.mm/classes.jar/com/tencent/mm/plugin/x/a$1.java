package com.tencent.mm.plugin.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bi;

final class a$1
  implements Runnable
{
  a$1(a parama, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(260313);
    k.asj(this.Lfg);
    if (k.iis() != null) {
      h.OAn.b(17162, new Object[] { Integer.valueOf(this.Lfh), k.iis().YCM, k.iis().YCL, k.iis().YCN });
    }
    AppMethodBeat.o(260313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.x.a.1
 * JD-Core Version:    0.7.0.1
 */