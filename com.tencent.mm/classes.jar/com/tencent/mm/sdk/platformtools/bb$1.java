package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class bb$1
  implements ap.a
{
  bb$1(bb parambb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(52240);
    long l = System.currentTimeMillis();
    this.ypO.pM(false);
    ab.i("MicroMsg.RWCache", "summer timer onTimerExpired e appendAll takes: " + (System.currentTimeMillis() - l) + " ms");
    AppMethodBeat.o(52240);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bb.1
 * JD-Core Version:    0.7.0.1
 */