package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  g HTT;
  public int HTW;
  
  c(int paramInt, g paramg)
  {
    this.HTW = paramInt;
    this.HTT = paramg;
  }
  
  private c(Context paramContext)
  {
    AppMethodBeat.i(206981);
    this.HTT = new g.a(paramContext, "recovery_crash_count").fhb();
    this.HTW = Math.max(this.HTT.getInt("crash_count", 0), 0);
    AppMethodBeat.o(206981);
  }
  
  public static c hL(Context paramContext)
  {
    AppMethodBeat.i(206980);
    paramContext = new c(paramContext);
    AppMethodBeat.o(206980);
    return paramContext;
  }
  
  public final void save()
  {
    AppMethodBeat.i(206982);
    this.HTT.ge("crash_count", this.HTW).fhc();
    AppMethodBeat.o(206982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.c
 * JD-Core Version:    0.7.0.1
 */