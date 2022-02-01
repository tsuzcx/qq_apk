package com.tencent.mm.ui.i.a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static b afuT = null;
  
  public static void a(b paramb)
  {
    afuT = paramb;
  }
  
  public static void g(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(142751);
    if (afuT != null) {
      afuT.g(paramImageView, paramString);
    }
    AppMethodBeat.o(142751);
  }
  
  public static void h(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(164172);
    if (afuT != null) {
      afuT.h(paramImageView, paramString);
    }
    AppMethodBeat.o(164172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.i.a.a
 * JD-Core Version:    0.7.0.1
 */