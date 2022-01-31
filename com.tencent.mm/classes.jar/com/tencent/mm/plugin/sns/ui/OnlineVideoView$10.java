package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class OnlineVideoView$10
  implements Runnable
{
  OnlineVideoView$10(OnlineVideoView paramOnlineVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(38399);
    if (this.rJD.kvG != null)
    {
      if (bo.isNullOrNil(this.rJD.kvG.getVideoPath()))
      {
        ab.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[] { Integer.valueOf(this.rJD.hashCode()) });
        String str = ar.a(OnlineVideoView.a(this.rJD), OnlineVideoView.c(this.rJD));
        if (!bo.isNullOrNil(str)) {
          this.rJD.bw(str, false);
        }
        AppMethodBeat.o(38399);
        return;
      }
      if (!this.rJD.kvG.isPlaying())
      {
        this.rJD.kvG.start();
        AppMethodBeat.o(38399);
        return;
      }
    }
    AppMethodBeat.o(38399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.10
 * JD-Core Version:    0.7.0.1
 */