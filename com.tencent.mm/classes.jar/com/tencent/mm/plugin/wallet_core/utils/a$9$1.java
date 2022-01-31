package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class a$9$1
  implements com.tencent.mm.ai.f
{
  a$9$1(a.9 param9, com.tencent.mm.vending.g.b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47992);
    g.RM();
    g.RK().eHt.b(1650, this);
    this.uyc.uxV.uxU = null;
    com.tencent.mm.vending.g.f.a(this.bDR, new Object[0]);
    AppMethodBeat.o(47992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.a.9.1
 * JD-Core Version:    0.7.0.1
 */