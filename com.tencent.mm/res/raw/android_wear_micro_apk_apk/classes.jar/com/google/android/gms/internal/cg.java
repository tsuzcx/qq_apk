package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;

public final class cg
{
  protected final Context mContext;
  
  public cg(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  @TargetApi(19)
  public final boolean a(int paramInt, String paramString)
  {
    boolean bool2 = false;
    int i;
    if (Build.VERSION.SDK_INT >= 19)
    {
      i = 1;
      if (i == 0) {
        break label45;
      }
    }
    for (;;)
    {
      label45:
      try
      {
        ((AppOpsManager)this.mContext.getSystemService("appops")).checkPackage(paramInt, paramString);
        bool1 = true;
        return bool1;
      }
      catch (SecurityException paramString) {}
      i = 0;
      break;
      String[] arrayOfString = this.mContext.getPackageManager().getPackagesForUid(paramInt);
      boolean bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (arrayOfString != null)
        {
          paramInt = 0;
          for (;;)
          {
            bool1 = bool2;
            if (paramInt >= arrayOfString.length) {
              break;
            }
            if (paramString.equals(arrayOfString[paramInt])) {
              return true;
            }
            paramInt += 1;
          }
        }
      }
    }
    return false;
  }
  
  public final ApplicationInfo getApplicationInfo(String paramString, int paramInt)
  {
    return this.mContext.getPackageManager().getApplicationInfo(paramString, paramInt);
  }
  
  public final PackageInfo getPackageInfo(String paramString, int paramInt)
  {
    return this.mContext.getPackageManager().getPackageInfo(paramString, paramInt);
  }
  
  public final CharSequence q(String paramString)
  {
    return this.mContext.getPackageManager().getApplicationLabel(this.mContext.getPackageManager().getApplicationInfo(paramString, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.cg
 * JD-Core Version:    0.7.0.1
 */