package com.tencent.mm.plugin.webview.ui.tools.c.a;

import com.tencent.luggage.k.a.a.b.b.c.a;
import com.tencent.luggage.k.a.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements com.tencent.luggage.k.a.b.c
{
  private static g CLP;
  
  public static g eGl()
  {
    AppMethodBeat.i(189257);
    if (CLP == null) {
      CLP = new g();
    }
    g localg = CLP;
    AppMethodBeat.o(189257);
    return localg;
  }
  
  public final b cy(String paramString)
  {
    AppMethodBeat.i(189258);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(189258);
        return null;
        if (paramString.equals("video")) {
          i = 0;
        }
        break;
      }
    }
    paramString = new l();
    Object localObject = new j();
    ((j)localObject).CLU = paramString;
    paramString.CMb = ((j)localObject);
    paramString.cjX = ((com.tencent.luggage.k.a.a.b.b.c)new i());
    localObject = paramString.cjX;
    if (localObject != null) {
      ((com.tencent.luggage.k.a.a.b.b.c)localObject).a((c.a)new l.o(paramString));
    }
    AppMethodBeat.o(189258);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.a.g
 * JD-Core Version:    0.7.0.1
 */