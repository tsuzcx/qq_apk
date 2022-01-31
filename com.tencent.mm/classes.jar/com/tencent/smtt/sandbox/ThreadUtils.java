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
    AppMethodBeat.i(139040);
    sLock = new Object();
    AppMethodBeat.o(139040);
  }
  
  private static Handler getUiThreadHandler()
  {
    AppMethodBeat.i(139038);
    synchronized (sLock)
    {
      if (sUiThreadHandler == null) {
        sUiThreadHandler = new Handler(Looper.getMainLooper());
      }
      Handler localHandler = sUiThreadHandler;
      AppMethodBeat.o(139038);
      return localHandler;
    }
  }
  
  public static void postOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(139039);
    getUiThreadHandler().post(paramRunnable);
    AppMethodBeat.o(139039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sandbox.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */