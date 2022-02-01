package com.tencent.mm.plugin.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.protocal.protobuf.crf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a$1
  implements x.a
{
  public a$1(a parama, long paramLong, crf paramcrf) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(197136);
    ad.i("MicroMsg.AbsReportStruct", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(bt.Df(this.irb)), this.irc.yhw });
    AppMethodBeat.o(197136);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.a.1
 * JD-Core Version:    0.7.0.1
 */