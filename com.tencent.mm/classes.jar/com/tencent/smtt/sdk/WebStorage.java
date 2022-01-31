package com.tencent.smtt.sdk;

import java.util.Map;

public class WebStorage
{
  private static WebStorage a;
  
  private static WebStorage a()
  {
    try
    {
      if (a == null) {
        a = new WebStorage();
      }
      WebStorage localWebStorage = a;
      return localWebStorage;
    }
    finally {}
  }
  
  public static WebStorage getInstance()
  {
    return a();
  }
  
  public void deleteAllData()
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().n();
      return;
    }
    android.webkit.WebStorage.getInstance().deleteAllData();
  }
  
  public void deleteOrigin(String paramString)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().e(paramString);
      return;
    }
    android.webkit.WebStorage.getInstance().deleteOrigin(paramString);
  }
  
  public void getOrigins(ValueCallback<Map> paramValueCallback)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().a(paramValueCallback);
      return;
    }
    android.webkit.WebStorage.getInstance().getOrigins(paramValueCallback);
  }
  
  public void getQuotaForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().b(paramString, paramValueCallback);
      return;
    }
    android.webkit.WebStorage.getInstance().getQuotaForOrigin(paramString, paramValueCallback);
  }
  
  public void getUsageForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().a(paramString, paramValueCallback);
      return;
    }
    android.webkit.WebStorage.getInstance().getUsageForOrigin(paramString, paramValueCallback);
  }
  
  @Deprecated
  public void setQuotaForOrigin(String paramString, long paramLong)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().a(paramString, paramLong);
      return;
    }
    android.webkit.WebStorage.getInstance().setQuotaForOrigin(paramString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebStorage
 * JD-Core Version:    0.7.0.1
 */