package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.wx;
import com.tencent.mm.protocal.protobuf.wy;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends c<wy>
{
  public b(String paramString)
  {
    AppMethodBeat.i(68399);
    wx localwx = new wx();
    localwx.CYT = paramString;
    localwx.time_stamp = ((int)System.currentTimeMillis());
    localwx.zFY = ae.dYR();
    paramString = new b.a();
    paramString.gUU = localwx;
    paramString.gUV = new wy();
    paramString.funcId = 2512;
    paramString.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/closeautolqtolqt";
    paramString.reqCmdId = 0;
    paramString.respCmdId = 0;
    this.rr = paramString.atI();
    ad.d("MicroMsg.CgiLqtAutoChargeClose", "close ");
    AppMethodBeat.o(68399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.b
 * JD-Core Version:    0.7.0.1
 */