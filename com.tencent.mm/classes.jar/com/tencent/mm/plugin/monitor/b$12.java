package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class b$12
  implements ap.a
{
  b$12(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(84530);
    b.e(this.oRW);
    AppMethodBeat.o(84530);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.12
 * JD-Core Version:    0.7.0.1
 */