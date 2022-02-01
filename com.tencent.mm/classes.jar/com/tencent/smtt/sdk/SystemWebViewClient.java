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
import android.webkit.SslErrorHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.p;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

@SuppressLint({"NewApi", "Override"})
class SystemWebViewClient
  extends android.webkit.WebViewClient
{
  private static String c = null;
  private WebViewClient a;
  private WebView b;
  
  SystemWebViewClient(WebView paramWebView, WebViewClient paramWebViewClient)
  {
    this.b = paramWebView;
    this.a = paramWebViewClient;
  }
  
  public void doUpdateVisitedHistory(android.webkit.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54706);
    this.b.a(paramWebView);
    this.a.doUpdateVisitedHistory(this.b, paramString, paramBoolean);
    AppMethodBeat.o(54706);
  }
  
  public void onFormResubmission(android.webkit.WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    AppMethodBeat.i(54699);
    this.b.a(paramWebView);
    this.a.onFormResubmission(this.b, paramMessage1, paramMessage2);
    AppMethodBeat.o(54699);
  }
  
  public void onLoadResource(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(54693);
    this.b.a(paramWebView);
    this.a.onLoadResource(this.b, paramString);
    AppMethodBeat.o(54693);
  }
  
  public void onPageCommitVisible(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(54713);
    this.b.a(paramWebView);
    this.a.onPageCommitVisible(this.b, paramString);
    AppMethodBeat.o(54713);
  }
  
  public void onPageFinished(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(54700);
    TbsLog.v("TbsPerfTest", "PageLoadFinished!");
    if (c == null)
    {
      localObject = p.a();
      if (localObject != null)
      {
        ((p)localObject).a(true);
        c = Boolean.toString(true);
      }
    }
    this.b.a(paramWebView);
    Object localObject = this.b;
    ((WebView)localObject).a += 1;
    this.a.onPageFinished(this.b, paramString);
    TbsLog.d("sdkreport", "SystemWebViewclient.onPageFinished--Pv=" + this.b.a);
    if ("com.qzone".equals(paramWebView.getContext().getApplicationInfo().packageName)) {
      this.b.a(paramWebView.getContext());
    }
    TbsLog.app_extra("SystemWebViewClient", paramWebView.getContext());
    WebView.d();
    if ((!TbsShareManager.mHasQueryed) && (this.b.getContext() != null) && (TbsShareManager.isThirdPartyApp(this.b.getContext())))
    {
      TbsShareManager.mHasQueryed = true;
      new Thread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(55114);
          if ((!TbsShareManager.forceLoadX5FromTBSDemo(SystemWebViewClient.a(SystemWebViewClient.this).getContext())) && (TbsDownloader.needDownload(SystemWebViewClient.a(SystemWebViewClient.this).getContext(), false))) {
            TbsDownloader.startDownload(SystemWebViewClient.a(SystemWebViewClient.this).getContext());
          }
          AppMethodBeat.o(55114);
        }
      }).start();
    }
    if ((this.b.getContext() != null) && (!TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport()))
    {
      TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
      TbsLogReport.getInstance(this.b.getContext()).dailyReport();
    }
    AppMethodBeat.o(54700);
  }
  
  public void onPageStarted(android.webkit.WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(54701);
    this.b.a(paramWebView);
    this.a.onPageStarted(this.b, paramString, paramBitmap);
    AppMethodBeat.o(54701);
  }
  
  public void onReceivedClientCertRequest(android.webkit.WebView paramWebView, android.webkit.ClientCertRequest paramClientCertRequest)
  {
    AppMethodBeat.i(54709);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.b.a(paramWebView);
      paramWebView = new a(paramClientCertRequest);
      this.a.onReceivedClientCertRequest(this.b, paramWebView);
    }
    AppMethodBeat.o(54709);
  }
  
  public void onReceivedError(android.webkit.WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(54702);
    this.b.a(paramWebView);
    this.a.onReceivedError(this.b, paramInt, paramString1, paramString2);
    AppMethodBeat.o(54702);
  }
  
  public void onReceivedError(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest, final android.webkit.WebResourceError paramWebResourceError)
  {
    Object localObject = null;
    AppMethodBeat.i(54703);
    this.b.a(paramWebView);
    if (paramWebResourceRequest != null) {}
    for (paramWebView = new f(paramWebResourceRequest);; paramWebView = null)
    {
      paramWebResourceRequest = localObject;
      if (paramWebResourceError != null) {
        paramWebResourceRequest = new com.tencent.smtt.export.external.interfaces.WebResourceError()
        {
          public CharSequence getDescription()
          {
            AppMethodBeat.i(54935);
            CharSequence localCharSequence = paramWebResourceError.getDescription();
            AppMethodBeat.o(54935);
            return localCharSequence;
          }
          
          public int getErrorCode()
          {
            AppMethodBeat.i(54936);
            int i = paramWebResourceError.getErrorCode();
            AppMethodBeat.o(54936);
            return i;
          }
        };
      }
      this.a.onReceivedError(this.b, paramWebView, paramWebResourceRequest);
      AppMethodBeat.o(54703);
      return;
    }
  }
  
  public void onReceivedHttpAuthRequest(android.webkit.WebView paramWebView, android.webkit.HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    AppMethodBeat.i(54705);
    this.b.a(paramWebView);
    this.a.onReceivedHttpAuthRequest(this.b, new b(paramHttpAuthHandler), paramString1, paramString2);
    AppMethodBeat.o(54705);
  }
  
  public void onReceivedHttpError(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest, android.webkit.WebResourceResponse paramWebResourceResponse)
  {
    AppMethodBeat.i(54704);
    this.b.a(paramWebView);
    paramWebView = new f(paramWebResourceRequest);
    paramWebResourceRequest = new SystemWebViewClient.g(paramWebResourceResponse);
    this.a.onReceivedHttpError(this.b, paramWebView, paramWebResourceRequest);
    AppMethodBeat.o(54704);
  }
  
  @TargetApi(12)
  public void onReceivedLoginRequest(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(54707);
    if (Build.VERSION.SDK_INT >= 12)
    {
      this.b.a(paramWebView);
      this.a.onReceivedLoginRequest(this.b, paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(54707);
  }
  
  @TargetApi(8)
  public void onReceivedSslError(android.webkit.WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    AppMethodBeat.i(54708);
    if (Build.VERSION.SDK_INT >= 8)
    {
      this.b.a(paramWebView);
      this.a.onReceivedSslError(this.b, new SystemWebViewClient.c(paramSslErrorHandler), new SystemWebViewClient.d(paramSslError));
    }
    AppMethodBeat.o(54708);
  }
  
  public void onScaleChanged(android.webkit.WebView paramWebView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(54710);
    this.b.a(paramWebView);
    this.a.onScaleChanged(this.b, paramFloat1, paramFloat2);
    AppMethodBeat.o(54710);
  }
  
  public void onTooManyRedirects(android.webkit.WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    AppMethodBeat.i(54711);
    this.b.a(paramWebView);
    this.a.onTooManyRedirects(this.b, paramMessage1, paramMessage2);
    AppMethodBeat.o(54711);
  }
  
  public void onUnhandledKeyEvent(android.webkit.WebView paramWebView, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(54712);
    this.b.a(paramWebView);
    this.a.onUnhandledKeyEvent(this.b, paramKeyEvent);
    AppMethodBeat.o(54712);
  }
  
  public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(54697);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(54697);
      return null;
    }
    if (paramWebResourceRequest == null)
    {
      AppMethodBeat.o(54697);
      return null;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramWebView = k.a(paramWebResourceRequest, "isRedirect");
      bool1 = bool2;
      if ((paramWebView instanceof Boolean)) {
        bool1 = ((Boolean)paramWebView).booleanValue();
      }
    }
    paramWebView = new SystemWebViewClient.e(this, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.isForMainFrame(), bool1, paramWebResourceRequest.hasGesture(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.getRequestHeaders());
    paramWebResourceRequest = this.a.shouldInterceptRequest(this.b, paramWebView);
    if (paramWebResourceRequest == null)
    {
      AppMethodBeat.o(54697);
      return null;
    }
    paramWebView = new android.webkit.WebResourceResponse(paramWebResourceRequest.getMimeType(), paramWebResourceRequest.getEncoding(), paramWebResourceRequest.getData());
    paramWebView.setResponseHeaders(paramWebResourceRequest.getResponseHeaders());
    int i = paramWebResourceRequest.getStatusCode();
    paramWebResourceRequest = paramWebResourceRequest.getReasonPhrase();
    if ((i != paramWebView.getStatusCode()) || ((paramWebResourceRequest != null) && (!paramWebResourceRequest.equals(paramWebView.getReasonPhrase())))) {
      paramWebView.setStatusCodeAndReasonPhrase(i, paramWebResourceRequest);
    }
    AppMethodBeat.o(54697);
    return paramWebView;
  }
  
  @TargetApi(11)
  public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(54696);
    if (Build.VERSION.SDK_INT < 11)
    {
      AppMethodBeat.o(54696);
      return null;
    }
    paramWebView = this.a.shouldInterceptRequest(this.b, paramString);
    if (paramWebView == null)
    {
      AppMethodBeat.o(54696);
      return null;
    }
    paramWebView = new android.webkit.WebResourceResponse(paramWebView.getMimeType(), paramWebView.getEncoding(), paramWebView.getData());
    AppMethodBeat.o(54696);
    return paramWebView;
  }
  
  public boolean shouldOverrideKeyEvent(android.webkit.WebView paramWebView, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(54698);
    this.b.a(paramWebView);
    boolean bool = this.a.shouldOverrideKeyEvent(this.b, paramKeyEvent);
    AppMethodBeat.o(54698);
    return bool;
  }
  
  public boolean shouldOverrideUrlLoading(android.webkit.WebView paramWebView, android.webkit.WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(54695);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramWebResourceRequest != null)
    {
      localObject1 = localObject2;
      if (paramWebResourceRequest.getUrl() != null) {
        localObject1 = paramWebResourceRequest.getUrl().toString();
      }
    }
    if ((localObject1 == null) || (this.b.showDebugView((String)localObject1)))
    {
      AppMethodBeat.o(54695);
      return true;
    }
    this.b.a(paramWebView);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramWebView = k.a(paramWebResourceRequest, "isRedirect");
      bool1 = bool2;
      if ((paramWebView instanceof Boolean)) {
        bool1 = ((Boolean)paramWebView).booleanValue();
      }
    }
    paramWebView = new SystemWebViewClient.e(this, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.isForMainFrame(), bool1, paramWebResourceRequest.hasGesture(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.getRequestHeaders());
    bool1 = this.a.shouldOverrideUrlLoading(this.b, paramWebView);
    AppMethodBeat.o(54695);
    return bool1;
  }
  
  public boolean shouldOverrideUrlLoading(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(54694);
    if ((paramString == null) || (this.b.showDebugView(paramString)))
    {
      AppMethodBeat.o(54694);
      return true;
    }
    this.b.a(paramWebView);
    boolean bool = this.a.shouldOverrideUrlLoading(this.b, paramString);
    AppMethodBeat.o(54694);
    return bool;
  }
  
  static class a
    extends com.tencent.smtt.export.external.interfaces.ClientCertRequest
  {
    private android.webkit.ClientCertRequest a;
    
    public a(android.webkit.ClientCertRequest paramClientCertRequest)
    {
      this.a = paramClientCertRequest;
    }
    
    public void cancel()
    {
      AppMethodBeat.i(55053);
      this.a.cancel();
      AppMethodBeat.o(55053);
    }
    
    public String getHost()
    {
      AppMethodBeat.i(55054);
      String str = this.a.getHost();
      AppMethodBeat.o(55054);
      return str;
    }
    
    public String[] getKeyTypes()
    {
      AppMethodBeat.i(55055);
      String[] arrayOfString = this.a.getKeyTypes();
      AppMethodBeat.o(55055);
      return arrayOfString;
    }
    
    public int getPort()
    {
      AppMethodBeat.i(55056);
      int i = this.a.getPort();
      AppMethodBeat.o(55056);
      return i;
    }
    
    public Principal[] getPrincipals()
    {
      AppMethodBeat.i(55057);
      Principal[] arrayOfPrincipal = this.a.getPrincipals();
      AppMethodBeat.o(55057);
      return arrayOfPrincipal;
    }
    
    public void ignore()
    {
      AppMethodBeat.i(55058);
      this.a.ignore();
      AppMethodBeat.o(55058);
    }
    
    public void proceed(PrivateKey paramPrivateKey, X509Certificate[] paramArrayOfX509Certificate)
    {
      AppMethodBeat.i(55059);
      this.a.proceed(paramPrivateKey, paramArrayOfX509Certificate);
      AppMethodBeat.o(55059);
    }
  }
  
  static class b
    implements com.tencent.smtt.export.external.interfaces.HttpAuthHandler
  {
    private android.webkit.HttpAuthHandler a;
    
    b(android.webkit.HttpAuthHandler paramHttpAuthHandler)
    {
      this.a = paramHttpAuthHandler;
    }
    
    public void cancel()
    {
      AppMethodBeat.i(54323);
      this.a.cancel();
      AppMethodBeat.o(54323);
    }
    
    public void proceed(String paramString1, String paramString2)
    {
      AppMethodBeat.i(54322);
      this.a.proceed(paramString1, paramString2);
      AppMethodBeat.o(54322);
    }
    
    public boolean useHttpAuthUsernamePassword()
    {
      AppMethodBeat.i(54324);
      boolean bool = this.a.useHttpAuthUsernamePassword();
      AppMethodBeat.o(54324);
      return bool;
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
      AppMethodBeat.i(55007);
      String str = this.a.getMethod();
      AppMethodBeat.o(55007);
      return str;
    }
    
    public Map<String, String> getRequestHeaders()
    {
      AppMethodBeat.i(55008);
      Map localMap = this.a.getRequestHeaders();
      AppMethodBeat.o(55008);
      return localMap;
    }
    
    public Uri getUrl()
    {
      AppMethodBeat.i(55009);
      Uri localUri = this.a.getUrl();
      AppMethodBeat.o(55009);
      return localUri;
    }
    
    public boolean hasGesture()
    {
      AppMethodBeat.i(55010);
      boolean bool = this.a.hasGesture();
      AppMethodBeat.o(55010);
      return bool;
    }
    
    public boolean isForMainFrame()
    {
      AppMethodBeat.i(55011);
      boolean bool = this.a.isForMainFrame();
      AppMethodBeat.o(55011);
      return bool;
    }
    
    public boolean isRedirect()
    {
      AppMethodBeat.i(55012);
      Object localObject;
      if (Build.VERSION.SDK_INT >= 24)
      {
        localObject = k.a(this.a, "isRedirect");
        if (!(localObject instanceof Boolean)) {}
      }
      for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
      {
        AppMethodBeat.o(55012);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient
 * JD-Core Version:    0.7.0.1
 */