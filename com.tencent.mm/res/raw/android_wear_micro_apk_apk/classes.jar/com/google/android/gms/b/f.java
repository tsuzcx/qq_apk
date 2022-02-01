package com.google.android.gms.b;

import java.util.ArrayDeque;
import java.util.Queue;

final class f<TResult>
{
  private final Object Lk = new Object();
  private Queue<e<TResult>> TQ;
  private boolean TR;
  
  public final void a(e<TResult> parame)
  {
    synchronized (this.Lk)
    {
      if (this.TQ == null) {
        this.TQ = new ArrayDeque();
      }
      this.TQ.add(parame);
      return;
    }
  }
  
  public final void b(b<TResult> paramb)
  {
    for (;;)
    {
      e locale;
      synchronized (this.Lk)
      {
        if ((this.TQ == null) || (this.TR)) {
          return;
        }
        this.TR = true;
        synchronized (this.Lk)
        {
          locale = (e)this.TQ.poll();
          if (locale == null)
          {
            this.TR = false;
            return;
          }
        }
      }
      locale.a(paramb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.b.f
 * JD-Core Version:    0.7.0.1
 */