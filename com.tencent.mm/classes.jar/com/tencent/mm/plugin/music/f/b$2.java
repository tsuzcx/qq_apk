package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements MediaPlayer.OnSeekCompleteListener
{
  b$2(b paramb) {}
  
  public final void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if ((this.mAy.eLh != null) && (this.mAy.eLh.isPlaying())) {
      y.i("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
    }
    try
    {
      this.mAy.eLh.start();
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      y.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramMediaPlayer, "start", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b.2
 * JD-Core Version:    0.7.0.1
 */