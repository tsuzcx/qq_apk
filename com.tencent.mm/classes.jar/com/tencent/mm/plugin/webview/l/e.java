package com.tencent.mm.plugin.webview.l;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.k.a;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.protocal.protobuf.fkt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponentInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "TAG", "", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideGetA8Key", "", "url", "force", "reason", "", "overrideProcessResult", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "webview-sdk_release"})
public final class e
  extends com.tencent.mm.plugin.webview.core.k
{
  private final String TAG = "MicroMsg.WebComponentInterceptor";
  
  public final boolean a(int paramInt, String paramString, bot parambot)
  {
    AppMethodBeat.i(216222);
    p.k(paramString, "reqUrl");
    p.k(parambot, "resp");
    paramString = parambot.TaC;
    byte[] arrayOfByte;
    if (paramString != null)
    {
      arrayOfByte = z.a(paramString);
      if (arrayOfByte == null) {}
    }
    try
    {
      paramString = new fkt();
      paramString.parseFrom(arrayOfByte);
      parambot = parambot.Tao;
      p.j(parambot, "resp.FullURL");
      f.h(parambot, paramString.TuI);
      AppMethodBeat.o(216222);
      return false;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramString, "parse WebComponentInfo", new Object[0]);
      }
    }
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(216219);
    p.k(paramWebView, "webview");
    p.k(paramWebResourceRequest, "request");
    paramWebView = paramWebResourceRequest.getUrl().toString();
    p.j(paramWebView, "request.url.toString()");
    Object localObject1 = c.QBP;
    if (n.M(paramWebView, c.hcx(), false))
    {
      paramWebView = getController().getJsapi().gUc();
      if (paramWebView != null)
      {
        p.k(paramWebResourceRequest, "request");
        localObject1 = paramWebView.QDy;
        p.k(paramWebResourceRequest, "request");
        paramWebView = c.x.QDp;
        paramWebResourceRequest = paramWebResourceRequest.getUrl();
        p.j(paramWebResourceRequest, "url");
        paramWebView = paramWebResourceRequest.getHost();
        if (paramWebView != null) {
          break label577;
        }
        paramWebView = "";
      }
    }
    label577:
    for (;;)
    {
      p.j(paramWebView, "url.host ?: \"\"");
      Log.i(c.TAG, "getInterceptResponse ".concat(String.valueOf(paramWebResourceRequest)));
      ((c)localObject1).QBB.a(b.QBn);
      c.m.a locala = (c.m.a)((c)localObject1).hct().get(paramWebView);
      if (locala != null)
      {
        paramWebView = new StringBuilder("['");
        Object localObject2 = c.x.QDp;
        localObject2 = c.QBP;
        localObject2 = c.QBG;
        Object localObject3 = c.QBP;
        paramWebView = kotlin.a.j.a((Iterable)c.x.je((List)((kotlin.f)localObject2).getValue()), (CharSequence)"','", null, null, 0, null, null, 62) + "']";
        Log.i(c.TAG, "buildMatrix " + paramWebView + ", " + paramWebResourceRequest);
        localObject2 = c.QBP;
        localObject2 = c.QBH;
        localObject3 = c.QBP;
        localObject2 = n.bx((String)((kotlin.f)localObject2).getValue(), "$__IFRAME_MATRIX__$", paramWebView);
        localObject3 = locala.QCO.name;
        p.j(localObject3, "worker.webComptInfo.name");
        localObject2 = n.bx((String)localObject2, "$__WEB_COMPT_NAME__$", (String)localObject3);
        c.c(locala.hcK(), "WeixinWebCompt.onBind.apply(WeixinWebCompt, " + paramWebView + ')');
        Log.i(c.TAG, "ready to response ".concat(String.valueOf(paramWebResourceRequest)));
        paramWebView = d.UTF_8;
        if (localObject2 == null)
        {
          paramWebView = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(216219);
          throw paramWebView;
        }
        paramWebView = ((String)localObject2).getBytes(paramWebView);
        p.j(paramWebView, "(this as java.lang.String).getBytes(charset)");
        paramWebView = new WebResourceResponse("text/html", "utf8", (InputStream)new ByteArrayInputStream(paramWebView));
        locala.Al = true;
        ((c)localObject1).QBB.a(b.QBo);
        AppMethodBeat.o(216219);
        return paramWebView;
      }
      ((c)localObject1).QBB.a(b.QBp);
      paramWebView = "webCompt: " + paramWebView + " not found";
      paramWebResourceRequest = d.UTF_8;
      if (paramWebView == null)
      {
        paramWebView = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(216219);
        throw paramWebView;
      }
      paramWebView = paramWebView.getBytes(paramWebResourceRequest);
      p.j(paramWebView, "(this as java.lang.String).getBytes(charset)");
      paramWebView = new WebResourceResponse("text/html", "utf8", (InputStream)new ByteArrayInputStream(paramWebView));
      AppMethodBeat.o(216219);
      return paramWebView;
      AppMethodBeat.o(216219);
      return null;
    }
  }
  
  public final boolean g(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(216216);
    p.k(paramString, "url");
    c.b localb = c.QBP;
    if (n.M(paramString, c.hcx(), false))
    {
      AppMethodBeat.o(216216);
      return true;
    }
    AppMethodBeat.o(216216);
    return false;
  }
  
  public final k.a o(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(216218);
    p.k(paramWebView, "webView");
    p.k(paramString, "url");
    c.b localb = c.QBP;
    if (n.M(paramString, c.hcx(), false))
    {
      paramWebView = new k.a(true, false);
      AppMethodBeat.o(216218);
      return paramWebView;
    }
    paramWebView = super.o(paramWebView, paramString);
    AppMethodBeat.o(216218);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.e
 * JD-Core Version:    0.7.0.1
 */