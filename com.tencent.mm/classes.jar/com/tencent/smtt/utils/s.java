package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public class s
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
  
  private static String a()
  {
    AppMethodBeat.i(65297);
    String str = " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
    AppMethodBeat.o(65297);
    return str;
  }
  
  public static String a(Context paramContext)
  {
    AppMethodBeat.i(65291);
    if (!TextUtils.isEmpty(a))
    {
      paramContext = a;
      AppMethodBeat.o(65291);
      return paramContext;
    }
    paramContext = a(paramContext, String.valueOf(WebView.getTbsSDKVersion(paramContext)), "0", b, c, d, e, f, g);
    a = paramContext;
    AppMethodBeat.o(65291);
    return paramContext;
  }
  
  private static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    AppMethodBeat.i(65292);
    String str2 = "";
    StringBuilder localStringBuilder = new StringBuilder();
    String str3 = b(paramContext) + "*" + c(paramContext);
    for (String str1 = str2;; str1 = str2)
    {
      try
      {
        ApplicationInfo localApplicationInfo = paramContext.getApplicationContext().getApplicationInfo();
        str1 = str2;
        localPackageInfo = paramContext.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
        str1 = str2;
        str2 = localApplicationInfo.packageName;
        str1 = str2;
        boolean bool = TextUtils.isEmpty(paramString7);
        if (bool) {
          break label395;
        }
        str1 = str2;
      }
      catch (PackageManager.NameNotFoundException paramString7)
      {
        for (;;)
        {
          PackageInfo localPackageInfo;
          label298:
          label344:
          paramString7 = "";
          label395:
          continue;
          if (d(paramContext)) {
            paramContext = "PAD";
          } else {
            paramContext = "PHONE";
          }
        }
      }
      str2 = a(str1);
      if (!"QB".equals(str2)) {
        break;
      }
      if (!paramBoolean) {
        break label443;
      }
      paramContext = "PAD";
      localStringBuilder.append("QV=3");
      a(localStringBuilder, "PL", "ADR");
      a(localStringBuilder, "PR", str2);
      a(localStringBuilder, "PP", str1);
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
      a(localStringBuilder, "DE", paramContext);
      paramContext = paramString6;
      if (TextUtils.isEmpty(paramString6)) {
        paramContext = "0";
      }
      a(localStringBuilder, "CHID", paramContext);
      a(localStringBuilder, "LCID", paramString5);
      paramContext = a();
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        break label298;
      }
      if (!TextUtils.isEmpty(paramContext)) {
        a(localStringBuilder, "MO", paramContext);
      }
      a(localStringBuilder, "RL", str3);
      paramContext = Build.VERSION.RELEASE;
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        break label344;
      }
      if (!TextUtils.isEmpty(paramContext)) {
        a(localStringBuilder, "OS", paramContext);
      }
      a(localStringBuilder, "API", Build.VERSION.SDK_INT);
      paramContext = localStringBuilder.toString();
      AppMethodBeat.o(65292);
      return paramContext;
      str1 = str2;
      paramString7 = localPackageInfo.versionName;
    }
  }
  
  private static String a(String paramString)
  {
    AppMethodBeat.i(65294);
    if ("com.tencent.mm".equals(paramString))
    {
      AppMethodBeat.o(65294);
      return "WX";
    }
    if ("com.tencent.mobileqq".equals(paramString))
    {
      AppMethodBeat.o(65294);
      return "QQ";
    }
    if ("com.qzone".equals(paramString))
    {
      AppMethodBeat.o(65294);
      return "QZ";
    }
    if ("com.tencent.mtt".equals(paramString))
    {
      AppMethodBeat.o(65294);
      return "QB";
    }
    AppMethodBeat.o(65294);
    return "TRD";
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    AppMethodBeat.i(65293);
    paramStringBuilder.append("&").append(paramString1).append("=").append(paramString2);
    AppMethodBeat.o(65293);
  }
  
  private static int b(Context paramContext)
  {
    AppMethodBeat.i(65295);
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null)
    {
      int j = paramContext.getWidth();
      AppMethodBeat.o(65295);
      return j;
    }
    AppMethodBeat.o(65295);
    return -1;
  }
  
  private static int c(Context paramContext)
  {
    AppMethodBeat.i(65296);
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null)
    {
      int j = paramContext.getHeight();
      AppMethodBeat.o(65296);
      return j;
    }
    AppMethodBeat.o(65296);
    return -1;
  }
  
  private static boolean d(Context paramContext)
  {
    boolean bool = true;
    AppMethodBeat.i(65298);
    if (h)
    {
      bool = i;
      AppMethodBeat.o(65298);
      return bool;
    }
    try
    {
      if (Math.min(b(paramContext), c(paramContext)) * 160 / e(paramContext) >= 700) {}
      for (;;)
      {
        i = bool;
        h = true;
        bool = i;
        AppMethodBeat.o(65298);
        return bool;
        bool = false;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(65298);
    }
  }
  
  private static int e(Context paramContext)
  {
    AppMethodBeat.i(65299);
    Object localObject = (WindowManager)paramContext.getSystemService("window");
    paramContext = new DisplayMetrics();
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    if (localObject != null)
    {
      ((Display)localObject).getMetrics(paramContext);
      int j = paramContext.densityDpi;
      AppMethodBeat.o(65299);
      return j;
    }
    AppMethodBeat.o(65299);
    return 160;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.utils.s
 * JD-Core Version:    0.7.0.1
 */