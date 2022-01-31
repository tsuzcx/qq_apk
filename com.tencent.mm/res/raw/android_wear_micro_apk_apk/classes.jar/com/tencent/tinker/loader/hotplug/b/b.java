package com.tencent.tinker.loader.hotplug.b;

import android.os.Handler.Callback;
import android.os.Message;

final class b
  implements Handler.Callback, f
{
  private final c alA;
  private final Handler.Callback alC;
  private volatile boolean alD;
  
  b(c paramc, Handler.Callback paramCallback)
  {
    this.alA = paramc;
    this.alC = paramCallback;
    this.alD = false;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (this.alD) {
      return false;
    }
    this.alD = true;
    this.alA.handleMessage(paramMessage);
    if (this.alC != null) {}
    for (boolean bool = this.alC.handleMessage(paramMessage);; bool = false)
    {
      this.alD = false;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.b.b
 * JD-Core Version:    0.7.0.1
 */