package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class ed
  implements Polygon
{
  private dh a;
  
  public ed(dh paramdh)
  {
    this.a = paramdh;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(150231);
    if (this.a != null)
    {
      boolean bool = this.a.a(eh.a(paramLatLng));
      AppMethodBeat.o(150231);
      return bool;
    }
    AppMethodBeat.o(150231);
    return false;
  }
  
  public int getFillColor()
  {
    AppMethodBeat.i(150230);
    if (this.a != null)
    {
      int i = this.a.g();
      AppMethodBeat.o(150230);
      return i;
    }
    AppMethodBeat.o(150230);
    return 0;
  }
  
  public String getId()
  {
    AppMethodBeat.i(101380);
    if (this.a != null)
    {
      String str = this.a.c();
      AppMethodBeat.o(101380);
      return str;
    }
    AppMethodBeat.o(101380);
    return null;
  }
  
  public int getLevel()
  {
    AppMethodBeat.i(101407);
    if (this.a != null)
    {
      int i = this.a.j();
      AppMethodBeat.o(101407);
      return i;
    }
    AppMethodBeat.o(101407);
    return 0;
  }
  
  public List<LatLng> getPoints()
  {
    AppMethodBeat.i(150224);
    if (this.a != null)
    {
      List localList = eh.a(this.a.d());
      AppMethodBeat.o(150224);
      return localList;
    }
    AppMethodBeat.o(150224);
    return null;
  }
  
  public int getStrokeColor()
  {
    AppMethodBeat.i(150228);
    if (this.a != null)
    {
      int i = this.a.f();
      AppMethodBeat.o(150228);
      return i;
    }
    AppMethodBeat.o(150228);
    return 0;
  }
  
  public float getStrokeWidth()
  {
    AppMethodBeat.i(150226);
    if (this.a != null)
    {
      float f1 = this.a.e();
      float f2 = w.g();
      AppMethodBeat.o(150226);
      return f1 * f2;
    }
    AppMethodBeat.o(150226);
    return 0.0F;
  }
  
  public float getZIndex()
  {
    AppMethodBeat.i(101405);
    if (this.a != null)
    {
      float f = (int)this.a.h();
      AppMethodBeat.o(101405);
      return f;
    }
    AppMethodBeat.o(101405);
    return 0.0F;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(101388);
    if (this.a != null)
    {
      boolean bool = this.a.i();
      AppMethodBeat.o(101388);
      return bool;
    }
    AppMethodBeat.o(101388);
    return false;
  }
  
  public void remove()
  {
    AppMethodBeat.i(101389);
    if (this.a != null) {
      this.a.b();
    }
    AppMethodBeat.o(101389);
  }
  
  public void setFillColor(int paramInt)
  {
    AppMethodBeat.i(150229);
    if (this.a != null) {
      this.a.b(paramInt);
    }
    AppMethodBeat.o(150229);
  }
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(101406);
    if (this.a != null) {
      this.a.d(paramInt);
    }
    AppMethodBeat.o(101406);
  }
  
  public void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(150223);
    if (this.a != null) {
      this.a.a(eh.b(paramList));
    }
    AppMethodBeat.o(150223);
  }
  
  public void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(150227);
    if (this.a != null) {
      this.a.a(paramInt);
    }
    AppMethodBeat.o(150227);
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(150225);
    if (this.a != null)
    {
      dh localdh = this.a;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localdh.a(f / w.g());
    }
    AppMethodBeat.o(150225);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(101398);
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
    AppMethodBeat.o(101398);
  }
  
  public void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(101404);
    if (this.a != null) {
      this.a.c((int)paramFloat);
    }
    AppMethodBeat.o(101404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ed
 * JD-Core Version:    0.7.0.1
 */