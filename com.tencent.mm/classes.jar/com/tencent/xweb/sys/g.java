package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.f;
import com.tencent.xweb.z;
import java.util.Map;

public final class g
  extends z
{
  WebView MRv;
  String MRw;
  
  public g(WebView paramWebView)
  {
    AppMethodBeat.i(153778);
    this.MRw = "";
    this.MRv = paramWebView;
    getUserAgentString();
    AppMethodBeat.o(153778);
  }
  
  public final void enableCustomizedLongPressTimeout(int paramInt) {}
  
  public final boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(153793);
    boolean bool = this.MRv.getSettings().getBlockNetworkImage();
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
    if ((this.MRw == null) || (this.MRw.isEmpty())) {}
    try
    {
      this.MRw = this.MRv.getSettings().getUserAgentString();
      label36:
      String str = this.MRw;
      AppMethodBeat.o(153808);
      return str;
    }
    catch (Exception localException)
    {
      break label36;
    }
  }
  
  public final void gfA()
  {
    AppMethodBeat.i(153799);
    this.MRv.getSettings().setAppCacheEnabled(true);
    AppMethodBeat.o(153799);
  }
  
  public final void gfB()
  {
    AppMethodBeat.i(153801);
    this.MRv.getSettings().setAppCacheMaxSize(10485760L);
    AppMethodBeat.o(153801);
  }
  
  public final void gfC()
  {
    AppMethodBeat.i(153802);
    this.MRv.getSettings().setDatabaseEnabled(true);
    AppMethodBeat.o(153802);
  }
  
  public final void gfD()
  {
    AppMethodBeat.i(153803);
    this.MRv.getSettings().setDomStorageEnabled(true);
    AppMethodBeat.o(153803);
  }
  
  public final void gfE()
  {
    AppMethodBeat.i(153810);
    this.MRv.getSettings().setCacheMode(-1);
    AppMethodBeat.o(153810);
  }
  
  public final void gfF()
  {
    AppMethodBeat.i(153811);
    if (Build.VERSION.SDK_INT >= 21) {
      this.MRv.getSettings().setMixedContentMode(0);
    }
    AppMethodBeat.o(153811);
  }
  
  public final void gft()
  {
    AppMethodBeat.i(153782);
    this.MRv.getSettings().setDisplayZoomControls(false);
    AppMethodBeat.o(153782);
  }
  
  public final void gfu()
  {
    AppMethodBeat.i(153783);
    this.MRv.getSettings().setAllowFileAccess(true);
    AppMethodBeat.o(153783);
  }
  
  public final void gfv()
  {
    AppMethodBeat.i(153785);
    this.MRv.getSettings().setSaveFormData(false);
    AppMethodBeat.o(153785);
  }
  
  public final void gfw()
  {
    AppMethodBeat.i(153786);
    this.MRv.getSettings().setSavePassword(false);
    AppMethodBeat.o(153786);
  }
  
  public final void gfx()
  {
    AppMethodBeat.i(153790);
    this.MRv.getSettings().setDefaultFontSize(8);
    AppMethodBeat.o(153790);
  }
  
  public final void gfy()
  {
    AppMethodBeat.i(153795);
    this.MRv.getSettings().setAllowUniversalAccessFromFileURLs(true);
    AppMethodBeat.o(153795);
  }
  
  public final void gfz()
  {
    AppMethodBeat.i(153796);
    this.MRv.getSettings().setAllowFileAccessFromFileURLs(true);
    AppMethodBeat.o(153796);
  }
  
  public final void setAppBrandInfo(Map<String, String> paramMap) {}
  
  public final void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(153800);
    this.MRv.getSettings().setAppCachePath(paramString);
    AppMethodBeat.o(153800);
  }
  
  public final void setAudioPlaybackRequiresUserGesture(boolean paramBoolean) {}
  
  public final void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(153792);
    this.MRv.getSettings().setBlockNetworkImage(paramBoolean);
    AppMethodBeat.o(153792);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(153781);
    this.MRv.getSettings().setBuiltInZoomControls(paramBoolean);
    AppMethodBeat.o(153781);
  }
  
  public final void setDatabasePath(String paramString)
  {
    AppMethodBeat.i(153798);
    this.MRv.getSettings().setDatabasePath(paramString);
    AppMethodBeat.o(153798);
  }
  
  public final void setDefaultTextEncodingName(String paramString)
  {
    AppMethodBeat.i(153806);
    this.MRv.getSettings().setDefaultTextEncodingName(paramString);
    AppMethodBeat.o(153806);
  }
  
  public final void setForceDarkBehavior(int paramInt) {}
  
  public final void setForceDarkMode(int paramInt) {}
  
  public final void setGeolocationEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153804);
    this.MRv.getSettings().setGeolocationEnabled(paramBoolean);
    AppMethodBeat.o(153804);
  }
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(153805);
    this.MRv.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
    AppMethodBeat.o(153805);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153794);
    this.MRv.getSettings().setJavaScriptEnabled(paramBoolean);
    AppMethodBeat.o(153794);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(153789);
    this.MRv.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
    AppMethodBeat.o(153789);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(153784);
    this.MRv.getSettings().setLoadWithOverviewMode(paramBoolean);
    AppMethodBeat.o(153784);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(153791);
    this.MRv.getSettings().setLoadsImagesAutomatically(paramBoolean);
    AppMethodBeat.o(153791);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(153780);
    if (Build.VERSION.SDK_INT >= 17) {
      this.MRv.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
    }
    AppMethodBeat.o(153780);
  }
  
  public final void setPluginsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(153797);
    f.c(this.MRv.getSettings(), "setPluginsEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(153797);
  }
  
  public final void setRenderPriority(WebSettings.RenderPriority paramRenderPriority)
  {
    AppMethodBeat.i(153809);
    this.MRv.getSettings().setRenderPriority(paramRenderPriority);
    AppMethodBeat.o(153809);
  }
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(153779);
    this.MRv.getSettings().setSupportZoom(paramBoolean);
    AppMethodBeat.o(153779);
  }
  
  public final void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(153787);
    this.MRv.getSettings().setTextZoom(paramInt);
    AppMethodBeat.o(153787);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(153788);
    this.MRv.getSettings().setUseWideViewPort(paramBoolean);
    AppMethodBeat.o(153788);
  }
  
  public final void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(153807);
    this.MRw = paramString;
    this.MRv.getSettings().setUserAgentString(paramString);
    AppMethodBeat.o(153807);
  }
  
  public final void setUsingForAppBrand(int paramInt) {}
  
  public final void setVideoPlaybackRequiresUserGesture(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.g
 * JD-Core Version:    0.7.0.1
 */