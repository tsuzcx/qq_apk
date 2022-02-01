package com.tencent.tencentmap.mapsdk.map;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentMapOptions
{
  public static final int GL_MAP_VIEW = 0;
  public static final int MAP_RENDER_LAYER = 2;
  public static final int TEXTURE_MAP_VIEW = 1;
  private boolean enableHandDrawMap = false;
  private boolean isMutipleInfowindowEnabled = false;
  private Object mExtSurface;
  private int mExtSurfaceHeight;
  private int mExtSurfaceWidth;
  private int mMapType = 0;
  private String mSubId;
  private String mSubKey;
  
  @Deprecated
  public TencentMapOptions enableHandDrawMap(boolean paramBoolean)
  {
    AppMethodBeat.i(87486);
    setHandDrawMapEnable(paramBoolean);
    AppMethodBeat.o(87486);
    return this;
  }
  
  public Object getExtSurface()
  {
    return this.mExtSurface;
  }
  
  public final int getExtSurfaceHeight()
  {
    return this.mExtSurfaceHeight;
  }
  
  public final int getExtSurfaceWidth()
  {
    return this.mExtSurfaceWidth;
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
  
  public void setExtSurface(Object paramObject)
  {
    AppMethodBeat.i(87485);
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture)) && (!(paramObject instanceof SurfaceHolder)))
    {
      paramObject = new IllegalArgumentException("Parameter Surface should be Surface,SurfaceTexture or SurfaceHolder");
      AppMethodBeat.o(87485);
      throw paramObject;
    }
    this.mExtSurface = paramObject;
    AppMethodBeat.o(87485);
  }
  
  public final void setExtSurfaceDimension(int paramInt1, int paramInt2)
  {
    this.mExtSurfaceWidth = paramInt1;
    this.mExtSurfaceHeight = paramInt2;
  }
  
  public void setHandDrawMapEnable(boolean paramBoolean)
  {
    this.enableHandDrawMap = paramBoolean;
  }
  
  public void setMapType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2)) {
      return;
    }
    this.mMapType = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.TencentMapOptions
 * JD-Core Version:    0.7.0.1
 */