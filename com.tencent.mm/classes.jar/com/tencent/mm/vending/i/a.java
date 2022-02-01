package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a agvB;
  public HandlerThread agvA;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(74941);
    agvB = new a();
    AppMethodBeat.o(74941);
  }
  
  private a()
  {
    AppMethodBeat.i(74940);
    this.agvA = new HandlerThread("Vending-HeavyWorkThread", 10);
    this.agvA.start();
    this.mHandler = new Handler(this.agvA.getLooper());
    AppMethodBeat.o(74940);
  }
  
  public static a jJY()
  {
    return agvB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vending.i.a
 * JD-Core Version:    0.7.0.1
 */