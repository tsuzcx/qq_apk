package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a APd;
  public HandlerThread a;
  private Handler b;
  
  static
  {
    AppMethodBeat.i(126144);
    APd = new a();
    AppMethodBeat.o(126144);
  }
  
  private a()
  {
    AppMethodBeat.i(126143);
    this.a = new HandlerThread("Vending-HeavyWorkThread", 10);
    this.a.start();
    this.b = new Handler(this.a.getLooper());
    AppMethodBeat.o(126143);
  }
  
  public static a dQv()
  {
    return APd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.i.a
 * JD-Core Version:    0.7.0.1
 */