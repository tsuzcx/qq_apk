package com.tencent.tencentmap.mapsdk.a;

import java.util.Arrays;

public final class lu
  extends nm
  implements Cloneable, Comparable<lu>
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public int f = 0;
  public int g = 0;
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  
  static
  {
    if (!lu.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      l = bool;
      return;
    }
  }
  
  public lu() {}
  
  public lu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramString6;
    this.i = paramString7;
    this.j = paramString8;
    this.k = paramString9;
  }
  
  public final int a(lu paramlu)
  {
    int i1 = 0;
    int[] arrayOfInt = new int[11];
    arrayOfInt[0] = nn.a(this.a, paramlu.a);
    arrayOfInt[1] = nn.a(this.b, paramlu.b);
    arrayOfInt[2] = nn.a(this.c, paramlu.c);
    arrayOfInt[3] = nn.a(this.d, paramlu.d);
    arrayOfInt[4] = nn.a(this.e, paramlu.e);
    arrayOfInt[5] = nn.b(this.f, paramlu.f);
    arrayOfInt[6] = nn.b(this.g, paramlu.g);
    arrayOfInt[7] = nn.a(this.h, paramlu.h);
    arrayOfInt[8] = nn.a(this.i, paramlu.i);
    arrayOfInt[9] = nn.a(this.j, paramlu.j);
    arrayOfInt[10] = nn.a(this.k, paramlu.k);
    int m = 0;
    for (;;)
    {
      int n = i1;
      if (m < 11)
      {
        if (arrayOfInt[m] != 0) {
          n = arrayOfInt[m];
        }
      }
      else {
        return n;
      }
      m += 1;
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
      while (l) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new ni(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.a, "masterName");
    paramStringBuilder.a(this.b, "slaveName");
    paramStringBuilder.a(this.c, "interfaceName");
    paramStringBuilder.a(this.d, "masterIp");
    paramStringBuilder.a(this.e, "slaveIp");
    paramStringBuilder.a(this.f, "slavePort");
    paramStringBuilder.a(this.g, "returnValue");
    paramStringBuilder.a(this.h, "slaveSetName");
    paramStringBuilder.a(this.i, "slaveSetArea");
    paramStringBuilder.a(this.j, "slaveSetID");
    paramStringBuilder.a(this.k, "tafVersion");
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
    paramStringBuilder.a(this.h, true);
    paramStringBuilder.a(this.i, true);
    paramStringBuilder.a(this.j, true);
    paramStringBuilder.a(this.k, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (lu)paramObject;
    } while ((!nn.a(this.a, paramObject.a)) || (!nn.a(this.b, paramObject.b)) || (!nn.a(this.c, paramObject.c)) || (!nn.a(this.d, paramObject.d)) || (!nn.a(this.e, paramObject.e)) || (!nn.a(this.f, paramObject.f)) || (!nn.a(this.g, paramObject.g)) || (!nn.a(this.h, paramObject.h)) || (!nn.a(this.i, paramObject.i)) || (!nn.a(this.j, paramObject.j)) || (!nn.a(this.k, paramObject.k)));
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new int[] { nn.a(this.a), nn.a(this.b), nn.a(this.c), nn.a(this.d), nn.a(this.e), nn.a(this.f), nn.a(this.g), nn.a(this.h), nn.a(this.i), nn.a(this.j), nn.a(this.k) });
  }
  
  public final void readFrom(nk paramnk)
  {
    this.a = paramnk.a(0, true);
    this.b = paramnk.a(1, true);
    this.c = paramnk.a(2, true);
    this.d = paramnk.a(3, true);
    this.e = paramnk.a(4, true);
    this.f = paramnk.a(this.f, 5, true);
    this.g = paramnk.a(this.g, 6, true);
    this.h = paramnk.a(7, false);
    this.i = paramnk.a(8, false);
    this.j = paramnk.a(9, false);
    this.k = paramnk.a(10, false);
  }
  
  public final void writeTo(nl paramnl)
  {
    paramnl.a(this.a, 0);
    paramnl.a(this.b, 1);
    paramnl.a(this.c, 2);
    paramnl.a(this.d, 3);
    paramnl.a(this.e, 4);
    paramnl.a(this.f, 5);
    paramnl.a(this.g, 6);
    if (this.h != null) {
      paramnl.a(this.h, 7);
    }
    if (this.i != null) {
      paramnl.a(this.i, 8);
    }
    if (this.j != null) {
      paramnl.a(this.j, 9);
    }
    if (this.k != null) {
      paramnl.a(this.k, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lu
 * JD-Core Version:    0.7.0.1
 */