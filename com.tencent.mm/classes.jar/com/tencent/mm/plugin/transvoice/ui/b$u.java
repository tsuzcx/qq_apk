package com.tencent.mm.plugin.transvoice.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "onTimerExpired"})
final class b$u
  implements ap.a
{
  b$u(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(156328);
    int i = b.C(this.tqJ);
    b localb = this.tqJ;
    b.c(localb, b.C(localb) + 1);
    switch (i % 3)
    {
    }
    for (;;)
    {
      b.D(this.tqJ);
      AppMethodBeat.o(156328);
      return true;
      b.a(this.tqJ, "·");
      continue;
      b.a(this.tqJ, "··");
      continue;
      b.a(this.tqJ, "···");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b.u
 * JD-Core Version:    0.7.0.1
 */