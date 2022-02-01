package com.tencent.mm.plugin.webview.l;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.k.a;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.fac;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponentInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "TAG", "", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideGetA8Key", "", "url", "force", "reason", "", "overrideProcessResult", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "webview-sdk_release"})
public final class e
  extends com.tencent.mm.plugin.webview.core.k
{
  private final String TAG = "MicroMsg.WebComponentInterceptor";
  
  public final boolean a(int paramInt, String paramString, bhj parambhj)
  {
    AppMethodBeat.i(225211);
    p.h(paramString, "reqUrl");
    p.h(parambhj, "resp");
    paramString = parambhj.LRT;
    byte[] arrayOfByte;
    if (paramString != null)
    {
      arrayOfByte = z.a(paramString);
      if (arrayOfByte == null) {}
    }
    try
    {
      paramString = new fac();
      paramString.parseFrom(arrayOfByte);
      parambhj = parambhj.LRH;
      p.g(parambhj, "resp.FullURL");
      f.g(parambhj, paramString.MjS);
      AppMethodBeat.o(225211);
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
  
  public final boolean aXP(String paramString)
  {
    AppMethodBeat.i(225208);
    p.h(paramString, "url");
    c.b localb = c.JDf;
    if (n.J(paramString, c.giN(), false))
    {
      AppMethodBeat.o(225208);
      return true;
    }
    AppMethodBeat.o(225208);
    return false;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(225210);
    p.h(paramWebView, "webview");
    p.h(paramWebResourceRequest, "request");
    paramWebView = paramWebResourceRequest.getUrl().toString();
    p.g(paramWebView, "request.url.toString()");
    Object localObject1 = c.JDf;
    if (n.J(paramWebView, c.giN(), false))
    {
      paramWebView = getController().getJsapi().gbi();
      if (paramWebView != null)
      {
        p.h(paramWebResourceRequest, "request");
        localObject1 = paramWebView.JEJ;
        p.h(paramWebResourceRequest, "request");
        paramWebView = c.w.JEA;
        paramWebResourceRequest = paramWebResourceRequest.getUrl();
        p.g(paramWebResourceRequest, "url");
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
      p.g(paramWebView, "url.host ?: \"\"");
      Log.i(c.TAG, "getInterceptResponse ".concat(String.valueOf(paramWebResourceRequest)));
      ((c)localObject1).JCS.a(b.JCE);
      c.l.a locala = (c.l.a)((c)localObject1).giJ().get(paramWebView);
      if (locala != null)
      {
        paramWebView = new StringBuilder("['");
        Object localObject2 = c.w.JEA;
        localObject2 = c.JDf;
        localObject2 = c.JCX;
        Object localObject3 = c.JDf;
        paramWebView = kotlin.a.j.a((Iterable)c.w.in((List)((kotlin.f)localObject2).getValue()), (CharSequence)"','", null, null, 0, null, null, 62) + "']";
        Log.i(c.TAG, "buildMatrix " + paramWebView + ", " + paramWebResourceRequest);
        localObject2 = c.JDf;
        localObject2 = c.JCY;
        localObject3 = c.JDf;
        localObject2 = n.by((String)((kotlin.f)localObject2).getValue(), "$__IFRAME_MATRIX__$", paramWebView);
        localObject3 = locala.JEa.name;
        p.g(localObject3, "worker.webComptInfo.name");
        localObject2 = n.by((String)localObject2, "$__WEB_COMPT_NAME__$", (String)localObject3);
        c.c(locala.giZ(), "WeixinWebCompt.onBind.apply(WeixinWebCompt, " + paramWebView + ')');
        Log.i(c.TAG, "ready to response ".concat(String.valueOf(paramWebResourceRequest)));
        paramWebView = d.UTF_8;
        if (localObject2 == null)
        {
          paramWebView = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(225210);
          throw paramWebView;
        }
        paramWebView = ((String)localObject2).getBytes(paramWebView);
        p.g(paramWebView, "(this as java.lang.String).getBytes(charset)");
        paramWebView = new WebResourceResponse("text/html", "utf8", (InputStream)new ByteArrayInputStream(paramWebView));
        locala.used = true;
        ((c)localObject1).JCS.a(b.JCF);
        AppMethodBeat.o(225210);
        return paramWebView;
      }
      ((c)localObject1).JCS.a(b.JCG);
      paramWebView = "webCompt: " + paramWebView + " not found";
      paramWebResourceRequest = d.UTF_8;
      if (paramWebView == null)
      {
        paramWebView = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(225210);
        throw paramWebView;
      }
      paramWebView = paramWebView.getBytes(paramWebResourceRequest);
      p.g(paramWebView, "(this as java.lang.String).getBytes(charset)");
      paramWebView = new WebResourceResponse("text/html", "utf8", (InputStream)new ByteArrayInputStream(paramWebView));
      AppMethodBeat.o(225210);
      return paramWebView;
      AppMethodBeat.o(225210);
      return null;
    }
  }
  
  public final k.a o(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(225209);
    p.h(paramWebView, "webView");
    p.h(paramString, "url");
    c.b localb = c.JDf;
    if (n.J(paramString, c.giN(), false))
    {
      paramWebView = new k.a(true, false);
      AppMethodBeat.o(225209);
      return paramWebView;
    }
    paramWebView = super.o(paramWebView, paramString);
    AppMethodBeat.o(225209);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.e
 * JD-Core Version:    0.7.0.1
 */