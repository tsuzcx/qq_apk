package com.tencent.youtu.ytcommon.tools;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class YTThreadOperate
{
  private static ExecutorService mExecutorService;
  private static Handler mHandler;
  
  static
  {
    AppMethodBeat.i(73401);
    mHandler = new Handler(Looper.getMainLooper());
    mExecutorService = Executors.newFixedThreadPool(3);
    AppMethodBeat.o(73401);
  }
  
  public static <T> Future<T> runOnSubThread(Callable<T> paramCallable)
  {
    AppMethodBeat.i(73399);
    paramCallable = mExecutorService.submit(new Callable()
    {
      public final T call()
      {
        AppMethodBeat.i(73393);
        try
        {
          Object localObject = this.val$runnable.call();
          AppMethodBeat.o(73393);
          return localObject;
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(73393);
        }
        return null;
      }
    });
    AppMethodBeat.o(73399);
    return paramCallable;
  }
  
  public static void runOnSubThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(73398);
    mExecutorService.submit(new YTThreadOperate.1(paramRunnable));
    AppMethodBeat.o(73398);
  }
  
  public static <T> void runOnSubThread(Callable<T> paramCallable, final UiThreadCallback<T> paramUiThreadCallback)
  {
    AppMethodBeat.i(73400);
    mExecutorService.submit(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(73395);
        final Object localObject1 = null;
        try
        {
          Object localObject2 = this.val$callable.call();
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          label19:
          break label19;
        }
        YTThreadOperate.mHandler.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(73394);
            if (YTThreadOperate.3.this.val$uiCallback != null) {
              try
              {
                YTThreadOperate.3.this.val$uiCallback.callback(localObject1);
                AppMethodBeat.o(73394);
                return;
              }
              catch (Exception localException)
              {
                YTException.report(localException);
              }
            }
            AppMethodBeat.o(73394);
          }
        });
        AppMethodBeat.o(73395);
      }
    });
    AppMethodBeat.o(73400);
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(73396);
    mHandler.post(paramRunnable);
    AppMethodBeat.o(73396);
  }
  
  public static void runOnUiThreadDelay(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(73397);
    mHandler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(73397);
  }
  
  public static abstract interface UiThreadCallback<T>
  {
    public abstract void callback(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTThreadOperate
 * JD-Core Version:    0.7.0.1
 */