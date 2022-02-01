package com.tencent.mm.pluginsdk.model.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.plugin.appbrand.aa.b;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class q
{
  public static String K(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(151762);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2.length() == 0))
    {
      ad.e("MicroMsg.AppUtil", "buildUnistallUrl fail, invalid arguments");
      AppMethodBeat.o(151762);
      return null;
    }
    String str2 = ac.f(paramContext.getSharedPreferences(aj.eFD(), 0));
    String str1;
    if ((str2 == null) || (str2.length() == 0)) {
      str1 = "zh_CN";
    }
    for (;;)
    {
      paramContext = paramContext.getString(2131761813, new Object[] { paramString1, Integer.valueOf(d.CpK), str1, d.glX, paramString2, Integer.valueOf(0) });
      AppMethodBeat.o(151762);
      return paramContext;
      str1 = str2;
      if (str2.equals("en")) {
        str1 = "en_US";
      }
    }
  }
  
  public static String O(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151763);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ad.e("MicroMsg.AppUtil", "buildRedirectUrl fail, invalid arguments");
      AppMethodBeat.o(151763);
      return null;
    }
    paramString1 = paramString1.trim();
    int i = paramString1.indexOf("#");
    String str1;
    if (i >= 0)
    {
      str1 = paramString1.substring(i);
      paramString1 = paramString1.substring(0, i);
    }
    for (;;)
    {
      i = paramString1.indexOf("?");
      String str3 = "";
      String str2 = paramString1;
      if (i >= 0)
      {
        str3 = paramString1.substring(i + 1);
        str2 = paramString1.substring(0, i);
      }
      ad.v("MicroMsg.AppUtil", "buildRedirectUrl, sharpStr = %s, paramStr = %s, srcUrl = %s", new Object[] { str1, str3, str2 });
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      if (!bt.isNullOrNil(str3))
      {
        String[] arrayOfString = str3.split("&");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            String str4 = arrayOfString[i];
            if (!bt.isNullOrNil(str4))
            {
              int k = str4.indexOf("=");
              ad.v("MicroMsg.AppUtil", "buildRedirectUrl, equalIdx = %d", new Object[] { Integer.valueOf(k) });
              if (k < 0) {
                break label256;
              }
              paramString1 = str4.substring(0, k + 1);
              str3 = str4.substring(k + 1);
            }
            for (;;)
            {
              localLinkedHashMap.put(paramString1, str3);
              i += 1;
              break;
              label256:
              str3 = "";
              paramString1 = str4;
            }
          }
        }
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localLinkedHashMap.put("from=", paramString1);
      ad.v("MicroMsg.AppUtil", "buildRedirectUrl, pMap size = %d", new Object[] { Integer.valueOf(localLinkedHashMap.size()) });
      paramString1 = new StringBuilder();
      paramString2 = localLinkedHashMap.keySet().iterator();
      while (paramString2.hasNext())
      {
        str3 = (String)paramString2.next();
        if (paramString1.length() > 0) {
          paramString1.append("&");
        }
        paramString1.append(str3);
        paramString1.append((String)localLinkedHashMap.get(str3));
      }
      paramString1 = paramString1.toString();
      paramString2 = str2 + "?" + paramString1;
      paramString1 = paramString2;
      if (!bt.isNullOrNil(str1)) {
        paramString1 = paramString2 + str1;
      }
      ad.v("MicroMsg.AppUtil", "buildRedirectUrl, ret url = %s", new Object[] { paramString1 });
      AppMethodBeat.o(151763);
      return paramString1;
      str1 = "";
    }
  }
  
  public static boolean a(Context paramContext, g paramg, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151767);
    a locala = a.a.cZX();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.AppUtil", "isAppValid, packageName is null");
      locala.e(paramg);
      AppMethodBeat.o(151767);
      return false;
    }
    if (paramg == null)
    {
      ad.i("MicroMsg.AppUtil", "app does not exist");
      AppMethodBeat.o(151767);
      return true;
    }
    if ((paramg.field_packageName == null) || (paramg.field_packageName.length() == 0))
    {
      ad.e("MicroMsg.AppUtil", "isAppValid fail, local packageName is null");
      locala.e(paramg);
      AppMethodBeat.o(151767);
      return false;
    }
    if ((paramg.field_signature == null) || (paramg.field_signature.length() == 0))
    {
      ad.e("MicroMsg.AppUtil", "isAppValid fail, local signature is null");
      locala.e(paramg);
      AppMethodBeat.o(151767);
      return false;
    }
    Signature[] arrayOfSignature = bJ(paramContext, paramString);
    if ((arrayOfSignature == null) || (arrayOfSignature.length == 0))
    {
      ad.e("MicroMsg.AppUtil", "isAppValid, apk signatures is null");
      locala.e(paramg);
      AppMethodBeat.o(151767);
      return false;
    }
    if (!bt.kU(paramg.field_packageName, paramString))
    {
      ad.e("MicroMsg.AppUtil", "isAppValid, packageName is diff, src:%s,local:%s", new Object[] { paramg.field_packageName, paramString });
      locala.e(paramg);
      if (paramBoolean) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151760);
            Toast.makeText(this.val$context, this.val$context.getString(2131761809), 1).show();
            AppMethodBeat.o(151760);
          }
        });
      }
      AppMethodBeat.o(151767);
      return false;
    }
    ad.i("MicroMsg.AppUtil", "server signatures:%s", new Object[] { paramg.field_signature });
    int j = arrayOfSignature.length;
    int i = 0;
    while (i < j)
    {
      paramString = r.aAY(com.tencent.mm.b.g.getMessageDigest(arrayOfSignature[i].toByteArray()));
      ad.i("MicroMsg.AppUtil", "local signatures:%s", new Object[] { paramString });
      if ((paramg.field_signature != null) && (paramg.field_signature.equals(paramString)))
      {
        locala.f(paramg);
        AppMethodBeat.o(151767);
        return true;
      }
      i += 1;
    }
    if (paramBoolean) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(162008);
          Toast.makeText(this.val$context, this.val$context.getString(2131761810), 1).show();
          AppMethodBeat.o(162008);
        }
      });
    }
    ad.w("MicroMsg.AppUtil", "isAppValid, signature is diff");
    locala.e(paramg);
    AppMethodBeat.o(151767);
    return false;
  }
  
  public static void aAX(String paramString)
  {
    AppMethodBeat.i(151773);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.AppUtil", "appid is null");
      AppMethodBeat.o(151773);
      return;
    }
    SharedPreferences localSharedPreferences = aj.eFE();
    if (localSharedPreferences != null)
    {
      String str = localSharedPreferences.getString("key_app_ids_registion_while_not_login", "");
      if (str.contains(paramString))
      {
        ad.i("MicroMsg.AppUtil", "this app has been saved : %s in %s", new Object[] { paramString, str });
        AppMethodBeat.o(151773);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("|");
      localStringBuilder.append(str);
      paramString = localStringBuilder.toString();
      localSharedPreferences.edit().putString("key_app_ids_registion_while_not_login", paramString).commit();
    }
    AppMethodBeat.o(151773);
  }
  
  public static String aK(Activity paramActivity)
  {
    AppMethodBeat.i(151776);
    Object localObject1 = "";
    localObject2 = paramActivity.getCallingActivity();
    if (localObject2 != null)
    {
      localObject1 = ((ComponentName)localObject2).getPackageName();
      ad.i("MicroMsg.AppUtil", "get calling activity, %s", new Object[] { localObject1 });
    }
    localObject2 = localObject1;
    if (bt.isNullOrNil((String)localObject1))
    {
      localObject2 = localObject1;
      if (Build.VERSION.SDK_INT >= 22) {
        localObject3 = localObject1;
      }
    }
    try
    {
      Object localObject4 = new c(paramActivity, "mReferrer", null).get();
      localObject2 = localObject1;
      if (localObject4 != null)
      {
        localObject3 = localObject1;
        localObject2 = (String)localObject4;
      }
      localObject3 = localObject2;
      ad.i("MicroMsg.AppUtil", "get referrer, %s", new Object[] { localObject2 });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppUtil", localException, "get mReferrer error", new Object[0]);
        localObject2 = localObject3;
      }
    }
    localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2))
    {
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 22)
      {
        paramActivity = paramActivity.getReferrer();
        localObject1 = localObject2;
        if (paramActivity != null)
        {
          localObject1 = paramActivity.getAuthority();
          ad.i("MicroMsg.AppUtil", "get referrer, %s", new Object[] { localObject1 });
        }
      }
    }
    AppMethodBeat.o(151776);
    return localObject1;
  }
  
  public static void aS(Bundle paramBundle)
  {
    AppMethodBeat.i(151768);
    if (paramBundle != null) {
      paramBundle.putString("wx_token_key", "com.tencent.mm.openapi.token");
    }
    AppMethodBeat.o(151768);
  }
  
  public static void aT(Bundle paramBundle)
  {
    AppMethodBeat.i(151769);
    if (paramBundle != null) {
      paramBundle.putString("platformId", "wechat");
    }
    AppMethodBeat.o(151769);
  }
  
  public static boolean b(Context paramContext, g paramg)
  {
    AppMethodBeat.i(151772);
    ad.i("MicroMsg.AppUtil", "check the signature of the Application.");
    if (paramContext == null)
    {
      ad.e("MicroMsg.AppUtil", "context is null.");
      AppMethodBeat.o(151772);
      return true;
    }
    if (paramg == null)
    {
      ad.e("MicroMsg.AppUtil", "appInfo is null.");
      AppMethodBeat.o(151772);
      return true;
    }
    if (bt.isNullOrNil(paramg.field_packageName))
    {
      ad.e("MicroMsg.AppUtil", "packageName is null.");
      AppMethodBeat.o(151772);
      return true;
    }
    if (bt.isNullOrNil(paramg.field_signature))
    {
      ad.e("MicroMsg.AppUtil", "app.field_signature is null. app.field_packageName is %s", new Object[] { paramg.field_packageName });
      AppMethodBeat.o(151772);
      return true;
    }
    paramContext = bJ(paramContext, paramg.field_packageName);
    if ((paramContext == null) || (paramContext.length == 0))
    {
      ad.e("MicroMsg.AppUtil", "apk signatures is null");
      AppMethodBeat.o(151772);
      return false;
    }
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str = r.aAY(com.tencent.mm.b.g.getMessageDigest(paramContext[i].toByteArray()));
      if (paramg.field_signature.equals(str))
      {
        ad.i("MicroMsg.AppUtil", "app_name : %s ,signature : %s", new Object[] { paramg.field_appName, paramg.field_signature });
        AppMethodBeat.o(151772);
        return true;
      }
      i += 1;
    }
    ad.w("MicroMsg.AppUtil", "signature is diff.(app_name:%s)", new Object[] { paramg.field_appName });
    AppMethodBeat.o(151772);
    return false;
  }
  
  public static String bH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151765);
    paramContext = bJ(paramContext, paramString);
    if ((paramContext == null) || (paramContext.length == 0))
    {
      ad.e("MicroMsg.AppUtil", "signs is null");
      AppMethodBeat.o(151765);
      return null;
    }
    paramContext = r.aAY(com.tencent.mm.b.g.getMessageDigest(paramContext[0].toByteArray()));
    AppMethodBeat.o(151765);
    return paramContext;
  }
  
  public static String bI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151766);
    paramContext = bJ(paramContext, paramString);
    if ((paramContext == null) || (paramContext.length == 0))
    {
      ad.e("MicroMsg.AppUtil", "signs is null");
      AppMethodBeat.o(151766);
      return null;
    }
    paramContext = com.tencent.mm.b.g.getMessageDigest(paramContext[0].toByteArray());
    AppMethodBeat.o(151766);
    return paramContext;
  }
  
  public static Signature[] bJ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151771);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.AppUtil", "getSignature, packageName is null");
      AppMethodBeat.o(151771);
      return null;
    }
    if (paramContext == null)
    {
      ad.e("MicroMsg.AppUtil", "getSignature, context is null");
      AppMethodBeat.o(151771);
      return null;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString, 64);
      if (paramContext == null)
      {
        ad.e("MicroMsg.AppUtil", "info is null, packageName = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(151771);
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ad.e("MicroMsg.AppUtil", "NameNotFoundException");
      AppMethodBeat.o(151771);
      return null;
    }
    paramContext = paramContext.signatures;
    AppMethodBeat.o(151771);
    return paramContext;
  }
  
  public static String e(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(151761);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      ad.e("MicroMsg.AppUtil", "buildSourceUrl fail, invalid arguments");
      AppMethodBeat.o(151761);
      return null;
    }
    String str2 = ac.f(paramContext.getSharedPreferences(aj.eFD(), 0));
    String str1;
    if ((str2 == null) || (str2.length() == 0)) {
      str1 = "zh_CN";
    }
    for (;;)
    {
      paramContext = paramContext.getString(2131761812, new Object[] { paramString1, Integer.valueOf(d.CpK), str1, d.glX, paramString2 });
      AppMethodBeat.o(151761);
      return paramContext;
      str1 = str2;
      if (str2.equals("en")) {
        str1 = "en_US";
      }
    }
  }
  
  public static void evM()
  {
    ar.BRb = null;
    ar.BRc = -1L;
  }
  
  public static void evN()
  {
    AppMethodBeat.i(151774);
    SharedPreferences localSharedPreferences = aj.eFE();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString("key_app_ids_registion_while_not_login", "").commit();
    }
    AppMethodBeat.o(151774);
  }
  
  public static void j(Activity paramActivity, final String paramString)
  {
    AppMethodBeat.i(151775);
    com.tencent.e.h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(162009);
        if ((this.val$activity == null) || (this.val$activity.isFinishing()))
        {
          AppMethodBeat.o(162009);
          return;
        }
        ad.v("MicroMsg.AppUtil", "reportLaunchWechat");
        try
        {
          String str2 = q.aK(this.val$activity);
          boolean bool1;
          if (bt.isNullOrNil(str2))
          {
            bool1 = bt.isNullOrNil(paramString);
            if (bool1)
            {
              AppMethodBeat.o(162009);
              return;
            }
          }
          Object localObject1 = this.val$activity;
          Object localObject2 = new Intent("android.intent.action.MAIN", null);
          ((Intent)localObject2).addCategory("android.intent.category.HOME");
          localObject1 = ((Activity)localObject1).getPackageManager().queryIntentActivities((Intent)localObject2, 0);
          int i;
          if (!bt.gL((List)localObject1))
          {
            i = 0;
            if (i < ((List)localObject1).size()) {
              if (bt.kU(str2, ((ResolveInfo)((List)localObject1).get(i)).activityInfo.packageName))
              {
                bool1 = true;
                label157:
                boolean bool2 = bt.isNullOrNil(paramString);
                if (bool2) {
                  break label287;
                }
              }
            }
          }
          for (;;)
          {
            try
            {
              localObject1 = URLEncoder.encode(paramString, "UTF-8");
              localObject2 = com.tencent.mm.plugin.report.service.h.vKh;
              if (!bool1) {
                break label294;
              }
              i = 1;
              ((com.tencent.mm.plugin.report.service.h)localObject2).f(17591, new Object[] { "", str2, localObject1, Integer.valueOf(i) });
              ad.i("MicroMsg.AppUtil", "reportLaunchWechat callPackage=%s, isCategoryHome = %b, url=%s, isCategoryHome= %b", new Object[] { str2, Boolean.valueOf(bool1), localObject1, Boolean.valueOf(bool1) });
              AppMethodBeat.o(162009);
              return;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              ad.e("MicroMsg.AppUtil", "reportLaunchWechat parse fail");
            }
            i += 1;
            break;
            bool1 = false;
            break label157;
            label287:
            String str1 = "";
            continue;
            label294:
            i = 0;
          }
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.AppUtil", "reportLaunchWechat ex:%s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(162009);
        }
      }
    }, "reportLaunchWechat");
    AppMethodBeat.o(151775);
  }
  
  public static void j(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(151770);
    paramBundle.putString("platformId", "wechat");
    if (!bt.isNullOrNil(paramString)) {
      paramBundle.putString("launchParam", paramString);
    }
    AppMethodBeat.o(151770);
  }
  
  public static boolean t(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151764);
    if (b.getPackageInfo(paramContext, paramString) != null)
    {
      AppMethodBeat.o(151764);
      return true;
    }
    AppMethodBeat.o(151764);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.q
 * JD-Core Version:    0.7.0.1
 */