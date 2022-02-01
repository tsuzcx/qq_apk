package com.tencent.mm.ui.f.a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static b KzH = null;
  
  public static void a(b paramb)
  {
    KzH = paramb;
  }
  
  public static void c(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(142751);
    if (KzH != null) {
      KzH.c(paramImageView, paramString);
    }
    AppMethodBeat.o(142751);
  }
  
  public static void d(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(164172);
    if (KzH != null) {
      KzH.d(paramImageView, paramString);
    }
    AppMethodBeat.o(164172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.f.a.a
 * JD-Core Version:    0.7.0.1
 */