package com.tencent.mm.plugin.multitalk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class c
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString, int paramInt10)
  {
    AppMethodBeat.i(164089);
    h.IzE.a(19192, true, true, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9), paramString, Integer.valueOf(paramInt10) });
    AppMethodBeat.o(164089);
  }
  
  public static void aM(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(164087);
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      a(paramInt, 0, 0, 0, 0, 0, i, 0, 0, "", 0);
      AppMethodBeat.o(164087);
      return;
    }
  }
  
  public static void aN(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(164088);
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      a(paramInt, 0, 0, 0, 0, 0, 0, i, 0, "", 0);
      AppMethodBeat.o(164088);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.d.c
 * JD-Core Version:    0.7.0.1
 */