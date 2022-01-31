package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ad
{
  public int a = -1;
  public int b = -1;
  private String c = "";
  private int d = -1;
  private byte e;
  private byte f = 1;
  private String[] g;
  
  public ad() {}
  
  public ad(String paramString, int paramInt)
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
  
  public final boolean a(ad paramad)
  {
    AppMethodBeat.i(147198);
    if ((paramad != null) && (this.c.equals(paramad.c)) && (this.d == paramad.d))
    {
      AppMethodBeat.o(147198);
      return true;
    }
    AppMethodBeat.o(147198);
    return false;
  }
  
  public final boolean a(String paramString)
  {
    AppMethodBeat.i(147196);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(147196);
      return false;
    }
    this.g = paramString.split(":");
    if (this.g.length != 2)
    {
      AppMethodBeat.o(147196);
      return false;
    }
    this.c = this.g[0];
    if (!dd.d(this.c))
    {
      AppMethodBeat.o(147196);
      return false;
    }
    try
    {
      this.d = Integer.parseInt(this.g[1]);
      if (this.d >= 0)
      {
        int i = this.d;
        if (i <= 65535) {}
      }
      else
      {
        AppMethodBeat.o(147196);
        return false;
      }
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(147196);
      return false;
    }
    AppMethodBeat.o(147196);
    return true;
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
    AppMethodBeat.i(147195);
    String str = this.c + ":" + this.d;
    AppMethodBeat.o(147195);
    return str;
  }
  
  public final boolean e()
  {
    return this.e == 3;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147197);
    String str = this.c + ":" + this.d + ",protocalType:" + this.f + ",ipType:" + this.e;
    AppMethodBeat.o(147197);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ad
 * JD-Core Version:    0.7.0.1
 */