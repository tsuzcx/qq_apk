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
import com.tencent.smtt.utils.o;

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
    AppMethodBeat.i(192735);
    super.onPageStarted(this.b.c(), 0, 0, paramString, paramBitmap);
    AppMethodBeat.o(192735);
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/smtt/sdk/k", "a", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/smtt/sdk/k", "a", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    AppMethodBeat.i(192714);
    this.b.a(paramIX5WebViewBase);
    this.a.doUpdateVisitedHistory(this.b, paramString, paramBoolean);
    AppMethodBeat.o(192714);
  }
  
  public void onDetectedBlankScreen(IX5WebViewBase paramIX5WebViewBase, String paramString, int paramInt)
  {
    AppMethodBeat.i(192736);
    this.b.a(paramIX5WebViewBase);
    this.a.onDetectedBlankScreen(paramString, paramInt);
    AppMethodBeat.o(192736);
  }
  
  public void onFormResubmission(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    AppMethodBeat.i(192715);
    this.b.a(paramIX5WebViewBase);
    this.a.onFormResubmission(this.b, paramMessage1, paramMessage2);
    AppMethodBeat.o(192715);
  }
  
  public void onLoadResource(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(192716);
    this.b.a(paramIX5WebViewBase);
    this.a.onLoadResource(this.b, paramString);
    AppMethodBeat.o(192716);
  }
  
  public void onPageCommitVisible(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(192739);
    this.b.a(paramIX5WebViewBase);
    this.a.onPageCommitVisible(this.b, paramString);
    AppMethodBeat.o(192739);
  }
  
  public void onPageFinished(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(192717);
    TbsLog.v("TbsPerfTest", "PageLoadFinished!");
    if (c == null)
    {
      localObject = o.a();
      if (localObject != null)
      {
        ((o)localObject).a(false);
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
            AppMethodBeat.i(192710);
            if ((!TbsShareManager.forceLoadX5FromTBSDemo(k.a(k.this).getContext())) && (TbsDownloader.needDownload(k.a(k.this).getContext(), false))) {
              TbsDownloader.startDownload(k.a(k.this).getContext());
            }
            AppMethodBeat.o(192710);
          }
        }).start();
      }
      if ((this.b.getContext() != null) && (!TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport()))
      {
        TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
        TbsLogReport.getInstance(this.b.getContext()).dailyReport();
      }
      AppMethodBeat.o(192717);
      return;
    }
    catch (Exception paramIX5WebViewBase)
    {
      break label169;
    }
  }
  
  public void onPageFinished(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(192737);
    onPageFinished(paramIX5WebViewBase, 0, 0, paramString);
    AppMethodBeat.o(192737);
  }
  
  public void onPageStarted(IX5WebViewBase paramIX5WebViewBase, int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(192718);
    this.b.a(paramIX5WebViewBase);
    this.a.onPageStarted(this.b, paramString, paramBitmap);
    AppMethodBeat.o(192718);
  }
  
  public void onPageStarted(IX5WebViewBase paramIX5WebViewBase, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(192738);
    onPageStarted(paramIX5WebViewBase, 0, 0, paramString, paramBitmap);
    AppMethodBeat.o(192738);
  }
  
  public void onReceivedClientCertRequest(IX5WebViewBase paramIX5WebViewBase, ClientCertRequest paramClientCertRequest)
  {
    AppMethodBeat.i(192724);
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedClientCertRequest(this.b, paramClientCertRequest);
    AppMethodBeat.o(192724);
  }
  
  public void onReceivedError(IX5WebViewBase paramIX5WebViewBase, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(192720);
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
      AppMethodBeat.o(192720);
      return;
    }
    AppMethodBeat.o(192720);
  }
  
  public void onReceivedError(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    AppMethodBeat.i(192719);
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedError(this.b, paramWebResourceRequest, paramWebResourceError);
    AppMethodBeat.o(192719);
  }
  
  public void onReceivedHttpAuthRequest(IX5WebViewBase paramIX5WebViewBase, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    AppMethodBeat.i(192722);
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedHttpAuthRequest(this.b, paramHttpAuthHandler, paramString1, paramString2);
    AppMethodBeat.o(192722);
  }
  
  public void onReceivedHttpError(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    AppMethodBeat.i(192721);
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedHttpError(this.b, paramWebResourceRequest, paramWebResourceResponse);
    AppMethodBeat.o(192721);
  }
  
  public void onReceivedLoginRequest(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(192734);
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedLoginRequest(this.b, paramString1, paramString2, paramString3);
    AppMethodBeat.o(192734);
  }
  
  public void onReceivedSslError(IX5WebViewBase paramIX5WebViewBase, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    AppMethodBeat.i(192723);
    this.b.a(paramIX5WebViewBase);
    this.a.onReceivedSslError(this.b, paramSslErrorHandler, paramSslError);
    AppMethodBeat.o(192723);
  }
  
  public void onScaleChanged(IX5WebViewBase paramIX5WebViewBase, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(192725);
    this.b.a(paramIX5WebViewBase);
    this.a.onScaleChanged(this.b, paramFloat1, paramFloat2);
    AppMethodBeat.o(192725);
  }
  
  public void onTooManyRedirects(IX5WebViewBase paramIX5WebViewBase, Message paramMessage1, Message paramMessage2)
  {
    AppMethodBeat.i(192729);
    this.b.a(paramIX5WebViewBase);
    this.a.onTooManyRedirects(this.b, paramMessage1, paramMessage2);
    AppMethodBeat.o(192729);
  }
  
  public void onUnhandledKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(192726);
    this.b.a(paramIX5WebViewBase);
    this.a.onUnhandledKeyEvent(this.b, paramKeyEvent);
    AppMethodBeat.o(192726);
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(192732);
    this.b.a(paramIX5WebViewBase);
    paramIX5WebViewBase = this.a.shouldInterceptRequest(this.b, paramWebResourceRequest);
    AppMethodBeat.o(192732);
    return paramIX5WebViewBase;
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(192733);
    this.b.a(paramIX5WebViewBase);
    paramIX5WebViewBase = this.a.shouldInterceptRequest(this.b, paramWebResourceRequest, paramBundle);
    AppMethodBeat.o(192733);
    return paramIX5WebViewBase;
  }
  
  public WebResourceResponse shouldInterceptRequest(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(192731);
    this.b.a(paramIX5WebViewBase);
    paramIX5WebViewBase = this.a.shouldInterceptRequest(this.b, paramString);
    AppMethodBeat.o(192731);
    return paramIX5WebViewBase;
  }
  
  public boolean shouldOverrideKeyEvent(IX5WebViewBase paramIX5WebViewBase, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(192727);
    this.b.a(paramIX5WebViewBase);
    boolean bool = this.a.shouldOverrideKeyEvent(this.b, paramKeyEvent);
    AppMethodBeat.o(192727);
    return bool;
  }
  
  public boolean shouldOverrideUrlLoading(IX5WebViewBase paramIX5WebViewBase, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(192730);
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null)) {}
    for (String str = paramWebResourceRequest.getUrl().toString();; str = null)
    {
      if ((str == null) || (this.b.showDebugView(str)))
      {
        AppMethodBeat.o(192730);
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
          paramWebResourceRequest = new com.tencent.mm.hellhoundlib.b.a().bc(paramWebResourceRequest);
          com.tencent.mm.hellhoundlib.a.a.a(paramIX5WebViewBase, paramWebResourceRequest.ahE(), "com/tencent/smtt/sdk/k", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;Lcom/tencent/smtt/export/external/interfaces/WebResourceRequest;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramIX5WebViewBase.startActivity((Intent)paramWebResourceRequest.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramIX5WebViewBase, "com/tencent/smtt/sdk/k", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;Lcom/tencent/smtt/export/external/interfaces/WebResourceRequest;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(192730);
          return true;
        }
        if (str.startsWith("tel:"))
        {
          a(str);
          AppMethodBeat.o(192730);
          return true;
        }
      }
      AppMethodBeat.o(192730);
      return bool;
    }
  }
  
  public boolean shouldOverrideUrlLoading(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(192728);
    if ((paramString == null) || (this.b.showDebugView(paramString)))
    {
      AppMethodBeat.o(192728);
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
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramIX5WebViewBase, paramString.ahE(), "com/tencent/smtt/sdk/k", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramIX5WebViewBase.startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramIX5WebViewBase, "com/tencent/smtt/sdk/k", "shouldOverrideUrlLoading", "(Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(192728);
        return true;
      }
      if (paramString.startsWith("tel:"))
      {
        a(paramString);
        AppMethodBeat.o(192728);
        return true;
      }
    }
    AppMethodBeat.o(192728);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.k
 * JD-Core Version:    0.7.0.1
 */