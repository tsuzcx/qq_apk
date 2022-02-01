package com.tencent.tencentmap.mapsdk.a;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class g
  implements com.tencent.mapsdk.raster.model.Circle
{
  private com.tencent.tencentmap.mapsdk.maps.model.Circle a;
  
  public g(com.tencent.tencentmap.mapsdk.maps.model.Circle paramCircle)
  {
    this.a = paramCircle;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(186204);
    if (this.a != null)
    {
      boolean bool = this.a.contains(q.a(paramLatLng));
      AppMethodBeat.o(186204);
      return bool;
    }
    AppMethodBeat.o(186204);
    return false;
  }
  
  public LatLng getCenter()
  {
    AppMethodBeat.i(186189);
    if (this.a != null)
    {
      LatLng localLatLng = q.a(this.a.getCenter());
      AppMethodBeat.o(186189);
      return localLatLng;
    }
    AppMethodBeat.o(186189);
    return null;
  }
  
  public int getFillColor()
  {
    AppMethodBeat.i(186197);
    if (this.a != null)
    {
      int i = this.a.getFillColor();
      AppMethodBeat.o(186197);
      return i;
    }
    AppMethodBeat.o(186197);
    return 0;
  }
  
  public String getId()
  {
    AppMethodBeat.i(186187);
    if (this.a != null)
    {
      String str = this.a.getId();
      AppMethodBeat.o(186187);
      return str;
    }
    AppMethodBeat.o(186187);
    return null;
  }
  
  public int getLevel()
  {
    AppMethodBeat.i(186201);
    if (this.a != null)
    {
      int i = this.a.getLevel();
      AppMethodBeat.o(186201);
      return i;
    }
    AppMethodBeat.o(186201);
    return 0;
  }
  
  public double getRadius()
  {
    AppMethodBeat.i(186191);
    if (this.a != null)
    {
      double d = this.a.getRadius();
      AppMethodBeat.o(186191);
      return d;
    }
    AppMethodBeat.o(186191);
    return 0.0D;
  }
  
  public int getStrokeColor()
  {
    AppMethodBeat.i(186195);
    if (this.a != null)
    {
      int i = this.a.getStrokeColor();
      AppMethodBeat.o(186195);
      return i;
    }
    AppMethodBeat.o(186195);
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
    AppMethodBeat.i(186193);
    if (this.a != null)
    {
      float f = this.a.getStrokeWidth();
      AppMethodBeat.o(186193);
      return f;
    }
    AppMethodBeat.o(186193);
    return 0.0F;
  }
  
  public float getZIndex()
  {
    AppMethodBeat.i(186199);
    if (this.a != null)
    {
      float f = (int)this.a.getZIndex();
      AppMethodBeat.o(186199);
      return f;
    }
    AppMethodBeat.o(186199);
    return 0.0F;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(186203);
    if (this.a != null)
    {
      boolean bool = this.a.isVisible();
      AppMethodBeat.o(186203);
      return bool;
    }
    AppMethodBeat.o(186203);
    return false;
  }
  
  public void remove()
  {
    AppMethodBeat.i(186186);
    if (this.a != null) {
      this.a.remove();
    }
    AppMethodBeat.o(186186);
  }
  
  public void setCenter(LatLng paramLatLng)
  {
    AppMethodBeat.i(186188);
    if (this.a != null) {
      this.a.setCenter(q.a(paramLatLng));
    }
    AppMethodBeat.o(186188);
  }
  
  public void setFillColor(int paramInt)
  {
    AppMethodBeat.i(186196);
    if (this.a != null) {
      this.a.setFillColor(paramInt);
    }
    AppMethodBeat.o(186196);
  }
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(186200);
    if (this.a != null) {
      this.a.setLevel(paramInt);
    }
    AppMethodBeat.o(186200);
  }
  
  public void setRadius(double paramDouble)
  {
    AppMethodBeat.i(186190);
    if (this.a != null) {
      this.a.setRadius(paramDouble);
    }
    AppMethodBeat.o(186190);
  }
  
  public void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(186194);
    if (this.a != null) {
      this.a.setStrokeColor(paramInt);
    }
    AppMethodBeat.o(186194);
  }
  
  public void setStrokeDash(boolean paramBoolean) {}
  
  public void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(186192);
    if (this.a != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Circle localCircle = this.a;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localCircle.setStrokeWidth(f);
    }
    AppMethodBeat.o(186192);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(186202);
    if (this.a != null) {
      this.a.setVisible(paramBoolean);
    }
    AppMethodBeat.o(186202);
  }
  
  public void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(186198);
    if (this.a != null) {
      this.a.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(186198);
  }
  
  public void strokeDashPathEffect(DashPathEffect paramDashPathEffect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.g
 * JD-Core Version:    0.7.0.1
 */