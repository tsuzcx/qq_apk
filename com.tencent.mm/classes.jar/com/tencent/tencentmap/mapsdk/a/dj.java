package com.tencent.tencentmap.mapsdk.a;

import java.util.HashMap;
import java.util.Map;

public final class dj
{
  public String a;
  public boolean b;
  public long c;
  public long d;
  public Map<String, String> e;
  boolean f;
  
  public dj(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
  {
    this.a = paramString;
    this.b = paramBoolean1;
    this.c = paramLong1;
    this.d = paramLong2;
    if (paramMap != null)
    {
      this.e = new HashMap();
      this.e.putAll(paramMap);
    }
    this.f = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dj
 * JD-Core Version:    0.7.0.1
 */