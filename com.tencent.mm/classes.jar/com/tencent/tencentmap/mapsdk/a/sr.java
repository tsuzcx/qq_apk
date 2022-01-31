package com.tencent.tencentmap.mapsdk.a;

public final class sr
{
  private int a = 0;
  private int b = 0;
  private String c = "default";
  private String d = "";
  private String e = "";
  
  public sr(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.d = paramString1;
    this.e = paramString2;
    this.c = paramString3;
  }
  
  public final int a()
  {
    return this.a * 10 + this.b;
  }
  
  public final boolean a(st paramst)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (this.a)
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while ("default".equals(this.c));
      if (paramst == null) {
        return false;
      }
      paramst = paramst.a();
      tm.a();
      return tm.a(paramst, tm.c(this.c));
      bool1 = bool2;
    } while ("default".equals(this.c));
    if (paramst != null)
    {
      tm.a();
      sw[] arrayOfsw = tm.c(this.c);
      paramst = paramst.b();
      int j = paramst.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label147;
        }
        bool1 = bool2;
        if (tm.a(paramst[i], arrayOfsw)) {
          break;
        }
        i += 1;
      }
    }
    label147:
    return false;
  }
  
  public final String b()
  {
    return this.d;
  }
  
  public final String c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.sr
 * JD-Core Version:    0.7.0.1
 */