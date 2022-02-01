package com.tencent.xweb.xwalk;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.z;
import java.util.Map;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkView;

public final class l
  extends z
{
  XWalkView SHF;
  
  public l(XWalkView paramXWalkView)
  {
    this.SHF = paramXWalkView;
  }
  
  public final void enableCustomizedLongPressTimeout(int paramInt)
  {
    AppMethodBeat.i(207307);
    this.SHF.getSettings().enableCustomizedLongPressTimeout(paramInt);
    AppMethodBeat.o(207307);
  }
  
  public final boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(154435);
    boolean bool = this.SHF.getSettings().getBlockNetworkImage();
    AppMethodBeat.o(154435);
    return bool;
  }
  
  public final int getForceDarkBehavior()
  {
    AppMethodBeat.i(154450);
    int i = this.SHF.getSettings().getForceDarkBehavior();
    AppMethodBeat.o(154450);
    return i;
  }
  
  public final int getForceDarkMode()
  {
    AppMethodBeat.i(154448);
    int i = this.SHF.getSettings().getForceDarkMode();
    AppMethodBeat.o(154448);
    return i;
  }
  
  public final String getUserAgentString()
  {
    AppMethodBeat.i(154445);
    String str = this.SHF.getSettings().getUserAgentString();
    AppMethodBeat.o(154445);
    return str;
  }
  
  public final void hsK() {}
  
  public final void hsL()
  {
    AppMethodBeat.i(154426);
    this.SHF.getSettings().setAllowFileAccess(true);
    AppMethodBeat.o(154426);
  }
  
  public final void hsM()
  {
    AppMethodBeat.i(154428);
    this.SHF.getSettings().setSaveFormData(false);
    AppMethodBeat.o(154428);
  }
  
  public final void hsN() {}
  
  public final void hsO()
  {
    AppMethodBeat.i(154432);
    this.SHF.getSettings().setDefaultFontSize(8);
    AppMethodBeat.o(154432);
  }
  
  public final void hsP()
  {
    AppMethodBeat.i(154437);
    this.SHF.getSettings().setAllowUniversalAccessFromFileURLs(true);
    AppMethodBeat.o(154437);
  }
  
  public final void hsQ()
  {
    AppMethodBeat.i(154438);
    this.SHF.getSettings().setAllowFileAccessFromFileURLs(true);
    AppMethodBeat.o(154438);
  }
  
  public final void hsR()
  {
    AppMethodBeat.i(154439);
    this.SHF.getSettings().setAppCacheEnabled(true);
    AppMethodBeat.o(154439);
  }
  
  public final void hsS() {}
  
  public final void hsT()
  {
    AppMethodBeat.i(154441);
    this.SHF.getSettings().setDatabaseEnabled(true);
    AppMethodBeat.o(154441);
  }
  
  public final void hsU()
  {
    AppMethodBeat.i(154442);
    this.SHF.getSettings().setDomStorageEnabled(true);
    AppMethodBeat.o(154442);
  }
  
  public final void hsV()
  {
    AppMethodBeat.i(154446);
    this.SHF.getSettings().setCacheMode(-1);
    AppMethodBeat.o(154446);
  }
  
  public final void hsW() {}
  
  public final void hsX()
  {
    AppMethodBeat.i(207309);
    this.SHF.getSettings().setBackgroundAudioPause(true);
    AppMethodBeat.o(207309);
  }
  
  public final void setAppBrandInfo(Map<String, String> paramMap)
  {
    AppMethodBeat.i(207308);
    this.SHF.getSettings().setAppBrandInfo(paramMap);
    AppMethodBeat.o(207308);
  }
  
  public final void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(154440);
    this.SHF.getSettings().setAppCachePath(paramString);
    AppMethodBeat.o(154440);
  }
  
  public final void setAudioPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(183741);
    this.SHF.getSettings().setAudioPlaybackRequiresUserGesture(paramBoolean);
    AppMethodBeat.o(183741);
  }
  
  public final void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(154434);
    this.SHF.getSettings().setBlockNetworkImage(paramBoolean);
    AppMethodBeat.o(154434);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(154425);
    this.SHF.getSettings().setBuiltInZoomControls(paramBoolean);
    AppMethodBeat.o(154425);
  }
  
  public final void setDatabasePath(String paramString) {}
  
  public final void setDefaultTextEncodingName(String paramString) {}
  
  public final void setForceDarkBehavior(int paramInt)
  {
    AppMethodBeat.i(154449);
    this.SHF.getSettings().setForceDarkBehavior(paramInt);
    AppMethodBeat.o(154449);
  }
  
  public final void setForceDarkMode(int paramInt)
  {
    AppMethodBeat.i(154447);
    this.SHF.getSettings().setForceDarkMode(paramInt);
    AppMethodBeat.o(154447);
  }
  
  public final void setGeolocationEnabled(boolean paramBoolean) {}
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(154443);
    this.SHF.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
    AppMethodBeat.o(154443);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154436);
    this.SHF.getSettings().setJavaScriptEnabled(paramBoolean);
    AppMethodBeat.o(154436);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(154431);
    paramLayoutAlgorithm = org.xwalk.core.XWalkSettings.LayoutAlgorithm.values()[paramLayoutAlgorithm.ordinal()];
    this.SHF.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
    AppMethodBeat.o(154431);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(154427);
    this.SHF.getSettings().setLoadWithOverviewMode(paramBoolean);
    AppMethodBeat.o(154427);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(154433);
    this.SHF.getSettings().setLoadsImagesAutomatically(paramBoolean);
    AppMethodBeat.o(154433);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(154422);
    this.SHF.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
    AppMethodBeat.o(154422);
  }
  
  public final void setPluginsEnabled(boolean paramBoolean) {}
  
  public final void setRenderPriority(WebSettings.RenderPriority paramRenderPriority) {}
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(154421);
    this.SHF.getSettings().setSupportZoom(paramBoolean);
    AppMethodBeat.o(154421);
  }
  
  public final void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(154429);
    this.SHF.getSettings().setTextZoom(paramInt);
    AppMethodBeat.o(154429);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(154430);
    this.SHF.getSettings().setUseWideViewPort(paramBoolean);
    AppMethodBeat.o(154430);
  }
  
  public final void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(154444);
    this.SHF.getSettings().setUserAgentString(paramString);
    AppMethodBeat.o(154444);
  }
  
  public final void setUsingForAppBrand(int paramInt)
  {
    AppMethodBeat.i(154424);
    this.SHF.getSettings().setUsingForAppBrand(paramInt);
    AppMethodBeat.o(154424);
  }
  
  public final void setVideoPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(154423);
    this.SHF.getSettings().setVideoPlaybackRequiresUserGesture(paramBoolean);
    AppMethodBeat.o(154423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.l
 * JD-Core Version:    0.7.0.1
 */