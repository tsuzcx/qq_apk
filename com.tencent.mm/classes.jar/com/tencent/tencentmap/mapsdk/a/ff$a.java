package com.tencent.tencentmap.mapsdk.a;

final class ff$a
{
  public String a;
  public boolean b = true;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  private String[] h;
  
  public ff$a(ff paramff, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramString1;
    paramff = paramString1.split("-");
    if (paramff.length < 5)
    {
      this.h = new String[] { "all", "all", "all", "all", "all" };
      int i = 0;
      while (i < paramff.length)
      {
        this.h[i] = paramff[i];
        i += 1;
      }
    }
    this.h = paramff;
    this.c = a(0, String.valueOf(paramInt));
    this.d = a(1, paramString2);
    this.e = a(2, paramString3);
    this.f = a(3, paramString4);
    this.g = a(4, paramString5);
    this.h = null;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (this.h.length >= paramInt + 1)
    {
      boolean bool = this.h[paramInt].equals(paramString);
      if ((!bool) && (!this.h[paramInt].equals("all"))) {
        this.b = false;
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ff.a
 * JD-Core Version:    0.7.0.1
 */