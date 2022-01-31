package com.google.android.gms.internal;

import java.util.concurrent.locks.Lock;

abstract class an
{
  private final al Oo;
  
  protected an(al paramal)
  {
    this.Oo = paramal;
  }
  
  public final void c(am paramam)
  {
    am.a(paramam).lock();
    try
    {
      al localal1 = am.b(paramam);
      al localal2 = this.Oo;
      if (localal1 != localal2) {
        return;
      }
      iu();
      return;
    }
    finally
    {
      am.a(paramam).unlock();
    }
  }
  
  protected abstract void iu();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.an
 * JD-Core Version:    0.7.0.1
 */