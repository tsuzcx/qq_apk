package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;

public final class en
{
  public int a = -1;
  public int b = -1;
  private String c = "";
  private int d = -1;
  private byte e;
  private byte f = 1;
  private String[] g;
  
  public en() {}
  
  public en(String paramString, int paramInt)
  {
    this.c = paramString;
    this.d = paramInt;
  }
  
  public final String a()
  {
    return this.c;
  }
  
  public final void a(byte paramByte)
  {
    this.e = 3;
  }
  
  public final boolean a(en paramen)
  {
    return (paramen != null) && (this.c.equals(paramen.c)) && (this.d == paramen.d);
  }
  
  public final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      this.g = paramString.split(":");
      if (this.g.length == 2)
      {
        this.c = this.g[0];
        if (hq.d(this.c)) {
          try
          {
            this.d = Integer.parseInt(this.g[1]);
            if (this.d >= 0)
            {
              int i = this.d;
              if (i <= 65535) {
                return true;
              }
            }
          }
          catch (NumberFormatException paramString) {}
        }
      }
    }
    return false;
  }
  
  public final byte b()
  {
    return this.e;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public final String d()
  {
    return this.c + ":" + this.d;
  }
  
  public final boolean e()
  {
    return this.e == 3;
  }
  
  public final String toString()
  {
    return this.c + ":" + this.d + ",protocalType:" + this.f + ",ipType:" + this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.en
 * JD-Core Version:    0.7.0.1
 */