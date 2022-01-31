package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class Vending$c<_Index>
{
  Vending.c.a<_Index> ANW;
  AtomicBoolean ANX;
  HashMap<_Index, Vending.c.b> a;
  byte[] b;
  Handler e;
  
  protected Vending$c(Looper paramLooper, Vending.c.a<_Index> parama)
  {
    AppMethodBeat.i(126150);
    this.a = new HashMap();
    this.ANW = null;
    this.ANX = new AtomicBoolean(false);
    this.b = new byte[0];
    this.ANW = parama;
    this.e = new Vending.c.1(this, paramLooper);
    AppMethodBeat.o(126150);
  }
  
  protected final void dQi()
  {
    AppMethodBeat.i(126151);
    this.e.removeCallbacksAndMessages(null);
    a.i("Vending.Loader", "clear()", new Object[0]);
    synchronized (this.b)
    {
      this.a.clear();
      this.ANW.cancel();
      AppMethodBeat.o(126151);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending.c
 * JD-Core Version:    0.7.0.1
 */