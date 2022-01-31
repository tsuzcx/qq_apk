package com.tencent.xweb.xwalk;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.t;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkView;

public final class k
  extends t
{
  XWalkView BKi;
  
  public k(XWalkView paramXWalkView)
  {
    this.BKi = paramXWalkView;
  }
  
  public final void dYq() {}
  
  public final void dYr()
  {
    AppMethodBeat.i(85352);
    this.BKi.getSettings().setSaveFormData(false);
    AppMethodBeat.o(85352);
  }
  
  public final void dYs() {}
  
  public final void dYt()
  {
    AppMethodBeat.i(85356);
    this.BKi.getSettings().setDefaultFontSize(8);
    AppMethodBeat.o(85356);
  }
  
  public final void dYu()
  {
    AppMethodBeat.i(85361);
    this.BKi.getSettings().setAppCacheEnabled(true);
    AppMethodBeat.o(85361);
  }
  
  public final void dYv() {}
  
  public final void dYw()
  {
    AppMethodBeat.i(85363);
    this.BKi.getSettings().setDatabaseEnabled(true);
    AppMethodBeat.o(85363);
  }
  
  public final void dYx()
  {
    AppMethodBeat.i(85364);
    this.BKi.getSettings().setDomStorageEnabled(true);
    AppMethodBeat.o(85364);
  }
  
  public final void dYy()
  {
    AppMethodBeat.i(85368);
    this.BKi.getSettings().setCacheMode(-1);
    AppMethodBeat.o(85368);
  }
  
  public final void dYz() {}
  
  public final boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(85359);
    boolean bool = this.BKi.getSettings().getBlockNetworkImage();
    AppMethodBeat.o(85359);
    return bool;
  }
  
  public final String getUserAgentString()
  {
    AppMethodBeat.i(85367);
    String str = this.BKi.getUserAgentString();
    AppMethodBeat.o(85367);
    return str;
  }
  
  public final void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(85362);
    this.BKi.getSettings().setAppCachePath(paramString);
    AppMethodBeat.o(85362);
  }
  
  public final void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(85358);
    this.BKi.getSettings().setBlockNetworkImage(paramBoolean);
    AppMethodBeat.o(85358);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(85350);
    this.BKi.getSettings().setBuiltInZoomControls(paramBoolean);
    AppMethodBeat.o(85350);
  }
  
  public final void setDatabasePath(String paramString) {}
  
  public final void setDefaultTextEncodingName(String paramString) {}
  
  public final void setGeolocationEnabled(boolean paramBoolean) {}
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(85365);
    this.BKi.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
    AppMethodBeat.o(85365);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(85360);
    this.BKi.getSettings().setJavaScriptEnabled(paramBoolean);
    AppMethodBeat.o(85360);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(85355);
    paramLayoutAlgorithm = org.xwalk.core.XWalkSettings.LayoutAlgorithm.values()[paramLayoutAlgorithm.ordinal()];
    this.BKi.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
    AppMethodBeat.o(85355);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(85351);
    this.BKi.getSettings().setLoadWithOverviewMode(paramBoolean);
    AppMethodBeat.o(85351);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(85357);
    this.BKi.getSettings().setLoadsImagesAutomatically(paramBoolean);
    AppMethodBeat.o(85357);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(85348);
    this.BKi.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
    AppMethodBeat.o(85348);
  }
  
  public final void setPluginsEnabled(boolean paramBoolean) {}
  
  public final void setRenderPriority(WebSettings.RenderPriority paramRenderPriority) {}
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(85347);
    this.BKi.getSettings().setSupportZoom(paramBoolean);
    AppMethodBeat.o(85347);
  }
  
  public final void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(85353);
    this.BKi.getSettings().setTextZoom(paramInt);
    AppMethodBeat.o(85353);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(85354);
    this.BKi.getSettings().setUseWideViewPort(paramBoolean);
    AppMethodBeat.o(85354);
  }
  
  public final void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(85366);
    this.BKi.getSettings().setUserAgentString(paramString);
    AppMethodBeat.o(85366);
  }
  
  public final void setUsingForAppBrand(int paramInt)
  {
    AppMethodBeat.i(85349);
    this.BKi.getSettings().setUsingForAppBrand(paramInt);
    AppMethodBeat.o(85349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.k
 * JD-Core Version:    0.7.0.1
 */