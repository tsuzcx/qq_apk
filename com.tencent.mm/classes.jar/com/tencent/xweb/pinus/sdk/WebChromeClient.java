package com.tencent.xweb.pinus.sdk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

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
  
  public void onExitFullscreenVideo(Bitmap paramBitmap) {}
  
  public void onGeolocationPermissionsHidePrompt() {}
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback) {}
  
  public void onGetSampleString(WebView paramWebView, Map<String, String> paramMap) {}
  
  public void onGetTranslateString(WebView paramWebView, Map<String, String> paramMap) {}
  
  public void onHideCustomView() {}
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResultInterface paramJsResultInterface)
  {
    return false;
  }
  
  public boolean onJsAlertInner(WebView paramWebView, String paramString1, String paramString2, Object paramObject)
  {
    return false;
  }
  
  public boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResultInterface paramJsResultInterface)
  {
    return false;
  }
  
  public boolean onJsBeforeUnloadInner(WebView paramWebView, String paramString1, String paramString2, Object paramObject)
  {
    return false;
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResultInterface paramJsResultInterface)
  {
    return false;
  }
  
  public boolean onJsConfirmInner(WebView paramWebView, String paramString1, String paramString2, Object paramObject)
  {
    return false;
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsResultInterface paramJsResultInterface)
  {
    return false;
  }
  
  public boolean onJsPromptInner(WebView paramWebView, String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    return false;
  }
  
  public void onPermissionRequest(PermissionRequest paramPermissionRequest)
  {
    AppMethodBeat.i(213674);
    paramPermissionRequest.deny();
    AppMethodBeat.o(213674);
  }
  
  public void onPermissionRequestCanceled(PermissionRequest paramPermissionRequest) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {}
  
  public void onReceivedIcon(WebView paramWebView, Bitmap paramBitmap) {}
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {}
  
  public void onReceivedTouchIconUrl(WebView paramWebView, String paramString, boolean paramBoolean) {}
  
  public void onRequestFocus(WebView paramWebView) {}
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.WebChromeClient
 * JD-Core Version:    0.7.0.1
 */