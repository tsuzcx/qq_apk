package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;

public class oi
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private boolean e = false;
  private Bitmap f = null;
  private volatile boolean g = false;
  private qb h;
  
  public oi(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public oi(int paramInt1, int paramInt2, int paramInt3, int paramInt4, qb paramqb)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.h = paramqb;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.f = paramBitmap;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public qb e()
  {
    return this.h;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof oi)) {
        return false;
      }
      paramObject = (oi)paramObject;
    } while ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c));
    return false;
  }
  
  public int hashCode()
  {
    return this.a * 7 + this.b * 11 + this.c * 13;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(24);
    localStringBuilder.append(this.a);
    localStringBuilder.append("-");
    localStringBuilder.append(this.b);
    localStringBuilder.append("-");
    localStringBuilder.append(this.c);
    localStringBuilder.append("-");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.oi
 * JD-Core Version:    0.7.0.1
 */