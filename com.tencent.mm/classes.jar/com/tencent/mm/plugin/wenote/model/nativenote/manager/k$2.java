package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class k$2
  implements ap.a
{
  k$2(k paramk) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(26832);
    if (-1L == k.c(this.vzP))
    {
      AppMethodBeat.o(26832);
      return false;
    }
    this.vzP.diW();
    AppMethodBeat.o(26832);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.k.2
 * JD-Core Version:    0.7.0.1
 */