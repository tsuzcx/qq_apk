package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1
  implements w.a
{
  c$1(c paramc) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(91351);
    ab.d("WebSearchService", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      h.qsU.idkeyStat(457L, 1L, 1L, false);
    }
    AppMethodBeat.o(91351);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.1
 * JD-Core Version:    0.7.0.1
 */