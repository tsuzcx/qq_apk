package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.protocal.protobuf.bao;

final class c$1
  implements w.a
{
  c$1(c paramc, o paramo, String paramString) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(91431);
    paramm = null;
    paramString = paramm;
    if (paramInt1 == 0)
    {
      paramString = paramm;
      if (paramInt2 == 0) {
        paramString = ((bao)paramb.fsW.fta).wAa;
      }
    }
    if (this.uMs != null) {
      this.uMs.n(this.Cr, c.agE(paramString));
    }
    AppMethodBeat.o(91431);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.1
 * JD-Core Version:    0.7.0.1
 */