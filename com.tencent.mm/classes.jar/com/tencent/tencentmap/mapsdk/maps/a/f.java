package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class f
  extends m
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
    AppMethodBeat.i(98857);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      m = bool;
      k = null;
      l = null;
      AppMethodBeat.o(98857);
      return;
    }
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(98853);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (m) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(98853);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(98853);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(98856);
    paramStringBuilder = new i(paramStringBuilder, paramInt);
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
    AppMethodBeat.o(98856);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(98852);
    paramObject = (f)paramObject;
    if ((n.a(1, paramObject.a)) && (n.a(1, paramObject.b)) && (n.a(1, paramObject.c)) && (n.a(1, paramObject.d)) && (n.a(Integer.valueOf(1), paramObject.e)) && (n.a(Integer.valueOf(1), paramObject.f)) && (n.a(Integer.valueOf(1), paramObject.g)) && (n.a(1, paramObject.h)) && (n.a(Integer.valueOf(1), paramObject.i)) && (n.a(Integer.valueOf(1), paramObject.j)))
    {
      AppMethodBeat.o(98852);
      return true;
    }
    AppMethodBeat.o(98852);
    return false;
  }
  
  public final void readFrom(k paramk)
  {
    AppMethodBeat.i(98855);
    try
    {
      this.a = paramk.a(this.a, 1, true);
      this.b = paramk.a(this.b, 2, true);
      this.c = paramk.a(this.c, 3, true);
      this.d = paramk.a(this.d, 4, true);
      this.e = paramk.a(5, true);
      this.f = paramk.a(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      this.g = ((byte[])paramk.a(k, 7, true));
      this.h = paramk.a(this.h, 8, true);
      HashMap localHashMap;
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.i = ((Map)paramk.a(l, 9, true));
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.j = ((Map)paramk.a(l, 10, true));
      AppMethodBeat.o(98855);
      return;
    }
    catch (Exception paramk)
    {
      System.out.println("RequestPacket decode error " + g.a(this.g));
      paramk = new RuntimeException(paramk);
      AppMethodBeat.o(98855);
      throw paramk;
    }
  }
  
  public final void writeTo(l paraml)
  {
    AppMethodBeat.i(98854);
    paraml.a(this.a, 1);
    paraml.b(this.b, 2);
    paraml.a(this.c, 3);
    paraml.a(this.d, 4);
    paraml.a(this.e, 5);
    paraml.a(this.f, 6);
    paraml.a(this.g, 7);
    paraml.a(this.h, 8);
    paraml.a(this.i, 9);
    paraml.a(this.j, 10);
    AppMethodBeat.o(98854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.f
 * JD-Core Version:    0.7.0.1
 */