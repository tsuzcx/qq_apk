package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.as.c;
import com.tencent.mm.as.o;
import com.tencent.mm.sdk.platformtools.bk;

public final class k
{
  public static void TY(String paramString)
  {
    if ((!bk.bl(paramString)) && (paramString.startsWith("http"))) {
      o.OI().a(paramString, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.k
 * JD-Core Version:    0.7.0.1
 */