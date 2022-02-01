package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import com.tencent.luggage.xweb_ext.extendplugin.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements com.tencent.luggage.xweb_ext.extendplugin.a.c
{
  private static g JxT;
  
  public static g gie()
  {
    AppMethodBeat.i(212059);
    if (JxT == null) {
      JxT = new g();
    }
    g localg = JxT;
    AppMethodBeat.o(212059);
    return localg;
  }
  
  public final b dW(String paramString)
  {
    AppMethodBeat.i(212060);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(212060);
        return null;
        if (paramString.equals("video")) {
          i = 0;
        }
        break;
      }
    }
    paramString = new l();
    Object localObject = new j();
    ((j)localObject).JxX = paramString;
    paramString.Jyg = ((j)localObject);
    paramString.cIY = ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)new i());
    localObject = paramString.cIY;
    if (localObject != null) {
      ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)localObject).a((c.a)new l.r(paramString));
    }
    AppMethodBeat.o(212060);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.g
 * JD-Core Version:    0.7.0.1
 */