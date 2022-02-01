package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.text.TextUtils;

public abstract class OverSeaTileProvider
  extends UrlTileProvider
{
  private String mProviderName;
  private int mProviderVersion;
  
  public OverSeaTileProvider(String paramString, int paramInt)
  {
    this.mProviderName = paramString;
    this.mProviderVersion = paramInt;
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("图源名不能为空");
    }
  }
  
  public abstract Bitmap getLogo(boolean paramBoolean);
  
  public final String getProviderName()
  {
    return this.mProviderName;
  }
  
  public final int getProviderVersion()
  {
    return this.mProviderVersion;
  }
  
  public boolean onDayNightChange(boolean paramBoolean)
  {
    return false;
  }
  
  public boolean onLanguageChange(Language paramLanguage)
  {
    return false;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("OverSeaProvider{");
    localStringBuffer.append("mProviderName='").append(this.mProviderName).append('\'');
    localStringBuffer.append(", mProviderVersion=").append(this.mProviderVersion);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider
 * JD-Core Version:    0.7.0.1
 */