package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class i
{
  private static volatile i.a Kmy;
  public static ExecutorService THREAD_POOL_EXECUTOR;
  private static volatile ScheduledExecutorService mScheduler;
  
  static
  {
    AppMethodBeat.i(188263);
    THREAD_POOL_EXECUTOR = Executors.newCachedThreadPool();
    mScheduler = null;
    Kmy = null;
    AppMethodBeat.o(188263);
  }
  
  public static ScheduledExecutorService getScheduledExecutorServiceInstance()
  {
    AppMethodBeat.i(188262);
    if (mScheduler == null) {}
    try
    {
      if (mScheduler == null) {
        mScheduler = Executors.newScheduledThreadPool(4);
      }
      ScheduledExecutorService localScheduledExecutorService = mScheduler;
      AppMethodBeat.o(188262);
      return localScheduledExecutorService;
    }
    finally
    {
      AppMethodBeat.o(188262);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.i
 * JD-Core Version:    0.7.0.1
 */