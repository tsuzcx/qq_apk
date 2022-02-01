package com.tencent.mm.pluginsdk.model.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.openapi.a.a;
import com.tencent.mm.plugin.openapi.a.a.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.threadpool.i;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class u
{
  public static boolean a(Context paramContext, g paramg, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151767);
    a locala = a.a.gxu();
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppUtil", "isAppValid, packageName is null");
      locala.e(paramg);
      AppMethodBeat.o(151767);
      return false;
    }
    if (paramg == null)
    {
      Log.i("MicroMsg.AppUtil", "app does not exist");
      AppMethodBeat.o(151767);
      return true;
    }
    if ((paramg.field_packageName == null) || (paramg.field_packageName.length() == 0))
    {
      Log.e("MicroMsg.AppUtil", "isAppValid fail, local packageName is null");
      locala.e(paramg);
      AppMethodBeat.o(151767);
      return false;
    }
    if ((paramg.field_signature == null) || (paramg.field_signature.length() == 0))
    {
      Log.e("MicroMsg.AppUtil", "isAppValid fail, local signature is null");
      locala.e(paramg);
      AppMethodBeat.o(151767);
      return false;
    }
    Signature[] arrayOfSignature = cG(paramContext, paramString);
    if ((arrayOfSignature == null) || (arrayOfSignature.length == 0))
    {
      Log.e("MicroMsg.AppUtil", "isAppValid, apk signatures is null");
      locala.e(paramg);
      AppMethodBeat.o(151767);
      return false;
    }
    if (!Util.isEqual(paramg.field_packageName, paramString))
    {
      Log.e("MicroMsg.AppUtil", "isAppValid, packageName is diff, src:%s,local:%s", new Object[] { paramg.field_packageName, paramString });
      locala.e(paramg);
      if (paramBoolean) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151760);
            Toast.makeText(u.this, u.this.getString(c.h.openapi_invalid_package), 1).show();
            AppMethodBeat.o(151760);
          }
        });
      }
      AppMethodBeat.o(151767);
      return false;
    }
    Log.i("MicroMsg.AppUtil", "server signatures:%s", new Object[] { paramg.field_signature });
    int j = arrayOfSignature.length;
    int i = 0;
    while (i < j)
    {
      paramString = v.bpX(com.tencent.mm.b.g.getMessageDigest(arrayOfSignature[i].toByteArray()));
      Log.i("MicroMsg.AppUtil", "local signatures:%s", new Object[] { paramString });
      if ((paramg.field_signature != null) && (paramg.field_signature.equals(paramString)))
      {
        locala.f(paramg);
        AppMethodBeat.o(151767);
        return true;
      }
      i += 1;
    }
    if (paramBoolean) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(162008);
          Toast.makeText(u.this, u.this.getString(c.h.openapi_invalid_signature), 1).show();
          AppMethodBeat.o(162008);
        }
      });
    }
    Log.w("MicroMsg.AppUtil", "isAppValid, signature is diff");
    locala.e(paramg);
    AppMethodBeat.o(151767);
    return false;
  }
  
  public static String ab(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151763);
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yMU, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = isMpUrl(paramString1);
      if ((i != 0) || (bool)) {
        break;
      }
      Log.i("MicroMsg.AppUtil", "buildRedirectUrl appendParams false");
      AppMethodBeat.o(151763);
      return paramString1;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      Log.e("MicroMsg.AppUtil", "buildRedirectUrl fail, invalid arguments");
      AppMethodBeat.o(151763);
      return null;
    }
    paramString1 = paramString1.trim();
    i = paramString1.indexOf("#");
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
      Log.v("MicroMsg.AppUtil", "buildRedirectUrl, sharpStr = %s, paramStr = %s, srcUrl = %s", new Object[] { str1, str3, str2 });
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      if (!Util.isNullOrNil(str3))
      {
        String[] arrayOfString = str3.split("&");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            String str4 = arrayOfString[i];
            if (!Util.isNullOrNil(str4))
            {
              int k = str4.indexOf("=");
              Log.v("MicroMsg.AppUtil", "buildRedirectUrl, equalIdx = %d", new Object[] { Integer.valueOf(k) });
              if (k < 0) {
                break label313;
              }
              paramString1 = str4.substring(0, k + 1);
              str3 = str4.substring(k + 1);
            }
            for (;;)
            {
              localLinkedHashMap.put(paramString1, str3);
              i += 1;
              break;
              label313:
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
      Log.v("MicroMsg.AppUtil", "buildRedirectUrl, pMap size = %d", new Object[] { Integer.valueOf(localLinkedHashMap.size()) });
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
      if (!Util.isNullOrNil(str1)) {
        paramString1 = paramString2 + str1;
      }
      Log.v("MicroMsg.AppUtil", "buildRedirectUrl, ret url = %s", new Object[] { paramString1 });
      AppMethodBeat.o(151763);
      return paramString1;
      str1 = "";
    }
  }
  
  public static String ad(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(151762);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2.length() == 0))
    {
      Log.e("MicroMsg.AppUtil", "buildUnistallUrl fail, invalid arguments");
      AppMethodBeat.o(151762);
      return null;
    }
    String str2 = LocaleUtil.loadApplicationLanguage(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    String str1;
    if ((str2 == null) || (str2.length() == 0)) {
      str1 = "zh_CN";
    }
    for (;;)
    {
      paramContext = paramContext.getString(c.h.openapi_uninstall_url, new Object[] { paramString1, Integer.valueOf(d.Yxh), str1, d.nsC, paramString2, Integer.valueOf(0) });
      AppMethodBeat.o(151762);
      return paramContext;
      str1 = str2;
      if (str2.equals("en")) {
        str1 = "en_US";
      }
    }
  }
  
  public static boolean b(Context paramContext, g paramg)
  {
    AppMethodBeat.i(151772);
    Log.i("MicroMsg.AppUtil", "check the signature of the Application.");
    if (paramContext == null)
    {
      Log.e("MicroMsg.AppUtil", "context is null.");
      AppMethodBeat.o(151772);
      return true;
    }
    if (paramg == null)
    {
      Log.e("MicroMsg.AppUtil", "appInfo is null.");
      AppMethodBeat.o(151772);
      return true;
    }
    if (Util.isNullOrNil(paramg.field_packageName))
    {
      Log.e("MicroMsg.AppUtil", "packageName is null.");
      AppMethodBeat.o(151772);
      return true;
    }
    if (Util.isNullOrNil(paramg.field_signature))
    {
      Log.e("MicroMsg.AppUtil", "app.field_signature is null. app.field_packageName is %s", new Object[] { paramg.field_packageName });
      AppMethodBeat.o(151772);
      return true;
    }
    paramContext = cG(paramContext, paramg.field_packageName);
    if ((paramContext == null) || (paramContext.length == 0))
    {
      Log.e("MicroMsg.AppUtil", "apk signatures is null");
      AppMethodBeat.o(151772);
      return false;
    }
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str = v.bpX(com.tencent.mm.b.g.getMessageDigest(paramContext[i].toByteArray()));
      if (paramg.field_signature.equals(str))
      {
        Log.i("MicroMsg.AppUtil", "app_name : %s ,signature : %s", new Object[] { paramg.field_appName, paramg.field_signature });
        AppMethodBeat.o(151772);
        return true;
      }
      i += 1;
    }
    Log.w("MicroMsg.AppUtil", "signature is diff.(app_name:%s)", new Object[] { paramg.field_appName });
    AppMethodBeat.o(151772);
    return false;
  }
  
  public static String bF(Activity paramActivity)
  {
    AppMethodBeat.i(151776);
    Object localObject1 = "";
    localObject2 = paramActivity.getCallingActivity();
    if (localObject2 != null)
    {
      localObject1 = ((ComponentName)localObject2).getPackageName();
      Log.i("MicroMsg.AppUtil", "get calling activity, %s", new Object[] { localObject1 });
    }
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1))
    {
      localObject2 = localObject1;
      if (Build.VERSION.SDK_INT >= 22) {
        localObject3 = localObject1;
      }
    }
    try
    {
      Object localObject4 = new com.tencent.mm.compatible.loader.b(paramActivity, "mReferrer", null).get();
      localObject2 = localObject1;
      if (localObject4 != null)
      {
        localObject3 = localObject1;
        localObject2 = (String)localObject4;
      }
      localObject3 = localObject2;
      Log.i("MicroMsg.AppUtil", "get referrer, %s", new Object[] { localObject2 });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppUtil", localException, "get mReferrer error", new Object[0]);
        localObject2 = localObject3;
      }
    }
    localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 22)
      {
        paramActivity = paramActivity.getReferrer();
        localObject1 = localObject2;
        if (paramActivity != null)
        {
          localObject1 = paramActivity.getAuthority();
          Log.i("MicroMsg.AppUtil", "get referrer, %s", new Object[] { localObject1 });
        }
      }
    }
    AppMethodBeat.o(151776);
    return localObject1;
  }
  
  public static void bS(Bundle paramBundle)
  {
    AppMethodBeat.i(151768);
    if (paramBundle != null) {
      paramBundle.putString("wx_token_key", "com.tencent.mm.openapi.token");
    }
    AppMethodBeat.o(151768);
  }
  
  public static void bT(Bundle paramBundle)
  {
    AppMethodBeat.i(151769);
    if (paramBundle != null) {
      paramBundle.putString("platformId", "wechat");
    }
    AppMethodBeat.o(151769);
  }
  
  public static void bpW(String paramString)
  {
    AppMethodBeat.i(151773);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppUtil", "appid is null");
      AppMethodBeat.o(151773);
      return;
    }
    SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
    if (localSharedPreferences != null)
    {
      String str = localSharedPreferences.getString("key_app_ids_registion_while_not_login", "");
      if (str.contains(paramString))
      {
        Log.i("MicroMsg.AppUtil", "this app has been saved : %s in %s", new Object[] { paramString, str });
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
  
  public static String cE(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151765);
    paramContext = cG(paramContext, paramString);
    if ((paramContext == null) || (paramContext.length == 0))
    {
      Log.e("MicroMsg.AppUtil", "signs is null");
      AppMethodBeat.o(151765);
      return null;
    }
    paramContext = v.bpX(com.tencent.mm.b.g.getMessageDigest(paramContext[0].toByteArray()));
    AppMethodBeat.o(151765);
    return paramContext;
  }
  
  public static String cF(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151766);
    paramContext = cG(paramContext, paramString);
    if ((paramContext == null) || (paramContext.length == 0))
    {
      Log.e("MicroMsg.AppUtil", "signs is null");
      AppMethodBeat.o(151766);
      return null;
    }
    paramContext = com.tencent.mm.b.g.getMessageDigest(paramContext[0].toByteArray());
    AppMethodBeat.o(151766);
    return paramContext;
  }
  
  public static Signature[] cG(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151771);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppUtil", "getSignature, packageName is null");
      AppMethodBeat.o(151771);
      return null;
    }
    if (paramContext == null)
    {
      Log.e("MicroMsg.AppUtil", "getSignature, context is null");
      AppMethodBeat.o(151771);
      return null;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString, 64);
      if (paramContext == null)
      {
        Log.e("MicroMsg.AppUtil", "info is null, packageName = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(151771);
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.e("MicroMsg.AppUtil", "NameNotFoundException");
      AppMethodBeat.o(151771);
      return null;
    }
    paramContext = paramContext.signatures;
    AppMethodBeat.o(151771);
    return paramContext;
  }
  
  public static String i(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(151761);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      Log.e("MicroMsg.AppUtil", "buildSourceUrl fail, invalid arguments");
      AppMethodBeat.o(151761);
      return null;
    }
    String str2 = LocaleUtil.loadApplicationLanguage(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    String str1;
    if ((str2 == null) || (str2.length() == 0)) {
      str1 = "zh_CN";
    }
    for (;;)
    {
      paramContext = paramContext.getString(c.h.openapi_source_url, new Object[] { paramString1, Integer.valueOf(d.Yxh), str1, d.nsC, paramString2 });
      AppMethodBeat.o(151761);
      return paramContext;
      str1 = str2;
      if (str2.equals("en")) {
        str1 = "en_US";
      }
    }
  }
  
  public static void iIC()
  {
    au.XTP = null;
    au.XTQ = -1L;
  }
  
  public static void iID()
  {
    AppMethodBeat.i(151774);
    SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString("key_app_ids_registion_while_not_login", "").commit();
    }
    AppMethodBeat.o(151774);
  }
  
  private static boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(244911);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(244911);
      return false;
    }
    if ((paramString.startsWith("https://" + WeChatHosts.domainString(c.h.host_mp_weixin_qq_com) + "/")) || (paramString.startsWith("http://" + WeChatHosts.domainString(c.h.host_mp_weixin_qq_com) + "/")))
    {
      AppMethodBeat.o(244911);
      return true;
    }
    AppMethodBeat.o(244911);
    return false;
  }
  
  public static void l(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(151770);
    paramBundle.putString("platformId", "wechat");
    if (!Util.isNullOrNil(paramString)) {
      paramBundle.putString("launchParam", paramString);
    }
    AppMethodBeat.o(151770);
  }
  
  public static void q(Activity paramActivity, final String paramString)
  {
    AppMethodBeat.i(151775);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(162009);
        if ((u.this == null) || (u.this.isFinishing()))
        {
          AppMethodBeat.o(162009);
          return;
        }
        Log.v("MicroMsg.AppUtil", "reportLaunchWechat");
        try
        {
          String str4 = u.bF(u.this);
          if (Util.isNullOrNil(str4))
          {
            bool = Util.isNullOrNil(paramString);
            if (bool)
            {
              AppMethodBeat.o(162009);
              return;
            }
          }
          String str3 = "";
          boolean bool = Util.isNullOrNil(paramString);
          String str1 = str3;
          if (!bool) {}
          try
          {
            str1 = URLEncoder.encode(paramString, "UTF-8");
            com.tencent.mm.plugin.report.service.h.OAn.b(17591, new Object[] { "", str4, str1, Integer.valueOf(0) });
            Log.i("MicroMsg.AppUtil", "reportLaunchWechat callPackage=%s, isCategoryHome = %b, url=%s, isCategoryHome= %b", new Object[] { str4, Boolean.FALSE, str1, Boolean.FALSE });
            AppMethodBeat.o(162009);
            return;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              Log.e("MicroMsg.AppUtil", "reportLaunchWechat parse fail");
              String str2 = str3;
            }
          }
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.AppUtil", "reportLaunchWechat ex:%s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(162009);
        }
      }
    }, "reportLaunchWechat");
    AppMethodBeat.o(151775);
  }
  
  public static boolean y(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151764);
    if (com.tencent.mm.plugin.appbrand.af.b.getPackageInfo(paramContext, paramString) != null)
    {
      AppMethodBeat.o(151764);
      return true;
    }
    AppMethodBeat.o(151764);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.u
 * JD-Core Version:    0.7.0.1
 */