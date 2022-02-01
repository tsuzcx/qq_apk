package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.ur;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends a<us>
{
  public b(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(68392);
    b.a locala = new b.a();
    ur localur = new ur();
    localur.GmB = paramLong;
    localur.GmC = paramString1;
    localur.GmD = paramString2;
    locala.hQF = localur;
    locala.hQG = new us();
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getfreefeedetail";
    locala.funcId = 1236;
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    ae.i("MicroMsg.CgiGetFreeFeeDetail", "get free fee detail: %s, %s, %s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 });
    AppMethodBeat.o(68392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.b
 * JD-Core Version:    0.7.0.1
 */