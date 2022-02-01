package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.sk;
import com.tencent.mm.protocal.protobuf.sl;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends c<sl>
{
  public b(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(68392);
    b.a locala = new b.a();
    sk localsk = new sk();
    localsk.CUj = paramLong;
    localsk.CUk = paramString1;
    localsk.CUl = paramString2;
    locala.gUU = localsk;
    locala.gUV = new sl();
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getfreefeedetail";
    locala.funcId = 1236;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ad.i("MicroMsg.CgiGetFreeFeeDetail", "get free fee detail: %s, %s, %s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 });
    AppMethodBeat.o(68392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.b
 * JD-Core Version:    0.7.0.1
 */