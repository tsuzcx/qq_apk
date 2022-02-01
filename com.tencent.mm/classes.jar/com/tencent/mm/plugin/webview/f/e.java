package com.tencent.mm.plugin.webview.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class e
{
  private static ConcurrentHashMap<Integer, c> Jck;
  
  static
  {
    AppMethodBeat.i(224490);
    Jck = new ConcurrentHashMap();
    AppMethodBeat.o(224490);
  }
  
  public static void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(224488);
    Jck.put(Integer.valueOf(paramInt), paramc);
    AppMethodBeat.o(224488);
  }
  
  public static c agf(int paramInt)
  {
    AppMethodBeat.i(224489);
    c localc = (c)Jck.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(224489);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.e
 * JD-Core Version:    0.7.0.1
 */