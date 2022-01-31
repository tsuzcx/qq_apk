package com.tencent.mm.plugin.voip.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class d$2$1
  implements ap.a
{
  d$2$1(d.2 param2) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(4971);
    ab.i("MicroMsg.VoipVoiceMiniManager", "click small view and time is up we remove it..");
    this.tFe.tFd.dismiss();
    if (d.a(this.tFe.tFd) != null) {
      d.a(this.tFe.tFd).stopTimer();
    }
    AppMethodBeat.o(4971);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.d.2.1
 * JD-Core Version:    0.7.0.1
 */