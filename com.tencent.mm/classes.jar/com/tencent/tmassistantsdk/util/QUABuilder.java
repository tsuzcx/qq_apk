package com.tencent.tmassistantsdk.util;

import android.text.TextUtils;

public final class QUABuilder
{
  public String mAdrRelease;
  public String mBuildNo;
  public String mChannel;
  public String mChannelId;
  public int mDeviceHeight;
  public int mDeviceWidth;
  public int mRootStatus;
  public String mUA;
  public String mVersionName;
  
  private String getAppSpec()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("0");
    localStringBuffer.append(this.mVersionName.subSequence(0, 1));
    localStringBuffer.append(this.mBuildNo);
    return localStringBuffer.toString();
  }
  
  public final String get()
  {
    String str = getAppSpec();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("TMASDK_");
    localStringBuffer.append(this.mVersionName);
    if (!TextUtils.isEmpty(this.mChannel))
    {
      localStringBuffer.append("_");
      localStringBuffer.append(this.mChannel);
    }
    localStringBuffer.append("/");
    localStringBuffer.append(str);
    localStringBuffer.append("&NA/");
    localStringBuffer.append(str);
    localStringBuffer.append("&");
    localStringBuffer.append(this.mAdrRelease);
    localStringBuffer.append("_");
    localStringBuffer.append(this.mRootStatus);
    localStringBuffer.append("&");
    localStringBuffer.append(this.mDeviceWidth / 16);
    localStringBuffer.append("_");
    localStringBuffer.append(this.mDeviceHeight / 16);
    localStringBuffer.append("_");
    localStringBuffer.append("14&");
    localStringBuffer.append(this.mUA);
    localStringBuffer.append("&");
    localStringBuffer.append(this.mChannelId);
    localStringBuffer.append("&");
    localStringBuffer.append("NA");
    localStringBuffer.append("&");
    localStringBuffer.append("V3");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.QUABuilder
 * JD-Core Version:    0.7.0.1
 */