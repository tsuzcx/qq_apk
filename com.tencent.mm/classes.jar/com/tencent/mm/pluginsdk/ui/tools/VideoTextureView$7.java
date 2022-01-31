package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class VideoTextureView$7
  implements MediaPlayer.OnCompletionListener
{
  VideoTextureView$7(VideoTextureView paramVideoTextureView) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    y.i("MicroMsg.VideoTextureView", "video on completion");
    VideoTextureView.b(this.snF, bk.UX());
    if (VideoTextureView.d(this.snF) != null) {
      VideoTextureView.d(this.snF).ug();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.7
 * JD-Core Version:    0.7.0.1
 */