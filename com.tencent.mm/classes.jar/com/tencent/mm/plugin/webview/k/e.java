package com.tencent.mm.plugin.webview.k;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.j.a;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.dyb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import d.l;
import d.n.d;
import d.n.n;
import d.v;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponentInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "TAG", "", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideGetA8Key", "", "url", "force", "reason", "", "overrideProcessResult", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "webview-sdk_release"})
public final class e
  extends com.tencent.mm.plugin.webview.core.j
{
  private final String TAG = "MicroMsg.WebComponentInterceptor";
  
  public final boolean aBa(String paramString)
  {
    AppMethodBeat.i(205614);
    d.g.b.k.h(paramString, "url");
    c.b localb = c.CQN;
    if (n.nb(paramString, c.b.getScheme()))
    {
      AppMethodBeat.o(205614);
      return true;
    }
    AppMethodBeat.o(205614);
    return false;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(205616);
    d.g.b.k.h(paramWebView, "webview");
    d.g.b.k.h(paramWebResourceRequest, "request");
    paramWebView = paramWebResourceRequest.getUrl().toString();
    d.g.b.k.g(paramWebView, "request.url.toString()");
    Object localObject1 = c.CQN;
    if (n.nb(paramWebView, c.b.getScheme()))
    {
      paramWebView = getController().getJsapi().ezV();
      d.g.b.k.h(paramWebResourceRequest, "request");
      localObject1 = paramWebView.CSw;
      d.g.b.k.h(paramWebResourceRequest, "request");
      paramWebView = c.w.CSm;
      paramWebResourceRequest = paramWebResourceRequest.getUrl();
      d.g.b.k.g(paramWebResourceRequest, "url");
      paramWebView = paramWebResourceRequest.getHost();
      if (paramWebView != null) {
        break label525;
      }
      paramWebView = "";
    }
    label525:
    for (;;)
    {
      ac.i(c.TAG, "getInterceptResponse ".concat(String.valueOf(paramWebResourceRequest)));
      ((c)localObject1).CQA.a(b.CQn);
      c.l.a locala = (c.l.a)((c)localObject1).eGQ().get(paramWebView);
      if (locala != null)
      {
        paramWebView = new StringBuilder("['");
        Object localObject2 = c.w.CSm;
        localObject2 = c.CQN;
        paramWebView = d.a.j.a((Iterable)c.w.gL(c.b.eHk()), (CharSequence)"','", null, null, 0, null, null, 62) + "']";
        ac.i(c.TAG, "buildMatrix " + paramWebView + ", " + paramWebResourceRequest);
        localObject2 = c.CQN;
        localObject2 = n.bg(c.b.eHl(), "$__IFRAME_MATRIX__$", paramWebView);
        String str = locala.CRJ.name;
        d.g.b.k.g(str, "worker.webComptInfo.name");
        localObject2 = n.bg((String)localObject2, "$__WEB_COMPT_NAME__$", str);
        c.c(locala.eHo(), "WeixinWebCompt.onBind.apply(WeixinWebCompt, " + paramWebView + ')');
        ac.i(c.TAG, "ready to response ".concat(String.valueOf(paramWebResourceRequest)));
        paramWebView = d.UTF_8;
        if (localObject2 == null)
        {
          paramWebView = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(205616);
          throw paramWebView;
        }
        paramWebView = ((String)localObject2).getBytes(paramWebView);
        d.g.b.k.g(paramWebView, "(this as java.lang.String).getBytes(charset)");
        paramWebView = new WebResourceResponse("text/html", "utf8", (InputStream)new ByteArrayInputStream(paramWebView));
        locala.used = true;
        ((c)localObject1).CQA.a(b.CQo);
        AppMethodBeat.o(205616);
        return paramWebView;
      }
      ((c)localObject1).CQA.a(b.CQp);
      paramWebView = "webCompt: " + paramWebView + " not found";
      paramWebResourceRequest = d.UTF_8;
      if (paramWebView == null)
      {
        paramWebView = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(205616);
        throw paramWebView;
      }
      paramWebView = paramWebView.getBytes(paramWebResourceRequest);
      d.g.b.k.g(paramWebView, "(this as java.lang.String).getBytes(charset)");
      paramWebView = new WebResourceResponse("text/html", "utf8", (InputStream)new ByteArrayInputStream(paramWebView));
      AppMethodBeat.o(205616);
      return paramWebView;
      AppMethodBeat.o(205616);
      return null;
    }
  }
  
  public final boolean d(String paramString, arn paramarn)
  {
    AppMethodBeat.i(205617);
    d.g.b.k.h(paramString, "reqUrl");
    d.g.b.k.h(paramarn, "resp");
    paramString = paramarn.ELl;
    byte[] arrayOfByte;
    if (paramString != null)
    {
      arrayOfByte = z.a(paramString);
      if (arrayOfByte == null) {}
    }
    try
    {
      paramString = new dyb();
      paramString.parseFrom(arrayOfByte);
      paramarn = paramarn.EKZ;
      d.g.b.k.g(paramarn, "resp.FullURL");
      f.h(paramarn, paramString.FbK);
      AppMethodBeat.o(205617);
      return false;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.printErrStackTrace(this.TAG, (Throwable)paramString, "parse WebComponentInfo", new Object[0]);
      }
    }
  }
  
  public final j.a n(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(205615);
    d.g.b.k.h(paramWebView, "webView");
    d.g.b.k.h(paramString, "url");
    c.b localb = c.CQN;
    if (n.nb(paramString, c.b.getScheme()))
    {
      paramWebView = new j.a(true, false);
      AppMethodBeat.o(205615);
      return paramWebView;
    }
    paramWebView = super.n(paramWebView, paramString);
    AppMethodBeat.o(205615);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.e
 * JD-Core Version:    0.7.0.1
 */