package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.t;
import com.tencent.xweb.util.e;

public final class f
  extends t
{
  WebView BHH;
  String BHI;
  
  public f(WebView paramWebView)
  {
    AppMethodBeat.i(84746);
    this.BHI = "";
    this.BHH = paramWebView;
    getUserAgentString();
    AppMethodBeat.o(84746);
  }
  
  public final void dYq()
  {
    AppMethodBeat.i(84750);
    this.BHH.getSettings().setDisplayZoomControls(false);
    AppMethodBeat.o(84750);
  }
  
  public final void dYr()
  {
    AppMethodBeat.i(84752);
    this.BHH.getSettings().setSaveFormData(false);
    AppMethodBeat.o(84752);
  }
  
  public final void dYs()
  {
    AppMethodBeat.i(84753);
    this.BHH.getSettings().setSavePassword(false);
    AppMethodBeat.o(84753);
  }
  
  public final void dYt()
  {
    AppMethodBeat.i(84757);
    this.BHH.getSettings().setDefaultFontSize(8);
    AppMethodBeat.o(84757);
  }
  
  public final void dYu()
  {
    AppMethodBeat.i(84764);
    this.BHH.getSettings().setAppCacheEnabled(true);
    AppMethodBeat.o(84764);
  }
  
  public final void dYv()
  {
    AppMethodBeat.i(84766);
    this.BHH.getSettings().setAppCacheMaxSize(10485760L);
    AppMethodBeat.o(84766);
  }
  
  public final void dYw()
  {
    AppMethodBeat.i(84767);
    this.BHH.getSettings().setDatabaseEnabled(true);
    AppMethodBeat.o(84767);
  }
  
  public final void dYx()
  {
    AppMethodBeat.i(84768);
    this.BHH.getSettings().setDomStorageEnabled(true);
    AppMethodBeat.o(84768);
  }
  
  public final void dYy()
  {
    AppMethodBeat.i(84775);
    this.BHH.getSettings().setCacheMode(-1);
    AppMethodBeat.o(84775);
  }
  
  public final void dYz()
  {
    AppMethodBeat.i(84776);
    if (Build.VERSION.SDK_INT >= 21) {
      this.BHH.getSettings().setMixedContentMode(0);
    }
    AppMethodBeat.o(84776);
  }
  
  public final boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(84760);
    boolean bool = this.BHH.getSettings().getBlockNetworkImage();
    AppMethodBeat.o(84760);
    return bool;
  }
  
  public final String getUserAgentString()
  {
    AppMethodBeat.i(84773);
    if ((this.BHI == null) || (this.BHI.isEmpty())) {}
    try
    {
      this.BHI = this.BHH.getSettings().getUserAgentString();
      label36:
      String str = this.BHI;
      AppMethodBeat.o(84773);
      return str;
    }
    catch (Exception localException)
    {
      break label36;
    }
  }
  
  public final void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(84765);
    this.BHH.getSettings().setAppCachePath(paramString);
    AppMethodBeat.o(84765);
  }
  
  public final void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(84759);
    this.BHH.getSettings().setBlockNetworkImage(paramBoolean);
    AppMethodBeat.o(84759);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(84749);
    this.BHH.getSettings().setBuiltInZoomControls(paramBoolean);
    AppMethodBeat.o(84749);
  }
  
  public final void setDatabasePath(String paramString)
  {
    AppMethodBeat.i(84763);
    this.BHH.getSettings().setDatabasePath(paramString);
    AppMethodBeat.o(84763);
  }
  
  public final void setDefaultTextEncodingName(String paramString)
  {
    AppMethodBeat.i(84771);
    this.BHH.getSettings().setDefaultTextEncodingName(paramString);
    AppMethodBeat.o(84771);
  }
  
  public final void setGeolocationEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(84769);
    this.BHH.getSettings().setGeolocationEnabled(paramBoolean);
    AppMethodBeat.o(84769);
  }
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(84770);
    this.BHH.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
    AppMethodBeat.o(84770);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(84761);
    this.BHH.getSettings().setJavaScriptEnabled(paramBoolean);
    AppMethodBeat.o(84761);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(84756);
    this.BHH.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
    AppMethodBeat.o(84756);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(84751);
    this.BHH.getSettings().setLoadWithOverviewMode(paramBoolean);
    AppMethodBeat.o(84751);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(84758);
    this.BHH.getSettings().setLoadsImagesAutomatically(paramBoolean);
    AppMethodBeat.o(84758);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(84748);
    if (Build.VERSION.SDK_INT >= 17) {
      this.BHH.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
    }
    AppMethodBeat.o(84748);
  }
  
  public final void setPluginsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(84762);
    e.c(this.BHH.getSettings(), "setPluginsEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(84762);
  }
  
  public final void setRenderPriority(WebSettings.RenderPriority paramRenderPriority)
  {
    AppMethodBeat.i(84774);
    this.BHH.getSettings().setRenderPriority(paramRenderPriority);
    AppMethodBeat.o(84774);
  }
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(84747);
    this.BHH.getSettings().setSupportZoom(paramBoolean);
    AppMethodBeat.o(84747);
  }
  
  public final void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(84754);
    this.BHH.getSettings().setTextZoom(paramInt);
    AppMethodBeat.o(84754);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(84755);
    this.BHH.getSettings().setUseWideViewPort(paramBoolean);
    AppMethodBeat.o(84755);
  }
  
  public final void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(84772);
    this.BHI = paramString;
    this.BHH.getSettings().setUserAgentString(paramString);
    AppMethodBeat.o(84772);
  }
  
  public final void setUsingForAppBrand(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.sys.f
 * JD-Core Version:    0.7.0.1
 */