package com.tencent.tencentmap.mapsdk.a;

public final class pu
{
  public qc a;
  public final float b;
  public final float c;
  public final float d;
  
  pu(int paramInt, qc paramqc, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a = paramqc;
    this.b = paramFloat1;
    this.c = paramFloat2;
    this.d = paramFloat3;
  }
  
  public pu(qc paramqc, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(1, paramqc, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static pu.a a()
  {
    return new pu.a();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof pu)) {
        return false;
      }
      paramObject = (pu)paramObject;
    } while ((this.a.equals(paramObject.a)) && (Float.floatToIntBits(this.b) == Float.floatToIntBits(paramObject.b)) && (Float.floatToIntBits(this.c) == Float.floatToIntBits(paramObject.c)) && (Float.floatToIntBits(this.d) == Float.floatToIntBits(paramObject.d)));
    return false;
  }
  
  public final String toString()
  {
    return "latlng:" + this.a.a + "," + this.a.b + ",zoom:" + this.b + ",tilt=" + this.c + ",bearing:" + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.pu
 * JD-Core Version:    0.7.0.1
 */