package com.tencent.mm.plugin.normsg;

import android.os.Looper;
import android.support.annotation.Keep;
import com.tencent.mm.sdk.g.d;

@Keep
public abstract class Normsg
{
  static {}
  
  private static final void initializeOnMainThread()
  {
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    Normsg.1 local1 = new Normsg.1(arrayOfBoolean);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local1.run();
      return;
    }
    d.h(local1, "NormsgInit").start();
    for (;;)
    {
      if (arrayOfBoolean[0] == 0) {}
      try
      {
        arrayOfBoolean.wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        continue;
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.Normsg
 * JD-Core Version:    0.7.0.1
 */