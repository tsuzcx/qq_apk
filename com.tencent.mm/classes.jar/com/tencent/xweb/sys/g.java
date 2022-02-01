package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.z;
import java.util.Map;

public final class g
  extends z
{
  String SEA;
  WebView SEz;
  
  public g(WebView paramWebView)
  {
    AppMethodBeat.i(153778);
    this.SEA = "";
    this.SEz = paramWebView;
    getUserAgentString();
    AppMethodBeat.o(153778);
  }
  
  public final void enableCustomizedLongPressTimeout(int paramInt) {}
  
  public final boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(153793);
    boolean bool = this.SEz.getSettings().getBlockNetworkImage();
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
    if ((this.SEA == null) || (this.SEA.isEmpty())) {}
    try
    {
      this.SEA = this.SEz.getSettings().getUserAgentString();
      label36:
      String str = this.SEA;
      AppMethodBeat.o(153808);
      return str;
    }
    catch (Exception localException)
    {
      break label36;
    }
  }
  
  public final void hsK()
  {
    AppMethodBeat.i(153782);
    this.SEz.getSettings().setDisplayZoomControls(false);
    AppMethodBeat.o(153782);
  }
  
  public final void hsL()
  {
    AppMethodBeat.i(153783);
    this.SEz.getSettings().setAllowFileAccess(true);
    AppMethodBeat.o(153783);
  }
  
  public final void hsM()
  {
    AppMethodBeat.i(153785);
    this.SEz.getSettings().setSaveFormData(false);
    AppMethodBeat.o(153785);
  }
  
  public final void hsN()
  {
    AppMethodBeat.i(153786);
    this.SEz.getSettings().setSavePassword(false);
    AppMethodBeat.o(153786);
  }
  
  public final void hsO()
  {
    AppMethodBeat.i(153790);
    this.SEz.getSettings().setDefaultFontSize(8);
    AppMethodBeat.o(153790);
  }
  
  public final void hsP()
  {
    AppMethodBeat.i(153795);
    this.SEz.getSettings().setAllowUniversalAccessFromFileURLs(true);
    AppMethodBeat.o(153795);
  }
  
  public final void hsQ()
  {
    AppMethodBeat.i(153796);
    this.SEz.getSettings().setAllowFileAccessFromFileURLs(true);
    AppMethodBeat.o(153796);
  }
  
  public final void hsR()
  {
    AppMethodBeat.i(153799);
    this.SEz.getSettings().setAppCacheEnabled(true);
    AppMethodBeat.o(153799);
  }
  
  public final void hsS()
  {
    AppMethodBeat.i(153801);
    this.SEz.getSettings().setAppCacheMaxSize(10485760L);
    AppMethodBeat.o(153801);
  }
  
  public final void hsT()
  {
    AppMethodBeat.i(153802);
    this.SEz.getSettings().setDatabaseEnabled(true);
    AppMethodBeat.o(153802);
  }
  
  public final void hsU()
  {
    AppMethodBeat.i(153803);
    this.SEz.getSettings().setDomStorageEnabled(true);
    AppMethodBeat.o(153803);
  }
  
  public final void hsV()
  {
    AppMethodBeat.i(153810);
    this.SEz.getSettings().setCacheMode(-1);
    AppMethodBeat.o(153810);
  }
  
  public final void hsW()
  {
    AppMethodBeat.i(153811);
    if (Build.VERSION.SDK_INT >= 21) {
      this.SEz.getSettings().setMixedContentMode(0);
    }
    AppMethodBeat.o(153811);
  }
  
  public final void hsX() {}
  
  public final void setAppBrandInfo(Map<String, String> paramMap) {}
  
  public final void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(153800);
    this.SEz.getSettings().setAppCachePath(paramString);
    AppMethodBeat.o(153800);
  }
  
  public final void setAudioPlaybackRequiresUserGesture(boolean paramBoolean) {}
  
  public final void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(153792);
    this.SEz.getSettings().setBlockNetworkImage(paramBoolean);
    AppMethodBeat.o(153792);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(153781);
    this.SEz.getSettings().setBuiltInZoomControls(paramBoolean);
    AppMethodBeat.o(153781);
  }
  
  public final void setDatabasePath(String paramString)
  {
    AppMethodBeat.i(153798);
    this.SEz.getSettings().setDatabasePath(paramString);
    AppMethodBeat.o(153798);
  }
  
  public final void setDefaultTextEncodingName(String paramString)
  {
    AppMethodBeat.i(153806);
    this.SEz.getSettings().setDefaultTextEncodingName(paramString);
    AppMethodBeat.o(153806);
  }
  
  public final void setForceDarkBehavior(int paramInt) {}
  
  public final void setForceDarkMode(int paramInt) {}
  
  public final void setGeolocationEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153804);
    this.SEz.getSettings().setGeolocationEnabled(paramBoolean);
    AppMethodBeat.o(153804);
  }
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(153805);
    this.SEz.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
    AppMethodBeat.o(153805);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153794);
    this.SEz.getSettings().setJavaScriptEnabled(paramBoolean);
    AppMethodBeat.o(153794);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(153789);
    this.SEz.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
    AppMethodBeat.o(153789);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(153784);
    this.SEz.getSettings().setLoadWithOverviewMode(paramBoolean);
    AppMethodBeat.o(153784);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(153791);
    this.SEz.getSettings().setLoadsImagesAutomatically(paramBoolean);
    AppMethodBeat.o(153791);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(153780);
    if (Build.VERSION.SDK_INT >= 17) {
      this.SEz.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
    }
    AppMethodBeat.o(153780);
  }
  
  public final void setPluginsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153797);
    com.tencent.xweb.util.g.c(this.SEz.getSettings(), "setPluginsEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(153797);
  }
  
  public final void setRenderPriority(WebSettings.RenderPriority paramRenderPriority)
  {
    AppMethodBeat.i(153809);
    this.SEz.getSettings().setRenderPriority(paramRenderPriority);
    AppMethodBeat.o(153809);
  }
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(153779);
    this.SEz.getSettings().setSupportZoom(paramBoolean);
    AppMethodBeat.o(153779);
  }
  
  public final void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(153787);
    this.SEz.getSettings().setTextZoom(paramInt);
    AppMethodBeat.o(153787);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(153788);
    this.SEz.getSettings().setUseWideViewPort(paramBoolean);
    AppMethodBeat.o(153788);
  }
  
  public final void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(153807);
    this.SEA = paramString;
    this.SEz.getSettings().setUserAgentString(paramString);
    AppMethodBeat.o(153807);
  }
  
  public final void setUsingForAppBrand(int paramInt) {}
  
  public final void setVideoPlaybackRequiresUserGesture(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.sys.g
 * JD-Core Version:    0.7.0.1
 */