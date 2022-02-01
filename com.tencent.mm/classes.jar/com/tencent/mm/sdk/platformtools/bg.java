package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Deprecated
class bg
{
  private static final ConcurrentLinkedQueue<Runnable> IzH;
  private static ExecutorService IzI;
  
  static
  {
    AppMethodBeat.i(156351);
    IzH = new ConcurrentLinkedQueue();
    IzI = null;
    AppMethodBeat.o(156351);
  }
  
  public static void aA(Runnable paramRunnable)
  {
    AppMethodBeat.i(156350);
    IzH.remove(paramRunnable);
    AppMethodBeat.o(156350);
  }
  
  public static void az(Runnable paramRunnable)
  {
    AppMethodBeat.i(156349);
    IzH.add(paramRunnable);
    AppMethodBeat.o(156349);
  }
  
  public static ExecutorService fpk()
  {
    AppMethodBeat.i(156348);
    try
    {
      if (IzI == null) {
        IzI = Executors.newSingleThreadExecutor();
      }
      ExecutorService localExecutorService = IzI;
      return localExecutorService;
    }
    finally
    {
      AppMethodBeat.o(156348);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bg
 * JD-Core Version:    0.7.0.1
 */