package com.tencent.mm.ui.e;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  static androidx.a.a.c.a<Context, Resources> Xos;
  static androidx.a.a.c.a<String, String> Xot;
  
  static
  {
    AppMethodBeat.i(250544);
    Xos = new a.1();
    Xot = new androidx.a.a.c.a() {};
    AppMethodBeat.o(250544);
  }
  
  public static void c(androidx.a.a.c.a<Context, Resources> parama)
  {
    Xos = parama;
  }
  
  public static void d(androidx.a.a.c.a<String, String> parama)
  {
    Xot = parama;
  }
  
  public static Resources ll(Context paramContext)
  {
    AppMethodBeat.i(250543);
    paramContext = (Resources)Xos.apply(paramContext);
    AppMethodBeat.o(250543);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.e.a
 * JD-Core Version:    0.7.0.1
 */