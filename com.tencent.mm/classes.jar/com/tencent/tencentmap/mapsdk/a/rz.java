package com.tencent.tencentmap.mapsdk.a;

public class rz
{
  private int a;
  private ry b;
  private ry c;
  
  rz(int paramInt, ry paramry1, ry paramry2)
  {
    paramry1 = new rz.a().a(paramry1).a(paramry2);
    this.b = new ry(rz.a.a(paramry1), rz.a.b(paramry1));
    this.c = new ry(rz.a.c(paramry1), rz.a.d(paramry1));
    this.a = paramInt;
  }
  
  public rz(ry paramry1, ry paramry2)
  {
    this(1, paramry1, paramry2);
  }
  
  public static rz.a a()
  {
    return new rz.a();
  }
  
  private boolean a(double paramDouble)
  {
    return (this.b.b() <= paramDouble) && (paramDouble <= this.c.b());
  }
  
  private boolean b(double paramDouble)
  {
    if (this.b.c() <= this.c.c()) {
      if ((this.b.c() > paramDouble) || (paramDouble > this.c.c())) {}
    }
    while ((this.b.c() <= paramDouble) || (paramDouble <= this.c.c()))
    {
      return true;
      return false;
    }
    return false;
  }
  
  private static double c(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 - paramDouble2 + 360.0D) % 360.0D;
  }
  
  private boolean c(rz paramrz)
  {
    if ((paramrz == null) || (paramrz.c == null) || (paramrz.b == null) || (this.c == null) || (this.b == null)) {}
    double d1;
    double d2;
    double d3;
    double d4;
    double d5;
    double d6;
    double d7;
    double d8;
    double d9;
    double d10;
    double d11;
    double d12;
    double d13;
    double d14;
    double d15;
    double d16;
    do
    {
      return false;
      d1 = paramrz.c.c();
      d2 = paramrz.b.c();
      d3 = this.c.c();
      d4 = this.b.c();
      d5 = this.c.c();
      d6 = this.b.c();
      d7 = paramrz.c.c();
      d8 = paramrz.b.c();
      d9 = paramrz.c.b();
      d10 = paramrz.b.b();
      d11 = this.c.b();
      d12 = this.b.b();
      d13 = this.c.b();
      d14 = this.b.b();
      d15 = paramrz.c.b();
      d16 = paramrz.b.b();
    } while ((Math.abs(d1 + d2 - d3 - d4) >= d5 - d6 + d7 - d8) || (Math.abs(d9 + d10 - d11 - d12) >= d13 - d14 + d15 - d16));
    return true;
  }
  
  private static double d(double paramDouble1, double paramDouble2)
  {
    return (paramDouble2 - paramDouble1 + 360.0D) % 360.0D;
  }
  
  public boolean a(ry paramry)
  {
    return (a(paramry.b())) && (b(paramry.c()));
  }
  
  public boolean a(rz paramrz)
  {
    if (paramrz == null) {}
    while ((!a(paramrz.b)) || (!a(paramrz.c))) {
      return false;
    }
    return true;
  }
  
  public ry b()
  {
    return this.b;
  }
  
  public boolean b(rz paramrz)
  {
    if (paramrz == null) {}
    while ((!c(paramrz)) && (!paramrz.c(this))) {
      return false;
    }
    return true;
  }
  
  public ry c()
  {
    return this.c;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof rz)) {
        return false;
      }
      paramObject = (rz)paramObject;
    } while ((this.b.equals(paramObject.b)) && (this.c.equals(paramObject.c)));
    return false;
  }
  
  public final int hashCode()
  {
    return ub.a(new Object[] { this.b, this.c });
  }
  
  public final String toString()
  {
    return ub.a(new String[] { ub.a("southwest", this.b), ub.a("northeast", this.c) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rz
 * JD-Core Version:    0.7.0.1
 */