package com.tencent.mm.ui.f.b;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static b KzI = null;
  
  public static void a(b paramb)
  {
    KzI = paramb;
  }
  
  public static Drawable mq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(142752);
    if (KzI != null)
    {
      paramString1 = KzI.ft(paramString1, paramString2);
      if ((paramString1 instanceof Drawable))
      {
        paramString1 = (Drawable)paramString1;
        AppMethodBeat.o(142752);
        return paramString1;
      }
      AppMethodBeat.o(142752);
      return null;
    }
    AppMethodBeat.o(142752);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.f.b.c
 * JD-Core Version:    0.7.0.1
 */