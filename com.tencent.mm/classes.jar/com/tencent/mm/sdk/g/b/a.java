package com.tencent.mm.sdk.g.b;

import java.util.concurrent.Executor;

public abstract interface a
  extends Executor
{
  public abstract int getCorePoolSize();
  
  public abstract void r(Runnable paramRunnable, long paramLong);
  
  public abstract boolean remove(Runnable paramRunnable);
  
  public abstract void reset();
  
  public abstract void shutdown();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.g.b.a
 * JD-Core Version:    0.7.0.1
 */