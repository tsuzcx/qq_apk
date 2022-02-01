package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a YBe;
  public HandlerThread YBd;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(74941);
    YBe = new a();
    AppMethodBeat.o(74941);
  }
  
  private a()
  {
    AppMethodBeat.i(74940);
    this.YBd = new HandlerThread("Vending-HeavyWorkThread", 10);
    this.YBd.start();
    this.mHandler = new Handler(this.YBd.getLooper());
    AppMethodBeat.o(74940);
  }
  
  public static a ieR()
  {
    return YBe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vending.i.a
 * JD-Core Version:    0.7.0.1
 */