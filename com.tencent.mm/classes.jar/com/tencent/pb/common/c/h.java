package com.tencent.pb.common.c;

import android.os.Handler;
import android.os.Looper;

public final class h
{
  public static Handler sHandler = new Handler(Looper.getMainLooper());
  
  public static void aA(Runnable paramRunnable)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramRunnable.run();
      return;
    }
    sHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.c.h
 * JD-Core Version:    0.7.0.1
 */