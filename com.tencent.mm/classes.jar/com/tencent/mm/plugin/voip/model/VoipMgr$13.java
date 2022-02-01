package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.av.a;

final class VoipMgr$13
  implements av.a
{
  VoipMgr$13(VoipMgr paramVoipMgr) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(192021);
    VoipMgr.L(this.zlq);
    AppMethodBeat.o(192021);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.13
 * JD-Core Version:    0.7.0.1
 */