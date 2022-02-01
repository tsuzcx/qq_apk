package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends c<abi>
{
  public b(String paramString)
  {
    AppMethodBeat.i(68399);
    abh localabh = new abh();
    localabh.Lmm = paramString;
    localabh.time_stamp = ((int)System.currentTimeMillis());
    localabh.HuS = ag.fNb();
    paramString = new d.a();
    paramString.iLN = localabh;
    paramString.iLO = new abi();
    paramString.funcId = 2512;
    paramString.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/closeautolqtolqt";
    paramString.iLP = 0;
    paramString.respCmdId = 0;
    c(paramString.aXF());
    Log.d("MicroMsg.CgiLqtAutoChargeClose", "close ");
    AppMethodBeat.o(68399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.b
 * JD-Core Version:    0.7.0.1
 */