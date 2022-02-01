package com.tencent.mm.plugin.webview.k;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.j.a;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import d.l;
import d.n.d;
import d.n.n;
import d.v;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponentInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "TAG", "", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideGetA8Key", "", "url", "force", "reason", "", "overrideProcessResult", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "webview-sdk_release"})
public final class e
  extends com.tencent.mm.plugin.webview.core.j
{
  private final String TAG = "MicroMsg.WebComponentInterceptor";
  
  public final boolean avI(String paramString)
  {
    AppMethodBeat.i(189481);
    d.g.b.k.h(paramString, "url");
    c.b localb = c.ByF;
    if (n.mA(paramString, c.b.getScheme()))
    {
      AppMethodBeat.o(189481);
      return true;
    }
    AppMethodBeat.o(189481);
    return false;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(189483);
    d.g.b.k.h(paramWebView, "webview");
    d.g.b.k.h(paramWebResourceRequest, "request");
    paramWebView = paramWebResourceRequest.getUrl().toString();
    d.g.b.k.g(paramWebView, "request.url.toString()");
    Object localObject1 = c.ByF;
    if (n.mA(paramWebView, c.b.getScheme()))
    {
      paramWebView = getController().getJsapi().ekz();
      d.g.b.k.h(paramWebResourceRequest, "request");
      localObject1 = paramWebView.BAp;
      d.g.b.k.h(paramWebResourceRequest, "request");
      paramWebView = c.w.BAf;
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
      ad.i(c.TAG, "getInterceptResponse ".concat(String.valueOf(paramWebResourceRequest)));
      ((c)localObject1).Bys.a(b.Byf);
      c.l.a locala = (c.l.a)((c)localObject1).erw().get(paramWebView);
      if (locala != null)
      {
        paramWebView = new StringBuilder("['");
        Object localObject2 = c.w.BAf;
        localObject2 = c.ByF;
        paramWebView = d.a.j.a((Iterable)c.w.gA(c.b.erQ()), (CharSequence)"','", null, null, 0, null, null, 62) + "']";
        ad.i(c.TAG, "buildMatrix " + paramWebView + ", " + paramWebResourceRequest);
        localObject2 = c.ByF;
        localObject2 = n.bb(c.b.erR(), "$__IFRAME_MATRIX__$", paramWebView);
        String str = locala.BzB.name;
        d.g.b.k.g(str, "worker.webComptInfo.name");
        localObject2 = n.bb((String)localObject2, "$__WEB_COMPT_NAME__$", str);
        c.c(locala.erU(), "WeixinWebCompt.onBind.apply(WeixinWebCompt, " + paramWebView + ')');
        ad.i(c.TAG, "ready to response ".concat(String.valueOf(paramWebResourceRequest)));
        paramWebView = d.UTF_8;
        if (localObject2 == null)
        {
          paramWebView = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(189483);
          throw paramWebView;
        }
        paramWebView = ((String)localObject2).getBytes(paramWebView);
        d.g.b.k.g(paramWebView, "(this as java.lang.String).getBytes(charset)");
        paramWebView = new WebResourceResponse("text/html", "utf8", (InputStream)new ByteArrayInputStream(paramWebView));
        locala.used = true;
        ((c)localObject1).Bys.a(b.Byg);
        AppMethodBeat.o(189483);
        return paramWebView;
      }
      ((c)localObject1).Bys.a(b.Byh);
      paramWebView = "webCompt: " + paramWebView + " not found";
      paramWebResourceRequest = d.UTF_8;
      if (paramWebView == null)
      {
        paramWebView = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(189483);
        throw paramWebView;
      }
      paramWebView = paramWebView.getBytes(paramWebResourceRequest);
      d.g.b.k.g(paramWebView, "(this as java.lang.String).getBytes(charset)");
      paramWebView = new WebResourceResponse("text/html", "utf8", (InputStream)new ByteArrayInputStream(paramWebView));
      AppMethodBeat.o(189483);
      return paramWebView;
      AppMethodBeat.o(189483);
      return null;
    }
  }
  
  public final boolean d(String paramString, aoj paramaoj)
  {
    AppMethodBeat.i(189484);
    d.g.b.k.h(paramString, "reqUrl");
    d.g.b.k.h(paramaoj, "resp");
    paramString = paramaoj.Dqj;
    byte[] arrayOfByte;
    if (paramString != null)
    {
      arrayOfByte = z.a(paramString);
      if (arrayOfByte == null) {}
    }
    try
    {
      paramString = new dsk();
      paramString.parseFrom(arrayOfByte);
      paramaoj = paramaoj.DpW;
      d.g.b.k.g(paramaoj, "resp.FullURL");
      f.h(paramaoj, paramString.DGq);
      AppMethodBeat.o(189484);
      return false;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace(this.TAG, (Throwable)paramString, "parse WebComponentInfo", new Object[0]);
      }
    }
  }
  
  public final j.a n(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(189482);
    d.g.b.k.h(paramWebView, "webView");
    d.g.b.k.h(paramString, "url");
    c.b localb = c.ByF;
    if (n.mA(paramString, c.b.getScheme()))
    {
      paramWebView = new j.a(true, false);
      AppMethodBeat.o(189482);
      return paramWebView;
    }
    paramWebView = super.n(paramWebView, paramString);
    AppMethodBeat.o(189482);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.e
 * JD-Core Version:    0.7.0.1
 */