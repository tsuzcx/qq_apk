package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static a LiW;
  public HandlerThread LiV;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(74941);
    LiW = new a();
    AppMethodBeat.o(74941);
  }
  
  private a()
  {
    AppMethodBeat.i(74940);
    this.LiV = new HandlerThread("Vending-HeavyWorkThread", 10);
    this.LiV.start();
    this.mHandler = new Handler(this.LiV.getLooper());
    AppMethodBeat.o(74940);
  }
  
  public static a fOk()
  {
    return LiW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.i.a
 * JD-Core Version:    0.7.0.1
 */