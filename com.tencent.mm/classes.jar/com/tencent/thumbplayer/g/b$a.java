package com.tencent.thumbplayer.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$a
  extends Handler
{
  b$a(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(192077);
    b.a(this.MbF, paramMessage);
    AppMethodBeat.o(192077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.g.b.a
 * JD-Core Version:    0.7.0.1
 */