package com.tencent.mm.vending.h;

import com.tencent.mm.vending.f.a;

public final class c
  extends d
{
  public c()
  {
    a.printErrStackTrace("Vending.NoLooperScheduler", new Exception("This is not a handler thread!"), "This is not a handler thread!", new Object[0]);
  }
  
  public final void cancel() {}
  
  public final String getType()
  {
    return Thread.currentThread().toString();
  }
  
  public final void j(Runnable paramRunnable, long paramLong)
  {
    a.w("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
    paramRunnable.run();
  }
  
  public final void k(Runnable paramRunnable)
  {
    a.w("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
    paramRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.c
 * JD-Core Version:    0.7.0.1
 */