package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.o;
import com.tencent.mm.sdk.platformtools.bt;

public final class i
{
  public static void ayy(String paramString)
  {
    AppMethodBeat.i(82047);
    if ((!bt.isNullOrNil(paramString)) && (paramString.startsWith("http"))) {
      o.ayE().a(paramString, null);
    }
    AppMethodBeat.o(82047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.i
 * JD-Core Version:    0.7.0.1
 */