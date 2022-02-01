package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5CoreEntry;
import com.tencent.smtt.export.external.interfaces.IX5CoreMessy;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.utils.TbsLog;

public class WebChromeClient
{
  public Bitmap getDefaultVideoPoster()
  {
    return null;
  }
  
  public View getVideoLoadingProgressView()
  {
    return null;
  }
  
  public void getVisitedHistory(ValueCallback<String[]> paramValueCallback) {}
  
  public void onCloseWindow(WebView paramWebView) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return false;
  }
  
  public boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    return false;
  }
  
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(54044);
    paramQuotaUpdater.updateQuota(paramLong2);
    AppMethodBeat.o(54044);
  }
  
  public void onGeolocationPermissionsHidePrompt() {}
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    AppMethodBeat.i(54045);
    paramGeolocationPermissionsCallback.invoke(paramString, true, true);
    AppMethodBeat.o(54045);
  }
  
  public void onHideCustomView() {}
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return false;
  }
  
  public boolean onJsTimeout()
  {
    return true;
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {}
  
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(54046);
    paramQuotaUpdater.updateQuota(paramLong2);
    AppMethodBeat.o(54046);
  }
  
  public void onReceivedIcon(WebView paramWebView, Bitmap paramBitmap) {}
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {}
  
  public void onReceivedTouchIconUrl(WebView paramWebView, String paramString, boolean paramBoolean) {}
  
  public void onRequestFocus(WebView paramWebView) {}
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, FileChooserParams paramFileChooserParams)
  {
    return false;
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(54047);
    paramValueCallback.onReceiveValue(null);
    AppMethodBeat.o(54047);
  }
  
  public static abstract class FileChooserParams
  {
    public static final int MODE_OPEN = 0;
    public static final int MODE_OPEN_FOLDER = 2;
    public static final int MODE_OPEN_MULTIPLE = 1;
    public static final int MODE_SAVE = 3;
    
    public static Uri[] parseResult(int paramInt, Intent paramIntent)
    {
      try
      {
        v localv = v.a();
        if ((localv != null) && (localv.b())) {
          return TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().parseFileChooserResult(paramInt, paramIntent);
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramIntent = android.webkit.WebChromeClient.FileChooserParams.parseResult(paramInt, paramIntent);
          return paramIntent;
        }
      }
      catch (Exception paramIntent)
      {
        TbsLog.i("WebChromeClient", "parseResult:" + paramIntent.toString());
      }
      return null;
    }
    
    public abstract Intent createIntent();
    
    public abstract String[] getAcceptTypes();
    
    public abstract String getFilenameHint();
    
    public abstract int getMode();
    
    public abstract CharSequence getTitle();
    
    public abstract boolean isCaptureEnabled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebChromeClient
 * JD-Core Version:    0.7.0.1
 */