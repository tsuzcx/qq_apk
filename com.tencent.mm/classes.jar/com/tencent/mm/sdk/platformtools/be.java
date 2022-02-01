package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Deprecated
class be
{
  private static final ConcurrentLinkedQueue<Runnable> GtH;
  private static ExecutorService GtI;
  
  static
  {
    AppMethodBeat.i(156351);
    GtH = new ConcurrentLinkedQueue();
    GtI = null;
    AppMethodBeat.o(156351);
  }
  
  public static void aC(Runnable paramRunnable)
  {
    AppMethodBeat.i(156349);
    GtH.add(paramRunnable);
    AppMethodBeat.o(156349);
  }
  
  public static void aD(Runnable paramRunnable)
  {
    AppMethodBeat.i(156350);
    GtH.remove(paramRunnable);
    AppMethodBeat.o(156350);
  }
  
  public static ExecutorService eVI()
  {
    AppMethodBeat.i(156348);
    try
    {
      if (GtI == null) {
        GtI = Executors.newSingleThreadExecutor();
      }
      ExecutorService localExecutorService = GtI;
      return localExecutorService;
    }
    finally
    {
      AppMethodBeat.o(156348);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.be
 * JD-Core Version:    0.7.0.1
 */