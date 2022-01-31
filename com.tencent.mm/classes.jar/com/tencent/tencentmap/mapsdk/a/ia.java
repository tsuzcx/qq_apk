package com.tencent.tencentmap.mapsdk.a;

import android.view.animation.Interpolator;

public abstract class ia
  implements Cloneable
{
  float a;
  Class<?> b;
  boolean c = false;
  private Interpolator d = null;
  
  public static ia a(float paramFloat)
  {
    return new ia.a(paramFloat);
  }
  
  public static ia a(float paramFloat, double paramDouble)
  {
    return new ia.a(paramFloat, paramDouble);
  }
  
  public static ia a(float paramFloat, Object paramObject)
  {
    return new ia.b(paramFloat, paramObject);
  }
  
  public static ia b(float paramFloat)
  {
    return new ia.b(paramFloat, null);
  }
  
  public abstract Object a();
  
  public void a(Interpolator paramInterpolator)
  {
    this.d = paramInterpolator;
  }
  
  public float b()
  {
    return this.a;
  }
  
  public Interpolator c()
  {
    return this.d;
  }
  
  public abstract ia d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ia
 * JD-Core Version:    0.7.0.1
 */