package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.compatible.b.f;

public final class i$7
  implements MediaPlayer.OnCompletionListener
{
  public i$7(i parami) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    if (System.currentTimeMillis() - this.qbG.qbE > 5000L)
    {
      this.qbG.qbC = 8;
      f.yi().setMode(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.i.7
 * JD-Core Version:    0.7.0.1
 */