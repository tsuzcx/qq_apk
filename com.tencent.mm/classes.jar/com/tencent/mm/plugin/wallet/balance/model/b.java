package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.vy;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends c<vz>
{
  public b(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(68392);
    d.a locala = new d.a();
    vy localvy = new vy();
    localvy.Lhf = paramLong;
    localvy.Lhg = paramString1;
    localvy.Lhh = paramString2;
    locala.iLN = localvy;
    locala.iLO = new vz();
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getfreefeedetail";
    locala.funcId = 1236;
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    Log.i("MicroMsg.CgiGetFreeFeeDetail", "get free fee detail: %s, %s, %s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 });
    AppMethodBeat.o(68392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.b
 * JD-Core Version:    0.7.0.1
 */