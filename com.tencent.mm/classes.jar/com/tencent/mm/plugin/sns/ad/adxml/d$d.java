package com.tencent.mm.plugin.sns.ad.adxml;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class d$d
{
  public boolean isClockwise;
  
  public static d D(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309866);
    if (paramMap.containsKey(paramString))
    {
      d locald = new d();
      if (Util.safeParseInt((String)paramMap.get(paramString + ".clockwise")) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        locald.isClockwise = bool;
        AppMethodBeat.o(309866);
        return locald;
      }
    }
    AppMethodBeat.o(309866);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.d.d
 * JD-Core Version:    0.7.0.1
 */