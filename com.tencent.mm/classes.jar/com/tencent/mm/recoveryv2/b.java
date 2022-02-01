package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  final f acjT;
  public int acjW;
  
  b(int paramInt, f paramf)
  {
    this.acjW = paramInt;
    this.acjT = paramf;
  }
  
  b(f paramf)
  {
    AppMethodBeat.i(237916);
    this.acjT = paramf;
    reload();
    AppMethodBeat.o(237916);
  }
  
  public static b lN(Context paramContext)
  {
    AppMethodBeat.i(237912);
    paramContext = new b(g.lP(paramContext).iQF());
    AppMethodBeat.o(237912);
    return paramContext;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(237929);
    this.acjW = Math.max(this.acjT.getInt("crash_count", 0), 0);
    AppMethodBeat.o(237929);
  }
  
  public final void sz()
  {
    AppMethodBeat.i(237932);
    this.acjT.iC("crash_count", this.acjW).iQG();
    AppMethodBeat.o(237932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.b
 * JD-Core Version:    0.7.0.1
 */