package com.tencent.xweb.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.WebViewKind;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class l
{
  private static ConcurrentMap<WebView.WebViewKind, g> aikk;
  
  static
  {
    AppMethodBeat.i(183531);
    aikk = new ConcurrentHashMap(3);
    AppMethodBeat.o(183531);
  }
  
  public static void a(WebView.WebViewKind paramWebViewKind, g paramg)
  {
    AppMethodBeat.i(183529);
    aikk.put(paramWebViewKind, paramg);
    AppMethodBeat.o(183529);
  }
  
  public static g d(WebView.WebViewKind paramWebViewKind)
  {
    AppMethodBeat.i(183530);
    paramWebViewKind = (g)aikk.get(paramWebViewKind);
    AppMethodBeat.o(183530);
    return paramWebViewKind;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.internal.l
 * JD-Core Version:    0.7.0.1
 */