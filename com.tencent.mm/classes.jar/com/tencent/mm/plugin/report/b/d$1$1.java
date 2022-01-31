package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.sdk.platformtools.ab;

final class d$1$1
  implements w.a
{
  d$1$1(d.1 param1) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(123496);
    ab.i("MicroMsg.MidHelper", "onGYNetEnd errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(123496);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.d.1.1
 * JD-Core Version:    0.7.0.1
 */