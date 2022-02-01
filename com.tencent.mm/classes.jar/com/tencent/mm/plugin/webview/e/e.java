package com.tencent.mm.plugin.webview.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class e
{
  private static ConcurrentHashMap<Integer, c> WPw;
  
  static
  {
    AppMethodBeat.i(294831);
    WPw = new ConcurrentHashMap();
    AppMethodBeat.o(294831);
  }
  
  public static void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(294819);
    WPw.put(Integer.valueOf(paramInt), paramc);
    AppMethodBeat.o(294819);
  }
  
  public static c atM(int paramInt)
  {
    AppMethodBeat.i(294825);
    c localc = (c)WPw.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(294825);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.e
 * JD-Core Version:    0.7.0.1
 */