package com.tencent.tencentmap.mapsdk.a;

import java.util.Arrays;

public final class fq
  extends nm
  implements Cloneable, Comparable<fq>
{
  public String a = "";
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public String h = "";
  public int i = 0;
  
  static
  {
    if (!fq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      j = bool;
      return;
    }
  }
  
  public final int a(fq paramfq)
  {
    int n = 0;
    int[] arrayOfInt = new int[6];
    arrayOfInt[0] = nn.a(this.a, paramfq.a);
    arrayOfInt[1] = nn.b(this.b, paramfq.b);
    arrayOfInt[2] = nn.b(this.c, paramfq.c);
    arrayOfInt[3] = nn.b(this.d, paramfq.d);
    arrayOfInt[4] = nn.b(this.e, paramfq.e);
    arrayOfInt[5] = nn.b(this.i, paramfq.i);
    int k = 0;
    for (;;)
    {
      int m = n;
      if (k < 6)
      {
        if (arrayOfInt[k] != 0) {
          m = arrayOfInt[k];
        }
      }
      else {
        return m;
      }
      k += 1;
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
      while (j) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new ni(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.a, "host");
    paramStringBuilder.a(this.b, "port");
    paramStringBuilder.a(this.c, "timeout");
    paramStringBuilder.a(this.d, "istcp");
    paramStringBuilder.a(this.e, "grid");
    paramStringBuilder.a(this.f, "groupworkid");
    paramStringBuilder.a(this.g, "grouprealid");
    paramStringBuilder.a(this.h, "setId");
    paramStringBuilder.a(this.i, "qos");
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
    paramStringBuilder.a(this.i, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (fq)paramObject;
    } while ((!nn.a(this.a, paramObject.a)) || (!nn.a(this.b, paramObject.b)) || (!nn.a(this.c, paramObject.c)) || (!nn.a(this.d, paramObject.d)) || (!nn.a(this.e, paramObject.e)) || (!nn.a(this.i, paramObject.i)));
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new int[] { nn.a(this.a), nn.a(this.b), nn.a(this.c), nn.a(this.d), nn.a(this.e), nn.a(this.i) });
  }
  
  public final void readFrom(nk paramnk)
  {
    this.a = paramnk.a(0, true);
    this.b = paramnk.a(this.b, 1, true);
    this.c = paramnk.a(this.c, 2, true);
    this.d = paramnk.a(this.d, 3, true);
    this.e = paramnk.a(this.e, 4, true);
    this.f = paramnk.a(this.f, 5, false);
    this.g = paramnk.a(this.g, 6, false);
    this.h = paramnk.a(7, false);
    this.i = paramnk.a(this.i, 8, false);
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
    paramnl.a(this.i, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.fq
 * JD-Core Version:    0.7.0.1
 */