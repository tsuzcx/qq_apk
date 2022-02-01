package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

@SuppressLint({"HandlerLeak"})
final class c
  extends Handler
{
  private final Context IY;
  
  public c(b paramb, Context paramContext) {}
  
  public final void handleMessage(Message paramMessage)
  {
    int i;
    switch (paramMessage.what)
    {
    default: 
      i = paramMessage.what;
      Log.w("GoogleApiAvailability", 50 + "Don't know how to handle this message: " + i);
    }
    do
    {
      return;
      i = this.IZ.d(this.IY);
    } while (!this.IZ.bt(i));
    this.IZ.a(this.IY, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.c
 * JD-Core Version:    0.7.0.1
 */