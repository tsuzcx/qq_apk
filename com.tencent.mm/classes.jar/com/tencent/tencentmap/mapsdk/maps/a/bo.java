package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bo
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  public static String d = "";
  
  private static String a()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable) {}
    return "null";
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(147297);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a());
    localStringBuffer.append(";Android ");
    localStringBuffer.append(b());
    localStringBuffer.append(",level ");
    localStringBuffer.append(c());
    a = localStringBuffer.toString();
    b = b(paramContext);
    paramContext.getPackageName();
    c = d();
    d = a();
    AppMethodBeat.o(147297);
  }
  
  private static String b()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable) {}
    return "null";
  }
  
  private static String b(Context paramContext)
  {
    AppMethodBeat.i(147298);
    Object localObject = paramContext.getPackageName();
    for (;;)
    {
      int i;
      int k;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
        localObject = paramContext.versionName;
        int m = paramContext.versionCode;
        if ((localObject == null) || (((String)localObject).trim().length() <= 0))
        {
          AppMethodBeat.o(147298);
          return String.valueOf(m);
        }
        paramContext = ((String)localObject).trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
        localObject = paramContext.toCharArray();
        i = 0;
        j = 0;
        if (i < localObject.length)
        {
          k = j;
          if (localObject[i] != '.') {
            break label172;
          }
          k = j + 1;
          break label172;
        }
        if (j < 3)
        {
          paramContext = paramContext + "." + m;
          AppMethodBeat.o(147298);
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        AppMethodBeat.o(147298);
        return "";
      }
      continue;
      label172:
      i += 1;
      int j = k;
    }
  }
  
  private static String c()
  {
    try
    {
      String str = Build.VERSION.SDK;
      return str;
    }
    catch (Throwable localThrowable) {}
    return "null";
  }
  
  private static String d()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.bo
 * JD-Core Version:    0.7.0.1
 */