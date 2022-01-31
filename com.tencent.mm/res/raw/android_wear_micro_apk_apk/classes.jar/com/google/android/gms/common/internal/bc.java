package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.cg;
import com.google.android.gms.internal.ch;

public final class bc
{
  private static Object KF = new Object();
  private static boolean KG;
  private static String KH;
  private static int KI;
  
  public static int i(Context paramContext)
  {
    for (;;)
    {
      String str;
      synchronized (KF)
      {
        if (KG) {
          return KI;
        }
        KG = true;
        str = paramContext.getPackageName();
        paramContext = ch.u(paramContext);
      }
      try
      {
        paramContext = paramContext.getApplicationInfo(str, 128).metaData;
        if (paramContext == null)
        {
          continue;
          paramContext = finally;
          throw paramContext;
        }
        KH = paramContext.getString("com.google.app.id");
        KI = paramContext.getInt("com.google.android.gms.version");
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          Log.wtf("MetadataValueReader", "This should never happen.", paramContext);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.bc
 * JD-Core Version:    0.7.0.1
 */