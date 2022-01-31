package com.tencent.mm.pluginsdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.te;
import com.tencent.mm.sdk.b.a;

public final class e
{
  public static te alc(String paramString)
  {
    AppMethodBeat.i(79204);
    te localte = new te();
    localte.cJF.ctW = 1;
    localte.cJF.cJG = paramString;
    a.ymk.l(localte);
    AppMethodBeat.o(79204);
    return localte;
  }
  
  public static void ald(String paramString)
  {
    AppMethodBeat.i(79205);
    te localte = new te();
    localte.cJF.ctW = 2;
    localte.cJF.cJG = paramString;
    a.ymk.l(localte);
    AppMethodBeat.o(79205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.e
 * JD-Core Version:    0.7.0.1
 */