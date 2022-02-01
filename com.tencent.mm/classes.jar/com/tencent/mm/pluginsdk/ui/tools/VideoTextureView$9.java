package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class VideoTextureView$9
  implements MediaPlayer.OnErrorListener
{
  VideoTextureView$9(VideoTextureView paramVideoTextureView) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134072);
    Log.w("MicroMsg.VideoTextureView", "Error: " + paramInt1 + "," + paramInt2);
    if (VideoTextureView.d(this.Ryh) != null) {
      VideoTextureView.d(this.Ryh).onError(paramInt1, paramInt2);
    }
    AppMethodBeat.o(134072);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.9
 * JD-Core Version:    0.7.0.1
 */