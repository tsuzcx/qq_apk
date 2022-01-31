package com.tencent.mm.plugin.w;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public final SparseArray<b> qSc;
  
  static
  {
    AppMethodBeat.i(79173);
    qSb = new c("INSTANCE");
    qSd = new c[] { qSb };
    AppMethodBeat.o(79173);
  }
  
  private c()
  {
    AppMethodBeat.i(79171);
    this.qSc = new SparseArray();
    AppMethodBeat.o(79171);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(79172);
    this.qSc.put(paramb.getType(), paramb);
    AppMethodBeat.o(79172);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.w.c
 * JD-Core Version:    0.7.0.1
 */