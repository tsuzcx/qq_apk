package com.tencent.tencentmap.mapsdk.a;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class it
  extends nm
{
  static byte[] k;
  static Map<String, String> l;
  public short a = 0;
  public byte b = 0;
  public int c = 0;
  public int d = 0;
  public String e = null;
  public String f = null;
  public byte[] g;
  public int h = 0;
  public Map<String, String> i;
  public Map<String, String> j;
  
  static
  {
    if (!it.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      m = bool;
      k = null;
      l = null;
      return;
    }
  }
  
  public it() {}
  
  public it(short paramShort, byte paramByte, int paramInt1, int paramInt2, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt3, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    this.a = paramShort;
    this.b = paramByte;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramArrayOfByte;
    this.h = paramInt3;
    this.i = paramMap1;
    this.j = paramMap2;
  }
  
  public final Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (m) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new ni(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.a, "iVersion");
    paramStringBuilder.a(this.b, "cPacketType");
    paramStringBuilder.a(this.c, "iMessageType");
    paramStringBuilder.a(this.d, "iRequestId");
    paramStringBuilder.a(this.e, "sServantName");
    paramStringBuilder.a(this.f, "sFuncName");
    paramStringBuilder.a(this.g, "sBuffer");
    paramStringBuilder.a(this.h, "iTimeout");
    paramStringBuilder.a(this.i, "context");
    paramStringBuilder.a(this.j, "status");
  }
  
  public final boolean equals(Object paramObject)
  {
    paramObject = (it)paramObject;
    return (nn.a(1, paramObject.a)) && (nn.a(1, paramObject.b)) && (nn.a(1, paramObject.c)) && (nn.a(1, paramObject.d)) && (nn.a(Integer.valueOf(1), paramObject.e)) && (nn.a(Integer.valueOf(1), paramObject.f)) && (nn.a(Integer.valueOf(1), paramObject.g)) && (nn.a(1, paramObject.h)) && (nn.a(Integer.valueOf(1), paramObject.i)) && (nn.a(Integer.valueOf(1), paramObject.j));
  }
  
  public final void readFrom(nk paramnk)
  {
    try
    {
      this.a = paramnk.a(this.a, 1, true);
      this.b = paramnk.a(this.b, 2, true);
      this.c = paramnk.a(this.c, 3, true);
      this.d = paramnk.a(this.d, 4, true);
      this.e = paramnk.a(5, true);
      this.f = paramnk.a(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      this.g = ((byte[])paramnk.a(k, 7, true));
      this.h = paramnk.a(this.h, 8, true);
      HashMap localHashMap;
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.i = ((Map)paramnk.a(l, 9, true));
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.j = ((Map)paramnk.a(l, 10, true));
      return;
    }
    catch (Exception paramnk)
    {
      System.out.println("RequestPacket decode error " + ng.a(this.g));
      throw new RuntimeException(paramnk);
    }
  }
  
  public final void writeTo(nl paramnl)
  {
    paramnl.a(this.a, 1);
    paramnl.b(this.b, 2);
    paramnl.a(this.c, 3);
    paramnl.a(this.d, 4);
    paramnl.a(this.e, 5);
    paramnl.a(this.f, 6);
    paramnl.a(this.g, 7);
    paramnl.a(this.h, 8);
    paramnl.a(this.i, 9);
    paramnl.a(this.j, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.it
 * JD-Core Version:    0.7.0.1
 */