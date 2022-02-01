package com.google.android.gms.b;

import java.util.concurrent.Executor;

final class d<TResult>
  implements e<TResult>
{
  private final Object Lk = new Object();
  private final Executor TM;
  private a<TResult> TN;
  
  public d(Executor paramExecutor, a<TResult> parama)
  {
    this.TM = paramExecutor;
    this.TN = parama;
  }
  
  public final void a(final b<TResult> paramb)
  {
    synchronized (this.Lk)
    {
      if (this.TN == null) {
        return;
      }
      this.TM.execute(new Runnable()
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