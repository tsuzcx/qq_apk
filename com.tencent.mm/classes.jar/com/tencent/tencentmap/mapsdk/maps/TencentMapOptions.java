package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.net.AdapterType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;
import java.lang.reflect.Field;
import java.util.Arrays;

public final class TencentMapOptions
{
  public static final int LOGO_POSITION_BOTTOM_CENTER = 4;
  public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
  public static final int LOGO_POSITION_BOTTOM_RIGHT = 1;
  public static final int LOGO_POSITION_TOP_CENTER = 5;
  public static final int LOGO_POSITION_TOP_LEFT = 3;
  public static final int LOGO_POSITION_TOP_RIGHT = 2;
  public static final int SCALEVIEW_POSITION_BOTTOM_CENTER = 4;
  public static final int SCALEVIEW_POSITION_BOTTOM_LEFT = 0;
  public static final int SCALEVIEW_POSITION_BOTTOM_RIGHT = 1;
  public static final int SCALEVIEW_POSITION_TOP_CENTER = 5;
  public static final int SCALEVIEW_POSITION_TOP_LEFT = 3;
  public static final int SCALEVIEW_POSITION_TOP_RIGHT = 2;
  public static final int ZOOM_POSITION_BOTTOM_LEFT = 0;
  public static final int ZOOM_POSITION_BOTTOM_RIGHT = 1;
  public static final int ZOOM_POSITION_TOP_LEFT = 3;
  public static final int ZOOM_POSITION_TOP_RIGHT = 2;
  private String customAssetsPath;
  private String customLocalPath;
  private boolean isEnableMultipleInfoWindow = false;
  private boolean isHandDrawMapEnable = false;
  private String mCustomUserId;
  private String[] mDebugTags;
  private Object mExtSurface;
  private int mExtSurfaceHeight;
  private int mExtSurfaceWidth;
  private Callback<TencentMap> mMapCallback;
  private TencentMapOptions.IMapKernel mMapKernel;
  private String mMapKey;
  private MapViewType mMapViewType;
  private AdapterType mNetAdapterType = AdapterType.DEFAULT;
  private Bundle mNetParams;
  private Object mProtocolDataDesc;
  private int mProtocolFrom;
  private String mSatelliteVersion = "0";
  private String mSubId;
  private String mSubKey;
  private Typeface mUserTypeface;
  
