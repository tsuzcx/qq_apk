package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  g Iob;
  public int Ioe;
  
  c(int paramInt, g paramg)
  {
    this.Ioe = paramInt;
    this.Iob = paramg;
  }
  
  private c(Context paramContext)
  {
    AppMethodBeat.i(195289);
    this.Iob = new g.a(paramContext, "recovery_crash_count").fkT();
    this.Ioe = Math.max(this.Iob.getInt("crash_count", 0), 0);
    AppMethodBeat.o(195289);
  }
  
  public static c hR(Context paramContext)
  {
    AppMethodBeat.i(195288);
    paramContext = new c(paramContext);
    AppMethodBeat.o(195288);
    return paramContext;
  }
  
  public final void save()
  {
    AppMethodBeat.i(195290);
    this.Iob.gn("crash_count", this.Ioe).fkU();
    AppMethodBeat.o(195290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.c
 * JD-Core Version:    0.7.0.1
 */