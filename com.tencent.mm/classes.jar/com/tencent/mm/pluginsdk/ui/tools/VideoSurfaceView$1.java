package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoSurfaceView$1
  implements MediaPlayer.OnVideoSizeChangedListener
{
  VideoSurfaceView$1(VideoSurfaceView paramVideoSurfaceView) {}
  
  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70440);
    VideoSurfaceView.a(this.wfS, paramMediaPlayer.getVideoWidth());
    VideoSurfaceView.b(this.wfS, paramMediaPlayer.getVideoHeight());
    ab.v("MicroMsg.VideoSurfaceView", "on size change size:( " + VideoSurfaceView.a(this.wfS) + " , " + VideoSurfaceView.b(this.wfS) + " )");
    VideoSurfaceView.c(this.wfS);
    AppMethodBeat.o(70440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */