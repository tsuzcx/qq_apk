package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class ec
  implements Polyline
{
  private dj a;
  
  public ec(dj paramdj)
  {
    this.a = paramdj;
  }
  
  public void eraseTo(int paramInt, LatLng paramLatLng)
  {
    AppMethodBeat.i(150376);
    if (this.a == null)
    {
      AppMethodBeat.o(150376);
      return;
    }
    this.a.a(paramInt, eh.a(paramLatLng));
    AppMethodBeat.o(150376);
  }
  
  public int getColor()
  {
    AppMethodBeat.i(150367);
    if (this.a != null)
    {
      int i = this.a.f();
      AppMethodBeat.o(150367);
      return i;
    }
    AppMethodBeat.o(150367);
    return 0;
  }
  
  public String getId()
  {
    AppMethodBeat.i(150361);
    if (this.a != null)
    {
      String str = this.a.c();
      AppMethodBeat.o(150361);
      return str;
    }
    AppMethodBeat.o(150361);
    return null;
  }
  
  public int getLevel()
  {
    AppMethodBeat.i(150371);
    if (this.a != null)
    {
      int i = this.a.k();
      AppMethodBeat.o(150371);
      return i;
    }
    AppMethodBeat.o(150371);
    return 0;
  }
  
  public List<LatLng> getPoints()
  {
    AppMethodBeat.i(150363);
    if (this.a != null)
    {
      List localList = eh.a(this.a.d());
      AppMethodBeat.o(150363);
      return localList;
    }
    AppMethodBeat.o(150363);
    return null;
  }
  
  public float getWidth()
  {
    AppMethodBeat.i(150365);
    if (this.a != null)
    {
      float f = this.a.e();
      AppMethodBeat.o(150365);
      return f;
    }
    AppMethodBeat.o(150365);
    return 0.0F;
  }
  
  public float getZIndex()
  {
    AppMethodBeat.i(150370);
    if (this.a != null)
    {
      float f = this.a.g();
      AppMethodBeat.o(150370);
      return f;
    }
    AppMethodBeat.o(150370);
    return 0.0F;
  }
  
  public boolean isDottedLine()
  {
    AppMethodBeat.i(150374);
    if ((this.a == null) || (this.a.i() == null))
    {
      AppMethodBeat.o(150374);
      return false;
    }
    AppMethodBeat.o(150374);
    return true;
  }
  
  public boolean isGeodesic()
  {
    return false;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(150373);
    if (this.a != null)
    {
      boolean bool = this.a.h();
      AppMethodBeat.o(150373);
      return bool;
    }
    AppMethodBeat.o(150373);
    return false;
  }
  
  public void remove()
  {
    AppMethodBeat.i(150360);
    if (this.a != null) {
      this.a.b();
    }
    AppMethodBeat.o(150360);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(150366);
    if (this.a != null) {
      this.a.a(paramInt);
    }
    AppMethodBeat.o(150366);
  }
  
  public void setColorTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(150375);
    if (this.a == null)
    {
      AppMethodBeat.o(150375);
      return;
    }
    this.a.a(cl.a(paramBitmapDescriptor.getBitmap()));
    AppMethodBeat.o(150375);
  }
  
  public void setDottedLine(boolean paramBoolean) {}
  
  public void setEraseable(boolean paramBoolean)
  {
    AppMethodBeat.i(150377);
    if (this.a == null)
    {
      AppMethodBeat.o(150377);
      return;
    }
    this.a.b(paramBoolean);
    AppMethodBeat.o(150377);
  }
  
  public void setGeodesic(boolean paramBoolean) {}
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(150369);
    if (this.a != null) {
      this.a.c(paramInt);
    }
    AppMethodBeat.o(150369);
  }
  
  public void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(150362);
    if (this.a != null) {
      this.a.a(eh.b(paramList));
    }
    AppMethodBeat.o(150362);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(150372);
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
    AppMethodBeat.o(150372);
  }
  
  public void setWidth(float paramFloat)
  {
    AppMethodBeat.i(150364);
    if (this.a != null)
    {
      dj localdj = this.a;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localdj.a(f);
    }
    AppMethodBeat.o(150364);
  }
  
  public void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(150368);
    if (this.a != null) {
      this.a.b((int)paramFloat);
    }
    AppMethodBeat.o(150368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ec
 * JD-Core Version:    0.7.0.1
 */