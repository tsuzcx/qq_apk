package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.vending.f.a;

public final class c
{
  private Looper b;
  private Handler c;
  private Handler d;
  byte[] e = new byte[0];
  private Looper wtl;
  c.a wtm;
  
  public c(Looper paramLooper1, Looper paramLooper2)
  {
    this.wtl = paramLooper1;
    this.b = paramLooper2;
    this.c = new c.1(this, this.wtl);
    this.d = new c.2(this, this.b);
  }
  
  public final void m(int paramInt, Object paramObject)
  {
    if (Looper.myLooper() == this.wtl) {
      if (this.wtm == null) {
        a.w("Vending.VendingSync", "This call is pointless.", new Object[0]);
      }
    }
    for (;;)
    {
      return;
      this.wtm.cKQ();
      synchronized (this.e)
      {
        this.d.sendMessageAtFrontOfQueue(this.d.obtainMessage(paramInt, paramObject));
      }
      try
      {
        this.e.wait();
        label69:
        this.wtm.cKR();
        return;
        paramObject = finally;
        throw paramObject;
        if (Looper.myLooper() != this.b) {
          continue;
        }
        this.c.sendMessageAtFrontOfQueue(this.c.obtainMessage(paramInt, paramObject));
        return;
      }
      catch (InterruptedException paramObject)
      {
        break label69;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vending.base.c
 * JD-Core Version:    0.7.0.1
 */