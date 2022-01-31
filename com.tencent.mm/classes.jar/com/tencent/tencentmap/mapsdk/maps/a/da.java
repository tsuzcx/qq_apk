package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class da
{
  private static String a = "";
  private static String b = "";
  
  public static int a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(147407);
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramString, 128);
      if (paramContext == null)
      {
        AppMethodBeat.o(147407);
        return -407;
      }
      paramString = paramContext.metaData;
      if (paramString == null)
      {
        AppMethodBeat.o(147407);
        return -408;
      }
      int i = paramContext.metaData.getInt("halley_appid", 0);
      if (i <= 0)
      {
        AppMethodBeat.o(147407);
        return -408;
      }
      AppMethodBeat.o(147407);
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(147407);
    }
    return -407;
  }
  
  public static da.a a(int paramInt, Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147397);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(147397);
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getServiceInfo(new ComponentName(paramString1, paramString2), 128);
      if (paramContext != null)
      {
        paramContext = new da.a(paramInt, paramString1, paramContext.enabled, paramContext.exported, paramContext.processName, paramContext.metaData);
        AppMethodBeat.o(147397);
        return paramContext;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(147397);
    }
    return null;
  }
  
  public static String a()
  {
    AppMethodBeat.i(147400);
    if (!TextUtils.isEmpty(b))
    {
      str = b;
      AppMethodBeat.o(147400);
      return str;
    }
    String str = ac.a().getSharedPreferences(a(false), 0).getString("deviceid", "");
    b = str;
    AppMethodBeat.o(147400);
    return str;
  }
  
  public static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 2) {
      str = "2g";
    }
    do
    {
      return str;
      if (paramInt == 3) {
        return "3g";
      }
      if (paramInt == 4) {
        return "4g";
      }
    } while (paramInt != 1);
    return "wifi";
  }
  
  public static String a(Context paramContext)
  {
    AppMethodBeat.i(147396);
    if (!TextUtils.isEmpty(a))
    {
      paramContext = a;
      AppMethodBeat.o(147396);
      return paramContext;
    }
    String str3 = paramContext.getPackageName();
    String str2 = dd.a(Process.myPid());
    String str1;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.startsWith(str3)) {}
    }
    else
    {
      str1 = dd.a(paramContext, Process.myPid());
    }
    a = str1;
    AppMethodBeat.o(147396);
    return str1;
  }
  
  private static String a(boolean paramBoolean)
  {
    AppMethodBeat.i(147398);
    Object localObject2 = new StringBuilder("HalleyServicePreferences_").append(ac.c());
    if (ac.b()) {}
    for (Object localObject1 = "_test";; localObject1 = "")
    {
      localObject2 = (String)localObject1;
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = (String)localObject2 + "_" + ac.i();
      }
      AppMethodBeat.o(147398);
      return localObject1;
    }
  }
  
  public static void a(String paramString)
  {
    AppMethodBeat.i(147399);
    ac.a().getSharedPreferences(a(false), 0).edit().putString("deviceid", paramString).commit();
    b = paramString;
    AppMethodBeat.o(147399);
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(147405);
    ac.a().getSharedPreferences(a(false), 0).edit().putInt(paramString, paramInt).commit();
    AppMethodBeat.o(147405);
  }
  
  public static void a(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(147403);
    ac.a().getSharedPreferences(a(false), 0).edit().putLong(paramString, paramLong).commit();
    AppMethodBeat.o(147403);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(147401);
    ac.a().getSharedPreferences(a(paramBoolean), 0).edit().putString(paramString1, paramString2).commit();
    AppMethodBeat.o(147401);
  }
  
  public static int b(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(147406);
    paramInt = ac.a().getSharedPreferences(a(false), 0).getInt(paramString, 0);
    AppMethodBeat.o(147406);
    return paramInt;
  }
  
  public static long b(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(147404);
    paramLong = ac.a().getSharedPreferences(a(false), 0).getLong(paramString, 0L);
    AppMethodBeat.o(147404);
    return paramLong;
  }
  
  public static String b(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(147402);
    paramString1 = ac.a().getSharedPreferences(a(paramBoolean), 0).getString(paramString1, paramString2);
    AppMethodBeat.o(147402);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.da
 * JD-Core Version:    0.7.0.1
 */