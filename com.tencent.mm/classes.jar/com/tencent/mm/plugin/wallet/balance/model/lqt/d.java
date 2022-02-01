package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.protocal.protobuf.cgr;

public final class d
  extends a<cgr>
{
  public d(String paramString)
  {
    AppMethodBeat.i(68401);
    cgq localcgq = new cgq();
    localcgq.time_stamp = ((int)System.currentTimeMillis());
    localcgq.Gro = paramString;
    localcgq.CPZ = ae.eFT();
    b.a locala = new b.a();
    locala.hQF = localcgq;
    locala.hQG = new cgr();
    locala.funcId = 2896;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/openlqautotrans";
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.CgiLqtAutoChargeOpen", "pwd: %s", new Object[] { paramString });
    AppMethodBeat.o(68401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.d
 * JD-Core Version:    0.7.0.1
 */