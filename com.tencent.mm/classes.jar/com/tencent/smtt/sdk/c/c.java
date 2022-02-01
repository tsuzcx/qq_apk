package com.tencent.smtt.sdk.c;

import android.content.ActivityNotFoundException;
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
    AppMethodBeat.i(219730);
    if (paramContext == null)
    {
      AppMethodBeat.o(219730);
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
        AppMethodBeat.o(219730);
        return 2;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(219730);
      return 2;
    }
    Object localObject2 = a(paramContext);
    if (((a)localObject2).a == -1)
    {
      AppMethodBeat.o(219730);
      return 4;
    }
    if ((((a)localObject2).a == 2) && (((a)localObject2).b < 33))
    {
      AppMethodBeat.o(219730);
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
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;Lcom/tencent/smtt/sdk/WebView;)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;Lcom/tencent/smtt/sdk/WebView;)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(219730);
        return 0;
      }
      catch (ActivityNotFoundException paramContext)
      {
        AppMethodBeat.o(219730);
        return 4;
      }
    }
  }
  
  public static int a(Context paramContext, String paramString1, HashMap<String, String> paramHashMap, String paramString2, WebView paramWebView)
  {
    j = 0;
    AppMethodBeat.i(219721);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        localObject1 = paramContext.getPackageManager();
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((PackageManager)localObject1).getPackageInfo("com.tencent.mtt", 0);
        if (localObject1 == null) {
          continue;
        }
        i = ((PackageInfo)localObject1).versionCode;
        if (i <= 601000) {
          continue;
        }
        i = 1;
      }
      finally
      {
        Object localObject1;
        int i = 0;
        continue;
        String str = "";
        continue;
        i = 0;
        continue;
      }
      try
      {
        localObject1 = URLEncoder.encode(paramString1, "UTF-8");
        if (i != 0) {
          paramString1 = (String)localObject1;
        }
      }
      catch (Exception localException)
      {
        i = j;
      }
    }
    if (i != 0)
    {
      localObject1 = ",encoded=1";
      localStringBuilder.append("mttbrowser://url=").append(paramString1).append(",product=TBS,packagename=").append(paramContext.getPackageName()).append(",from=").append(paramString2).append(",version=4.4.1.0038").append((String)localObject1);
      i = a(paramContext, localStringBuilder.toString(), paramHashMap, paramWebView);
      AppMethodBeat.o(219721);
      return i;
    }
  }
  
  private static Uri a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(219713);
    paramContext = Uri.fromFile(new File(paramString));
    AppMethodBeat.o(219713);
    return paramContext;
  }
  
  public static a a(Context paramContext)
  {
    AppMethodBeat.i(219748);
    boolean bool = paramContext.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
    locala = new a();
    if (bool)
    {
      AppMethodBeat.o(219748);
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
              AppMethodBeat.o(219748);
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
    AppMethodBeat.o(219748);
    return locala;
  }
  
  private static b a(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(219742);
    Object localObject = new Intent("com.tencent.QQBrowser.action.VIEW");
    ((Intent)localObject).setData(paramUri);
    paramUri = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    if (paramUri.size() <= 0)
    {
      AppMethodBeat.o(219742);
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
        AppMethodBeat.o(219742);
        return paramContext;
      }
      if (str.contains("com.tencent.qbx"))
      {
        paramContext.a = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.b = ((ResolveInfo)localObject).activityInfo.packageName;
      }
    }
    AppMethodBeat.o(219742);
    return paramContext;
  }
  
  public static boolean a(Context paramContext, long paramLong1, long paramLong2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(219761);
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
      AppMethodBeat.o(219761);
      return bool1;
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2, HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    AppMethodBeat.i(219711);
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
      AppMethodBeat.o(219711);
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
      AppMethodBeat.o(219711);
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
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/util/HashMap;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/util/HashMap;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(219711);
    return true;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: ldc_w 419
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 50	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   10: astore 4
    //   12: new 60	android/content/Intent
    //   15: dup
    //   16: ldc 62
    //   18: invokespecial 66	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: ldc 145
    //   25: invokevirtual 422	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   28: pop
    //   29: aload_1
    //   30: aload 4
    //   32: ldc_w 424
    //   35: invokevirtual 410	android/content/Intent:setDataAndType	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;
    //   38: pop
    //   39: aload_2
    //   40: ifnull +76 -> 116
    //   43: aload_2
    //   44: invokevirtual 84	java/util/HashMap:keySet	()Ljava/util/Set;
    //   47: astore 4
    //   49: aload 4
    //   51: ifnull +65 -> 116
    //   54: aload 4
    //   56: invokeinterface 90 1 0
    //   61: astore 4
    //   63: aload 4
    //   65: invokeinterface 96 1 0
    //   70: ifeq +46 -> 116
    //   73: aload 4
    //   75: invokeinterface 100 1 0
    //   80: checkcast 36	java/lang/String
    //   83: astore 5
    //   85: aload_2
    //   86: aload 5
    //   88: invokevirtual 104	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   91: checkcast 36	java/lang/String
    //   94: astore 6
    //   96: aload 6
    //   98: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifne -38 -> 63
    //   104: aload_1
    //   105: aload 5
    //   107: aload 6
    //   109: invokevirtual 113	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   112: pop
    //   113: goto -50 -> 63
    //   116: aload_1
    //   117: ldc 137
    //   119: aload_0
    //   120: invokestatic 141	com/tencent/smtt/sdk/c/c:d	(Landroid/content/Context;)I
    //   123: invokevirtual 144	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   126: pop
    //   127: aload_1
    //   128: new 426	android/content/ComponentName
    //   131: dup
    //   132: ldc 68
    //   134: ldc_w 428
    //   137: invokespecial 431	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: invokevirtual 435	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   143: pop
    //   144: new 178	com/tencent/mm/hellhoundlib/b/a
    //   147: dup
    //   148: invokespecial 181	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   151: aload_1
    //   152: invokevirtual 185	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   155: astore_2
    //   156: aload_0
    //   157: aload_2
    //   158: invokevirtual 189	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   161: ldc 190
    //   163: ldc 191
    //   165: ldc_w 436
    //   168: ldc 194
    //   170: ldc 196
    //   172: ldc 198
    //   174: invokestatic 203	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_0
    //   178: aload_2
    //   179: iconst_0
    //   180: invokevirtual 207	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   183: checkcast 60	android/content/Intent
    //   186: invokevirtual 211	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   189: aload_0
    //   190: ldc 190
    //   192: ldc 191
    //   194: ldc_w 436
    //   197: ldc 194
    //   199: ldc 196
    //   201: ldc 198
    //   203: invokestatic 215	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   206: iconst_1
    //   207: istore_3
    //   208: iload_3
    //   209: ifne +71 -> 280
    //   212: aload_1
    //   213: aconst_null
    //   214: invokevirtual 435	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   217: pop
    //   218: new 178	com/tencent/mm/hellhoundlib/b/a
    //   221: dup
    //   222: invokespecial 181	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   225: aload_1
    //   226: invokevirtual 185	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   229: astore_1
    //   230: aload_0
    //   231: aload_1
    //   232: invokevirtual 189	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   235: ldc 190
    //   237: ldc 191
    //   239: ldc_w 436
    //   242: ldc 194
    //   244: ldc 196
    //   246: ldc 198
    //   248: invokestatic 203	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   251: aload_0
    //   252: aload_1
    //   253: iconst_0
    //   254: invokevirtual 207	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   257: checkcast 60	android/content/Intent
    //   260: invokevirtual 211	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   263: aload_0
    //   264: ldc 190
    //   266: ldc 191
    //   268: ldc_w 436
    //   271: ldc 194
    //   273: ldc 196
    //   275: ldc 198
    //   277: invokestatic 215	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   280: ldc_w 419
    //   283: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: iconst_1
    //   287: ireturn
    //   288: astore_2
    //   289: iconst_0
    //   290: istore_3
    //   291: goto -83 -> 208
    //   294: astore_0
    //   295: ldc_w 419
    //   298: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: iconst_0
    //   302: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramContext	Context
    //   0	303	1	paramString	String
    //   0	303	2	paramHashMap	HashMap<String, String>
    //   207	84	3	i	int
    //   10	64	4	localObject	Object
    //   83	23	5	str1	String
    //   94	14	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   116	206	288	finally
    //   212	280	294	finally
  }
  
  private static boolean a(String paramString)
  {
    AppMethodBeat.i(219751);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(219751);
      return false;
    }
    paramString = paramString.trim();
    int i = paramString.toLowerCase().indexOf("://");
    int j = paramString.toLowerCase().indexOf('.');
    if ((i > 0) && (j > 0) && (i > j))
    {
      AppMethodBeat.o(219751);
      return false;
    }
    boolean bool = paramString.toLowerCase().contains("://");
    AppMethodBeat.o(219751);
    return bool;
  }
  
  public static boolean b(Context paramContext)
  {
    AppMethodBeat.i(219754);
    if (a(paramContext).a == -1)
    {
      AppMethodBeat.o(219754);
      return false;
    }
    AppMethodBeat.o(219754);
    return true;
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool2 = true;
    AppMethodBeat.i(219757);
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
      AppMethodBeat.o(219757);
      return bool1;
    }
  }
  
  private static int d(Context paramContext)
  {
    AppMethodBeat.i(219736);
    int i = 26;
    paramContext = paramContext.getApplicationInfo().processName;
    if (paramContext.equals("com.tencent.mobileqq")) {
      i = 13;
    }
    for (;;)
    {
      AppMethodBeat.o(219736);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.c.c
 * JD-Core Version:    0.7.0.1
 */