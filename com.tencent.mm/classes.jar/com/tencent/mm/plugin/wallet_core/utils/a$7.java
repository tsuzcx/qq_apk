package com.tencent.mm.plugin.wallet_core.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class a$7
  implements f
{
  a$7(a parama, Context paramContext) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47990);
    g.RM();
    g.RK().eHt.b(1650, this);
    this.uxV.uxU = null;
    if (this.uxV.ezI != null)
    {
      this.uxV.b(this.val$context, this.uxV.ezI);
      this.uxV.ezI = null;
    }
    AppMethodBeat.o(47990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.a.7
 * JD-Core Version:    0.7.0.1
 */