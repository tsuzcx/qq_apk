package com.tencent.mm.vending.h;

import com.tencent.mm.vending.f.a;

public final class c
  extends d
{
  public c()
  {
    new Exception("This is not a handler thread!");
    a.ms();
  }
  
  public final void a(Runnable paramRunnable, long paramLong)
  {
    a.mp();
    paramRunnable.run();
  }
  
  public final void d(Runnable paramRunnable)
  {
    a.mp();
    paramRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.c
 * JD-Core Version:    0.7.0.1
 */