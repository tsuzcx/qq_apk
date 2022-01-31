package com.tencent.mm.ui.chatting.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class a$1
  implements ap.a
{
  a$1(a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(31095);
    if ((a.a(this.zDD) != null) && (a.a(this.zDD).bSe))
    {
      ab.i("MicroMsg.ChattingDataAdapter", "[onTimerExpired]");
      this.zDD.dHc();
    }
    AppMethodBeat.o(31095);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a.1
 * JD-Core Version:    0.7.0.1
 */