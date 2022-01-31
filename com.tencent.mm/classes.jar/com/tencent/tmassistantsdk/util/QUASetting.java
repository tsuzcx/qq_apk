package com.tencent.tmassistantsdk.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;

public class QUASetting
{
  protected static final String APP_VERSION = "100";
  protected static final String BUILD_NO = "100";
  public static final int ROOT_STATUS_UNKNOWN = 0;
  protected static final String UN_DEFINED = "NA";
  protected static String mChannelId = "NA";
  protected Context mContext = null;
  
  public QUASetting(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private StringBuffer filter(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuffer.append("NA");
      return localStringBuffer;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      if ((paramString[i] > ' ') && (paramString[i] != '/') && (paramString[i] != '_') && (paramString[i] != '&') && (paramString[i] != '|') && (paramString[i] != '-')) {
        localStringBuffer.append(paramString[i]);
      }
      i += 1;
    }
    return localStringBuffer;
  }
  
  private String getAndroidVersion()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Build.VERSION.RELEASE;
    if (TextUtils.isEmpty(str)) {
      localStringBuffer.append("NA");
    }
    for (;;)
    {
      localStringBuffer.append("_");
      localStringBuffer.append(Build.VERSION.SDK_INT);
      return localStringBuffer.toString();
      localStringBuffer.append(str);
    }
  }
  
  public static String getBuildNo()
  {
    if ("100".contains("BuildNo")) {
      return "0000";
    }
    return "100";
  }
  
  private int getDeviceHeight()
  {
    return this.mContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  private int getDeviceWidth()
  {
    return this.mContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private int getRootStatus()
  {
    return 0;
  }
  
  private String getUA()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(filter(Build.BRAND));
    localStringBuffer.append("_");
    localStringBuffer.append(filter(Build.MODEL));
    return localStringBuffer.toString();
  }
  
  public String buildQUA()
  {
    QUABuilder localQUABuilder = new QUABuilder();
    localQUABuilder.mBuildNo = getBuildNo();
    localQUABuilder.mChannel = "";
    localQUABuilder.mChannelId = mChannelId;
    localQUABuilder.mAdrRelease = getAndroidVersion();
    localQUABuilder.mDeviceHeight = getDeviceHeight();
    localQUABuilder.mDeviceWidth = getDeviceWidth();
    localQUABuilder.mRootStatus = getRootStatus();
    localQUABuilder.mUA = getUA();
    localQUABuilder.mVersionName = "100";
    return localQUABuilder.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.QUASetting
 * JD-Core Version:    0.7.0.1
 */