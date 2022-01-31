package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

class ii$2
  extends hv
{
  ii$2(ii paramii, int paramInt, double[] paramArrayOfDouble, boolean paramBoolean, long paramLong, float paramFloat1, float paramFloat2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    super(paramInt, paramArrayOfDouble, paramBoolean);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(148341);
    long l1 = System.currentTimeMillis() - this.j;
    double d1 = hf.b(l1, 0.0F, this.k, 5000L);
    double d2 = hf.b(l1, 0.0F, this.l, 5000L);
    double[] arrayOfDouble = this.b;
    arrayOfDouble[2] += Math.abs(d1);
    arrayOfDouble = this.b;
    arrayOfDouble[3] += Math.abs(d2);
    int i;
    int i1;
    if (this.b[2] >= Math.abs(this.m))
    {
      i = 1;
      if (this.b[3] < Math.abs(this.n)) {
        break label192;
      }
      i1 = 1;
      label121:
      if (i == 0) {
        break label198;
      }
      this.b[0] = (this.o - this.q.o());
      label145:
      if (i1 == 0) {
        break label208;
      }
      this.b[1] = (this.p - this.q.p());
    }
    for (;;)
    {
      if ((i == 0) || (i1 == 0)) {
        break label218;
      }
      AppMethodBeat.o(148341);
      return true;
      i = 0;
      break;
      label192:
      i1 = 0;
      break label121;
      label198:
      this.b[0] = d1;
      break label145;
      label208:
      this.b[1] = d2;
    }
    label218:
    AppMethodBeat.o(148341);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ii.2
 * JD-Core Version:    0.7.0.1
 */