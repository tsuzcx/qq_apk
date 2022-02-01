package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.cfw;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends a<cfx>
{
  public d(String paramString)
  {
    AppMethodBeat.i(68401);
    cfw localcfw = new cfw();
    localcfw.time_stamp = ((int)System.currentTimeMillis());
    localcfw.FYP = paramString;
    localcfw.Cyu = ae.eCl();
    b.a locala = new b.a();
    locala.hNM = localcfw;
    locala.hNN = new cfx();
    locala.funcId = 2896;
    locala.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/openlqautotrans";
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    ad.d("MicroMsg.CgiLqtAutoChargeOpen", "pwd: %s", new Object[] { paramString });
    AppMethodBeat.o(68401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.d
 * JD-Core Version:    0.7.0.1
 */