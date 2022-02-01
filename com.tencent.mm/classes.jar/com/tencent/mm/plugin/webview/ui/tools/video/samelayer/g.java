package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import com.tencent.luggage.xweb_ext.extendplugin.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements com.tencent.luggage.xweb_ext.extendplugin.a.c
{
  private static g EIe;
  
  public static g eYW()
  {
    AppMethodBeat.i(199117);
    if (EIe == null) {
      EIe = new g();
    }
    g localg = EIe;
    AppMethodBeat.o(199117);
    return localg;
  }
  
  public final b dD(String paramString)
  {
    AppMethodBeat.i(199118);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(199118);
        return null;
        if (paramString.equals("video")) {
          i = 0;
        }
        break;
      }
    }
    paramString = new l();
    Object localObject = new j();
    ((j)localObject).EIi = paramString;
    paramString.EIr = ((j)localObject);
    paramString.cva = ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)new i());
    localObject = paramString.cva;
    if (localObject != null) {
      ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)localObject).a((c.a)new l.q(paramString));
    }
    AppMethodBeat.o(199118);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.g
 * JD-Core Version:    0.7.0.1
 */