package com.tencent.mm.sdk.system;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LooperCompat
{
  public static void addMainLooperIdleHandler(MessageQueue.IdleHandler paramIdleHandler)
  {
    AppMethodBeat.i(153464);
    if (paramIdleHandler == null)
    {
      AppMethodBeat.o(153464);
      return;
    }
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
      public void run()
      {
        AppMethodBeat.i(153463);
        Looper.myQueue().addIdleHandler(LooperCompat.this);
        AppMethodBeat.o(153463);
      }
    });
    AppMethodBeat.o(153464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.system.LooperCompat
 * JD-Core Version:    0.7.0.1
 */