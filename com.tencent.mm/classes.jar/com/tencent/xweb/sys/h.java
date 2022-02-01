package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ad;
import com.tencent.xweb.util.k;
import java.util.Map;
import org.xwalk.core.Log;

public final class h
  extends ad
{
  private WebView aimt;
  String aimu;
  
  public h(WebView paramWebView)
  {
    AppMethodBeat.i(153778);
    this.aimu = "";
    this.aimt = paramWebView;
    getUserAgentString();
    AppMethodBeat.o(153778);
  }
  
  public final void a(WebSettings.RenderPriority paramRenderPriority)
  {
    AppMethodBeat.i(153809);
    this.aimt.getSettings().setRenderPriority(paramRenderPriority);
    AppMethodBeat.o(153809);
  }
  
  public final void enableCustomizedLongPressTimeout(int paramInt) {}
  
  public final boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(153793);
    boolean bool = this.aimt.getSettings().getBlockNetworkImage();
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
  
  public final int getTextZoom()
  {
    AppMethodBeat.i(212676);
    int i = this.aimt.getSettings().getTextZoom();
    AppMethodBeat.o(212676);
    return i;
  }
  
  public final String getUserAgentString()
  {
    AppMethodBeat.i(153808);
    if ((this.aimu == null) || (this.aimu.isEmpty())) {}
    try
    {
      this.aimu = this.aimt.getSettings().getUserAgentString();
      String str = this.aimu;
      AppMethodBeat.o(153808);
      return str;
    }
    finally
    {
      for (;;)
      {
        Log.e("SysWebViewSettings", "getUserAgentString error:".concat(String.valueOf(localObject)));
      }
    }
  }
  
  public final void kfK()
  {
    AppMethodBeat.i(153782);
    this.aimt.getSettings().setDisplayZoomControls(false);
    AppMethodBeat.o(153782);
  }
  
  public final void kfL()
  {
    AppMethodBeat.i(153783);
    this.aimt.getSettings().setAllowFileAccess(true);
    AppMethodBeat.o(153783);
  }
  
  public final void kfM()
  {
    AppMethodBeat.i(153785);
    this.aimt.getSettings().setSaveFormData(false);
    AppMethodBeat.o(153785);
  }
  
  public final void kfN()
  {
    AppMethodBeat.i(153786);
    this.aimt.getSettings().setSavePassword(false);
    AppMethodBeat.o(153786);
  }
  
  public final void kfO()
  {
    AppMethodBeat.i(153790);
    this.aimt.getSettings().setDefaultFontSize(8);
    AppMethodBeat.o(153790);
  }
  
  public final void kfP()
  {
    AppMethodBeat.i(153799);
    this.aimt.getSettings().setAppCacheEnabled(true);
    AppMethodBeat.o(153799);
  }
  
  public final void kfQ()
  {
    AppMethodBeat.i(153801);
    this.aimt.getSettings().setAppCacheMaxSize(10485760L);
    AppMethodBeat.o(153801);
  }
  
  public final void kfR()
  {
    AppMethodBeat.i(153802);
    this.aimt.getSettings().setDatabaseEnabled(true);
    AppMethodBeat.o(153802);
  }
  
  public final void kfS()
  {
    AppMethodBeat.i(153803);
    this.aimt.getSettings().setDomStorageEnabled(true);
    AppMethodBeat.o(153803);
  }
  
  public final void kfT()
  {
    AppMethodBeat.i(153810);
    this.aimt.getSettings().setCacheMode(-1);
    AppMethodBeat.o(153810);
  }
  
  public final void kfU()
  {
    AppMethodBeat.i(153811);
    if (Build.VERSION.SDK_INT >= 21) {
      this.aimt.getSettings().setMixedContentMode(0);
    }
    AppMethodBeat.o(153811);
  }
  
  public final void kfV() {}
  
  public final void setAppBrandInfo(Map<String, String> paramMap) {}
  
  public final void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(153800);
    this.aimt.getSettings().setAppCachePath(paramString);
    AppMethodBeat.o(153800);
  }
  
  public final void setAudioPlaybackRequiresUserGesture(boolean paramBoolean) {}
  
  public final void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(153792);
    this.aimt.getSettings().setBlockNetworkImage(paramBoolean);
    AppMethodBeat.o(153792);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(153781);
    this.aimt.getSettings().setBuiltInZoomControls(paramBoolean);
    AppMethodBeat.o(153781);
  }
  
  public final void setDatabasePath(String paramString)
  {
    AppMethodBeat.i(153798);
    this.aimt.getSettings().setDatabasePath(paramString);
    AppMethodBeat.o(153798);
  }
  
  public final void setDefaultTextEncodingName(String paramString)
  {
    AppMethodBeat.i(153806);
    this.aimt.getSettings().setDefaultTextEncodingName(paramString);
    AppMethodBeat.o(153806);
  }
  
  public final void setForceDarkBehavior(int paramInt) {}
  
  public final void setForceDarkMode(int paramInt) {}
  
  public final void setGeolocationEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153804);
    this.aimt.getSettings().setGeolocationEnabled(paramBoolean);
    AppMethodBeat.o(153804);
  }
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(153805);
    this.aimt.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
    AppMethodBeat.o(153805);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153794);
    this.aimt.getSettings().setJavaScriptEnabled(paramBoolean);
    AppMethodBeat.o(153794);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(153789);
    this.aimt.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
    AppMethodBeat.o(153789);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(153784);
    this.aimt.getSettings().setLoadWithOverviewMode(paramBoolean);
    AppMethodBeat.o(153784);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(153791);
    this.aimt.getSettings().setLoadsImagesAutomatically(paramBoolean);
    AppMethodBeat.o(153791);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(153780);
    if (Build.VERSION.SDK_INT >= 17) {
      this.aimt.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
    }
    AppMethodBeat.o(153780);
  }
  
  public final void setPluginsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153797);
    k.c(this.aimt.getSettings(), "setPluginsEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(153797);
  }
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(153779);
    this.aimt.getSettings().setSupportZoom(paramBoolean);
    AppMethodBeat.o(153779);
  }
  
  public final void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(153787);
    this.aimt.getSettings().setTextZoom(paramInt);
    AppMethodBeat.o(153787);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(153788);
    this.aimt.getSettings().setUseWideViewPort(paramBoolean);
    AppMethodBeat.o(153788);
  }
  
  public final void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(153807);
    this.aimu = paramString;
    this.aimt.getSettings().setUserAgentString(paramString);
    AppMethodBeat.o(153807);
  }
  
  public final void setUsingForAppBrand(int paramInt) {}
  
  public final void setVideoPlaybackRequiresUserGesture(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.sys.h
 * JD-Core Version:    0.7.0.1
 */