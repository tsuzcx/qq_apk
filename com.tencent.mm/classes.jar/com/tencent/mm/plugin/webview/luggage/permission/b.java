package com.tencent.mm.plugin.webview.luggage.permission;

import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static ConcurrentHashMap<Integer, LuggageGetA8Key> reL = new ConcurrentHashMap();
  
  public static LuggageGetA8Key BZ(int paramInt)
  {
    return (LuggageGetA8Key)reL.remove(Integer.valueOf(paramInt));
  }
  
  public static void a(int paramInt, LuggageGetA8Key paramLuggageGetA8Key)
  {
    reL.put(Integer.valueOf(paramInt), paramLuggageGetA8Key);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.permission.b
 * JD-Core Version:    0.7.0.1
 */