  private void setTypeface(Typeface paramTypeface, boolean paramBoolean)
  {
    AppMethodBeat.i(181044);
    if (paramTypeface == null)
    {
      AppMethodBeat.o(181044);
      return;
    }
    if (paramBoolean) {
      try
      {
        Field localField = Typeface.class.getDeclaredField("DEFAULT");
        localField.setAccessible(true);
        localField.set(Typeface.DEFAULT, paramTypeface);
        AppMethodBeat.o(181044);
        return;
      }
      catch (NoSuchFieldException paramTypeface)
      {
        AppMethodBeat.o(181044);
        return;
      }
      catch (IllegalAccessException paramTypeface)
      {
        AppMethodBeat.o(181044);
        return;
      }
    }
    this.mUserTypeface = paramTypeface;
    AppMethodBeat.o(181044);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(181046);
    if (this == paramObject)
    {
      AppMethodBeat.o(181046);
      return true;
    }
    if (!(paramObject instanceof TencentMapOptions))
    {
      AppMethodBeat.o(181046);
      return false;
    }
    paramObject = (TencentMapOptions)paramObject;
    if (this.isHandDrawMapEnable != paramObject.isHandDrawMapEnable)
    {
      AppMethodBeat.o(181046);
      return false;
    }
    if (this.mExtSurfaceWidth != paramObject.mExtSurfaceWidth)
    {
      AppMethodBeat.o(181046);
      return false;
    }
    if (this.mExtSurfaceHeight != paramObject.mExtSurfaceHeight)
    {
      AppMethodBeat.o(181046);
      return false;
    }
    if (this.isEnableMultipleInfoWindow != paramObject.isEnableMultipleInfoWindow)
    {
      AppMethodBeat.o(181046);
      return false;
    }
    if (this.mProtocolFrom != paramObject.mProtocolFrom)
    {
      AppMethodBeat.o(181046);
      return false;
    }
    if (this.customAssetsPath != null)
    {
      if (this.customAssetsPath.equals(paramObject.customAssetsPath)) {}
    }
    else {
      while (paramObject.customAssetsPath != null)
      {
        AppMethodBeat.o(181046);
        return false;
      }
    }
    if (this.customLocalPath != null)
    {
      if (this.customLocalPath.equals(paramObject.customLocalPath)) {}
    }
    else {
      while (paramObject.customLocalPath != null)
      {
        AppMethodBeat.o(181046);
        return false;
      }
    }
    if (this.mExtSurface != null)
    {
      if (this.mExtSurface.equals(paramObject.mExtSurface)) {}
    }
    else {
      while (paramObject.mExtSurface != null)
      {
        AppMethodBeat.o(181046);
        return false;
      }
    }
    if (this.mSubId != null)
    {
      if (this.mSubId.equals(paramObject.mSubId)) {}
    }
    else {
      while (paramObject.mSubId != null)
      {
        AppMethodBeat.o(181046);
        return false;
      }
    }
    if (this.mSubKey != null)
    {
      if (this.mSubKey.equals(paramObject.mSubKey)) {}
    }
    else {
      while (paramObject.mSubKey != null)
      {
        AppMethodBeat.o(181046);
        return false;
      }
    }
    if (this.mMapKey != null)
    {
      if (this.mMapKey.equals(paramObject.mMapKey)) {}
    }
    else {
      while (paramObject.mMapKey != null)
      {
        AppMethodBeat.o(181046);
        return false;
      }
    }
    if (!Arrays.equals(this.mDebugTags, paramObject.mDebugTags))
    {
      AppMethodBeat.o(181046);
      return false;
    }
    if (this.mSatelliteVersion != null)
    {
      if (this.mSatelliteVersion.equals(paramObject.mSatelliteVersion)) {}
    }
    else {
      while (paramObject.mSatelliteVersion != null)
      {
        AppMethodBeat.o(181046);
        return false;
      }
    }
    if (this.mMapViewType != paramObject.mMapViewType)
    {
      AppMethodBeat.o(181046);
      return false;
    }
    if (this.mMapKernel != null)
    {
      if (this.mMapKernel.equals(paramObject.mMapKernel)) {}
    }
    else {
      while (paramObject.mMapKernel != null)
      {
        AppMethodBeat.o(181046);
        return false;
      }
    }
    if (this.mUserTypeface != null)
    {
      if (this.mUserTypeface.equals(paramObject.mUserTypeface)) {}
    }
    else {
      while (paramObject.mUserTypeface != null)
      {
        AppMethodBeat.o(181046);
        return false;
      }
    }
    if (this.mProtocolDataDesc != null)
    {
      if (this.mProtocolDataDesc.equals(paramObject.mProtocolDataDesc)) {}
    }
    else {
      while (paramObject.mProtocolDataDesc != null)
      {
        AppMethodBeat.o(181046);
        return false;
      }
    }
    if (this.mNetAdapterType != paramObject.mNetAdapterType)
    {
      AppMethodBeat.o(181046);
      return false;
    }
    if (this.mCustomUserId != paramObject.mCustomUserId)
    {
      AppMethodBeat.o(181046);
      return false;
    }
    if (this.mNetParams != null)
    {
      boolean bool = this.mNetParams.equals(paramObject.mNetParams);
      AppMethodBeat.o(181046);
      return bool;
    }
    if (paramObject.mNetParams == null)
    {
      AppMethodBeat.o(181046);
      return true;
    }
    AppMethodBeat.o(181046);
    return false;
  }
  
  public final String getCustomAssetsPath()
  {
    return this.customAssetsPath;
  }
  
  public final String getCustomLocalPath()
  {
    return this.customLocalPath;
  }
  
  public final String getCustomUserId()
  {
    return this.mCustomUserId;
  }
  
  public final String[] getDebugTags()
  {
    return this.mDebugTags;
  }
  
  public final Object getExtSurface()
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
  
  public final Callback<TencentMap> getMapAsyncCallback()
  {
    return this.mMapCallback;
  }
  
