package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoView$4
  implements MediaPlayer.OnErrorListener
{
  VideoView$4(VideoView paramVideoView) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35286);
    ab.d("MicroMsg.VideoView", "Error: " + paramInt1 + "," + paramInt2);
    if ((VideoView.o(this.ABv) != null) && (VideoView.o(this.ABv).onError(VideoView.e(this.ABv), paramInt1, paramInt2)))
    {
      AppMethodBeat.o(35286);
      return true;
    }
    this.ABv.getWindowToken();
    AppMethodBeat.o(35286);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.video.VideoView.4
 * JD-Core Version:    0.7.0.1
 */