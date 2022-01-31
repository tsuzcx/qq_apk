package com.google.android.gms.b;

import java.util.ArrayDeque;
import java.util.Queue;

final class f<TResult>
{
  private final Object Jv = new Object();
  private Queue<e<TResult>> Sb;
  private boolean Sc;
  
  public final void a(e<TResult> parame)
  {
    synchronized (this.Jv)
    {
      if (this.Sb == null) {
        this.Sb = new ArrayDeque();
      }
      this.Sb.add(parame);
      return;
    }
  }
  
  public final void b(b<TResult> paramb)
  {
    for (;;)
    {
      e locale;
      synchronized (this.Jv)
      {
        if ((this.Sb == null) || (this.Sc)) {
          return;
        }
        this.Sc = true;
        synchronized (this.Jv)
        {
          locale = (e)this.Sb.poll();
          if (locale == null)
          {
            this.Sc = false;
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