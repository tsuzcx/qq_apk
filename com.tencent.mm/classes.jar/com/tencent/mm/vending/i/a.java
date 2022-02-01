package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a Jrr;
  public HandlerThread Jrq;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(74941);
    Jrr = new a();
    AppMethodBeat.o(74941);
  }
  
  private a()
  {
    AppMethodBeat.i(74940);
    this.Jrq = new HandlerThread("Vending-HeavyWorkThread", 10);
    this.Jrq.start();
    this.mHandler = new Handler(this.Jrq.getLooper());
    AppMethodBeat.o(74940);
  }
  
  public static a fxx()
  {
    return Jrr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.i.a
 * JD-Core Version:    0.7.0.1
 */