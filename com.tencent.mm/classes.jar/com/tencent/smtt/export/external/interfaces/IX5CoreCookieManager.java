package com.tencent.smtt.export.external.interfaces;

import android.content.Context;
import android.webkit.ValueCallback;
import java.net.URL;
import java.util.List;
import java.util.Map;

public abstract interface IX5CoreCookieManager
{
  public abstract boolean acceptCookie();
  
  public abstract boolean acceptThirdPartyCookies(Object paramObject);
  
  public abstract void appendDomain(URL paramURL);
  
  public abstract void flush();
  
  public abstract String getCookie(String paramString);
  
  public abstract String getCookie(String paramString, boolean paramBoolean);
  
  public abstract String getQCookie(String paramString);
  
  public abstract boolean hasCookies();
  
  public abstract void removeAllCookie();
  
  public abstract void removeAllCookies(ValueCallback<Boolean> paramValueCallback);
  
  public abstract void removeExpiredCookie();
  
  public abstract void removeSessionCookie();
  
  public abstract void removeSessionCookies(ValueCallback<Boolean> paramValueCallback);
  
  public abstract void setAcceptCookie(boolean paramBoolean);
  
  public abstract void setAcceptThirdPartyCookies(Object paramObject, boolean paramBoolean);
  
  public abstract void setCookie(String paramString1, String paramString2);
  
  public abstract void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback);
  
  public abstract void setCookie(URL paramURL, Map<String, List<String>> paramMap);
  
  public abstract boolean setCookies(Map<String, String[]> paramMap);
  
  public abstract void setQCookie(String paramString1, String paramString2);
  
  public abstract void syncImmediately();
  
  @Deprecated
  public abstract void syncManagerCreateInstance(Context paramContext);
  
  @Deprecated
  public abstract void syncManagerStartSync();
  
  @Deprecated
  public abstract void syncManagerStopSync();
  
  @Deprecated
  public abstract void syncManagerSync();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
 * JD-Core Version:    0.7.0.1
 */