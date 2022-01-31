package com.tencent.mm.plugin.sns.ui;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class OfflineVideoView$6
  implements Runnable
{
  OfflineVideoView$6(OfflineVideoView paramOfflineVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(38365);
    if ((OfflineVideoView.d(this.rJb) != null) && (OfflineVideoView.d(this.rJb).getVisibility() != 8))
    {
      ab.i("MicroMsg.OfflineVideoView", "%d hide loading.", new Object[] { Integer.valueOf(this.rJb.hashCode()) });
      OfflineVideoView.d(this.rJb).setVisibility(8);
    }
    AppMethodBeat.o(38365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView.6
 * JD-Core Version:    0.7.0.1
 */