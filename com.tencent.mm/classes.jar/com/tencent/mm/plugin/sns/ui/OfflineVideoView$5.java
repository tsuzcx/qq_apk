package com.tencent.mm.plugin.sns.ui;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class OfflineVideoView$5
  implements Runnable
{
  OfflineVideoView$5(OfflineVideoView paramOfflineVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(38364);
    ab.i("MicroMsg.OfflineVideoView", "%d show loading. downloadMode %d", new Object[] { Integer.valueOf(this.rJb.hashCode()), Integer.valueOf(this.rJb.hashCode()) });
    if ((OfflineVideoView.d(this.rJb) != null) && (OfflineVideoView.d(this.rJb).getVisibility() != 0)) {
      OfflineVideoView.d(this.rJb).setVisibility(0);
    }
    AppMethodBeat.o(38364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView.5
 * JD-Core Version:    0.7.0.1
 */