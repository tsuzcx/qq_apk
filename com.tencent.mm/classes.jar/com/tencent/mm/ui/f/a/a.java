package com.tencent.mm.ui.f.a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static b AnD = null;
  
  public static void a(b paramb)
  {
    AnD = paramb;
  }
  
  public static void c(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(107321);
    if (AnD != null) {
      AnD.c(paramImageView, paramString);
    }
    AppMethodBeat.o(107321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.f.a.a
 * JD-Core Version:    0.7.0.1
 */