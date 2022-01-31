package com.tencent.xweb.xwalk;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.xweb.n;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkView;

public final class i
  extends n
{
  XWalkView xmn;
  
  public i(XWalkView paramXWalkView)
  {
    this.xmn = paramXWalkView;
  }
  
  public final void cSl() {}
  
  public final void cSm()
  {
    this.xmn.getSettings().setSaveFormData(false);
  }
  
  public final void cSn() {}
  
  public final void cSo()
  {
    this.xmn.getSettings().setDefaultFontSize(8);
  }
  
  public final void cSp()
  {
    this.xmn.getSettings().setAppCacheEnabled(true);
  }
  
  public final void cSq() {}
  
  public final void cSr()
  {
    this.xmn.getSettings().setDatabaseEnabled(true);
  }
  
  public final void cSs()
  {
    this.xmn.getSettings().setDomStorageEnabled(true);
  }
  
  public final void cSt()
  {
    this.xmn.getSettings().setCacheMode(-1);
  }
  
  public final void cSu() {}
  
  public final boolean getBlockNetworkImage()
  {
    return this.xmn.getSettings().getBlockNetworkImage();
  }
  
  public final String getUserAgentString()
  {
    return this.xmn.getUserAgentString();
  }
  
  public final void setAppCachePath(String paramString)
  {
    this.xmn.getSettings().setAppCachePath(paramString);
  }
  
  public final void setBlockNetworkImage(boolean paramBoolean)
  {
    this.xmn.getSettings().setBlockNetworkImage(paramBoolean);
  }
  
  public final void setBuiltInZoomControls(boolean paramBoolean)
  {
    this.xmn.getSettings().setBuiltInZoomControls(paramBoolean);
  }
  
  public final void setDatabasePath(String paramString) {}
  
  public final void setDefaultTextEncodingName(String paramString) {}
  
  public final void setGeolocationEnabled(boolean paramBoolean) {}
  
  public final void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    this.xmn.getSettings().setJavaScriptCanOpenWindowsAutomatically(paramBoolean);
  }
  
  public final void setJavaScriptEnabled(boolean paramBoolean)
  {
    this.xmn.getSettings().setJavaScriptEnabled(paramBoolean);
  }
  
  public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    paramLayoutAlgorithm = org.xwalk.core.XWalkSettings.LayoutAlgorithm.values()[paramLayoutAlgorithm.ordinal()];
    this.xmn.getSettings().setLayoutAlgorithm(paramLayoutAlgorithm);
  }
  
  public final void setLoadWithOverviewMode(boolean paramBoolean)
  {
    this.xmn.getSettings().setLoadWithOverviewMode(paramBoolean);
  }
  
  public final void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    this.xmn.getSettings().setLoadsImagesAutomatically(paramBoolean);
  }
  
  public final void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    this.xmn.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
  }
  
  public final void setPluginsEnabled(boolean paramBoolean) {}
  
  public final void setRenderPriority(WebSettings.RenderPriority paramRenderPriority) {}
  
  public final void setSupportZoom(boolean paramBoolean)
  {
    this.xmn.getSettings().setSupportZoom(paramBoolean);
  }
  
  public final void setTextZoom(int paramInt)
  {
    this.xmn.getSettings().setTextZoom(paramInt);
  }
  
  public final void setUseWideViewPort(boolean paramBoolean)
  {
    this.xmn.getSettings().setUseWideViewPort(paramBoolean);
  }
  
  public final void setUserAgentString(String paramString)
  {
    this.xmn.getSettings().setUserAgentString(paramString);
  }
  
  public final void setUsingForAppBrand(int paramInt)
  {
    this.xmn.getSettings().setUsingForAppBrand(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.i
 * JD-Core Version:    0.7.0.1
 */