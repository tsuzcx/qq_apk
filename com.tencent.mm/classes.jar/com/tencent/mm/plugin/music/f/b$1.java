package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class b$1
  implements MediaPlayer.OnCompletionListener
{
  b$1(b paramb) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(137298);
    Log.e("MicroMsg.Music.MMMediaPlayer", "onCompletion, stop music");
    this.AlP.so(true);
    AppMethodBeat.o(137298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b.1
 * JD-Core Version:    0.7.0.1
 */