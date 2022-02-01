package com.tencent.tbs.one.impl.e.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.d.a.a;
import com.tencent.tbs.one.impl.e.e.a;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.tbs.one.impl.a.a<com.tencent.tbs.one.impl.e.e<com.tencent.tbs.one.impl.common.d>>
  implements a.a
{
  int b;
  private Context c;
  private String d;
  private String e;
  private String[] f;
  private int g;
  private File h;
  private com.tencent.tbs.one.impl.d.a i;
  private Bundle j;
  
  public b(Context paramContext, String paramString1, String paramString2, String[] paramArrayOfString, int paramInt, File paramFile, Bundle paramBundle)
  {
    this.c = paramContext;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramArrayOfString;
    this.g = paramInt;
    this.h = paramFile;
    this.j = paramBundle;
  }
  
  private static int a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(174046);
    int k = paramContext.getSharedPreferences(String.format("com.tencent.tbs.one.%s.prefs", new Object[] { paramString }), 4).getInt("in_use_deps_version", -1);
    AppMethodBeat.o(174046);
    return k;
  }
  
  private JSONObject c()
  {
    AppMethodBeat.i(174044);
    try
    {
      JSONObject localJSONObject1 = com.tencent.tbs.one.impl.a.e.a(com.tencent.tbs.b.a.ahzM);
      AppMethodBeat.o(174044);
      return localJSONObject1;
    }
    finally
    {
      com.tencent.tbs.one.impl.a.f.c("[%s] Failed to get component sdk versions", new Object[] { this.d, localObject });
      JSONObject localJSONObject2 = new JSONObject();
      AppMethodBeat.o(174044);
      return localJSONObject2;
    }
  }
  
  private JSONObject d()
  {
    int k = 0;
    AppMethodBeat.i(174045);
    File[] arrayOfFile = com.tencent.tbs.one.impl.common.f.d(com.tencent.tbs.one.impl.common.f.a(this.c.getDir("tbs", 0), this.d)).listFiles();
    JSONObject localJSONObject = new JSONObject();
    if (arrayOfFile != null)
    {
      int m = arrayOfFile.length;
      while (k < m)
      {
        File localFile = arrayOfFile[k];
        com.tencent.tbs.one.impl.a.e.a(localJSONObject, localFile.getName(), Integer.valueOf(com.tencent.tbs.one.impl.e.f.c(localFile)));
        k += 1;
      }
    }
    AppMethodBeat.o(174045);
    return localJSONObject;
  }
  
  private JSONArray e()
  {
    AppMethodBeat.i(174047);
    JSONArray localJSONArray = new JSONArray();
    Context localContext = this.c;
    String str1 = this.d;
    String[] arrayOfString = this.f;
    if (arrayOfString != null)
    {
      int m = arrayOfString.length;
      int k = 0;
      while (k < m)
      {
        String str2 = arrayOfString[k];
        if (!str2.equals(localContext.getPackageName())) {}
        try
        {
          int n = a(localContext.createPackageContext(str2, 2), str1);
          if (n != -1) {
            localJSONArray.put(n);
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          label93:
          break label93;
        }
        k += 1;
      }
    }
    else
    {
      AppMethodBeat.o(174047);
      return localJSONArray;
    }
  }
  
  public final void a()
  {
    AppMethodBeat.i(174040);
    Context localContext = this.c;
    final String str1 = this.d;
    String str2 = this.e;
    Object localObject1 = this.h;
    Object localObject2 = com.tencent.tbs.one.impl.common.a.b(localContext, str1);
    if (localObject2 != null)
    {
      int k = ((TBSOneRuntimeExtension)localObject2).shouldOverrideInstallationJob(str1, "DEPS", -1, null, (File)localObject1, new TBSOneCallback()
      {
        public final void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(174038);
          b.this.b = 0;
          b.this.a(paramAnonymousInt, paramAnonymousString, null);
          AppMethodBeat.o(174038);
        }
        
        public final void onProgressChanged(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(174037);
          b.this.a(paramAnonymousInt2);
          AppMethodBeat.o(174037);
        }
      });
      if (k != 0)
      {
        com.tencent.tbs.one.impl.a.f.a("[%s] Intercepted DEPS installation job by runtime extension", new Object[] { str1 });
        this.b = k;
        AppMethodBeat.o(174040);
        return;
      }
    }
    boolean bool;
    if (this.j != null) {
      bool = this.j.getBoolean("is_ignore_frequency_limitation", false);
    }
    while (!bool)
    {
      long l = com.tencent.tbs.one.impl.e.f.h((File)localObject1);
      if (System.currentTimeMillis() - l < 86400000L)
      {
        super.a(209, "Too many DEPS requests, last request time: " + com.tencent.tbs.one.impl.a.d.a(l), null);
        AppMethodBeat.o(174040);
        return;
        bool = false;
      }
      else
      {
        com.tencent.tbs.one.impl.e.f.i((File)localObject1);
      }
    }
    h.a("TBSOneAction", 1001, null);
    JSONObject localJSONObject = new JSONObject();
    com.tencent.tbs.one.impl.a.e.a(localJSONObject, "ONEV", Integer.valueOf(1));
    com.tencent.tbs.one.impl.a.e.a(localJSONObject, "DEPSV", Integer.valueOf(a(localContext, str1)));
    com.tencent.tbs.one.impl.a.e.a(localJSONObject, "HSTV", e());
    com.tencent.tbs.one.impl.a.e.a(localJSONObject, "SDKV", c());
    com.tencent.tbs.one.impl.a.e.a(localJSONObject, "LOCV", d());
    if (this.g != -1) {
      com.tencent.tbs.one.impl.a.e.a(localJSONObject, "REQV", Integer.valueOf(this.g));
    }
    com.tencent.tbs.one.impl.a.e.a(localJSONObject, "PROTV", Integer.valueOf(1));
    com.tencent.tbs.one.impl.a.e.a(localJSONObject, "FUNC", Integer.valueOf(0));
    String str3 = localContext.getPackageName();
    com.tencent.tbs.one.impl.a.e.a(localJSONObject, "PN", str3);
    localObject2 = localContext.getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject2).getPackageInfo(str3, 0);
      com.tencent.tbs.one.impl.a.e.a(localJSONObject, "PPVN", ((PackageInfo)localObject1).versionName);
      com.tencent.tbs.one.impl.a.e.a(localJSONObject, "PPVC", Integer.valueOf(((PackageInfo)localObject1).versionCode));
      localObject1 = null;
    }
    catch (PackageManager.NameNotFoundException localException1)
    {
      try
      {
        localObject2 = ((PackageManager)localObject2).getApplicationInfo(str3, 128);
        localObject1 = localObject2;
        if (localObject1 != null)
        {
          com.tencent.tbs.one.impl.a.e.a(localJSONObject, "TAPI", Integer.valueOf(((ApplicationInfo)localObject1).targetSdkVersion));
          if (((ApplicationInfo)localObject1).metaData != null)
          {
            localObject1 = ((ApplicationInfo)localObject1).metaData.get("com.tencent.mm.BuildInfo.CLIENT_VERSION");
            if (localObject1 == null) {}
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            com.tencent.tbs.one.impl.a.e.a(localJSONObject, "META", Integer.toHexString(Integer.parseInt(String.valueOf(localObject1))));
            com.tencent.tbs.one.impl.a.e.a(localJSONObject, "BVR", Build.VERSION.RELEASE);
            com.tencent.tbs.one.impl.a.e.a(localJSONObject, "ABI", Build.CPU_ABI);
            if ((TextUtils.isEmpty(com.tencent.tbs.one.impl.a.d.a)) && (localContext.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0))
            {
              localObject1 = (TelephonyManager)localContext.getSystemService("phone");
              com.tencent.tbs.one.impl.a.d.a = (String)com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/tbs/one/impl/e/a/b", "a", "()V", "android/telephony/TelephonyManager", "getDeviceId", "()Ljava/lang/String;");
              com.tencent.tbs.one.impl.a.d.b = (String)com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/tbs/one/impl/e/a/b", "a", "()V", "android/telephony/TelephonyManager", "getSubscriberId", "()Ljava/lang/String;");
            }
            com.tencent.tbs.one.impl.a.e.a(localJSONObject, "IMEI", com.tencent.tbs.one.impl.a.d.a);
            com.tencent.tbs.one.impl.a.e.a(localJSONObject, "GUID", "");
            if (TextUtils.isEmpty(com.tencent.tbs.one.impl.a.d.c))
            {
              localObject1 = localContext.getContentResolver();
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG("android_id").cG(localObject1);
              com.tencent.tbs.one.impl.a.d.c = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/tbs/one/impl/e/a/b", "a", "()V", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
            }
            com.tencent.tbs.one.impl.a.e.a(localJSONObject, "ADRID", com.tencent.tbs.one.impl.a.d.c);
            com.tencent.tbs.one.impl.a.e.a(localJSONObject, "UA", com.tencent.tbs.one.impl.a.d.a());
            com.tencent.tbs.one.impl.a.f.a("[%s] Requesting DEPS from %s, post data: %s", new Object[] { str1, str2, localJSONObject });
            this.i = new com.tencent.tbs.one.impl.d.a(localContext, str2, "POST", null, localJSONObject.toString().getBytes(com.tencent.tbs.one.impl.common.b.a));
            this.i.f = this;
            this.i.a(new l()
            {
              public final void a(int paramAnonymousInt1, int paramAnonymousInt2)
              {
                AppMethodBeat.i(174054);
                b.this.a(paramAnonymousInt2);
                AppMethodBeat.o(174054);
              }
              
              public final void a(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
              {
                AppMethodBeat.i(174055);
                b.this.a(paramAnonymousInt, paramAnonymousString, paramAnonymousThrowable);
                h.a("TBSOneAction", 1002, null);
                AppMethodBeat.o(174055);
              }
            });
            AppMethodBeat.o(174040);
            return;
            localNameNotFoundException = localNameNotFoundException;
            com.tencent.tbs.one.impl.a.f.c("Failed to get package info for %s", new Object[] { str3, localNameNotFoundException });
          }
          localException1 = localException1;
          com.tencent.tbs.one.impl.a.f.c("Failed to get application info for %s", new Object[] { str3, localException1 });
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            com.tencent.tbs.one.impl.a.f.c("Failed to parse meta data %s", new Object[] { localNameNotFoundException, localException2 });
          }
        }
      }
    }
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(174042);
    com.tencent.tbs.one.impl.e.f.a(this.h, System.currentTimeMillis());
    super.a(paramInt, paramString, paramThrowable);
    AppMethodBeat.o(174042);
  }
  
  public final void a(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream)
  {
    AppMethodBeat.i(174043);
    Context localContext = this.c;
    final String str = this.d;
    Object localObject = this.e;
    final File localFile = this.h;
    com.tencent.tbs.one.impl.a.f.a("[%s] Receiving DEPS response: [%d] %s", new Object[] { str, Integer.valueOf(paramInt), paramMap });
    if ((paramInt != 200) || (paramInputStream == null))
    {
      a(210, "Invalid DEPS response stream, url: " + (String)localObject + ", statusCode: " + paramInt, null);
      AppMethodBeat.o(174043);
      return;
    }
    paramMap = com.tencent.tbs.one.impl.common.a.b(localContext, str);
    if (paramMap != null)
    {
      paramInt = paramMap.shouldInterceptDEPSResponse(str, null, paramInputStream, localFile, new TBSOneCallback()
      {
        public final void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(174033);
          b.this.b = 0;
          b.this.a(paramAnonymousInt, paramAnonymousString, null);
          AppMethodBeat.o(174033);
        }
        
        public final void onProgressChanged(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(174032);
          b.this.a(com.tencent.tbs.one.impl.e.f.a(paramAnonymousInt2, 50, 100));
          AppMethodBeat.o(174032);
        }
      });
      if (paramInt != 0)
      {
        com.tencent.tbs.one.impl.a.f.a("[%s] Intercepted DEPS response stream by runtime extension", new Object[] { str });
        this.b = paramInt;
        AppMethodBeat.o(174043);
        return;
      }
    }
    try
    {
      paramInputStream = c.a(paramInputStream, "utf-8");
      paramInputStream = paramMap.optString("DEPS");
    }
    catch (IOException paramMap)
    {
      try
      {
        paramMap = new JSONObject(paramInputStream);
        com.tencent.tbs.one.impl.a.f.a("[%s] Receiving DEPS data %s", new Object[] { str, paramMap });
        paramInt = paramMap.optInt("CODE", -1);
        if (paramInt == 0) {
          break label357;
        }
        paramMap = paramMap.optString("MSG");
        a(213, "Failed to request DEPS, url: " + (String)localObject + ", response code: " + paramInt + ", message: " + paramMap, null);
        AppMethodBeat.o(174043);
        return;
      }
      catch (JSONException paramMap)
      {
        a(212, "Failed to parse DEPS response " + paramInputStream + ", url: " + (String)localObject, paramMap);
        AppMethodBeat.o(174043);
        return;
      }
      paramMap = paramMap;
      a(211, "Failed to read DEPS response, url:".concat(String.valueOf(localObject)), paramMap);
      AppMethodBeat.o(174043);
      return;
    }
    try
    {
      label357:
      localObject = com.tencent.tbs.one.impl.common.d.a(paramInputStream);
      c.a(paramInputStream, "utf-8", localFile);
      paramInputStream = com.tencent.tbs.one.impl.e.e.a(e.a.e, localObject);
      paramInputStream.c = paramMap;
      a(paramInputStream);
      AppMethodBeat.o(174043);
      return;
    }
    catch (TBSOneException paramMap)
    {
      a(paramMap.getErrorCode(), paramMap.getMessage(), paramMap.getCause());
      AppMethodBeat.o(174043);
      return;
    }
    catch (IOException paramMap)
    {
      a(305, "Failed to save online DEPS to " + localFile.getAbsolutePath(), paramMap);
      AppMethodBeat.o(174043);
    }
  }
  
  public final void b()
  {
    AppMethodBeat.i(174041);
    super.b();
    if (this.i != null) {
      this.i.b();
    }
    if (this.b != 0)
    {
      TBSOneRuntimeExtension localTBSOneRuntimeExtension = com.tencent.tbs.one.impl.common.a.b(this.c, this.d);
      if (localTBSOneRuntimeExtension != null) {
        localTBSOneRuntimeExtension.cancel(this.b);
      }
    }
    AppMethodBeat.o(174041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.a.b
 * JD-Core Version:    0.7.0.1
 */