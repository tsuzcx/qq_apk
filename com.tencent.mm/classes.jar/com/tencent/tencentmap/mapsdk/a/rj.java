package com.tencent.tencentmap.mapsdk.a;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.LatLng;

public class rj
  implements Circle
{
  private pv a;
  
  public rj(pv parampv)
  {
    this.a = parampv;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    if (this.a != null) {
      return this.a.a(rq.a(paramLatLng));
    }
    return false;
  }
  
  public LatLng getCenter()
  {
    if (this.a != null) {
      return rq.a(this.a.d());
    }
    return null;
  }
  
  public int getFillColor()
  {
    if (this.a != null) {
      return this.a.h();
    }
    return 0;
  }
  
  public String getId()
  {
    if (this.a != null) {
      return this.a.c();
    }
    return null;
  }
  
  public double getRadius()
  {
    if (this.a != null) {
      return this.a.e();
    }
    return 0.0D;
  }
  
  public int getStrokeColor()
  {
    if (this.a != null) {
      return this.a.g();
    }
    return 0;
  }
  
  public boolean getStrokeDash()
  {
    return false;
  }
  
  public DashPathEffect getStrokeDashPathEffect()
  {
    return null;
  }
  
  public float getStrokeWidth()
  {
    if (this.a != null) {
      return this.a.f() * rk.a();
    }
    return 0.0F;
  }
  
  public float getZIndex()
  {
    if (this.a != null) {
      return (int)this.a.i();
    }
    return 0.0F;
  }
  
  public boolean isVisible()
  {
    if (this.a != null) {
      return this.a.j();
    }
    return false;
  }
  
  public void remove()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public void setCenter(LatLng paramLatLng)
  {
    if (this.a != null) {
      this.a.b(rq.a(paramLatLng));
    }
  }
  
  public void setFillColor(int paramInt)
  {
    if (this.a != null) {
      this.a.b(paramInt);
    }
  }
  
  public void setRadius(double paramDouble)
  {
    if (this.a != null) {
      this.a.a(paramDouble);
    }
  }
  
  public void setStrokeColor(int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
  
  public void setStrokeDash(boolean paramBoolean) {}
  
  public void setStrokeWidth(float paramFloat)
  {
    if (this.a != null)
    {
      pv localpv = this.a;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localpv.a(f / rk.a());
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
  
  public void setZIndex(float paramFloat)
  {
    if (this.a != null) {
      this.a.c((int)paramFloat);
    }
  }
  
  public void strokeDashPathEffect(DashPathEffect paramDashPathEffect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rj
 * JD-Core Version:    0.7.0.1
 */