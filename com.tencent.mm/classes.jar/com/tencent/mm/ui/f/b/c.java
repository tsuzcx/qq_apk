package com.tencent.mm.ui.f.b;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static b AnE = null;
  
  public static void a(b paramb)
  {
    AnE = paramb;
  }
  
  public static Drawable iB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(107322);
    if (AnE != null)
    {
      paramString1 = AnE.dJ(paramString1, paramString2);
      if ((paramString1 instanceof Drawable))
      {
        paramString1 = (Drawable)paramString1;
        AppMethodBeat.o(107322);
        return paramString1;
      }
      AppMethodBeat.o(107322);
      return null;
    }
    AppMethodBeat.o(107322);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.f.b.c
 * JD-Core Version:    0.7.0.1
 */