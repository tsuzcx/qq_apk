package com.tencent.mm.ui.g.b;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static b Qjs = null;
  
  public static void a(b paramb)
  {
    Qjs = paramb;
  }
  
  public static Drawable nl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(142752);
    if (Qjs != null)
    {
      paramString1 = Qjs.fP(paramString1, paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.g.b.c
 * JD-Core Version:    0.7.0.1
 */