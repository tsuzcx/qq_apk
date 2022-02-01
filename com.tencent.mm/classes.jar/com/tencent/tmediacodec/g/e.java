package com.tencent.tmediacodec.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class e
{
  private static final ExecutorService Snd;
  private static Handler Sne;
  private static final Handler mHandler;
  private static final HandlerThread mHandlerThread;
  
  static
  {
    AppMethodBeat.i(190205);
    mHandler = new Handler(Looper.getMainLooper());
    Snd = Executors.newCachedThreadPool();
    HandlerThread localHandlerThread = new HandlerThread("com.tencent.tmediacodec-sub");
    mHandlerThread = localHandlerThread;
    localHandlerThread.start();
    Sne = new Handler(mHandlerThread.getLooper());
    AppMethodBeat.o(190205);
  }
  
  public static void bb(Runnable paramRunnable)
  {
    AppMethodBeat.i(190204);
    Sne.post(paramRunnable);
    AppMethodBeat.o(190204);
  }
  
  public static void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(190203);
    Snd.execute(paramRunnable);
    AppMethodBeat.o(190203);
  }
  
  public static void runOnSubThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(190202);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Snd.execute(paramRunnable);
      AppMethodBeat.o(190202);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(190202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmediacodec.g.e
 * JD-Core Version:    0.7.0.1
 */