  public final TencentMapOptions.IMapKernel getMapKernel()
  {
    return this.mMapKernel;
  }
  
  public final String getMapKey()
  {
    return this.mMapKey;
  }
  
  public final MapViewType getMapViewType()
  {
    return this.mMapViewType;
  }
  
  public final AdapterType getNetAdapterType()
  {
    return this.mNetAdapterType;
  }
  
  public final Bundle getNetParams()
  {
    return this.mNetParams;
  }
  
  public final Object getProtocolDataDesc()
  {
    return this.mProtocolDataDesc;
  }
  
  public final int getProtocolFrom()
  {
    return this.mProtocolFrom;
  }
  
  public final String getSatelliteVersion()
  {
    return this.mSatelliteVersion;
  }
  
  public final String getSubId()
  {
    return this.mSubId;
  }
  
  public final String getSubKey()
  {
    return this.mSubKey;
  }
  
  public final Typeface getTypeface()
  {
    if (this.mUserTypeface == null) {
      return Typeface.DEFAULT;
    }
    return this.mUserTypeface;
  }
  
  public final int hashCode()
  {
    int i3 = 1;
    int i11 = 0;
    AppMethodBeat.i(181047);
    int i;
    int j;
    label41:
    int k;
    label50:
    int m;
    label66:
    int i12;
    int i13;
    int n;
    label94:
    int i1;
    label110:
    int i2;
    label126:
    int i14;
    label133:
    int i4;
    label158:
    int i5;
    label174:
    int i6;
    label190:
    int i7;
    label206:
    int i15;
    int i8;
    label228:
    int i9;
    if (this.customAssetsPath != null)
    {
      i = this.customAssetsPath.hashCode();
      if (this.customLocalPath == null) {
        break label400;
      }
      j = this.customLocalPath.hashCode();
      if (!this.isHandDrawMapEnable) {
        break label405;
      }
      k = 1;
      if (this.mExtSurface == null) {
        break label410;
      }
      m = this.mExtSurface.hashCode();
      i12 = this.mExtSurfaceWidth;
      i13 = this.mExtSurfaceHeight;
      if (this.mSubId == null) {
        break label416;
      }
      n = this.mSubId.hashCode();
      if (this.mSubKey == null) {
        break label422;
      }
      i1 = this.mSubKey.hashCode();
      if (this.mMapKey == null) {
        break label428;
      }
      i2 = this.mMapKey.hashCode();
      if (!this.isEnableMultipleInfoWindow) {
        break label434;
      }
      i14 = Arrays.hashCode(this.mDebugTags);
      if (this.mSatelliteVersion == null) {
        break label440;
      }
      i4 = this.mSatelliteVersion.hashCode();
      if (this.mMapViewType == null) {
        break label446;
      }
      i5 = this.mMapViewType.hashCode();
      if (this.mMapKernel == null) {
        break label452;
      }
      i6 = this.mMapKernel.hashCode();
      if (this.mUserTypeface == null) {
        break label458;
      }
      i7 = this.mUserTypeface.hashCode();
      i15 = this.mProtocolFrom;
      if (this.mProtocolDataDesc == null) {
        break label464;
      }
      i8 = this.mProtocolDataDesc.hashCode();
      if (this.mNetAdapterType == null) {
        break label470;
      }
      i9 = this.mNetAdapterType.hashCode();
      label244:
      if (this.mNetParams == null) {
        break label476;
      }
    }
    label400:
    label405:
    label410:
    label416:
    label422:
    label428:
    label434:
    label440:
    label446:
    label452:
    label458:
    label464:
    label470:
    label476:
    for (int i10 = this.mNetParams.hashCode();; i10 = 0)
    {
      if (this.mCustomUserId != null) {
        i11 = this.mCustomUserId.hashCode();
      }
      AppMethodBeat.o(181047);
      return (i10 + (i9 + (i8 + ((i7 + (i6 + (i5 + (i4 + (((i2 + (i1 + (n + (((m + (k + (j + i * 31) * 31) * 31) * 31 + i12) * 31 + i13) * 31) * 31) * 31) * 31 + i3) * 31 + i14) * 31) * 31) * 31) * 31) * 31 + i15) * 31) * 31) * 31) * 31 + i11;
      i = 0;
      break;
      j = 0;
      break label41;
      k = 0;
      break label50;
      m = 0;
      break label66;
      n = 0;
      break label94;
      i1 = 0;
      break label110;
      i2 = 0;
      break label126;
      i3 = 0;
      break label133;
      i4 = 0;
      break label158;
      i5 = 0;
      break label174;
      i6 = 0;
      break label190;
      i7 = 0;
      break label206;
      i8 = 0;
      break label228;
      i9 = 0;
      break label244;
    }
  }
  
