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
  WebView KDR;
  String KDS;
  
  public g(WebView paramWebView)
  {
    AppMethodBeat.i(153778);
    this.KDS = "";
    this.KDR = paramWebView;
    getUserAgentString();
    AppMethodBeat.o(153778);
  }
  
  public final void enableCustomizedLongPressTimeout(int paramInt) {}
  
  public final void fJA()
  {
    AppMethodBeat.i(153786);
    this.KDR.getSettings().setSavePassword(false);
    AppMethodBeat.o(153786);
  }
  
  public final void fJB()
  {
    AppMethodBeat.i(153790);
    this.KDR.getSettings().setDefaultFontSize(8);
    AppMethodBeat.o(153790);
  }
  
  public final void fJC()
  {
    AppMethodBeat.i(153795);
    this.KDR.getSettings().setAllowUniversalAccessFromFileURLs(true);
    AppMethodBeat.o(153795);
  }
  
  public final void fJD()
  {
    AppMethodBeat.i(153796);
    this.KDR.getSettings().setAllowFileAccessFromFileURLs(true);
    AppMethodBeat.o(153796);
  }
  
  public final void fJE()
  {
    AppMethodBeat.i(153799);
    this.KDR.getSettings().setAppCacheEnabled(true);
    AppMethodBeat.o(153799);
  }
  
  public final void fJF()
  {
    AppMethodBeat.i(153801);
    this.KDR.getSettings().setAppCacheMaxSize(10485760L);
    AppMethodBeat.o(153801);
  }
  
  public final void fJG()
  {
    AppMethodBeat.i(153802);
    this.KDR.getSettings().setDatabaseEnabled(true);
    AppMethodBeat.o(153802);
  }
  
  public final void fJH()
  {
    AppMethodBeat.i(153803);
    this.KDR.getSettings().setDomStorageEnabled(true);
    AppMethodBeat.o(153803);
  }
  
  public final void fJI()
  {
    AppMethodBeat.i(153810);
    this.KDR.getSettings().setCacheMode(-1);
    AppMethodBeat.o(153810);
  }
  
  public final void fJJ()
  {
    AppMethodBeat.i(153811);
    if (Build.VERSION.SDK_INT >= 21) {
      this.KDR.getSettings().setMixedContentMode(0);
    }
    AppMethodBeat.o(153811);
  }
  
  public final void fJx()
  {
    AppMethodBeat.i(153782);
    this.KDR.getSettings().setDisplayZoomControls(false);
    AppMethodBeat.o(153782);
  }
  
  public final void fJy()
  {
    AppMethodBeat.i(153783);
    this.KDR.getSettings().setAllowFileAccess(true);
    AppMethodBeat.o(153783);
  }
  
  public final void fJz()
  {
    AppMethodBeat.i(153785);
    this.KDR.getSettings().setSaveFormData(false);
    AppMethodBeat.o(153785);
  }
  
  public final boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(153793);
    boolean bool = this.KDR.getSettings().getBlockNetworkImage();
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
    if ((this.KDS == null) || (this.KDS.isEmpty())) {}
    try
    {
      this.KDS = this.KDR.getSettings().getUserAgentString();
      label36:
      String str = this.KDS;
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
    this.KDR.getSettings().setAppCachePath(paramString);
    AppMethodBeat.o(153800);
  }
  
  public final void setAudioPlaybackRequiresUserGesture(boolean paramBoolean) {}
  
  public final void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(153792);
    this.KDR.getSettings().setBlockNetworkImage(paramBoolean);
    AppMethodBeat.o(153792);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(153781);
    this.KDR.getSettings().setBuiltInZoomControls(paramBoolean);
    AppMethodBeat.o(153781);
  }
  
  public final void setDatabasePath(String paramString)
  {
    AppMethodBeat.i(153798);
    this.KDR.getSettings().setDatabasePath(paramString);
    AppMethodBeat.o(153798);
  }
  
  public final void setDefaultTextEncodingName(String paramString)
  {
    AppMethodBeat.i(153806);
    this.KDR.getSettings().setDefaultTextEncodingName(paramString);
    AppMethodBeat.o(153806);
  }
  
  public final void setForceDarkBehavior(int paramInt) {}
  
  public final void setForceDarkMode(int paramInt) {}
  
  public final void setGeolocationEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153804);
    this.KDR.getSettings().setGeolocationEnabled(paramBoolean);
    AppMethodBeat.o(153804);
  }
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(153805);
    this.KDR.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
    AppMethodBeat.o(153805);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153794);
    this.KDR.getSettings().setJavaScriptEnabled(paramBoolean);
    AppMethodBeat.o(153794);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(153789);
    this.KDR.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
    AppMethodBeat.o(153789);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(153784);
    this.KDR.getSettings().setLoadWithOverviewMode(paramBoolean);
    AppMethodBeat.o(153784);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(153791);
    this.KDR.getSettings().setLoadsImagesAutomatically(paramBoolean);
    AppMethodBeat.o(153791);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(153780);
    if (Build.VERSION.SDK_INT >= 17) {
      this.KDR.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
    }
    AppMethodBeat.o(153780);
  }
  
  public final void setPluginsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153797);
    f.c(this.KDR.getSettings(), "setPluginsEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(153797);
  }
  
  public final void setRenderPriority(WebSettings.RenderPriority paramRenderPriority)
  {
    AppMethodBeat.i(153809);
    this.KDR.getSettings().setRenderPriority(paramRenderPriority);
    AppMethodBeat.o(153809);
  }
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(153779);
    this.KDR.getSettings().setSupportZoom(paramBoolean);
    AppMethodBeat.o(153779);
  }
  
  public final void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(153787);
    this.KDR.getSettings().setTextZoom(paramInt);
    AppMethodBeat.o(153787);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(153788);
    this.KDR.getSettings().setUseWideViewPort(paramBoolean);
    AppMethodBeat.o(153788);
  }
  
  public final void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(153807);
    this.KDS = paramString;
    this.KDR.getSettings().setUserAgentString(paramString);
    AppMethodBeat.o(153807);
  }
  
  public final void setUsingForAppBrand(int paramInt) {}
  
  public final void setVideoPlaybackRequiresUserGesture(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.g
 * JD-Core Version:    0.7.0.1
 */