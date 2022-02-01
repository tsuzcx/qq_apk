package com.tencent.xweb.pinus.sdk;

import android.webkit.WebSettings.LayoutAlgorithm;
import java.util.Map;

public abstract interface WebSettingsInterface
{
  public abstract void disableCustomizedLongPressTimeout();
  
  public abstract void enableCustomizedLongPressTimeout(int paramInt);
  
  public abstract boolean getAllowContentAccess();
  
  public abstract boolean getAllowFileAccess();
  
  public abstract boolean getAllowFileAccessFromFileURLs();
  
  public abstract boolean getAllowUniversalAccessFromFileURLs();
  
  public abstract Map<String, String> getAppBrandInfo();
  
  public abstract boolean getAudioPlaybackRequiresUserGesture();
  
  public abstract boolean getBackgroundAudioPause();
  
  public abstract boolean getBlockNetworkImage();
  
  public abstract boolean getBlockNetworkLoads();
  
  public abstract boolean getBuiltInZoomControls();
  
  public abstract int getCacheMode();
  
  public abstract String getCursiveFontFamily();
  
  public abstract boolean getDatabaseEnabled();
  
  public abstract String getDatabasePath();
  
  public abstract int getDefaultFixedFontSize();
  
  public abstract int getDefaultFontSize();
  
  public abstract String getDefaultTextEncodingName();
  
  public abstract int getDisabledActionModeMenuItems();
  
  public abstract boolean getDisplayZoomControls();
  
  public abstract boolean getDomStorageEnabled();
  
  public abstract String getFantasyFontFamily();
  
  public abstract String getFixedFontFamily();
  
  public abstract int getForceDark();
  
  public abstract int getForceDarkBehavior();
  
  public abstract int getForceDarkMode();
  
  public abstract boolean getJavaScriptCanOpenWindowsAutomatically();
  
  public abstract boolean getJavaScriptEnabled();
  
  public abstract boolean getJavascriptCanAccessClipboard();
  
  public abstract WebSettings.LayoutAlgorithm getLayoutAlgorithm();
  
  public abstract boolean getLoadWithOverviewMode();
  
  public abstract boolean getLoadsImagesAutomatically();
  
  public abstract boolean getMediaPlaybackRequiresUserGesture();
  
  public abstract int getMinimumFontSize();
  
  public abstract int getMinimumLogicalFontSize();
  
  public abstract int getMixedContentMode();
  
  public abstract boolean getOffscreenPreRaster();
  
  public abstract String getSansSerifFontFamily();
  
  public abstract boolean getSaveFormData();
  
  public abstract boolean getSavePassword();
  
  public abstract String getSerifFontFamily();
  
  public abstract String getStandardFontFamily();
  
  public abstract int getTextZoom();
  
  public abstract boolean getUseWideViewPort();
  
  public abstract String getUserAgentString();
  
  public abstract int getUsingForAppBrand();
  
  public abstract boolean getVideoPlaybackRequiresUserGesture();
  
  public abstract void setAllowContentAccess(boolean paramBoolean);
  
  public abstract void setAllowFileAccess(boolean paramBoolean);
  
  public abstract void setAllowFileAccessFromFileURLs(boolean paramBoolean);
  
  public abstract void setAllowUniversalAccessFromFileURLs(boolean paramBoolean);
  
  public abstract void setAppBrandInfo(Map<String, String> paramMap);
  
  public abstract void setAppCacheEnabled(boolean paramBoolean);
  
  public abstract void setAppCacheMaxSize(long paramLong);
  
  public abstract void setAppCachePath(String paramString);
  
  public abstract void setAudioPlaybackRequiresUserGesture(boolean paramBoolean);
  
  public abstract void setBackgroundAudioPause(boolean paramBoolean);
  
  public abstract void setBlockNetworkImage(boolean paramBoolean);
  
  public abstract void setBlockNetworkLoads(boolean paramBoolean);
  
  public abstract void setBuiltInZoomControls(boolean paramBoolean);
  
  public abstract void setCacheMode(int paramInt);
  
  public abstract void setCursiveFontFamily(String paramString);
  
  public abstract void setDatabaseEnabled(boolean paramBoolean);
  
  public abstract void setDatabasePath(String paramString);
  
  public abstract void setDefaultFixedFontSize(int paramInt);
  
  public abstract void setDefaultFontSize(int paramInt);
  
  public abstract void setDefaultTextEncodingName(String paramString);
  
  public abstract void setDisabledActionModeMenuItems(int paramInt);
  
  public abstract void setDisplayZoomControls(boolean paramBoolean);
  
  public abstract void setDomStorageEnabled(boolean paramBoolean);
  
  public abstract void setFantasyFontFamily(String paramString);
  
  public abstract void setFixedFontFamily(String paramString);
  
  public abstract void setForceDark(int paramInt);
  
  public abstract void setForceDarkBehavior(int paramInt);
  
  public abstract void setForceDarkMode(int paramInt);
  
  public abstract void setGeolocationEnabled(boolean paramBoolean);
  
  public abstract void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean);
  
  public abstract void setJavaScriptEnabled(boolean paramBoolean);
  
  public abstract void setJavascriptCanAccessClipboard(boolean paramBoolean);
  
  public abstract void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm);
  
  public abstract void setLoadWithOverviewMode(boolean paramBoolean);
  
  public abstract void setLoadsImagesAutomatically(boolean paramBoolean);
  
  public abstract void setMediaPlaybackRequiresUserGesture(boolean paramBoolean);
  
  public abstract void setMinimumFontSize(int paramInt);
  
  public abstract void setMinimumLogicalFontSize(int paramInt);
  
  public abstract void setMixedContentMode(int paramInt);
  
  public abstract void setNeedInitialFocus(boolean paramBoolean);
  
  public abstract void setOffscreenPreRaster(boolean paramBoolean);
  
  public abstract void setSansSerifFontFamily(String paramString);
  
  public abstract void setSaveFormData(boolean paramBoolean);
  
  public abstract void setSavePassword(boolean paramBoolean);
  
  public abstract void setSerifFontFamily(String paramString);
  
  public abstract void setStandardFontFamily(String paramString);
  
  public abstract void setSupportMultipleWindows(boolean paramBoolean);
  
  public abstract void setSupportZoom(boolean paramBoolean);
  
  public abstract void setTextZoom(int paramInt);
  
  public abstract void setUseWideViewPort(boolean paramBoolean);
  
  public abstract void setUserAgentString(String paramString);
  
  public abstract void setUsingForAppBrand(int paramInt);
  
  public abstract void setVideoPlaybackRequiresUserGesture(boolean paramBoolean);
  
  public abstract boolean supportMultipleWindows();
  
  public abstract boolean supportZoom();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.WebSettingsInterface
 * JD-Core Version:    0.7.0.1
 */