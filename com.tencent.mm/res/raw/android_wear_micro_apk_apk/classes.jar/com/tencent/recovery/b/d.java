package com.tencent.recovery.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public final class d
{
  private static c ajG;
  
  public static a A(Context paramContext)
  {
    Object localObject1 = null;
    if (ajG != null) {
      localObject1 = ajG.nV();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      com.tencent.recovery.a.d.c("Recovery.OptionFactory", "not found custom custom options, use default", new Object[0]);
      localObject1 = new b();
      ((b)localObject1).W("");
      ((b)localObject1).nT();
      ((b)localObject1).X(String.valueOf(com.tencent.recovery.e.a.C(paramContext)));
    }
    try
    {
      ((b)localObject1).Y(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName);
      label82:
      ((b)localObject1).nR();
      ((b)localObject1).nS();
      localObject2 = ((b)localObject1).nU();
      return localObject2;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      break label82;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.b.d
 * JD-Core Version:    0.7.0.1
 */