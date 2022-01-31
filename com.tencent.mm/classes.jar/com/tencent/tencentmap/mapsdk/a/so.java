package com.tencent.tencentmap.mapsdk.a;

public final class so
  extends sn
{
  private sw d;
  private sw e;
  private double f;
  private double g;
  
  public so(tn paramtn, sw paramsw, long paramLong, uv paramuv)
  {
    super(paramtn, paramLong, paramuv);
    this.e = paramsw;
  }
  
  protected final void a(float paramFloat)
  {
    double d1 = this.f;
    double d2 = paramFloat;
    double d3 = this.g;
    double d4 = paramFloat;
    this.d.b(d1 * d2 + this.d.b());
    this.d.a(d3 * d4 + this.d.a());
    this.b.b(this.d);
  }
  
  protected final void c()
  {
    this.d = this.b.b();
    this.f = (this.e.b() - this.d.b());
    this.g = (this.e.a() - this.d.a());
  }
  
  protected final void d()
  {
    this.b.b(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.so
 * JD-Core Version:    0.7.0.1
 */