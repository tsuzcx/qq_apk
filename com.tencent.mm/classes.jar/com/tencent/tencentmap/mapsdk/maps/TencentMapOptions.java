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
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
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
  private String mCustomCacheRootPath;
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
  private boolean mOfflineMapEnable;
  private OverSeaSource mOverSeaSource = OverSeaSource.DEFAULT;
  private Object mProtocolDataDesc;
  private int mProtocolFrom;
  private String mSatelliteVersion = "0";
  private String mSubId;
  private String mSubKey;
  private TrafficStyle mTrafficStyle;
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
    if (this.mOfflineMapEnable != paramObject.mOfflineMapEnable)
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
    if (this.mNetParams != null)
    {
      if (this.mNetParams.equals(paramObject.mNetParams)) {}
    }
    else {
      while (paramObject.mNetParams != null)
      {
        AppMethodBeat.o(181046);
        return false;
      }
    }
    if (this.mCustomUserId != null)
    {
      if (this.mCustomUserId.equals(paramObject.mCustomUserId)) {}
    }
    else {
      while (paramObject.mCustomUserId != null)
      {
        AppMethodBeat.o(181046);
        return false;
      }
    }
    if (this.mMapCallback != null)
    {
      if (this.mMapCallback.equals(paramObject.mMapCallback)) {}
    }
    else {
      while (paramObject.mMapCallback != null)
      {
        AppMethodBeat.o(181046);
        return false;
      }
    }
    if (this.mTrafficStyle != null)
    {
      if (this.mTrafficStyle.equals(paramObject.mTrafficStyle)) {}
    }
    else {
      while (paramObject.mTrafficStyle != null)
      {
        AppMethodBeat.o(181046);
        return false;
      }
    }
    if (this.mOverSeaSource == paramObject.mOverSeaSource)
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
  
  public final String getCustomCacheRootPath()
  {
    return this.mCustomCacheRootPath;
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
  
  public final OverSeaSource getOverSeaSource()
  {
    return this.mOverSeaSource;
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
  
  public final TrafficStyle getTrafficStyle()
  {
    return this.mTrafficStyle;
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
    int i13 = 1;
    int i15 = 0;
    AppMethodBeat.i(181047);
    int i;
    int j;
    label41:
    int k;
    label50:
    int m;
    label66:
    int i16;
    int i17;
    int n;
    label94:
    int i1;
    label110:
    int i2;
    label126:
    int i3;
    label136:
    int i18;
    int i4;
    label161:
    int i5;
    label177:
    int i6;
    label193:
    int i7;
    label209:
    int i19;
    int i8;
    label231:
    int i9;
    label247:
    int i10;
    label263:
    int i11;
    label279:
    int i12;
    if (this.customAssetsPath != null)
    {
      i = this.customAssetsPath.hashCode();
      if (this.customLocalPath == null) {
        break label482;
      }
      j = this.customLocalPath.hashCode();
      if (!this.isHandDrawMapEnable) {
        break label487;
      }
      k = 1;
      if (this.mExtSurface == null) {
        break label492;
      }
      m = this.mExtSurface.hashCode();
      i16 = this.mExtSurfaceWidth;
      i17 = this.mExtSurfaceHeight;
      if (this.mSubId == null) {
        break label498;
      }
      n = this.mSubId.hashCode();
      if (this.mSubKey == null) {
        break label504;
      }
      i1 = this.mSubKey.hashCode();
      if (this.mMapKey == null) {
        break label510;
      }
      i2 = this.mMapKey.hashCode();
      if (!this.isEnableMultipleInfoWindow) {
        break label516;
      }
      i3 = 1;
      i18 = Arrays.hashCode(this.mDebugTags);
      if (this.mSatelliteVersion == null) {
        break label522;
      }
      i4 = this.mSatelliteVersion.hashCode();
      if (this.mMapViewType == null) {
        break label528;
      }
      i5 = this.mMapViewType.hashCode();
      if (this.mMapKernel == null) {
        break label534;
      }
      i6 = this.mMapKernel.hashCode();
      if (this.mUserTypeface == null) {
        break label540;
      }
      i7 = this.mUserTypeface.hashCode();
      i19 = this.mProtocolFrom;
      if (this.mProtocolDataDesc == null) {
        break label546;
      }
      i8 = this.mProtocolDataDesc.hashCode();
      if (this.mNetAdapterType == null) {
        break label552;
      }
      i9 = this.mNetAdapterType.hashCode();
      if (this.mNetParams == null) {
        break label558;
      }
      i10 = this.mNetParams.hashCode();
      if (this.mCustomUserId == null) {
        break label564;
      }
      i11 = this.mCustomUserId.hashCode();
      if (this.mMapCallback == null) {
        break label570;
      }
      i12 = this.mMapCallback.hashCode();
      label295:
      if (!this.mOfflineMapEnable) {
        break label576;
      }
      label302:
      if (this.mOverSeaSource == null) {
        break label582;
      }
    }
    label516:
    label522:
    label528:
    label534:
    label540:
    label546:
    label552:
    label558:
    label564:
    label570:
    label576:
    label582:
    for (int i14 = this.mOverSeaSource.hashCode();; i14 = 0)
    {
      if (this.mTrafficStyle != null) {
        i15 = this.mTrafficStyle.hashCode();
      }
      AppMethodBeat.o(181047);
      return (i14 + ((i12 + (i11 + (i10 + (i9 + (i8 + ((i7 + (i6 + (i5 + (i4 + ((i3 + (i2 + (i1 + (n + (((m + (k + (j + i * 31) * 31) * 31) * 31 + i16) * 31 + i17) * 31) * 31) * 31) * 31) * 31 + i18) * 31) * 31) * 31) * 31) * 31 + i19) * 31) * 31) * 31) * 31) * 31) * 31 + i13) * 31) * 31 + i15;
      i = 0;
      break;
      label482:
      j = 0;
      break label41;
      label487:
      k = 0;
      break label50;
      label492:
      m = 0;
      break label66;
      label498:
      n = 0;
      break label94;
      label504:
      i1 = 0;
      break label110;
      label510:
      i2 = 0;
      break label126;
      i3 = 0;
      break label136;
      i4 = 0;
      break label161;
      i5 = 0;
      break label177;
      i6 = 0;
      break label193;
      i7 = 0;
      break label209;
      i8 = 0;
      break label231;
      i9 = 0;
      break label247;
      i10 = 0;
      break label263;
      i11 = 0;
      break label279;
      i12 = 0;
      break label295;
      i13 = 0;
      break label302;
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
  
  public final boolean isOfflineMapEnable()
  {
    return this.mOfflineMapEnable;
  }
  
  public final TencentMapOptions openDebugLogByTags(String... paramVarArgs)
  {
    this.mDebugTags = paramVarArgs;
    return this;
  }
  
  public final TencentMapOptions setCustomAssetsPath(String paramString)
  {
    this.customAssetsPath = paramString;
    return this;
  }
  
  public final TencentMapOptions setCustomCacheRootPath(String paramString)
  {
    this.mCustomCacheRootPath = paramString;
    return this;
  }
  
  public final TencentMapOptions setCustomLocalPath(String paramString)
  {
    this.customLocalPath = paramString;
    return this;
  }
  
  public final TencentMapOptions setCustomUserID(String paramString)
  {
    this.mCustomUserId = paramString;
    return this;
  }
  
  public final TencentMapOptions setExtSurface(Object paramObject)
  {
    AppMethodBeat.i(209857);
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture)) && (!(paramObject instanceof SurfaceHolder)))
    {
      paramObject = new IllegalArgumentException("Parameter Surface should be Surface,SurfaceTexture or SurfaceHolder");
      AppMethodBeat.o(209857);
      throw paramObject;
    }
    this.mExtSurface = paramObject;
    AppMethodBeat.o(209857);
    return this;
  }
  
  public final TencentMapOptions setExtSurfaceDimension(int paramInt1, int paramInt2)
  {
    this.mExtSurfaceWidth = paramInt1;
    this.mExtSurfaceHeight = paramInt2;
    return this;
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
  
  public final TencentMapOptions setMapKey(String paramString)
  {
    this.mMapKey = paramString;
    return this;
  }
  
  public final TencentMapOptions setMapViewType(MapViewType paramMapViewType)
  {
    this.mMapViewType = paramMapViewType;
    return this;
  }
  
  public final TencentMapOptions setMultipleInfoWindowEnable(boolean paramBoolean)
  {
    this.isEnableMultipleInfoWindow = paramBoolean;
    return this;
  }
  
  public final TencentMapOptions setNetAdapter(AdapterType paramAdapterType, Bundle paramBundle)
  {
    this.mNetAdapterType = paramAdapterType;
    this.mNetParams = paramBundle;
    return this;
  }
  
  public final TencentMapOptions setOfflineMapEnable(boolean paramBoolean)
  {
    this.mOfflineMapEnable = paramBoolean;
    return this;
  }
  
  public final TencentMapOptions setOverSeaSource(OverSeaSource paramOverSeaSource)
  {
    this.mOverSeaSource = paramOverSeaSource;
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
  
  public final TencentMapOptions setSubInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(209859);
    if (paramString1 != null)
    {
      this.mSubKey = paramString1.trim();
      if (paramString2 == null) {
        break label48;
      }
    }
    label48:
    for (this.mSubId = paramString2.trim();; this.mSubId = "")
    {
      AppMethodBeat.o(209859);
      return this;
      this.mSubKey = "";
      break;
    }
  }
  
  public final TencentMapOptions setTrafficStyle(TrafficStyle paramTrafficStyle)
  {
    this.mTrafficStyle = paramTrafficStyle;
    return this;
  }
  
  public final TencentMapOptions setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(209858);
    setTypeface(paramTypeface, false);
    AppMethodBeat.o(209858);
    return this;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(209860);
    StringBuffer localStringBuffer1 = new StringBuffer("TencentMapOptions{");
    localStringBuffer1.append("customAssetsPath='").append(this.customAssetsPath).append('\'');
    localStringBuffer1.append(", customLocalPath='").append(this.customLocalPath).append('\'');
    localStringBuffer1.append(", isHandDrawMapEnable=").append(this.isHandDrawMapEnable);
    localStringBuffer1.append(", mExtSurface=").append(this.mExtSurface);
    localStringBuffer1.append(", mExtSurfaceWidth=").append(this.mExtSurfaceWidth);
    localStringBuffer1.append(", mExtSurfaceHeight=").append(this.mExtSurfaceHeight);
    localStringBuffer1.append(", mSubId='").append(this.mSubId).append('\'');
    localStringBuffer1.append(", mSubKey='").append(this.mSubKey).append('\'');
    localStringBuffer1.append(", mMapKey='").append(this.mMapKey).append('\'');
    localStringBuffer1.append(", isEnableMultipleInfoWindow=").append(this.isEnableMultipleInfoWindow);
    StringBuffer localStringBuffer2 = localStringBuffer1.append(", mDebugTags=");
    if (this.mDebugTags == null) {}
    for (String str = "null";; str = Arrays.asList(this.mDebugTags).toString())
    {
      localStringBuffer2.append(str);
      localStringBuffer1.append(", mSatelliteVersion='").append(this.mSatelliteVersion).append('\'');
      localStringBuffer1.append(", mMapViewType=").append(this.mMapViewType);
      localStringBuffer1.append(", mMapKernel=").append(this.mMapKernel);
      localStringBuffer1.append(", mUserTypeface=").append(this.mUserTypeface);
      localStringBuffer1.append(", mProtocolFrom=").append(this.mProtocolFrom);
      localStringBuffer1.append(", mProtocolDataDesc=").append(this.mProtocolDataDesc);
      localStringBuffer1.append(", mNetAdapterType=").append(this.mNetAdapterType);
      localStringBuffer1.append(", mNetParams=").append(this.mNetParams);
      localStringBuffer1.append(", mCustomUserId='").append(this.mCustomUserId).append('\'');
      localStringBuffer1.append(", mMapCallback=").append(this.mMapCallback);
      localStringBuffer1.append(", mOfflineMapEnable=").append(this.mOfflineMapEnable);
      localStringBuffer1.append(", mOverSeaSource=").append(this.mOverSeaSource);
      localStringBuffer1.append(", mTrafficStyle=").append(this.mTrafficStyle);
      localStringBuffer1.append('}');
      str = localStringBuffer1.toString();
      AppMethodBeat.o(209860);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.TencentMapOptions
 * JD-Core Version:    0.7.0.1
 */