package com.tencent.mm.plugin.webview.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class e
{
  private static ConcurrentHashMap<Integer, c> DXc;
  
  static
  {
    AppMethodBeat.i(213979);
    DXc = new ConcurrentHashMap();
    AppMethodBeat.o(213979);
  }
  
  public static c WR(int paramInt)
  {
    AppMethodBeat.i(213978);
    c localc = (c)DXc.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(213978);
    return localc;
  }
  
  public static void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(213977);
    DXc.put(Integer.valueOf(paramInt), paramc);
    AppMethodBeat.o(213977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.e
 * JD-Core Version:    0.7.0.1
 */