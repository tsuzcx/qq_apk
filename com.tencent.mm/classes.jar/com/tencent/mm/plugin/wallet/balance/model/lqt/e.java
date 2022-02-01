package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.cep;

public final class e
  extends c<cep>
{
  public e()
  {
    AppMethodBeat.i(68402);
    ceo localceo = new ceo();
    localceo.time_stamp = ((int)System.currentTimeMillis());
    localceo.zFY = ae.dYR();
    b.a locala = new b.a();
    locala.gUU = localceo;
    locala.gUV = new cep();
    locala.funcId = 2668;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/qrysetting";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(68402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.e
 * JD-Core Version:    0.7.0.1
 */