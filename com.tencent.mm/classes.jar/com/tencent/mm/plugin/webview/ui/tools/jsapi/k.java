package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.d;
import com.tencent.mm.ay.q;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
{
  public static void bmW(String paramString)
  {
    AppMethodBeat.i(82047);
    if ((!Util.isNullOrNil(paramString)) && (paramString.startsWith("http"))) {
      q.bmg().a(paramString, null);
    }
    AppMethodBeat.o(82047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.k
 * JD-Core Version:    0.7.0.1
 */