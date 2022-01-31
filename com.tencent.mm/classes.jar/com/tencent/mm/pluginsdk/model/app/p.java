package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.plugin.z.a.a;
import com.tencent.mm.plugin.z.a.a.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class p
{
  public static String VY(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
      return null;
    }
    return VZ(paramString);
  }
  
  public static String VZ(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString.toLowerCase());
    localStringBuffer.append("mMHc ItnStR");
    return g.o(localStringBuffer.toString().getBytes());
  }
  
  public static void Wa(String paramString)
  {
    if (bk.bl(paramString)) {
      y.e("MicroMsg.AppUtil", "appid is null");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = ae.cqS();
    } while (localSharedPreferences == null);
    String str = localSharedPreferences.getString("key_app_ids_registion_while_not_login", "");
    if (str.contains(paramString))
    {
      y.i("MicroMsg.AppUtil", "this app has been saved : %s in %s", new Object[] { paramString, str });
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("|");
    localStringBuilder.append(str);
    paramString = localStringBuilder.toString();
    localSharedPreferences.edit().putString("key_app_ids_registion_while_not_login", paramString).commit();
  }
  
  public static void ak(Bundle paramBundle)
  {
    paramBundle.putString("wx_token_key", "com.tencent.mm.openapi.token");
  }
  
  public static void al(Bundle paramBundle)
  {
    paramBundle.putString("platformId", "wechat");
  }
  
  public static boolean b(Context paramContext, f paramf)
  {
    y.i("MicroMsg.AppUtil", "check the signature of the Application.");
    if (paramContext == null)
    {
      y.e("MicroMsg.AppUtil", "context is null.");
      return true;
    }
    if (paramf == null)
    {
      y.e("MicroMsg.AppUtil", "appInfo is null.");
      return true;
    }
    if (bk.bl(paramf.field_packageName))
    {
      y.e("MicroMsg.AppUtil", "packageName is null.");
      return true;
    }
    if (bk.bl(paramf.field_signature))
    {
      y.e("MicroMsg.AppUtil", "app.field_signature is null. app.field_packageName is %s", new Object[] { paramf.field_packageName });
      return true;
    }
    paramContext = bj(paramContext, paramf.field_packageName);
    if ((paramContext == null) || (paramContext.length == 0))
    {
      y.e("MicroMsg.AppUtil", "apk signatures is null");
      return false;
    }
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str = VZ(g.o(paramContext[i].toByteArray()));
      if (paramf.field_signature.equals(str))
      {
        y.i("MicroMsg.AppUtil", "app_name : %s ,signature : %s", new Object[] { paramf.field_appName, paramf.field_signature });
        return true;
      }
      i += 1;
    }
    y.w("MicroMsg.AppUtil", "signature is diff.(app_name:%s)", new Object[] { paramf.field_appName });
    return false;
  }
  
  public static String bi(Context paramContext, String paramString)
  {
    paramContext = bj(paramContext, paramString);
    if ((paramContext == null) || (paramContext.length == 0))
    {
      y.e("MicroMsg.AppUtil", "signs is null");
      return null;
    }
    return VZ(g.o(paramContext[0].toByteArray()));
  }
  
  public static Signature[] bj(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.AppUtil", "getSignature, packageName is null");
      return null;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString, 64);
      if (paramContext == null)
      {
        y.e("MicroMsg.AppUtil", "info is null, packageName = " + paramString);
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      y.e("MicroMsg.AppUtil", "NameNotFoundException");
      return null;
    }
    return paramContext.signatures;
  }
  
  public static boolean c(Context paramContext, f paramf, String paramString)
  {
    a locala = a.a.bru();
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.AppUtil", "isAppValid, packageName is null");
      locala.c(paramf);
      return false;
    }
    if (paramf == null)
    {
      y.i("MicroMsg.AppUtil", "app does not exist");
      return true;
    }
    if ((paramf.field_packageName == null) || (paramf.field_packageName.length() == 0))
    {
      y.e("MicroMsg.AppUtil", "isAppValid fail, local packageName is null");
      locala.c(paramf);
      return false;
    }
    if ((paramf.field_signature == null) || (paramf.field_signature.length() == 0))
    {
      y.e("MicroMsg.AppUtil", "isAppValid fail, local signature is null");
      locala.c(paramf);
      return false;
    }
    paramContext = bj(paramContext, paramString);
    if ((paramContext == null) || (paramContext.length == 0))
    {
      y.e("MicroMsg.AppUtil", "isAppValid, apk signatures is null");
      locala.c(paramf);
      return false;
    }
    if (!paramf.field_packageName.equals(paramString))
    {
      y.e("MicroMsg.AppUtil", "isAppValid, packageName is diff, src:%s,local:%s", new Object[] { paramf.field_packageName, paramString });
      locala.c(paramf);
      return false;
    }
    y.i("MicroMsg.AppUtil", "server signatures:%s", new Object[] { paramf.field_signature });
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      paramString = VZ(g.o(paramContext[i].toByteArray()));
      y.i("MicroMsg.AppUtil", "local signatures:%s", new Object[] { paramString });
      if ((paramf.field_signature != null) && (paramf.field_signature.equals(paramString)))
      {
        locala.d(paramf);
        return true;
      }
      i += 1;
    }
    y.w("MicroMsg.AppUtil", "isAppValid, signature is diff");
    locala.c(paramf);
    return false;
  }
  
  public static void ckW()
  {
    ar.rVA = null;
    ar.rVB = -1L;
  }
  
  public static String f(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      y.e("MicroMsg.AppUtil", "buildSourceUrl fail, invalid arguments");
      return null;
    }
    String str2 = x.d(paramContext.getSharedPreferences(ae.cqR(), 0));
    String str1;
    if ((str2 == null) || (str2.length() == 0)) {
      str1 = "zh_CN";
    }
    for (;;)
    {
      return paramContext.getString(a.h.openapi_source_url, new Object[] { paramString1, Integer.valueOf(d.spa), str1, d.dOM, paramString2 });
      str1 = str2;
      if (str2.equals("en")) {
        str1 = "en_US";
      }
    }
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.AppUtil", "getPackageInfo, packageName is null");
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      y.w("MicroMsg.AppUtil", "app not installed, packageName = " + paramString);
    }
    return null;
  }
  
  public static void i(Bundle paramBundle, String paramString)
  {
    paramBundle.putString("platformId", "wechat");
    if (!bk.bl(paramString)) {
      paramBundle.putString("launchParam", paramString);
    }
  }
  
  public static boolean o(Context paramContext, String paramString)
  {
    return getPackageInfo(paramContext, paramString) != null;
  }
  
  public static String u(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      y.e("MicroMsg.AppUtil", "buildRedirectUrl fail, invalid arguments");
      return null;
    }
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
      y.v("MicroMsg.AppUtil", "buildRedirectUrl, sharpStr = %s, paramStr = %s, srcUrl = %s", new Object[] { str1, str3, str2 });
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      if (!bk.bl(str3))
      {
        String[] arrayOfString = str3.split("&");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            String str4 = arrayOfString[i];
            if (!bk.bl(str4))
            {
              int k = str4.indexOf("=");
              y.v("MicroMsg.AppUtil", "buildRedirectUrl, equalIdx = %d", new Object[] { Integer.valueOf(k) });
              if (k < 0) {
                break label248;
              }
              paramString1 = str4.substring(0, k + 1);
              str3 = str4.substring(k + 1);
            }
            for (;;)
            {
              localLinkedHashMap.put(paramString1, str3);
              i += 1;
              break;
              label248:
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
      y.v("MicroMsg.AppUtil", "buildRedirectUrl, pMap size = %d", new Object[] { Integer.valueOf(localLinkedHashMap.size()) });
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
      if (!bk.bl(str1)) {
        paramString1 = paramString2 + str1;
      }
      y.v("MicroMsg.AppUtil", "buildRedirectUrl, ret url = %s", new Object[] { paramString1 });
      return paramString1;
      str1 = "";
    }
  }
  
  public static String v(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2.length() == 0))
    {
      y.e("MicroMsg.AppUtil", "buildUnistallUrl fail, invalid arguments");
      return null;
    }
    String str2 = x.d(paramContext.getSharedPreferences(ae.cqR(), 0));
    String str1;
    if ((str2 == null) || (str2.length() == 0)) {
      str1 = "zh_CN";
    }
    for (;;)
    {
      return paramContext.getString(a.h.openapi_uninstall_url, new Object[] { paramString1, Integer.valueOf(d.spa), str1, d.dOM, paramString2, Integer.valueOf(0) });
      str1 = str2;
      if (str2.equals("en")) {
        str1 = "en_US";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.p
 * JD-Core Version:    0.7.0.1
 */