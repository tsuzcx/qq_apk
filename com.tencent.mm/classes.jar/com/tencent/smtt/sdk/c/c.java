package com.tencent.smtt.sdk.c;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c
{
  private byte _hellAccFlag_;
  
  public static int a(Context paramContext, String paramString, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    AppMethodBeat.i(188208);
    if (paramContext == null)
    {
      AppMethodBeat.o(188208);
      return 3;
    }
    Object localObject1 = paramString;
    if (!a(paramString)) {
      localObject1 = "http://".concat(String.valueOf(paramString));
    }
    try
    {
      localObject1 = Uri.parse((String)localObject1);
      if (localObject1 == null)
      {
        AppMethodBeat.o(188208);
        return 2;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(188208);
      return 2;
    }
    Object localObject2 = a(paramContext);
    if (((a)localObject2).a == -1)
    {
      AppMethodBeat.o(188208);
      return 4;
    }
    if ((((a)localObject2).a == 2) && (((a)localObject2).b < 33))
    {
      AppMethodBeat.o(188208);
      return 5;
    }
    paramString = new Intent("android.intent.action.VIEW");
    if (((a)localObject2).a == 2) {
      if ((((a)localObject2).b >= 33) && (((a)localObject2).b <= 39)) {
        paramString.setClassName("com.tencent.mtt", "com.tencent.mtt.MainActivity");
      }
    }
    label683:
    for (;;)
    {
      paramString.setData((Uri)localObject1);
      if (paramHashMap != null)
      {
        localObject1 = paramHashMap.keySet();
        if (localObject1 != null)
        {
          localObject1 = ((Set)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              String str = (String)paramHashMap.get(localObject2);
              if (!TextUtils.isEmpty(str))
              {
                paramString.putExtra((String)localObject2, str);
                continue;
                if ((((a)localObject2).b >= 40) && (((a)localObject2).b <= 45))
                {
                  paramString.setClassName("com.tencent.mtt", "com.tencent.mtt.SplashActivity");
                  break;
                }
                if (((a)localObject2).b < 46) {
                  break label683;
                }
                paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                localObject2 = a(paramContext, (Uri)localObject1);
                if ((localObject2 != null) && (!TextUtils.isEmpty(((b)localObject2).a))) {
                  paramString.setClassName(((b)localObject2).b, ((b)localObject2).a);
                }
                break;
                if (((a)localObject2).a == 1)
                {
                  if (((a)localObject2).b == 1)
                  {
                    paramString.setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                    break;
                  }
                  if (((a)localObject2).b != 2) {
                    break label683;
                  }
                  paramString.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                  break;
                }
                if (((a)localObject2).a == 0)
                {
                  if ((((a)localObject2).b >= 4) && (((a)localObject2).b <= 6))
                  {
                    paramString.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                    break;
                  }
                  if (((a)localObject2).b <= 6) {
                    break label683;
                  }
                  paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                  localObject2 = a(paramContext, (Uri)localObject1);
                  if ((localObject2 != null) && (!TextUtils.isEmpty(((b)localObject2).a))) {
                    paramString.setClassName(((b)localObject2).b, ((b)localObject2).a);
                  }
                  break;
                }
                paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                localObject2 = a(paramContext, (Uri)localObject1);
                if ((localObject2 != null) && (!TextUtils.isEmpty(((b)localObject2).a))) {
                  paramString.setClassName(((b)localObject2).b, ((b)localObject2).a);
                }
                break;
              }
            }
          }
        }
      }
      try
      {
        paramString.putExtra("loginType", d(paramContext));
        paramString.addFlags(268435456);
        if (paramWebView != null)
        {
          paramString.putExtra("AnchorPoint", new Point(paramWebView.getScrollX(), paramWebView.getScrollY()));
          paramString.putExtra("ContentSize", new Point(paramWebView.getContentWidth(), paramWebView.getContentHeight()));
        }
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;Lcom/tencent/smtt/sdk/WebView;)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;Lcom/tencent/smtt/sdk/WebView;)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(188208);
        return 0;
      }
      catch (ActivityNotFoundException paramContext)
      {
        AppMethodBeat.o(188208);
        return 4;
      }
    }
  }
  
  public static int a(Context paramContext, String paramString1, HashMap<String, String> paramHashMap, String paramString2, WebView paramWebView)
  {
    j = 0;
    AppMethodBeat.i(188207);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        localObject = paramContext.getPackageManager();
        if (localObject == null) {
          continue;
        }
        localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.mtt", 0);
        if (localObject == null) {
          continue;
        }
        i = ((PackageInfo)localObject).versionCode;
        if (i <= 601000) {
          continue;
        }
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int i = 0;
        continue;
        String str = "";
        continue;
        i = 0;
        continue;
      }
      try
      {
        localObject = URLEncoder.encode(paramString1, "UTF-8");
        if (i != 0) {
          paramString1 = (String)localObject;
        }
      }
      catch (Exception localException)
      {
        i = j;
      }
    }
    if (i != 0)
    {
      localObject = ",encoded=1";
      localStringBuilder.append("mttbrowser://url=").append(paramString1).append(",product=TBS,packagename=").append(paramContext.getPackageName()).append(",from=").append(paramString2).append(",version=4.4.0.0006").append((String)localObject);
      i = a(paramContext, localStringBuilder.toString(), paramHashMap, paramWebView);
      AppMethodBeat.o(188207);
      return i;
    }
  }
  
  private static Uri a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(188205);
    paramContext = Uri.fromFile(new File(paramString));
    AppMethodBeat.o(188205);
    return paramContext;
  }
  
  public static a a(Context paramContext)
  {
    AppMethodBeat.i(188211);
    boolean bool = paramContext.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
    locala = new a();
    if (bool)
    {
      AppMethodBeat.o(188211);
      return locala;
    }
    for (;;)
    {
      try
      {
        localPackageManager = paramContext.getPackageManager();
        localObject1 = null;
        try
        {
          localObject6 = localPackageManager.getPackageInfo("com.tencent.mtt", 0);
          localObject1 = localObject6;
          locala.a = 2;
          localObject1 = localObject6;
          locala.e = "com.tencent.mtt";
          localObject1 = localObject6;
          locala.c = "ADRQB_";
          Object localObject3 = localObject6;
          if (localObject6 != null)
          {
            localObject1 = localObject6;
            localObject3 = localObject6;
            if (((PackageInfo)localObject6).versionCode > 420000)
            {
              localObject1 = localObject6;
              locala.b = ((PackageInfo)localObject6).versionCode;
              localObject1 = localObject6;
              locala.c += ((PackageInfo)localObject6).versionName.replaceAll("\\.", "");
              localObject1 = localObject6;
              locala.d = ((PackageInfo)localObject6).versionName.replaceAll("\\.", "");
              AppMethodBeat.o(188211);
              return locala;
            }
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException3)
        {
          localObject4 = localObject1;
        }
      }
      catch (Exception paramContext)
      {
        PackageManager localPackageManager;
        Object localObject1;
        Object localObject6;
        Object localObject4;
        PackageInfo localPackageInfo1;
        Object localObject2;
        continue;
      }
      try
      {
        localObject1 = localPackageManager.getPackageInfo("com.tencent.qbx", 0);
        localObject4 = localObject1;
        locala.a = 0;
        localObject4 = localObject1;
        locala.e = "com.tencent.qbx";
        localObject4 = localObject1;
        locala.c = "ADRQBX_";
        paramContext = (Context)localObject1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        try
        {
          localPackageInfo1 = localPackageManager.getPackageInfo("com.tencent.qbx5", 0);
          localObject4 = localPackageInfo1;
          locala.a = 1;
          localObject4 = localPackageInfo1;
          locala.e = "com.tencent.qbx5";
          localObject4 = localPackageInfo1;
          locala.c = "ADRQBX5_";
          paramContext = localPackageInfo1;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2)
        {
          localObject2 = localObject4;
          try
          {
            localObject4 = localPackageManager.getPackageInfo("com.tencent.mtt", 0);
            localObject2 = localObject4;
            locala.e = "com.tencent.mtt";
            localObject2 = localObject4;
            locala.a = 2;
            localObject2 = localObject4;
            locala.c = "ADRQB_";
            paramContext = (Context)localObject4;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException4)
          {
            try
            {
              PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo("com.tencent.mtt.x86", 0);
              localObject2 = localPackageInfo2;
              locala.e = "com.tencent.mtt.x86";
              localObject2 = localPackageInfo2;
              locala.a = 2;
              localObject2 = localPackageInfo2;
              locala.c = "ADRQB_";
              paramContext = localPackageInfo2;
            }
            catch (Exception localException)
            {
              Object localObject5 = localObject2;
              try
              {
                localObject6 = a(paramContext, Uri.parse("https://mdc.html5.qq.com/mh?channel_id=50079&u="));
                paramContext = localObject2;
                if (localObject6 == null) {
                  continue;
                }
                paramContext = localObject2;
                localObject5 = localObject2;
                if (TextUtils.isEmpty(((b)localObject6).b)) {
                  continue;
                }
                localObject5 = localObject2;
                paramContext = localPackageManager.getPackageInfo(((b)localObject6).b, 0);
                localObject5 = paramContext;
                locala.e = ((b)localObject6).b;
                localObject5 = paramContext;
                locala.a = 2;
                localObject5 = paramContext;
                locala.c = "ADRQB_";
              }
              catch (Exception paramContext)
              {
                paramContext = (Context)localObject5;
              }
            }
          }
        }
      }
    }
    if (paramContext != null)
    {
      locala.b = paramContext.versionCode;
      locala.c += paramContext.versionName.replaceAll("\\.", "");
      locala.d = paramContext.versionName.replaceAll("\\.", "");
    }
    AppMethodBeat.o(188211);
    return locala;
  }
  
  private static b a(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(188210);
    Object localObject = new Intent("com.tencent.QQBrowser.action.VIEW");
    ((Intent)localObject).setData(paramUri);
    paramUri = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    if (paramUri.size() <= 0)
    {
      AppMethodBeat.o(188210);
      return null;
    }
    paramContext = new b(null);
    paramUri = paramUri.iterator();
    while (paramUri.hasNext())
    {
      localObject = (ResolveInfo)paramUri.next();
      String str = ((ResolveInfo)localObject).activityInfo.packageName;
      if (str.contains("com.tencent.mtt"))
      {
        paramContext.a = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.b = ((ResolveInfo)localObject).activityInfo.packageName;
        AppMethodBeat.o(188210);
        return paramContext;
      }
      if (str.contains("com.tencent.qbx"))
      {
        paramContext.a = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.b = ((ResolveInfo)localObject).activityInfo.packageName;
      }
    }
    AppMethodBeat.o(188210);
    return paramContext;
  }
  
  public static boolean a(Context paramContext, long paramLong1, long paramLong2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(188215);
    paramContext = a(paramContext);
    boolean bool1 = false;
    try
    {
      long l = Long.valueOf(paramContext.d).longValue();
      if (l >= paramLong1) {
        bool1 = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    if (paramContext.b >= paramLong2)
    {
      bool1 = bool2;
      AppMethodBeat.o(188215);
      return bool1;
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2, HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    AppMethodBeat.i(188204);
    Intent localIntent;
    try
    {
      localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
      if (paramHashMap != null)
      {
        Object localObject = paramHashMap.keySet();
        if (localObject != null)
        {
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str1 = (String)((Iterator)localObject).next();
            String str2 = (String)paramHashMap.get(str1);
            if (!TextUtils.isEmpty(str2)) {
              localIntent.putExtra(str1, str2);
            }
          }
        }
      }
      new File(paramString1);
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(188204);
      return false;
    }
    localIntent.putExtra("key_reader_sdk_id", 3);
    localIntent.putExtra("key_reader_sdk_type", paramInt);
    if (paramInt == 0) {
      localIntent.putExtra("key_reader_sdk_path", paramString1);
    }
    for (;;)
    {
      localIntent.putExtra("key_reader_sdk_format", paramString2);
      if ((paramContext != null) && (paramContext.getApplicationInfo().targetSdkVersion >= 24) && (Build.VERSION.SDK_INT >= 24)) {
        localIntent.addFlags(1);
      }
      paramString1 = a(paramContext, paramString1);
      if (paramString1 != null) {
        break;
      }
      AppMethodBeat.o(188204);
      return false;
      if (paramInt == 1) {
        localIntent.putExtra("key_reader_sdk_url", paramString1);
      }
    }
    localIntent.setDataAndType(paramString1, "mtt/".concat(String.valueOf(paramString2)));
    localIntent.putExtra("loginType", d(paramContext.getApplicationContext()));
    if (paramBundle != null) {
      localIntent.putExtra("key_reader_sdk_extrals", paramBundle);
    }
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString1.axQ(), "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/util/HashMap;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/util/HashMap;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(188204);
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(188206);
    Object localObject = Uri.parse(paramString);
    paramString = new Intent("android.intent.action.VIEW");
    paramString.setFlags(268435456);
    paramString.setDataAndType((Uri)localObject, "video/*");
    if (paramHashMap != null)
    {
      localObject = paramHashMap.keySet();
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          String str2 = (String)paramHashMap.get(str1);
          if (!TextUtils.isEmpty(str2)) {
            paramString.putExtra(str1, str2);
          }
        }
      }
    }
    try
    {
      paramString.putExtra("loginType", d(paramContext));
      paramString.setComponent(new ComponentName("com.tencent.mtt", "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
      paramHashMap = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramHashMap.axQ(), "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramHashMap.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      i = 1;
    }
    catch (Throwable paramHashMap)
    {
      for (;;)
      {
        try
        {
          paramString.setComponent(null);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.axQ(), "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(188206);
          return true;
        }
        catch (Throwable paramContext)
        {
          int i;
          AppMethodBeat.o(188206);
        }
        paramHashMap = paramHashMap;
        i = 0;
      }
    }
    if (i == 0) {}
    return false;
  }
  
  private static boolean a(String paramString)
  {
    AppMethodBeat.i(188212);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(188212);
      return false;
    }
    paramString = paramString.trim();
    int i = paramString.toLowerCase().indexOf("://");
    int j = paramString.toLowerCase().indexOf('.');
    if ((i > 0) && (j > 0) && (i > j))
    {
      AppMethodBeat.o(188212);
      return false;
    }
    boolean bool = paramString.toLowerCase().contains("://");
    AppMethodBeat.o(188212);
    return bool;
  }
  
  public static boolean b(Context paramContext)
  {
    AppMethodBeat.i(188213);
    if (a(paramContext).a == -1)
    {
      AppMethodBeat.o(188213);
      return false;
    }
    AppMethodBeat.o(188213);
    return true;
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool2 = true;
    AppMethodBeat.i(188214);
    paramContext = a(paramContext);
    boolean bool1 = false;
    try
    {
      long l = Long.valueOf(paramContext.d).longValue();
      if (l >= 6001500L) {
        bool1 = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    if (paramContext.b >= 601500)
    {
      bool1 = bool2;
      AppMethodBeat.o(188214);
      return bool1;
    }
  }
  
  private static int d(Context paramContext)
  {
    AppMethodBeat.i(188209);
    int i = 26;
    paramContext = paramContext.getApplicationInfo().processName;
    if (paramContext.equals("com.tencent.mobileqq")) {
      i = 13;
    }
    for (;;)
    {
      AppMethodBeat.o(188209);
      return i;
      if (paramContext.equals("com.qzone")) {
        i = 14;
      } else if (paramContext.equals("com.tencent.WBlog")) {
        i = 15;
      } else if (paramContext.equals("com.tencent.mm")) {
        i = 24;
      }
    }
  }
  
  public static class a
  {
    public int a = -1;
    public int b = -1;
    public String c = "";
    public String d = "0";
    public String e = null;
  }
  
  static class b
  {
    public String a = "";
    public String b = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.c.c
 * JD-Core Version:    0.7.0.1
 */