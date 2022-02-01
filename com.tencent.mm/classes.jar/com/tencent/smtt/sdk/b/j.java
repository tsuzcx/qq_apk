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
    AppMethodBeat.i(219795);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(219795);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(219795);
    return bool;
  }
  
  public boolean acceptThirdPartyCookies(Object paramObject)
  {
    AppMethodBeat.i(219827);
    paramObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[] { Object.class }, new Object[] { paramObject });
    if (paramObject != null)
    {
      boolean bool = ((Boolean)paramObject).booleanValue();
      AppMethodBeat.o(219827);
      return bool;
    }
    AppMethodBeat.o(219827);
    return true;
  }
  
  public void appendDomain(URL paramURL) {}
  
  public void flush()
  {
    AppMethodBeat.i(219856);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
    AppMethodBeat.o(219856);
  }
  
  public String getCookie(String paramString)
  {
    AppMethodBeat.i(219894);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(219894);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(219894);
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
    AppMethodBeat.i(219868);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(219868);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(219868);
    return bool;
  }
  
  public void removeAllCookie()
  {
    AppMethodBeat.i(219848);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
    AppMethodBeat.o(219848);
  }
  
  public void removeAllCookies(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(219852);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(219852);
  }
  
  public void removeExpiredCookie()
  {
    AppMethodBeat.i(219862);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
    AppMethodBeat.o(219862);
  }
  
  public void removeSessionCookie()
  {
    AppMethodBeat.i(219835);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
    AppMethodBeat.o(219835);
  }
  
  public void removeSessionCookies(ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(219842);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(219842);
  }
  
  public void setAcceptCookie(boolean paramBoolean)
  {
    AppMethodBeat.i(219814);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(219814);
  }
  
  public void setAcceptThirdPartyCookies(Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(219820);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[] { Object.class, Boolean.TYPE }, new Object[] { paramObject, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(219820);
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219802);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class }, new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(219802);
  }
  
  public void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(219807);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[] { String.class, String.class, ValueCallback.class }, new Object[] { paramString1, paramString2, paramValueCallback });
    AppMethodBeat.o(219807);
  }
  
  public void setCookie(URL paramURL, Map<String, List<String>> paramMap) {}
  
  public boolean setCookies(Map<String, String[]> paramMap)
  {
    AppMethodBeat.i(219798);
    paramMap = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[] { Map.class }, new Object[] { paramMap });
    if (paramMap == null)
    {
      AppMethodBeat.o(219798);
      return false;
    }
    boolean bool = ((Boolean)paramMap).booleanValue();
    AppMethodBeat.o(219798);
    return bool;
  }
  
  public void setQCookie(String paramString1, String paramString2) {}
  
  public void syncImmediately() {}
  
  public void syncManagerCreateInstance(Context paramContext)
  {
    AppMethodBeat.i(219872);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(219872);
  }
  
  public void syncManagerStartSync()
  {
    AppMethodBeat.i(219885);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
    AppMethodBeat.o(219885);
  }
  
  public void syncManagerStopSync()
  {
    AppMethodBeat.i(219881);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
    AppMethodBeat.o(219881);
  }
  
  public void syncManagerSync()
  {
    AppMethodBeat.i(219878);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
    AppMethodBeat.o(219878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.j
 * JD-Core Version:    0.7.0.1
 */