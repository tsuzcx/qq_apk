package com.tencent.tencentmap.mapsdk.a;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;

public abstract class lt
{
  protected long a;
  protected long b;
  protected lt.a c;
  protected lt.b d;
  private boolean e;
  private boolean f;
  private boolean g;
  private Interpolator h;
  
  private long f()
  {
    return SystemClock.uptimeMillis();
  }
  
  public void a()
  {
    this.e = false;
  }
  
  protected abstract void a(float paramFloat, Interpolator paramInterpolator);
  
  public void a(lt.a parama)
  {
    this.c = parama;
  }
  
  public void a(lt.b paramb)
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
      this.b = f();
      this.e = true;
    } while (this.c == null);
    this.c.b();
    return true;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public void c()
  {
    if (!this.e)
    {
      if ((!this.g) && (this.c != null)) {
        this.c.a();
      }
      return;
    }
    float f1 = (float)(f() - this.b) / (float)this.a;
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
  
  public boolean d()
  {
    return this.f;
  }
  
  public boolean e()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lt
 * JD-Core Version:    0.7.0.1
 */