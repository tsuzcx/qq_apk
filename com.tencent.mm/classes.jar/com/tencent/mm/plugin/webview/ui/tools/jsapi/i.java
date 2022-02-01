package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
{
  public static void baY(String paramString)
  {
    AppMethodBeat.i(82047);
    if ((!Util.isNullOrNil(paramString)) && (paramString.startsWith("http"))) {
      q.bcQ().a(paramString, null);
    }
    AppMethodBeat.o(82047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.i
 * JD-Core Version:    0.7.0.1
 */