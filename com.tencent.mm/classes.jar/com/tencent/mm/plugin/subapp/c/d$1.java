package com.tencent.mm.plugin.subapp.c;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.y;

final class d$1
  implements MediaPlayer.OnCompletionListener
{
  d$1(d paramd) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    try
    {
      paramMediaPlayer.release();
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      y.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", paramMediaPlayer, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.d.1
 * JD-Core Version:    0.7.0.1
 */