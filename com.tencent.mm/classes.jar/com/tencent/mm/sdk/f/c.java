package com.tencent.mm.sdk.f;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static void a(MessageQueue.IdleHandler paramIdleHandler)
  {
    AppMethodBeat.i(153464);
    if (Build.VERSION.SDK_INT >= 23)
    {
      Looper.getMainLooper().getQueue().addIdleHandler(paramIdleHandler);
      AppMethodBeat.o(153464);
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Looper.myQueue().addIdleHandler(paramIdleHandler);
      AppMethodBeat.o(153464);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(153463);
        Looper.myQueue().addIdleHandler(this.EYJ);
        AppMethodBeat.o(153463);
      }
    });
    AppMethodBeat.o(153464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.f.c
 * JD-Core Version:    0.7.0.1
 */