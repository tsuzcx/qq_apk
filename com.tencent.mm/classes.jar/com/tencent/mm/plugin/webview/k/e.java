package com.tencent.mm.plugin.webview.k;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.j.a;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.eeb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import d.g.b.p;
import d.l;
import d.n.d;
import d.n.n;
import d.v;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponentInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "TAG", "", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideGetA8Key", "", "url", "force", "reason", "", "overrideProcessResult", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "webview-sdk_release"})
public final class e
  extends com.tencent.mm.plugin.webview.core.j
{
  private final String TAG = "MicroMsg.WebComponentInterceptor";
  
  public final boolean aGv(String paramString)
  {
    AppMethodBeat.i(214408);
    p.h(paramString, "url");
    c.b localb = c.EuR;
    if (n.nz(paramString, c.eVX()))
    {
      AppMethodBeat.o(214408);
      return true;
    }
    AppMethodBeat.o(214408);
    return false;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(214410);
    p.h(paramWebView, "webview");
    p.h(paramWebResourceRequest, "request");
    paramWebView = paramWebResourceRequest.getUrl().toString();
    p.g(paramWebView, "request.url.toString()");
    Object localObject1 = c.EuR;
    if (n.nz(paramWebView, c.eVX()))
    {
      paramWebView = getController().getJsapi().eOJ();
      p.h(paramWebResourceRequest, "request");
      localObject1 = paramWebView.Ewx;
      p.h(paramWebResourceRequest, "request");
      paramWebView = c.w.Ewo;
      paramWebResourceRequest = paramWebResourceRequest.getUrl();
      p.g(paramWebResourceRequest, "url");
      paramWebView = paramWebResourceRequest.getHost();
      if (paramWebView != null) {
        break label559;
      }
      paramWebView = "";
    }
    label559:
    for (;;)
    {
      ad.i(c.TAG, "getInterceptResponse ".concat(String.valueOf(paramWebResourceRequest)));
      ((c)localObject1).EuF.a(b.Eur);
      c.l.a locala = (c.l.a)((c)localObject1).eVS().get(paramWebView);
      if (locala != null)
      {
        paramWebView = new StringBuilder("['");
        Object localObject2 = c.w.Ewo;
        localObject2 = c.EuR;
        localObject2 = c.EuJ;
        Object localObject3 = c.EuR;
        paramWebView = d.a.j.a((Iterable)c.w.gX((List)((d.f)localObject2).getValue()), (CharSequence)"','", null, null, 0, null, null, 62) + "']";
        ad.i(c.TAG, "buildMatrix " + paramWebView + ", " + paramWebResourceRequest);
        localObject2 = c.EuR;
        localObject2 = c.EuK;
        localObject3 = c.EuR;
        localObject2 = n.bp((String)((d.f)localObject2).getValue(), "$__IFRAME_MATRIX__$", paramWebView);
        localObject3 = locala.EvN.name;
        p.g(localObject3, "worker.webComptInfo.name");
        localObject2 = n.bp((String)localObject2, "$__WEB_COMPT_NAME__$", (String)localObject3);
        c.c(locala.eWh(), "WeixinWebCompt.onBind.apply(WeixinWebCompt, " + paramWebView + ')');
        ad.i(c.TAG, "ready to response ".concat(String.valueOf(paramWebResourceRequest)));
        paramWebView = d.UTF_8;
        if (localObject2 == null)
        {
          paramWebView = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(214410);
          throw paramWebView;
        }
        paramWebView = ((String)localObject2).getBytes(paramWebView);
        p.g(paramWebView, "(this as java.lang.String).getBytes(charset)");
        paramWebView = new WebResourceResponse("text/html", "utf8", (InputStream)new ByteArrayInputStream(paramWebView));
        locala.used = true;
        ((c)localObject1).EuF.a(b.Eus);
        AppMethodBeat.o(214410);
        return paramWebView;
      }
      ((c)localObject1).EuF.a(b.Eut);
      paramWebView = "webCompt: " + paramWebView + " not found";
      paramWebResourceRequest = d.UTF_8;
      if (paramWebView == null)
      {
        paramWebView = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(214410);
        throw paramWebView;
      }
      paramWebView = paramWebView.getBytes(paramWebResourceRequest);
      p.g(paramWebView, "(this as java.lang.String).getBytes(charset)");
      paramWebView = new WebResourceResponse("text/html", "utf8", (InputStream)new ByteArrayInputStream(paramWebView));
      AppMethodBeat.o(214410);
      return paramWebView;
      AppMethodBeat.o(214410);
      return null;
    }
  }
  
  public final boolean d(String paramString, avj paramavj)
  {
    AppMethodBeat.i(214411);
    p.h(paramString, "reqUrl");
    p.h(paramavj, "resp");
    paramString = paramavj.Guo;
    byte[] arrayOfByte;
    if (paramString != null)
    {
      arrayOfByte = z.a(paramString);
      if (arrayOfByte == null) {}
    }
    try
    {
      paramString = new eeb();
      paramString.parseFrom(arrayOfByte);
      paramavj = paramavj.Guc;
      p.g(paramavj, "resp.FullURL");
      f.g(paramavj, paramString.GLj);
      AppMethodBeat.o(214411);
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
  
  public final j.a m(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(214409);
    p.h(paramWebView, "webView");
    p.h(paramString, "url");
    c.b localb = c.EuR;
    if (n.nz(paramString, c.eVX()))
    {
      paramWebView = new j.a(true, false);
      AppMethodBeat.o(214409);
      return paramWebView;
    }
    paramWebView = super.m(paramWebView, paramString);
    AppMethodBeat.o(214409);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.e
 * JD-Core Version:    0.7.0.1
 */