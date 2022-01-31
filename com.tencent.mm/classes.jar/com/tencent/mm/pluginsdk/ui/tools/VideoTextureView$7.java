package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoTextureView$7
  implements MediaPlayer.OnInfoListener
{
  VideoTextureView$7(VideoTextureView paramVideoTextureView) {}
  
  public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(118014);
    ab.d("MicroMsg.VideoTextureView", "onInfo [%d %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (VideoTextureView.l(this.wga) != null) {
      VideoTextureView.l(this.wga).he(paramInt1, paramInt2);
    }
    AppMethodBeat.o(118014);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.7
 * JD-Core Version:    0.7.0.1
 */