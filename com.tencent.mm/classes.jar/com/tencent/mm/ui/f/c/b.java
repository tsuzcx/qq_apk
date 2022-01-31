package com.tencent.mm.ui.f.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static a AnF = null;
  
  public static void a(a parama)
  {
    AnF = parama;
  }
  
  public static int bW(String paramString, int paramInt)
  {
    AppMethodBeat.i(112573);
    if (AnF != null)
    {
      paramInt = AnF.bW(paramString, paramInt);
      AppMethodBeat.o(112573);
      return paramInt;
    }
    AppMethodBeat.o(112573);
    return paramInt;
  }
  
  public static CharSequence c(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(112572);
    if (AnF != null)
    {
      paramContext = AnF.c(paramContext, paramCharSequence, paramFloat);
      AppMethodBeat.o(112572);
      return paramContext;
    }
    AppMethodBeat.o(112572);
    return paramCharSequence;
  }
  
  public static CharSequence h(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(112571);
    if (AnF != null)
    {
      paramContext = AnF.h(paramCharSequence, paramInt);
      AppMethodBeat.o(112571);
      return paramContext;
    }
    AppMethodBeat.o(112571);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.f.c.b
 * JD-Core Version:    0.7.0.1
 */