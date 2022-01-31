package com.tencent.mm.plugin.subapp.c;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class d$1
  implements MediaPlayer.OnCompletionListener
{
  d$1(d paramd) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(25260);
    try
    {
      paramMediaPlayer.release();
      AppMethodBeat.o(25260);
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      ab.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", paramMediaPlayer, "", new Object[0]);
      AppMethodBeat.o(25260);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.d.1
 * JD-Core Version:    0.7.0.1
 */