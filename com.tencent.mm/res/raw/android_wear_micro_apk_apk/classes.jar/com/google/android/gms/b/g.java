package com.google.android.gms.b;

import java.util.concurrent.Executor;

final class g<TResult>
  extends b<TResult>
{
  private final Object Jv = new Object();
  private final f<TResult> Sd = new f();
  private boolean Se;
  private TResult Sf;
  private Exception Sg;
  
  private void ko()
  {
    if (!this.Se) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.gms.common.internal.d.a(bool, "Task is already complete");
      return;
    }
  }
  
  public final b<TResult> a(Executor arg1, a<TResult> parama)
  {
    this.Sd.a(new d(???, parama));
    synchronized (this.Jv)
    {
      if (!this.Se) {
        return this;
      }
      this.Sd.b(this);
      return this;
    }
  }
  
  public final void a(Exception paramException)
  {
    com.google.android.gms.common.internal.d.e(paramException, "Exception must not be null");
    synchronized (this.Jv)
    {
      ko();
      this.Se = true;
      this.Sg = paramException;
      this.Sd.b(this);
      return;
    }
  }
  
  public final boolean b(Exception paramException)
  {
    com.google.android.gms.common.internal.d.e(paramException, "Exception must not be null");
    synchronized (this.Jv)
    {
      if (this.Se) {
        return false;
      }
      this.Se = true;
      this.Sg = paramException;
      this.Sd.b(this);
      return true;
    }
  }
  
  public final Exception getException()
  {
    synchronized (this.Jv)
    {
      Exception localException = this.Sg;
      return localException;
    }
  }
  
  public final boolean km()
  {
    for (;;)
    {
      synchronized (this.Jv)
      {
        if ((this.Se) && (this.Sg == null))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final void x(TResult arg1)
  {
    synchronized (this.Jv)
    {
      ko();
      this.Se = true;
      this.Sf = null;
      this.Sd.b(this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.b.g
 * JD-Core Version:    0.7.0.1
 */