package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

public final class b
{
  public Handler mMainHandler = new Handler(Looper.getMainLooper());
  WeakReference<com.tencent.toybrick.b.b> xbv;
  public Runnable xbw;
  
  public b(com.tencent.toybrick.b.b paramb)
  {
    this.xbv = new WeakReference(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.toybrick.e.b
 * JD-Core Version:    0.7.0.1
 */