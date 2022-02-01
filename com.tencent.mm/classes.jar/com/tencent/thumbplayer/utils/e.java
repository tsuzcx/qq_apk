package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class e
  extends ReentrantReadWriteLock
{
  public Condition Mcv;
  
  public e()
  {
    AppMethodBeat.i(192179);
    this.Mcv = writeLock().newCondition();
    AppMethodBeat.o(192179);
  }
  
  public final boolean fXL()
  {
    AppMethodBeat.i(192180);
    boolean bool2 = false;
    int i = 3;
    for (;;)
    {
      i -= 1;
      boolean bool1 = bool2;
      if (i >= 0) {}
      try
      {
        bool1 = this.Mcv.await(500L, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(192180);
        return bool1;
      }
      catch (InterruptedException localInterruptedException)
      {
        d.e("TPReadWriteLock", localInterruptedException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.e
 * JD-Core Version:    0.7.0.1
 */