package com.tencent.mm.plugin.x;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public final SparseArray<b> DlT;
  
  static
  {
    AppMethodBeat.i(151584);
    DlS = new c("INSTANCE");
    DlU = new c[] { DlS };
    AppMethodBeat.o(151584);
  }
  
  private c()
  {
    AppMethodBeat.i(151582);
    this.DlT = new SparseArray();
    AppMethodBeat.o(151582);
  }
  
  public static boolean XE(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(151583);
    this.DlT.put(paramb.getType(), paramb);
    AppMethodBeat.o(151583);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.x.c
 * JD-Core Version:    0.7.0.1
 */