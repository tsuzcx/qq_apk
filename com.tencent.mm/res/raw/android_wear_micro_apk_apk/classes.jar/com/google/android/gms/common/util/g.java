package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;

public final class g
{
  private static Boolean MU;
  private static Boolean MV;
  private static Boolean MW;
  
  @TargetApi(24)
  public static boolean k(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 24)
    {
      i = 1;
      if (i != 0)
      {
        if (MV == null)
        {
          if ((!k.ie()) || (!paramContext.getPackageManager().hasSystemFeature("cn.google"))) {
            break label105;
          }
          bool = true;
          label40:
          MV = Boolean.valueOf(bool);
        }
        if (!MV.booleanValue()) {
          break label115;
        }
      }
      if (MU == null) {
        if ((!k.id()) || (!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch"))) {
          break label110;
        }
      }
    }
    label105:
    label110:
    for (boolean bool = true;; bool = false)
    {
      MU = Boolean.valueOf(bool);
      if (!MU.booleanValue()) {
        break label115;
      }
      return true;
      i = 0;
      break;
      bool = false;
      break label40;
    }
    label115:
    return false;
  }
  
  public static boolean l(Context paramContext)
  {
    if (MW == null) {
      MW = Boolean.valueOf(paramContext.getPackageManager().hasSystemFeature("android.hardware.type.iot"));
    }
    return MW.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.g
 * JD-Core Version:    0.7.0.1
 */