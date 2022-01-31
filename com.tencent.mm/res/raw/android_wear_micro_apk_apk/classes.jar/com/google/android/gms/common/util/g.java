package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;

public final class g
{
  private static Boolean Lf;
  private static Boolean Lg;
  private static Boolean Lh;
  
  @TargetApi(24)
  public static boolean j(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 24)
    {
      i = 1;
      if (i != 0)
      {
        if (Lg == null)
        {
          if ((!j.hW()) || (!paramContext.getPackageManager().hasSystemFeature("cn.google"))) {
            break label105;
          }
          bool = true;
          label40:
          Lg = Boolean.valueOf(bool);
        }
        if (!Lg.booleanValue()) {
          break label115;
        }
      }
      if (Lf == null) {
        if ((!j.hV()) || (!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch"))) {
          break label110;
        }
      }
    }
    label105:
    label110:
    for (boolean bool = true;; bool = false)
    {
      Lf = Boolean.valueOf(bool);
      if (!Lf.booleanValue()) {
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
  
  public static boolean k(Context paramContext)
  {
    if (Lh == null) {
      Lh = Boolean.valueOf(paramContext.getPackageManager().hasSystemFeature("android.hardware.type.iot"));
    }
    return Lh.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.g
 * JD-Core Version:    0.7.0.1
 */