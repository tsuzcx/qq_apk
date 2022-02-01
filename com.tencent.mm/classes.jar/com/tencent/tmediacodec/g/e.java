package com.tencent.tmediacodec.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class e
{
  private static final ExecutorService ZPO;
  private static Handler ZPP;
  private static final Handler mHandler;
  private static final HandlerThread mHandlerThread;
  
  static
  {
    AppMethodBeat.i(224715);
    mHandler = new Handler(Looper.getMainLooper());
    ZPO = Executors.newCachedThreadPool();
    HandlerThread localHandlerThread = new HandlerThread("com.tencent.tmediacodec-sub");
    mHandlerThread = localHandlerThread;
    localHandlerThread.start();
    ZPP = new Handler(mHandlerThread.getLooper());
    AppMethodBeat.o(224715);
  }
  
  public static void bi(Runnable paramRunnable)
  {
    AppMethodBeat.i(224712);
    ZPP.post(paramRunnable);
    AppMethodBeat.o(224712);
  }
  
  public static void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(224711);
    ZPO.execute(paramRunnable);
    AppMethodBeat.o(224711);
  }
  
  public static void runOnSubThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(224709);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ZPO.execute(paramRunnable);
      AppMethodBeat.o(224709);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(224709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmediacodec.g.e
 * JD-Core Version:    0.7.0.1
 */