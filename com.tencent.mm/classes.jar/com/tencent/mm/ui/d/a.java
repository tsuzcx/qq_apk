package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  static androidx.a.a.c.a<Context, Resources> aeZB;
  static androidx.a.a.c.a<String, String> aeZC;
  
  static
  {
    AppMethodBeat.i(249638);
    aeZB = new a.1();
    aeZC = new androidx.a.a.c.a() {};
    AppMethodBeat.o(249638);
  }
  
  public static void c(androidx.a.a.c.a<Context, Resources> parama)
  {
    aeZB = parama;
  }
  
  public static void d(androidx.a.a.c.a<String, String> parama)
  {
    aeZC = parama;
  }
  
  public static Resources np(Context paramContext)
  {
    AppMethodBeat.i(249633);
    paramContext = (Resources)aeZB.apply(paramContext);
    AppMethodBeat.o(249633);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.d.a
 * JD-Core Version:    0.7.0.1
 */