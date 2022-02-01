package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import com.tencent.luggage.xweb_ext.extendplugin.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements com.tencent.luggage.xweb_ext.extendplugin.a.c
{
  private static g EpO;
  
  public static g eVj()
  {
    AppMethodBeat.i(208934);
    if (EpO == null) {
      EpO = new g();
    }
    g localg = EpO;
    AppMethodBeat.o(208934);
    return localg;
  }
  
  public final b dA(String paramString)
  {
    AppMethodBeat.i(208935);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(208935);
        return null;
        if (paramString.equals("video")) {
          i = 0;
        }
        break;
      }
    }
    paramString = new l();
    Object localObject = new j();
    ((j)localObject).EpS = paramString;
    paramString.Eqb = ((j)localObject);
    paramString.cux = ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)new i());
    localObject = paramString.cux;
    if (localObject != null) {
      ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)localObject).a((c.a)new l.q(paramString));
    }
    AppMethodBeat.o(208935);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.g
 * JD-Core Version:    0.7.0.1
 */