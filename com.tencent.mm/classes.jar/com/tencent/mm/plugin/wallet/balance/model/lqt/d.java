package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.bwl;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends c<bwm>
{
  public d(String paramString)
  {
    AppMethodBeat.i(68401);
    bwl localbwl = new bwl();
    localbwl.time_stamp = ((int)System.currentTimeMillis());
    localbwl.CYT = paramString;
    localbwl.zFY = ae.dYR();
    b.a locala = new b.a();
    locala.gUU = localbwl;
    locala.gUV = new bwm();
    locala.funcId = 2896;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/openlqautotrans";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ad.d("MicroMsg.CgiLqtAutoChargeOpen", "pwd: %s", new Object[] { paramString });
    AppMethodBeat.o(68401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.d
 * JD-Core Version:    0.7.0.1
 */