package com.tencent.mm.plugin.webview.luggage.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static ConcurrentHashMap<Integer, LuggageGetA8Key> uUT;
  
  static
  {
    AppMethodBeat.i(6489);
    uUT = new ConcurrentHashMap();
    AppMethodBeat.o(6489);
  }
  
  public static LuggageGetA8Key JT(int paramInt)
  {
    AppMethodBeat.i(6488);
    LuggageGetA8Key localLuggageGetA8Key = (LuggageGetA8Key)uUT.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(6488);
    return localLuggageGetA8Key;
  }
  
  public static void a(int paramInt, LuggageGetA8Key paramLuggageGetA8Key)
  {
    AppMethodBeat.i(6487);
    uUT.put(Integer.valueOf(paramInt), paramLuggageGetA8Key);
    AppMethodBeat.o(6487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.permission.b
 * JD-Core Version:    0.7.0.1
 */