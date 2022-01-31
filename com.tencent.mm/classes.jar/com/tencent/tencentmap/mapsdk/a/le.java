package com.tencent.tencentmap.mapsdk.a;

public final class le
  extends nm
{
  public String a = "";
  public int b = 0;
  public String c = "";
  
  public le() {}
  
  public le(String paramString1, int paramInt, String paramString2)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
  }
  
  public final void readFrom(nk paramnk)
  {
    this.a = paramnk.a(0, true);
    this.b = paramnk.a(this.b, 1, true);
    this.c = paramnk.a(2, false);
  }
  
  public final void writeTo(nl paramnl)
  {
    paramnl.a(this.a, 0);
    paramnl.a(this.b, 1);
    if (this.c != null) {
      paramnl.a(this.c, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.le
 * JD-Core Version:    0.7.0.1
 */