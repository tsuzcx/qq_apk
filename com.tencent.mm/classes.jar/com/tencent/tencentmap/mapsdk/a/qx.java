package com.tencent.tencentmap.mapsdk.a;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.LatLng;

public class qx
  implements Circle
{
  private rv a;
  
  public qx(rv paramrv)
  {
    this.a = paramrv;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    if (this.a != null) {
      return this.a.b(re.a(paramLatLng));
    }
    return false;
  }
  
  public LatLng getCenter()
  {
    if (this.a != null) {
      return re.a(this.a.c());
    }
    return null;
  }
  
  public int getFillColor()
  {
    if (this.a != null) {
      return this.a.g();
    }
    return 0;
  }
  
  public String getId()
  {
    if (this.a != null) {
      return this.a.b();
    }
    return null;
  }
  
  public double getRadius()
  {
    if (this.a != null) {
      return this.a.d();
    }
    return 0.0D;
  }
  
  public int getStrokeColor()
  {
    if (this.a != null) {
      return this.a.f();
    }
    return 0;
  }
  
  public boolean getStrokeDash()
  {
    if (this.a != null) {
      return this.a.j();
    }
    return false;
  }
  
  public DashPathEffect getStrokeDashPathEffect()
  {
    if (this.a != null) {
      return this.a.k();
    }
    return null;
  }
  
  public float getStrokeWidth()
  {
    if (this.a != null) {
      return this.a.e();
    }
    return 0.0F;
  }
  
  public float getZIndex()
  {
    if (this.a != null) {
      return (int)this.a.h();
    }
    return 0.0F;
  }
  
  public boolean isVisible()
  {
    if (this.a != null) {
      return this.a.i();
    }
    return false;
  }
  
  public void remove()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void setCenter(LatLng paramLatLng)
  {
    if (this.a != null) {
      this.a.a(re.a(paramLatLng));
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
  
  public void setStrokeDash(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.b(paramBoolean);
    }
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    if (this.a != null)
    {
      rv localrv = this.a;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localrv.a(f);
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
      this.a.b((int)paramFloat);
    }
  }
  
  public void strokeDashPathEffect(DashPathEffect paramDashPathEffect)
  {
    if (this.a != null) {
      this.a.a(paramDashPathEffect);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.qx
 * JD-Core Version:    0.7.0.1
 */