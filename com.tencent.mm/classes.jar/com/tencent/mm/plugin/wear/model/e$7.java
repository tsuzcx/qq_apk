package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class e$7
  implements ap.a
{
  e$7(e parame) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(26309);
    a.cYy().uGI.a(new com.tencent.mm.plugin.wear.model.f.a());
    AppMethodBeat.o(26309);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.7
 * JD-Core Version:    0.7.0.1
 */