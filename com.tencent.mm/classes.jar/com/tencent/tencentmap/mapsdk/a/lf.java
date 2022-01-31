package com.tencent.tencentmap.mapsdk.a;

public final class lf
  extends nm
{
  public String a = "";
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public String e = "";
  public String f = "";
  public int g = 0;
  
  public final void readFrom(nk paramnk)
  {
    this.a = paramnk.a(0, true);
    this.b = paramnk.a(this.b, 1, true);
    this.c = paramnk.a(this.c, 2, true);
    this.d = paramnk.a(this.d, 3, false);
    this.e = paramnk.a(4, false);
    this.f = paramnk.a(5, false);
    this.g = paramnk.a(this.g, 6, false);
  }
  
  public final void writeTo(nl paramnl)
  {
    paramnl.a(this.a, 0);
    paramnl.a(this.b, 1);
    paramnl.a(this.c, 2);
    paramnl.a(this.d, 3);
    if (this.e != null) {
      paramnl.a(this.e, 4);
    }
    if (this.f != null) {
      paramnl.a(this.f, 5);
    }
    paramnl.a(this.g, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lf
 * JD-Core Version:    0.7.0.1
 */