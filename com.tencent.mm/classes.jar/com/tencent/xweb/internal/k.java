package com.tencent.xweb.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.c;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class k
{
  private static ConcurrentMap<WebView.c, f> SDQ;
  
  static
  {
    AppMethodBeat.i(183531);
    SDQ = new ConcurrentHashMap(3);
    AppMethodBeat.o(183531);
  }
  
  public static void a(WebView.c paramc, f paramf)
  {
    AppMethodBeat.i(183529);
    SDQ.put(paramc, paramf);
    AppMethodBeat.o(183529);
  }
  
  public static f f(WebView.c paramc)
  {
    AppMethodBeat.i(183530);
    paramc = (f)SDQ.get(paramc);
    AppMethodBeat.o(183530);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.internal.k
 * JD-Core Version:    0.7.0.1
 */