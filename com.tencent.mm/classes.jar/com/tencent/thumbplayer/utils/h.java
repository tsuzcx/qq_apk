package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class h
  extends ReentrantReadWriteLock
{
  public Condition Kmx;
  
  public h()
  {
    AppMethodBeat.i(188260);
    this.Kmx = writeLock().newCondition();
    AppMethodBeat.o(188260);
  }
  
  public final boolean fGz()
  {
    AppMethodBeat.i(188261);
    boolean bool2 = false;
    int i = 3;
    for (;;)
    {
      i -= 1;
      boolean bool1 = bool2;
      if (i >= 0) {}
      try
      {
        bool1 = this.Kmx.await(500L, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(188261);
        return bool1;
      }
      catch (InterruptedException localInterruptedException)
      {
        f.e("TPReadWriteLock", localInterruptedException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.h
 * JD-Core Version:    0.7.0.1
 */