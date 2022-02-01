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
    AppMethodBeat.i(227723);
    THREAD_POOL_EXECUTOR = Executors.newCachedThreadPool();
    mScheduler = null;
    mMainThreadHandler = null;
    AppMethodBeat.o(227723);
  }
  
  private static void getMainThreadHandler()
  {
    AppMethodBeat.i(227693);
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
        AppMethodBeat.o(227693);
        throw ((Throwable)localObject1);
      }
      finally
      {
        AppMethodBeat.o(227693);
      }
    }
    AppMethodBeat.o(227693);
  }
  
  public static ScheduledExecutorService getScheduledExecutorServiceInstance()
  {
    AppMethodBeat.i(227686);
    if (mScheduler == null) {}
    try
    {
      if (mScheduler == null) {
        mScheduler = Executors.newScheduledThreadPool(4);
      }
      ScheduledExecutorService localScheduledExecutorService = mScheduler;
      AppMethodBeat.o(227686);
      return localScheduledExecutorService;
    }
    finally
    {
      AppMethodBeat.o(227686);
    }
  }
  
  public static void postDelayRunnableOnMainThread(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(227712);
    getMainThreadHandler();
    if (mMainThreadHandler != null) {
      mMainThreadHandler.postDelayed(paramRunnable, paramLong);
    }
    AppMethodBeat.o(227712);
  }
  
  public static void postRunnableOnMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(227705);
    getMainThreadHandler();
    if (mMainThreadHandler != null) {
      mMainThreadHandler.post(paramRunnable);
    }
    AppMethodBeat.o(227705);
  }
  
  public static void postRunnableOnMainThreadFront(Runnable paramRunnable)
  {
    AppMethodBeat.i(227699);
    getMainThreadHandler();
    if (mMainThreadHandler != null) {
      mMainThreadHandler.postAtFrontOfQueue(paramRunnable);
    }
    AppMethodBeat.o(227699);
  }
  
  public static void sendMessage(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(227714);
    if (paramHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      paramHandler.sendMessage(localMessage);
    }
    AppMethodBeat.o(227714);
  }
  
  public static void sendMessageDelay(Handler paramHandler, int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(227719);
    if (paramHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      paramHandler.sendMessageDelayed(localMessage, paramLong);
    }
    AppMethodBeat.o(227719);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPThreadUtil
 * JD-Core Version:    0.7.0.1
 */