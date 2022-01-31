package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class Vending$6
  extends Handler
{
  Vending$6(Vending paramVending, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(126158);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(126158);
      return;
      Vending.f(this.ANV);
      AppMethodBeat.o(126158);
      return;
      this.ANV.destroyAsynchronous();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending.6
 * JD-Core Version:    0.7.0.1
 */