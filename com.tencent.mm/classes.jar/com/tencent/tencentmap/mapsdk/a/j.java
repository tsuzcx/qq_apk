package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import java.util.Iterator;
import java.util.List;

public class j
  implements com.tencent.mapsdk.raster.model.Marker
{
  private com.tencent.tencentmap.mapsdk.maps.model.Marker a;
  private n b;
  
  public j(n paramn, com.tencent.tencentmap.mapsdk.maps.model.Marker paramMarker)
  {
    AppMethodBeat.i(186144);
    this.b = paramn;
    this.a = paramMarker;
    if ((this.b != null) && (this.b.a() != null)) {
      try
      {
        this.b.a().add(this.a);
        return;
      }
      finally
      {
        AppMethodBeat.o(186144);
      }
    }
    AppMethodBeat.o(186144);
  }
  
  public float getAlpha()
  {
    AppMethodBeat.i(186145);
    if (this.a != null)
    {
      float f = this.a.getAlpha();
      AppMethodBeat.o(186145);
      return f;
    }
    AppMethodBeat.o(186145);
    return 0.0F;
  }
  
  public String getContentDescription()
  {
    AppMethodBeat.i(186167);
    if (this.a != null)
    {
      String str = this.a.getContentDescription();
      AppMethodBeat.o(186167);
      return str;
    }
    AppMethodBeat.o(186167);
    return null;
  }
  
  public String getId()
  {
    AppMethodBeat.i(181191);
    if (this.a != null)
    {
      String str = this.a.getId();
      AppMethodBeat.o(181191);
      return str;
    }
    AppMethodBeat.o(181191);
    return "";
  }
  
  public int getLevel()
  {
    AppMethodBeat.i(181205);
    if (this.a != null)
    {
      int i = this.a.getLevel();
      AppMethodBeat.o(181205);
      return i;
    }
    AppMethodBeat.o(181205);
    return 0;
  }
  
  public View getMarkerView()
  {
    return null;
  }
  
  public LatLng getPosition()
  {
    AppMethodBeat.i(186146);
    if (this.a != null)
    {
      LatLng localLatLng = q.a(this.a.getPosition());
      AppMethodBeat.o(186146);
      return localLatLng;
    }
    AppMethodBeat.o(186146);
    return null;
  }
  
  public float getRotation()
  {
    AppMethodBeat.i(186147);
    if (this.a != null)
    {
      float f = this.a.getRotation();
      AppMethodBeat.o(186147);
      return f;
    }
    AppMethodBeat.o(186147);
    return 0.0F;
  }
  
  public String getSnippet()
  {
    AppMethodBeat.i(186148);
    if (this.a != null)
    {
      String str = this.a.getSnippet();
      AppMethodBeat.o(186148);
      return str;
    }
    AppMethodBeat.o(186148);
    return null;
  }
  
  public Object getTag()
  {
    AppMethodBeat.i(186164);
    if (this.a != null)
    {
      Object localObject = this.a.getTag();
      AppMethodBeat.o(186164);
      return localObject;
    }
    AppMethodBeat.o(186164);
    return null;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(186149);
    if (this.a != null)
    {
      String str = this.a.getTitle();
      AppMethodBeat.o(186149);
      return str;
    }
    AppMethodBeat.o(186149);
    return null;
  }
  
  public float getZIndex()
  {
    AppMethodBeat.i(181203);
    if (this.a != null)
    {
      float f = this.a.getZIndex();
      AppMethodBeat.o(181203);
      return f;
    }
    AppMethodBeat.o(181203);
    return 0.0F;
  }
  
  public void hideInfoWindow()
  {
    AppMethodBeat.i(186150);
    if (this.a != null) {
      this.a.hideInfoWindow();
    }
    AppMethodBeat.o(186150);
  }
  
  public boolean isDraggable()
  {
    AppMethodBeat.i(186151);
    if (this.a != null)
    {
      boolean bool = this.a.isDraggable();
      AppMethodBeat.o(186151);
      return bool;
    }
    AppMethodBeat.o(186151);
    return false;
  }
  
  public boolean isInfoWindowShown()
  {
    AppMethodBeat.i(186152);
    if (this.a != null)
    {
      boolean bool = this.a.isInfoWindowShown();
      AppMethodBeat.o(186152);
      return bool;
    }
    AppMethodBeat.o(186152);
    return false;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(181207);
    if (this.a != null)
    {
      boolean bool = this.a.isVisible();
      AppMethodBeat.o(181207);
      return bool;
    }
    AppMethodBeat.o(181207);
    return false;
  }
  
  public void refreshInfoWindow()
  {
    AppMethodBeat.i(186168);
    if (this.a != null) {
      this.a.refreshInfoWindow();
    }
    AppMethodBeat.o(186168);
  }
  
  public void remove()
  {
    AppMethodBeat.i(181190);
    if (this.a != null) {}
    try
    {
      if ((this.b != null) && (this.b.a() != null)) {
        this.b.a().remove(this.a);
      }
      this.a.remove();
      AppMethodBeat.o(181190);
      return;
    }
    finally
    {
      AppMethodBeat.o(181190);
    }
  }
  
  public void set2Top()
  {
    AppMethodBeat.i(186162);
    if ((this.b == null) || (this.b.a() == null))
    {
      AppMethodBeat.o(186162);
      return;
    }
    try
    {
      int i = this.b.a().size();
      Object localObject1 = this.b.a().iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          com.tencent.tencentmap.mapsdk.maps.model.Marker localMarker = (com.tencent.tencentmap.mapsdk.maps.model.Marker)((Iterator)localObject1).next();
          if (localMarker.getZIndex() <= i) {
            break;
          }
          i = (int)localMarker.getZIndex();
        }
        else
        {
          localObject1 = this.a;
          if (i < 2147483647) {}
          for (float f = i + 1;; f = 2.147484E+009F)
          {
            ((com.tencent.tencentmap.mapsdk.maps.model.Marker)localObject1).setZIndex(f);
            return;
          }
        }
      }
    }
    finally
    {
      AppMethodBeat.o(186162);
    }
    for (;;) {}
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(186153);
    if (this.a != null) {
      this.a.setAlpha(paramFloat);
    }
    AppMethodBeat.o(186153);
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(186154);
    if (this.a != null) {
      this.a.setAnchor(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(186154);
  }
  
  public void setContentDescription(String paramString)
  {
    AppMethodBeat.i(186166);
    if (this.a != null) {
      this.a.setContentDescription(paramString);
    }
    AppMethodBeat.o(186166);
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    AppMethodBeat.i(186155);
    if (this.a != null) {
      this.a.setDraggable(paramBoolean);
    }
    AppMethodBeat.o(186155);
  }
  
  public void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(186156);
    if ((this.a != null) && (paramBitmapDescriptor != null)) {
      this.a.setIcon(BitmapDescriptorFactory.fromBitmap(paramBitmapDescriptor.getBitmap()));
    }
    AppMethodBeat.o(186156);
  }
  
  public void setInfoWindowHideAnimation(Animation paramAnimation) {}
  
  public void setInfoWindowShowAnimation(Animation paramAnimation) {}
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(181204);
    if (this.a != null) {
      this.a.setLevel(paramInt);
    }
    AppMethodBeat.o(181204);
  }
  
  public void setMarkerView(View paramView)
  {
    AppMethodBeat.i(186163);
    if (this.a != null) {
      this.a.setIcon(BitmapDescriptorFactory.fromView(paramView));
    }
    AppMethodBeat.o(186163);
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    AppMethodBeat.i(186157);
    if (this.a != null) {
      this.a.setPosition(q.a(paramLatLng));
    }
    AppMethodBeat.o(186157);
  }
  
  public void setRotation(float paramFloat)
  {
    AppMethodBeat.i(186158);
    if (this.a != null) {
      this.a.setRotation(paramFloat);
    }
    AppMethodBeat.o(186158);
  }
  
  public void setSnippet(String paramString)
  {
    AppMethodBeat.i(186159);
    if (this.a != null) {
      this.a.setSnippet(paramString);
    }
    AppMethodBeat.o(186159);
  }
  
  public void setTag(Object paramObject)
  {
    AppMethodBeat.i(186165);
    if (this.a != null) {
      this.a.setTag(paramObject);
    }
    AppMethodBeat.o(186165);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(186160);
    if (this.a != null) {
      this.a.setTitle(paramString);
    }
    AppMethodBeat.o(186160);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(181206);
    if (this.a != null) {
      this.a.setVisible(paramBoolean);
    }
    AppMethodBeat.o(181206);
  }
  
  public void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(181202);
    if (this.a != null) {
      this.a.setZIndex(paramFloat);
    }
    AppMethodBeat.o(181202);
  }
  
  public void showInfoWindow()
  {
    AppMethodBeat.i(186161);
    if (this.a != null) {
      this.a.showInfoWindow();
    }
    AppMethodBeat.o(186161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.j
 * JD-Core Version:    0.7.0.1
 */