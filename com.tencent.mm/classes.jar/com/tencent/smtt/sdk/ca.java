package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.IconListener;
import com.tencent.smtt.utils.TbsLog;
import dalvik.system.DexClassLoader;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

class ca
{
  private DexLoader a;
  
  public ca(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public int a(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(139516);
    if (TbsDownloader.getOverSea(paramContext))
    {
      AppMethodBeat.o(139516);
      return -103;
    }
    if (paramString2 == null)
    {
      paramValueCallback = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, Map.class, ValueCallback.class }, new Object[] { paramContext, paramString1, paramMap, paramValueCallback });
      paramString2 = paramValueCallback;
      if (paramValueCallback == null) {
        paramString2 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, Map.class }, new Object[] { paramContext, paramString1, paramMap });
      }
      paramMap = paramString2;
      if (paramString2 == null) {
        paramMap = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
      }
      if (paramMap == null)
      {
        AppMethodBeat.o(139516);
        return -104;
      }
      i = ((Integer)paramMap).intValue();
      AppMethodBeat.o(139516);
      return i;
    }
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 });
    if (paramContext == null)
    {
      AppMethodBeat.o(139516);
      return -104;
    }
    int i = ((Integer)paramContext).intValue();
    AppMethodBeat.o(139516);
    return i;
  }
  
  public IX5WebViewBase a(Context paramContext)
  {
    AppMethodBeat.i(139460);
    localObject3 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[] { Context.class }, new Object[] { paramContext });
    if (localObject3 == null) {}
    for (;;)
    {
      try
      {
        localObject1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
        if ((localObject1 != null) && ((localObject1 instanceof Throwable))) {
          TbsCoreLoadStat.getInstance().a(paramContext, 325, (Throwable)localObject1);
        }
        if ((localObject1 != null) && ((localObject1 instanceof String))) {
          TbsCoreLoadStat.getInstance().a(paramContext, 325, new Throwable((String)localObject1));
        }
        localObject1 = null;
        localObject2 = null;
      }
      catch (Exception paramContext)
      {
        IX5WebViewBase localIX5WebViewBase;
        Object localObject1 = null;
        Object localObject2 = localObject3;
        continue;
        continue;
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(139460);
        return null;
        localIX5WebViewBase = (IX5WebViewBase)localObject3;
        localObject1 = localIX5WebViewBase;
        localObject2 = localObject3;
        if (localIX5WebViewBase == null) {
          continue;
        }
        localObject1 = localIX5WebViewBase;
        localObject2 = localObject3;
      }
      try
      {
        if (localIX5WebViewBase.getView() == null)
        {
          TbsCoreLoadStat.getInstance().a(paramContext, 325, new Throwable("x5webview.getView is null!"));
          localObject2 = null;
          localObject1 = localIX5WebViewBase;
        }
      }
      catch (Exception paramContext)
      {
        localObject1 = localIX5WebViewBase;
        localObject2 = localObject3;
      }
    }
    AppMethodBeat.o(139460);
    return localObject1;
  }
  
  public InputStream a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(139463);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[] { String.class, Boolean.TYPE }, new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramString == null)
    {
      AppMethodBeat.o(139463);
      return null;
    }
    paramString = (InputStream)paramString;
    AppMethodBeat.o(139463);
    return paramString;
  }
  
  public String a(String paramString)
  {
    AppMethodBeat.i(139461);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139461);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(139461);
    return paramString;
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(139500);
    paramString1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(139500);
      return null;
    }
    paramString1 = (String)paramString1;
    AppMethodBeat.o(139500);
    return paramString1;
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(139515);
    TbsLog.w("desktop", " tbsWizard clearAllX5Cache");
    if (paramBoolean)
    {
      this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[] { Context.class }, new Object[] { paramContext });
      AppMethodBeat.o(139515);
      return;
    }
    try
    {
      this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[] { Context.class, Boolean.TYPE }, new Object[] { paramContext, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(139515);
      return;
    }
    catch (Exception localException)
    {
      this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
      this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
      this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[] { Context.class }, new Object[] { paramContext });
      this.a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
      this.a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
      paramContext = this.a.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
      if (paramContext != null) {
        this.a.invokeMethod(paramContext, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
      }
      paramContext = this.a.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
      if (paramContext != null) {
        this.a.invokeMethod(paramContext, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
      }
      this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
      AppMethodBeat.o(139515);
    }
  }
  
  public void a(ValueCallback<Map> paramValueCallback)
  {
    AppMethodBeat.i(139482);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(139482);
  }
  
  public void a(String paramString, long paramLong)
  {
    AppMethodBeat.i(139485);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new Class[] { String.class, Long.TYPE }, new Object[] { paramString, Long.valueOf(paramLong) });
    AppMethodBeat.o(139485);
  }
  
  public void a(String paramString, ValueCallback<Long> paramValueCallback)
  {
    AppMethodBeat.i(139483);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
    AppMethodBeat.o(139483);
  }
  
  public void a(String paramString, IconListener paramIconListener)
  {
    AppMethodBeat.i(139472);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[] { String.class, IconListener.class }, new Object[] { paramString, paramIconListener });
    AppMethodBeat.o(139472);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(139459);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webview_setWebContentsDebuggingEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(139459);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(139454);
    try
    {
      Object localObject = this.a.getClassLoader().loadClass("com.tencent.tbs.tbsshell.WebCoreProxy").getMethod("canUseX5", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = ((Method)localObject).invoke(null, new Object[0]);
      if ((localObject instanceof Boolean))
      {
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(139454);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(139454);
      throw localThrowable;
    }
    boolean bool = ((Boolean)localThrowable).booleanValue();
    AppMethodBeat.o(139454);
    return bool;
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(139517);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString });
    if ((paramContext instanceof Boolean))
    {
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(139517);
      return bool;
    }
    AppMethodBeat.o(139517);
    return false;
  }
  
  public boolean a(Map<String, String[]> paramMap)
  {
    AppMethodBeat.i(139458);
    paramMap = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[] { Map.class }, new Object[] { paramMap });
    if (paramMap == null)
    {
      AppMethodBeat.o(139458);
      return false;
    }
    boolean bool = ((Boolean)paramMap).booleanValue();
    AppMethodBeat.o(139458);
    return bool;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(139501);
    paramArrayOfByte = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new Class[] { String.class }, new Object[] { paramArrayOfByte });
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(139501);
      return null;
    }
    paramArrayOfByte = (byte[])paramArrayOfByte;
    AppMethodBeat.o(139501);
    return paramArrayOfByte;
  }
  
  public Uri[] a(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(139470);
    paramIntent = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[] { Integer.TYPE, Intent.class }, new Object[] { Integer.valueOf(paramInt), paramIntent });
    if (paramIntent == null)
    {
      AppMethodBeat.o(139470);
      return null;
    }
    paramIntent = (Uri[])paramIntent;
    AppMethodBeat.o(139470);
    return paramIntent;
  }
  
  public DexLoader b()
  {
    return this.a;
  }
  
  public String b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(139514);
    paramString1 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
    if (paramString1 == null)
    {
      AppMethodBeat.o(139514);
      return null;
    }
    paramString1 = (String)paramString1;
    AppMethodBeat.o(139514);
    return paramString1;
  }
  
  public void b(ValueCallback<Set<String>> paramValueCallback)
  {
    AppMethodBeat.i(139489);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetOrigins", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(139489);
  }
  
  public void b(String paramString)
  {
    AppMethodBeat.i(139469);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(139469);
  }
  
  public void b(String paramString, ValueCallback<Long> paramValueCallback)
  {
    AppMethodBeat.i(139484);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
    AppMethodBeat.o(139484);
  }
  
  public boolean b(Context paramContext)
  {
    AppMethodBeat.i(139476);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(139476);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(139476);
    return bool;
  }
  
  public Object c()
  {
    AppMethodBeat.i(139455);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0]);
    AppMethodBeat.o(139455);
    return localObject;
  }
  
  public void c(Context paramContext)
  {
    AppMethodBeat.i(139477);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(139477);
  }
  
  public void c(String paramString)
  {
    AppMethodBeat.i(139473);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(139473);
  }
  
  public void c(String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(139490);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetAllowed", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
    AppMethodBeat.o(139490);
  }
  
  public void d(String paramString)
  {
    AppMethodBeat.i(139474);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(139474);
  }
  
  public boolean d()
  {
    AppMethodBeat.i(139456);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(139456);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(139456);
    return bool;
  }
  
  public boolean d(Context paramContext)
  {
    AppMethodBeat.i(139478);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(139478);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(139478);
    return bool;
  }
  
  public void e()
  {
    AppMethodBeat.i(139457);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
    AppMethodBeat.o(139457);
  }
  
  public void e(Context paramContext)
  {
    AppMethodBeat.i(139479);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(139479);
  }
  
  public void e(String paramString)
  {
    AppMethodBeat.i(139486);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(139486);
  }
  
  public String f()
  {
    AppMethodBeat.i(139462);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(139462);
      return null;
    }
    localObject = (String)localObject;
    AppMethodBeat.o(139462);
    return localObject;
  }
  
  public void f(String paramString)
  {
    AppMethodBeat.i(139491);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClear", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(139491);
  }
  
  public boolean f(Context paramContext)
  {
    AppMethodBeat.i(139480);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(139480);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(139480);
    return bool;
  }
  
  public Object g()
  {
    AppMethodBeat.i(139464);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
    AppMethodBeat.o(139464);
    return localObject;
  }
  
  public void g(Context paramContext)
  {
    AppMethodBeat.i(139481);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(139481);
  }
  
  public void g(String paramString)
  {
    AppMethodBeat.i(139492);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsAllow", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(139492);
  }
  
  public IX5DateSorter h(Context paramContext)
  {
    AppMethodBeat.i(139488);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDateSorter", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(139488);
      return null;
    }
    paramContext = (IX5DateSorter)paramContext;
    AppMethodBeat.o(139488);
    return paramContext;
  }
  
  public String h(String paramString)
  {
    AppMethodBeat.i(139494);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetFileExtensionFromUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139494);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(139494);
    return paramString;
  }
  
  public boolean h()
  {
    AppMethodBeat.i(139465);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(139465);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(139465);
    return bool;
  }
  
  public IX5WebChromeClient i()
  {
    AppMethodBeat.i(139466);
    if (this.a == null)
    {
      AppMethodBeat.o(139466);
      return null;
    }
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(139466);
      return null;
    }
    localObject = (IX5WebChromeClient)localObject;
    AppMethodBeat.o(139466);
    return localObject;
  }
  
  public String i(Context paramContext)
  {
    AppMethodBeat.i(139519);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getDefaultUserAgent", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext instanceof String))
    {
      paramContext = (String)paramContext;
      AppMethodBeat.o(139519);
      return paramContext;
    }
    AppMethodBeat.o(139519);
    return null;
  }
  
  public boolean i(String paramString)
  {
    AppMethodBeat.i(139495);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasMimeType", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139495);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(139495);
    return bool;
  }
  
  public IX5WebViewClient j()
  {
    AppMethodBeat.i(139467);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(139467);
      return null;
    }
    localObject = (IX5WebViewClient)localObject;
    AppMethodBeat.o(139467);
    return localObject;
  }
  
  public String j(String paramString)
  {
    AppMethodBeat.i(139496);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139496);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(139496);
    return paramString;
  }
  
  public IX5WebViewClientExtension k()
  {
    AppMethodBeat.i(139468);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(139468);
      return null;
    }
    localObject = (IX5WebViewClientExtension)localObject;
    AppMethodBeat.o(139468);
    return localObject;
  }
  
  public boolean k(String paramString)
  {
    AppMethodBeat.i(139497);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasExtension", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139497);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(139497);
    return bool;
  }
  
  public String l(String paramString)
  {
    AppMethodBeat.i(139498);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139498);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(139498);
    return paramString;
  }
  
  public void l()
  {
    AppMethodBeat.i(139471);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
    AppMethodBeat.o(139471);
  }
  
  public String m(String paramString)
  {
    AppMethodBeat.i(139499);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139499);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(139499);
    return paramString;
  }
  
  public void m()
  {
    AppMethodBeat.i(139475);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
    AppMethodBeat.o(139475);
  }
  
  public void n()
  {
    AppMethodBeat.i(139487);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new Object[0]);
    AppMethodBeat.o(139487);
  }
  
  public boolean n(String paramString)
  {
    AppMethodBeat.i(139502);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139502);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(139502);
    return bool;
  }
  
  public void o()
  {
    AppMethodBeat.i(139493);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClearAll", null, new Object[0]);
    AppMethodBeat.o(139493);
  }
  
  public boolean o(String paramString)
  {
    AppMethodBeat.i(139503);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139503);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(139503);
    return bool;
  }
  
  public void p()
  {
    AppMethodBeat.i(139518);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
    AppMethodBeat.o(139518);
  }
  
  public boolean p(String paramString)
  {
    AppMethodBeat.i(139504);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139504);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(139504);
    return bool;
  }
  
  public boolean q(String paramString)
  {
    AppMethodBeat.i(139505);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139505);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(139505);
    return bool;
  }
  
  public boolean r(String paramString)
  {
    AppMethodBeat.i(139506);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139506);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(139506);
    return bool;
  }
  
  public boolean s(String paramString)
  {
    AppMethodBeat.i(139507);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139507);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(139507);
    return bool;
  }
  
  public boolean t(String paramString)
  {
    AppMethodBeat.i(139508);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139508);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(139508);
    return bool;
  }
  
  public boolean u(String paramString)
  {
    AppMethodBeat.i(139509);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139509);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(139509);
    return bool;
  }
  
  public boolean v(String paramString)
  {
    AppMethodBeat.i(139510);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139510);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(139510);
    return bool;
  }
  
  public boolean w(String paramString)
  {
    AppMethodBeat.i(139511);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139511);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(139511);
    return bool;
  }
  
  public boolean x(String paramString)
  {
    AppMethodBeat.i(139512);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139512);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(139512);
    return bool;
  }
  
  public String y(String paramString)
  {
    AppMethodBeat.i(139513);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(139513);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(139513);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.ca
 * JD-Core Version:    0.7.0.1
 */