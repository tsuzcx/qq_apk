package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoTextureView$6
  implements MediaPlayer.OnBufferingUpdateListener
{
  VideoTextureView$6(VideoTextureView paramVideoTextureView) {}
  
  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    AppMethodBeat.i(118013);
    ab.d("MicroMsg.VideoTextureView", "onBufferingUpdate percent[%d]", new Object[] { Integer.valueOf(paramInt) });
    VideoTextureView.c(this.wga, paramInt);
    AppMethodBeat.o(118013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.6
 * JD-Core Version:    0.7.0.1
 */