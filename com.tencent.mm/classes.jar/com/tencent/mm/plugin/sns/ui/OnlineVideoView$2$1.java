package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class OnlineVideoView$2$1
  implements Runnable
{
  OnlineVideoView$2$1(OnlineVideoView.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(293031);
    if (this.Ofs.KHP.txH != null)
    {
      if (Util.isNullOrNil(this.Ofs.KHP.txH.getVideoPath()))
      {
        Log.i(OnlineVideoView.c(this.Ofs.KHP), "%d had not set video path to play", new Object[] { Integer.valueOf(this.Ofs.KHP.hashCode()) });
        String str = ax.a(OnlineVideoView.s(this.Ofs.KHP), OnlineVideoView.u(this.Ofs.KHP));
        if (!Util.isNullOrNil(str)) {
          this.Ofs.KHP.cD(str, false);
        }
        AppMethodBeat.o(293031);
        return;
      }
      if (!this.Ofs.KHP.txH.isPlaying()) {
        this.Ofs.KHP.txH.start();
      }
    }
    AppMethodBeat.o(293031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.2.1
 * JD-Core Version:    0.7.0.1
 */