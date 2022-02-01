package com.tencent.mm.plugin.webview.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class e
{
  private static ConcurrentHashMap<Integer, c> Epe;
  
  static
  {
    AppMethodBeat.i(213810);
    Epe = new ConcurrentHashMap();
    AppMethodBeat.o(213810);
  }
  
  public static c Xx(int paramInt)
  {
    AppMethodBeat.i(213809);
    c localc = (c)Epe.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(213809);
    return localc;
  }
  
  public static void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(213808);
    Epe.put(Integer.valueOf(paramInt), paramc);
    AppMethodBeat.o(213808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.e
 * JD-Core Version:    0.7.0.1
 */