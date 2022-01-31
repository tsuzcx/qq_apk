package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.sdk.platformtools.ap.a;

final class k$8
  implements ap.a
{
  k$8(k paramk) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(4398);
    if (this.tvC.mStatus == 4)
    {
      a.Logi("MicroMsg.Voip.VoipContext", "connect time out.. now finish..");
      this.tvC.tvj.tBN.twb = 105;
      this.tvC.y(1, -9000, "");
    }
    AppMethodBeat.o(4398);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.k.8
 * JD-Core Version:    0.7.0.1
 */