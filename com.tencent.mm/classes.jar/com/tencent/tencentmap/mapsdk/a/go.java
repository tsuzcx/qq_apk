package com.tencent.tencentmap.mapsdk.a;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class go
  extends LinkedHashMap<String, String>
{
  go(gn paramgn, int paramInt, float paramFloat, boolean paramBoolean)
  {
    super(8, 1.0F, true);
  }
  
  protected final boolean removeEldestEntry(Map.Entry<String, String> paramEntry)
  {
    return size() > 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.go
 * JD-Core Version:    0.7.0.1
 */