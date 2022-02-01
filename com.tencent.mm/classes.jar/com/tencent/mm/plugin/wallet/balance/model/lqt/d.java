package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbg;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends c<cbg>
{
  public d(String paramString)
  {
    AppMethodBeat.i(68401);
    cbf localcbf = new cbf();
    localcbf.time_stamp = ((int)System.currentTimeMillis());
    localcbf.ErF = paramString;
    localcbf.AYl = ae.eon();
    b.a locala = new b.a();
    locala.hvt = localcbf;
    locala.hvu = new cbg();
    locala.funcId = 2896;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/openlqautotrans";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ac.d("MicroMsg.CgiLqtAutoChargeOpen", "pwd: %s", new Object[] { paramString });
    AppMethodBeat.o(68401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.d
 * JD-Core Version:    0.7.0.1
 */