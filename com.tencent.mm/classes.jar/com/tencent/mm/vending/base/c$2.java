package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2
  extends Handler
{
  c$2(c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(126153);
    synchronized (this.a.e)
    {
      if (this.a.AOh != null) {
        this.a.AOh.synchronizing(paramMessage.what, paramMessage.obj);
      }
      this.a.e.notify();
      AppMethodBeat.o(126153);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.vending.base.c.2
 * JD-Core Version:    0.7.0.1
 */