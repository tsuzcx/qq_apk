package com.tencent.thumbplayer.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.d;

public final class a
{
  private static boolean MaA;
  private static String MaB;
  private static int MaC;
  private static boolean MaD;
  private static int MaE;
  private static String MaF;
  private static long MaG = -1L;
  private static String Mau = "";
  private static String Mav;
  private static String Maw;
  private static String Max;
  private static int May = -1;
  private static String Maz;
  private static String appVersion;
  private static String appVersionName;
  
  static
  {
    MaB = "";
    MaC = 0;
    MaD = true;
    MaE = -1;
    MaF = "\\.";
    appVersion = "";
  }
  
  public static void aZL(String paramString)
  {
    Mau = paramString;
  }
  
  public static void fWM()
  {
    MaD = true;
  }
  
  public static boolean fWN()
  {
    return MaD;
  }
  
  public static String fWO()
  {
    return Mav;
  }
  
  public static String fWP()
  {
    return Maw;
  }
  
  public static String fWQ()
  {
    return Max;
  }
  
  public static String fWR()
  {
    return Maz;
  }
  
  public static String fWS()
  {
    return MaB;
  }
  
  public static int fWT()
  {
    return MaC;
  }
  
  public static boolean fWU()
  {
    return MaA;
  }
  
  public static int fWV()
  {
    if ((May == -1) && (MaE != -1)) {
      return MaE;
    }
    return May;
  }
  
  public static void fWW()
  {
    MaE = 1;
  }
  
  public static void fWw()
  {
    May = 100;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    AppMethodBeat.i(191890);
    if (!TextUtils.isEmpty(appVersionName))
    {
      paramContext = appVersionName;
      AppMethodBeat.o(191890);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(191890);
      return "";
    }
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      appVersionName = str;
      paramContext = str;
      if (str == null) {
        paramContext = "";
      }
      AppMethodBeat.o(191890);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(191890);
    }
    return "";
  }
  
  public static String getGuid()
  {
    return Mau;
  }
  
  public static int getPlatform()
  {
    return MaE;
  }
  
  public static long li(Context paramContext)
  {
    AppMethodBeat.i(191891);
    long l;
    if (-1L != MaG)
    {
      l = MaG;
      AppMethodBeat.o(191891);
      return l;
    }
    try
    {
      l = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).getLongVersionCode();
      MaG = l;
      AppMethodBeat.o(191891);
      return l;
    }
    catch (Throwable paramContext)
    {
      d.e("TPPlayerConfig", "getLongVersionCode less api 28");
      l = MaG;
      AppMethodBeat.o(191891);
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.e.a
 * JD-Core Version:    0.7.0.1
 */