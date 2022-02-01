package com.tencent.mm.ui.f.b;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static b IIB = null;
  
  public static void a(b paramb)
  {
    IIB = paramb;
  }
  
  public static Drawable lR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(142752);
    if (IIB != null)
    {
      paramString1 = IIB.fj(paramString1, paramString2);
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