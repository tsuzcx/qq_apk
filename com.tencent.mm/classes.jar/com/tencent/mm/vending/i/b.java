package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static b APe;
  public HandlerThread a;
  private Handler b;
  
  static
  {
    AppMethodBeat.i(126146);
    APe = new b();
    AppMethodBeat.o(126146);
  }
  
  private b()
  {
    AppMethodBeat.i(126145);
    this.a = new HandlerThread("Vending-LogicThread");
    this.a.start();
    this.b = new Handler(this.a.getLooper());
    AppMethodBeat.o(126145);
  }
  
  public static b dQw()
  {
    return APe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.i.b
 * JD-Core Version:    0.7.0.1
 */