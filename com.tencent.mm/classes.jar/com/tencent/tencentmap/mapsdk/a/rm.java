package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polyline;
import java.util.List;

public class rm
  implements Polyline
{
  private qk a;
  
  public rm(qk paramqk)
  {
    this.a = paramqk;
  }
  
  public int getColor()
  {
    if (this.a != null) {
      return this.a.f();
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
  
  public float getWidth()
  {
    if (this.a != null) {
      return this.a.e();
    }
    return 0.0F;
  }
  
  public float getZIndex()
  {
    if (this.a != null) {
      return this.a.g();
    }
    return 0.0F;
  }
  
  public boolean isDottedLine()
  {
    return (this.a != null) || (this.a.i() != null);
  }
  
  public boolean isGeodesic()
  {
    return false;
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
      this.a.b();
    }
  }
  
  public void setColor(int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
  
  public void setColorTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(ps.a(paramBitmapDescriptor.getBitmap()));
  }
  
  public void setDottedLine(boolean paramBoolean) {}
  
  public void setGeodesic(boolean paramBoolean) {}
  
  public void setPoints(List<LatLng> paramList)
  {
    if (this.a != null) {
      this.a.a(rq.b(paramList));
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
      qk localqk = this.a;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localqk.a(f);
    }
  }
  
  public void setZIndex(float paramFloat)
  {
    if (this.a != null) {
      this.a.b((int)paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rm
 * JD-Core Version:    0.7.0.1
 */