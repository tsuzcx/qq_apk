package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public class m
{
  private static String a = null;
  private static String b = "GA";
  private static String c = "GE";
  private static String d = "9422";
  private static String e = "0";
  private static String f = "";
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  
  public static String a(Context paramContext)
  {
    AppMethodBeat.i(219330);
    if (!TextUtils.isEmpty(a))
    {
      paramContext = a;
      AppMethodBeat.o(219330);
      return paramContext;
    }
    paramContext = a(paramContext, String.valueOf(WebView.getTbsSDKVersion(paramContext)), "0", b, c, d, e, f, g);
    a = paramContext;
    AppMethodBeat.o(219330);
    return paramContext;
  }
  
  private static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    AppMethodBeat.i(219333);
    localObject2 = "";
    StringBuilder localStringBuilder = new StringBuilder();
    String str = b(paramContext) + "*" + c(paramContext);
    localObject1 = localObject2;
    for (;;)
    {
      try
      {
        ApplicationInfo localApplicationInfo = paramContext.getApplicationContext().getApplicationInfo();
        localObject1 = localObject2;
        localObject3 = paramContext.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
        localObject1 = localObject2;
        localObject2 = localApplicationInfo.packageName;
        localObject1 = localObject2;
        boolean bool = TextUtils.isEmpty(paramString7);
        if (bool) {
          continue;
        }
      }
      catch (PackageManager.NameNotFoundException paramString7)
      {
        Object localObject3;
        paramString7 = "";
        localObject2 = localObject1;
        continue;
        if (!e(paramContext)) {
          continue;
        }
        localObject1 = "PAD";
        continue;
        localObject1 = "PHONE";
        continue;
      }
      localObject3 = a((String)localObject2);
      if (!"QB".equals(localObject3)) {
        continue;
      }
      if (!paramBoolean) {
        continue;
      }
      localObject1 = "PAD";
      localStringBuilder.append("QV=3");
      a(localStringBuilder, "PL", "ADR");
      a(localStringBuilder, "PR", (String)localObject3);
      a(localStringBuilder, "PP", (String)localObject2);
      a(localStringBuilder, "PPVN", paramString7);
      if (!TextUtils.isEmpty(paramString1)) {
        a(localStringBuilder, "TBSVC", paramString1);
      }
      a(localStringBuilder, "CO", "SYS");
      if (!TextUtils.isEmpty(paramString2)) {
        a(localStringBuilder, "COVC", paramString2);
      }
      a(localStringBuilder, "PB", paramString4);
      a(localStringBuilder, "VE", paramString3);
      a(localStringBuilder, "DE", (String)localObject1);
      paramString1 = paramString6;
      if (TextUtils.isEmpty(paramString6)) {
        paramString1 = "0";
      }
      a(localStringBuilder, "CHID", paramString1);
      a(localStringBuilder, "LCID", paramString5);
      paramContext = d(paramContext);
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        continue;
      }
      if (!TextUtils.isEmpty(paramContext)) {
        a(localStringBuilder, "MO", paramContext);
      }
      a(localStringBuilder, "RL", str);
      paramContext = Build.VERSION.RELEASE;
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        continue;
      }
      if (!TextUtils.isEmpty(paramContext)) {
        a(localStringBuilder, "OS", paramContext);
      }
      a(localStringBuilder, "API", Build.VERSION.SDK_INT);
      paramContext = localStringBuilder.toString();
      AppMethodBeat.o(219333);
      return paramContext;
      localObject1 = localObject2;
      paramString7 = ((PackageInfo)localObject3).versionName;
    }
  }
  
  private static String a(String paramString)
  {
    AppMethodBeat.i(219339);
    if ("com.tencent.mm".equals(paramString))
    {
      AppMethodBeat.o(219339);
      return "WX";
    }
    if ("com.tencent.mobileqq".equals(paramString))
    {
      AppMethodBeat.o(219339);
      return "QQ";
    }
    if ("com.qzone".equals(paramString))
    {
      AppMethodBeat.o(219339);
      return "QZ";
    }
    if ("com.tencent.mtt".equals(paramString))
    {
      AppMethodBeat.o(219339);
      return "QB";
    }
    AppMethodBeat.o(219339);
    return "TRD";
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    AppMethodBeat.i(219335);
    paramStringBuilder.append("&").append(paramString1).append("=").append(paramString2);
    AppMethodBeat.o(219335);
  }
  
  private static int b(Context paramContext)
  {
    AppMethodBeat.i(219342);
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null)
    {
      int j = paramContext.getWidth();
      AppMethodBeat.o(219342);
      return j;
    }
    AppMethodBeat.o(219342);
    return -1;
  }
  
  private static int c(Context paramContext)
  {
    AppMethodBeat.i(219346);
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null)
    {
      int j = paramContext.getHeight();
      AppMethodBeat.o(219346);
      return j;
    }
    AppMethodBeat.o(219346);
    return -1;
  }
  
  private static String d(Context paramContext)
  {
    AppMethodBeat.i(219350);
    paramContext = r.d(paramContext);
    paramContext = " " + paramContext.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
    AppMethodBeat.o(219350);
    return paramContext;
  }
  
  private static boolean e(Context paramContext)
  {
    boolean bool = true;
    AppMethodBeat.i(219352);
    if (h)
    {
      bool = i;
      AppMethodBeat.o(219352);
      return bool;
    }
    try
    {
      if (Math.min(b(paramContext), c(paramContext)) * 160 / f(paramContext) >= 700) {}
      for (;;)
      {
        i = bool;
        h = true;
        bool = i;
        return bool;
        bool = false;
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(219352);
    }
  }
  
  private static int f(Context paramContext)
  {
    AppMethodBeat.i(219357);
    Object localObject = (WindowManager)paramContext.getSystemService("window");
    paramContext = new DisplayMetrics();
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    if (localObject != null)
    {
      ((Display)localObject).getMetrics(paramContext);
      int j = paramContext.densityDpi;
      AppMethodBeat.o(219357);
      return j;
    }
    AppMethodBeat.o(219357);
    return 160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.utils.m
 * JD-Core Version:    0.7.0.1
 */