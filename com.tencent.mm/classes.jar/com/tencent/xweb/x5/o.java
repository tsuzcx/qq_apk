package com.tencent.xweb.x5;

import android.os.Bundle;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.z;
import java.util.Map;
import org.a.a;
import org.xwalk.core.Log;

public final class o
  extends z
{
  WebView MSy;
  private int MSz = 0;
  
  public o(WebView paramWebView)
  {
    this.MSy = paramWebView;
  }
  
  public final void enableCustomizedLongPressTimeout(int paramInt) {}
  
  public final boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(154004);
    boolean bool = this.MSy.getSettings().getBlockNetworkImage();
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
    String str = this.MSy.getSettings().getUserAgentString();
    AppMethodBeat.o(154019);
    return str;
  }
  
  public final void gfA()
  {
    AppMethodBeat.i(154010);
    this.MSy.getSettings().setAppCacheEnabled(true);
    AppMethodBeat.o(154010);
  }
  
  public final void gfB()
  {
    AppMethodBeat.i(154012);
    this.MSy.getSettings().setAppCacheMaxSize(10485760L);
    AppMethodBeat.o(154012);
  }
  
  public final void gfC()
  {
    AppMethodBeat.i(154013);
    this.MSy.getSettings().setDatabaseEnabled(true);
    AppMethodBeat.o(154013);
  }
  
  public final void gfD()
  {
    AppMethodBeat.i(154014);
    this.MSy.getSettings().setDomStorageEnabled(true);
    AppMethodBeat.o(154014);
  }
  
  public final void gfE()
  {
    AppMethodBeat.i(154021);
    this.MSy.getSettings().setCacheMode(-1);
    AppMethodBeat.o(154021);
  }
  
  public final void gfF()
  {
    AppMethodBeat.i(154022);
    this.MSy.getSettings().setMixedContentMode(0);
    AppMethodBeat.o(154022);
  }
  
  public final void gft()
  {
    AppMethodBeat.i(153993);
    this.MSy.getSettings().setDisplayZoomControls(false);
    AppMethodBeat.o(153993);
  }
  
  public final void gfu()
  {
    AppMethodBeat.i(153994);
    this.MSy.getSettings().setAllowFileAccess(true);
    AppMethodBeat.o(153994);
  }
  
  public final void gfv()
  {
    AppMethodBeat.i(153996);
    this.MSy.getSettings().setSaveFormData(false);
    AppMethodBeat.o(153996);
  }
  
  public final void gfw()
  {
    AppMethodBeat.i(153997);
    this.MSy.getSettings().setSavePassword(false);
    AppMethodBeat.o(153997);
  }
  
  public final void gfx()
  {
    AppMethodBeat.i(154001);
    this.MSy.getSettings().setDefaultFontSize(8);
    AppMethodBeat.o(154001);
  }
  
  public final void gfy()
  {
    AppMethodBeat.i(154006);
    this.MSy.getSettings().setAllowUniversalAccessFromFileURLs(true);
    AppMethodBeat.o(154006);
  }
  
  public final void gfz()
  {
    AppMethodBeat.i(154007);
    this.MSy.getSettings().setAllowFileAccessFromFileURLs(true);
    AppMethodBeat.o(154007);
  }
  
  public final void setAppBrandInfo(Map<String, String> paramMap) {}
  
  public final void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(154011);
    this.MSy.getSettings().setAppCachePath(paramString);
    AppMethodBeat.o(154011);
  }
  
  public final void setAudioPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(183739);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("require", paramBoolean);
      this.MSy.getX5WebViewExtension().invokeMiscMethod("setAudioPlaybackRequiresUserGestureV2", localBundle);
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
    this.MSy.getSettings().setBlockNetworkImage(paramBoolean);
    AppMethodBeat.o(154003);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(153992);
    this.MSy.getSettings().setBuiltInZoomControls(paramBoolean);
    AppMethodBeat.o(153992);
  }
  
  public final void setDatabasePath(String paramString)
  {
    AppMethodBeat.i(154009);
    this.MSy.getSettings().setDatabasePath(paramString);
    AppMethodBeat.o(154009);
  }
  
  public final void setDefaultTextEncodingName(String paramString)
  {
    AppMethodBeat.i(154017);
    this.MSy.getSettings().setDefaultTextEncodingName(paramString);
    AppMethodBeat.o(154017);
  }
  
  public final void setForceDarkBehavior(int paramInt) {}
  
  public final void setForceDarkMode(int paramInt) {}
  
  public final void setGeolocationEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154015);
    this.MSy.getSettings().setGeolocationEnabled(paramBoolean);
    AppMethodBeat.o(154015);
  }
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(154016);
    this.MSy.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
    AppMethodBeat.o(154016);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154005);
    this.MSy.getSettings().setJavaScriptEnabled(paramBoolean);
    AppMethodBeat.o(154005);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(154000);
    paramLayoutAlgorithm = com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm.values()[paramLayoutAlgorithm.ordinal()];
    this.MSy.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
    AppMethodBeat.o(154000);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(153995);
    this.MSy.getSettings().setLoadWithOverviewMode(paramBoolean);
    AppMethodBeat.o(153995);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(154002);
    this.MSy.getSettings().setLoadsImagesAutomatically(paramBoolean);
    AppMethodBeat.o(154002);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(153990);
    this.MSy.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
    AppMethodBeat.o(153990);
  }
  
  public final void setPluginsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154008);
    this.MSy.getSettings().setPluginsEnabled(paramBoolean);
    AppMethodBeat.o(154008);
  }
  
  public final void setRenderPriority(WebSettings.RenderPriority paramRenderPriority)
  {
    AppMethodBeat.i(154020);
    paramRenderPriority = com.tencent.smtt.sdk.WebSettings.RenderPriority.values()[paramRenderPriority.ordinal()];
    this.MSy.getSettings().setRenderPriority(paramRenderPriority);
    AppMethodBeat.o(154020);
  }
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(153989);
    this.MSy.getSettings().setSupportZoom(paramBoolean);
    AppMethodBeat.o(153989);
  }
  
  public final void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(153998);
    this.MSy.getSettings().setTextZoom(paramInt);
    AppMethodBeat.o(153998);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(153999);
    this.MSy.getSettings().setUseWideViewPort(paramBoolean);
    AppMethodBeat.o(153999);
  }
  
  public final void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(154018);
    this.MSy.getSettings().setUserAgentString(paramString);
    AppMethodBeat.o(154018);
  }
  
  public final void setUsingForAppBrand(int paramInt)
  {
    AppMethodBeat.i(154023);
    this.MSz = paramInt;
    if (this.MSy.getX5WebViewExtension() == null)
    {
      AppMethodBeat.o(154023);
      return;
    }
    switch (this.MSz)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(154023);
      return;
      Bundle localBundle1 = new Bundle(1);
      localBundle1.putInt("flag", 1);
      this.MSy.getX5WebViewExtension().invokeMiscMethod("setMiniProgramFlag", localBundle1);
      try
      {
        a.gB(this.MSy.getX5WebViewExtension()).A("setEnableAutoPageDiscarding", new Object[] { Boolean.FALSE });
        a.gB(this.MSy.getX5WebViewExtension()).A("setEnableAutoPageRestoration", new Object[] { Boolean.FALSE });
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
      this.MSy.getX5WebViewExtension().invokeMiscMethod("setMiniProgramFlag", localBundle2);
    }
  }
  
  public final void setVideoPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(153991);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("require", paramBoolean);
      a.gB(this.MSy.getX5WebViewExtension()).A("invokeMiscMethod", new Object[] { "setVideoPlaybackRequiresUserGesture", localBundle });
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