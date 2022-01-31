package com.tencent.mm.pluginsdk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class AbstractVideoView$1
  implements ap.a
{
  AbstractVideoView$1(AbstractVideoView paramAbstractVideoView) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(117934);
    if (!this.vPL.isPlaying())
    {
      AppMethodBeat.o(117934);
      return false;
    }
    if (this.vPL.vPw)
    {
      if (this.vPL.ryi != null) {
        this.vPL.ryi.ct(this.vPL.getSessionId(), this.vPL.getMediaId());
      }
      this.vPL.vPw = false;
    }
    this.vPL.rl(this.vPL.getCurrPosSec());
    AbstractVideoView.a(this.vPL, this.vPL.isPlaying());
    AppMethodBeat.o(117934);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView.1
 * JD-Core Version:    0.7.0.1
 */