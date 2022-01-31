package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class y
{
  public static String a = "TencentMapSDK";
  private static String b;
  private static String c;
  private static String d;
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  
  public static String a()
  {
    return c;
  }
  
  private static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replace("&", "").replace("#", "").replace("?", "");
  }
  
  public static void a(Context paramContext)
  {
    String str;
    if (b == null)
    {
      str = b(paramContext);
      b = str;
      b = a(str);
    }
    if (c == null)
    {
      str = c(paramContext);
      c = str;
      c = a(str);
    }
    if (d == null)
    {
      str = Build.MODEL;
      d = str;
      d = a(str);
    }
    if (e == null) {
      e = Build.VERSION.RELEASE;
    }
    if (f == null)
    {
      str = d(paramContext);
      f = str;
      f = a(str);
    }
    if (g == null)
    {
      str = paramContext.getPackageName();
      g = str;
      g = a(str);
    }
    if (h == null)
    {
      paramContext = e(paramContext);
      h = paramContext;
      h = a(paramContext);
    }
  }
  
  public static String b()
  {
    return d;
  }
  
  private static String b(Context paramContext)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT < 21)
    {
      localObject = "armeabi-v7a";
      return localObject;
    }
    if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT < 23)) {
      for (paramContext = paramContext.getClassLoader();; paramContext = Build.SUPPORTED_32_BIT_ABIS[0])
      {
        try
        {
          paramContext = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[] { String.class }).invoke(paramContext, new Object[] { "art" });
          if (paramContext == null) {
            break label129;
          }
          if (!((String)paramContext).contains("lib64")) {
            continue;
          }
          paramContext = Build.SUPPORTED_64_BIT_ABIS[0];
        }
        catch (NoSuchMethodException paramContext)
        {
          for (;;)
          {
            paramContext = "";
          }
        }
        catch (IllegalAccessException paramContext)
        {
          for (;;)
          {
            paramContext = "";
          }
        }
        catch (InvocationTargetException paramContext)
        {
          for (;;)
          {
            paramContext = "";
          }
        }
        catch (NullPointerException paramContext)
        {
          for (;;)
          {
            paramContext = "";
          }
        }
        localObject = paramContext;
        if (paramContext != null) {
          break;
        }
        return Build.SUPPORTED_ABIS[0];
      }
    }
    label129:
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (Process.is64Bit()) {
        return Build.SUPPORTED_64_BIT_ABIS[0];
      }
      return Build.SUPPORTED_32_BIT_ABIS[0];
    }
    return "";
  }
  
  public static String c()
  {
    return e;
  }
  
  private static String c(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (localTelephonyManager == null) {
      return "";
    }
    if (Build.VERSION.SDK_INT > 22)
    {
      if (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
        return "no permission";
      }
      return localTelephonyManager.getDeviceId();
    }
    return localTelephonyManager.getDeviceId();
  }
  
  public static String d()
  {
    return f;
  }
  
  private static String d(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    String str = "unknown";
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128).loadLabel(localPackageManager);
      return paramContext.toString();
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        rh.b(Log.getStackTraceString(paramContext));
        paramContext = str;
      }
    }
  }
  
  public static String e()
  {
    return g;
  }
  
  private static String e(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    String str = paramContext.getPackageName();
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
      if (paramContext == null) {
        return "";
      }
      if (paramContext.metaData == null) {
        return "";
      }
      return paramContext.metaData.getString(a);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  public static String f()
  {
    return h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.y
 * JD-Core Version:    0.7.0.1
 */