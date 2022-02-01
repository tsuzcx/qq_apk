package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public int NBC;
  g NBz;
  
  c(int paramInt, g paramg)
  {
    this.NBC = paramInt;
    this.NBz = paramg;
  }
  
  private c(Context paramContext)
  {
    AppMethodBeat.i(193777);
    this.NBz = new g.a(paramContext, "recovery_crash_count").guE();
    this.NBC = Math.max(this.NBz.getInt("crash_count", 0), 0);
    AppMethodBeat.o(193777);
  }
  
  public static c iK(Context paramContext)
  {
    AppMethodBeat.i(193776);
    paramContext = new c(paramContext);
    AppMethodBeat.o(193776);
    return paramContext;
  }
  
  public final void save()
  {
    AppMethodBeat.i(193778);
    this.NBz.gL("crash_count", this.NBC).guF();
    AppMethodBeat.o(193778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.c
 * JD-Core Version:    0.7.0.1
 */