package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;

public final class TileOverlayOptions
{
  private boolean mBetterQuality = true;
  private volatile String mDiskCacheDir;
  private int mMaxMemoryCacheSize;
  private TileProvider mTileProvider;
  private volatile String mVersionInfo;
  private int mZIndex = 1;
  
  public final TileOverlayOptions betterQuality(boolean paramBoolean)
  {
    this.mBetterQuality = paramBoolean;
    return this;
  }
  
  public final TileOverlayOptions diskCacheDir(String paramString)
  {
    this.mDiskCacheDir = paramString;
    return this;
  }
  
  public final String getDiskCacheDir()
  {
    return this.mDiskCacheDir;
  }
  
  public final int getMaxMemoryCacheSize(TencentMapContext paramTencentMapContext)
  {
    AppMethodBeat.i(181090);
    if (this.mMaxMemoryCacheSize == 0)
    {
      i = paramTencentMapContext.getScreenPixels();
      AppMethodBeat.o(181090);
      return i * 4;
    }
    int i = this.mMaxMemoryCacheSize;
    AppMethodBeat.o(181090);
    return i;
  }
  
  public final TileProvider getTileProvider()
  {
    return this.mTileProvider;
  }
  
  public final String getVersionInfo()
  {
    return this.mVersionInfo;
  }
  
  public final int getZIndex()
  {
    return this.mZIndex;
  }
  
  public final boolean isBetterQuality()
  {
    return this.mBetterQuality;
  }
  
  public final TileOverlayOptions maxMemoryCacheSize(int paramInt)
  {
    this.mMaxMemoryCacheSize = paramInt;
    return this;
  }
  
  public final TileOverlayOptions tileProvider(TileProvider paramTileProvider)
  {
    this.mTileProvider = paramTileProvider;
    return this;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191297);
    String str = "{mDiskCacheDir='" + this.mDiskCacheDir + '\'' + ", mVersionInfo='" + this.mVersionInfo + '\'' + ", mZIndex=" + this.mZIndex + ", mBetterQuality=" + this.mBetterQuality + ", mMaxMemoryCacheSize=" + this.mMaxMemoryCacheSize + '}';
    AppMethodBeat.o(191297);
    return str;
  }
  
  public final TileOverlayOptions versionInfo(String paramString)
  {
    this.mVersionInfo = paramString;
    return this;
  }
  
  public final TileOverlayOptions zIndex(int paramInt)
  {
    this.mZIndex = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions
 * JD-Core Version:    0.7.0.1
 */