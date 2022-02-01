package com.tencent.thumbplayer.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.f;

public final class a
{
  private static String Khe = "";
  private static String Khf;
  private static String Khg;
  private static String Khh;
  private static int Khi = -1;
  private static String Khj;
  private static boolean Khk;
  private static String Khl = "";
  private static int Khm = 0;
  private static boolean Khn = true;
  private static int Kho = -1;
  private static String Khp = "\\.";
  private static long Khq = -1L;
  private static String appVersion = "";
  private static String appVersionName;
  
  public static void aTL(String paramString)
  {
    Khe = paramString;
  }
  
  public static String fFA()
  {
    return Khg;
  }
  
  public static String fFB()
  {
    return Khh;
  }
  
  public static String fFC()
  {
    return Khj;
  }
  
  public static String fFD()
  {
    return Khl;
  }
  
  public static int fFE()
  {
    return Khm;
  }
  
  public static boolean fFF()
  {
    return Khk;
  }
  
  public static int fFG()
  {
    if ((Khi == -1) && (Kho != -1)) {
      return Kho;
    }
    return Khi;
  }
  
  public static void fFH()
  {
    Kho = 1;
  }
  
  public static void fFf()
  {
    Khi = 100;
  }
  
  public static void fFx()
  {
    Khn = true;
  }
  
  public static boolean fFy()
  {
    return Khn;
  }
  
  public static String fFz()
  {
    return Khf;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    AppMethodBeat.i(187869);
    if (!TextUtils.isEmpty(appVersionName))
    {
      paramContext = appVersionName;
      AppMethodBeat.o(187869);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(187869);
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
      AppMethodBeat.o(187869);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(187869);
    }
    return "";
  }
  
  public static String getGuid()
  {
    return Khe;
  }
  
  public static int getPlatform()
  {
    return Kho;
  }
  
  public static long kV(Context paramContext)
  {
    AppMethodBeat.i(187870);
    long l;
    if (-1L != Khq)
    {
      l = Khq;
      AppMethodBeat.o(187870);
      return l;
    }
    try
    {
      l = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).getLongVersionCode();
      Khq = l;
      AppMethodBeat.o(187870);
      return l;
    }
    catch (Throwable paramContext)
    {
      f.e("TPPlayerConfig", "getLongVersionCode less api 28");
      l = Khq;
      AppMethodBeat.o(187870);
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.e.a
 * JD-Core Version:    0.7.0.1
 */