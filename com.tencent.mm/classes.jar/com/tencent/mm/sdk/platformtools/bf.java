package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Deprecated
class bf
{
  private static final ConcurrentLinkedQueue<Runnable> EWv;
  private static ExecutorService EWw;
  
  static
  {
    AppMethodBeat.i(156351);
    EWv = new ConcurrentLinkedQueue();
    EWw = null;
    AppMethodBeat.o(156351);
  }
  
  public static void aA(Runnable paramRunnable)
  {
    AppMethodBeat.i(156349);
    EWv.add(paramRunnable);
    AppMethodBeat.o(156349);
  }
  
  public static void aB(Runnable paramRunnable)
  {
    AppMethodBeat.i(156350);
    EWv.remove(paramRunnable);
    AppMethodBeat.o(156350);
  }
  
  public static ExecutorService eGn()
  {
    AppMethodBeat.i(156348);
    try
    {
      if (EWw == null) {
        EWw = Executors.newSingleThreadExecutor();
      }
      ExecutorService localExecutorService = EWw;
      return localExecutorService;
    }
    finally
    {
      AppMethodBeat.o(156348);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bf
 * JD-Core Version:    0.7.0.1
 */