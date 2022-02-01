package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class i
  extends ReentrantReadWriteLock
{
  public Condition ZIf;
  
  public i()
  {
    AppMethodBeat.i(222303);
    this.ZIf = writeLock().newCondition();
    AppMethodBeat.o(222303);
  }
  
  public final boolean WW(long paramLong)
  {
    AppMethodBeat.i(222305);
    boolean bool2 = false;
    int i = 3;
    for (;;)
    {
      i -= 1;
      boolean bool1 = bool2;
      if (i >= 0) {}
      try
      {
        bool1 = this.ZIf.await(500L, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(222305);
        return bool1;
      }
      catch (InterruptedException localInterruptedException)
      {
        g.e("TPReadWriteLock", localInterruptedException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.i
 * JD-Core Version:    0.7.0.1
 */