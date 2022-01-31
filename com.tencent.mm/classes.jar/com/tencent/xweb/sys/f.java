package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import com.tencent.xweb.n;
import com.tencent.xweb.util.d;

public final class f
  extends n
{
  WebView xkc;
  String xkd = "";
  
  public f(WebView paramWebView)
  {
    this.xkc = paramWebView;
    getUserAgentString();
  }
  
  public final void cSl()
  {
    this.xkc.getSettings().setDisplayZoomControls(false);
  }
  
  public final void cSm()
  {
    this.xkc.getSettings().setSaveFormData(false);
  }
  
  public final void cSn()
  {
    this.xkc.getSettings().setSavePassword(false);
  }
  
  public final void cSo()
  {
    this.xkc.getSettings().setDefaultFontSize(8);
  }
  
  public final void cSp()
  {
    this.xkc.getSettings().setAppCacheEnabled(true);
  }
  
  public final void cSq()
  {
    this.xkc.getSettings().setAppCacheMaxSize(10485760L);
  }
  
  public final void cSr()
  {
    this.xkc.getSettings().setDatabaseEnabled(true);
  }
  
  public final void cSs()
  {
    this.xkc.getSettings().setDomStorageEnabled(true);
  }
  
  public final void cSt()
  {
    this.xkc.getSettings().setCacheMode(-1);
  }
  
  public final void cSu()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      this.xkc.getSettings().setMixedContentMode(0);
    }
  }
  
  public final boolean getBlockNetworkImage()
  {
    return this.xkc.getSettings().getBlockNetworkImage();
  }
  
  public final String getUserAgentString()
  {
    if ((this.xkd == null) || (this.xkd.isEmpty())) {}
    try
    {
      this.xkd = this.xkc.getSettings().getUserAgentString();
      label31:
      return this.xkd;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  public final void setAppCachePath(String paramString)
  {
    this.xkc.getSettings().setAppCachePath(paramString);
  }
  
  public final void setBlockNetworkImage(boolean paramBoolean)
  {
    this.xkc.getSettings().setBlockNetworkImage(paramBoolean);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    this.xkc.getSettings().setBuiltInZoomControls(paramBoolean);
  }
  
  public final void setDatabasePath(String paramString)
  {
    this.xkc.getSettings().setDatabasePath(paramString);
  }
  
  public final void setDefaultTextEncodingName(String paramString)
  {
    this.xkc.getSettings().setDefaultTextEncodingName(paramString);
  }
  
  public final void setGeolocationEnabled(boolean paramBoolean)
  {
    this.xkc.getSettings().setGeolocationEnabled(paramBoolean);
  }
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    this.xkc.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    this.xkc.getSettings().setJavaScriptEnabled(paramBoolean);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    this.xkc.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    this.xkc.getSettings().setLoadWithOverviewMode(paramBoolean);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    this.xkc.getSettings().setLoadsImagesAutomatically(paramBoolean);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.xkc.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
    }
  }
  
  public final void setPluginsEnabled(boolean paramBoolean)
  {
    d.c(this.xkc.getSettings(), "setPluginsEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public final void setRenderPriority(WebSettings.RenderPriority paramRenderPriority)
  {
    this.xkc.getSettings().setRenderPriority(paramRenderPriority);
  }
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    this.xkc.getSettings().setSupportZoom(paramBoolean);
  }
  
  public final void setTextZoom(int paramInt)
  {
    this.xkc.getSettings().setTextZoom(paramInt);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    this.xkc.getSettings().setUseWideViewPort(paramBoolean);
  }
  
  public final void setUserAgentString(String paramString)
  {
    this.xkd = paramString;
    this.xkc.getSettings().setUserAgentString(paramString);
  }
  
  public final void setUsingForAppBrand(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.sys.f
 * JD-Core Version:    0.7.0.1
 */