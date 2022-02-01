package com.tencent.smtt.export.external.interfaces;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.easel.interfaces.IEaselView;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import java.util.Map;

public abstract interface IX5CoreMessy
{
  public abstract boolean canOpenFile(Context paramContext, String paramString);
  
  public abstract void checkTrim(int paramInt);
  
  public abstract void clearAdWebviewInfo();
  
  public abstract void clearAllPermanentPermission();
  
  public abstract void closeFileReader();
  
  public abstract void closeMiniQB();
  
  public abstract void createCacheWebView(Context paramContext);
  
  public abstract IX5DateSorter createDateSorter(Context paramContext);
  
  public abstract IX5WebChromeClient createDefaultX5WebChromeClient();
  
  public abstract IX5WebViewClientExtension createDefaultX5WebChromeClientExtension();
  
  public abstract IX5WebViewClient createDefaultX5WebViewClient();
  
  public abstract IEaselView createEaselView(Context paramContext);
  
  public abstract boolean createMiniQBShortCut(Context paramContext, String paramString1, String paramString2, Bitmap paramBitmap);
  
  public abstract void destoryScaleManager();
  
  public abstract void doSearch(Context paramContext, String paramString1, IX5WebViewBase paramIX5WebViewBase, String paramString2);
  
  public abstract void doWupTask();
  
  public abstract void fileInfoDetect(Context paramContext, String paramString, ValueCallback<String> paramValueCallback);
  
  public abstract Bundle getAdWebViewInfoFromX5Core();
  
  public abstract String getCrashExtraMessage();
  
  public abstract IX5WebViewBase getCurrentMainWebviewJustForQQandWechat();
  
  public abstract String getDefaultUserAgent(Context paramContext);
  
  public abstract String getExtendRule(Context paramContext, String paramString);
  
  public abstract String getGUID();
  
  public abstract String getMiniQBVersion();
  
  public abstract String getTbsVersion();
  
  public abstract boolean getX5RenderPerformDebug();
  
  public abstract boolean installLocalQbApk(Context paramContext, String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract boolean isMiniQBShortCutExist(Context paramContext, String paramString);
  
  public abstract boolean isWritingWebCoreLogToFile();
  
  public abstract String mimeTypeMapGetExtensionFromMimeType(String paramString);
  
  public abstract String mimeTypeMapGetFileExtensionFromUrl(String paramString);
  
  public abstract String mimeTypeMapGetMimeTypeFromExtension(String paramString);
  
  public abstract boolean mimeTypeMapHasExtension(String paramString);
  
  public abstract boolean mimeTypeMapHasMimeType(String paramString);
  
  public abstract Uri[] parseFileChooserResult(int paramInt, Intent paramIntent);
  
  public abstract void prefetchResource(Context paramContext, String paramString, Map<String, String> paramMap);
  
  public abstract void pvUploadNotifybyUI();
  
  public abstract void refreshJavaCoreApnState();
  
  public abstract void setAdWebviewInfo(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, int paramInt4);
  
  public abstract void setAdWebviewShouldShow(boolean paramBoolean);
  
  public abstract void setGuidToTbs(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong);
  
  public abstract void setQBSmttService(Object paramObject);
  
  public abstract void setTbsInitPerformanceData(int paramInt, Map<String, String> paramMap);
  
  public abstract void setWebContentsDebuggingEnabled(boolean paramBoolean);
  
  public abstract void setWebCoreLogWrite2FileFlag(boolean paramBoolean, String paramString);
  
  public abstract void setWebViewPoolSize(Context paramContext, int paramInt);
  
  public abstract void setX5RenderPerformDebug(boolean paramBoolean);
  
  public abstract int startMiniQB(Context paramContext, String paramString, Map<String, String> paramMap, ValueCallback<String> paramValueCallback);
  
  public abstract int startQBWeb(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap);
  
  public abstract void switchContext(IX5WebViewBase paramIX5WebViewBase, Context paramContext);
  
  public abstract void traceBegin(int paramInt, String paramString);
  
  public abstract void traceEnd(int paramInt, String paramString);
  
  public abstract void uploadWebCoreLog2Server();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5CoreMessy
 * JD-Core Version:    0.7.0.1
 */