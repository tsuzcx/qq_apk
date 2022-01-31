package com.tencent.xweb.x5;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.TextSize;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.n;
import com.tencent.xweb.n.a;

public final class k
  extends n
{
  WebView xkP;
  
  public k(WebView paramWebView)
  {
    this.xkP = paramWebView;
  }
  
  public final void a(n.a parama)
  {
    try
    {
      this.xkP.getSettings().setTextSize(WebSettings.TextSize.valueOf(parama.name()));
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void cSl()
  {
    this.xkP.getSettings().setDisplayZoomControls(false);
  }
  
  public final void cSm()
  {
    this.xkP.getSettings().setSaveFormData(false);
  }
  
  public final void cSn()
  {
    this.xkP.getSettings().setSavePassword(false);
  }
  
  public final void cSo()
  {
    this.xkP.getSettings().setDefaultFontSize(8);
  }
  
  public final void cSp()
  {
    this.xkP.getSettings().setAppCacheEnabled(true);
  }
  
  public final void cSq()
  {
    this.xkP.getSettings().setAppCacheMaxSize(10485760L);
  }
  
  public final void cSr()
  {
    this.xkP.getSettings().setDatabaseEnabled(true);
  }
  
  public final void cSs()
  {
    this.xkP.getSettings().setDomStorageEnabled(true);
  }
  
  public final void cSt()
  {
    this.xkP.getSettings().setCacheMode(-1);
  }
  
  public final void cSu()
  {
    this.xkP.getSettings().setMixedContentMode(0);
  }
  
  public final boolean getBlockNetworkImage()
  {
    return this.xkP.getSettings().getBlockNetworkImage();
  }
  
  public final String getUserAgentString()
  {
    return this.xkP.getSettings().getUserAgentString();
  }
  
  public final void setAppCachePath(String paramString)
  {
    this.xkP.getSettings().setAppCachePath(paramString);
  }
  
  public final void setBlockNetworkImage(boolean paramBoolean)
  {
    this.xkP.getSettings().setBlockNetworkImage(paramBoolean);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    this.xkP.getSettings().setBuiltInZoomControls(paramBoolean);
  }
  
  public final void setDatabasePath(String paramString)
  {
    this.xkP.getSettings().setDatabasePath(paramString);
  }
  
  public final void setDefaultTextEncodingName(String paramString)
  {
    this.xkP.getSettings().setDefaultTextEncodingName(paramString);
  }
  
  public final void setGeolocationEnabled(boolean paramBoolean)
  {
    this.xkP.getSettings().setGeolocationEnabled(paramBoolean);
  }
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    this.xkP.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    this.xkP.getSettings().setJavaScriptEnabled(paramBoolean);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    paramLayoutAlgorithm = com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm.values()[paramLayoutAlgorithm.ordinal()];
    this.xkP.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    this.xkP.getSettings().setLoadWithOverviewMode(paramBoolean);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    this.xkP.getSettings().setLoadsImagesAutomatically(paramBoolean);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    this.xkP.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
  }
  
  public final void setPluginsEnabled(boolean paramBoolean)
  {
    this.xkP.getSettings().setPluginsEnabled(paramBoolean);
  }
  
  public final void setRenderPriority(WebSettings.RenderPriority paramRenderPriority)
  {
    paramRenderPriority = com.tencent.smtt.sdk.WebSettings.RenderPriority.values()[paramRenderPriority.ordinal()];
    this.xkP.getSettings().setRenderPriority(paramRenderPriority);
  }
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    this.xkP.getSettings().setSupportZoom(paramBoolean);
  }
  
  public final void setTextZoom(int paramInt)
  {
    this.xkP.getSettings().setTextZoom(paramInt);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    this.xkP.getSettings().setUseWideViewPort(paramBoolean);
  }
  
  public final void setUserAgentString(String paramString)
  {
    this.xkP.getSettings().setUserAgentString(paramString);
  }
  
  public final void setUsingForAppBrand(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.x5.k
 * JD-Core Version:    0.7.0.1
 */