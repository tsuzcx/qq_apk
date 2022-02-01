package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class l
  implements com.tencent.mapsdk.raster.model.Polygon
{
  private com.tencent.tencentmap.mapsdk.maps.model.Polygon a;
  
  public l(com.tencent.tencentmap.mapsdk.maps.model.Polygon paramPolygon)
  {
    this.a = paramPolygon;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(186222);
    if (this.a != null)
    {
      boolean bool = this.a.contains(q.a(paramLatLng));
      AppMethodBeat.o(186222);
      return bool;
    }
    AppMethodBeat.o(186222);
    return false;
  }
  
  public int getFillColor()
  {
    AppMethodBeat.i(186215);
    if (this.a != null)
    {
      int i = this.a.getFillColor();
      AppMethodBeat.o(186215);
      return i;
    }
    AppMethodBeat.o(186215);
    return 0;
  }
  
  public String getId()
  {
    AppMethodBeat.i(186207);
    if (this.a != null)
    {
      String str = this.a.getId();
      AppMethodBeat.o(186207);
      return str;
    }
    AppMethodBeat.o(186207);
    return null;
  }
  
  public int getLevel()
  {
    AppMethodBeat.i(186219);
    if (this.a != null)
    {
      int i = this.a.getLevel();
      AppMethodBeat.o(186219);
      return i;
    }
    AppMethodBeat.o(186219);
    return 0;
  }
  
  public List<LatLng> getPoints()
  {
    AppMethodBeat.i(186209);
    if (this.a != null)
    {
      List localList = q.a(this.a.getPoints());
      AppMethodBeat.o(186209);
      return localList;
    }
    AppMethodBeat.o(186209);
    return null;
  }
  
  public int getStrokeColor()
  {
    AppMethodBeat.i(186213);
    if (this.a != null)
    {
      int i = this.a.getStrokeColor();
      AppMethodBeat.o(186213);
      return i;
    }
    AppMethodBeat.o(186213);
    return 0;
  }
  
  public float getStrokeWidth()
  {
    AppMethodBeat.i(186211);
    if (this.a != null)
    {
      float f = this.a.getStrokeWidth();
      AppMethodBeat.o(186211);
      return f;
    }
    AppMethodBeat.o(186211);
    return 0.0F;
  }
  
  public float getZIndex()
  {
    AppMethodBeat.i(186217);
    if (this.a != null)
    {
      float f = (int)this.a.getZIndex();
      AppMethodBeat.o(186217);
      return f;
    }
    AppMethodBeat.o(186217);
    return 0.0F;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(186221);
    if (this.a != null)
    {
      boolean bool = this.a.isVisible();
      AppMethodBeat.o(186221);
      return bool;
    }
    AppMethodBeat.o(186221);
    return false;
  }
  
  public void remove()
  {
    AppMethodBeat.i(186206);
    if (this.a != null) {
      this.a.remove();
    }
    AppMethodBeat.o(186206);
  }
  
  public void setFillColor(int paramInt)
  {
    AppMethodBeat.i(186214);
    if (this.a != null) {
      this.a.setFillColor(paramInt);
    }
    AppMethodBeat.o(186214);
  }
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(186218);
    if (this.a != null) {
      this.a.setLevel(paramInt);
    }
    AppMethodBeat.o(186218);
  }
  
  public void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(186208);
    if (this.a != null) {
      this.a.setPoints(q.b(paramList));
    }
    AppMethodBeat.o(186208);
  }
  
  public void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(186212);
    if (this.a != null) {
      this.a.setStrokeColor(paramInt);
    }
    AppMethodBeat.o(186212);
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(186210);
    if (this.a != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Polygon localPolygon = this.a;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localPolygon.setStrokeWidth(f);
    }
    AppMethodBeat.o(186210);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(186220);
    if (this.a != null) {
      this.a.setVisible(paramBoolean);
    }
    AppMethodBeat.o(186220);
  }
  
  public void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(186216);
    if (this.a != null) {
      this.a.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(186216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.l
 * JD-Core Version:    0.7.0.1
 */