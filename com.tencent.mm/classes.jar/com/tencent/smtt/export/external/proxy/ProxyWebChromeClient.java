package com.tencent.smtt.export.external.proxy;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;

public class ProxyWebChromeClient
  implements IX5WebChromeClient
{
  protected IX5WebChromeClient mWebChromeClient;
  
  public Bitmap getDefaultVideoPoster()
  {
    return null;
  }
  
  public void getVisitedHistory(ValueCallback<String[]> paramValueCallback)
  {
    AppMethodBeat.i(53259);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.getVisitedHistory(paramValueCallback);
    }
    AppMethodBeat.o(53259);
  }
  
  public IX5WebChromeClient getmWebChromeClient()
  {
    return this.mWebChromeClient;
  }
  
  public void onCloseWindow(IX5WebViewBase paramIX5WebViewBase)
  {
    AppMethodBeat.i(53258);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onCloseWindow(paramIX5WebViewBase);
    }
    AppMethodBeat.o(53258);
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(53255);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onConsoleMessage(paramString1, paramInt, paramString2);
    }
    AppMethodBeat.o(53255);
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(53238);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(53238);
      return bool;
    }
    AppMethodBeat.o(53238);
    return false;
  }
  
  public boolean onCreateWindow(IX5WebViewBase paramIX5WebViewBase, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    AppMethodBeat.i(53239);
    if (this.mWebChromeClient != null)
    {
      paramBoolean1 = this.mWebChromeClient.onCreateWindow(paramIX5WebViewBase, paramBoolean1, paramBoolean2, paramMessage);
      AppMethodBeat.o(53239);
      return paramBoolean1;
    }
    AppMethodBeat.o(53239);
    return false;
  }
  
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(53254);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, paramQuotaUpdater);
    }
    AppMethodBeat.o(53254);
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    AppMethodBeat.i(53256);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onGeolocationPermissionsHidePrompt();
    }
    AppMethodBeat.o(53256);
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    AppMethodBeat.i(53240);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    }
    AppMethodBeat.o(53240);
  }
  
  public void onGeolocationStartUpdating(ValueCallback<Location> paramValueCallback, ValueCallback<Bundle> paramValueCallback1)
  {
    AppMethodBeat.i(53261);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onGeolocationStartUpdating(paramValueCallback, paramValueCallback1);
    }
    AppMethodBeat.o(53261);
  }
  
  public void onGeolocationStopUpdating()
  {
    AppMethodBeat.i(53262);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onGeolocationStopUpdating();
    }
    AppMethodBeat.o(53262);
  }
  
  public void onHideCustomView()
  {
    AppMethodBeat.i(53241);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onHideCustomView();
    }
    AppMethodBeat.o(53241);
  }
  
  public boolean onJsAlert(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(53242);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onJsAlert(paramIX5WebViewBase, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(53242);
      return bool;
    }
    AppMethodBeat.o(53242);
    return false;
  }
  
  public boolean onJsBeforeUnload(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(53244);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onJsBeforeUnload(paramIX5WebViewBase, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(53244);
      return bool;
    }
    AppMethodBeat.o(53244);
    return false;
  }
  
  public boolean onJsConfirm(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(53257);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onJsConfirm(paramIX5WebViewBase, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(53257);
      return bool;
    }
    AppMethodBeat.o(53257);
    return false;
  }
  
  public boolean onJsPrompt(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    AppMethodBeat.i(53243);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onJsPrompt(paramIX5WebViewBase, paramString1, paramString2, paramString3, paramJsPromptResult);
      AppMethodBeat.o(53243);
      return bool;
    }
    AppMethodBeat.o(53243);
    return false;
  }
  
  public boolean onJsTimeout()
  {
    AppMethodBeat.i(53245);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onJsTimeout();
      AppMethodBeat.o(53245);
      return bool;
    }
    AppMethodBeat.o(53245);
    return false;
  }
  
  public void onProgressChanged(IX5WebViewBase paramIX5WebViewBase, int paramInt)
  {
    AppMethodBeat.i(53246);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onProgressChanged(paramIX5WebViewBase, paramInt);
    }
    AppMethodBeat.o(53246);
  }
  
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(53247);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onReachedMaxAppCacheSize(paramLong1, paramLong2, paramQuotaUpdater);
    }
    AppMethodBeat.o(53247);
  }
  
  public void onReceivedIcon(IX5WebViewBase paramIX5WebViewBase, Bitmap paramBitmap)
  {
    AppMethodBeat.i(53248);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onReceivedIcon(paramIX5WebViewBase, paramBitmap);
    }
    AppMethodBeat.o(53248);
  }
  
  public void onReceivedTitle(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(53250);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onReceivedTitle(paramIX5WebViewBase, paramString);
    }
    AppMethodBeat.o(53250);
  }
  
  public void onReceivedTouchIconUrl(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(53249);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onReceivedTouchIconUrl(paramIX5WebViewBase, paramString, paramBoolean);
    }
    AppMethodBeat.o(53249);
  }
  
  public void onRequestFocus(IX5WebViewBase paramIX5WebViewBase)
  {
    AppMethodBeat.i(53251);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onRequestFocus(paramIX5WebViewBase);
    }
    AppMethodBeat.o(53251);
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(53253);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onShowCustomView(paramView, paramCustomViewCallback);
    }
    AppMethodBeat.o(53253);
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(53252);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onShowCustomView(paramView, paramCustomViewCallback);
    }
    AppMethodBeat.o(53252);
  }
  
  public boolean onShowFileChooser(IX5WebViewBase paramIX5WebViewBase, ValueCallback<Uri[]> paramValueCallback, IX5WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    return false;
  }
  
  public void openFileChooser(ValueCallback<Uri[]> paramValueCallback, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(53260);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.openFileChooser(paramValueCallback, paramString1, paramString2, paramBoolean);
    }
    AppMethodBeat.o(53260);
  }
  
  public void setWebChromeClient(IX5WebChromeClient paramIX5WebChromeClient)
  {
    this.mWebChromeClient = paramIX5WebChromeClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.export.external.proxy.ProxyWebChromeClient
 * JD-Core Version:    0.7.0.1
 */