package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class w
{
  public static String a = "TencentMapSDK";
  private static String b;
  private static String c;
  private static String d;
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  private static float i = 1.0F;
  
  public static String a()
  {
    return c;
  }
  
  private static String a(String paramString)
  {
    AppMethodBeat.i(150422);
    if (paramString == null)
    {
      AppMethodBeat.o(150422);
      return "";
    }
    paramString = paramString.replace("&", "").replace("#", "").replace("?", "");
    AppMethodBeat.o(150422);
    return paramString;
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(150417);
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
      str = e(paramContext);
      h = str;
      h = a(str);
    }
    i = paramContext.getResources().getDisplayMetrics().density;
    AppMethodBeat.o(150417);
  }
  
  public static String b()
  {
    return d;
  }
  
  private static String b(Context paramContext)
  {
    AppMethodBeat.i(150418);
    Object localObject;
    if (Build.VERSION.SDK_INT < 21) {
      localObject = "armeabi-v7a";
    }
    for (;;)
    {
      AppMethodBeat.o(150418);
      return localObject;
      if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT < 23)) {
        for (paramContext = paramContext.getClassLoader();; paramContext = Build.SUPPORTED_32_BIT_ABIS[0])
        {
          try
          {
            paramContext = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[] { String.class }).invoke(paramContext, new Object[] { "art" });
            if (paramContext == null) {
              break label142;
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
          localObject = Build.SUPPORTED_ABIS[0];
          break;
        }
      }
      label142:
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (Process.is64Bit()) {
          localObject = Build.SUPPORTED_64_BIT_ABIS[0];
        } else {
          localObject = Build.SUPPORTED_32_BIT_ABIS[0];
        }
      }
      else {
        localObject = "";
      }
    }
  }
  
  public static String c()
  {
    return e;
  }
  
  private static String c(Context paramContext)
  {
    AppMethodBeat.i(150419);
    if (paramContext == null)
    {
      AppMethodBeat.o(150419);
      return "";
    }
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (localTelephonyManager == null)
    {
      AppMethodBeat.o(150419);
      return "";
    }
    if (Build.VERSION.SDK_INT > 22) {
      if (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
        paramContext = "no permission";
      }
    }
    for (;;)
    {
      AppMethodBeat.o(150419);
      return paramContext;
      paramContext = localTelephonyManager.getDeviceId();
      continue;
      paramContext = localTelephonyManager.getDeviceId();
    }
  }
  
  public static String d()
  {
    return f;
  }
  
  private static String d(Context paramContext)
  {
    AppMethodBeat.i(150420);
    if (paramContext == null)
    {
      AppMethodBeat.o(150420);
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    String str = "unknown";
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128).loadLabel(localPackageManager);
      paramContext = paramContext.toString();
      AppMethodBeat.o(150420);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        dw.b(Log.getStackTraceString(paramContext));
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
    AppMethodBeat.i(150421);
    if (paramContext == null)
    {
      AppMethodBeat.o(150421);
      return "";
    }
    String str = paramContext.getPackageName();
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
      if (paramContext == null)
      {
        AppMethodBeat.o(150421);
        return "";
      }
      if (paramContext.metaData == null)
      {
        AppMethodBeat.o(150421);
        return "";
      }
      paramContext = paramContext.metaData.getString(a);
      AppMethodBeat.o(150421);
      return paramContext;
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
  
  public static float g()
  {
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.w
 * JD-Core Version:    0.7.0.1
 */