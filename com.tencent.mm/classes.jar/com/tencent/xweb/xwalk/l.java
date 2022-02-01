package com.tencent.xweb.xwalk;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.z;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkView;

public final class l
  extends z
{
  XWalkView KGU;
  
  public l(XWalkView paramXWalkView)
  {
    this.KGU = paramXWalkView;
  }
  
  public final void enableCustomizedLongPressTimeout(int paramInt)
  {
    AppMethodBeat.i(208924);
    this.KGU.getSettings().enableCustomizedLongPressTimeout(paramInt);
    AppMethodBeat.o(208924);
  }
  
  public final void fJA() {}
  
  public final void fJB()
  {
    AppMethodBeat.i(154432);
    this.KGU.getSettings().setDefaultFontSize(8);
    AppMethodBeat.o(154432);
  }
  
  public final void fJC()
  {
    AppMethodBeat.i(154437);
    this.KGU.getSettings().setAllowUniversalAccessFromFileURLs(true);
    AppMethodBeat.o(154437);
  }
  
  public final void fJD()
  {
    AppMethodBeat.i(154438);
    this.KGU.getSettings().setAllowFileAccessFromFileURLs(true);
    AppMethodBeat.o(154438);
  }
  
  public final void fJE()
  {
    AppMethodBeat.i(154439);
    this.KGU.getSettings().setAppCacheEnabled(true);
    AppMethodBeat.o(154439);
  }
  
  public final void fJF() {}
  
  public final void fJG()
  {
    AppMethodBeat.i(154441);
    this.KGU.getSettings().setDatabaseEnabled(true);
    AppMethodBeat.o(154441);
  }
  
  public final void fJH()
  {
    AppMethodBeat.i(154442);
    this.KGU.getSettings().setDomStorageEnabled(true);
    AppMethodBeat.o(154442);
  }
  
  public final void fJI()
  {
    AppMethodBeat.i(154446);
    this.KGU.getSettings().setCacheMode(-1);
    AppMethodBeat.o(154446);
  }
  
  public final void fJJ() {}
  
  public final void fJx() {}
  
  public final void fJy()
  {
    AppMethodBeat.i(154426);
    this.KGU.getSettings().setAllowFileAccess(true);
    AppMethodBeat.o(154426);
  }
  
  public final void fJz()
  {
    AppMethodBeat.i(154428);
    this.KGU.getSettings().setSaveFormData(false);
    AppMethodBeat.o(154428);
  }
  
  public final boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(154435);
    boolean bool = this.KGU.getSettings().getBlockNetworkImage();
    AppMethodBeat.o(154435);
    return bool;
  }
  
  public final int getForceDarkBehavior()
  {
    AppMethodBeat.i(154450);
    int i = this.KGU.getSettings().getForceDarkBehavior();
    AppMethodBeat.o(154450);
    return i;
  }
  
  public final int getForceDarkMode()
  {
    AppMethodBeat.i(154448);
    int i = this.KGU.getSettings().getForceDarkMode();
    AppMethodBeat.o(154448);
    return i;
  }
  
  public final String getUserAgentString()
  {
    AppMethodBeat.i(154445);
    String str = this.KGU.getSettings().getUserAgentString();
    AppMethodBeat.o(154445);
    return str;
  }
  
  public final void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(154440);
    this.KGU.getSettings().setAppCachePath(paramString);
    AppMethodBeat.o(154440);
  }
  
  public final void setAudioPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(183741);
    this.KGU.getSettings().setAudioPlaybackRequiresUserGesture(paramBoolean);
    AppMethodBeat.o(183741);
  }
  
  public final void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(154434);
    this.KGU.getSettings().setBlockNetworkImage(paramBoolean);
    AppMethodBeat.o(154434);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(154425);
    this.KGU.getSettings().setBuiltInZoomControls(paramBoolean);
    AppMethodBeat.o(154425);
  }
  
  public final void setDatabasePath(String paramString) {}
  
  public final void setDefaultTextEncodingName(String paramString) {}
  
  public final void setForceDarkBehavior(int paramInt)
  {
    AppMethodBeat.i(154449);
    this.KGU.getSettings().setForceDarkBehavior(paramInt);
    AppMethodBeat.o(154449);
  }
  
  public final void setForceDarkMode(int paramInt)
  {
    AppMethodBeat.i(154447);
    this.KGU.getSettings().setForceDarkMode(paramInt);
    AppMethodBeat.o(154447);
  }
  
  public final void setGeolocationEnabled(boolean paramBoolean) {}
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(154443);
    this.KGU.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
    AppMethodBeat.o(154443);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154436);
    this.KGU.getSettings().setJavaScriptEnabled(paramBoolean);
    AppMethodBeat.o(154436);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(154431);
    paramLayoutAlgorithm = org.xwalk.core.XWalkSettings.LayoutAlgorithm.values()[paramLayoutAlgorithm.ordinal()];
    this.KGU.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
    AppMethodBeat.o(154431);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(154427);
    this.KGU.getSettings().setLoadWithOverviewMode(paramBoolean);
    AppMethodBeat.o(154427);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(154433);
    this.KGU.getSettings().setLoadsImagesAutomatically(paramBoolean);
    AppMethodBeat.o(154433);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(154422);
    this.KGU.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
    AppMethodBeat.o(154422);
  }
  
  public final void setPluginsEnabled(boolean paramBoolean) {}
  
  public final void setRenderPriority(WebSettings.RenderPriority paramRenderPriority) {}
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(154421);
    this.KGU.getSettings().setSupportZoom(paramBoolean);
    AppMethodBeat.o(154421);
  }
  
  public final void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(154429);
    this.KGU.getSettings().setTextZoom(paramInt);
    AppMethodBeat.o(154429);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(154430);
    this.KGU.getSettings().setUseWideViewPort(paramBoolean);
    AppMethodBeat.o(154430);
  }
  
  public final void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(154444);
    this.KGU.getSettings().setUserAgentString(paramString);
    AppMethodBeat.o(154444);
  }
  
  public final void setUsingForAppBrand(int paramInt)
  {
    AppMethodBeat.i(154424);
    this.KGU.getSettings().setUsingForAppBrand(paramInt);
    AppMethodBeat.o(154424);
  }
  
  public final void setVideoPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(154423);
    this.KGU.getSettings().setVideoPlaybackRequiresUserGesture(paramBoolean);
    AppMethodBeat.o(154423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.l
 * JD-Core Version:    0.7.0.1
 */