package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.xs;
import com.tencent.mm.protocal.protobuf.xt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class b
  extends z<xt>
{
  public b(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(68392);
    c.a locala = new c.a();
    xs localxs = new xs();
    localxs.Zgz = paramLong;
    localxs.ZgA = paramString1;
    localxs.ZgB = paramString2;
    locala.otE = localxs;
    locala.otF = new xt();
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getfreefeedetail";
    locala.funcId = 1236;
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    Log.i("MicroMsg.CgiGetFreeFeeDetail", "get free fee detail: %s, %s, %s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 });
    AppMethodBeat.o(68392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.b
 * JD-Core Version:    0.7.0.1
 */