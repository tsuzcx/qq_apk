package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.r;
import com.tencent.smtt.utils.w;
import java.io.InputStream;
import java.util.Map;

@SuppressLint({"NewApi", "Override"})
class ae
  extends android.webkit.WebViewClient
{
  private static String c = null;
  private WebViewClient a;
  private WebView b;
  
  ae(WebView paramWebView, WebViewClient paramWebViewClient)
  {
    this.b = paramWebView;
    this.a = paramWebViewClient;
  }
  
  public void doUpdateVisitedHistory(android.webkit.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(139187);
    this.b.a(paramWebView);
    this.a.doUpdateVisitedHistory(this.b, paramString, paramBoolean);
    AppMethodBeat.o(139187);
  }
  
  public void onFormResubmission(android.webkit.WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    AppMethodBeat.i(139180);
    this.b.a(paramWebView);
    this.a.onFormResubmission(this.b, paramMessage1, paramMessage2);
    AppMethodBeat.o(139180);
  }
  
  public void onLoadResource(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(139175);
    this.b.a(paramWebView);
    this.a.onLoadResource(this.b, paramString);
    AppMethodBeat.o(139175);
  }
  
  public void onPageFinished(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(139181);
    if (c == null)
    {
      localObject = w.a();
      if (localObject != null)
      {
        ((w)localObject).a(true);
        c = Boolean.toString(true);
      }
    }
    this.b.a(paramWebView);
    Object localObject = this.b;
    ((WebView)localObject).a += 1;
    this.a.onPageFinished(this.b, paramString);
    if ("com.qzone".equals(paramWebView.getContext().getApplicationInfo().packageName)) {
      this.b.a(paramWebView.getContext());
    }
    TbsLog.app_extra("SystemWebViewClient", paramWebView.getContext());
    WebView.d();
    if ((!TbsShareManager.mHasQueryed) && (this.b.getContext() != null) && (TbsShareManager.isThirdPartyApp(this.b.getContext())))
    {
      TbsShareManager.mHasQueryed = true;
      new Thread(new af(this)).start();
    }
    if ((this.b.getContext() != null) && (!TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport()))
    {
      TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
      TbsLogReport.getInstance(this.b.getContext()).dailyReport();
    }
    AppMethodBeat.o(139181);
  }
  
  public void onPageStarted(android.webkit.WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(139182);
    this.b.a(paramWebView);
    this.a.onPageStarted(this.b, paramString, paramBitmap);
    AppMethodBeat.o(139182);
  }
  
  public void onReceivedClientCertRequest(android.webkit.WebView paramWebView, ClientCertRequest paramClientCertRequest)
  {
    AppMethodBeat.i(139190);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.b.a(paramWebView);
      paramWebView = new ae.a(paramClientCertRequest);
      this.a.onReceivedClientCertRequest(this.b, paramWebView);
    }
    AppMethodBeat.o(139190);
  }
  
  public void onReceivedError(android.webkit.WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(139183);
    this.b.a(paramWebView);
    this.a.onReceivedError(this.b, paramInt, paramString1, paramString2);
    AppMethodBeat.o(139183);
  }
  
  public void onReceivedError(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    Object localObject = null;
    AppMethodBeat.i(139184);
    this.b.a(paramWebView);
    if (paramWebResourceRequest != null) {}
    for (paramWebView = new f(paramWebResourceRequest);; paramWebView = null)
    {
      paramWebResourceRequest = localObject;
      if (paramWebResourceError != null) {
        paramWebResourceRequest = new ag(this, paramWebResourceError);
      }
      this.a.onReceivedError(this.b, paramWebView, paramWebResourceRequest);
      AppMethodBeat.o(139184);
      return;
    }
  }
  
  public void onReceivedHttpAuthRequest(android.webkit.WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    AppMethodBeat.i(139186);
    this.b.a(paramWebView);
    this.a.onReceivedHttpAuthRequest(this.b, new ae.b(paramHttpAuthHandler), paramString1, paramString2);
    AppMethodBeat.o(139186);
  }
  
  public void onReceivedHttpError(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest, android.webkit.WebResourceResponse paramWebResourceResponse)
  {
    AppMethodBeat.i(139185);
    this.b.a(paramWebView);
    paramWebView = new f(paramWebResourceRequest);
    paramWebResourceRequest = new g(paramWebResourceResponse);
    this.a.onReceivedHttpError(this.b, paramWebView, paramWebResourceRequest);
    AppMethodBeat.o(139185);
  }
  
  @TargetApi(12)
  public void onReceivedLoginRequest(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(139188);
    if (Build.VERSION.SDK_INT >= 12)
    {
      this.b.a(paramWebView);
      this.a.onReceivedLoginRequest(this.b, paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(139188);
  }
  
  @TargetApi(8)
  public void onReceivedSslError(android.webkit.WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    AppMethodBeat.i(139189);
    if (Build.VERSION.SDK_INT >= 8)
    {
      this.b.a(paramWebView);
      this.a.onReceivedSslError(this.b, new ae.c(paramSslErrorHandler), new ae.d(paramSslError));
    }
    AppMethodBeat.o(139189);
  }
  
  public void onScaleChanged(android.webkit.WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(139191);
    this.b.a(paramWebView);
    this.a.onScaleChanged(this.b, paramFloat1, paramFloat2);
    AppMethodBeat.o(139191);
  }
  
  public void onTooManyRedirects(android.webkit.WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    AppMethodBeat.i(139192);
    this.b.a(paramWebView);
    this.a.onTooManyRedirects(this.b, paramMessage1, paramMessage2);
    AppMethodBeat.o(139192);
  }
  
  public void onUnhandledKeyEvent(android.webkit.WebView paramWebView, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(139193);
    this.b.a(paramWebView);
    this.a.onUnhandledKeyEvent(this.b, paramKeyEvent);
    AppMethodBeat.o(139193);
  }
  
  public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(139178);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(139178);
      return null;
    }
    if (paramWebResourceRequest == null)
    {
      AppMethodBeat.o(139178);
      return null;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramWebView = r.a(paramWebResourceRequest, "isRedirect");
      bool1 = bool2;
      if ((paramWebView instanceof Boolean)) {
        bool1 = ((Boolean)paramWebView).booleanValue();
      }
    }
    paramWebView = new e(paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.isForMainFrame(), bool1, paramWebResourceRequest.hasGesture(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.getRequestHeaders());
    paramWebResourceRequest = this.a.shouldInterceptRequest(this.b, paramWebView);
    if (paramWebResourceRequest == null)
    {
      AppMethodBeat.o(139178);
      return null;
    }
    paramWebView = new android.webkit.WebResourceResponse(paramWebResourceRequest.getMimeType(), paramWebResourceRequest.getEncoding(), paramWebResourceRequest.getData());
    paramWebView.setResponseHeaders(paramWebResourceRequest.getResponseHeaders());
    int i = paramWebResourceRequest.getStatusCode();
    paramWebResourceRequest = paramWebResourceRequest.getReasonPhrase();
    if ((i != paramWebView.getStatusCode()) || ((paramWebResourceRequest != null) && (!paramWebResourceRequest.equals(paramWebView.getReasonPhrase())))) {
      paramWebView.setStatusCodeAndReasonPhrase(i, paramWebResourceRequest);
    }
    AppMethodBeat.o(139178);
    return paramWebView;
  }
  
  @TargetApi(11)
  public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(139177);
    if (Build.VERSION.SDK_INT < 11)
    {
      AppMethodBeat.o(139177);
      return null;
    }
    paramWebView = this.a.shouldInterceptRequest(this.b, paramString);
    if (paramWebView == null)
    {
      AppMethodBeat.o(139177);
      return null;
    }
    paramWebView = new android.webkit.WebResourceResponse(paramWebView.getMimeType(), paramWebView.getEncoding(), paramWebView.getData());
    AppMethodBeat.o(139177);
    return paramWebView;
  }
  
  public boolean shouldOverrideKeyEvent(android.webkit.WebView paramWebView, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(139179);
    this.b.a(paramWebView);
    boolean bool = this.a.shouldOverrideKeyEvent(this.b, paramKeyEvent);
    AppMethodBeat.o(139179);
    return bool;
  }
  
  public boolean shouldOverrideUrlLoading(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(139176);
    if ((paramString == null) || (this.b.showDebugView(paramString)))
    {
      AppMethodBeat.o(139176);
      return true;
    }
    this.b.a(paramWebView);
    boolean bool = this.a.shouldOverrideUrlLoading(this.b, paramString);
    AppMethodBeat.o(139176);
    return bool;
  }
  
  class e
    implements com.tencent.smtt.export.external.interfaces.WebResourceRequest
  {
    private String b;
    private boolean c;
    private boolean d;
    private boolean e;
    private String f;
    private Map<String, String> g;
    
    public e(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Map<String, String> paramMap)
    {
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = paramBoolean3;
      this.e = paramString;
      this.f = paramMap;
      Object localObject;
      this.g = localObject;
    }
    
    public String getMethod()
    {
      return this.f;
    }
    
    public Map<String, String> getRequestHeaders()
    {
      return this.g;
    }
    
    public Uri getUrl()
    {
      AppMethodBeat.i(139157);
      Uri localUri = Uri.parse(this.b);
      AppMethodBeat.o(139157);
      return localUri;
    }
    
    public boolean hasGesture()
    {
      return this.e;
    }
    
    public boolean isForMainFrame()
    {
      return this.c;
    }
    
    public boolean isRedirect()
    {
      return this.d;
    }
  }
  
  static class f
    implements com.tencent.smtt.export.external.interfaces.WebResourceRequest
  {
    android.webkit.WebResourceRequest a;
    
    f(android.webkit.WebResourceRequest paramWebResourceRequest)
    {
      this.a = paramWebResourceRequest;
    }
    
    public String getMethod()
    {
      AppMethodBeat.i(139158);
      String str = this.a.getMethod();
      AppMethodBeat.o(139158);
      return str;
    }
    
    public Map<String, String> getRequestHeaders()
    {
      AppMethodBeat.i(139159);
      Map localMap = this.a.getRequestHeaders();
      AppMethodBeat.o(139159);
      return localMap;
    }
    
    public Uri getUrl()
    {
      AppMethodBeat.i(139160);
      Uri localUri = this.a.getUrl();
      AppMethodBeat.o(139160);
      return localUri;
    }
    
    public boolean hasGesture()
    {
      AppMethodBeat.i(139161);
      boolean bool = this.a.hasGesture();
      AppMethodBeat.o(139161);
      return bool;
    }
    
    public boolean isForMainFrame()
    {
      AppMethodBeat.i(139162);
      boolean bool = this.a.isForMainFrame();
      AppMethodBeat.o(139162);
      return bool;
    }
    
    public boolean isRedirect()
    {
      AppMethodBeat.i(139163);
      Object localObject;
      if (Build.VERSION.SDK_INT >= 24)
      {
        localObject = r.a(this.a, "isRedirect");
        if (!(localObject instanceof Boolean)) {}
      }
      for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
      {
        AppMethodBeat.o(139163);
        return bool;
      }
    }
  }
  
  static class g
    extends com.tencent.smtt.export.external.interfaces.WebResourceResponse
  {
    android.webkit.WebResourceResponse a;
    
    public g(android.webkit.WebResourceResponse paramWebResourceResponse)
    {
      this.a = paramWebResourceResponse;
    }
    
    public InputStream getData()
    {
      AppMethodBeat.i(139164);
      InputStream localInputStream = this.a.getData();
      AppMethodBeat.o(139164);
      return localInputStream;
    }
    
    public String getEncoding()
    {
      AppMethodBeat.i(139165);
      String str = this.a.getEncoding();
      AppMethodBeat.o(139165);
      return str;
    }
    
    public String getMimeType()
    {
      AppMethodBeat.i(139166);
      String str = this.a.getMimeType();
      AppMethodBeat.o(139166);
      return str;
    }
    
    public String getReasonPhrase()
    {
      AppMethodBeat.i(139167);
      String str = this.a.getReasonPhrase();
      AppMethodBeat.o(139167);
      return str;
    }
    
    public Map<String, String> getResponseHeaders()
    {
      AppMethodBeat.i(139168);
      Map localMap = this.a.getResponseHeaders();
      AppMethodBeat.o(139168);
      return localMap;
    }
    
    public int getStatusCode()
    {
      AppMethodBeat.i(139169);
      int i = this.a.getStatusCode();
      AppMethodBeat.o(139169);
      return i;
    }
    
    public void setData(InputStream paramInputStream)
    {
      AppMethodBeat.i(139170);
      this.a.setData(paramInputStream);
      AppMethodBeat.o(139170);
    }
    
    public void setEncoding(String paramString)
    {
      AppMethodBeat.i(139171);
      this.a.setEncoding(paramString);
      AppMethodBeat.o(139171);
    }
    
    public void setMimeType(String paramString)
    {
      AppMethodBeat.i(139172);
      this.a.setMimeType(paramString);
      AppMethodBeat.o(139172);
    }
    
    public void setResponseHeaders(Map<String, String> paramMap)
    {
      AppMethodBeat.i(139173);
      this.a.setResponseHeaders(paramMap);
      AppMethodBeat.o(139173);
    }
    
    public void setStatusCodeAndReasonPhrase(int paramInt, String paramString)
    {
      AppMethodBeat.i(139174);
      this.a.setStatusCodeAndReasonPhrase(paramInt, paramString);
      AppMethodBeat.o(139174);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.ae
 * JD-Core Version:    0.7.0.1
 */