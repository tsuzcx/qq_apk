package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class VideoTextureView$1
  extends Thread
{
  VideoTextureView$1(VideoTextureView paramVideoTextureView, MediaPlayer paramMediaPlayer) {}
  
  public final void run()
  {
    AppMethodBeat.i(134064);
    try
    {
      if (this.nTu != null)
      {
        ad.i("MicroMsg.VideoTextureView", "%d another thread to release player[%s]", new Object[] { Integer.valueOf(this.CnQ.hashCode()), this.nTu });
        this.nTu.stop();
        this.nTu.release();
      }
      AppMethodBeat.o(134064);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(134064);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.1
 * JD-Core Version:    0.7.0.1
 */