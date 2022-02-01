package com.tencent.tmediacodec.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class e
{
  private static final ExecutorService ahUP;
  private static Handler ahUQ;
  private static final Handler mHandler;
  private static final HandlerThread mHandlerThread;
  
  static
  {
    AppMethodBeat.i(210829);
    mHandler = new Handler(Looper.getMainLooper());
    ahUP = Executors.newCachedThreadPool();
    HandlerThread localHandlerThread = new HandlerThread("com.tencent.tmediacodec-sub");
    mHandlerThread = localHandlerThread;
    localHandlerThread.start();
    ahUQ = new Handler(mHandlerThread.getLooper());
    AppMethodBeat.o(210829);
  }
  
  public static void br(Runnable paramRunnable)
  {
    AppMethodBeat.i(210821);
    ahUQ.post(paramRunnable);
    AppMethodBeat.o(210821);
  }
  
  public static void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(210814);
    ahUP.execute(paramRunnable);
    AppMethodBeat.o(210814);
  }
  
  public static void runOnSubThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(210808);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ahUP.execute(paramRunnable);
      AppMethodBeat.o(210808);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(210808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmediacodec.g.e
 * JD-Core Version:    0.7.0.1
 */