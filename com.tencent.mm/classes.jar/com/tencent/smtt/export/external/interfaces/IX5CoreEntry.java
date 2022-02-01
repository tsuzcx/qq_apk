package com.tencent.smtt.export.external.interfaces;

import android.content.Context;
import java.util.Map;

public abstract interface IX5CoreEntry
{
  public abstract boolean canLoadX5(Context paramContext);
  
  public abstract boolean canUseX5();
  
  public abstract IX5WebViewBase createX5WebView(Context paramContext, boolean paramBoolean);
  
  public abstract int getCoreVersion();
  
  public abstract IX5CoreCacheManager getX5CoreCacheManager();
  
  public abstract IX5CoreCookieManager getX5CoreCookieManager();
  
  public abstract IX5CoreGeolocationPermissions getX5CoreGeolocationPermissions();
  
  public abstract IX5CoreJsCore getX5CoreJsCore();
  
  public abstract IX5CoreMessy getX5CoreMessy();
  
  public abstract IX5CoreNetwork getX5CoreNetwork();
  
  public abstract IX5CoreOptimizedBitmap getX5CoreOptimizedBitmap();
  
  public abstract IX5CoreUrlUtil getX5CoreUrlUtil();
  
  public abstract IX5CoreWebIconDB getX5CoreWebIconDB();
  
  public abstract IX5CoreWebStorage getX5CoreWebStorage();
  
  public abstract IX5CoreWebViewDB getX5CoreWebViewDB();
  
  public abstract void initRuntimeEnvironment();
  
  public abstract void initSettings(Map paramMap);
  
  public abstract void setQua1(String paramString);
  
  public abstract void setQua2_v3(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean);
  
  public abstract void setSdkVersionCode(int paramInt);
  
  public abstract void setSdkVersionName(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5CoreEntry
 * JD-Core Version:    0.7.0.1
 */