package com.tencent.thumbplayer.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.d;

public final class a
{
  private static String MxA;
  private static long MxB = -1L;
  private static String Mxp = "";
  private static String Mxq;
  private static String Mxr;
  private static String Mxs;
  private static int Mxt = -1;
  private static String Mxu;
  private static boolean Mxv;
  private static String Mxw = "";
  private static int Mxx = 0;
  private static boolean Mxy = true;
  private static int Mxz = -1;
  private static String appVersion;
  private static String appVersionName;
  
  static
  {
    MxA = "\\.";
    appVersion = "";
  }
  
  public static void bbo(String paramString)
  {
    Mxp = paramString;
  }
  
  public static void gaV()
  {
    Mxt = 100;
  }
  
  public static void gbl()
  {
    Mxy = true;
  }
  
  public static boolean gbm()
  {
    return Mxy;
  }
  
  public static String gbn()
  {
    return Mxq;
  }
  
  public static String gbo()
  {
    return Mxr;
  }
  
  public static String gbp()
  {
    return Mxs;
  }
  
  public static String gbq()
  {
    return Mxu;
  }
  
  public static String gbr()
  {
    return Mxw;
  }
  
  public static int gbs()
  {
    return Mxx;
  }
  
  public static boolean gbt()
  {
    return Mxv;
  }
  
  public static int gbu()
  {
    if ((Mxt == -1) && (Mxz != -1)) {
      return Mxz;
    }
    return Mxt;
  }
  
  public static void gbv()
  {
    Mxz = 1;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    AppMethodBeat.i(194568);
    if (!TextUtils.isEmpty(appVersionName))
    {
      paramContext = appVersionName;
      AppMethodBeat.o(194568);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(194568);
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
      AppMethodBeat.o(194568);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(194568);
    }
    return "";
  }
  
  public static String getGuid()
  {
    return Mxp;
  }
  
  public static int getPlatform()
  {
    return Mxz;
  }
  
  public static long lo(Context paramContext)
  {
    AppMethodBeat.i(194569);
    long l;
    if (-1L != MxB)
    {
      l = MxB;
      AppMethodBeat.o(194569);
      return l;
    }
    try
    {
      l = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).getLongVersionCode();
      MxB = l;
      AppMethodBeat.o(194569);
      return l;
    }
    catch (Throwable paramContext)
    {
      d.e("TPPlayerConfig", "getLongVersionCode less api 28");
      l = MxB;
      AppMethodBeat.o(194569);
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.e.a
 * JD-Core Version:    0.7.0.1
 */