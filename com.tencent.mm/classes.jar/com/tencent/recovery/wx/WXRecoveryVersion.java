package com.tencent.recovery.wx;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class WXRecoveryVersion
{
  private static String BaseClientVersion = null;
  
  public static String getBaseClientVersion(Context paramContext)
  {
    if ((paramContext != null) && (BaseClientVersion == null)) {}
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      BaseClientVersion = "0x" + Integer.toHexString(paramContext.metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION"));
      label55:
      return BaseClientVersion;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      break label55;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.wx.WXRecoveryVersion
 * JD-Core Version:    0.7.0.1
 */