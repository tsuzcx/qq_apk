package com.tencent.mm.plugin.webview.ui.tools.d.a;

import com.tencent.luggage.k.a.a.b.b.c.a;
import com.tencent.luggage.k.a.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements com.tencent.luggage.k.a.b.c
{
  private static g BtG;
  
  public static g eqR()
  {
    AppMethodBeat.i(188690);
    if (BtG == null) {
      BtG = new g();
    }
    g localg = BtG;
    AppMethodBeat.o(188690);
    return localg;
  }
  
  public final b cJ(String paramString)
  {
    AppMethodBeat.i(188691);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(188691);
        return null;
        if (paramString.equals("video")) {
          i = 0;
        }
        break;
      }
    }
    paramString = new l();
    Object localObject = new j();
    ((j)localObject).BtK = paramString;
    paramString.BtS = ((j)localObject);
    paramString.cmV = ((com.tencent.luggage.k.a.a.b.b.c)new i());
    localObject = paramString.cmV;
    if (localObject != null) {
      ((com.tencent.luggage.k.a.a.b.b.c)localObject).a((c.a)new l.o(paramString));
    }
    AppMethodBeat.o(188691);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.d.a.g
 * JD-Core Version:    0.7.0.1
 */