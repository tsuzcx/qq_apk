package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class VoipMgr$11
  implements ap.a
{
  VoipMgr$11(VoipMgr paramVoipMgr) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(140150);
    VoipMgr.H(this.tyo);
    AppMethodBeat.o(140150);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.11
 * JD-Core Version:    0.7.0.1
 */