package com.tencent.tencentmap.mapsdk.a;

import java.util.HashMap;
import java.util.Map;

public final class ju
  extends nm
  implements Cloneable
{
  static byte[] i;
  static Map<String, String> j;
  public short a = 0;
  public byte b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public byte[] f = null;
  public Map<String, String> g = null;
  public String h = "";
  
  static
  {
    if (!ju.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      k = bool;
      return;
    }
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
      while (k) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new ni(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.a, "iVersion");
    paramStringBuilder.a(this.b, "cPacketType");
    paramStringBuilder.a(this.c, "iRequestId");
    paramStringBuilder.a(this.d, "iMessageType");
    paramStringBuilder.a(this.e, "iRet");
    paramStringBuilder.a(this.f, "sBuffer");
    paramStringBuilder.a(this.g, "status");
    paramStringBuilder.a(this.h, "sResultDesc");
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new ni(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.a, true);
    paramStringBuilder.a(this.b, true);
    paramStringBuilder.a(this.c, true);
    paramStringBuilder.a(this.d, true);
    paramStringBuilder.a(this.e, true);
    paramStringBuilder.a(this.f, true);
    paramStringBuilder.a(this.g, true);
    paramStringBuilder.a(this.h, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ju)paramObject;
    } while ((!nn.a(this.a, paramObject.a)) || (!nn.a(this.b, paramObject.b)) || (!nn.a(this.c, paramObject.c)) || (!nn.a(this.d, paramObject.d)) || (!nn.a(this.e, paramObject.e)) || (!nn.a(this.f, paramObject.f)) || (!nn.a(this.g, paramObject.g)) || (!nn.a(this.h, paramObject.h)));
    return true;
  }
  
  public final int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public final void readFrom(nk paramnk)
  {
    this.a = paramnk.a(this.a, 1, true);
    this.b = paramnk.a(this.b, 2, true);
    this.c = paramnk.a(this.c, 3, true);
    this.d = paramnk.a(this.d, 4, true);
    this.e = paramnk.a(this.e, 5, true);
    if (i == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      i = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.f = ((byte[])paramnk.a(i, 6, true));
    if (j == null)
    {
      j = new HashMap();
      j.put("", "");
    }
    this.g = ((Map)paramnk.a(j, 7, true));
    this.h = paramnk.a(8, false);
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
    if (this.h != null) {
      paramnl.a(this.h, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ju
 * JD-Core Version:    0.7.0.1
 */