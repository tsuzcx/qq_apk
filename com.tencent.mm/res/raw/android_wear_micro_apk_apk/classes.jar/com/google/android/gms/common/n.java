package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.util.g;
import com.google.android.gms.common.util.h;
import com.google.android.gms.common.util.k;
import com.google.android.gms.common.util.l;
import com.google.android.gms.d;
import com.google.android.gms.internal.cg;
import com.google.android.gms.internal.ch;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class n
{
  @Deprecated
  public static final int IX = 10298000;
  public static boolean Ni = false;
  public static boolean Nj = false;
  static boolean Nk = false;
  private static boolean Nl = false;
  static final AtomicBoolean Nm = new AtomicBoolean();
  private static final AtomicBoolean Nn = new AtomicBoolean();
  
  @Deprecated
  public static boolean b(Context paramContext, int paramInt)
  {
    if (paramInt == 18) {
      return true;
    }
    if (paramInt == 1) {
      return h(paramContext, "com.google.android.gms");
    }
    return false;
  }
  
  @Deprecated
  public static boolean bC(int paramInt)
  {
    return l.h(null, paramInt);
  }
  
  @Deprecated
  public static boolean bD(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return false;
    }
    return true;
  }
  
  @Deprecated
  public static String bv(int paramInt)
  {
    return ConnectionResult.bs(paramInt);
  }
  
  @Deprecated
  public static int d(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext.getResources().getString(d.HQ);
      if ((!"com.google.android.gms".equals(paramContext.getPackageName())) && (!Nn.get()))
      {
        i = bc.j(paramContext);
        if (i == 0) {
          throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
      }
      int j;
      if (i != IX)
      {
        j = IX;
        paramContext = String.valueOf("com.google.android.gms.version");
        throw new IllegalStateException(String.valueOf(paramContext).length() + 290 + "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + j + " but found " + i + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"" + paramContext + "\" android:value=\"@integer/google_play_services_version\" />");
      }
      if ((!g.k(paramContext)) && (!g.l(paramContext))) {}
      PackageInfo localPackageInfo;
      for (int i = 1;; i = 0)
      {
        localObject = null;
        if (i != 0) {}
        try
        {
          localObject = localPackageManager.getPackageInfo("com.android.vending", 8256);
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
          return 9;
        }
        try
        {
          localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
          o.q(paramContext);
          if (i == 0) {
            break label278;
          }
          paramContext = o.a((PackageInfo)localObject, m.Nh);
          if (paramContext != null) {
            break label251;
          }
          Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
          return 9;
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
          return 1;
        }
      }
      label251:
      if (o.a(localPackageInfo, new j[] { paramContext }) == null)
      {
        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
        return 9;
        if (o.a(localPackageInfo, m.Nh) == null)
        {
          Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
          return 9;
        }
      }
      label278:
      i = h.bB(IX);
      if (h.bB(localPackageInfo.versionCode) < i)
      {
        i = IX;
        j = localPackageInfo.versionCode;
        Log.w("GooglePlayServicesUtil", 77 + "Google Play services out of date.  Requires " + i + " but found " + j);
        return 2;
      }
      Object localObject = localPackageInfo.applicationInfo;
      paramContext = (Context)localObject;
      if (localObject == null) {}
      try
      {
        paramContext = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
        if (!paramContext.enabled) {
          return 3;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", paramContext);
        return 1;
      }
    }
    return 0;
  }
  
  public static Resources f(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  @TargetApi(21)
  static boolean h(Context paramContext, String paramString)
  {
    boolean bool = paramString.equals("com.google.android.gms");
    if (k.ie())
    {
      localObject = paramContext.getPackageManager().getPackageInstaller().getAllSessions().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((PackageInstaller.SessionInfo)((Iterator)localObject).next()).getAppPackageName())) {
          return true;
        }
      }
    }
    Object localObject = paramContext.getPackageManager();
    try
    {
      paramString = ((PackageManager)localObject).getApplicationInfo(paramString, 8192);
      if (bool) {
        return paramString.enabled;
      }
      if (paramString.enabled)
      {
        if (Build.VERSION.SDK_INT >= 18)
        {
          i = 1;
          if (i == 0) {
            break label161;
          }
          paramContext = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
          if (paramContext == null) {
            break label161;
          }
          bool = "true".equals(paramContext.getString("restricted_profile"));
          if (!bool) {
            break label161;
          }
        }
        label161:
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label166;
          }
          return true;
          i = 0;
          break;
        }
      }
      label166:
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  @Deprecated
  public static void m(Context paramContext)
  {
    if (Nm.getAndSet(true)) {}
    for (;;)
    {
      return;
      try
      {
        paramContext = (NotificationManager)paramContext.getSystemService("notification");
        if (paramContext != null)
        {
          paramContext.cancel(10436);
          return;
        }
      }
      catch (SecurityException paramContext) {}
    }
  }
  
  public static boolean o(Context paramContext)
  {
    boolean bool = false;
    if (!Nl) {}
    for (;;)
    {
      try
      {
        PackageInfo localPackageInfo = ch.v(paramContext).getPackageInfo("com.google.android.gms", 64);
        if (localPackageInfo == null) {
          continue;
        }
        o.q(paramContext);
        if (o.a(localPackageInfo, new j[] { m.Nh[1] }) == null) {
          continue;
        }
        Nk = true;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", paramContext);
        Nl = true;
        continue;
      }
      finally
      {
        Nl = true;
      }
      if ((Nk) || (!"user".equals(Build.TYPE))) {
        bool = true;
      }
      return bool;
      Nk = false;
    }
  }
  
  public static Context p(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.n
 * JD-Core Version:    0.7.0.1
 */