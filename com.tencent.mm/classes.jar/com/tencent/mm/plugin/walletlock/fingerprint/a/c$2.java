package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.plugin.soter.d.g;

final class c$2
  implements g
{
  c$2(c paramc) {}
  
  public final void aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(51471);
    if (this.uEo.isCancelled)
    {
      AppMethodBeat.o(51471);
      return;
    }
    if (paramInt == 0)
    {
      paramString = d.cyc();
      c.he(paramString.son, paramString.kbP);
      AppMethodBeat.o(51471);
      return;
    }
    if (this.uEo.uEl != null) {
      this.uEo.uEl.aC(2, "init soter failed");
    }
    AppMethodBeat.o(51471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.c.2
 * JD-Core Version:    0.7.0.1
 */