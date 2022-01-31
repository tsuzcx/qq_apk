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
    AppMethodBeat.i(63854);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.getVisitedHistory(paramValueCallback);
    }
    AppMethodBeat.o(63854);
  }
  
  public IX5WebChromeClient getmWebChromeClient()
  {
    return this.mWebChromeClient;
  }
  
  public void onCloseWindow(IX5WebViewBase paramIX5WebViewBase)
  {
    AppMethodBeat.i(63853);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onCloseWindow(paramIX5WebViewBase);
    }
    AppMethodBeat.o(63853);
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63850);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onConsoleMessage(paramString1, paramInt, paramString2);
    }
    AppMethodBeat.o(63850);
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(63833);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(63833);
      return bool;
    }
    AppMethodBeat.o(63833);
    return false;
  }
  
  public boolean onCreateWindow(IX5WebViewBase paramIX5WebViewBase, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    AppMethodBeat.i(63834);
    if (this.mWebChromeClient != null)
    {
      paramBoolean1 = this.mWebChromeClient.onCreateWindow(paramIX5WebViewBase, paramBoolean1, paramBoolean2, paramMessage);
      AppMethodBeat.o(63834);
      return paramBoolean1;
    }
    AppMethodBeat.o(63834);
    return false;
  }
  
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(63849);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, paramQuotaUpdater);
    }
    AppMethodBeat.o(63849);
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    AppMethodBeat.i(63851);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onGeolocationPermissionsHidePrompt();
    }
    AppMethodBeat.o(63851);
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    AppMethodBeat.i(63835);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    }
    AppMethodBeat.o(63835);
  }
  
  public void onGeolocationStartUpdating(ValueCallback<Location> paramValueCallback, ValueCallback<Bundle> paramValueCallback1)
  {
    AppMethodBeat.i(63856);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onGeolocationStartUpdating(paramValueCallback, paramValueCallback1);
    }
    AppMethodBeat.o(63856);
  }
  
  public void onGeolocationStopUpdating()
  {
    AppMethodBeat.i(63857);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onGeolocationStopUpdating();
    }
    AppMethodBeat.o(63857);
  }
  
  public void onHideCustomView()
  {
    AppMethodBeat.i(63836);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onHideCustomView();
    }
    AppMethodBeat.o(63836);
  }
  
  public boolean onJsAlert(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(63837);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onJsAlert(paramIX5WebViewBase, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(63837);
      return bool;
    }
    AppMethodBeat.o(63837);
    return false;
  }
  
  public boolean onJsBeforeUnload(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(63839);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onJsBeforeUnload(paramIX5WebViewBase, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(63839);
      return bool;
    }
    AppMethodBeat.o(63839);
    return false;
  }
  
  public boolean onJsConfirm(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(63852);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onJsConfirm(paramIX5WebViewBase, paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(63852);
      return bool;
    }
    AppMethodBeat.o(63852);
    return false;
  }
  
  public boolean onJsPrompt(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    AppMethodBeat.i(63838);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onJsPrompt(paramIX5WebViewBase, paramString1, paramString2, paramString3, paramJsPromptResult);
      AppMethodBeat.o(63838);
      return bool;
    }
    AppMethodBeat.o(63838);
    return false;
  }
  
  public boolean onJsTimeout()
  {
    AppMethodBeat.i(63840);
    if (this.mWebChromeClient != null)
    {
      boolean bool = this.mWebChromeClient.onJsTimeout();
      AppMethodBeat.o(63840);
      return bool;
    }
    AppMethodBeat.o(63840);
    return false;
  }
  
  public void onProgressChanged(IX5WebViewBase paramIX5WebViewBase, int paramInt)
  {
    AppMethodBeat.i(63841);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onProgressChanged(paramIX5WebViewBase, paramInt);
    }
    AppMethodBeat.o(63841);
  }
  
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(63842);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onReachedMaxAppCacheSize(paramLong1, paramLong2, paramQuotaUpdater);
    }
    AppMethodBeat.o(63842);
  }
  
  public void onReceivedIcon(IX5WebViewBase paramIX5WebViewBase, Bitmap paramBitmap)
  {
    AppMethodBeat.i(63843);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onReceivedIcon(paramIX5WebViewBase, paramBitmap);
    }
    AppMethodBeat.o(63843);
  }
  
  public void onReceivedTitle(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(63845);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onReceivedTitle(paramIX5WebViewBase, paramString);
    }
    AppMethodBeat.o(63845);
  }
  
  public void onReceivedTouchIconUrl(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63844);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onReceivedTouchIconUrl(paramIX5WebViewBase, paramString, paramBoolean);
    }
    AppMethodBeat.o(63844);
  }
  
  public void onRequestFocus(IX5WebViewBase paramIX5WebViewBase)
  {
    AppMethodBeat.i(63846);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onRequestFocus(paramIX5WebViewBase);
    }
    AppMethodBeat.o(63846);
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(63848);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onShowCustomView(paramView, paramCustomViewCallback);
    }
    AppMethodBeat.o(63848);
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(63847);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onShowCustomView(paramView, paramCustomViewCallback);
    }
    AppMethodBeat.o(63847);
  }
  
  public boolean onShowFileChooser(IX5WebViewBase paramIX5WebViewBase, ValueCallback<Uri[]> paramValueCallback, IX5WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    return false;
  }
  
  public void openFileChooser(ValueCallback<Uri[]> paramValueCallback, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(63855);
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.openFileChooser(paramValueCallback, paramString1, paramString2, paramBoolean);
    }
    AppMethodBeat.o(63855);
  }
  
  public void setWebChromeClient(IX5WebChromeClient paramIX5WebChromeClient)
  {
    this.mWebChromeClient = paramIX5WebChromeClient;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.export.external.proxy.ProxyWebChromeClient
 * JD-Core Version:    0.7.0.1
 */