package com.tencent.tencentmap.mapsdk.a;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class dz
  implements Circle
{
  private co a;
  
  public dz(co paramco)
  {
    this.a = paramco;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(150221);
    if (this.a != null)
    {
      boolean bool = this.a.a(eh.a(paramLatLng));
      AppMethodBeat.o(150221);
      return bool;
    }
    AppMethodBeat.o(150221);
    return false;
  }
  
  public LatLng getCenter()
  {
    AppMethodBeat.i(150206);
    if (this.a != null)
    {
      LatLng localLatLng = eh.a(this.a.d());
      AppMethodBeat.o(150206);
      return localLatLng;
    }
    AppMethodBeat.o(150206);
    return null;
  }
  
  public int getFillColor()
  {
    AppMethodBeat.i(150214);
    if (this.a != null)
    {
      int i = this.a.h();
      AppMethodBeat.o(150214);
      return i;
    }
    AppMethodBeat.o(150214);
    return 0;
  }
  
  public String getId()
  {
    AppMethodBeat.i(150204);
    if (this.a != null)
    {
      String str = this.a.c();
      AppMethodBeat.o(150204);
      return str;
    }
    AppMethodBeat.o(150204);
    return null;
  }
  
  public int getLevel()
  {
    AppMethodBeat.i(150218);
    if (this.a != null)
    {
      int i = this.a.k();
      AppMethodBeat.o(150218);
      return i;
    }
    AppMethodBeat.o(150218);
    return 0;
  }
  
  public double getRadius()
  {
    AppMethodBeat.i(150208);
    if (this.a != null)
    {
      double d = this.a.e();
      AppMethodBeat.o(150208);
      return d;
    }
    AppMethodBeat.o(150208);
    return 0.0D;
  }
  
  public int getStrokeColor()
  {
    AppMethodBeat.i(150212);
    if (this.a != null)
    {
      int i = this.a.g();
      AppMethodBeat.o(150212);
      return i;
    }
    AppMethodBeat.o(150212);
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
    AppMethodBeat.i(150210);
    if (this.a != null)
    {
      float f1 = this.a.f();
      float f2 = w.g();
      AppMethodBeat.o(150210);
      return f1 * f2;
    }
    AppMethodBeat.o(150210);
    return 0.0F;
  }
  
  public float getZIndex()
  {
    AppMethodBeat.i(150216);
    if (this.a != null)
    {
      float f = (int)this.a.i();
      AppMethodBeat.o(150216);
      return f;
    }
    AppMethodBeat.o(150216);
    return 0.0F;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(150220);
    if (this.a != null)
    {
      boolean bool = this.a.j();
      AppMethodBeat.o(150220);
      return bool;
    }
    AppMethodBeat.o(150220);
    return false;
  }
  
  public void remove()
  {
    AppMethodBeat.i(150203);
    if (this.a != null) {
      this.a.b();
    }
    AppMethodBeat.o(150203);
  }
  
  public void setCenter(LatLng paramLatLng)
  {
    AppMethodBeat.i(150205);
    if (this.a != null) {
      this.a.b(eh.a(paramLatLng));
    }
    AppMethodBeat.o(150205);
  }
  
  public void setFillColor(int paramInt)
  {
    AppMethodBeat.i(150213);
    if (this.a != null) {
      this.a.b(paramInt);
    }
    AppMethodBeat.o(150213);
  }
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(150217);
    if (this.a != null) {
      this.a.d(paramInt);
    }
    AppMethodBeat.o(150217);
  }
  
  public void setRadius(double paramDouble)
  {
    AppMethodBeat.i(150207);
    if (this.a != null) {
      this.a.a(paramDouble);
    }
    AppMethodBeat.o(150207);
  }
  
  public void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(150211);
    if (this.a != null) {
      this.a.a(paramInt);
    }
    AppMethodBeat.o(150211);
  }
  
  public void setStrokeDash(boolean paramBoolean) {}
  
  public void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(150209);
    if (this.a != null)
    {
      co localco = this.a;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localco.a(f / w.g());
    }
    AppMethodBeat.o(150209);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(150219);
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
    AppMethodBeat.o(150219);
  }
  
  public void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(150215);
    if (this.a != null) {
      this.a.c((int)paramFloat);
    }
    AppMethodBeat.o(150215);
  }
  
  public void strokeDashPathEffect(DashPathEffect paramDashPathEffect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dz
 * JD-Core Version:    0.7.0.1
 */