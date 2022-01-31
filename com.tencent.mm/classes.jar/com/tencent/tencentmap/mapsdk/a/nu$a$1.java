package com.tencent.tencentmap.mapsdk.a;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class nu$a$1
  extends LinkedHashMap<K, V>
{
  nu$a$1(nu.a parama, int paramInt, float paramFloat, boolean paramBoolean)
  {
    super(paramInt, paramFloat, paramBoolean);
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    return size() > nu.a.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.nu.a.1
 * JD-Core Version:    0.7.0.1
 */