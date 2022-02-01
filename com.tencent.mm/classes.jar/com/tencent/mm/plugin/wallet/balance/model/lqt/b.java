package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.protocal.protobuf.xq;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends c<xq>
{
  public b(String paramString)
  {
    AppMethodBeat.i(68399);
    xp localxp = new xp();
    localxp.ErF = paramString;
    localxp.time_stamp = ((int)System.currentTimeMillis());
    localxp.AYl = ae.eon();
    paramString = new b.a();
    paramString.hvt = localxp;
    paramString.hvu = new xq();
    paramString.funcId = 2512;
    paramString.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/closeautolqtolqt";
    paramString.reqCmdId = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.aAz();
    ac.d("MicroMsg.CgiLqtAutoChargeClose", "close ");
    AppMethodBeat.o(68399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.b
 * JD-Core Version:    0.7.0.1
 */