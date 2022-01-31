package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class Vending$c<_Index>
{
  HashMap<_Index, Vending.c.b> a = new HashMap();
  byte[] b = new byte[0];
  Handler e;
  Vending.c.a<_Index> wtb = null;
  AtomicBoolean wtc = new AtomicBoolean(false);
  
  protected Vending$c(Looper paramLooper, Vending.c.a<_Index> parama)
  {
    this.wtb = parama;
    this.e = new Vending.c.1(this, paramLooper);
  }
  
  protected final void cKS()
  {
    this.e.removeCallbacksAndMessages(null);
    a.i("Vending.Loader", "clear()", new Object[0]);
    synchronized (this.b)
    {
      this.a.clear();
      this.wtb.cancel();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending.c
 * JD-Core Version:    0.7.0.1
 */