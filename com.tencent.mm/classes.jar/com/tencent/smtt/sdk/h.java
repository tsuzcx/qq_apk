package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

final class h
  extends Thread
{
  h(Context paramContext, String paramString, ValueCallback paramValueCallback) {}
  
  public final void run()
  {
    bv localbv = bv.a();
    localbv.a(this.a, null);
    boolean bool = false;
    if (localbv.b()) {
      bool = localbv.c().a(this.a, this.b);
    }
    new Handler(Looper.getMainLooper()).post(new i(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.h
 * JD-Core Version:    0.7.0.1
 */