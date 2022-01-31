package com.tencent.mm.plugin.music.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  extends Handler
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(137475);
    if (100 == paramMessage.what)
    {
      ab.i("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", new Object[] { Long.valueOf(this.oYW.oYL.getDuration()), Long.valueOf(this.oYW.oYL.getCurrentPosition()), Long.valueOf(this.oYW.oYL.getBufferedPosition()), Long.valueOf(this.oYW.oYL.getBufferedPercentage()) });
      this.oYW.bTu.removeMessages(100);
      if (this.oYW.oXo) {
        this.oYW.bTu.sendEmptyMessageDelayed(100, 5000L);
      }
    }
    AppMethodBeat.o(137475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a.1
 * JD-Core Version:    0.7.0.1
 */