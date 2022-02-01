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
  XWalkView Mxu;
  
  public l(XWalkView paramXWalkView)
  {
    this.Mxu = paramXWalkView;
  }
  
  public final void enableCustomizedLongPressTimeout(int paramInt)
  {
    AppMethodBeat.i(195565);
    this.Mxu.getSettings().enableCustomizedLongPressTimeout(paramInt);
    AppMethodBeat.o(195565);
  }
  
  public final void gaR() {}
  
  public final void gaS()
  {
    AppMethodBeat.i(154426);
    this.Mxu.getSettings().setAllowFileAccess(true);
    AppMethodBeat.o(154426);
  }
  
  public final void gaT()
  {
    AppMethodBeat.i(154428);
    this.Mxu.getSettings().setSaveFormData(false);
    AppMethodBeat.o(154428);
  }
  
  public final void gaU() {}
  
  public final void gaV()
  {
    AppMethodBeat.i(154432);
    this.Mxu.getSettings().setDefaultFontSize(8);
    AppMethodBeat.o(154432);
  }
  
  public final void gaW()
  {
    AppMethodBeat.i(154437);
    this.Mxu.getSettings().setAllowUniversalAccessFromFileURLs(true);
    AppMethodBeat.o(154437);
  }
  
  public final void gaX()
  {
    AppMethodBeat.i(154438);
    this.Mxu.getSettings().setAllowFileAccessFromFileURLs(true);
    AppMethodBeat.o(154438);
  }
  
  public final void gaY()
  {
    AppMethodBeat.i(154439);
    this.Mxu.getSettings().setAppCacheEnabled(true);
    AppMethodBeat.o(154439);
  }
  
  public final void gaZ() {}
  
  public final void gba()
  {
    AppMethodBeat.i(154441);
    this.Mxu.getSettings().setDatabaseEnabled(true);
    AppMethodBeat.o(154441);
  }
  
  public final void gbb()
  {
    AppMethodBeat.i(154442);
    this.Mxu.getSettings().setDomStorageEnabled(true);
    AppMethodBeat.o(154442);
  }
  
  public final void gbc()
  {
    AppMethodBeat.i(154446);
    this.Mxu.getSettings().setCacheMode(-1);
    AppMethodBeat.o(154446);
  }
  
  public final void gbd() {}
  
  public final boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(154435);
    boolean bool = this.Mxu.getSettings().getBlockNetworkImage();
    AppMethodBeat.o(154435);
    return bool;
  }
  
  public final int getForceDarkBehavior()
  {
    AppMethodBeat.i(154450);
    int i = this.Mxu.getSettings().getForceDarkBehavior();
    AppMethodBeat.o(154450);
    return i;
  }
  
  public final int getForceDarkMode()
  {
    AppMethodBeat.i(154448);
    int i = this.Mxu.getSettings().getForceDarkMode();
    AppMethodBeat.o(154448);
    return i;
  }
  
  public final String getUserAgentString()
  {
    AppMethodBeat.i(154445);
    String str = this.Mxu.getSettings().getUserAgentString();
    AppMethodBeat.o(154445);
    return str;
  }
  
  public final void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(154440);
    this.Mxu.getSettings().setAppCachePath(paramString);
    AppMethodBeat.o(154440);
  }
  
  public final void setAudioPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(183741);
    this.Mxu.getSettings().setAudioPlaybackRequiresUserGesture(paramBoolean);
    AppMethodBeat.o(183741);
  }
  
  public final void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(154434);
    this.Mxu.getSettings().setBlockNetworkImage(paramBoolean);
    AppMethodBeat.o(154434);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(154425);
    this.Mxu.getSettings().setBuiltInZoomControls(paramBoolean);
    AppMethodBeat.o(154425);
  }
  
  public final void setDatabasePath(String paramString) {}
  
  public final void setDefaultTextEncodingName(String paramString) {}
  
  public final void setForceDarkBehavior(int paramInt)
  {
    AppMethodBeat.i(154449);
    this.Mxu.getSettings().setForceDarkBehavior(paramInt);
    AppMethodBeat.o(154449);
  }
  
  public final void setForceDarkMode(int paramInt)
  {
    AppMethodBeat.i(154447);
    this.Mxu.getSettings().setForceDarkMode(paramInt);
    AppMethodBeat.o(154447);
  }
  
  public final void setGeolocationEnabled(boolean paramBoolean) {}
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(154443);
    this.Mxu.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
    AppMethodBeat.o(154443);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154436);
    this.Mxu.getSettings().setJavaScriptEnabled(paramBoolean);
    AppMethodBeat.o(154436);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(154431);
    paramLayoutAlgorithm = org.xwalk.core.XWalkSettings.LayoutAlgorithm.values()[paramLayoutAlgorithm.ordinal()];
    this.Mxu.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
    AppMethodBeat.o(154431);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(154427);
    this.Mxu.getSettings().setLoadWithOverviewMode(paramBoolean);
    AppMethodBeat.o(154427);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(154433);
    this.Mxu.getSettings().setLoadsImagesAutomatically(paramBoolean);
    AppMethodBeat.o(154433);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(154422);
    this.Mxu.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
    AppMethodBeat.o(154422);
  }
  
  public final void setPluginsEnabled(boolean paramBoolean) {}
  
  public final void setRenderPriority(WebSettings.RenderPriority paramRenderPriority) {}
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(154421);
    this.Mxu.getSettings().setSupportZoom(paramBoolean);
    AppMethodBeat.o(154421);
  }
  
  public final void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(154429);
    this.Mxu.getSettings().setTextZoom(paramInt);
    AppMethodBeat.o(154429);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(154430);
    this.Mxu.getSettings().setUseWideViewPort(paramBoolean);
    AppMethodBeat.o(154430);
  }
  
  public final void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(154444);
    this.Mxu.getSettings().setUserAgentString(paramString);
    AppMethodBeat.o(154444);
  }
  
  public final void setUsingForAppBrand(int paramInt)
  {
    AppMethodBeat.i(154424);
    this.Mxu.getSettings().setUsingForAppBrand(paramInt);
    AppMethodBeat.o(154424);
  }
  
  public final void setVideoPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(154423);
    this.Mxu.getSettings().setVideoPlaybackRequiresUserGesture(paramBoolean);
    AppMethodBeat.o(154423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.l
 * JD-Core Version:    0.7.0.1
 */