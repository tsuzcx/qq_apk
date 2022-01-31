package com.tencent.smtt.sdk;

import java.util.Set;

public class GeolocationPermissions
{
  private static GeolocationPermissions a;
  
  private static GeolocationPermissions a()
  {
    try
    {
      if (a == null) {
        a = new GeolocationPermissions();
      }
      GeolocationPermissions localGeolocationPermissions = a;
      return localGeolocationPermissions;
    }
    finally {}
  }
  
  public static GeolocationPermissions getInstance()
  {
    return a();
  }
  
  public void allow(String paramString)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().g(paramString);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().allow(paramString);
  }
  
  public void clear(String paramString)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().f(paramString);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().clear(paramString);
  }
  
  public void clearAll()
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().o();
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().clearAll();
  }
  
  public void getAllowed(String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().c(paramString, paramValueCallback);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().getAllowed(paramString, paramValueCallback);
  }
  
  public void getOrigins(ValueCallback<Set<String>> paramValueCallback)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().b(paramValueCallback);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().getOrigins(paramValueCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.GeolocationPermissions
 * JD-Core Version:    0.7.0.1
 */