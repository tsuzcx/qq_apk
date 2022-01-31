package com.tencent.tencentmap.mapsdk.a;

public final class ct
  extends dc
{
  private static byte[] j;
  public byte a = 0;
  public int b = 0;
  public byte[] c = null;
  public String d = "";
  public long e = 0L;
  private byte f = 0;
  private byte g = 0;
  private String h = "";
  private String i = "";
  
  public final void a(da paramda)
  {
    this.a = paramda.a(this.a, 0, true);
    this.b = paramda.a(this.b, 1, true);
    if (j == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      j = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.c = ((byte[])paramda.b(2, true));
    this.d = paramda.a(3, true);
    this.f = paramda.a(this.f, 4, true);
    this.g = paramda.a(this.g, 5, true);
    this.e = paramda.a(this.e, 6, true);
    this.h = paramda.a(7, false);
    this.i = paramda.a(8, false);
  }
  
  public final void a(db paramdb)
  {
    paramdb.a(this.a, 0);
    paramdb.a(this.b, 1);
    paramdb.a(this.c, 2);
    paramdb.a(this.d, 3);
    paramdb.a(this.f, 4);
    paramdb.a(this.g, 5);
    paramdb.a(this.e, 6);
    if (this.h != null) {
      paramdb.a(this.h, 7);
    }
    if (this.i != null) {
      paramdb.a(this.i, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ct
 * JD-Core Version:    0.7.0.1
 */