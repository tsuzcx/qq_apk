package com.tencent.xweb.xwalk;

import android.net.Uri;
import android.net.http.SslError;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.a.a;
import com.tencent.xweb.c.k;
import com.tencent.xweb.p;
import com.tencent.xweb.s;
import com.tencent.xweb.util.f;
import com.tencent.xweb.w;
import java.util.Map;
import org.xwalk.core.ClientCertRequest;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkHttpAuthHandler;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkWebResourceRequest;
import org.xwalk.core.XWalkWebResourceResponse;

final class j$2
  extends m
{
  int BJY = 0;
  
  j$2(j paramj, XWalkView paramXWalkView)
  {
    super(paramXWalkView);
  }
  
  public final void doUpdateVisitedHistory(XWalkView paramXWalkView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(85288);
    if ((paramString != null) && (paramString.startsWith("data:text/html;charset=utf-8")))
    {
      AppMethodBeat.o(85288);
      return;
    }
    this.BJX.iyq.a(this.BJX.BHt, paramString, paramBoolean);
    AppMethodBeat.o(85288);
  }
  
  public final void onDocumentLoadedInFrame(XWalkView paramXWalkView, long paramLong)
  {
    AppMethodBeat.i(85284);
    super.onDocumentLoadedInFrame(paramXWalkView, paramLong);
    AppMethodBeat.o(85284);
  }
  
  public final void onLoadFinished(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(85285);
    super.onLoadFinished(paramXWalkView, paramString);
    AppMethodBeat.o(85285);
  }
  
  public final void onLoadStarted(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(85279);
    this.BJX.iyq.h(this.BJX.BHt, paramString);
    AppMethodBeat.o(85279);
  }
  
  public final void onProgressChanged(XWalkView paramXWalkView, int paramInt)
  {
    AppMethodBeat.i(85283);
    if ((Math.abs(paramInt - this.BJY) > 5) || (paramInt == 100))
    {
      this.BJY = paramInt;
      Log.i("XWWebView", "onProgressChanged, progress = ".concat(String.valueOf(paramInt)));
    }
    this.BJX.iyr.a(this.BJX.BHt, paramInt);
    AppMethodBeat.o(85283);
  }
  
  public final void onReceivedClientCertRequest(XWalkView paramXWalkView, ClientCertRequest paramClientCertRequest)
  {
    AppMethodBeat.i(85286);
    super.onReceivedClientCertRequest(paramXWalkView, paramClientCertRequest);
    AppMethodBeat.o(85286);
  }
  
  public final void onReceivedHttpAuthRequest(XWalkView paramXWalkView, XWalkHttpAuthHandler paramXWalkHttpAuthHandler, String paramString1, String paramString2)
  {
    AppMethodBeat.i(85289);
    super.onReceivedHttpAuthRequest(paramXWalkView, paramXWalkHttpAuthHandler, paramString1, paramString2);
    AppMethodBeat.o(85289);
  }
  
  public final void onReceivedLoadError(XWalkView paramXWalkView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(85281);
    Log.i("XWWebView", "onReceivedError ".concat(String.valueOf(paramString2)));
    super.onReceivedLoadError(paramXWalkView, paramInt, paramString1, paramString2);
    this.BJX.BJO = true;
    this.BJX.iyq.a(this.BJX.BHt, paramInt, paramString1, paramString2);
    k.dYQ().dYR();
    f.b(paramString2, paramInt, System.currentTimeMillis() - this.BJX.BHz, j.b(this.BJX));
    if (this.BJX.iyq.b(this.BJX.BHt, paramInt, paramString1, paramString2))
    {
      AppMethodBeat.o(85281);
      return;
    }
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
    paramXWalkView.append("<title>无法打开页面</title>\n");
    paramXWalkView.append("<script >\n");
    paramXWalkView.append("var html = document.documentElement,");
    paramXWalkView.append("resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize';");
    paramXWalkView.append("function setHtmlFontSize() {");
    paramXWalkView.append("var cliWidth = html.clientWidth;");
    paramXWalkView.append("html.style.fontSize = 100 * (cliWidth / 720) + 'px';}");
    paramXWalkView.append("window.addEventListener(resizeEvt, setHtmlFontSize, false);");
    paramXWalkView.append("</script>\n");
    paramXWalkView.append("<style>.exp{ text-align:center; margin-top:15rem; height=\"10rem\" width=\"10rem\"}</style>\n");
    paramXWalkView.append("<style>.fcolorfortitle{ color: rgba(0, 0, 0, 0.3); font-size:44px;}</style>\n");
    paramXWalkView.append("<style>.fcolorforsubtitle{ color: rgba(0, 0, 0, 0.3); font-size:34px;}</style>\n");
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
    this.BJX.BJF.loadDataWithBaseURL("file:///android_asset/", paramXWalkView, "text/html", "utf-8", null);
    AppMethodBeat.o(85281);
  }
  
  public final void onReceivedResponseHeaders(XWalkView paramXWalkView, XWalkWebResourceRequest paramXWalkWebResourceRequest, XWalkWebResourceResponse paramXWalkWebResourceResponse)
  {
    AppMethodBeat.i(85287);
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
        this.BJX.iyq.b(this.BJX.BHt, (String)localObject1, null);
        this.BJX.BJF.postDelayed(new j.2.1(this, (String)localObject1), 300L);
      }
    }
    while (paramXWalkWebResourceResponse.getStatusCode() < 400)
    {
      super.onReceivedResponseHeaders(paramXWalkView, paramXWalkWebResourceRequest, paramXWalkWebResourceResponse);
      AppMethodBeat.o(85287);
      return;
    }
    Log.i("XWWebView", "onReceivedHttpError code:" + paramXWalkWebResourceResponse.getStatusCode());
    Object localObject2 = this.BJX.iyq;
    WebView localWebView = this.BJX.BHt;
    f.i locali = new f.i(paramXWalkWebResourceRequest);
    if (paramXWalkWebResourceResponse == null)
    {
      localObject1 = null;
      label212:
      ((w)localObject2).a(localWebView, locali, (s)localObject1);
      if (paramXWalkWebResourceRequest.getUrl() == null) {
        break label308;
      }
    }
    label308:
    for (Object localObject1 = paramXWalkWebResourceRequest.getUrl().toString();; localObject1 = "")
    {
      this.BJX.iyq.a(this.BJX.BHt, paramXWalkWebResourceResponse.getStatusCode(), "", (String)localObject1);
      break;
      localObject1 = new s(paramXWalkWebResourceResponse.getMimeType(), paramXWalkWebResourceResponse.getEncoding(), paramXWalkWebResourceResponse.getStatusCode(), paramXWalkWebResourceResponse.getReasonPhrase(), paramXWalkWebResourceResponse.getResponseHeaders(), paramXWalkWebResourceResponse.getData());
      break label212;
    }
  }
  
  public final void onReceivedSslError(XWalkView paramXWalkView, ValueCallback<Boolean> paramValueCallback, SslError paramSslError)
  {
    AppMethodBeat.i(85282);
    Log.i("XWWebView", "onReceivedSslError " + paramSslError.getPrimaryError());
    this.BJX.iyq.a(this.BJX.BHt, new f.h(paramValueCallback), paramSslError);
    AppMethodBeat.o(85282);
  }
  
  public final XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView paramXWalkView, XWalkWebResourceRequest paramXWalkWebResourceRequest)
  {
    AppMethodBeat.i(85280);
    f.i locali = new f.i(paramXWalkWebResourceRequest);
    if (locali.BHo == null)
    {
      paramXWalkView = null;
      if (paramXWalkView == null) {
        break label174;
      }
    }
    label174:
    for (paramXWalkView = this.BJX.iyq.a(this.BJX.BHt, locali, paramXWalkView);; paramXWalkView = null)
    {
      Object localObject = paramXWalkView;
      if (paramXWalkView == null) {
        localObject = this.BJX.iyq.a(this.BJX.BHt, locali);
      }
      if (localObject == null) {}
      for (paramXWalkView = this.BJX.iyq.c(this.BJX.BHt, paramXWalkWebResourceRequest.getUrl().toString());; paramXWalkView = (XWalkView)localObject)
      {
        if (paramXWalkView != null)
        {
          paramXWalkView = createXWalkWebResourceResponse(paramXWalkView.mMimeType, paramXWalkView.mEncoding, paramXWalkView.mInputStream, paramXWalkView.mStatusCode, paramXWalkView.mReasonPhrase, paramXWalkView.mResponseHeaders);
          AppMethodBeat.o(85280);
          return paramXWalkView;
          paramXWalkView = locali.BHo.getBundle();
          break;
        }
        AppMethodBeat.o(85280);
        return null;
      }
    }
  }
  
  public final boolean shouldOverrideUrlLoading(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(85278);
    boolean bool = this.BJX.iyq.a(this.BJX.BHt, paramString);
    Log.i("XWWebView", "shouldOverrideUrlLoading ret =  " + bool + " url = " + paramString);
    AppMethodBeat.o(85278);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.j.2
 * JD-Core Version:    0.7.0.1
 */