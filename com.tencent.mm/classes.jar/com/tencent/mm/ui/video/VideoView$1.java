package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoView$1
  implements MediaPlayer.OnVideoSizeChangedListener
{
  VideoView$1(VideoView paramVideoView) {}
  
  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35283);
    VideoView.a(this.ABv, paramMediaPlayer.getVideoWidth());
    VideoView.b(this.ABv, paramMediaPlayer.getVideoHeight());
    ab.v("MicroMsg.VideoView", "on size change size:( " + VideoView.a(this.ABv) + " , " + VideoView.b(this.ABv) + " )");
    this.ABv.dOA();
    if (VideoView.a(this.ABv) != 0) {
      VideoView.b(this.ABv);
    }
    AppMethodBeat.o(35283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.video.VideoView.1
 * JD-Core Version:    0.7.0.1
 */