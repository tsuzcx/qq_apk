package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polyline;
import java.util.List;

public class ra
  implements Polyline
{
  private se a;
  
  public ra(se paramse)
  {
    this.a = paramse;
  }
  
  public int getColor()
  {
    if (this.a != null) {
      return this.a.e();
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
  
  public float getWidth()
  {
    if (this.a != null) {
      return this.a.d();
    }
    return 0.0F;
  }
  
  public float getZIndex()
  {
    if (this.a != null) {
      return this.a.f();
    }
    return 0.0F;
  }
  
  public boolean isDottedLine()
  {
    if (this.a != null) {
      return this.a.i();
    }
    return false;
  }
  
  public boolean isGeodesic()
  {
    if (this.a != null) {
      return this.a.h();
    }
    return false;
  }
  
  public boolean isVisible()
  {
    if (this.a != null) {
      return this.a.g();
    }
    return false;
  }
  
  public void remove()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void setColor(int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
  
  public void setColorTexture(BitmapDescriptor paramBitmapDescriptor) {}
  
  public void setDottedLine(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.c(paramBoolean);
    }
  }
  
  public void setGeodesic(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.b(paramBoolean);
    }
  }
  
  public void setPoints(List<LatLng> paramList)
  {
    if (this.a != null) {
      this.a.a(re.b(paramList));
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
  
  public void setWidth(float paramFloat)
  {
    if (this.a != null)
    {
      se localse = this.a;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localse.a(f);
    }
  }
  
  public void setZIndex(float paramFloat)
  {
    if (this.a != null) {
      this.a.b((int)paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ra
 * JD-Core Version:    0.7.0.1
 */