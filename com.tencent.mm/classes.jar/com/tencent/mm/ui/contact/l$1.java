package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class l$1
  implements MTimerHandler.CallBack
{
  l$1(l paraml) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(37831);
    Log.d("MicroMsg.FMessageContactView", "refresh timer expired, update");
    l.jyz();
    l.a(this.afdX);
    AppMethodBeat.o(37831);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.l.1
 * JD-Core Version:    0.7.0.1
 */