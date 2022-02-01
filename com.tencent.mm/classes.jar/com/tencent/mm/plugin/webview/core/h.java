package com.tencent.mm.plugin.webview.core;

import android.net.http.SslError;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.t;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "", "()V", "doUpdateVisitedHistory", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "isReload", "", "onPageCommitVisible", "onPageFinished", "onPageStarted", "onReceivedError", "view", "request", "Lcom/tencent/xweb/WebResourceRequest;", "error", "Lcom/tencent/xweb/WebResourceError;", "errorCode", "", "description", "failingUrl", "onReceivedHttpError", "webResourceRequest", "webResourceResponse", "Lcom/tencent/xweb/WebResourceResponse;", "onReceivedSslError", "handler", "Lcom/tencent/xweb/SslErrorHandler;", "Landroid/net/http/SslError;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class h
{
  public void a(WebResourceRequest paramWebResourceRequest, ac paramac) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse) {}
  
  public void a(WebView paramWebView, t paramt, SslError paramSslError) {}
  
  public void b(WebView paramWebView, String paramString) {}
  
  public void b(WebView paramWebView, String paramString, boolean paramBoolean) {}
  
  public void e(WebView paramWebView, String paramString) {}
  
  public void h(WebView paramWebView, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.h
 * JD-Core Version:    0.7.0.1
 */