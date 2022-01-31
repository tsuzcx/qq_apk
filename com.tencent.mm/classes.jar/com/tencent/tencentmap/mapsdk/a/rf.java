package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.map.UiSettings;

public class rf
  implements UiSettings
{
  private vd a;
  
  public rf(vd paramvd)
  {
    this.a = paramvd;
  }
  
  public boolean isAnimationEnabled()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return false;
  }
  
  public boolean isCompassEnabled()
  {
    return false;
  }
  
  public boolean isIndoorLevelPickerEnabled()
  {
    return false;
  }
  
  public boolean isRotateGesturesEnabled()
  {
    return false;
  }
  
  public boolean isScaleControlsEnabled()
  {
    if (this.a != null) {
      return this.a.b();
    }
    return false;
  }
  
  public boolean isTiltGesturesEnabled()
  {
    return false;
  }
  
  public void setAllGesturesEnabled(boolean paramBoolean)
  {
    if (this.a != null)
    {
      this.a.c(paramBoolean);
      this.a.d(paramBoolean);
    }
  }
  
  public void setAnimationEnabled(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
  
  public void setCompassEnabled(boolean paramBoolean) {}
  
  public void setIndoorLevelPickerEnabled(boolean paramBoolean) {}
  
  public void setLogoPosition(int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
  
  public void setLogoPosition(int paramInt, int[] paramArrayOfInt)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramInt, paramArrayOfInt);
  }
  
  public void setLogoScale(float paramFloat)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramFloat);
  }
  
  public void setRotateGesturesEnabled(boolean paramBoolean) {}
  
  public void setScaleControlsEnabled(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.b(paramBoolean);
    }
  }
  
  public void setScaleViewPosition(int paramInt)
  {
    if (this.a != null) {
      this.a.b(paramInt);
    }
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.c(paramBoolean);
    }
  }
  
  public void setTiltGesturesEnabled(boolean paramBoolean) {}
  
  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.d(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rf
 * JD-Core Version:    0.7.0.1
 */