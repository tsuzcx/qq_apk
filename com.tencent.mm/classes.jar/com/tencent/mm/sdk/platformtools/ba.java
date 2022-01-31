package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Deprecated
class ba
{
  private static final ConcurrentLinkedQueue<Runnable> ypH;
  private static ExecutorService ypI;
  
  static
  {
    AppMethodBeat.i(93590);
    ypH = new ConcurrentLinkedQueue();
    ypI = null;
    AppMethodBeat.o(93590);
  }
  
  public static void ag(Runnable paramRunnable)
  {
    AppMethodBeat.i(93588);
    ypH.add(paramRunnable);
    AppMethodBeat.o(93588);
  }
  
  public static void ah(Runnable paramRunnable)
  {
    AppMethodBeat.i(93589);
    ypH.remove(paramRunnable);
    AppMethodBeat.o(93589);
  }
  
  public static ExecutorService dtx()
  {
    AppMethodBeat.i(93587);
    try
    {
      if (ypI == null) {
        ypI = Executors.newSingleThreadExecutor();
      }
      ExecutorService localExecutorService = ypI;
      return localExecutorService;
    }
    finally
    {
      AppMethodBeat.o(93587);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ba
 * JD-Core Version:    0.7.0.1
 */