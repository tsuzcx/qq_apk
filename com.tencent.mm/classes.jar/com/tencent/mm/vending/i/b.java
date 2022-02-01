package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static b LiY;
  public HandlerThread LiX;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(74943);
    LiY = new b();
    AppMethodBeat.o(74943);
  }
  
  private b()
  {
    AppMethodBeat.i(74942);
    this.LiX = new HandlerThread("Vending-LogicThread");
    this.LiX.start();
    this.mHandler = new Handler(this.LiX.getLooper());
    AppMethodBeat.o(74942);
  }
  
  public static b fOl()
  {
    return LiY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.i.b
 * JD-Core Version:    0.7.0.1
 */