package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.av.a;

final class b$13
  implements av.a
{
  b$13(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(51512);
    b.e(this.vYI);
    AppMethodBeat.o(51512);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.13
 * JD-Core Version:    0.7.0.1
 */