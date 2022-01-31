package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoTextureView$9
  implements MediaPlayer.OnErrorListener
{
  VideoTextureView$9(VideoTextureView paramVideoTextureView) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(118016);
    ab.w("MicroMsg.VideoTextureView", "Error: " + paramInt1 + "," + paramInt2);
    if (VideoTextureView.d(this.wga) != null) {
      VideoTextureView.d(this.wga).onError(paramInt1, paramInt2);
    }
    AppMethodBeat.o(118016);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.9
 * JD-Core Version:    0.7.0.1
 */