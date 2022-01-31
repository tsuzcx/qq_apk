package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;

public class WebViewClient
{
  public static final int ERROR_AUTHENTICATION = -4;
  public static final int ERROR_BAD_URL = -12;
  public static final int ERROR_CONNECT = -6;
  public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
  public static final int ERROR_FILE = -13;
  public static final int ERROR_FILE_NOT_FOUND = -14;
  public static final int ERROR_HOST_LOOKUP = -2;
  public static final int ERROR_IO = -7;
  public static final int ERROR_PROXY_AUTHENTICATION = -5;
  public static final int ERROR_REDIRECT_LOOP = -9;
  public static final int ERROR_TIMEOUT = -8;
  public static final int ERROR_TOO_MANY_REQUESTS = -15;
  public static final int ERROR_UNKNOWN = -1;
  public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
  public static final int ERROR_UNSUPPORTED_SCHEME = -10;
  public static final int INTERCEPT_BY_ISP = -16;
  w a;
  
  public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean) {}
  
  public void onDetectedBlankScreen(String paramString, int paramInt) {}
  
  public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    AppMethodBeat.i(65029);
    paramMessage1.sendToTarget();
    AppMethodBeat.o(65029);
  }
  
  public void onLoadResource(WebView paramWebView, String paramString) {}
  
  public void onPageFinished(WebView paramWebView, String paramString) {}
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(65025);
    if (this.a != null) {
      this.a.a(paramWebView, paramString, paramBitmap);
    }
    AppMethodBeat.o(65025);
  }
  
  public void onReceivedClientCertRequest(WebView paramWebView, ClientCertRequest paramClientCertRequest)
  {
    AppMethodBeat.i(65032);
    paramClientCertRequest.cancel();
    AppMethodBeat.o(65032);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    AppMethodBeat.i(65026);
    if (this.a != null)
    {
      if (paramWebResourceRequest.isForMainFrame())
      {
        this.a.onReceivedError(paramWebView.c(), paramWebResourceError.getErrorCode(), paramWebResourceError.getDescription().toString(), paramWebResourceRequest.getUrl().toString());
        AppMethodBeat.o(65026);
      }
    }
    else if (paramWebResourceRequest.isForMainFrame()) {
      onReceivedError(paramWebView, paramWebResourceError.getErrorCode(), paramWebResourceError.getDescription().toString(), paramWebResourceRequest.getUrl().toString());
    }
    AppMethodBeat.o(65026);
  }
  
  public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    AppMethodBeat.i(65030);
    paramHttpAuthHandler.cancel();
    AppMethodBeat.o(65030);
  }
  
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse) {}
  
  public void onReceivedLoginRequest(WebView paramWebView, String paramString1, String paramString2, String paramString3) {}
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    AppMethodBeat.i(65031);
    paramSslErrorHandler.cancel();
    AppMethodBeat.o(65031);
  }
  
  public void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2) {}
  
  public void onTooManyRedirects(WebView paramWebView, Message paramMessage1, Message paramMessage2) {}
  
  public void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent) {}
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(65027);
    if (this.a != null)
    {
      paramWebView = this.a.shouldInterceptRequest(paramWebView.c(), paramWebResourceRequest.getUrl().toString());
      AppMethodBeat.o(65027);
      return paramWebView;
    }
    paramWebView = shouldInterceptRequest(paramWebView, paramWebResourceRequest.getUrl().toString());
    AppMethodBeat.o(65027);
    return paramWebView;
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(65028);
    if (this.a != null)
    {
      paramWebView = this.a.shouldInterceptRequest(paramWebView.c(), paramWebResourceRequest);
      AppMethodBeat.o(65028);
      return paramWebView;
    }
    AppMethodBeat.o(65028);
    return null;
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return null;
  }
  
  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(65024);
    if (this.a != null)
    {
      bool = this.a.shouldOverrideUrlLoading(paramWebView.c(), paramWebResourceRequest.getUrl().toString());
      AppMethodBeat.o(65024);
      return bool;
    }
    boolean bool = shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest.getUrl().toString());
    AppMethodBeat.o(65024);
    return bool;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebViewClient
 * JD-Core Version:    0.7.0.1
 */