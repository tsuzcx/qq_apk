package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class f
{
  private static volatile f.a Mzr;
  public static ExecutorService THREAD_POOL_EXECUTOR;
  private static volatile ScheduledExecutorService mScheduler;
  
  static
  {
    AppMethodBeat.i(194860);
    THREAD_POOL_EXECUTOR = Executors.newCachedThreadPool();
    mScheduler = null;
    Mzr = null;
    AppMethodBeat.o(194860);
  }
  
  public static ScheduledExecutorService getScheduledExecutorServiceInstance()
  {
    AppMethodBeat.i(194859);
    if (mScheduler == null) {}
    try
    {
      if (mScheduler == null) {
        mScheduler = Executors.newScheduledThreadPool(4);
      }
      ScheduledExecutorService localScheduledExecutorService = mScheduler;
      AppMethodBeat.o(194859);
      return localScheduledExecutorService;
    }
    finally
    {
      AppMethodBeat.o(194859);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.f
 * JD-Core Version:    0.7.0.1
 */