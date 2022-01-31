package com.tencent.tencentmap.mapsdk.a;

public final class rz$a
{
  private double a = (1.0D / 0.0D);
  private double b = (-1.0D / 0.0D);
  private double c = (0.0D / 0.0D);
  private double d = (0.0D / 0.0D);
  
  private boolean a(double paramDouble)
  {
    if (this.c <= this.d) {
      if ((this.c > paramDouble) || (paramDouble > this.d)) {}
    }
    while ((this.c <= paramDouble) || (paramDouble <= this.d))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final a a(ry paramry)
  {
    this.a = Math.min(this.a, paramry.b());
    this.b = Math.max(this.b, paramry.b());
    double d1 = paramry.c();
    if (Double.isNaN(this.c)) {
      this.c = d1;
    }
    do
    {
      this.d = d1;
      do
      {
        return this;
      } while (a(d1));
    } while (rz.a(this.c, d1) >= rz.b(this.d, d1));
    this.c = d1;
    return this;
  }
  
  public final rz a()
  {
    return new rz(new ry(this.a, this.c), new ry(this.b, this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rz.a
 * JD-Core Version:    0.7.0.1
 */