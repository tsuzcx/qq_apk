package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import java.util.List;

public class k
  implements com.tencent.mapsdk.raster.model.Polyline
{
  private com.tencent.tencentmap.mapsdk.maps.model.Polyline a;
  
  public k(com.tencent.tencentmap.mapsdk.maps.model.Polyline paramPolyline)
  {
    this.a = paramPolyline;
  }
  
  public void eraseTo(int paramInt, LatLng paramLatLng)
  {
    AppMethodBeat.i(186379);
    if (this.a == null)
    {
      AppMethodBeat.o(186379);
      return;
    }
    this.a.eraseTo(paramInt, q.a(paramLatLng));
    AppMethodBeat.o(186379);
  }
  
  public int getColor()
  {
    AppMethodBeat.i(186370);
    if (this.a != null)
    {
      int i = this.a.getColor();
      AppMethodBeat.o(186370);
      return i;
    }
    AppMethodBeat.o(186370);
    return 0;
  }
  
  public String getId()
  {
    AppMethodBeat.i(181297);
    if (this.a != null)
    {
      String str = this.a.getId();
      AppMethodBeat.o(181297);
      return str;
    }
    AppMethodBeat.o(181297);
    return null;
  }
  
  public int getLevel()
  {
    AppMethodBeat.i(186374);
    if (this.a != null)
    {
      int i = this.a.getLevel();
      AppMethodBeat.o(186374);
      return i;
    }
    AppMethodBeat.o(186374);
    return 0;
  }
  
  public List<LatLng> getPoints()
  {
    AppMethodBeat.i(186366);
    if (this.a != null)
    {
      List localList = q.a(this.a.getPoints());
      AppMethodBeat.o(186366);
      return localList;
    }
    AppMethodBeat.o(186366);
    return null;
  }
  
  public float getWidth()
  {
    AppMethodBeat.i(186368);
    if (this.a != null)
    {
      float f = this.a.getWidth();
      AppMethodBeat.o(186368);
      return f;
    }
    AppMethodBeat.o(186368);
    return 0.0F;
  }
  
  public float getZIndex()
  {
    AppMethodBeat.i(186373);
    if (this.a != null)
    {
      float f = this.a.getZIndex();
      AppMethodBeat.o(186373);
      return f;
    }
    AppMethodBeat.o(186373);
    return 0.0F;
  }
  
  public boolean isDottedLine()
  {
    AppMethodBeat.i(186377);
    if ((this.a == null) || (this.a.getPattern() == null))
    {
      AppMethodBeat.o(186377);
      return false;
    }
    AppMethodBeat.o(186377);
    return true;
  }
  
  public boolean isGeodesic()
  {
    return false;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(186376);
    if (this.a != null)
    {
      boolean bool = this.a.isVisible();
      AppMethodBeat.o(186376);
      return bool;
    }
    AppMethodBeat.o(186376);
    return false;
  }
  
  public void remove()
  {
    AppMethodBeat.i(181295);
    if (this.a != null) {
      this.a.remove();
    }
    AppMethodBeat.o(181295);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(186369);
    if (this.a != null) {
      this.a.setColor(paramInt);
    }
    AppMethodBeat.o(186369);
  }
  
  public void setColorTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(186378);
    if (this.a == null)
    {
      AppMethodBeat.o(186378);
      return;
    }
    this.a.setColorTexture(BitmapDescriptorFactory.fromBitmap(paramBitmapDescriptor.getBitmap()));
    AppMethodBeat.o(186378);
  }
  
  public void setDottedLine(boolean paramBoolean) {}
  
  public void setEraseable(boolean paramBoolean)
  {
    AppMethodBeat.i(186380);
    if (this.a == null)
    {
      AppMethodBeat.o(186380);
      return;
    }
    this.a.setEraseable(paramBoolean);
    AppMethodBeat.o(186380);
  }
  
  public void setGeodesic(boolean paramBoolean) {}
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(186372);
    if (this.a != null) {
      this.a.setLevel(paramInt);
    }
    AppMethodBeat.o(186372);
  }
  
  public void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(186365);
    if (this.a != null) {
      this.a.setPoints(q.b(paramList));
    }
    AppMethodBeat.o(186365);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(186375);
    if (this.a != null) {
      this.a.setVisible(paramBoolean);
    }
    AppMethodBeat.o(186375);
  }
  
  public void setWidth(float paramFloat)
  {
    AppMethodBeat.i(186367);
    if (this.a != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Polyline localPolyline = this.a;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localPolyline.setWidth(f);
    }
    AppMethodBeat.o(186367);
  }
  
  public void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(186371);
    if (this.a != null) {
      this.a.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(186371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.k
 * JD-Core Version:    0.7.0.1
 */