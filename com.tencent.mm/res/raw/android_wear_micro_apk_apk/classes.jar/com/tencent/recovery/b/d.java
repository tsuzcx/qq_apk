package com.tencent.recovery.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public final class d
{
  private static c ani;
  
  public static a B(Context paramContext)
  {
    Object localObject1 = null;
    if (ani != null) {
      localObject1 = ani.oJ();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      com.tencent.recovery.a.d.c("Recovery.OptionFactory", "not found custom custom options, use default", new Object[0]);
      localObject1 = new b();
      ((b)localObject1).aa("");
      ((b)localObject1).oH();
      ((b)localObject1).ab(String.valueOf(com.tencent.recovery.e.a.D(paramContext)));
    }
    try
    {
      ((b)localObject1).ac(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName);
      label82:
      ((b)localObject1).oF();
      ((b)localObject1).oG();
      localObject2 = ((b)localObject1).oI();
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