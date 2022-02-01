package com.tencent.mm.plugin.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.protocal.protobuf.crz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a$1
  implements x.a
{
  public a$1(a parama, long paramLong, crz paramcrz) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(221074);
    ae.i("MicroMsg.AbsReportStruct", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(bu.DD(this.itW)), this.itX.yxn });
    AppMethodBeat.o(221074);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.a.1
 * JD-Core Version:    0.7.0.1
 */