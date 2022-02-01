package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static b agvD;
  public HandlerThread agvC;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(74943);
    agvD = new b();
    AppMethodBeat.o(74943);
  }
  
  private b()
  {
    AppMethodBeat.i(74942);
    this.agvC = new HandlerThread("Vending-LogicThread");
    this.agvC.start();
    this.mHandler = new Handler(this.agvC.getLooper());
    AppMethodBeat.o(74942);
  }
  
  public static b jJZ()
  {
    return agvD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vending.i.b
 * JD-Core Version:    0.7.0.1
 */