package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.su;
import com.tencent.mm.protocal.protobuf.sv;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends c<sv>
{
  public b(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(68392);
    b.a locala = new b.a();
    su localsu = new su();
    localsu.EmT = paramLong;
    localsu.EmU = paramString1;
    localsu.EmV = paramString2;
    locala.hvt = localsu;
    locala.hvu = new sv();
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getfreefeedetail";
    locala.funcId = 1236;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ac.i("MicroMsg.CgiGetFreeFeeDetail", "get free fee detail: %s, %s, %s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 });
    AppMethodBeat.o(68392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.b
 * JD-Core Version:    0.7.0.1
 */