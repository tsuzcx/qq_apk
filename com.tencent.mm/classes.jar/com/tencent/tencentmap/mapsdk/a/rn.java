package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polygon;
import java.util.List;

public class rn
  implements Polygon
{
  private qi a;
  
  public rn(qi paramqi)
  {
    this.a = paramqi;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    if (this.a != null) {
      return this.a.a(rq.a(paramLatLng));
    }
    return false;
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
      return this.a.c();
    }
    return null;
  }
  
  public List<LatLng> getPoints()
  {
    if (this.a != null) {
      return rq.a(this.a.d());
    }
    return null;
  }
  
  public int getStrokeColor()
  {
    if (this.a != null) {
      return this.a.f();
    }
    return 0;
  }
  
  public float getStrokeWidth()
  {
    if (this.a != null) {
      return this.a.e() * rk.a();
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
      this.a.b();
    }
  }
  
  public void setFillColor(int paramInt)
  {
    if (this.a != null) {
      this.a.b(paramInt);
    }
  }
  
  public void setPoints(List<LatLng> paramList)
  {
    if (this.a != null) {
      this.a.a(rq.b(paramList));
    }
  }
  
  public void setStrokeColor(int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    if (this.a != null)
    {
      qi localqi = this.a;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localqi.a(f / rk.a());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rn
 * JD-Core Version:    0.7.0.1
 */