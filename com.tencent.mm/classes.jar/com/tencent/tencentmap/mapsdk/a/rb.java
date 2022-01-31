package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polygon;
import java.util.List;

public class rb
  implements Polygon
{
  private sc a;
  
  public rb(sc paramsc)
  {
    this.a = paramsc;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    if (this.a != null) {
      return this.a.a(re.a(paramLatLng));
    }
    return false;
  }
  
  public int getFillColor()
  {
    if (this.a != null) {
      return this.a.f();
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
  
  public List<LatLng> getPoints()
  {
    if (this.a != null) {
      return re.a(this.a.c());
    }
    return null;
  }
  
  public int getStrokeColor()
  {
    if (this.a != null) {
      return this.a.e();
    }
    return 0;
  }
  
  public float getStrokeWidth()
  {
    if (this.a != null) {
      return this.a.d();
    }
    return 0.0F;
  }
  
  public float getZIndex()
  {
    if (this.a != null) {
      return (int)this.a.g();
    }
    return 0.0F;
  }
  
  public boolean isVisible()
  {
    if (this.a != null) {
      return this.a.h();
    }
    return false;
  }
  
  public void remove()
  {
    if (this.a != null) {
      this.a.a();
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
      this.a.a(re.b(paramList));
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
      sc localsc = this.a;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localsc.a(f);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rb
 * JD-Core Version:    0.7.0.1
 */