package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.p;

class k
  extends X5ProxyWebViewClient
{
  private static String c = null;
  private byte _hellAccFlag_;
  private WebViewClient a;
  private WebView b;
  
  public k(IX5WebViewClient paramIX5WebViewClient, WebView paramWebView, WebViewClient paramWebViewClient)
  {
    super(paramIX5WebViewClient);
    this.b = paramWebView;
    this.a = paramWebViewClient;
    this.a.a = this;
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(219575);
    super.onPageStarted(this.b.c(), 0, 0, paramString, paramBitmap);
    AppMethodBeat.o(219575);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(55321);
    Object localObject = new Intent("android.intent.action.DIAL", Uri.parse(paramString));
    ((Intent)localObject).addFlags(268435456);
    try
    {
      if (this.b.getContext() != null)
      {
        paramString = this.b.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/smtt/sdk/k", "a", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/smtt/sdk/k", "a", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(55321);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(55321);
    }
  }
  
  public void countPVContentCacheCallBack(String paramString)
  {
    paramString = this.b;
    paramString.a += 1;
  }
  
  public void doUpdateVisitedHistory(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(219435);
    this.b.a(paramIX5WebViewBase);
    this.a.doUpdateVisitedHistory(this.b, paramString, paramBoolean);
    AppMethodBeat.o(219435);
  }
  
  public void onDetectedBlankScreen(IX5WebViewBase paramIX5WebViewBase, String paramString, int paramInt)
  {
    AppMethodBeat.i(219580);
    this.b.a(paramIX5WebViewBase);
    this.a.onDetectedBlankScreen(paramString, paramInt);
    AppMethodBeat.o(219580);
  }
  
  public void onFormResubmission(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    AppMethodBeat.i(219440);
    this.b.a(paramIX5WebViewBase);
    this.a.onFormResubmission(this.b, paramMessage1, paramMessage2);
    AppMethodBeat.o(219440);
  }
  
  public void onLoadResource(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(219443);
    this.b.a(paramIX5WebViewBase);
    this.a.onLoadResource(this.b, paramString);
    AppMethodBeat.o(219443);
  }
  
  public void onPageCommitVisible(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(219594);
    this.b.a(paramIX5WebViewBase);
    this.a.onPageCommitVisible(this.b, paramString);
    AppMethodBeat.o(219594);
  }
  
  public void onPageFinished(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(219452);
    TbsLog.v("TbsPerfTest", "PageLoadFinished!");
    if (c == null)
    {
      localObject = p.a();
      if (localObject != null)
      {
        ((p)localObject).a(false);
        c = Boolean.toString(false);
      }
    }
    this.b.a(paramIX5WebViewBase);
    Object localObject = this.b;
    ((WebView)localObject).a += 1;
    this.a.onPageFinished(this.b, paramString);
    TbsLog.d("sdkreport", "SmttWebViewclient.onPageFinished--Pv=" + this.b.a);
    if ("com.qzone".equals(paramIX5WebViewBase.getView().getContext().getApplicationInfo().packageName)) {
      this.b.a(paramIX5WebViewBase.getView().getContext());
    }
    TbsLog.app_extra("SmttWebViewClient", paramIX5WebViewBase.getView().getContext());
    try
    {
      super.onPageFinished(paramIX5WebViewBase, paramInt1, paramInt2, paramString);
      label169:
      WebView.d();
      if ((!TbsShareManager.mHasQueryed) && (this.b.getContext() != null) && (TbsShareManager.isThirdPartyApp(this.b.getContext())))
      {
        TbsShareManager.mHasQueryed = true;
        new Thread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(219737);
            if ((!TbsShareManager.forceLoadX5FromTBSDemo(k.a(k.this).getContext())) && (TbsDownloader.needDownload(k.a(k.this).getContext(), false))) {
              TbsDownloader.startDownload(k.a(k.this).getContext());
            }
            AppMethodBeat.o(219737);
          }
        }).start();
      }
      if ((this.b.getContext() != null) && (!TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport()))
      {
        TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
        TbsLogReport.getInstance(this.b.getContext()).dailyReport();
      }
      AppMethodBeat.o(219452);
      return;
    }
    catch (Exception paramIX5WebViewBase)
    {
      break label169;
    }
  }
  
  public void onPageFinished(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(219584);
    onPageFinished(paramIX5WebViewBase, 0, 0, paramString);
    AppMethodBeat.o(219584);
  }
  
  public void onPageStarted(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(219457);
    this.b.a(paramIX5WebViewBase);
    this.a.onPageStarted(this.b, paramString, paramBitmap);
    AppMethodBeat.o(219457);
  }
  
  public void onPageStarted(IX5WebViewBase paramIX5WebViewBase, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(219587);
    onPageStarted(paramIX5WebViewBase, 0, 0, paramString, paramBitmap);
    AppMethodBeat.o(219587);
  }
  
  public void onReceivedClientCertRequest(IX5WebViewBase paramIX5WebViewBase, ClientCertRequest paramClientCertRequest)
  {
    AppMethodBeat.i(219504);
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedClientCertRequest(this.b, paramClientCertRequest);
    AppMethodBeat.o(219504);
  }
  
  public void onReceivedError(IX5WebViewBase paramIX5WebViewBase, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(219467);
    int i = paramInt;
    if (paramInt < -15)
    {
      if (paramInt == -17) {
        i = -1;
      }
    }
    else
    {
      this.b.a(paramIX5WebViewBase);
      this.a.onReceivedError(this.b, i, paramString1, paramString2);
      AppMethodBeat.o(219467);
      return;
    }
    AppMethodBeat.o(219467);
  }
  
  public void onReceivedError(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    AppMethodBeat.i(219461);
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedError(this.b, paramWebResourceRequest, paramWebResourceError);
    AppMethodBeat.o(219461);
  }
  
  public void onReceivedHttpAuthRequest(IX5WebViewBase paramIX5WebViewBase, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    AppMethodBeat.i(219490);
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedHttpAuthRequest(this.b, paramHttpAuthHandler, paramString1, paramString2);
    AppMethodBeat.o(219490);
  }
  
  public void onReceivedHttpError(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    AppMethodBeat.i(219472);
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedHttpError(this.b, paramWebResourceRequest, paramWebResourceResponse);
    AppMethodBeat.o(219472);
  }
  
  public void onReceivedLoginRequest(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(219570);
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedLoginRequest(this.b, paramString1, paramString2, paramString3);
    AppMethodBeat.o(219570);
  }
  
  public void onReceivedSslError(IX5WebViewBase paramIX5WebViewBase, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    AppMethodBeat.i(219495);
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedSslError(this.b, paramSslErrorHandler, paramSslError);
    AppMethodBeat.o(219495);
  }
  
  public void onScaleChanged(IX5WebViewBase paramIX5WebViewBase, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(219508);
    this.b.a(paramIX5WebViewBase);
    this.a.onScaleChanged(this.b, paramFloat1, paramFloat2);
    AppMethodBeat.o(219508);
  }
  
  public void onTooManyRedirects(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    AppMethodBeat.i(219539);
    this.b.a(paramIX5WebViewBase);
    this.a.onTooManyRedirects(this.b, paramMessage1, paramMessage2);
    AppMethodBeat.o(219539);
  }
  
  public void onUnhandledKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(219515);
    this.b.a(paramIX5WebViewBase);
    this.a.onUnhandledKeyEvent(this.b, paramKeyEvent);
    AppMethodBeat.o(219515);
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(219555);
    this.b.a(paramIX5WebViewBase);
    paramIX5WebViewBase = this.a.shouldInterceptRequest(this.b, paramWebResourceRequest);
    AppMethodBeat.o(219555);
    return paramIX5WebViewBase;
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(219563);
    this.b.a(paramIX5WebViewBase);
    paramIX5WebViewBase = this.a.shouldInterceptRequest(this.b, paramWebResourceRequest, paramBundle);
    AppMethodBeat.o(219563);
    return paramIX5WebViewBase;
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(219550);
    this.b.a(paramIX5WebViewBase);
    paramIX5WebViewBase = this.a.shouldInterceptRequest(this.b, paramString);
    AppMethodBeat.o(219550);
    return paramIX5WebViewBase;
  }
  
  public boolean shouldOverrideKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(219522);
    this.b.a(paramIX5WebViewBase);
    boolean bool = this.a.shouldOverrideKeyEvent(this.b, paramKeyEvent);
    AppMethodBeat.o(219522);
    return bool;
  }
  
  public boolean shouldOverrideUrlLoading(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(219546);
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null)) {}
    for (String str = paramWebResourceRequest.getUrl().toString();; str = null)
    {
      if ((str == null) || (this.b.showDebugView(str)))
      {
        AppMethodBeat.o(219546);
        return true;
      }
      this.b.a(paramIX5WebViewBase);
      boolean bool = this.a.shouldOverrideUrlLoading(this.b, paramWebResourceRequest);
      if (!bool)
      {
        if (str.startsWith("wtai://wp/mc;"))
        {
          paramWebResourceRequest = new Intent("android.intent.action.VIEW", Uri.parse("tel:" + str.substring(13)));
          paramIX5WebViewBase = this.b.getContext();
          paramWebResourceRequest = new com.tencent.mm.hellhoundlib.b.a().cG(paramWebResourceRequest);
          com.tencent.mm.hellhoundlib.a.a.b(paramIX5WebViewBase, paramWebResourceRequest.aYi(), "com/tencent/smtt/sdk/k", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;Lcom/tencent/smtt/export/external/interfaces/WebResourceRequest;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramIX5WebViewBase.startActivity((Intent)paramWebResourceRequest.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramIX5WebViewBase, "com/tencent/smtt/sdk/k", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;Lcom/tencent/smtt/export/external/interfaces/WebResourceRequest;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(219546);
          return true;
        }
        if (str.startsWith("tel:"))
        {
          a(str);
          AppMethodBeat.o(219546);
          return true;
        }
      }
      AppMethodBeat.o(219546);
      return bool;
    }
  }
  
  public boolean shouldOverrideUrlLoading(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(219534);
    if ((paramString == null) || (this.b.showDebugView(paramString)))
    {
      AppMethodBeat.o(219534);
      return true;
    }
    this.b.a(paramIX5WebViewBase);
    boolean bool = this.a.shouldOverrideUrlLoading(this.b, paramString);
    if (!bool)
    {
      if (paramString.startsWith("wtai://wp/mc;"))
      {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse("tel:" + paramString.substring(13)));
        paramIX5WebViewBase = this.b.getContext();
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(paramIX5WebViewBase, paramString.aYi(), "com/tencent/smtt/sdk/k", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramIX5WebViewBase.startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramIX5WebViewBase, "com/tencent/smtt/sdk/k", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(219534);
        return true;
      }
      if (paramString.startsWith("tel:"))
      {
        a(paramString);
        AppMethodBeat.o(219534);
        return true;
      }
    }
    AppMethodBeat.o(219534);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.k
 * JD-Core Version:    0.7.0.1
 */