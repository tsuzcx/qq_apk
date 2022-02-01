package com.google.android.gms.b;

import java.util.concurrent.Executor;

final class g<TResult>
  extends b<TResult>
{
  private final Object Lk = new Object();
  private final f<TResult> TS = new f();
  private boolean TT;
  private TResult TU;
  private Exception TV;
  
  private void kx()
  {
    if (!this.TT) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.gms.common.internal.d.a(bool, "Task is already complete");
      return;
    }
  }
  
  public final void G(TResult arg1)
  {
    synchronized (this.Lk)
    {
      kx();
      this.TT = true;
      this.TU = null;
      this.TS.b(this);
      return;
    }
  }
  
  public final b<TResult> a(Executor arg1, a<TResult> parama)
  {
    this.TS.a(new d(???, parama));
    synchronized (this.Lk)
    {
      if (!this.TT) {
        return this;
      }
      this.TS.b(this);
      return this;
    }
  }
  
  public final void a(Exception paramException)
  {
    com.google.android.gms.common.internal.d.g(paramException, "Exception must not be null");
    synchronized (this.Lk)
    {
      kx();
      this.TT = true;
      this.TV = paramException;
      this.TS.b(this);
      return;
    }
  }
  
  public final boolean b(Exception paramException)
  {
    com.google.android.gms.common.internal.d.g(paramException, "Exception must not be null");
    synchronized (this.Lk)
    {
      if (this.TT) {
        return false;
      }
      this.TT = true;
      this.TV = paramException;
      this.TS.b(this);
      return true;
    }
  }
  
  public final Exception getException()
  {
    synchronized (this.Lk)
    {
      Exception localException = this.TV;
      return localException;
    }
  }
  
  public final boolean kv()
  {
    for (;;)
    {
      synchronized (this.Lk)
      {
        if ((this.TT) && (this.TV == null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.b.g
 * JD-Core Version:    0.7.0.1
 */