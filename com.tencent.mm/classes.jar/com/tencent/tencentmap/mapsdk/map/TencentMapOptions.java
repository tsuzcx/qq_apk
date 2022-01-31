package com.tencent.tencentmap.mapsdk.map;

import android.view.Surface;

public class TencentMapOptions
{
  public static final int MAPTYPE_RASTER = 0;
  public static final int MAPTYPE_VECTOR = 1;
  private boolean enableHandDrawMap = false;
  private boolean isMutipleInfowindowEnabled = false;
  private Surface mExtSurface;
  private int mMapType = 1;
  private String mSubId;
  private String mSubKey;
  
  @Deprecated
  public TencentMapOptions enableHandDrawMap(boolean paramBoolean)
  {
    setHandDrawMapEnable(paramBoolean);
    return this;
  }
  
  public Surface getExtSurface()
  {
    return this.mExtSurface;
  }
  
  public int getMapType()
  {
    return this.mMapType;
  }
  
  public final String getSubId()
  {
    return this.mSubId;
  }
  
  public final String getSubKey()
  {
    return this.mSubKey;
  }
  
  public boolean isHandDrawMapEnable()
  {
    return this.enableHandDrawMap;
  }
  
  public boolean isMutipleInfowindowEnabled()
  {
    return this.isMutipleInfowindowEnabled;
  }
  
  public void setExtSurface(Surface paramSurface)
  {
    this.mExtSurface = paramSurface;
  }
  
  public void setHandDrawMapEnable(boolean paramBoolean)
  {
    this.enableHandDrawMap = paramBoolean;
  }
  
  public void setMapType(int paramInt)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 1) {}
    }
    else
    {
      i = 1;
    }
    this.mMapType = i;
  }
  
  public void setMutipleInfowindowEnabled(boolean paramBoolean)
  {
    this.isMutipleInfowindowEnabled = paramBoolean;
  }
  
  public final void setSubInfo(String paramString1, String paramString2)
  {
    this.mSubId = paramString2;
    this.mSubKey = paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.TencentMapOptions
 * JD-Core Version:    0.7.0.1
 */