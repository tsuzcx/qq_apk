package com.tencent.mm.plugin.voip_cs.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class e$1
  implements MTimerHandler.CallBack
{
  e$1(e parame) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(125356);
    Log.v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
    this.UXX.ied();
    AppMethodBeat.o(125356);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.model.e.1
 * JD-Core Version:    0.7.0.1
 */