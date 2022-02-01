package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

final class CopyOnWriteFileSystem$b
{
  private static final HashSet<Long> LjE;
  
  static
  {
    AppMethodBeat.i(13067);
    LjE = new HashSet();
    AppMethodBeat.o(13067);
  }
  
  static void lock(long paramLong)
  {
    AppMethodBeat.i(13065);
    synchronized (LjE)
    {
      for (;;)
      {
        boolean bool = LjE.add(Long.valueOf(paramLong));
        if (bool) {
          break;
        }
        try
        {
          LjE.wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      AppMethodBeat.o(13065);
      return;
    }
  }
  
  static void unlock(long paramLong)
  {
    AppMethodBeat.i(13066);
    synchronized (LjE)
    {
      if (LjE.remove(Long.valueOf(paramLong))) {
        LjE.notifyAll();
      }
      AppMethodBeat.o(13066);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.CopyOnWriteFileSystem.b
 * JD-Core Version:    0.7.0.1
 */