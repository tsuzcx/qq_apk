package com.tencent.xweb;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.f;

public class z
{
  f aifb;
  
  public static boolean kfD()
  {
    return false;
  }
  
  public void a(WebView paramWebView, int paramInt) {}
  
  public boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(212469);
    if (this.aifb != null)
    {
      boolean bool = this.aifb.khc();
      AppMethodBeat.o(212469);
      return bool;
    }
    AppMethodBeat.o(212469);
    return false;
  }
  
  public boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, a parama)
  {
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(156776);
    if (this.aifb != null)
    {
      boolean bool = this.aifb.a(paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(156776);
      return bool;
    }
    AppMethodBeat.o(156776);
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, q paramq)
  {
    AppMethodBeat.i(156778);
    if (this.aifb != null)
    {
      boolean bool = this.aifb.a(paramString1, paramString2, paramString3, paramq);
      AppMethodBeat.o(156778);
      return bool;
    }
    AppMethodBeat.o(156778);
    return false;
  }
  
  public void b(WebView paramWebView, int paramInt) {}
  
  public boolean b(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    return true;
  }
  
  public boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(156777);
    if (this.aifb != null)
    {
      boolean bool = this.aifb.b(paramString1, paramString2, paramJsResult);
      AppMethodBeat.o(156777);
      return bool;
    }
    AppMethodBeat.o(156777);
    return false;
  }
  
  public boolean cxL()
  {
    AppMethodBeat.i(212473);
    if (this.aifb != null)
    {
      boolean bool = this.aifb.cxL();
      AppMethodBeat.o(212473);
      return bool;
    }
    AppMethodBeat.o(212473);
    return false;
  }
  
  public void d(WebView paramWebView, String paramString) {}
  
  public boolean e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return true;
  }
  
  public View getVideoLoadingProgressView()
  {
    return null;
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return false;
  }
  
  public void onExitFullscreenVideo(Bitmap paramBitmap) {}
  
  public void onGeolocationPermissionsHidePrompt() {}
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(156774);
    paramCallback.invoke(paramString, true, true);
    AppMethodBeat.o(156774);
  }
  
  public void onHideCustomView()
  {
    AppMethodBeat.i(156775);
    if (this.aifb != null) {
      this.aifb.onHideCustomView();
    }
    AppMethodBeat.o(156775);
  }
  
  public void onPermissionRequest(PermissionRequest paramPermissionRequest)
  {
    AppMethodBeat.i(212486);
    paramPermissionRequest.deny();
    AppMethodBeat.o(212486);
  }
  
  public void onPermissionRequestCanceled(PermissionRequest paramPermissionRequest) {}
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(156780);
    if (this.aifb != null) {
      this.aifb.onShowCustomView(paramView, paramCustomViewCallback);
    }
    AppMethodBeat.o(156780);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(156779);
    paramValueCallback.onReceiveValue(null);
    AppMethodBeat.o(156779);
  }
  
  public static abstract class a
  {
    public abstract String[] getAcceptTypes();
    
    public abstract int getMode();
    
    public abstract boolean isCaptureEnabled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.z
 * JD-Core Version:    0.7.0.1
 */