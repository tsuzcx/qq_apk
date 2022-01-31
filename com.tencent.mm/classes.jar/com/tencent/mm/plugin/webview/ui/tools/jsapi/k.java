package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.c;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.bo;

public final class k
{
  public static void ajm(String paramString)
  {
    AppMethodBeat.i(9839);
    if ((!bo.isNullOrNil(paramString)) && (paramString.startsWith("http"))) {
      o.ahB().a(paramString, null);
    }
    AppMethodBeat.o(9839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.k
 * JD-Core Version:    0.7.0.1
 */