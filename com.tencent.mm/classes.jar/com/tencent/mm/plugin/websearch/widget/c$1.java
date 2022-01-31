package com.tencent.mm.plugin.websearch.widget;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.protocal.c.auh;

final class c$1
  implements w.a
{
  c$1(c paramc, o paramo, String paramString) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    paramm = null;
    paramString = paramm;
    if (paramInt1 == 0)
    {
      paramString = paramm;
      if (paramInt2 == 0) {
        paramString = ((auh)paramb.ecF.ecN).sEb;
      }
    }
    if (this.qXd != null) {
      this.qXd.m(this.BG, c.RD(paramString));
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.1
 * JD-Core Version:    0.7.0.1
 */