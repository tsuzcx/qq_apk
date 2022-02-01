package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class i
  extends ReentrantReadWriteLock
{
  public Condition ahNi;
  
  public i()
  {
    AppMethodBeat.i(227059);
    this.ahNi = writeLock().newCondition();
    AppMethodBeat.o(227059);
  }
  
  public final boolean Bj(long paramLong)
  {
    AppMethodBeat.i(227065);
    boolean bool2 = false;
    int i = 3;
    for (;;)
    {
      i -= 1;
      boolean bool1 = bool2;
      if (i >= 0) {}
      try
      {
        bool1 = this.ahNi.await(500L, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(227065);
        return bool1;
      }
      catch (InterruptedException localInterruptedException)
      {
        g.e("TPReadWriteLock", localInterruptedException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.i
 * JD-Core Version:    0.7.0.1
 */