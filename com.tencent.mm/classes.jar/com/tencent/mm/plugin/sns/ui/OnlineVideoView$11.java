package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class OnlineVideoView$11
  implements Runnable
{
  OnlineVideoView$11(OnlineVideoView paramOnlineVideoView, boolean paramBoolean, float paramFloat) {}
  
  public final void run()
  {
    AppMethodBeat.i(38400);
    ab.i("MicroMsg.OnlineVideoView", "%d switch video model isVideoPlay %b %f", new Object[] { Integer.valueOf(this.rJD.hashCode()), Boolean.valueOf(this.kvP), Float.valueOf(this.rJc) });
    View localView = (View)this.rJD.kvG;
    if (this.kvP)
    {
      OnlineVideoView.d(this.rJD).setAlpha(this.rJc);
      OnlineVideoView.d(this.rJD).setVisibility(0);
      localView.setAlpha(this.rJc);
      localView.setVisibility(0);
      if (this.rJc >= 1.0D)
      {
        OnlineVideoView.e(this.rJD).setVisibility(8);
        AppMethodBeat.o(38400);
      }
    }
    else
    {
      OnlineVideoView.d(this.rJD).setVisibility(8);
      localView.setVisibility(8);
      if (OnlineVideoView.f(this.rJD)) {
        OnlineVideoView.e(this.rJD).setVisibility(0);
      }
    }
    AppMethodBeat.o(38400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.11
 * JD-Core Version:    0.7.0.1
 */