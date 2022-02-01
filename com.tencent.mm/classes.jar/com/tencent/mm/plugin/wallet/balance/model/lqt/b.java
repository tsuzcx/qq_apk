package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.zo;
import com.tencent.mm.protocal.protobuf.zp;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends a<zp>
{
  public b(String paramString)
  {
    AppMethodBeat.i(68399);
    zo localzo = new zo();
    localzo.FYP = paramString;
    localzo.time_stamp = ((int)System.currentTimeMillis());
    localzo.Cyu = ae.eCl();
    paramString = new b.a();
    paramString.hNM = localzo;
    paramString.hNN = new zp();
    paramString.funcId = 2512;
    paramString.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/closeautolqtolqt";
    paramString.hNO = 0;
    paramString.respCmdId = 0;
    c(paramString.aDC());
    ad.d("MicroMsg.CgiLqtAutoChargeClose", "close ");
    AppMethodBeat.o(68399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.b
 * JD-Core Version:    0.7.0.1
 */