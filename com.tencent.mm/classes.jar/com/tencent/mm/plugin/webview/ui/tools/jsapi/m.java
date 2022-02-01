package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.e;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.sdk.platformtools.Util;

public final class m
{
  public static void bmB(String paramString)
  {
    AppMethodBeat.i(82047);
    if ((!Util.isNullOrNil(paramString)) && (paramString.startsWith("http"))) {
      r.bJZ().a(paramString, true, null);
    }
    AppMethodBeat.o(82047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.m
 * JD-Core Version:    0.7.0.1
 */