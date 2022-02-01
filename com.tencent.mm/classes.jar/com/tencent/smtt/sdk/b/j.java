package com.tencent.smtt.sdk.b;

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
    AppMethodBeat.i(192906);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(192906);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(192906);
    return bool;
  }
  
  public boolean acceptThirdPartyCookies(Object paramObject)
  {
    AppMethodBeat.i(192912);
    paramObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[] { Object.class }, new Object[] { paramObject });
    if (paramObject != null)
    {
      boolean bool = ((Boolean)paramObject).booleanValue();
      AppMethodBeat.o(192912);
      return bool;
    }
    AppMethodBeat.o(192912);
    return true;
  }
  
  public void appendDomain(URL paramURL) {}
  
  public void flush()
  {
    AppMethodBeat.i(192917);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
    AppMethodBeat.o(192917);
  }
  
  public String getCookie(String paramString)
  {
    AppMethodBeat.i(192924);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(192924);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(192924);
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
    AppMethodBeat.i(192919);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(192919);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(192919);
    return bool;
  }
  
  public void removeAllCookie()
  {
    AppMethodBeat.i(192915);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
    AppMethodBeat.o(192915);
  }
  
  public void removeAllCookies(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(192916);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(192916);
  }
  
  public void removeExpiredCookie()
  {
    AppMethodBeat.i(192918);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
    AppMethodBeat.o(192918);
  }
  
  public void removeSessionCookie()
  {
    AppMethodBeat.i(192913);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
    AppMethodBeat.o(192913);
  }
  
  public void removeSessionCookies(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(192914);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(192914);
  }
  
  public void setAcceptCookie(boolean paramBoolean)
  {
    AppMethodBeat.i(192910);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(192910);
  }
  
  public void setAcceptThirdPartyCookies(Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(192911);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[] { Object.class, Boolean.TYPE }, new Object[] { paramObject, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(192911);
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192908);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class }, new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(192908);
  }
  
  public void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(192909);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class, ValueCallback.class }, new Object[] { paramString1, paramString2, paramValueCallback });
    AppMethodBeat.o(192909);
  }
  
  public void setCookie(URL paramURL, Map<String, List<String>> paramMap) {}
  
  public boolean setCookies(Map<String, String[]> paramMap)
  {
    AppMethodBeat.i(192907);
    paramMap = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[] { Map.class }, new Object[] { paramMap });
    if (paramMap == null)
    {
      AppMethodBeat.o(192907);
      return false;
    }
    boolean bool = ((Boolean)paramMap).booleanValue();
    AppMethodBeat.o(192907);
    return bool;
  }
  
  public void setQCookie(String paramString1, String paramString2) {}
  
  public void syncImmediately() {}
  
  public void syncManagerCreateInstance(Context paramContext)
  {
    AppMethodBeat.i(192920);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(192920);
  }
  
  public void syncManagerStartSync()
  {
    AppMethodBeat.i(192923);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
    AppMethodBeat.o(192923);
  }
  
  public void syncManagerStopSync()
  {
    AppMethodBeat.i(192922);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
    AppMethodBeat.o(192922);
  }
  
  public void syncManagerSync()
  {
    AppMethodBeat.i(192921);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
    AppMethodBeat.o(192921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.j
 * JD-Core Version:    0.7.0.1
 */