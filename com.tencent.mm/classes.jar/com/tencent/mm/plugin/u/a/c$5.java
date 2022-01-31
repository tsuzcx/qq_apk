package com.tencent.mm.plugin.u.a;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$5
  extends SparseIntArray
{
  c$5()
  {
    AppMethodBeat.i(80761);
    put(2, 1012);
    put(1, 1013);
    AppMethodBeat.o(80761);
  }
  
  public final int get(int paramInt)
  {
    AppMethodBeat.i(80762);
    paramInt = super.get(paramInt, 1011);
    AppMethodBeat.o(80762);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a.c.5
 * JD-Core Version:    0.7.0.1
 */