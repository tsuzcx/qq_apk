package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.adq;
import com.tencent.mm.protocal.protobuf.adr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class b
  extends z<adr>
{
  public b(String paramString)
  {
    AppMethodBeat.i(68399);
    adq localadq = new adq();
    localadq.ZlW = paramString;
    localadq.time_stamp = ((int)System.currentTimeMillis());
    localadq.Vbl = ai.ieD();
    paramString = new c.a();
    paramString.otE = localadq;
    paramString.otF = new adr();
    paramString.funcId = 2512;
    paramString.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/closeautolqtolqt";
    paramString.otG = 0;
    paramString.respCmdId = 0;
    c(paramString.bEF());
    Log.d("MicroMsg.CgiLqtAutoChargeClose", "close ");
    AppMethodBeat.o(68399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.b
 * JD-Core Version:    0.7.0.1
 */