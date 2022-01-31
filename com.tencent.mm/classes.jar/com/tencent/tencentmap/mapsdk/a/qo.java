package com.tencent.tencentmap.mapsdk.a;

public final class qo
{
  public final qc a;
  public final qc b;
  public final qc c;
  public final qc d;
  public final qd e;
  
  public qo(qc paramqc1, qc paramqc2, qc paramqc3, qc paramqc4, qd paramqd)
  {
    this.a = paramqc1;
    this.b = paramqc2;
    this.c = paramqc3;
    this.d = paramqc4;
    this.e = paramqd;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof qo)) {
        return false;
      }
      paramObject = (qo)paramObject;
    } while ((this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)) && (this.c.equals(paramObject.c)) && (this.d.equals(paramObject.d)) && (this.e.equals(paramObject.e)));
    return false;
  }
  
  public final String toString()
  {
    return "nearLeft" + this.a + "nearRight" + this.b + "farLeft" + this.c + "farRight" + this.d + "latLngBounds" + this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.qo
 * JD-Core Version:    0.7.0.1
 */