package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  h UPc;
  int UPf;
  
  c(int paramInt, h paramh)
  {
    this.UPf = paramInt;
    this.UPc = paramh;
  }
  
  private c(Context paramContext)
  {
    AppMethodBeat.i(189971);
    this.UPc = new h.a(paramContext, "recovery_crash_count").hqf();
    this.UPf = Math.max(this.UPc.getInt("crash_count", 0), 0);
    AppMethodBeat.o(189971);
  }
  
  public static c jN(Context paramContext)
  {
    AppMethodBeat.i(189966);
    paramContext = new c(paramContext);
    AppMethodBeat.o(189966);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.c
 * JD-Core Version:    0.7.0.1
 */