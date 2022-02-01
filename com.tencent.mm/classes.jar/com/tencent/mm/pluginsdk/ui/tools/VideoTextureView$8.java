package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class VideoTextureView$8
  implements MediaPlayer.OnCompletionListener
{
  VideoTextureView$8(VideoTextureView paramVideoTextureView) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(134071);
    ad.i("MicroMsg.VideoTextureView", "video on completion");
    VideoTextureView.b(this.CnQ, bt.aGK());
    if (VideoTextureView.d(this.CnQ) != null) {
      VideoTextureView.d(this.CnQ).onCompletion();
    }
    AppMethodBeat.o(134071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.8
 * JD-Core Version:    0.7.0.1
 */