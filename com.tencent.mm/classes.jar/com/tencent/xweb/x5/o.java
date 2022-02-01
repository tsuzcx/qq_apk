package com.tencent.xweb.x5;

import android.os.Bundle;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.z;
import org.a.a;
import org.xwalk.core.Log;

public final class o
  extends z
{
  WebView Mvu;
  private int Mvv = 0;
  
  public o(WebView paramWebView)
  {
    this.Mvu = paramWebView;
  }
  
  public final void enableCustomizedLongPressTimeout(int paramInt) {}
  
  public final void gaR()
  {
    AppMethodBeat.i(153993);
    this.Mvu.getSettings().setDisplayZoomControls(false);
    AppMethodBeat.o(153993);
  }
  
  public final void gaS()
  {
    AppMethodBeat.i(153994);
    this.Mvu.getSettings().setAllowFileAccess(true);
    AppMethodBeat.o(153994);
  }
  
  public final void gaT()
  {
    AppMethodBeat.i(153996);
    this.Mvu.getSettings().setSaveFormData(false);
    AppMethodBeat.o(153996);
  }
  
  public final void gaU()
  {
    AppMethodBeat.i(153997);
    this.Mvu.getSettings().setSavePassword(false);
    AppMethodBeat.o(153997);
  }
  
  public final void gaV()
  {
    AppMethodBeat.i(154001);
    this.Mvu.getSettings().setDefaultFontSize(8);
    AppMethodBeat.o(154001);
  }
  
  public final void gaW()
  {
    AppMethodBeat.i(154006);
    this.Mvu.getSettings().setAllowUniversalAccessFromFileURLs(true);
    AppMethodBeat.o(154006);
  }
  
  public final void gaX()
  {
    AppMethodBeat.i(154007);
    this.Mvu.getSettings().setAllowFileAccessFromFileURLs(true);
    AppMethodBeat.o(154007);
  }
  
  public final void gaY()
  {
    AppMethodBeat.i(154010);
    this.Mvu.getSettings().setAppCacheEnabled(true);
    AppMethodBeat.o(154010);
  }
  
  public final void gaZ()
  {
    AppMethodBeat.i(154012);
    this.Mvu.getSettings().setAppCacheMaxSize(10485760L);
    AppMethodBeat.o(154012);
  }
  
  public final void gba()
  {
    AppMethodBeat.i(154013);
    this.Mvu.getSettings().setDatabaseEnabled(true);
    AppMethodBeat.o(154013);
  }
  
  public final void gbb()
  {
    AppMethodBeat.i(154014);
    this.Mvu.getSettings().setDomStorageEnabled(true);
    AppMethodBeat.o(154014);
  }
  
  public final void gbc()
  {
    AppMethodBeat.i(154021);
    this.Mvu.getSettings().setCacheMode(-1);
    AppMethodBeat.o(154021);
  }
  
  public final void gbd()
  {
    AppMethodBeat.i(154022);
    this.Mvu.getSettings().setMixedContentMode(0);
    AppMethodBeat.o(154022);
  }
  
  public final boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(154004);
    boolean bool = this.Mvu.getSettings().getBlockNetworkImage();
    AppMethodBeat.o(154004);
    return bool;
  }
  
  public final int getForceDarkBehavior()
  {
    return 0;
  }
  
  public final int getForceDarkMode()
  {
    return 0;
  }
  
  public final String getUserAgentString()
  {
    AppMethodBeat.i(154019);
    String str = this.Mvu.getSettings().getUserAgentString();
    AppMethodBeat.o(154019);
    return str;
  }
  
  public final void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(154011);
    this.Mvu.getSettings().setAppCachePath(paramString);
    AppMethodBeat.o(154011);
  }
  
  public final void setAudioPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(183739);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("require", paramBoolean);
      this.Mvu.getX5WebViewExtension().invokeMiscMethod("setAudioPlaybackRequiresUserGestureV2", localBundle);
      AppMethodBeat.o(183739);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(183739);
    }
  }
  
  public final void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(154003);
    this.Mvu.getSettings().setBlockNetworkImage(paramBoolean);
    AppMethodBeat.o(154003);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(153992);
    this.Mvu.getSettings().setBuiltInZoomControls(paramBoolean);
    AppMethodBeat.o(153992);
  }
  
  public final void setDatabasePath(String paramString)
  {
    AppMethodBeat.i(154009);
    this.Mvu.getSettings().setDatabasePath(paramString);
    AppMethodBeat.o(154009);
  }
  
  public final void setDefaultTextEncodingName(String paramString)
  {
    AppMethodBeat.i(154017);
    this.Mvu.getSettings().setDefaultTextEncodingName(paramString);
    AppMethodBeat.o(154017);
  }
  
  public final void setForceDarkBehavior(int paramInt) {}
  
  public final void setForceDarkMode(int paramInt) {}
  
  public final void setGeolocationEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154015);
    this.Mvu.getSettings().setGeolocationEnabled(paramBoolean);
    AppMethodBeat.o(154015);
  }
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(154016);
    this.Mvu.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
    AppMethodBeat.o(154016);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154005);
    this.Mvu.getSettings().setJavaScriptEnabled(paramBoolean);
    AppMethodBeat.o(154005);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(154000);
    paramLayoutAlgorithm = com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm.values()[paramLayoutAlgorithm.ordinal()];
    this.Mvu.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
    AppMethodBeat.o(154000);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(153995);
    this.Mvu.getSettings().setLoadWithOverviewMode(paramBoolean);
    AppMethodBeat.o(153995);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(154002);
    this.Mvu.getSettings().setLoadsImagesAutomatically(paramBoolean);
    AppMethodBeat.o(154002);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(153990);
    this.Mvu.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
    AppMethodBeat.o(153990);
  }
  
  public final void setPluginsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154008);
    this.Mvu.getSettings().setPluginsEnabled(paramBoolean);
    AppMethodBeat.o(154008);
  }
  
  public final void setRenderPriority(WebSettings.RenderPriority paramRenderPriority)
  {
    AppMethodBeat.i(154020);
    paramRenderPriority = com.tencent.smtt.sdk.WebSettings.RenderPriority.values()[paramRenderPriority.ordinal()];
    this.Mvu.getSettings().setRenderPriority(paramRenderPriority);
    AppMethodBeat.o(154020);
  }
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(153989);
    this.Mvu.getSettings().setSupportZoom(paramBoolean);
    AppMethodBeat.o(153989);
  }
  
  public final void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(153998);
    this.Mvu.getSettings().setTextZoom(paramInt);
    AppMethodBeat.o(153998);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(153999);
    this.Mvu.getSettings().setUseWideViewPort(paramBoolean);
    AppMethodBeat.o(153999);
  }
  
  public final void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(154018);
    this.Mvu.getSettings().setUserAgentString(paramString);
    AppMethodBeat.o(154018);
  }
  
  public final void setUsingForAppBrand(int paramInt)
  {
    AppMethodBeat.i(154023);
    this.Mvv = paramInt;
    if (this.Mvu.getX5WebViewExtension() == null)
    {
      AppMethodBeat.o(154023);
      return;
    }
    switch (this.Mvv)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(154023);
      return;
      Bundle localBundle1 = new Bundle(1);
      localBundle1.putInt("flag", 1);
      this.Mvu.getX5WebViewExtension().invokeMiscMethod("setMiniProgramFlag", localBundle1);
      try
      {
        a.gy(this.Mvu.getX5WebViewExtension()).C("setEnableAutoPageDiscarding", new Object[] { Boolean.FALSE });
        a.gy(this.Mvu.getX5WebViewExtension()).C("setEnableAutoPageRestoration", new Object[] { Boolean.FALSE });
        AppMethodBeat.o(154023);
        return;
      }
      catch (Exception localException)
      {
        Log.e("XWEB.X5WebViewSettings", "DisableAutoPageDiscarding error ".concat(String.valueOf(localException)));
        AppMethodBeat.o(154023);
        return;
      }
      Bundle localBundle2 = new Bundle(1);
      localBundle2.putInt("flag", 2);
      this.Mvu.getX5WebViewExtension().invokeMiscMethod("setMiniProgramFlag", localBundle2);
    }
  }
  
  public final void setVideoPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(153991);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("require", paramBoolean);
      a.gy(this.Mvu.getX5WebViewExtension()).C("invokeMiscMethod", new Object[] { "setVideoPlaybackRequiresUserGesture", localBundle });
      AppMethodBeat.o(153991);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(153991);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.o
 * JD-Core Version:    0.7.0.1
 */