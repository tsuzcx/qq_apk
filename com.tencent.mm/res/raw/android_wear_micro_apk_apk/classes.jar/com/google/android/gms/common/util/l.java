package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.o;
import com.google.android.gms.internal.cg;
import com.google.android.gms.internal.ch;

public final class l
{
  @TargetApi(19)
  public static boolean b(Context paramContext, int paramInt, String paramString)
  {
    return ch.v(paramContext).a(paramInt, paramString);
  }
  
  public static boolean h(Context paramContext, int paramInt)
  {
    if (!b(paramContext, paramInt, "com.google.android.gms")) {}
    do
    {
      return false;
      Object localObject = paramContext.getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo("com.google.android.gms", 64);
        o localo = o.q(paramContext);
        paramContext.getPackageManager();
        return localo.a((PackageInfo)localObject);
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    } while (!Log.isLoggable("UidVerifier", 3));
    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.l
 * JD-Core Version:    0.7.0.1
 */