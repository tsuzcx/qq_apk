package com.tencent.mm.ui.i.b;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static b afuU = null;
  
  public static void a(b paramb)
  {
    afuU = paramb;
  }
  
  public static Drawable qd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(142752);
    if (afuU != null)
    {
      paramString1 = afuU.gH(paramString1, paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.i.b.c
 * JD-Core Version:    0.7.0.1
 */