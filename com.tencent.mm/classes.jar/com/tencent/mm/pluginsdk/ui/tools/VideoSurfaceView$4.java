package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class VideoSurfaceView$4
  implements MediaPlayer.OnErrorListener
{
  VideoSurfaceView$4(VideoSurfaceView paramVideoSurfaceView) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116297);
    ad.d("MicroMsg.VideoSurfaceView", "Error: " + paramInt1 + "," + paramInt2);
    if (VideoSurfaceView.e(this.CnL) != null) {
      VideoSurfaceView.e(this.CnL).onError(paramInt1, paramInt2);
    }
    AppMethodBeat.o(116297);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.4
 * JD-Core Version:    0.7.0.1
 */