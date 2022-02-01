package com.tencent.xweb.pinus;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ad;
import com.tencent.xweb.pinus.sdk.WebSettingsInterface;
import com.tencent.xweb.pinus.sdk.WebView;
import java.util.Map;

public final class i
  extends ad
{
  private WebView ailc;
  
  public i(WebView paramWebView)
  {
    this.ailc = paramWebView;
  }
  
  public final void a(WebSettings.RenderPriority paramRenderPriority) {}
  
  public final void enableCustomizedLongPressTimeout(int paramInt)
  {
    AppMethodBeat.i(213640);
    this.ailc.getSettings().enableCustomizedLongPressTimeout(paramInt);
    AppMethodBeat.o(213640);
  }
  
  public final boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(213738);
    boolean bool = this.ailc.getSettings().getBlockNetworkImage();
    AppMethodBeat.o(213738);
    return bool;
  }
  
  public final int getForceDarkBehavior()
  {
    AppMethodBeat.i(213892);
    int i = this.ailc.getSettings().getForceDarkBehavior();
    AppMethodBeat.o(213892);
    return i;
  }
  
  public final int getForceDarkMode()
  {
    AppMethodBeat.i(213883);
    int i = this.ailc.getSettings().getForceDarkMode();
    AppMethodBeat.o(213883);
    return i;
  }
  
  public final int getTextZoom()
  {
    AppMethodBeat.i(213696);
    int i = this.ailc.getSettings().getTextZoom();
    AppMethodBeat.o(213696);
    return i;
  }
  
  public final String getUserAgentString()
  {
    AppMethodBeat.i(213846);
    String str = this.ailc.getSettings().getUserAgentString();
    AppMethodBeat.o(213846);
    return str;
  }
  
  public final void kfK()
  {
    AppMethodBeat.i(213653);
    this.ailc.getSettings().setDisplayZoomControls(false);
    AppMethodBeat.o(213653);
  }
  
  public final void kfL()
  {
    AppMethodBeat.i(213660);
    this.ailc.getSettings().setAllowFileAccess(true);
    AppMethodBeat.o(213660);
  }
  
  public final void kfM()
  {
    AppMethodBeat.i(213673);
    this.ailc.getSettings().setSaveFormData(false);
    AppMethodBeat.o(213673);
  }
  
  public final void kfN()
  {
    AppMethodBeat.i(213683);
    this.ailc.getSettings().setSavePassword(false);
    AppMethodBeat.o(213683);
  }
  
  public final void kfO()
  {
    AppMethodBeat.i(213717);
    this.ailc.getSettings().setDefaultFontSize(8);
    AppMethodBeat.o(213717);
  }
  
  public final void kfP()
  {
    AppMethodBeat.i(213772);
    this.ailc.getSettings().setAppCacheEnabled(true);
    AppMethodBeat.o(213772);
  }
  
  public final void kfQ()
  {
    AppMethodBeat.i(213789);
    this.ailc.getSettings().setAppCacheMaxSize(10485760L);
    AppMethodBeat.o(213789);
  }
  
  public final void kfR()
  {
    AppMethodBeat.i(213801);
    this.ailc.getSettings().setDatabaseEnabled(true);
    AppMethodBeat.o(213801);
  }
  
  public final void kfS()
  {
    AppMethodBeat.i(213811);
    this.ailc.getSettings().setDomStorageEnabled(true);
    AppMethodBeat.o(213811);
  }
  
  public final void kfT()
  {
    AppMethodBeat.i(213859);
    this.ailc.getSettings().setCacheMode(-1);
    AppMethodBeat.o(213859);
  }
  
  public final void kfU()
  {
    AppMethodBeat.i(213868);
    this.ailc.getSettings().setMixedContentMode(0);
    AppMethodBeat.o(213868);
  }
  
  public final void kfV()
  {
    AppMethodBeat.i(213904);
    this.ailc.getSettings().setBackgroundAudioPause(true);
    AppMethodBeat.o(213904);
  }
  
  public final void setAppBrandInfo(Map<String, String> paramMap)
  {
    AppMethodBeat.i(213898);
    this.ailc.getSettings().setAppBrandInfo(paramMap);
    AppMethodBeat.o(213898);
  }
  
  public final void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(213780);
    this.ailc.getSettings().setAppCachePath(paramString);
    AppMethodBeat.o(213780);
  }
  
  public final void setAudioPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(213622);
    this.ailc.getSettings().setAudioPlaybackRequiresUserGesture(paramBoolean);
    AppMethodBeat.o(213622);
  }
  
  public final void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(213731);
    this.ailc.getSettings().setBlockNetworkImage(paramBoolean);
    AppMethodBeat.o(213731);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(213647);
    this.ailc.getSettings().setBuiltInZoomControls(paramBoolean);
    AppMethodBeat.o(213647);
  }
  
  public final void setDatabasePath(String paramString)
  {
    AppMethodBeat.i(213765);
    this.ailc.getSettings().setDatabasePath(paramString);
    AppMethodBeat.o(213765);
  }
  
  public final void setDefaultTextEncodingName(String paramString)
  {
    AppMethodBeat.i(213835);
    this.ailc.getSettings().setDefaultTextEncodingName(paramString);
    AppMethodBeat.o(213835);
  }
  
  public final void setForceDarkBehavior(int paramInt)
  {
    AppMethodBeat.i(213888);
    this.ailc.getSettings().setForceDarkBehavior(paramInt);
    AppMethodBeat.o(213888);
  }
  
  public final void setForceDarkMode(int paramInt)
  {
    AppMethodBeat.i(213879);
    this.ailc.getSettings().setForceDarkMode(paramInt);
    AppMethodBeat.o(213879);
  }
  
  public final void setGeolocationEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(213819);
    this.ailc.getSettings().setGeolocationEnabled(paramBoolean);
    AppMethodBeat.o(213819);
  }
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(213828);
    this.ailc.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
    AppMethodBeat.o(213828);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(213750);
    this.ailc.getSettings().setJavaScriptEnabled(paramBoolean);
    AppMethodBeat.o(213750);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(213708);
    this.ailc.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
    AppMethodBeat.o(213708);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(213667);
    this.ailc.getSettings().setLoadWithOverviewMode(paramBoolean);
    AppMethodBeat.o(213667);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(213725);
    this.ailc.getSettings().setLoadsImagesAutomatically(paramBoolean);
    AppMethodBeat.o(213725);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(213613);
    this.ailc.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
    AppMethodBeat.o(213613);
  }
  
  public final void setPluginsEnabled(boolean paramBoolean) {}
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(213604);
    this.ailc.getSettings().setSupportZoom(paramBoolean);
    AppMethodBeat.o(213604);
  }
  
  public final void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(213688);
    this.ailc.getSettings().setTextZoom(paramInt);
    AppMethodBeat.o(213688);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(213702);
    this.ailc.getSettings().setUseWideViewPort(paramBoolean);
    AppMethodBeat.o(213702);
  }
  
  public final void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(213840);
    this.ailc.getSettings().setUserAgentString(paramString);
    AppMethodBeat.o(213840);
  }
  
  public final void setUsingForAppBrand(int paramInt)
  {
    AppMethodBeat.i(213873);
    this.ailc.getSettings().setUsingForAppBrand(paramInt);
    AppMethodBeat.o(213873);
  }
  
  public final void setVideoPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(213631);
    this.ailc.getSettings().setVideoPlaybackRequiresUserGesture(paramBoolean);
    AppMethodBeat.o(213631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.i
 * JD-Core Version:    0.7.0.1
 */