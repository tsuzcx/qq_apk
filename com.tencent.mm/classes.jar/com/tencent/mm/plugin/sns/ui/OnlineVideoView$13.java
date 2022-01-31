package com.tencent.mm.plugin.sns.ui;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class OnlineVideoView$13
  implements Runnable
{
  OnlineVideoView$13(OnlineVideoView paramOnlineVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(38402);
    ab.i("MicroMsg.OnlineVideoView", "%d show loading. downloadMode %d", new Object[] { Integer.valueOf(this.rJD.hashCode()), Integer.valueOf(OnlineVideoView.i(this.rJD)) });
    if (OnlineVideoView.i(this.rJD) == 1)
    {
      if ((OnlineVideoView.g(this.rJD) != null) && (OnlineVideoView.g(this.rJD).getVisibility() != 0)) {
        OnlineVideoView.g(this.rJD).setVisibility(0);
      }
      if ((OnlineVideoView.h(this.rJD) != null) && (OnlineVideoView.h(this.rJD).getVisibility() != 8)) {
        OnlineVideoView.h(this.rJD).setVisibility(8);
      }
    }
    if (OnlineVideoView.i(this.rJD) == 2)
    {
      if ((OnlineVideoView.h(this.rJD) != null) && (OnlineVideoView.h(this.rJD).getVisibility() != 0)) {
        OnlineVideoView.h(this.rJD).setVisibility(0);
      }
      if ((OnlineVideoView.g(this.rJD) != null) && (OnlineVideoView.g(this.rJD).getVisibility() != 8)) {
        OnlineVideoView.g(this.rJD).setVisibility(8);
      }
    }
    if (OnlineVideoView.i(this.rJD) == 3)
    {
      if ((OnlineVideoView.h(this.rJD) != null) && (OnlineVideoView.h(this.rJD).getVisibility() != 0))
      {
        OnlineVideoView.h(this.rJD).setVisibility(0);
        OnlineVideoView.h(this.rJD).dOF();
      }
      if ((OnlineVideoView.g(this.rJD) != null) && (OnlineVideoView.g(this.rJD).getVisibility() != 8)) {
        OnlineVideoView.g(this.rJD).setVisibility(8);
      }
    }
    AppMethodBeat.o(38402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.13
 * JD-Core Version:    0.7.0.1
 */