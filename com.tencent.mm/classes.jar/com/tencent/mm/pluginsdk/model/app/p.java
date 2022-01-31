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
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class p
{
  public static String C(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(79336);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2.length() == 0))
    {
      ab.e("MicroMsg.AppUtil", "buildUnistallUrl fail, invalid arguments");
      AppMethodBeat.o(79336);
      return null;
    }
    String str2 = aa.f(paramContext.getSharedPreferences(ah.dsP(), 0));
    String str1;
    if ((str2 == null) || (str2.length() == 0)) {
      str1 = "zh_CN";
    }
    for (;;)
    {
      paramContext = paramContext.getString(2131302028, new Object[] { paramString1, Integer.valueOf(com.tencent.mm.protocal.d.whH), str1, com.tencent.mm.protocal.d.eQs, paramString2, Integer.valueOf(0) });
      AppMethodBeat.o(79336);
      return paramContext;
      str1 = str2;
      if (str2.equals("en")) {
        str1 = "en_US";
      }
    }
  }
  
  public static String H(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79337);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ab.e("MicroMsg.AppUtil", "buildRedirectUrl fail, invalid arguments");
      AppMethodBeat.o(79337);
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
      ab.v("MicroMsg.AppUtil", "buildRedirectUrl, sharpStr = %s, paramStr = %s, srcUrl = %s", new Object[] { str1, str3, str2 });
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      if (!bo.isNullOrNil(str3))
      {
        String[] arrayOfString = str3.split("&");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            String str4 = arrayOfString[i];
            if (!bo.isNullOrNil(str4))
            {
              int k = str4.indexOf("=");
              ab.v("MicroMsg.AppUtil", "buildRedirectUrl, equalIdx = %d", new Object[] { Integer.valueOf(k) });
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
      ab.v("MicroMsg.AppUtil", "buildRedirectUrl, pMap size = %d", new Object[] { Integer.valueOf(localLinkedHashMap.size()) });
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
      if (!bo.isNullOrNil(str1)) {
        paramString1 = paramString2 + str1;
      }
      ab.v("MicroMsg.AppUtil", "buildRedirectUrl, ret url = %s", new Object[] { paramString1 });
      AppMethodBeat.o(79337);
      return paramString1;
      str1 = "";
    }
  }
  
  public static boolean a(Context paramContext, f paramf, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(79342);
    a locala = a.a.caj();
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.AppUtil", "isAppValid, packageName is null");
      locala.e(paramf);
      AppMethodBeat.o(79342);
      return false;
    }
    if (paramf == null)
    {
      ab.i("MicroMsg.AppUtil", "app does not exist");
      AppMethodBeat.o(79342);
      return true;
    }
    if ((paramf.field_packageName == null) || (paramf.field_packageName.length() == 0))
    {
      ab.e("MicroMsg.AppUtil", "isAppValid fail, local packageName is null");
      locala.e(paramf);
      AppMethodBeat.o(79342);
      return false;
    }
    if ((paramf.field_signature == null) || (paramf.field_signature.length() == 0))
    {
      ab.e("MicroMsg.AppUtil", "isAppValid fail, local signature is null");
      locala.e(paramf);
      AppMethodBeat.o(79342);
      return false;
    }
    Signature[] arrayOfSignature = bv(paramContext, paramString);
    if ((arrayOfSignature == null) || (arrayOfSignature.length == 0))
    {
      ab.e("MicroMsg.AppUtil", "isAppValid, apk signatures is null");
      locala.e(paramf);
      AppMethodBeat.o(79342);
      return false;
    }
    if (!bo.isEqual(paramf.field_packageName, paramString))
    {
      ab.e("MicroMsg.AppUtil", "isAppValid, packageName is diff, src:%s,local:%s", new Object[] { paramf.field_packageName, paramString });
      locala.e(paramf);
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131302025), 1).show();
      }
      AppMethodBeat.o(79342);
      return false;
    }
    ab.i("MicroMsg.AppUtil", "server signatures:%s", new Object[] { paramf.field_signature });
    int j = arrayOfSignature.length;
    int i = 0;
    while (i < j)
    {
      paramString = q.aly(g.w(arrayOfSignature[i].toByteArray()));
      ab.i("MicroMsg.AppUtil", "local signatures:%s", new Object[] { paramString });
      if ((paramf.field_signature != null) && (paramf.field_signature.equals(paramString)))
      {
        locala.f(paramf);
        AppMethodBeat.o(79342);
        return true;
      }
      i += 1;
    }
    if (paramBoolean) {
      Toast.makeText(paramContext, paramContext.getString(2131302026), 1).show();
    }
    ab.w("MicroMsg.AppUtil", "isAppValid, signature is diff");
    locala.e(paramf);
    AppMethodBeat.o(79342);
    return false;
  }
  
  public static void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(79343);
    if (paramBundle != null) {
      paramBundle.putString("wx_token_key", "com.tencent.mm.openapi.token");
    }
    AppMethodBeat.o(79343);
  }
  
  public static void aD(Bundle paramBundle)
  {
    AppMethodBeat.i(79344);
    if (paramBundle != null) {
      paramBundle.putString("platformId", "wechat");
    }
    AppMethodBeat.o(79344);
  }
  
  public static void alx(String paramString)
  {
    AppMethodBeat.i(79348);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.AppUtil", "appid is null");
      AppMethodBeat.o(79348);
      return;
    }
    SharedPreferences localSharedPreferences = ah.dsQ();
    if (localSharedPreferences != null)
    {
      String str = localSharedPreferences.getString("key_app_ids_registion_while_not_login", "");
      if (str.contains(paramString))
      {
        ab.i("MicroMsg.AppUtil", "this app has been saved : %s in %s", new Object[] { paramString, str });
        AppMethodBeat.o(79348);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("|");
      localStringBuilder.append(str);
      paramString = localStringBuilder.toString();
      localSharedPreferences.edit().putString("key_app_ids_registion_while_not_login", paramString).commit();
    }
    AppMethodBeat.o(79348);
  }
  
  public static String ap(Activity paramActivity)
  {
    AppMethodBeat.i(151618);
    Object localObject1 = "";
    localObject2 = paramActivity.getCallingActivity();
    if (localObject2 != null)
    {
      localObject1 = ((ComponentName)localObject2).getPackageName();
      ab.i("MicroMsg.AppUtil", "get calling activity, %s", new Object[] { localObject1 });
    }
    localObject2 = localObject1;
    if (bo.isNullOrNil((String)localObject1))
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
      ab.i("MicroMsg.AppUtil", "get referrer, %s", new Object[] { localObject2 });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppUtil", localException, "get mReferrer error", new Object[0]);
        localObject2 = localObject3;
      }
    }
    localObject1 = localObject2;
    if (bo.isNullOrNil((String)localObject2))
    {
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 22)
      {
        paramActivity = paramActivity.getReferrer();
        localObject1 = localObject2;
        if (paramActivity != null)
        {
          localObject1 = paramActivity.getAuthority();
          ab.i("MicroMsg.AppUtil", "get referrer, %s", new Object[] { localObject1 });
        }
      }
    }
    AppMethodBeat.o(151618);
    return localObject1;
  }
  
  public static boolean b(Context paramContext, f paramf)
  {
    AppMethodBeat.i(79347);
    ab.i("MicroMsg.AppUtil", "check the signature of the Application.");
    if (paramContext == null)
    {
      ab.e("MicroMsg.AppUtil", "context is null.");
      AppMethodBeat.o(79347);
      return true;
    }
    if (paramf == null)
    {
      ab.e("MicroMsg.AppUtil", "appInfo is null.");
      AppMethodBeat.o(79347);
      return true;
    }
    if (bo.isNullOrNil(paramf.field_packageName))
    {
      ab.e("MicroMsg.AppUtil", "packageName is null.");
      AppMethodBeat.o(79347);
      return true;
    }
    if (bo.isNullOrNil(paramf.field_signature))
    {
      ab.e("MicroMsg.AppUtil", "app.field_signature is null. app.field_packageName is %s", new Object[] { paramf.field_packageName });
      AppMethodBeat.o(79347);
      return true;
    }
    paramContext = bv(paramContext, paramf.field_packageName);
    if ((paramContext == null) || (paramContext.length == 0))
    {
      ab.e("MicroMsg.AppUtil", "apk signatures is null");
      AppMethodBeat.o(79347);
      return false;
    }
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str = q.aly(g.w(paramContext[i].toByteArray()));
      if (paramf.field_signature.equals(str))
      {
        ab.i("MicroMsg.AppUtil", "app_name : %s ,signature : %s", new Object[] { paramf.field_appName, paramf.field_signature });
        AppMethodBeat.o(79347);
        return true;
      }
      i += 1;
    }
    ab.w("MicroMsg.AppUtil", "signature is diff.(app_name:%s)", new Object[] { paramf.field_appName });
    AppMethodBeat.o(79347);
    return false;
  }
  
  public static String bu(Context paramContext, String paramString)
  {
    AppMethodBeat.i(79339);
    paramContext = bv(paramContext, paramString);
    if ((paramContext == null) || (paramContext.length == 0))
    {
      ab.e("MicroMsg.AppUtil", "signs is null");
      AppMethodBeat.o(79339);
      return null;
    }
    paramContext = q.aly(g.w(paramContext[0].toByteArray()));
    AppMethodBeat.o(79339);
    return paramContext;
  }
  
  public static Signature[] bv(Context paramContext, String paramString)
  {
    AppMethodBeat.i(79346);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.AppUtil", "getSignature, packageName is null");
      AppMethodBeat.o(79346);
      return null;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString, 64);
      if (paramContext == null)
      {
        ab.e("MicroMsg.AppUtil", "info is null, packageName = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(79346);
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ab.e("MicroMsg.AppUtil", "NameNotFoundException");
      AppMethodBeat.o(79346);
      return null;
    }
    paramContext = paramContext.signatures;
    AppMethodBeat.o(79346);
    return paramContext;
  }
  
  public static void dlF()
  {
    an.vMo = null;
    an.vMp = -1L;
  }
  
  public static void dlG()
  {
    AppMethodBeat.i(79349);
    SharedPreferences localSharedPreferences = ah.dsQ();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString("key_app_ids_registion_while_not_login", "").commit();
    }
    AppMethodBeat.o(79349);
  }
  
  public static String f(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(79335);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      ab.e("MicroMsg.AppUtil", "buildSourceUrl fail, invalid arguments");
      AppMethodBeat.o(79335);
      return null;
    }
    String str2 = aa.f(paramContext.getSharedPreferences(ah.dsP(), 0));
    String str1;
    if ((str2 == null) || (str2.length() == 0)) {
      str1 = "zh_CN";
    }
    for (;;)
    {
      paramContext = paramContext.getString(2131302027, new Object[] { paramString1, Integer.valueOf(com.tencent.mm.protocal.d.whH), str1, com.tencent.mm.protocal.d.eQs, paramString2 });
      AppMethodBeat.o(79335);
      return paramContext;
      str1 = str2;
      if (str2.equals("en")) {
        str1 = "en_US";
      }
    }
  }
  
  public static void i(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(151617);
    com.tencent.mm.sdk.g.d.ysm.b(new p.1(paramActivity, paramString), "reportLaunchWechat");
    AppMethodBeat.o(151617);
  }
  
  public static void j(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(79345);
    paramBundle.putString("platformId", "wechat");
    if (!bo.isNullOrNil(paramString)) {
      paramBundle.putString("launchParam", paramString);
    }
    AppMethodBeat.o(79345);
  }
  
  public static boolean u(Context paramContext, String paramString)
  {
    AppMethodBeat.i(79338);
    if (b.getPackageInfo(paramContext, paramString) != null)
    {
      AppMethodBeat.o(79338);
      return true;
    }
    AppMethodBeat.o(79338);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.p
 * JD-Core Version:    0.7.0.1
 */