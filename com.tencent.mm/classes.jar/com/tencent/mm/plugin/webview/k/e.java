package com.tencent.mm.plugin.webview.k;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.j.a;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.protocal.protobuf.efs;
import com.tencent.mm.sdk.platformtools.ae;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponentInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "TAG", "", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideGetA8Key", "", "url", "force", "reason", "", "overrideProcessResult", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "webview-sdk_release"})
public final class e
  extends com.tencent.mm.plugin.webview.core.j
{
  private final String TAG = "MicroMsg.WebComponentInterceptor";
  
  public final boolean aHP(String paramString)
  {
    AppMethodBeat.i(214249);
    p.h(paramString, "url");
    c.b localb = c.ENl;
    if (n.nF(paramString, c.eZJ()))
    {
      AppMethodBeat.o(214249);
      return true;
    }
    AppMethodBeat.o(214249);
    return false;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(214251);
    p.h(paramWebView, "webview");
    p.h(paramWebResourceRequest, "request");
    paramWebView = paramWebResourceRequest.getUrl().toString();
    p.g(paramWebView, "request.url.toString()");
    Object localObject1 = c.ENl;
    if (n.nF(paramWebView, c.eZJ()))
    {
      paramWebView = getController().getJsapi().eSu();
      p.h(paramWebResourceRequest, "request");
      localObject1 = paramWebView.EOT;
      p.h(paramWebResourceRequest, "request");
      paramWebView = c.w.EOK;
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
      ae.i(c.TAG, "getInterceptResponse ".concat(String.valueOf(paramWebResourceRequest)));
      ((c)localObject1).EMZ.a(b.EML);
      c.l.a locala = (c.l.a)((c)localObject1).eZE().get(paramWebView);
      if (locala != null)
      {
        paramWebView = new StringBuilder("['");
        Object localObject2 = c.w.EOK;
        localObject2 = c.ENl;
        localObject2 = c.ENd;
        Object localObject3 = c.ENl;
        paramWebView = d.a.j.a((Iterable)c.w.hh((List)((d.f)localObject2).getValue()), (CharSequence)"','", null, null, 0, null, null, 62) + "']";
        ae.i(c.TAG, "buildMatrix " + paramWebView + ", " + paramWebResourceRequest);
        localObject2 = c.ENl;
        localObject2 = c.ENe;
        localObject3 = c.ENl;
        localObject2 = n.bq((String)((d.f)localObject2).getValue(), "$__IFRAME_MATRIX__$", paramWebView);
        localObject3 = locala.EOi.name;
        p.g(localObject3, "worker.webComptInfo.name");
        localObject2 = n.bq((String)localObject2, "$__WEB_COMPT_NAME__$", (String)localObject3);
        c.c(locala.eZT(), "WeixinWebCompt.onBind.apply(WeixinWebCompt, " + paramWebView + ')');
        ae.i(c.TAG, "ready to response ".concat(String.valueOf(paramWebResourceRequest)));
        paramWebView = d.UTF_8;
        if (localObject2 == null)
        {
          paramWebView = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(214251);
          throw paramWebView;
        }
        paramWebView = ((String)localObject2).getBytes(paramWebView);
        p.g(paramWebView, "(this as java.lang.String).getBytes(charset)");
        paramWebView = new WebResourceResponse("text/html", "utf8", (InputStream)new ByteArrayInputStream(paramWebView));
        locala.used = true;
        ((c)localObject1).EMZ.a(b.EMM);
        AppMethodBeat.o(214251);
        return paramWebView;
      }
      ((c)localObject1).EMZ.a(b.EMN);
      paramWebView = "webCompt: " + paramWebView + " not found";
      paramWebResourceRequest = d.UTF_8;
      if (paramWebView == null)
      {
        paramWebView = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(214251);
        throw paramWebView;
      }
      paramWebView = paramWebView.getBytes(paramWebResourceRequest);
      p.g(paramWebView, "(this as java.lang.String).getBytes(charset)");
      paramWebView = new WebResourceResponse("text/html", "utf8", (InputStream)new ByteArrayInputStream(paramWebView));
      AppMethodBeat.o(214251);
      return paramWebView;
      AppMethodBeat.o(214251);
      return null;
    }
  }
  
  public final boolean d(String paramString, avz paramavz)
  {
    AppMethodBeat.i(214252);
    p.h(paramString, "reqUrl");
    p.h(paramavz, "resp");
    paramString = paramavz.GNN;
    byte[] arrayOfByte;
    if (paramString != null)
    {
      arrayOfByte = z.a(paramString);
      if (arrayOfByte == null) {}
    }
    try
    {
      paramString = new efs();
      paramString.parseFrom(arrayOfByte);
      paramavz = paramavz.GNB;
      p.g(paramavz, "resp.FullURL");
      f.g(paramavz, paramString.HeK);
      AppMethodBeat.o(214252);
      return false;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.printErrStackTrace(this.TAG, (Throwable)paramString, "parse WebComponentInfo", new Object[0]);
      }
    }
  }
  
  public final j.a n(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(214250);
    p.h(paramWebView, "webView");
    p.h(paramString, "url");
    c.b localb = c.ENl;
    if (n.nF(paramString, c.eZJ()))
    {
      paramWebView = new j.a(true, false);
      AppMethodBeat.o(214250);
      return paramWebView;
    }
    paramWebView = super.n(paramWebView, paramString);
    AppMethodBeat.o(214250);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.e
 * JD-Core Version:    0.7.0.1
 */