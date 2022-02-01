package com.tencent.threadpool.i;

import java.util.concurrent.Future;

public abstract class b
  implements e, j, Runnable
{
  private Future dBj;
  
  public final void c(Future paramFuture)
  {
    this.dBj = paramFuture;
  }
  
  public boolean cancel()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.dBj != null)
    {
      bool1 = bool2;
      if (!this.dBj.isDone()) {
        bool1 = this.dBj.cancel(false);
      }
    }
    return bool1;
  }
  
  public final boolean isDone()
  {
    if (this.dBj == null) {
      return false;
    }
    return this.dBj.isDone();
  }
  
  public boolean isLogging()
  {
    return true;
  }
  
  public final boolean jZt()
  {
    if ((this.dBj != null) && (!this.dBj.isDone())) {
      return this.dBj.cancel(true);
    }
    return false;
  }
  
  public final void jZu()
  {
    if ((this.dBj != null) && (!this.dBj.isCancelled())) {
      this.dBj.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.i.b
 * JD-Core Version:    0.7.0.1
 */