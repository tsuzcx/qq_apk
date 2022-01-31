package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class Vending$6
  extends Handler
{
  Vending$6(Vending paramVending, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      Vending.f(this.wta);
      return;
    }
    this.wta.destroyAsynchronous();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending.6
 * JD-Core Version:    0.7.0.1
 */