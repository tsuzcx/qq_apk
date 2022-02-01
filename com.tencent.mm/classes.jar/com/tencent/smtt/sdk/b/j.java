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
    AppMethodBeat.i(196976);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(196976);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(196976);
    return bool;
  }
  
  public boolean acceptThirdPartyCookies(Object paramObject)
  {
    AppMethodBeat.i(196992);
    paramObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[] { Object.class }, new Object[] { paramObject });
    if (paramObject != null)
    {
      boolean bool = ((Boolean)paramObject).booleanValue();
      AppMethodBeat.o(196992);
      return bool;
    }
    AppMethodBeat.o(196992);
    return true;
  }
  
  public void appendDomain(URL paramURL) {}
  
  public void flush()
  {
    AppMethodBeat.i(197003);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
    AppMethodBeat.o(197003);
  }
  
  public String getCookie(String paramString)
  {
    AppMethodBeat.i(197015);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197015);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(197015);
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
    AppMethodBeat.i(197005);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(197005);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(197005);
    return bool;
  }
  
  public void removeAllCookie()
  {
    AppMethodBeat.i(196999);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
    AppMethodBeat.o(196999);
  }
  
  public void removeAllCookies(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(197002);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(197002);
  }
  
  public void removeExpiredCookie()
  {
    AppMethodBeat.i(197004);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
    AppMethodBeat.o(197004);
  }
  
  public void removeSessionCookie()
  {
    AppMethodBeat.i(196994);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
    AppMethodBeat.o(196994);
  }
  
  public void removeSessionCookies(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(196996);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(196996);
  }
  
  public void setAcceptCookie(boolean paramBoolean)
  {
    AppMethodBeat.i(196986);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(196986);
  }
  
  public void setAcceptThirdPartyCookies(Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(196990);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[] { Object.class, Boolean.TYPE }, new Object[] { paramObject, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(196990);
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196981);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class }, new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(196981);
  }
  
  public void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(196984);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class, ValueCallback.class }, new Object[] { paramString1, paramString2, paramValueCallback });
    AppMethodBeat.o(196984);
  }
  
  public void setCookie(URL paramURL, Map<String, List<String>> paramMap) {}
  
  public boolean setCookies(Map<String, String[]> paramMap)
  {
    AppMethodBeat.i(196978);
    paramMap = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[] { Map.class }, new Object[] { paramMap });
    if (paramMap == null)
    {
      AppMethodBeat.o(196978);
      return false;
    }
    boolean bool = ((Boolean)paramMap).booleanValue();
    AppMethodBeat.o(196978);
    return bool;
  }
  
  public void setQCookie(String paramString1, String paramString2) {}
  
  public void syncImmediately() {}
  
  public void syncManagerCreateInstance(Context paramContext)
  {
    AppMethodBeat.i(197006);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(197006);
  }
  
  public void syncManagerStartSync()
  {
    AppMethodBeat.i(197011);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
    AppMethodBeat.o(197011);
  }
  
  public void syncManagerStopSync()
  {
    AppMethodBeat.i(197008);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
    AppMethodBeat.o(197008);
  }
  
  public void syncManagerSync()
  {
    AppMethodBeat.i(197007);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
    AppMethodBeat.o(197007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.j
 * JD-Core Version:    0.7.0.1
 */