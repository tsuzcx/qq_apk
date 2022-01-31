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
    AppMethodBeat.i(118111);
    mHandler = new Handler(Looper.getMainLooper());
    mExecutorService = Executors.newFixedThreadPool(3);
    AppMethodBeat.o(118111);
  }
  
  public static <T> Future<T> runOnSubThread(Callable<T> paramCallable)
  {
    AppMethodBeat.i(118109);
    paramCallable = mExecutorService.submit(new YTThreadOperate.2(paramCallable));
    AppMethodBeat.o(118109);
    return paramCallable;
  }
  
  public static void runOnSubThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(118108);
    mExecutorService.submit(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(118102);
        this.val$runnable.run();
        AppMethodBeat.o(118102);
      }
    });
    AppMethodBeat.o(118108);
  }
  
  public static <T> void runOnSubThread(Callable<T> paramCallable, YTThreadOperate.UiThreadCallback<T> paramUiThreadCallback)
  {
    AppMethodBeat.i(118110);
    mExecutorService.submit(new YTThreadOperate.3(paramCallable, paramUiThreadCallback));
    AppMethodBeat.o(118110);
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(118106);
    mHandler.post(paramRunnable);
    AppMethodBeat.o(118106);
  }
  
  public static void runOnUiThreadDelay(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(118107);
    mHandler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(118107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTThreadOperate
 * JD-Core Version:    0.7.0.1
 */