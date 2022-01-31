package com.tencent.mm.plugin.product.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.nk.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class f$2
  implements Runnable
{
  f$2(f paramf, nk paramnk) {}
  
  public final void run()
  {
    AppMethodBeat.i(44057);
    ab.d("MicroMsg.MallProductUI", "JSOAUTH errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(this.pvW.cDN.errCode), Boolean.valueOf(this.pvW.cDN.cDO) });
    if (this.pvW.cDN.errCode == 0)
    {
      c localc = f.c(this.pvV);
      nk localnk = this.pvW;
      cx localcx = new cx();
      localcx.jJA = localnk.cDN.userName;
      localcx.wpj = localnk.cDN.cDQ;
      localcx.wpk = localnk.cDN.cDR;
      localcx.gwQ = localnk.cDN.cDS;
      localcx.gwR = localnk.cDN.cDT;
      localcx.gwY = localnk.cDN.cDU;
      localcx.nqY = localnk.cDN.cDV;
      if ((!bo.isNullOrNil(localcx.jJA)) && (!bo.isNullOrNil(localcx.wpj))) {
        localc.puc = localcx;
      }
    }
    f.d(this.pvV);
    AppMethodBeat.o(44057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.f.2
 * JD-Core Version:    0.7.0.1
 */