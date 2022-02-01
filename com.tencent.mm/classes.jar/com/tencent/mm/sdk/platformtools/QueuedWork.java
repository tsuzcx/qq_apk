package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Deprecated
class QueuedWork
{
  private static final ConcurrentLinkedQueue<Runnable> mPendingWorks;
  private static ExecutorService mSingleThreadExecutor;
  
  static
  {
    AppMethodBeat.i(156351);
    mPendingWorks = new ConcurrentLinkedQueue();
    mSingleThreadExecutor = null;
    AppMethodBeat.o(156351);
  }
  
  public static void add(Runnable paramRunnable)
  {
    AppMethodBeat.i(156349);
    mPendingWorks.add(paramRunnable);
    AppMethodBeat.o(156349);
  }
  
  public static boolean hasPendingWork()
  {
    AppMethodBeat.i(262810);
    if (!mPendingWorks.isEmpty())
    {
      AppMethodBeat.o(262810);
      return true;
    }
    AppMethodBeat.o(262810);
    return false;
  }
  
  public static void remove(Runnable paramRunnable)
  {
    AppMethodBeat.i(156350);
    mPendingWorks.remove(paramRunnable);
    AppMethodBeat.o(156350);
  }
  
  public static ExecutorService singleThreadExecutor()
  {
    AppMethodBeat.i(156348);
    try
    {
      if (mSingleThreadExecutor == null) {
        mSingleThreadExecutor = Executors.newSingleThreadExecutor();
      }
      ExecutorService localExecutorService = mSingleThreadExecutor;
      return localExecutorService;
    }
    finally
    {
      AppMethodBeat.o(156348);
    }
  }
  
  public static void waitToFinish()
  {
    AppMethodBeat.i(262809);
    for (;;)
    {
      Runnable localRunnable = (Runnable)mPendingWorks.poll();
      if (localRunnable == null) {
        break;
      }
      localRunnable.run();
    }
    AppMethodBeat.o(262809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.QueuedWork
 * JD-Core Version:    0.7.0.1
 */