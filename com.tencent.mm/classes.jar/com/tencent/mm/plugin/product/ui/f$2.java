package com.tencent.mm.plugin.product.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pq;
import com.tencent.mm.g.a.pq.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class f$2
  implements Runnable
{
  f$2(f paramf, pq parampq) {}
  
  public final void run()
  {
    AppMethodBeat.i(66963);
    ad.d("MicroMsg.MallProductUI", "JSOAUTH errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(this.wNE.dDU.errCode), Boolean.valueOf(this.wNE.dDU.dDV) });
    if (this.wNE.dDU.errCode == 0)
    {
      c localc = f.c(this.wND);
      pq localpq = this.wNE;
      di localdi = new di();
      localdi.nDo = localpq.dDU.userName;
      localdi.FvB = localpq.dDU.dDX;
      localdi.FvC = localpq.dDU.dDY;
      localdi.jdd = localpq.dDU.dDZ;
      localdi.jde = localpq.dDU.dEa;
      localdi.jdl = localpq.dDU.dEb;
      localdi.ugo = localpq.dDU.dEc;
      if ((!bt.isNullOrNil(localdi.nDo)) && (!bt.isNullOrNil(localdi.FvB))) {
        localc.wLN = localdi;
      }
    }
    f.d(this.wND);
    AppMethodBeat.o(66963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.f.2
 * JD-Core Version:    0.7.0.1
 */