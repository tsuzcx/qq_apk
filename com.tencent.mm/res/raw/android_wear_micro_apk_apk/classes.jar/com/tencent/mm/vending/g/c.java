package com.tencent.mm.vending.g;

public final class c
  extends d
{
  public c()
  {
    new Exception("This is not a handler thread!");
  }
  
  public final void a(Runnable paramRunnable, long paramLong)
  {
    paramRunnable.run();
  }
  
  public final void b(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.c
 * JD-Core Version:    0.7.0.1
 */