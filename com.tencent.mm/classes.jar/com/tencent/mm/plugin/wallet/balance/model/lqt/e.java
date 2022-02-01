package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.cjs;

public final class e
  extends c<cjs>
{
  public e()
  {
    AppMethodBeat.i(68402);
    cjr localcjr = new cjr();
    localcjr.time_stamp = ((int)System.currentTimeMillis());
    localcjr.AYl = ae.eon();
    b.a locala = new b.a();
    locala.hvt = localcjr;
    locala.hvu = new cjs();
    locala.funcId = 2668;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/qrysetting";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(68402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.e
 * JD-Core Version:    0.7.0.1
 */