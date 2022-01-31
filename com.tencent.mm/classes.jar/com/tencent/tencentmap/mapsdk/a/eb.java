package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public class eb
  implements Marker
{
  private dc a;
  private ef b;
  
  public eb(ef paramef, dc paramdc)
  {
    AppMethodBeat.i(150168);
    this.b = paramef;
    this.a = paramdc;
    if ((this.b != null) && (this.b.a() != null)) {
      try
      {
        this.b.a().add(this.a);
        return;
      }
      finally
      {
        AppMethodBeat.o(150168);
      }
    }
    AppMethodBeat.o(150168);
  }
  
  public float getAlpha()
  {
    AppMethodBeat.i(150169);
    if (this.a != null)
    {
      float f = this.a.h();
      AppMethodBeat.o(150169);
      return f;
    }
    AppMethodBeat.o(150169);
    return 0.0F;
  }
  
  public String getContentDescription()
  {
    AppMethodBeat.i(150191);
    if (this.a != null)
    {
      String str = this.a.u();
      AppMethodBeat.o(150191);
      return str;
    }
    AppMethodBeat.o(150191);
    return null;
  }
  
  public String getId()
  {
    AppMethodBeat.i(101346);
    if (this.a != null)
    {
      String str = this.a.c();
      AppMethodBeat.o(101346);
      return str;
    }
    AppMethodBeat.o(101346);
    return "";
  }
  
  public int getLevel()
  {
    AppMethodBeat.i(101360);
    if (this.a != null)
    {
      int i = this.a.v();
      AppMethodBeat.o(101360);
      return i;
    }
    AppMethodBeat.o(101360);
    return 0;
  }
  
  public View getMarkerView()
  {
    return null;
  }
  
  public LatLng getPosition()
  {
    AppMethodBeat.i(150170);
    if (this.a != null)
    {
      LatLng localLatLng = eh.a(this.a.e());
      AppMethodBeat.o(150170);
      return localLatLng;
    }
    AppMethodBeat.o(150170);
    return null;
  }
  
  public float getRotation()
  {
    AppMethodBeat.i(150171);
    if (this.a != null)
    {
      float f = this.a.m();
      AppMethodBeat.o(150171);
      return f;
    }
    AppMethodBeat.o(150171);
    return 0.0F;
  }
  
  public String getSnippet()
  {
    AppMethodBeat.i(150172);
    if (this.a != null)
    {
      String str = this.a.g();
      AppMethodBeat.o(150172);
      return str;
    }
    AppMethodBeat.o(150172);
    return null;
  }
  
  public Object getTag()
  {
    AppMethodBeat.i(150188);
    if (this.a != null)
    {
      Object localObject = this.a.t();
      AppMethodBeat.o(150188);
      return localObject;
    }
    AppMethodBeat.o(150188);
    return null;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(150173);
    if (this.a != null)
    {
      String str = this.a.f();
      AppMethodBeat.o(150173);
      return str;
    }
    AppMethodBeat.o(150173);
    return null;
  }
  
  public float getZIndex()
  {
    AppMethodBeat.i(101358);
    if (this.a != null)
    {
      float f = this.a.p();
      AppMethodBeat.o(101358);
      return f;
    }
    AppMethodBeat.o(101358);
    return 0.0F;
  }
  
  public void hideInfoWindow()
  {
    AppMethodBeat.i(150174);
    if (this.a != null) {
      this.a.k();
    }
    AppMethodBeat.o(150174);
  }
  
  public boolean isDraggable()
  {
    AppMethodBeat.i(150175);
    if (this.a != null)
    {
      boolean bool = this.a.i();
      AppMethodBeat.o(150175);
      return bool;
    }
    AppMethodBeat.o(150175);
    return false;
  }
  
  public boolean isInfoWindowShown()
  {
    AppMethodBeat.i(150176);
    if (this.a != null)
    {
      boolean bool = this.a.l();
      AppMethodBeat.o(150176);
      return bool;
    }
    AppMethodBeat.o(150176);
    return false;
  }
  
  public boolean isVisible()
  {
    AppMethodBeat.i(101362);
    if (this.a != null)
    {
      boolean bool = this.a.n();
      AppMethodBeat.o(101362);
      return bool;
    }
    AppMethodBeat.o(101362);
    return false;
  }
  
  public void remove()
  {
    AppMethodBeat.i(101345);
    if (this.a != null) {}
    try
    {
      if ((this.b != null) && (this.b.a() != null)) {
        this.b.a().remove(this.a);
      }
      this.a.b();
      AppMethodBeat.o(101345);
      return;
    }
    finally
    {
      AppMethodBeat.o(101345);
    }
  }
  
  public void set2Top()
  {
    AppMethodBeat.i(150186);
    if ((this.b == null) || (this.b.a() == null))
    {
      AppMethodBeat.o(150186);
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
          dc localdc = (dc)((Iterator)localObject1).next();
          if (localdc.p() <= i) {
            break;
          }
          i = (int)localdc.p();
        }
        else
        {
          localObject1 = this.a;
          if (i < 2147483647) {}
          for (float f = i + 1;; f = 2.147484E+009F)
          {
            ((dc)localObject1).c(f);
            return;
          }
        }
      }
    }
    finally
    {
      AppMethodBeat.o(150186);
    }
    for (;;) {}
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(150177);
    if (this.a != null) {
      this.a.b(paramFloat);
    }
    AppMethodBeat.o(150177);
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150178);
    if (this.a != null) {
      this.a.a(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(150178);
  }
  
  public void setContentDescription(String paramString)
  {
    AppMethodBeat.i(150190);
    if (this.a != null) {
      this.a.c(paramString);
    }
    AppMethodBeat.o(150190);
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    AppMethodBeat.i(150179);
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
    AppMethodBeat.o(150179);
  }
  
  public void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(150180);
    if ((this.a != null) && (paramBitmapDescriptor != null)) {
      this.a.a(cl.a(paramBitmapDescriptor.getBitmap()));
    }
    AppMethodBeat.o(150180);
  }
  
  public void setInfoWindowHideAnimation(Animation paramAnimation) {}
  
  public void setInfoWindowShowAnimation(Animation paramAnimation) {}
  
  public void setLevel(int paramInt)
  {
    AppMethodBeat.i(101359);
    if (this.a != null) {
      this.a.a(paramInt);
    }
    AppMethodBeat.o(101359);
  }
  
  public void setMarkerView(View paramView)
  {
    AppMethodBeat.i(150187);
    if (this.a != null) {
      this.a.a(cl.a(paramView));
    }
    AppMethodBeat.o(150187);
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    AppMethodBeat.i(150181);
    if (this.a != null) {
      this.a.a(eh.a(paramLatLng));
    }
    AppMethodBeat.o(150181);
  }
  
  public void setRotation(float paramFloat)
  {
    AppMethodBeat.i(150182);
    if (this.a != null) {
      this.a.a(paramFloat);
    }
    AppMethodBeat.o(150182);
  }
  
  public void setSnippet(String paramString)
  {
    AppMethodBeat.i(150183);
    if (this.a != null) {
      this.a.b(paramString);
    }
    AppMethodBeat.o(150183);
  }
  
  public void setTag(Object paramObject)
  {
    AppMethodBeat.i(150189);
    if (this.a != null) {
      this.a.a(paramObject);
    }
    AppMethodBeat.o(150189);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(150184);
    if (this.a != null) {
      this.a.a(paramString);
    }
    AppMethodBeat.o(150184);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(101361);
    if (this.a != null) {
      this.a.b(paramBoolean);
    }
    AppMethodBeat.o(101361);
  }
  
  public void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(101357);
    if (this.a != null) {
      this.a.c(paramFloat);
    }
    AppMethodBeat.o(101357);
  }
  
  public void showInfoWindow()
  {
    AppMethodBeat.i(150185);
    if (this.a != null) {
      this.a.j();
    }
    AppMethodBeat.o(150185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.eb
 * JD-Core Version:    0.7.0.1
 */