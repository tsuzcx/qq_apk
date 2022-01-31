package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class Vending$5
  extends Handler
{
  Vending$5(Vending paramVending, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (Vending.i)paramMessage.obj;
    Vending.a(this.wta, paramMessage.a, paramMessage.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending.5
 * JD-Core Version:    0.7.0.1
 */