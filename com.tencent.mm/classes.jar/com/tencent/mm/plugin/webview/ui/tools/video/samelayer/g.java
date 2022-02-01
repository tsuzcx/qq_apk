package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import com.tencent.luggage.xweb_ext.extendplugin.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements com.tencent.luggage.xweb_ext.extendplugin.a.c
{
  private static g QvY;
  
  public static g hbD()
  {
    AppMethodBeat.i(266784);
    if (QvY == null) {
      QvY = new g();
    }
    g localg = QvY;
    AppMethodBeat.o(266784);
    return localg;
  }
  
  public final b ex(String paramString)
  {
    AppMethodBeat.i(266788);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(266788);
        return null;
        if (paramString.equals("video")) {
          i = 0;
        }
        break;
      }
    }
    paramString = new k();
    Object localObject = new WebViewVideoEventHandler();
    ((WebViewVideoEventHandler)localObject).Qwd = paramString;
    paramString.Qwp = ((WebViewVideoEventHandler)localObject);
    paramString.cJC = ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)new i());
    localObject = paramString.cJC;
    if (localObject != null) {
      ((com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c)localObject).a((c.a)new k.s(paramString));
    }
    AppMethodBeat.o(266788);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.g
 * JD-Core Version:    0.7.0.1
 */