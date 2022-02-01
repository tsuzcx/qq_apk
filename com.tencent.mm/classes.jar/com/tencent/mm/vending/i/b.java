package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static b YBg;
  public HandlerThread YBf;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(74943);
    YBg = new b();
    AppMethodBeat.o(74943);
  }
  
  private b()
  {
    AppMethodBeat.i(74942);
    this.YBf = new HandlerThread("Vending-LogicThread");
    this.YBf.start();
    this.mHandler = new Handler(this.YBf.getLooper());
    AppMethodBeat.o(74942);
  }
  
  public static b ieS()
  {
    return YBg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vending.i.b
 * JD-Core Version:    0.7.0.1
 */