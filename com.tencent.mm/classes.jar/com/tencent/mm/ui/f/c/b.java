package com.tencent.mm.ui.f.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static a KzJ = null;
  
  public static void a(a parama)
  {
    KzJ = parama;
  }
  
  public static CharSequence c(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(159256);
    if (KzJ != null)
    {
      paramContext = KzJ.c(paramContext, paramCharSequence, paramFloat);
      AppMethodBeat.o(159256);
      return paramContext;
    }
    AppMethodBeat.o(159256);
    return paramCharSequence;
  }
  
  public static int cR(String paramString, int paramInt)
  {
    AppMethodBeat.i(159257);
    if (KzJ != null)
    {
      paramInt = KzJ.cR(paramString, paramInt);
      AppMethodBeat.o(159257);
      return paramInt;
    }
    AppMethodBeat.o(159257);
    return paramInt;
  }
  
  public static CharSequence h(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(159255);
    if (KzJ != null)
    {
      paramContext = KzJ.i(paramCharSequence, paramInt);
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