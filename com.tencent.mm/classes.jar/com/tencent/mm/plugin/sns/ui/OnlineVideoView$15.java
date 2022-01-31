package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ap;

final class OnlineVideoView$15
  implements Runnable
{
  OnlineVideoView$15(OnlineVideoView paramOnlineVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(38404);
    if ((this.rJD.kvG != null) && (this.rJD.rJi != null))
    {
      int i = this.rJD.kvG.getCurrentPosition() / 1000;
      this.rJD.rJi.mj(i);
    }
    OnlineVideoView.j(this.rJD).ag(500L, 500L);
    AppMethodBeat.o(38404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.15
 * JD-Core Version:    0.7.0.1
 */