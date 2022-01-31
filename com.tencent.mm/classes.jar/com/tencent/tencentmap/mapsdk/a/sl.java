package com.tencent.tencentmap.mapsdk.a;

public final class sl
{
  private final rz a;
  private final int b;
  private final ry c;
  private final ry d;
  private final ry e;
  private final ry f;
  
  protected sl(int paramInt, ry paramry1, ry paramry2, ry paramry3, ry paramry4, rz paramrz)
  {
    this.b = paramInt;
    this.d = paramry1;
    this.c = paramry2;
    this.f = paramry3;
    this.e = paramry4;
    this.a = paramrz;
  }
  
  public sl(ry paramry1, ry paramry2, ry paramry3, ry paramry4, rz paramrz)
  {
    this(1, paramry1, paramry2, paramry3, paramry4, paramrz);
  }
  
  public final ry a()
  {
    return this.d;
  }
  
  public final ry b()
  {
    return this.c;
  }
  
  public final ry c()
  {
    return this.f;
  }
  
  public final ry d()
  {
    return this.e;
  }
  
  public final rz e()
  {
    return this.a;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof sl)) {
        return false;
      }
      paramObject = (sl)paramObject;
    } while ((a().equals(paramObject.a())) && (b().equals(paramObject.b())) && (c().equals(paramObject.c())) && (d().equals(paramObject.d())) && (e().equals(paramObject.e())));
    return false;
  }
  
  public final int hashCode()
  {
    return ub.a(new Object[] { a(), b(), c(), d(), e() });
  }
  
  public final String toString()
  {
    return ub.a(new String[] { ub.a("nearLeft", a()), ub.a("nearRight", b()), ub.a("farLeft", c()), ub.a("farRight", d()), ub.a("latLngBounds", e()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.sl
 * JD-Core Version:    0.7.0.1
 */