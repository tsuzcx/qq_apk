package com.tencent.mm.plugin.webview.l;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.core.m.a;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.protocal.protobuf.ghh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/webcompt/WebComponentInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "TAG", "", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideGetA8Key", "", "url", "force", "reason", "", "overrideProcessResult", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends m
{
  private final String TAG = "MicroMsg.WebComponentInterceptor";
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(295418);
    s.u(paramWebView, "webview");
    s.u(paramWebResourceRequest, "request");
    paramWebView = paramWebResourceRequest.getUrl().toString();
    s.s(paramWebView, "request.url.toString()");
    Object localObject1 = c.XuL;
    if (n.U(paramWebView, c.iDd(), false))
    {
      paramWebView = getController().getJsapi().itJ();
      if (paramWebView != null)
      {
        s.u(paramWebResourceRequest, "request");
        localObject1 = paramWebView.Xws;
        s.u(paramWebResourceRequest, "request");
        paramWebResourceRequest = paramWebResourceRequest.getUrl();
        paramWebView = paramWebResourceRequest.getHost();
        if (paramWebView == null) {
          paramWebView = "";
        }
        c.m.a locala;
        Object localObject2;
        for (;;)
        {
          Log.i(c.TAG, s.X("getInterceptResponse ", paramWebResourceRequest));
          ((c)localObject1).XuN.a(b.Xux);
          locala = (c.m.a)((c)localObject1).iDa().get(paramWebView);
          if (locala == null) {
            break label415;
          }
          paramWebView = new StringBuilder("['");
          localObject2 = c.XuL;
          paramWebView = p.a((Iterable)c.mn((List)c.XuQ.getValue()), (CharSequence)"','", null, null, 0, null, null, 62) + "']";
          Log.i(c.TAG, "buildMatrix " + paramWebView + ", " + paramWebResourceRequest);
          localObject2 = c.XuL;
          localObject2 = n.bW((String)c.XuR.getValue(), "$__IFRAME_MATRIX__$", paramWebView);
          String str = locala.XvO.name;
          s.s(str, "worker.webComptInfo.name");
          localObject2 = n.bW((String)localObject2, "$__WEB_COMPT_NAME__$", str);
          c.c(locala.iDs(), "WeixinWebCompt.onBind.apply(WeixinWebCompt, " + paramWebView + ')');
          Log.i(c.TAG, s.X("ready to response ", paramWebResourceRequest));
          paramWebView = kotlin.n.d.UTF_8;
          if (localObject2 != null) {
            break;
          }
          paramWebView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(295418);
          throw paramWebView;
        }
        paramWebView = ((String)localObject2).getBytes(paramWebView);
        s.s(paramWebView, "(this as java.lang.String).getBytes(charset)");
        paramWebView = new WebResourceResponse("text/html", "utf8", (InputStream)new ByteArrayInputStream(paramWebView));
        locala.bgt = true;
        ((c)localObject1).XuN.a(b.Xuy);
        AppMethodBeat.o(295418);
        return paramWebView;
        label415:
        ((c)localObject1).XuN.a(b.Xuz);
        paramWebView = "webCompt: " + paramWebView + " not found";
        paramWebResourceRequest = kotlin.n.d.UTF_8;
        if (paramWebView == null)
        {
          paramWebView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(295418);
          throw paramWebView;
        }
        paramWebView = paramWebView.getBytes(paramWebResourceRequest);
        s.s(paramWebView, "(this as java.lang.String).getBytes(charset)");
        paramWebView = new WebResourceResponse("text/html", "utf8", (InputStream)new ByteArrayInputStream(paramWebView));
        AppMethodBeat.o(295418);
        return paramWebView;
      }
    }
    AppMethodBeat.o(295418);
    return null;
  }
  
  public final boolean b(int paramInt, String paramString, cdf paramcdf)
  {
    AppMethodBeat.i(295424);
    s.u(paramString, "reqUrl");
    s.u(paramcdf, "resp");
    paramString = paramcdf.aanA;
    byte[] arrayOfByte;
    if (paramString != null)
    {
      arrayOfByte = w.a(paramString);
      if (arrayOfByte == null) {}
    }
    try
    {
      paramString = new ghh();
      paramString.parseFrom(arrayOfByte);
      paramcdf = paramcdf.aanm;
      s.s(paramcdf, "resp.FullURL");
      e.h(paramcdf, paramString.aaJo);
      AppMethodBeat.o(295424);
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
  
  public final boolean f(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(295401);
    s.u(paramString, "url");
    c.b localb = c.XuL;
    if (n.U(paramString, c.iDd(), false))
    {
      AppMethodBeat.o(295401);
      return true;
    }
    AppMethodBeat.o(295401);
    return false;
  }
  
  public final m.a j(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(295405);
    s.u(paramWebView, "webView");
    s.u(paramString, "url");
    c.b localb = c.XuL;
    if (n.U(paramString, c.iDd(), false))
    {
      paramWebView = new m.a(true, false);
      AppMethodBeat.o(295405);
      return paramWebView;
    }
    paramWebView = super.j(paramWebView, paramString);
    AppMethodBeat.o(295405);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.d
 * JD-Core Version:    0.7.0.1
 */