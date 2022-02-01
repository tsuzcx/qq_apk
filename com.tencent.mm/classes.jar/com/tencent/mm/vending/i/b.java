package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static b Jrt;
  public HandlerThread Jrs;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(74943);
    Jrt = new b();
    AppMethodBeat.o(74943);
  }
  
  private b()
  {
    AppMethodBeat.i(74942);
    this.Jrs = new HandlerThread("Vending-LogicThread");
    this.Jrs.start();
    this.mHandler = new Handler(this.Jrs.getLooper());
    AppMethodBeat.o(74942);
  }
  
  public static b fxy()
  {
    return Jrt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.i.b
 * JD-Core Version:    0.7.0.1
 */