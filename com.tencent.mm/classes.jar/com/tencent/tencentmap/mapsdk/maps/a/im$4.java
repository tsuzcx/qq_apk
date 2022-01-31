package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;

class im$4
  extends hv
{
  im$4(im paramim, int paramInt, double[] paramArrayOfDouble, long paramLong1, long paramLong2, PointF paramPointF)
  {
    super(paramInt, paramArrayOfDouble);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(148550);
    long l1 = System.currentTimeMillis() - this.j;
    if (l1 > this.k)
    {
      im.a(this.m, false);
      AppMethodBeat.o(148550);
      return true;
    }
    double d;
    if (this.l.x != 0.0F)
    {
      d = hf.a(l1, this.l.x, -this.l.x, this.k);
      this.b[0] = d;
    }
    if (this.l.y != 0.0F)
    {
      d = hf.a(l1, this.l.y, -this.l.y, this.k);
      this.b[1] = d;
    }
    AppMethodBeat.o(148550);
    return false;
  }
  
  public void b()
  {
    AppMethodBeat.i(148549);
    im.a(this.m, false);
    AppMethodBeat.o(148549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.im.4
 * JD-Core Version:    0.7.0.1
 */