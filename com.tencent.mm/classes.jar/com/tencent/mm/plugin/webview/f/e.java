package com.tencent.mm.plugin.webview.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class e
{
  private static ConcurrentHashMap<Integer, c> PYS;
  
  static
  {
    AppMethodBeat.i(206178);
    PYS = new ConcurrentHashMap();
    AppMethodBeat.o(206178);
  }
  
  public static void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(206175);
    PYS.put(Integer.valueOf(paramInt), paramc);
    AppMethodBeat.o(206175);
  }
  
  public static c anU(int paramInt)
  {
    AppMethodBeat.i(206176);
    c localc = (c)PYS.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(206176);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.e
 * JD-Core Version:    0.7.0.1
 */