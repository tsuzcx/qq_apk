package com.tencent.thumbplayer.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$a
  extends Handler
{
  c$a(c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(189441);
    c.a(this.Sbb, paramMessage);
    AppMethodBeat.o(189441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.g.c.a
 * JD-Core Version:    0.7.0.1
 */