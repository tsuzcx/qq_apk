package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.protocal.protobuf.zs;

public final class b
  extends a<zs>
{
  public b(String paramString)
  {
    AppMethodBeat.i(68399);
    zr localzr = new zr();
    localzr.Gro = paramString;
    localzr.time_stamp = ((int)System.currentTimeMillis());
    localzr.CPZ = ae.eFT();
    paramString = new b.a();
    paramString.hQF = localzr;
    paramString.hQG = new zs();
    paramString.funcId = 2512;
    paramString.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/closeautolqtolqt";
    paramString.hQH = 0;
    paramString.respCmdId = 0;
    c(paramString.aDS());
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.CgiLqtAutoChargeClose", "close ");
    AppMethodBeat.o(68399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.b
 * JD-Core Version:    0.7.0.1
 */