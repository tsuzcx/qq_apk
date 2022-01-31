package com.tencent.mm.pluginsdk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class AbstractVideoView$4
  implements ap.a
{
  AbstractVideoView$4(AbstractVideoView paramAbstractVideoView) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(117937);
    boolean bool = this.vPL.isPlaying();
    int i = this.vPL.getCurrPosMs();
    ab.i(this.vPL.TAG, "%s prepare start checker isplaying[%b] currPosMs[%d]", new Object[] { this.vPL.bas(), Boolean.valueOf(bool), Integer.valueOf(i) });
    if ((this.vPL.kvG != null) && (i <= 50)) {
      this.vPL.kvG.A(0.0D);
    }
    AppMethodBeat.o(117937);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.AbstractVideoView.4
 * JD-Core Version:    0.7.0.1
 */