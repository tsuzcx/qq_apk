package com.tencent.mm.sdk.platformtools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ay$2
  implements MediaPlayer.OnCompletionListener
{
  ay$2(String paramString, MediaPlayer paramMediaPlayer, ay.a parama) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(52222);
    if (paramMediaPlayer == null) {}
    for (int i = -1;; i = paramMediaPlayer.hashCode())
    {
      ab.i("MicroMsg.PlaySound", "play completion mp:%d  path:%s", new Object[] { Integer.valueOf(i), this.val$path });
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      if (this.kNg != null) {
        this.kNg.release();
      }
      if (this.ypw != null) {
        this.ypw.Es();
      }
      AppMethodBeat.o(52222);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ay.2
 * JD-Core Version:    0.7.0.1
 */