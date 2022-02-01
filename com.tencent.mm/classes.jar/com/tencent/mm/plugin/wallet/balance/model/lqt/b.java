package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.abp;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends c<abp>
{
  public b(String paramString)
  {
    AppMethodBeat.i(68399);
    abo localabo = new abo();
    localabo.SnA = paramString;
    localabo.time_stamp = ((int)System.currentTimeMillis());
    localabo.OmF = ah.gFF();
    paramString = new d.a();
    paramString.lBU = localabo;
    paramString.lBV = new abp();
    paramString.funcId = 2512;
    paramString.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/closeautolqtolqt";
    paramString.lBW = 0;
    paramString.respCmdId = 0;
    c(paramString.bgN());
    Log.d("MicroMsg.CgiLqtAutoChargeClose", "close ");
    AppMethodBeat.o(68399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.b
 * JD-Core Version:    0.7.0.1
 */