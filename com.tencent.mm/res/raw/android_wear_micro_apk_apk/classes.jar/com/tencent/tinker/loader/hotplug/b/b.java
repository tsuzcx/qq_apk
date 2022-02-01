package com.tencent.tinker.loader.hotplug.b;

import android.os.Handler.Callback;
import android.os.Message;

final class b
  implements Handler.Callback, f
{
  private final c apa;
  private final Handler.Callback apc;
  private volatile boolean apd;
  
  b(c paramc, Handler.Callback paramCallback)
  {
    this.apa = paramc;
    this.apc = paramCallback;
    this.apd = false;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (this.apd) {
      return false;
    }
    this.apd = true;
    this.apa.handleMessage(paramMessage);
    if (this.apc != null) {}
    for (boolean bool = this.apc.handleMessage(paramMessage);; bool = false)
    {
      this.apd = false;
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.b.b
 * JD-Core Version:    0.7.0.1
 */