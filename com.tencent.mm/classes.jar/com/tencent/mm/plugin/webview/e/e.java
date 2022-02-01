package com.tencent.mm.plugin.webview.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class e
{
  private static ConcurrentHashMap<Integer, c> Bbk;
  
  static
  {
    AppMethodBeat.i(189748);
    Bbk = new ConcurrentHashMap();
    AppMethodBeat.o(189748);
  }
  
  public static c ST(int paramInt)
  {
    AppMethodBeat.i(189747);
    c localc = (c)Bbk.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(189747);
    return localc;
  }
  
  public static void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(189746);
    Bbk.put(Integer.valueOf(paramInt), paramc);
    AppMethodBeat.o(189746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.e
 * JD-Core Version:    0.7.0.1
 */