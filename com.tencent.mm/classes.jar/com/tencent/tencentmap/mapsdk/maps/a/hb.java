package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;

public abstract class hb
  implements Cloneable
{
  float a;
  Class<?> b;
  boolean c = false;
  private Interpolator d = null;
  
  public static hb a(float paramFloat)
  {
    return new hb.a(paramFloat);
  }
  
  public static hb a(float paramFloat, double paramDouble)
  {
    return new hb.a(paramFloat, paramDouble);
  }
  
  public static hb a(float paramFloat, Object paramObject)
  {
    return new hb.b(paramFloat, paramObject);
  }
  
  public static hb b(float paramFloat)
  {
    return new hb.b(paramFloat, null);
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
  
  public abstract hb d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.hb
 * JD-Core Version:    0.7.0.1
 */