package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

final class Vending$c$1
  extends Handler
{
  Vending$c$1(Vending.c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message arg1)
  {
    AppMethodBeat.i(126164);
    if (this.ANY.ANX.get())
    {
      this.ANY.ANW.cancel();
      AppMethodBeat.o(126164);
      return;
    }
    Object localObject1 = ???.obj;
    this.ANY.ANW.cJ(localObject1);
    synchronized (this.ANY.b)
    {
      this.ANY.a.put(localObject1, Vending.c.b.AOb);
      AppMethodBeat.o(126164);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending.c.1
 * JD-Core Version:    0.7.0.1
 */