package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

class ao$a$1
  extends LinkedHashMap<K, V>
{
  ao$a$1(ao.a parama, int paramInt, float paramFloat, boolean paramBoolean)
  {
    super(paramInt, paramFloat, paramBoolean);
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    AppMethodBeat.i(149627);
    if (size() > ao.a.a(this.a))
    {
      AppMethodBeat.o(149627);
      return true;
    }
    AppMethodBeat.o(149627);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ao.a.1
 * JD-Core Version:    0.7.0.1
 */