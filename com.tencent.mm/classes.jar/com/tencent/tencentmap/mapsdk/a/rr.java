package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.map.UiSettings;

public class rr
  implements UiSettings
{
  private aj a;
  
  public rr(aj paramaj)
  {
    this.a = paramaj;
  }
  
  public boolean isAnimationEnabled()
  {
    return false;
  }
  
  public boolean isCompassEnabled()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.a();
  }
  
  public boolean isIndoorLevelPickerEnabled()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.d();
  }
  
  public boolean isRotateGesturesEnabled()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.c();
  }
  
  public boolean isScaleControlsEnabled()
  {
    if (this.a != null) {
      return this.a.e();
    }
    return false;
  }
  
  public boolean isTiltGesturesEnabled()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.b();
  }
  
  public void setAllGesturesEnabled(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.g(paramBoolean);
    }
  }
  
  public void setAnimationEnabled(boolean paramBoolean) {}
  
  public void setCompassEnabled(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.b(paramBoolean);
  }
  
  public void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.j(paramBoolean);
    }
  }
  
  public void setLogoPosition(int paramInt)
  {
    if (this.a != null) {
      this.a.b(paramInt);
    }
  }
  
  public void setLogoPosition(int paramInt, int[] paramArrayOfInt)
  {
    if (this.a != null) {
      this.a.a(paramInt, paramArrayOfInt);
    }
  }
  
  public void setLogoScale(float paramFloat)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramFloat);
  }
  
  public void setRotateGesturesEnabled(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.f(paramBoolean);
  }
  
  public void setScaleControlsEnabled(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.h(paramBoolean);
    }
  }
  
  public void setScaleViewPosition(int paramInt)
  {
    if (this.a != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.a.a(paramInt);
      return;
      paramInt = 4;
      continue;
      paramInt = 1;
    }
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.c(paramBoolean);
    }
  }
  
  public void setTiltGesturesEnabled(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.e(paramBoolean);
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.d(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rr
 * JD-Core Version:    0.7.0.1
 */