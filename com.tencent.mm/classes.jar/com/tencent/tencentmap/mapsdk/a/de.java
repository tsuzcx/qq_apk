package com.tencent.tencentmap.mapsdk.a;

import java.util.HashMap;
import java.util.Map;

public final class de
  extends dc
{
  private static byte[] k = null;
  private static Map<String, String> l = null;
  public short a = 3;
  public int b = 0;
  public String c = null;
  public String d = null;
  public byte[] e;
  private byte f = 0;
  private int g = 0;
  private int h = 0;
  private Map<String, String> i;
  private Map<String, String> j;
  
  public final void a(da paramda)
  {
    try
    {
      this.a = paramda.a(this.a, 1, true);
      this.f = paramda.a(this.f, 2, true);
      this.g = paramda.a(this.g, 3, true);
      this.b = paramda.a(this.b, 4, true);
      this.c = paramda.a(5, true);
      this.d = paramda.a(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      this.e = ((byte[])paramda.b(7, true));
      this.h = paramda.a(this.h, 8, true);
      HashMap localHashMap;
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.i = ((Map)paramda.a(l, 9, true));
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.j = ((Map)paramda.a(l, 10, true));
      return;
    }
    catch (Exception paramda)
    {
      throw new RuntimeException(paramda);
    }
  }
  
  public final void a(db paramdb)
  {
    paramdb.a(this.a, 1);
    paramdb.a(this.f, 2);
    paramdb.a(this.g, 3);
    paramdb.a(this.b, 4);
    paramdb.a(this.c, 5);
    paramdb.a(this.d, 6);
    paramdb.a(this.e, 7);
    paramdb.a(this.h, 8);
    paramdb.a(this.i, 9);
    paramdb.a(this.j, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.de
 * JD-Core Version:    0.7.0.1
 */