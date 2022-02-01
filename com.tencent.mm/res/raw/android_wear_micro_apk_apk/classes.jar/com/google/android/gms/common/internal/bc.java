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
  private static Object Mu = new Object();
  private static boolean Mv;
  private static String Mw;
  private static int Mx;
  
  public static int j(Context paramContext)
  {
    for (;;)
    {
      String str;
      synchronized (Mu)
      {
        if (Mv) {
          return Mx;
        }
        Mv = true;
        str = paramContext.getPackageName();
        paramContext = ch.v(paramContext);
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
        Mw = paramContext.getString("com.google.app.id");
        Mx = paramContext.getInt("com.google.android.gms.version");
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