package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class k$1
  implements ap.a
{
  k$1(k paramk) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(33712);
    ab.d("MicroMsg.FMessageContactView", "refresh timer expired, update");
    k.dLT();
    k.a(this.AcQ);
    AppMethodBeat.o(33712);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.k.1
 * JD-Core Version:    0.7.0.1
 */