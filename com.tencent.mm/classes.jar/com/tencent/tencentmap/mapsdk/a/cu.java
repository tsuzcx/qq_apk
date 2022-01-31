package com.tencent.tencentmap.mapsdk.a;

public final class cu
  extends dc
  implements Cloneable
{
  public String a = "";
  public String b = "";
  public String c = "";
  public boolean d = true;
  public long e = 0L;
  public long f = 0L;
  public String g = "";
  public long h = 0L;
  private int i = 0;
  
  public final void a(da paramda)
  {
    this.a = paramda.a(0, true);
    this.b = paramda.a(1, true);
    this.c = paramda.a(2, true);
    if (paramda.a((byte)0, 3, true) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.d = bool;
      this.e = paramda.a(this.e, 4, true);
      this.f = paramda.a(this.f, 5, true);
      this.g = paramda.a(6, true);
      this.h = paramda.a(this.h, 7, true);
      this.i = paramda.a(this.i, 8, false);
      return;
    }
  }
  
  public final void a(db paramdb)
  {
    paramdb.a(this.a, 0);
    paramdb.a(this.b, 1);
    paramdb.a(this.c, 2);
    paramdb.a(this.d);
    paramdb.a(this.e, 4);
    paramdb.a(this.f, 5);
    paramdb.a(this.g, 6);
    paramdb.a(this.h, 7);
    paramdb.a(this.i, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cu
 * JD-Core Version:    0.7.0.1
 */