package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.cor;
import com.tencent.mm.protocal.protobuf.cos;

public final class e
  extends a<cos>
{
  public e()
  {
    AppMethodBeat.i(68402);
    cor localcor = new cor();
    localcor.time_stamp = ((int)System.currentTimeMillis());
    localcor.Cyu = ae.eCl();
    b.a locala = new b.a();
    locala.hNM = localcor;
    locala.hNN = new cos();
    locala.funcId = 2668;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/qrysetting";
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    AppMethodBeat.o(68402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.e
 * JD-Core Version:    0.7.0.1
 */