package com.tencent.mm.plugin.y;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public final SparseArray<b> yQS;
  
  static
  {
    AppMethodBeat.i(151584);
    yQR = new c("INSTANCE");
    yQT = new c[] { yQR };
    AppMethodBeat.o(151584);
  }
  
  private c()
  {
    AppMethodBeat.i(151582);
    this.yQS = new SparseArray();
    AppMethodBeat.o(151582);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(151583);
    this.yQS.put(paramb.getType(), paramb);
    AppMethodBeat.o(151583);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.y.c
 * JD-Core Version:    0.7.0.1
 */