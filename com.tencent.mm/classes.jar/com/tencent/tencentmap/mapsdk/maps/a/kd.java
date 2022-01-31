package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;

public abstract class kd
{
  protected long a = 1500L;
  protected long b = 0L;
  protected kd.a c = null;
  protected b d = null;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private Interpolator h = new LinearInterpolator();
  
  private long g()
  {
    return SystemClock.uptimeMillis();
  }
  
  public Interpolator a()
  {
    return this.h;
  }
  
  protected abstract void a(float paramFloat, Interpolator paramInterpolator);
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.h = paramInterpolator;
  }
  
  public void a(kd.a parama)
  {
    this.c = parama;
  }
  
  public void a(b paramb)
  {
    this.d = paramb;
  }
  
  public boolean a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    boolean bool = true;
    if (this.a <= 0L) {
      bool = false;
    }
    do
    {
      return bool;
      this.f = true;
      this.b = g();
      this.e = true;
    } while (this.c == null);
    this.c.b();
    return true;
  }
  
  public void b()
  {
    this.e = false;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public void d()
  {
    if (!this.e)
    {
      if ((!this.g) && (this.c != null)) {
        this.c.a();
      }
      return;
    }
    float f1 = (float)(g() - this.b) / (float)this.a;
    if (f1 > 1.0F)
    {
      this.e = false;
      a(1.0F, this.h);
      if (this.c != null) {
        this.c.a();
      }
      this.g = true;
      return;
    }
    a(f1, this.h);
  }
  
  public boolean e()
  {
    return this.f;
  }
  
  public boolean f()
  {
    return this.g;
  }
  
  public static abstract interface b
  {
    public abstract void a(float paramFloat);
    
    public abstract void a(float paramFloat1, float paramFloat2);
    
    public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
    
    public abstract void a(int paramInt1, int paramInt2);
    
    public abstract void b(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.kd
 * JD-Core Version:    0.7.0.1
 */