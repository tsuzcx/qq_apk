package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static b LFA;
  public HandlerThread LFz;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(74943);
    LFA = new b();
    AppMethodBeat.o(74943);
  }
  
  private b()
  {
    AppMethodBeat.i(74942);
    this.LFz = new HandlerThread("Vending-LogicThread");
    this.LFz.start();
    this.mHandler = new Handler(this.LFz.getLooper());
    AppMethodBeat.o(74942);
  }
  
  public static b fSG()
  {
    return LFA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.i.b
 * JD-Core Version:    0.7.0.1
 */