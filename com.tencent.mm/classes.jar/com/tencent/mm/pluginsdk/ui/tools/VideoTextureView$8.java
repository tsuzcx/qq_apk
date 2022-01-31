package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class VideoTextureView$8
  implements MediaPlayer.OnCompletionListener
{
  VideoTextureView$8(VideoTextureView paramVideoTextureView) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(118015);
    ab.i("MicroMsg.VideoTextureView", "video on completion");
    VideoTextureView.b(this.wga, bo.aox());
    if (VideoTextureView.d(this.wga) != null) {
      VideoTextureView.d(this.wga).Es();
    }
    AppMethodBeat.o(118015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.8
 * JD-Core Version:    0.7.0.1
 */