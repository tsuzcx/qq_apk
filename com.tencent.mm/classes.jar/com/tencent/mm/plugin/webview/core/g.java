package com.tencent.mm.plugin.webview.core;

import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.threadpool.i;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;", "", "uin", "", "(J)V", "realUin", "getRealUin", "()J", "realUin$delegate", "Lkotlin/Lazy;", "sampleRate", "getSampleRate", "sampleRate$delegate", "getUin", "reportLoadError", "", "errorCode", "", "description", "", "failingUrl", "appId", "webCoreType", "pageLoadType", "reportReceivedError", "isForMainFrame", "", "reportReceivedHttpError", "request", "Lcom/tencent/xweb/WebResourceRequest;", "response", "Lcom/tencent/xweb/WebResourceResponse;", "reportReceivedReceivedSslError", "error", "Landroid/net/http/SslError;", "shouldReport", "urlEncode", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final a WxV;
  private final j WxW;
  private final j WxX;
  final long uin;
  
  static
  {
    AppMethodBeat.i(295174);
    WxV = new a((byte)0);
    AppMethodBeat.o(295174);
  }
  
  public g(long paramLong)
  {
    AppMethodBeat.i(295121);
    this.uin = paramLong;
    this.WxW = k.cm((a)new b(this));
    this.WxX = k.cm((a)c.WxZ);
    AppMethodBeat.o(295121);
  }
  
  private static String EL(String paramString)
  {
    AppMethodBeat.i(295147);
    if (paramString == null)
    {
      AppMethodBeat.o(295147);
      return "";
    }
    paramString = URLEncoder.encode(paramString, "UTF-8");
    s.s(paramString, "encode(this, \"UTF-8\")");
    AppMethodBeat.o(295147);
    return paramString;
  }
  
  private static final void a(SslError paramSslError, g paramg, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(295170);
    s.u(paramg, "this$0");
    paramg = paramSslError.getUrl();
    localObject1 = paramg;
    if (paramg == null) {
      localObject1 = "";
    }
    paramg = null;
    try
    {
      Uri localUri = Uri.parse((String)localObject1);
      paramg = localUri;
    }
    finally
    {
      for (;;)
      {
        int i;
        Log.e("MicroMsg.WebPageErrorMonitor", s.X("onReceivedError, parse uri error:", localObject1));
        continue;
        String str = paramg.getHost();
        paramg = str;
        if (str == null)
        {
          paramg = "";
          continue;
          paramSslError = paramSslError.toString();
        }
      }
    }
    if (paramg == null)
    {
      paramg = "";
      i = paramSslError.getPrimaryError();
      paramSslError = paramSslError.getCertificate();
      if (paramSslError != null) {
        break label185;
      }
      paramSslError = null;
      paramSslError = EL(paramSslError);
      com.tencent.mm.plugin.report.service.h.OAn.b(22086, new Object[] { Integer.valueOf(3), Integer.valueOf(i), paramg, EL((String)localObject1), paramSslError, Integer.valueOf(1), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(295170);
    }
  }
  
  private static final void a(WebResourceRequest paramWebResourceRequest, g paramg, WebResourceResponse paramWebResourceResponse, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(295163);
    s.u(paramg, "this$0");
    int i;
    if (!paramWebResourceRequest.isForMainFrame())
    {
      paramg = paramWebResourceRequest.getUrl();
      if (paramg != null)
      {
        paramg = paramg.getPath();
        if ((paramg == null) || (n.rs(paramg, ".ico") != true)) {}
      }
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(295163);
        return;
      }
    }
    Object localObject = paramWebResourceRequest.getUrl().getHost();
    paramg = (g)localObject;
    if (localObject == null) {
      paramg = "";
    }
    localObject = paramWebResourceRequest.getUrl();
    if (localObject == null)
    {
      localObject = null;
      localObject = EL((String)localObject);
      if (paramWebResourceResponse != null) {
        break label234;
      }
      i = -1;
      label122:
      if (paramWebResourceResponse != null) {
        break label243;
      }
      paramWebResourceResponse = null;
      label128:
      paramWebResourceResponse = EL(paramWebResourceResponse);
      if (!paramWebResourceRequest.isForMainFrame()) {
        break label251;
      }
    }
    label234:
    label243:
    label251:
    for (int j = 1;; j = 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(22086, new Object[] { Integer.valueOf(2), Integer.valueOf(i), paramg, localObject, paramWebResourceResponse, Integer.valueOf(j), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(295163);
      return;
      localObject = ((Uri)localObject).toString();
      break;
      i = paramWebResourceResponse.mStatusCode;
      break label122;
      paramWebResourceResponse = paramWebResourceResponse.mReasonPhrase;
      break label128;
    }
  }
  
  private static final void a(String paramString1, int paramInt1, g paramg, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(295158);
    s.u(paramg, "this$0");
    paramg = null;
    try
    {
      Uri localUri = Uri.parse(paramString1);
      paramg = localUri;
    }
    finally
    {
      for (;;)
      {
        Log.e("MicroMsg.WebPageErrorMonitor", s.X("onReceivedError, parse uri error:", paramString1));
        continue;
        String str = paramg.getHost();
        paramg = str;
        if (str == null) {
          paramg = "";
        }
      }
    }
    if (paramg == null)
    {
      paramg = "";
      com.tencent.mm.plugin.report.service.h.OAn.b(22086, new Object[] { Integer.valueOf(4), Integer.valueOf(paramInt1), paramg, EL(paramString1), EL(paramString2), Integer.valueOf(1), paramString3, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      AppMethodBeat.o(295158);
      return;
    }
  }
  
  private static final void a(String paramString1, int paramInt1, g paramg, String paramString2, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(295152);
    s.u(paramg, "this$0");
    paramg = null;
    try
    {
      localObject1 = Uri.parse(paramString1);
      paramg = (g)localObject1;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        int i;
        Log.e("MicroMsg.WebPageErrorMonitor", s.X("onReceivedError, parse uri error:", paramString1));
        continue;
        String str = paramg.getHost();
        paramg = str;
        if (str == null)
        {
          paramg = "";
          continue;
          i = 0;
        }
      }
    }
    if (paramg == null)
    {
      paramg = "";
      localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
      paramString1 = EL(paramString1);
      paramString2 = EL(paramString2);
      if (!paramBoolean) {
        break label165;
      }
      i = 1;
      ((com.tencent.mm.plugin.report.service.h)localObject1).b(22086, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), paramg, paramString1, paramString2, Integer.valueOf(i), paramString3, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      AppMethodBeat.o(295152);
    }
  }
  
  private final boolean cJe()
  {
    AppMethodBeat.i(295144);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || ((Log.getLogLevel() <= 1) && (WeChatEnvironment.hasDebugger())))
    {
      AppMethodBeat.o(295144);
      return true;
    }
    if ((isl() == 0L) || (isl() == -1L))
    {
      AppMethodBeat.o(295144);
      return true;
    }
    if ((isl() <= 0L) || (getSampleRate() <= 0L))
    {
      AppMethodBeat.o(295144);
      return false;
    }
    if (isl() % getSampleRate() == 0L)
    {
      AppMethodBeat.o(295144);
      return true;
    }
    AppMethodBeat.o(295144);
    return false;
  }
  
  private final long getSampleRate()
  {
    AppMethodBeat.i(295131);
    long l = ((Number)this.WxX.getValue()).longValue();
    AppMethodBeat.o(295131);
    return l;
  }
  
  private final long isl()
  {
    AppMethodBeat.i(295125);
    long l = ((Number)this.WxW.getValue()).longValue();
    AppMethodBeat.o(295125);
    return l;
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(295203);
    if (!cJe())
    {
      AppMethodBeat.o(295203);
      return;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(295203);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new g..ExternalSyntheticLambda2(paramString2, paramInt1, this, paramString1, paramString3, paramInt2, paramInt3), "MicroMsg.WebPageErrorMonitor");
    AppMethodBeat.o(295203);
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(295198);
    if (!cJe())
    {
      AppMethodBeat.o(295198);
      return;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(295198);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new g..ExternalSyntheticLambda3(paramString2, paramInt1, this, paramString1, paramBoolean, paramString3, paramInt2, paramInt3), "MicroMsg.WebPageErrorMonitor");
    AppMethodBeat.o(295198);
  }
  
  public final void a(SslError paramSslError, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(295214);
    if (!cJe())
    {
      AppMethodBeat.o(295214);
      return;
    }
    if (paramSslError == null)
    {
      AppMethodBeat.o(295214);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new g..ExternalSyntheticLambda0(paramSslError, this, paramString, paramInt1, paramInt2), "MicroMsg.WebPageErrorMonitor");
    AppMethodBeat.o(295214);
  }
  
  public final void a(WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(295210);
    if (!cJe())
    {
      AppMethodBeat.o(295210);
      return;
    }
    if (paramWebResourceRequest == null)
    {
      AppMethodBeat.o(295210);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new g..ExternalSyntheticLambda1(paramWebResourceRequest, this, paramWebResourceResponse, paramString, paramInt1, paramInt2), "MicroMsg.WebPageErrorMonitor");
    AppMethodBeat.o(295210);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor$Companion;", "", "()V", "COMM_FAST_LOAD", "", "DEFAULT_REPORT_SAMPLE_RATE", "", "DEFAULT_UIN", "DEFAULT_UN_LOGIN_UIN", "ERROR_TYPE_HTTP", "ERROR_TYPE_LOAD_ERROR", "ERROR_TYPE_NORMAL", "ERROR_TYPE_SSL", "LOG_ID", "MP_FAST_LOAD", "NORMAL_LOAD", "PAGE_ICON_SUFFIX", "", "SYS_KERNEL", "TAG", "UNKNOWN_KERNEL", "X5_KERNEL", "XWEB_KERNEL", "getWebCoreType", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static int g(MMWebView paramMMWebView)
    {
      AppMethodBeat.i(295059);
      if (paramMMWebView == null)
      {
        AppMethodBeat.o(295059);
        return 0;
      }
      if (paramMMWebView.getIsX5Kernel())
      {
        AppMethodBeat.o(295059);
        return 1;
      }
      if (paramMMWebView.isXWalkKernel())
      {
        AppMethodBeat.o(295059);
        return 2;
      }
      AppMethodBeat.o(295059);
      return 3;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Long>
  {
    b(g paramg)
    {
      super();
    }
    
    private Long ism()
    {
      AppMethodBeat.i(295045);
      long l1 = 0L;
      try
      {
        String str = p.getString((int)this.WxY.uin);
        s.s(str, "getString(uin.toInt())");
        long l2 = Long.parseLong(str);
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.i("MicroMsg.WebPageErrorMonitor", "uin parse error");
        }
      }
      AppMethodBeat.o(295045);
      return Long.valueOf(l1);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<Long>
  {
    public static final c WxZ;
    
    static
    {
      AppMethodBeat.i(295041);
      WxZ = new c();
      AppMethodBeat.o(295041);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.g
 * JD-Core Version:    0.7.0.1
 */