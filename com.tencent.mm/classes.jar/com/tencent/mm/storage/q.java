package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/storage/BizCardReport;", "", "()V", "report20800Insert", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "arriveType", "", "pos", "useServerTime", "cardType", "style", "recID", "", "cardId", "", "expType", "extraData", "report20800Receive", "weight", "plugin-biz_release"})
public final class q
{
  public static final q IIu;
  
  static
  {
    AppMethodBeat.i(188820);
    IIu = new q();
    AppMethodBeat.o(188820);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(188818);
    g.yxI.f(20800, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Long.valueOf(paramLong), paramString1, paramString2, paramString3 });
    AppMethodBeat.o(188818);
  }
  
  public static void a(w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(188819);
    p.h(paramw, "info");
    if (!paramw.ftb())
    {
      AppMethodBeat.o(188819);
      return;
    }
    g.yxI.f(20800, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramw.fsZ()), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Long.valueOf(paramLong), paramString1, paramString2, paramString3 });
    AppMethodBeat.o(188819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.q
 * JD-Core Version:    0.7.0.1
 */