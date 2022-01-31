package com.tencent.smtt.sdk.a;

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
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class d
{
  public static int a(Context paramContext, String paramString, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    if (paramContext == null) {
      return 3;
    }
    Object localObject1 = paramString;
    if (!a(paramString)) {
      localObject1 = "http://" + paramString;
    }
    try
    {
      localObject1 = Uri.parse((String)localObject1);
      if (localObject1 == null) {
        return 2;
      }
    }
    catch (Exception paramContext)
    {
      return 2;
    }
    Object localObject2 = a(paramContext);
    if (((d.a)localObject2).a == -1) {
      return 4;
    }
    if ((((d.a)localObject2).a == 2) && (((d.a)localObject2).b < 33)) {
      return 5;
    }
    paramString = new Intent("android.intent.action.VIEW");
    if (((d.a)localObject2).a == 2) {
      if ((((d.a)localObject2).b >= 33) && (((d.a)localObject2).b <= 39)) {
        paramString.setClassName("com.tencent.mtt", "com.tencent.mtt.MainActivity");
      }
    }
    label595:
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
                if ((((d.a)localObject2).b >= 40) && (((d.a)localObject2).b <= 45))
                {
                  paramString.setClassName("com.tencent.mtt", "com.tencent.mtt.SplashActivity");
                  break;
                }
                if (((d.a)localObject2).b < 46) {
                  break label595;
                }
                paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                localObject2 = a(paramContext, (Uri)localObject1);
                if ((localObject2 != null) && (!TextUtils.isEmpty(((d.b)localObject2).a))) {
                  paramString.setClassName(((d.b)localObject2).b, ((d.b)localObject2).a);
                }
                break;
                if (((d.a)localObject2).a == 1)
                {
                  if (((d.a)localObject2).b == 1)
                  {
                    paramString.setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                    break;
                  }
                  if (((d.a)localObject2).b != 2) {
                    break label595;
                  }
                  paramString.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                  break;
                }
                if (((d.a)localObject2).a == 0)
                {
                  if ((((d.a)localObject2).b >= 4) && (((d.a)localObject2).b <= 6))
                  {
                    paramString.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                    break;
                  }
                  if (((d.a)localObject2).b <= 6) {
                    break label595;
                  }
                  paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                  localObject2 = a(paramContext, (Uri)localObject1);
                  if ((localObject2 != null) && (!TextUtils.isEmpty(((d.b)localObject2).a))) {
                    paramString.setClassName(((d.b)localObject2).b, ((d.b)localObject2).a);
                  }
                  break;
                }
                paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                localObject2 = a(paramContext, (Uri)localObject1);
                if ((localObject2 != null) && (!TextUtils.isEmpty(((d.b)localObject2).a))) {
                  paramString.setClassName(((d.b)localObject2).b, ((d.b)localObject2).a);
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
        paramContext.startActivity(paramString);
        return 0;
      }
      catch (ActivityNotFoundException paramContext)
      {
        return 4;
      }
    }
  }
  
  public static int a(Context paramContext, String paramString1, HashMap<String, String> paramHashMap, String paramString2, WebView paramWebView)
  {
    j = 0;
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
      localStringBuilder.append("mttbrowser://url=").append(paramString1).append(",product=TBS,packagename=").append(paramContext.getPackageName()).append(",from=").append(paramString2).append(",version=3.6.0.1350").append((String)localObject);
      return a(paramContext, localStringBuilder.toString(), paramHashMap, paramWebView);
    }
  }
  
  public static d.a a(Context paramContext)
  {
    boolean bool = paramContext.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
    locala = new d.a();
    if (bool) {
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
                localObject6 = a(paramContext, Uri.parse("http://mdc.html5.qq.com/mh?channel_id=50079&u="));
                paramContext = localObject2;
                if (localObject6 == null) {
                  continue;
                }
                paramContext = localObject2;
                localObject5 = localObject2;
                if (TextUtils.isEmpty(((d.b)localObject6).b)) {
                  continue;
                }
                localObject5 = localObject2;
                paramContext = localPackageManager.getPackageInfo(((d.b)localObject6).b, 0);
                localObject5 = paramContext;
                locala.e = ((d.b)localObject6).b;
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
    return locala;
  }
  
  private static d.b a(Context paramContext, Uri paramUri)
  {
    Object localObject = new Intent("com.tencent.QQBrowser.action.VIEW");
    ((Intent)localObject).setData(paramUri);
    paramUri = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    if (paramUri.size() <= 0) {
      return null;
    }
    paramContext = new d.b(null);
    paramUri = paramUri.iterator();
    while (paramUri.hasNext())
    {
      localObject = (ResolveInfo)paramUri.next();
      String str = ((ResolveInfo)localObject).activityInfo.packageName;
      if (str.contains("com.tencent.mtt"))
      {
        paramContext.a = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.b = ((ResolveInfo)localObject).activityInfo.packageName;
        return paramContext;
      }
      if (str.contains("com.tencent.qbx"))
      {
        paramContext.a = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.b = ((ResolveInfo)localObject).activityInfo.packageName;
      }
    }
    return paramContext;
  }
  
  public static boolean a(Context paramContext, long paramLong1, long paramLong2)
  {
    paramContext = a(paramContext);
    boolean bool = false;
    try
    {
      long l = Long.valueOf(paramContext.d).longValue();
      if (l >= paramLong1) {
        bool = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label30:
      break label30;
    }
    if (paramContext.b >= paramLong2) {
      return true;
    }
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2, HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    try
    {
      Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
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
      paramHashMap = new File(paramString1);
      localIntent.putExtra("key_reader_sdk_id", 3);
      localIntent.putExtra("key_reader_sdk_type", paramInt);
      if (paramInt == 0) {
        localIntent.putExtra("key_reader_sdk_path", paramString1);
      }
      for (;;)
      {
        localIntent.putExtra("key_reader_sdk_format", paramString2);
        localIntent.setDataAndType(Uri.fromFile(paramHashMap), "mtt/" + paramString2);
        localIntent.putExtra("loginType", d(paramContext.getApplicationContext()));
        if (paramBundle != null) {
          localIntent.putExtra("key_reader_sdk_extrals", paramBundle);
        }
        paramContext.startActivity(localIntent);
        return true;
        if (paramInt == 1) {
          localIntent.putExtra("key_reader_sdk_url", paramString1);
        }
      }
      return false;
    }
    catch (Exception paramContext) {}
  }
  
  public static boolean a(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
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
      paramContext.startActivity(paramString);
      i = 1;
    }
    catch (Throwable paramHashMap)
    {
      for (;;)
      {
        try
        {
          paramString.setComponent(null);
          paramContext.startActivity(paramString);
          return true;
        }
        catch (Throwable paramContext) {}
        paramHashMap = paramHashMap;
        int i = 0;
      }
    }
    if (i == 0) {}
    return false;
  }
  
  private static boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    int i;
    int j;
    do
    {
      return false;
      paramString = paramString.trim();
      i = paramString.toLowerCase().indexOf("://");
      j = paramString.toLowerCase().indexOf('.');
    } while ((i > 0) && (j > 0) && (i > j));
    return paramString.toLowerCase().contains("://");
  }
  
  public static boolean b(Context paramContext)
  {
    return a(paramContext).a != -1;
  }
  
  public static boolean c(Context paramContext)
  {
    paramContext = a(paramContext);
    boolean bool = false;
    try
    {
      long l = Long.valueOf(paramContext.d).longValue();
      if (l >= 6001500L) {
        bool = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label28:
      break label28;
    }
    if (paramContext.b >= 601500) {
      return true;
    }
    return bool;
  }
  
  private static int d(Context paramContext)
  {
    int i = 26;
    paramContext = paramContext.getApplicationInfo().processName;
    if (paramContext.equals("com.tencent.mobileqq")) {
      i = 13;
    }
    do
    {
      return i;
      if (paramContext.equals("com.qzone")) {
        return 14;
      }
      if (paramContext.equals("com.tencent.WBlog")) {
        return 15;
      }
    } while (!paramContext.equals("com.tencent.mm"));
    return 24;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.d
 * JD-Core Version:    0.7.0.1
 */