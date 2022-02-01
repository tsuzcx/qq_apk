package com.tencent.mm.ui.e;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  static android.arch.a.c.a<Context, Resources> PRK;
  static android.arch.a.c.a<String, String> PRL;
  
  static
  {
    AppMethodBeat.i(198213);
    PRK = new android.arch.a.c.a() {};
    PRL = new android.arch.a.c.a() {};
    AppMethodBeat.o(198213);
  }
  
  public static void b(android.arch.a.c.a<Context, Resources> parama)
  {
    PRK = parama;
  }
  
  public static void c(android.arch.a.c.a<String, String> parama)
  {
    PRL = parama;
  }
  
  public static Resources kn(Context paramContext)
  {
    AppMethodBeat.i(198212);
    paramContext = (Resources)PRK.apply(paramContext);
    AppMethodBeat.o(198212);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.e.a
 * JD-Core Version:    0.7.0.1
 */