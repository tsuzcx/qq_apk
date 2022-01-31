package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class e$1
  implements ap.a
{
  e$1(e parame) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(135304);
    ab.v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
    this.tKU.cQt();
    AppMethodBeat.o(135304);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.e.1
 * JD-Core Version:    0.7.0.1
 */