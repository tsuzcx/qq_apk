package com.google.android.gms.b;

import java.util.concurrent.Executor;

final class d<TResult>
  implements e<TResult>
{
  private final Object Jv = new Object();
  private final Executor RX;
  private a<TResult> RY;
  
  public d(Executor paramExecutor, a<TResult> parama)
  {
    this.RX = paramExecutor;
    this.RY = parama;
  }
  
  public final void a(final b<TResult> paramb)
  {
    synchronized (this.Jv)
    {
      if (this.RY == null) {
        return;
      }
      this.RX.execute(new Runnable()
      {
        public final void run()
        {
          synchronized (d.a(d.this))
          {
            if (d.b(d.this) != null) {
              d.b(d.this).a(paramb);
            }
            return;
          }
        }
      });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.b.d
 * JD-Core Version:    0.7.0.1
 */