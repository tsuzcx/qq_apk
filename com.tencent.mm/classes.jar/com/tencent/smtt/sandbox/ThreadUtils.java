package com.tencent.smtt.sandbox;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ThreadUtils
{
  private static final Object sLock;
  private static Handler sUiThreadHandler;
  
  static
  {
    AppMethodBeat.i(53819);
    sLock = new Object();
    AppMethodBeat.o(53819);
  }
  
  private static Handler getUiThreadHandler()
  {
    AppMethodBeat.i(53817);
    synchronized (sLock)
    {
      if (sUiThreadHandler == null) {
        sUiThreadHandler = new Handler(Looper.getMainLooper());
      }
      Handler localHandler = sUiThreadHandler;
      AppMethodBeat.o(53817);
      return localHandler;
    }
  }
  
  public static void postOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(53818);
    getUiThreadHandler().post(paramRunnable);
    AppMethodBeat.o(53818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sandbox.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */