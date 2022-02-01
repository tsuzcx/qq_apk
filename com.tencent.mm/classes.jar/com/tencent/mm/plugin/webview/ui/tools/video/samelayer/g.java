package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import com.tencent.luggage.xweb_ext.extendplugin.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements c
{
  private static g Xos;
  
  public static g iBQ()
  {
    AppMethodBeat.i(297113);
    if (Xos == null) {
      Xos = new g();
    }
    g localg = Xos;
    AppMethodBeat.o(297113);
    return localg;
  }
  
  public final b fU(String paramString)
  {
    AppMethodBeat.i(297116);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(297116);
        return null;
        if (paramString.equals("video")) {
          i = 0;
        }
        break;
      }
    }
    paramString = new j();
    paramString.hUG();
    AppMethodBeat.o(297116);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.g
 * JD-Core Version:    0.7.0.1
 */