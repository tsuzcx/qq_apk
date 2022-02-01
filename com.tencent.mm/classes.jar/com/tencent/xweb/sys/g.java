package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.f;
import com.tencent.xweb.z;

public final class g
  extends z
{
  WebView Mur;
  String Mus;
  
  public g(WebView paramWebView)
  {
    AppMethodBeat.i(153778);
    this.Mus = "";
    this.Mur = paramWebView;
    getUserAgentString();
    AppMethodBeat.o(153778);
  }
  
  public final void enableCustomizedLongPressTimeout(int paramInt) {}
  
  public final void gaR()
  {
    AppMethodBeat.i(153782);
    this.Mur.getSettings().setDisplayZoomControls(false);
    AppMethodBeat.o(153782);
  }
  
  public final void gaS()
  {
    AppMethodBeat.i(153783);
    this.Mur.getSettings().setAllowFileAccess(true);
    AppMethodBeat.o(153783);
  }
  
  public final void gaT()
  {
    AppMethodBeat.i(153785);
    this.Mur.getSettings().setSaveFormData(false);
    AppMethodBeat.o(153785);
  }
  
  public final void gaU()
  {
    AppMethodBeat.i(153786);
    this.Mur.getSettings().setSavePassword(false);
    AppMethodBeat.o(153786);
  }
  
  public final void gaV()
  {
    AppMethodBeat.i(153790);
    this.Mur.getSettings().setDefaultFontSize(8);
    AppMethodBeat.o(153790);
  }
  
  public final void gaW()
  {
    AppMethodBeat.i(153795);
    this.Mur.getSettings().setAllowUniversalAccessFromFileURLs(true);
    AppMethodBeat.o(153795);
  }
  
  public final void gaX()
  {
    AppMethodBeat.i(153796);
    this.Mur.getSettings().setAllowFileAccessFromFileURLs(true);
    AppMethodBeat.o(153796);
  }
  
  public final void gaY()
  {
    AppMethodBeat.i(153799);
    this.Mur.getSettings().setAppCacheEnabled(true);
    AppMethodBeat.o(153799);
  }
  
  public final void gaZ()
  {
    AppMethodBeat.i(153801);
    this.Mur.getSettings().setAppCacheMaxSize(10485760L);
    AppMethodBeat.o(153801);
  }
  
  public final void gba()
  {
    AppMethodBeat.i(153802);
    this.Mur.getSettings().setDatabaseEnabled(true);
    AppMethodBeat.o(153802);
  }
  
  public final void gbb()
  {
    AppMethodBeat.i(153803);
    this.Mur.getSettings().setDomStorageEnabled(true);
    AppMethodBeat.o(153803);
  }
  
  public final void gbc()
  {
    AppMethodBeat.i(153810);
    this.Mur.getSettings().setCacheMode(-1);
    AppMethodBeat.o(153810);
  }
  
  public final void gbd()
  {
    AppMethodBeat.i(153811);
    if (Build.VERSION.SDK_INT >= 21) {
      this.Mur.getSettings().setMixedContentMode(0);
    }
    AppMethodBeat.o(153811);
  }
  
  public final boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(153793);
    boolean bool = this.Mur.getSettings().getBlockNetworkImage();
    AppMethodBeat.o(153793);
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
    AppMethodBeat.i(153808);
    if ((this.Mus == null) || (this.Mus.isEmpty())) {}
    try
    {
      this.Mus = this.Mur.getSettings().getUserAgentString();
      label36:
      String str = this.Mus;
      AppMethodBeat.o(153808);
      return str;
    }
    catch (Exception localException)
    {
      break label36;
    }
  }
  
  public final void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(153800);
    this.Mur.getSettings().setAppCachePath(paramString);
    AppMethodBeat.o(153800);
  }
  
  public final void setAudioPlaybackRequiresUserGesture(boolean paramBoolean) {}
  
  public final void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(153792);
    this.Mur.getSettings().setBlockNetworkImage(paramBoolean);
    AppMethodBeat.o(153792);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(153781);
    this.Mur.getSettings().setBuiltInZoomControls(paramBoolean);
    AppMethodBeat.o(153781);
  }
  
  public final void setDatabasePath(String paramString)
  {
    AppMethodBeat.i(153798);
    this.Mur.getSettings().setDatabasePath(paramString);
    AppMethodBeat.o(153798);
  }
  
  public final void setDefaultTextEncodingName(String paramString)
  {
    AppMethodBeat.i(153806);
    this.Mur.getSettings().setDefaultTextEncodingName(paramString);
    AppMethodBeat.o(153806);
  }
  
  public final void setForceDarkBehavior(int paramInt) {}
  
  public final void setForceDarkMode(int paramInt) {}
  
  public final void setGeolocationEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153804);
    this.Mur.getSettings().setGeolocationEnabled(paramBoolean);
    AppMethodBeat.o(153804);
  }
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(153805);
    this.Mur.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
    AppMethodBeat.o(153805);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153794);
    this.Mur.getSettings().setJavaScriptEnabled(paramBoolean);
    AppMethodBeat.o(153794);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(153789);
    this.Mur.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
    AppMethodBeat.o(153789);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(153784);
    this.Mur.getSettings().setLoadWithOverviewMode(paramBoolean);
    AppMethodBeat.o(153784);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(153791);
    this.Mur.getSettings().setLoadsImagesAutomatically(paramBoolean);
    AppMethodBeat.o(153791);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(153780);
    if (Build.VERSION.SDK_INT >= 17) {
      this.Mur.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
    }
    AppMethodBeat.o(153780);
  }
  
  public final void setPluginsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153797);
    f.c(this.Mur.getSettings(), "setPluginsEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(153797);
  }
  
  public final void setRenderPriority(WebSettings.RenderPriority paramRenderPriority)
  {
    AppMethodBeat.i(153809);
    this.Mur.getSettings().setRenderPriority(paramRenderPriority);
    AppMethodBeat.o(153809);
  }
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(153779);
    this.Mur.getSettings().setSupportZoom(paramBoolean);
    AppMethodBeat.o(153779);
  }
  
  public final void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(153787);
    this.Mur.getSettings().setTextZoom(paramInt);
    AppMethodBeat.o(153787);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(153788);
    this.Mur.getSettings().setUseWideViewPort(paramBoolean);
    AppMethodBeat.o(153788);
  }
  
  public final void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(153807);
    this.Mus = paramString;
    this.Mur.getSettings().setUserAgentString(paramString);
    AppMethodBeat.o(153807);
  }
  
  public final void setUsingForAppBrand(int paramInt) {}
  
  public final void setVideoPlaybackRequiresUserGesture(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.g
 * JD-Core Version:    0.7.0.1
 */