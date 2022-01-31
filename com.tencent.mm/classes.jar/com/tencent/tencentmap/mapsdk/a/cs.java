package com.tencent.tencentmap.mapsdk.a;

public final class cs
  extends dc
{
  private static byte[] m;
  public byte a = 0;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public int f = 0;
  public byte[] g = null;
  public byte h = 0;
  public byte i = 0;
  public String j = "";
  public String k = "";
  public String l = "";
  
  public final void a(da paramda)
  {
    this.a = paramda.a(this.a, 0, true);
    this.b = paramda.a(1, true);
    this.c = paramda.a(2, true);
    this.d = paramda.a(3, true);
    this.e = paramda.a(4, true);
    this.f = paramda.a(this.f, 5, true);
    if (m == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      m = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.g = ((byte[])paramda.b(6, true));
    this.h = paramda.a(this.h, 7, true);
    this.i = paramda.a(this.i, 8, true);
    this.j = paramda.a(9, false);
    this.k = paramda.a(10, false);
    this.l = paramda.a(11, false);
  }
  
  public final void a(db paramdb)
  {
    paramdb.a(this.a, 0);
    paramdb.a(this.b, 1);
    paramdb.a(this.c, 2);
    paramdb.a(this.d, 3);
    paramdb.a(this.e, 4);
    paramdb.a(this.f, 5);
    paramdb.a(this.g, 6);
    paramdb.a(this.h, 7);
    paramdb.a(this.i, 8);
    if (this.j != null) {
      paramdb.a(this.j, 9);
    }
    if (this.k != null) {
      paramdb.a(this.k, 10);
    }
    if (this.l != null) {
      paramdb.a(this.l, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cs
 * JD-Core Version:    0.7.0.1
 */