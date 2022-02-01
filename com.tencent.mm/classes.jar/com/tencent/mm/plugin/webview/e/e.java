package com.tencent.mm.plugin.webview.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class e
{
  private static ConcurrentHashMap<Integer, c> Ctw;
  
  static
  {
    AppMethodBeat.i(205377);
    Ctw = new ConcurrentHashMap();
    AppMethodBeat.o(205377);
  }
  
  public static c Vb(int paramInt)
  {
    AppMethodBeat.i(205376);
    c localc = (c)Ctw.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(205376);
    return localc;
  }
  
  public static void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(205375);
    Ctw.put(Integer.valueOf(paramInt), paramc);
    AppMethodBeat.o(205375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.e
 * JD-Core Version:    0.7.0.1
 */