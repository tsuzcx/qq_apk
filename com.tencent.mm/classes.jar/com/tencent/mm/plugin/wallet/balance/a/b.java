package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends a<qa>
{
  public b(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(45220);
    b.a locala = new b.a();
    pz localpz = new pz();
    localpz.wIq = paramLong;
    localpz.wIr = paramString1;
    localpz.wIs = paramString2;
    locala.fsX = localpz;
    locala.fsY = new qa();
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getfreefeedetail";
    locala.funcId = 1236;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ab.i("MicroMsg.CgiGetFreeFeeDetail", "get free fee detail: %s, %s, %s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 });
    AppMethodBeat.o(45220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.b
 * JD-Core Version:    0.7.0.1
 */