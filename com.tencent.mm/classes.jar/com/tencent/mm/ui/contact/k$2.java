package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class k$2
  implements k.a
{
  k$2(k paramk) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(33713);
    ab.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
    if (!k.b(this.AcQ).dtj()) {
      k.b(this.AcQ).stopTimer();
    }
    paramString = k.b(this.AcQ);
    if (k.c(this.AcQ)) {}
    for (long l = 500L;; l = 1000L)
    {
      paramString.ag(l, l);
      AppMethodBeat.o(33713);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.k.2
 * JD-Core Version:    0.7.0.1
 */