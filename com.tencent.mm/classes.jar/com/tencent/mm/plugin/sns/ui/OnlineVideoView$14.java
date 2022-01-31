package com.tencent.mm.plugin.sns.ui;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class OnlineVideoView$14
  implements Runnable
{
  OnlineVideoView$14(OnlineVideoView paramOnlineVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(38403);
    if ((OnlineVideoView.g(this.rJD) != null) && (OnlineVideoView.g(this.rJD).getVisibility() != 8))
    {
      ab.i("MicroMsg.OnlineVideoView", "%d hide loading.", new Object[] { Integer.valueOf(this.rJD.hashCode()) });
      OnlineVideoView.g(this.rJD).setVisibility(8);
    }
    if ((OnlineVideoView.h(this.rJD) != null) && (OnlineVideoView.h(this.rJD).getVisibility() != 8))
    {
      ab.i("MicroMsg.OnlineVideoView", "%d hide progress.", new Object[] { Integer.valueOf(this.rJD.hashCode()) });
      OnlineVideoView.h(this.rJD).setVisibility(8);
    }
    AppMethodBeat.o(38403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.14
 * JD-Core Version:    0.7.0.1
 */