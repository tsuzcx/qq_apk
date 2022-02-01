package com.tencent.mm.ui.f.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static a Hij = null;
  
  public static void a(a parama)
  {
    Hij = parama;
  }
  
  public static CharSequence c(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(159256);
    if (Hij != null)
    {
      paramContext = Hij.c(paramContext, paramCharSequence, paramFloat);
      AppMethodBeat.o(159256);
      return paramContext;
    }
    AppMethodBeat.o(159256);
    return paramCharSequence;
  }
  
  public static int cJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(159257);
    if (Hij != null)
    {
      paramInt = Hij.cJ(paramString, paramInt);
      AppMethodBeat.o(159257);
      return paramInt;
    }
    AppMethodBeat.o(159257);
    return paramInt;
  }
  
  public static CharSequence g(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(159255);
    if (Hij != null)
    {
      paramContext = Hij.i(paramCharSequence, paramInt);
      AppMethodBeat.o(159255);
      return paramContext;
    }
    AppMethodBeat.o(159255);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.f.c.b
 * JD-Core Version:    0.7.0.1
 */