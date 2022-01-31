package com.tencent.mm.plugin.sns.ui;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class OnlineVideoView$12
  implements Runnable
{
  OnlineVideoView$12(OnlineVideoView paramOnlineVideoView, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(38401);
    if ((OnlineVideoView.g(this.rJD) != null) && (OnlineVideoView.g(this.rJD).getVisibility() != 8)) {
      OnlineVideoView.g(this.rJD).setVisibility(8);
    }
    if (OnlineVideoView.h(this.rJD) != null)
    {
      if (OnlineVideoView.h(this.rJD).getVisibility() != 0) {
        OnlineVideoView.h(this.rJD).setVisibility(0);
      }
      ab.i("MicroMsg.OnlineVideoView", "%d update progress %d %d", new Object[] { Integer.valueOf(this.rJD.hashCode()), Integer.valueOf(this.fzv), Integer.valueOf(this.fFB) });
      if ((OnlineVideoView.h(this.rJD).getMax() != this.fFB) && (this.fFB > 0)) {
        OnlineVideoView.h(this.rJD).setMax(this.fFB);
      }
      OnlineVideoView.h(this.rJD).setProgress(this.fzv);
    }
    AppMethodBeat.o(38401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.12
 * JD-Core Version:    0.7.0.1
 */