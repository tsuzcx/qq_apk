package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

final class b$3
  implements MediaPlayer.OnPreparedListener
{
  b$3(b paramb) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(137550);
    if (this.paE.gaO != null) {
      ab.i("MicroMsg.Music.MMMediaPlayer", "onPrepared");
    }
    try
    {
      this.paE.gaO.start();
      this.paE.oIr = false;
      this.paE.onStart();
      if (this.paE.paD != null) {
        this.paE.paD.isStop = true;
      }
      this.paE.paD = new b.a(this.paE, (byte)0);
      paramMediaPlayer = this.paE.paD;
      paramMediaPlayer.isStop = false;
      d.post(paramMediaPlayer, "music_play_progress_runnable");
      AppMethodBeat.o(137550);
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramMediaPlayer, "start", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b.3
 * JD-Core Version:    0.7.0.1
 */