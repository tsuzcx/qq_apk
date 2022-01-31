package com.tencent.mm.sdk.platformtools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class au$2
  implements MediaPlayer.OnCompletionListener
{
  au$2(String paramString, MediaPlayer paramMediaPlayer, au.a parama) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer == null) {}
    for (int i = -1;; i = paramMediaPlayer.hashCode())
    {
      y.i("MicroMsg.PlaySound", "play completion mp:%d  path:%s", new Object[] { Integer.valueOf(i), this.dlh });
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      if (this.iHc != null) {
        this.iHc.release();
      }
      if (this.uhs != null) {
        this.uhs.ug();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.au.2
 * JD-Core Version:    0.7.0.1
 */