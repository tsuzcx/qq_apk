package com.tencent.tencentmap.mapsdk.map;

public abstract interface UiSettings
{
  @Deprecated
  public static final int LOGO_POSITION_CENTER_BOTTOM = 4;
  @Deprecated
  public static final int LOGO_POSITION_CENTER_TOP = 5;
  public static final int LOGO_POSITION_LEFT_BOTTOM = 0;
  public static final int LOGO_POSITION_LEFT_TOP = 3;
  public static final int LOGO_POSITION_RIGHT_BOTTOM = 1;
  public static final int LOGO_POSITION_RIGHT_TOP = 2;
  public static final int SCALEVIEW_POSITION_CENTER_BOTTOM = 1;
  public static final int SCALEVIEW_POSITION_LEFT_BOTTOM = 0;
  public static final int SCALEVIEW_POSITION_RIGHT_BOTTOM = 2;
  
  public abstract boolean isAnimationEnabled();
  
  public abstract boolean isCompassEnabled();
  
  public abstract boolean isIndoorLevelPickerEnabled();
  
  public abstract boolean isRotateGesturesEnabled();
  
  public abstract boolean isScaleControlsEnabled();
  
  public abstract boolean isTiltGesturesEnabled();
  
  public abstract void setAllGesturesEnabled(boolean paramBoolean);
  
  public abstract void setAnimationEnabled(boolean paramBoolean);
  
  public abstract void setCompassEnabled(boolean paramBoolean);
  
  public abstract void setIndoorLevelPickerEnabled(boolean paramBoolean);
  
  public abstract void setLogoPosition(int paramInt);
  
  public abstract void setLogoPosition(int paramInt, int[] paramArrayOfInt);
  
  public abstract void setLogoScale(float paramFloat);
  
  public abstract void setRotateGesturesEnabled(boolean paramBoolean);
  
  public abstract void setScaleControlsEnabled(boolean paramBoolean);
  
  public abstract void setScaleViewPosition(int paramInt);
  
  public abstract void setScrollGesturesEnabled(boolean paramBoolean);
  
  public abstract void setTiltGesturesEnabled(boolean paramBoolean);
  
  public abstract void setZoomGesturesEnabled(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.UiSettings
 * JD-Core Version:    0.7.0.1
 */