package com.tencent.tencentmap.mapsdk.a;

public final class sv$a
{
  private double a = 1.7976931348623157E+308D;
  private double b = -1.797693134862316E+308D;
  private double c = 1.7976931348623157E+308D;
  private double d = -1.797693134862316E+308D;
  
  public final a a(sw paramsw)
  {
    this.a = Math.min(this.a, paramsw.a());
    this.b = Math.max(this.b, paramsw.a());
    this.d = Math.max(this.d, paramsw.b());
    this.c = Math.min(this.c, paramsw.b());
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.sv.a
 * JD-Core Version:    0.7.0.1
 */