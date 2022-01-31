package com.tencent.xweb.xwalk;

import android.net.Uri;
import android.net.http.SslError;
import android.webkit.ValueCallback;
import com.tencent.xweb.WebView;
import com.tencent.xweb.a.a;
import com.tencent.xweb.j;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import com.tencent.xweb.util.e;
import java.util.Map;
import org.xwalk.core.ClientCertRequest;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkHttpAuthHandler;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkWebResourceRequest;
import org.xwalk.core.XWalkWebResourceResponse;

final class h$2
  extends k
{
  h$2(h paramh, XWalkView paramXWalkView)
  {
    super(paramXWalkView);
  }
  
  public final void doUpdateVisitedHistory(XWalkView paramXWalkView, String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (paramString.startsWith("data:text/html;charset=utf-8"))) {
      return;
    }
    this.xmk.gIG.a(this.xmk.xjP, paramString, paramBoolean);
  }
  
  public final void onDocumentLoadedInFrame(XWalkView paramXWalkView, long paramLong)
  {
    super.onDocumentLoadedInFrame(paramXWalkView, paramLong);
  }
  
  public final void onLoadFinished(XWalkView paramXWalkView, String paramString)
  {
    super.onLoadFinished(paramXWalkView, paramString);
  }
  
  public final void onLoadStarted(XWalkView paramXWalkView, String paramString)
  {
    this.xmk.gIG.f(this.xmk.xjP, paramString);
  }
  
  public final void onProgressChanged(XWalkView paramXWalkView, int paramInt)
  {
    Log.i("XWWebView", "onProgressChanged, progress = " + paramInt);
    this.xmk.gVg.a(this.xmk.xjP, paramInt);
  }
  
  public final void onReceivedClientCertRequest(XWalkView paramXWalkView, ClientCertRequest paramClientCertRequest)
  {
    super.onReceivedClientCertRequest(paramXWalkView, paramClientCertRequest);
  }
  
  public final void onReceivedHttpAuthRequest(XWalkView paramXWalkView, XWalkHttpAuthHandler paramXWalkHttpAuthHandler, String paramString1, String paramString2)
  {
    super.onReceivedHttpAuthRequest(paramXWalkView, paramXWalkHttpAuthHandler, paramString1, paramString2);
  }
  
  public final void onReceivedLoadError(XWalkView paramXWalkView, int paramInt, String paramString1, String paramString2)
  {
    Log.i("XWWebView", "onReceivedError " + paramString2);
    super.onReceivedLoadError(paramXWalkView, paramInt, paramString1, paramString2);
    this.xmk.xmd = true;
    this.xmk.gIG.a(this.xmk.xjP, paramInt, paramString1, paramString2);
    paramXWalkView = new StringBuilder(2000);
    paramXWalkView.append("<html>\n");
    paramXWalkView.append("<head>\n");
    paramXWalkView.append("<script type=\"text/javascript\">\n");
    paramXWalkView.append("function jumurl(){\n");
    paramXWalkView.append("　　window.location.href = '");
    paramXWalkView.append(paramString2);
    paramXWalkView.append("';\n");
    paramXWalkView.append("}\n");
    paramXWalkView.append("</script>\n");
    paramXWalkView.append("<script >\n");
    paramXWalkView.append("var html = doc.documentElement,");
    paramXWalkView.append("resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize';");
    paramXWalkView.append("function setHtmlFontSize() {");
    paramXWalkView.append("var cliWidth = html.clientWidth;");
    paramXWalkView.append("html.style.fontSize = 100 * (cliWidth / 720) + 'px';}");
    paramXWalkView.append("window.addEventListener(resizeEvt, setHtmlFontSize, false);");
    paramXWalkView.append("</script>\n");
    paramXWalkView.append("\"<style>.exp{ text-align:center; margin-top:15rem; height=\"10rem\" width=\"10rem\"}</style>\"\n");
    paramXWalkView.append("\"<style>.fcolorfortitle{ color: rgba(0, 0, 0, 0.3); font-size:44px;}</style>\"\n");
    paramXWalkView.append("\"<style>.fcolorforsubtitle{ color: rgba(0, 0, 0, 0.3); font-size:34px;}</style>\"\n");
    paramXWalkView.append("</head>\n");
    paramXWalkView.append("<body bgcolor=\"#F2F2F2\" onclick=\"jumurl()\"'\">\n");
    paramXWalkView.append("<br></br>");
    paramXWalkView.append("<p></p>");
    paramXWalkView.append("<div class=\"exp\" ><img src=\"html/img/webview_404_refresh_icon.svg\" text-align:center /><div>");
    paramXWalkView.append("<br></br>");
    paramXWalkView.append("<font size=\"44px\" class=\"fcolorfortitle\">无法打开页面</font>");
    paramXWalkView.append("<br></br>");
    paramXWalkView.append("<font size=\"44px\" class=\"fcolorforsubtitle\">轻触屏幕重新加载</font>");
    paramXWalkView.append("</body>\n");
    paramXWalkView.append("</html>");
    paramXWalkView = paramXWalkView.toString();
    this.xmk.xlW.loadDataWithBaseURL("file:///android_asset/", paramXWalkView, "text/html", "utf-8", null);
    e.b(paramString2, paramInt, System.currentTimeMillis() - this.xmk.xjV, h.b(this.xmk));
  }
  
  public final void onReceivedResponseHeaders(XWalkView paramXWalkView, XWalkWebResourceRequest paramXWalkWebResourceRequest, XWalkWebResourceResponse paramXWalkWebResourceResponse)
  {
    if (paramXWalkWebResourceResponse.getStatusCode() == 302)
    {
      localObject2 = (String)paramXWalkWebResourceResponse.getResponseHeaders().get("location");
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!((String)localObject2).isEmpty()) {}
      }
      else
      {
        localObject1 = (String)paramXWalkWebResourceResponse.getResponseHeaders().get("Location");
      }
      if ((localObject1 != null) && (((String)localObject1).trim().startsWith("weixin://")))
      {
        this.xmk.gIG.b(this.xmk.xjP, (String)localObject1, null);
        this.xmk.xlW.postDelayed(new h.2.1(this, (String)localObject1), 300L);
      }
    }
    while (paramXWalkWebResourceResponse.getStatusCode() < 400)
    {
      super.onReceivedResponseHeaders(paramXWalkView, paramXWalkWebResourceRequest, paramXWalkWebResourceResponse);
      return;
    }
    Log.i("XWWebView", "onReceivedHttpError code:" + paramXWalkWebResourceResponse.getStatusCode());
    Object localObject2 = this.xmk.gIG;
    WebView localWebView = this.xmk.xjP;
    e.h localh = new e.h(paramXWalkWebResourceRequest);
    if (paramXWalkWebResourceResponse == null)
    {
      localObject1 = null;
      label198:
      ((p)localObject2).a(localWebView, localh, (m)localObject1);
      if (paramXWalkWebResourceRequest.getUrl() == null) {
        break label294;
      }
    }
    label294:
    for (Object localObject1 = paramXWalkWebResourceRequest.getUrl().toString();; localObject1 = "")
    {
      this.xmk.gIG.a(this.xmk.xjP, paramXWalkWebResourceResponse.getStatusCode(), "", (String)localObject1);
      break;
      localObject1 = new m(paramXWalkWebResourceResponse.getMimeType(), paramXWalkWebResourceResponse.getEncoding(), paramXWalkWebResourceResponse.getStatusCode(), paramXWalkWebResourceResponse.getReasonPhrase(), paramXWalkWebResourceResponse.getResponseHeaders(), paramXWalkWebResourceResponse.getData());
      break label198;
    }
  }
  
  public final void onReceivedSslError(XWalkView paramXWalkView, ValueCallback<Boolean> paramValueCallback, SslError paramSslError)
  {
    Log.i("XWWebView", "onReceivedSslError " + paramSslError.getPrimaryError());
    this.xmk.gIG.a(this.xmk.xjP, new e.g(paramValueCallback), paramSslError);
  }
  
  public final XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView paramXWalkView, XWalkWebResourceRequest paramXWalkWebResourceRequest)
  {
    Object localObject2 = null;
    e.h localh = new e.h(paramXWalkWebResourceRequest);
    if (localh.xjK == null)
    {
      paramXWalkView = null;
      if (paramXWalkView == null) {
        break label160;
      }
    }
    label160:
    for (paramXWalkView = this.xmk.gIG.a(this.xmk.xjP, localh, paramXWalkView);; paramXWalkView = null)
    {
      Object localObject1 = paramXWalkView;
      if (paramXWalkView == null) {
        localObject1 = this.xmk.gIG.a(this.xmk.xjP, localh);
      }
      if (localObject1 == null) {}
      for (paramXWalkView = this.xmk.gIG.c(this.xmk.xjP, paramXWalkWebResourceRequest.getUrl().toString());; paramXWalkView = (XWalkView)localObject1)
      {
        paramXWalkWebResourceRequest = localObject2;
        if (paramXWalkView != null) {
          paramXWalkWebResourceRequest = createXWalkWebResourceResponse(paramXWalkView.mMimeType, paramXWalkView.mEncoding, paramXWalkView.mInputStream, paramXWalkView.mStatusCode, paramXWalkView.mReasonPhrase, paramXWalkView.mResponseHeaders);
        }
        return paramXWalkWebResourceRequest;
        paramXWalkView = localh.xjK.getBundle();
        break;
      }
    }
  }
  
  public final boolean shouldOverrideUrlLoading(XWalkView paramXWalkView, String paramString)
  {
    boolean bool = this.xmk.gIG.b(this.xmk.xjP, paramString);
    Log.i("XWWebView", "shouldOverrideUrlLoading ret =  " + bool + " url = " + paramString);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.h.2
 * JD-Core Version:    0.7.0.1
 */