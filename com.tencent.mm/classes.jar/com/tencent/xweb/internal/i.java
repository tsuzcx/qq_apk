package com.tencent.xweb.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.c;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class i
{
  private static ConcurrentMap<WebView.c, f> MQM;
  
  static
  {
    AppMethodBeat.i(183531);
    MQM = new ConcurrentHashMap(3);
    AppMethodBeat.o(183531);
  }
  
  public static void a(WebView.c paramc, f paramf)
  {
    AppMethodBeat.i(183529);
    MQM.put(paramc, paramf);
    AppMethodBeat.o(183529);
  }
  
  public static f f(WebView.c paramc)
  {
    AppMethodBeat.i(183530);
    paramc = (f)MQM.get(paramc);
    AppMethodBeat.o(183530);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.internal.i
 * JD-Core Version:    0.7.0.1
 */