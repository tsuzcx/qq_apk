package com.tencent.smtt.sdk.a;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class j
  implements IX5CoreCookieManager
{
  private DexLoader a;
  
  j(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public boolean acceptCookie()
  {
    AppMethodBeat.i(54714);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(54714);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(54714);
    return bool;
  }
  
  public boolean acceptThirdPartyCookies(Object paramObject)
  {
    AppMethodBeat.i(54720);
    paramObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[] { Object.class }, new Object[] { paramObject });
    if (paramObject != null)
    {
      boolean bool = ((Boolean)paramObject).booleanValue();
      AppMethodBeat.o(54720);
      return bool;
    }
    AppMethodBeat.o(54720);
    return true;
  }
  
  public void appendDomain(URL paramURL) {}
  
  public void flush()
  {
    AppMethodBeat.i(54725);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
    AppMethodBeat.o(54725);
  }
  
  public String getCookie(String paramString)
  {
    AppMethodBeat.i(54732);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(54732);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(54732);
    return paramString;
  }
  
  public String getCookie(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public String getQCookie(String paramString)
  {
    return null;
  }
  
  public boolean hasCookies()
  {
    AppMethodBeat.i(54727);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(54727);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(54727);
    return bool;
  }
  
  public void removeAllCookie()
  {
    AppMethodBeat.i(54723);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
    AppMethodBeat.o(54723);
  }
  
  public void removeAllCookies(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(54724);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(54724);
  }
  
  public void removeExpiredCookie()
  {
    AppMethodBeat.i(54726);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
    AppMethodBeat.o(54726);
  }
  
  public void removeSessionCookie()
  {
    AppMethodBeat.i(54721);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
    AppMethodBeat.o(54721);
  }
  
  public void removeSessionCookies(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(54722);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(54722);
  }
  
  public void setAcceptCookie(boolean paramBoolean)
  {
    AppMethodBeat.i(54718);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(54718);
  }
  
  public void setAcceptThirdPartyCookies(Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(54719);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[] { Object.class, Boolean.TYPE }, new Object[] { paramObject, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(54719);
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54716);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class }, new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(54716);
  }
  
  public void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(54717);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class, ValueCallback.class }, new Object[] { paramString1, paramString2, paramValueCallback });
    AppMethodBeat.o(54717);
  }
  
  public void setCookie(URL paramURL, Map<String, List<String>> paramMap) {}
  
  public boolean setCookies(Map<String, String[]> paramMap)
  {
    AppMethodBeat.i(54715);
    paramMap = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[] { Map.class }, new Object[] { paramMap });
    if (paramMap == null)
    {
      AppMethodBeat.o(54715);
      return false;
    }
    boolean bool = ((Boolean)paramMap).booleanValue();
    AppMethodBeat.o(54715);
    return bool;
  }
  
  public void setQCookie(String paramString1, String paramString2) {}
  
  public void syncImmediately() {}
  
  public void syncManagerCreateInstance(Context paramContext)
  {
    AppMethodBeat.i(54728);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(54728);
  }
  
  public void syncManagerStartSync()
  {
    AppMethodBeat.i(54731);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
    AppMethodBeat.o(54731);
  }
  
  public void syncManagerStopSync()
  {
    AppMethodBeat.i(54730);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
    AppMethodBeat.o(54730);
  }
  
  public void syncManagerSync()
  {
    AppMethodBeat.i(54729);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
    AppMethodBeat.o(54729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.j
 * JD-Core Version:    0.7.0.1
 */