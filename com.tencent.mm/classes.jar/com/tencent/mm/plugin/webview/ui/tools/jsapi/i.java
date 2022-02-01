package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.c;
import com.tencent.mm.av.o;
import com.tencent.mm.sdk.platformtools.bs;

public final class i
{
  public static void aDP(String paramString)
  {
    AppMethodBeat.i(82047);
    if ((!bs.isNullOrNil(paramString)) && (paramString.startsWith("http"))) {
      o.aFw().a(paramString, null);
    }
    AppMethodBeat.o(82047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.i
 * JD-Core Version:    0.7.0.1
 */