  public final boolean isHandDrawMapEnable()
  {
    return this.isHandDrawMapEnable;
  }
  
  public final boolean isMultipleInfoWindowEnable()
  {
    return this.isEnableMultipleInfoWindow;
  }
  
  public final void openDebugLogByTags(String... paramVarArgs)
  {
    this.mDebugTags = paramVarArgs;
  }
  
  public final void setCustomAssetsPath(String paramString)
  {
    this.customAssetsPath = paramString;
  }
  
  public final void setCustomLocalPath(String paramString)
  {
    this.customLocalPath = paramString;
  }
  
  public final TencentMapOptions setCustomUserID(String paramString)
  {
    this.mCustomUserId = paramString;
    return this;
  }
  
  public final void setExtSurface(Object paramObject)
  {
    AppMethodBeat.i(181042);
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture)) && (!(paramObject instanceof SurfaceHolder)))
    {
      paramObject = new IllegalArgumentException("Parameter Surface should be Surface,SurfaceTexture or SurfaceHolder");
      AppMethodBeat.o(181042);
      throw paramObject;
    }
    this.mExtSurface = paramObject;
    AppMethodBeat.o(181042);
  }
  
  public final void setExtSurfaceDimension(int paramInt1, int paramInt2)
  {
    this.mExtSurfaceWidth = paramInt1;
    this.mExtSurfaceHeight = paramInt2;
  }
  
  public final TencentMapOptions setGetMapAsync(Callback<TencentMap> paramCallback)
  {
    this.mMapCallback = paramCallback;
    return this;
  }
  
  public final TencentMapOptions setHandDrawMapEnable(boolean paramBoolean)
  {
    this.isHandDrawMapEnable = paramBoolean;
    return this;
  }
  
  public final TencentMapOptions setMapKernel(TencentMapOptions.IMapKernel paramIMapKernel)
  {
    this.mMapKernel = paramIMapKernel;
    return this;
  }
  
  public final void setMapKey(String paramString)
  {
    this.mMapKey = paramString;
  }
  
  public final TencentMapOptions setMapViewType(MapViewType paramMapViewType)
  {
    this.mMapViewType = paramMapViewType;
    return this;
  }
  
  public final void setMultipleInfoWindowEnable(boolean paramBoolean)
  {
    this.isEnableMultipleInfoWindow = paramBoolean;
  }
  
  public final TencentMapOptions setNetAdapter(AdapterType paramAdapterType, Bundle paramBundle)
  {
    this.mNetAdapterType = paramAdapterType;
    this.mNetParams = paramBundle;
    return this;
  }
  
  public final TencentMapOptions setSatelliteVersion(String paramString)
  {
    this.mSatelliteVersion = paramString;
    return this;
  }
  
  public final TencentMapOptions setServiceProtocol(int paramInt, Object paramObject)
  {
    this.mProtocolFrom = paramInt;
    this.mProtocolDataDesc = paramObject;
    return this;
  }
  
  public final void setSubInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(181045);
    if (paramString1 != null) {}
    for (this.mSubKey = paramString1.trim(); paramString2 != null; this.mSubKey = "")
    {
      this.mSubId = paramString2.trim();
      AppMethodBeat.o(181045);
      return;
    }
    this.mSubId = "";
    AppMethodBeat.o(181045);
  }
  
  public final void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(181043);
    setTypeface(paramTypeface, false);
    AppMethodBeat.o(181043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.TencentMapOptions
 * JD-Core Version:    0.7.0.1
 */