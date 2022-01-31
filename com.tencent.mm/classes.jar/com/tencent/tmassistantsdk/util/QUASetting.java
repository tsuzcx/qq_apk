package com.tencent.tmassistantsdk.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(76280);
    StringBuffer localStringBuffer = new StringBuffer();
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuffer.append("NA");
      AppMethodBeat.o(76280);
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
    AppMethodBeat.o(76280);
    return localStringBuffer;
  }
  
  private String getAndroidVersion()
  {
    AppMethodBeat.i(76279);
    Object localObject = new StringBuffer();
    String str = Build.VERSION.RELEASE;
    if (TextUtils.isEmpty(str)) {
      ((StringBuffer)localObject).append("NA");
    }
    for (;;)
    {
      ((StringBuffer)localObject).append("_");
      ((StringBuffer)localObject).append(Build.VERSION.SDK_INT);
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(76279);
      return localObject;
      ((StringBuffer)localObject).append(str);
    }
  }
  
  public static String getBuildNo()
  {
    AppMethodBeat.i(76277);
    if ("100".contains("BuildNo"))
    {
      AppMethodBeat.o(76277);
      return "0000";
    }
    AppMethodBeat.o(76277);
    return "100";
  }
  
  private int getDeviceHeight()
  {
    AppMethodBeat.i(76276);
    int i = this.mContext.getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(76276);
    return i;
  }
  
  private int getDeviceWidth()
  {
    AppMethodBeat.i(76275);
    int i = this.mContext.getResources().getDisplayMetrics().widthPixels;
    AppMethodBeat.o(76275);
    return i;
  }
  
  private int getRootStatus()
  {
    return 0;
  }
  
  private String getUA()
  {
    AppMethodBeat.i(76278);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(filter(Build.BRAND));
    ((StringBuffer)localObject).append("_");
    ((StringBuffer)localObject).append(filter(Build.MODEL));
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76278);
    return localObject;
  }
  
  public String buildQUA()
  {
    AppMethodBeat.i(76274);
    Object localObject = new QUABuilder();
    ((QUABuilder)localObject).mBuildNo = getBuildNo();
    ((QUABuilder)localObject).mChannel = "";
    ((QUABuilder)localObject).mChannelId = mChannelId;
    ((QUABuilder)localObject).mAdrRelease = getAndroidVersion();
    ((QUABuilder)localObject).mDeviceHeight = getDeviceHeight();
    ((QUABuilder)localObject).mDeviceWidth = getDeviceWidth();
    ((QUABuilder)localObject).mRootStatus = getRootStatus();
    ((QUABuilder)localObject).mUA = getUA();
    ((QUABuilder)localObject).mVersionName = "100";
    localObject = ((QUABuilder)localObject).get();
    AppMethodBeat.o(76274);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.QUASetting
 * JD-Core Version:    0.7.0.1
 */