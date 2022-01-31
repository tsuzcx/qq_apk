package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h
  extends Thread
{
  h(Context paramContext, String paramString, ValueCallback paramValueCallback) {}
  
  public final void run()
  {
    AppMethodBeat.i(63986);
    bz localbz = bz.a();
    localbz.a(this.a, null);
    boolean bool = false;
    if (localbz.b()) {
      bool = localbz.c().a(this.a, this.b);
    }
    new Handler(Looper.getMainLooper()).post(new i(this, bool));
    AppMethodBeat.o(63986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sdk.h
 * JD-Core Version:    0.7.0.1
 */