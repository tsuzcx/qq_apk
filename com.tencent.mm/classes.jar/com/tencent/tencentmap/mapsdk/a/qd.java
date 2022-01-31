package com.tencent.tencentmap.mapsdk.a;

public final class qd
{
  public final qc a;
  public final qc b;
  
  public qd(qc paramqc1, qc paramqc2)
  {
    this.a = paramqc1;
    this.b = paramqc2;
  }
  
  static double a(double paramDouble1, double paramDouble2)
  {
    return c(paramDouble1, paramDouble2);
  }
  
  public static qd.a a()
  {
    return new qd.a();
  }
  
  static double b(double paramDouble1, double paramDouble2)
  {
    return d(paramDouble1, paramDouble2);
  }
  
  private static double c(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 - paramDouble2 + 360.0D) % 360.0D;
  }
  
  private static double d(double paramDouble1, double paramDouble2)
  {
    return (paramDouble2 - paramDouble1 + 360.0D) % 360.0D;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof qd)) {
        return false;
      }
      paramObject = (qd)paramObject;
    } while ((this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.qd
 * JD-Core Version:    0.7.0.1
 */