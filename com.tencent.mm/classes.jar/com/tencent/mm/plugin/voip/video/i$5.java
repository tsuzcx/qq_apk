package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class i$5
  implements MediaPlayer.OnCompletionListener
{
  i$5(i parami) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    if (System.currentTimeMillis() - this.qbG.qbE > 5000L) {
      this.qbG.qbC = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.i.5
 * JD-Core Version:    0.7.0.1
 */