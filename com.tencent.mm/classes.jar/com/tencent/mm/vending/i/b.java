package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static b HQY;
  public HandlerThread HQX;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(74943);
    HQY = new b();
    AppMethodBeat.o(74943);
  }
  
  private b()
  {
    AppMethodBeat.i(74942);
    this.HQX = new HandlerThread("Vending-LogicThread");
    this.HQX.start();
    this.mHandler = new Handler(this.HQX.getLooper());
    AppMethodBeat.o(74942);
  }
  
  public static b fhw()
  {
    return HQY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.i.b
 * JD-Core Version:    0.7.0.1
 */