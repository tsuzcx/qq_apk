package com.tencent.tencentmap.mapsdk.a;

public final class mm
  extends nm
  implements Cloneable
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public int g = 0;
  public int h = 0;
  public int i = 0;
  
  static
  {
    if (!mm.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      j = bool;
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
      while (j) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new ni(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.a, "unid");
    paramStringBuilder.a(this.b, "masterName");
    paramStringBuilder.a(this.c, "slaveName");
    paramStringBuilder.a(this.d, "interfaceName");
    paramStringBuilder.a(this.e, "masterIp");
    paramStringBuilder.a(this.f, "slaveIp");
    paramStringBuilder.a(this.g, "depth");
    paramStringBuilder.a(this.h, "width");
    paramStringBuilder.a(this.i, "parentWidth");
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
      paramObject = (mm)paramObject;
    } while ((!nn.a(this.a, paramObject.a)) || (!nn.a(this.b, paramObject.b)) || (!nn.a(this.c, paramObject.c)) || (!nn.a(this.d, paramObject.d)) || (!nn.a(this.e, paramObject.e)) || (!nn.a(this.f, paramObject.f)) || (!nn.a(this.g, paramObject.g)) || (!nn.a(this.h, paramObject.h)) || (!nn.a(this.i, paramObject.i)));
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
    this.a = paramnk.a(0, true);
    this.b = paramnk.a(1, true);
    this.c = paramnk.a(2, true);
    this.d = paramnk.a(3, true);
    this.e = paramnk.a(4, true);
    this.f = paramnk.a(5, true);
    this.g = paramnk.a(this.g, 6, true);
    this.h = paramnk.a(this.h, 7, true);
    this.i = paramnk.a(this.i, 8, true);
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
    paramnl.a(this.h, 7);
    paramnl.a(this.i, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mm
 * JD-Core Version:    0.7.0.1
 */