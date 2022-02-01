package com.tencent.xweb.pinus.sdk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

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
  public static final int ERROR_UNSAFE_RESOURCE = -16;
  public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
  public static final int ERROR_UNSUPPORTED_SCHEME = -10;
  public static final int SAFE_BROWSING_THREAT_BILLING = 4;
  public static final int SAFE_BROWSING_THREAT_MALWARE = 1;
  public static final int SAFE_BROWSING_THREAT_PHISHING = 2;
  public static final int SAFE_BROWSING_THREAT_UNKNOWN = 0;
  public static final int SAFE_BROWSING_THREAT_UNWANTED_SOFTWARE = 3;
  
  private void onReceivedError2(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Object paramObject)
  {
    AppMethodBeat.i(213462);
    onReceivedError(paramWebView, paramWebResourceRequest, new WebResourceErrorInterfaceImpl(paramObject));
    AppMethodBeat.o(213462);
  }
  
  private void onReceivedHttpAuthRequestInner(WebView paramWebView, Object paramObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(213471);
    onReceivedHttpAuthRequest(paramWebView, new HttpAuthHandlerInterfaceImpl(paramObject), paramString1, paramString2);
    AppMethodBeat.o(213471);
  }
  
  private boolean onRenderProcessGoneInner(WebView paramWebView, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(213480);
    paramBoolean = onRenderProcessGone(paramWebView, new RenderProcessGoneDetail(paramBoolean, paramInt));
    AppMethodBeat.o(213480);
    return paramBoolean;
  }
  
  public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean) {}
  
  public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    AppMethodBeat.i(213564);
    paramMessage1.sendToTarget();
    AppMethodBeat.o(213564);
  }
  
  public void onLoadResource(WebView paramWebView, String paramString) {}
  
  public void onPageCommitVisible(WebView paramWebView, String paramString) {}
  
  public void onPageFinished(WebView paramWebView, String paramString) {}
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public void onReceivedClientCertRequest(WebView paramWebView, ClientCertRequest paramClientCertRequest)
  {
    AppMethodBeat.i(213591);
    paramClientCertRequest.cancel();
    AppMethodBeat.o(213591);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceErrorInterface paramWebResourceErrorInterface) {}
  
  public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandlerInterface paramHttpAuthHandlerInterface, String paramString1, String paramString2)
  {
    AppMethodBeat.i(213598);
    paramHttpAuthHandlerInterface.cancel();
    AppMethodBeat.o(213598);
  }
  
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse) {}
  
  public void onReceivedLoginRequest(WebView paramWebView, String paramString1, String paramString2, String paramString3) {}
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    AppMethodBeat.i(213582);
    paramSslErrorHandler.cancel();
    AppMethodBeat.o(213582);
  }
  
  public boolean onRenderProcessGone(WebView paramWebView, RenderProcessGoneDetail paramRenderProcessGoneDetail)
  {
    return false;
  }
  
  public void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2) {}
  
  @Deprecated
  public void onTooManyRedirects(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    AppMethodBeat.i(213534);
    paramMessage1.sendToTarget();
    AppMethodBeat.o(213534);
  }
  
  public void onUnhandledInputEvent(WebView paramWebView, InputEvent paramInputEvent)
  {
    AppMethodBeat.i(213624);
    if ((paramInputEvent instanceof KeyEvent))
    {
      onUnhandledKeyEvent(paramWebView, (KeyEvent)paramInputEvent);
      AppMethodBeat.o(213624);
      return;
    }
    AppMethodBeat.o(213624);
  }
  
  public void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent) {}
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(213527);
    paramWebView = shouldInterceptRequest(paramWebView, paramWebResourceRequest.getUrl().toString());
    AppMethodBeat.o(213527);
    return paramWebView;
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
    AppMethodBeat.i(213491);
    boolean bool = shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest.getUrl().toString());
    AppMethodBeat.o(213491);
    return bool;
  }
  
  @Deprecated
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public class RenderProcessGoneDetail
  {
    private boolean mDidCrash;
    private int mRendererPriorityAtExit;
    
    public RenderProcessGoneDetail(boolean paramBoolean, int paramInt)
    {
      this.mDidCrash = paramBoolean;
      this.mRendererPriorityAtExit = paramInt;
    }
    
    public boolean didCrash()
    {
      return this.mDidCrash;
    }
    
    public int rendererPriorityAtExit()
    {
      return this.mRendererPriorityAtExit;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SafeBrowsingThreat {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.WebViewClient
 * JD-Core Version:    0.7.0.1
 */