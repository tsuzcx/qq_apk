package com.tencent.mm.ui.g.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static a Qjt = null;
  
  public static CharSequence a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(159255);
    if (Qjt != null)
    {
      paramContext = Qjt.a(paramContext, paramCharSequence, paramInt);
      AppMethodBeat.o(159255);
      return paramContext;
    }
    AppMethodBeat.o(159255);
    return paramCharSequence;
  }
  
  public static void a(a parama)
  {
    Qjt = parama;
  }
  
  public static CharSequence c(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(159256);
    if (Qjt != null)
    {
      paramContext = Qjt.c(paramContext, paramCharSequence, paramFloat);
      AppMethodBeat.o(159256);
      return paramContext;
    }
    AppMethodBeat.o(159256);
    return paramCharSequence;
  }
  
  public static int db(String paramString, int paramInt)
  {
    AppMethodBeat.i(159257);
    if (Qjt != null)
    {
      paramInt = Qjt.db(paramString, paramInt);
      AppMethodBeat.o(159257);
      return paramInt;
    }
    AppMethodBeat.o(159257);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.g.c.b
 * JD-Core Version:    0.7.0.1
 */