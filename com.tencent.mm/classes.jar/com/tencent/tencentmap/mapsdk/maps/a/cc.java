package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class cc
  extends LinkedHashMap<String, String>
{
  cc(cb paramcb, int paramInt, float paramFloat, boolean paramBoolean)
  {
    super(8, 1.0F, true);
  }
  
  protected final boolean removeEldestEntry(Map.Entry<String, String> paramEntry)
  {
    AppMethodBeat.i(147341);
    if (size() > 8)
    {
      AppMethodBeat.o(147341);
      return true;
    }
    AppMethodBeat.o(147341);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.cc
 * JD-Core Version:    0.7.0.1
 */