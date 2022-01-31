package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.sdk.platformtools.ab;

final class OnlineVideoView$9
  implements Runnable
{
  OnlineVideoView$9(OnlineVideoView paramOnlineVideoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(38398);
    ab.w("MicroMsg.OnlineVideoView", "%d deal sns video change isOnlinePlay[%b]", new Object[] { Integer.valueOf(this.rJD.hashCode()), Boolean.valueOf(OnlineVideoView.w(this.rJD)) });
    if (OnlineVideoView.w(this.rJD))
    {
      OnlineVideoView.x(this.rJD);
      this.rJD.kvG.stop();
      this.rJD.ctW();
      String str = ar.D(OnlineVideoView.c(this.rJD));
      boolean bool = com.tencent.mm.vfs.e.deleteFile(str);
      if (this.rJD.rJi != null)
      {
        this.rJD.rJi.cuf();
        this.rJD.rJi.clear();
        this.rJD.rJi = new ae(this.rJD);
      }
      ab.i("MicroMsg.OnlineVideoView", "%d delete video file[%b] [%s]", new Object[] { Integer.valueOf(this.rJD.hashCode()), Boolean.valueOf(bool), str });
      OnlineVideoView.y(this.rJD);
      OnlineVideoView.z(this.rJD);
    }
    AppMethodBeat.o(38398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.9
 * JD-Core Version:    0.7.0.1
 */