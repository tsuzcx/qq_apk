package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ah.l;

public class lb
  extends kz
{
  private jv a;
  private kx b;
  
  public lb(kx paramkx, jv paramjv)
  {
    this.b = paramkx;
    this.a = paramjv;
  }
  
  private Rect a(Rect paramRect)
  {
    AppMethodBeat.i(149131);
    if (paramRect == null)
    {
      AppMethodBeat.o(149131);
      return null;
    }
    int j = paramRect.left;
    int i = paramRect.right;
    int m = paramRect.top;
    int k = paramRect.bottom;
    int i3 = (paramRect.right + paramRect.left) / 2;
    int n = (paramRect.top + paramRect.bottom) / 2;
    int i4 = paramRect.right;
    int i5 = paramRect.left;
    int i1 = paramRect.bottom;
    int i2 = paramRect.top;
    if (i4 - i5 < ka.t * 40.0F)
    {
      j = (int)(i3 - ka.t * 20.0F);
      i = (int)(i3 + ka.t * 20.0F);
    }
    if (i1 - i2 < ka.t * 40.0F)
    {
      m = (int)(n - ka.t * 20.0F);
      k = (int)(n + ka.t * 20.0F);
    }
    paramRect = new Rect(j, m, i, k);
    AppMethodBeat.o(149131);
    return paramRect;
  }
  
  public Rect a()
  {
    AppMethodBeat.i(149130);
    if (this.a == null)
    {
      AppMethodBeat.o(149130);
      return null;
    }
    Rect localRect = a(this.a.l());
    AppMethodBeat.o(149130);
    return localRect;
  }
  
  public String b()
  {
    AppMethodBeat.i(149132);
    if (this.a == null)
    {
      AppMethodBeat.o(149132);
      return null;
    }
    String str = this.a.m();
    AppMethodBeat.o(149132);
    return str;
  }
  
  public void c()
  {
    AppMethodBeat.i(149133);
    if (this.b != null)
    {
      ah.l locall = this.b.s;
      if ((this.a != null) && (locall != null)) {
        locall.a(this.a.y);
      }
    }
    AppMethodBeat.o(149133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lb
 * JD-Core Version:    0.7.0.1
 */