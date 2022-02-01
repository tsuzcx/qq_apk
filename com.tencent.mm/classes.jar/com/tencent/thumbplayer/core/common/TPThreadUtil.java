package com.tencent.thumbplayer.core.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TPThreadUtil
{
  public static ExecutorService THREAD_POOL_EXECUTOR;
  private static volatile EventHandler mMainThreadHandler;
  private static volatile ScheduledExecutorService mScheduler;
  
  static
  {
    AppMethodBeat.i(220511);
    THREAD_POOL_EXECUTOR = Executors.newCachedThreadPool();
    mScheduler = null;
    mMainThreadHandler = null;
    AppMethodBeat.o(220511);
  }
  
  private static void getMainThreadHandler()
  {
    AppMethodBeat.i(220505);
    if (mMainThreadHandler == null) {
      try
      {
        if (mMainThreadHandler == null)
        {
          localObject1 = Looper.getMainLooper();
          if (localObject1 != null) {
            mMainThreadHandler = new EventHandler((Looper)localObject1);
          }
        }
        else
        {
          return;
        }
        mMainThreadHandler = null;
        Object localObject1 = new IllegalStateException("cannot get thread looper");
        AppMethodBeat.o(220505);
        throw ((Throwable)localObject1);
      }
      finally
      {
        AppMethodBeat.o(220505);
      }
    }
    AppMethodBeat.o(220505);
  }
  
  public static ScheduledExecutorService getScheduledExecutorServiceInstance()
  {
    AppMethodBeat.i(220504);
    if (mScheduler == null) {}
    try
    {
      if (mScheduler == null) {
        mScheduler = Executors.newScheduledThreadPool(4);
      }
      ScheduledExecutorService localScheduledExecutorService = mScheduler;
      AppMethodBeat.o(220504);
      return localScheduledExecutorService;
    }
    finally
    {
      AppMethodBeat.o(220504);
    }
  }
  
  public static void postDelayRunnableOnMainThread(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(220508);
    getMainThreadHandler();
    if (mMainThreadHandler != null) {
      mMainThreadHandler.postDelayed(paramRunnable, paramLong);
    }
    AppMethodBeat.o(220508);
  }
  
  public static void postRunnableOnMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(220507);
    getMainThreadHandler();
    if (mMainThreadHandler != null) {
      mMainThreadHandler.post(paramRunnable);
    }
    AppMethodBeat.o(220507);
  }
  
  public static void postRunnableOnMainThreadFront(Runnable paramRunnable)
  {
    AppMethodBeat.i(220506);
    getMainThreadHandler();
    if (mMainThreadHandler != null) {
      mMainThreadHandler.postAtFrontOfQueue(paramRunnable);
    }
    AppMethodBeat.o(220506);
  }
  
  public static void sendMessage(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(220509);
    if (paramHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      paramHandler.sendMessage(localMessage);
    }
    AppMethodBeat.o(220509);
  }
  
  public static void sendMessageDelay(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(220510);
    if (paramHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      paramHandler.sendMessageDelayed(localMessage, paramLong);
    }
    AppMethodBeat.o(220510);
  }
  
  static class EventHandler
    extends Handler
  {
    EventHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPThreadUtil
 * JD-Core Version:    0.7.0.1
 */