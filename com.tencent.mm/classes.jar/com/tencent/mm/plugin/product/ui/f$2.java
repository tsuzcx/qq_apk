package com.tencent.mm.plugin.product.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.g.a.pr.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class f$2
  implements Runnable
{
  f$2(f paramf, pr parampr) {}
  
  public final void run()
  {
    AppMethodBeat.i(66963);
    ae.d("MicroMsg.MallProductUI", "JSOAUTH errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(this.xds.dEZ.errCode), Boolean.valueOf(this.xds.dEZ.dFa) });
    if (this.xds.dEZ.errCode == 0)
    {
      c localc = f.c(this.xdr);
      pr localpr = this.xds;
      di localdi = new di();
      localdi.nIJ = localpr.dEZ.userName;
      localdi.FNZ = localpr.dEZ.dFc;
      localdi.FOa = localpr.dEZ.dFd;
      localdi.jfW = localpr.dEZ.dFe;
      localdi.jfX = localpr.dEZ.dFf;
      localdi.jge = localpr.dEZ.dFg;
      localdi.urL = localpr.dEZ.dFh;
      if ((!bu.isNullOrNil(localdi.nIJ)) && (!bu.isNullOrNil(localdi.FNZ))) {
        localc.xbB = localdi;
      }
    }
    f.d(this.xdr);
    AppMethodBeat.o(66963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.f.2
 * JD-Core Version:    0.7.0.1
 */