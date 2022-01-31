package com.tencent.tencentmap.mapsdk.a;

class jf$2
  extends iv
{
  jf$2(jf paramjf, int paramInt, double[] paramArrayOfDouble, boolean paramBoolean, long paramLong, float paramFloat1, float paramFloat2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    super(paramInt, paramArrayOfDouble, paramBoolean);
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis() - this.j;
    double d1 = ie.b(l1, 0.0F, this.k, 5000L);
    double d2 = ie.b(l1, 0.0F, this.l, 5000L);
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
        break label182;
      }
      i1 = 1;
      label116:
      if (i == 0) {
        break label188;
      }
      this.b[0] = (this.o - this.q.o());
      label140:
      if (i1 == 0) {
        break label198;
      }
      this.b[1] = (this.p - this.q.p());
    }
    for (;;)
    {
      if ((i == 0) || (i1 == 0)) {
        break label208;
      }
      return true;
      i = 0;
      break;
      label182:
      i1 = 0;
      break label116;
      label188:
      this.b[0] = d1;
      break label140;
      label198:
      this.b[1] = d2;
    }
    label208:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jf.2
 * JD-Core Version:    0.7.0.1
 */