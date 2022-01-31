package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import java.util.Iterator;
import java.util.List;

public class rl
  implements Marker
{
  private qf a;
  private rp b;
  
  public rl(rp paramrp, qf paramqf)
  {
    this.b = paramrp;
    this.a = paramqf;
    if ((this.b != null) && (this.b.a() != null)) {
      try
      {
        this.b.a().add(this.a);
        return;
      }
      finally {}
    }
  }
  
  public float getAlpha()
  {
    if (this.a != null) {
      return this.a.h();
    }
    return 0.0F;
  }
  
  public String getId()
  {
    if (this.a != null) {
      return this.a.c();
    }
    return "";
  }
  
  public View getMarkerView()
  {
    return null;
  }
  
  public LatLng getPosition()
  {
    if (this.a != null) {
      return rq.a(this.a.e());
    }
    return null;
  }
  
  public float getRotation()
  {
    if (this.a != null) {
      return this.a.m();
    }
    return 0.0F;
  }
  
  public String getSnippet()
  {
    if (this.a != null) {
      return this.a.g();
    }
    return null;
  }
  
  public Object getTag()
  {
    if (this.a != null) {
      return this.a.t();
    }
    return null;
  }
  
  public String getTitle()
  {
    if (this.a != null) {
      return this.a.f();
    }
    return null;
  }
  
  public float getZIndex()
  {
    if (this.a != null) {
      return this.a.p();
    }
    return 0.0F;
  }
  
  public void hideInfoWindow()
  {
    if (this.a != null) {
      this.a.k();
    }
  }
  
  public boolean isDraggable()
  {
    if (this.a != null) {
      return this.a.i();
    }
    return false;
  }
  
  public boolean isInfoWindowShown()
  {
    if (this.a != null) {
      return this.a.l();
    }
    return false;
  }
  
  public boolean isVisible()
  {
    if (this.a != null) {
      return this.a.n();
    }
    return false;
  }
  
  public void remove()
  {
    if (this.a != null) {}
    try
    {
      if ((this.b != null) && (this.b.a() != null)) {
        this.b.a().remove(this.a);
      }
      this.a.b();
      return;
    }
    finally {}
  }
  
  public void set2Top()
  {
    if ((this.b == null) || (this.b.a() == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = this.b.a().size();
        Object localObject1 = this.b.a().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          qf localqf = (qf)((Iterator)localObject1).next();
          if (localqf.p() <= i) {
            break label128;
          }
          i = (int)localqf.p();
          break;
        }
        localObject1 = this.a;
        if (i < 2147483647)
        {
          f = i + 1;
          ((qf)localObject1).c(f);
          return;
        }
      }
      finally {}
      float f = 2.147484E+009F;
    }
    label128:
    for (;;)
    {
      break;
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    if (this.a != null) {
      this.a.b(paramFloat);
    }
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    if (this.a != null) {
      this.a.a(paramFloat1, paramFloat2);
    }
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
  
  public void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    if ((this.a != null) && (paramBitmapDescriptor != null)) {
      this.a.a(ps.a(paramBitmapDescriptor.getBitmap()));
    }
  }
  
  public void setInfoWindowHideAnimation(Animation paramAnimation) {}
  
  public void setInfoWindowShowAnimation(Animation paramAnimation) {}
  
  public void setMarkerView(View paramView)
  {
    if (this.a != null) {
      this.a.a(ps.a(paramView));
    }
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    if (this.a != null) {
      this.a.a(rq.a(paramLatLng));
    }
  }
  
  public void setRotation(float paramFloat)
  {
    if (this.a != null) {
      this.a.a(paramFloat);
    }
  }
  
  public void setSnippet(String paramString)
  {
    if (this.a != null) {
      this.a.b(paramString);
    }
  }
  
  public void setTag(Object paramObject)
  {
    if (this.a != null) {
      this.a.a(paramObject);
    }
  }
  
  public void setTitle(String paramString)
  {
    if (this.a != null) {
      this.a.a(paramString);
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.b(paramBoolean);
    }
  }
  
  public void setZIndex(float paramFloat)
  {
    if (this.a != null) {
      this.a.c(paramFloat);
    }
  }
  
  public void showInfoWindow()
  {
    if (this.a != null) {
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rl
 * JD-Core Version:    0.7.0.1
 */