package com.tencent.mm.plugin.webview.core;

import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;", "", "uin", "", "(J)V", "realUin", "getRealUin", "()J", "realUin$delegate", "Lkotlin/Lazy;", "sampleRate", "getSampleRate", "sampleRate$delegate", "getUin", "reportLoadError", "", "errorCode", "", "description", "", "failingUrl", "appId", "webCoreType", "pageLoadType", "reportReceivedError", "isForMainFrame", "", "reportReceivedHttpError", "request", "Lcom/tencent/xweb/WebResourceRequest;", "response", "Lcom/tencent/xweb/WebResourceResponse;", "reportReceivedReceivedSslError", "error", "Landroid/net/http/SslError;", "shouldReport", "urlEncode", "Companion", "webview-sdk_release"})
public final class e
{
  public static final a PHr;
  private final f PHp;
  private final f PHq;
  final long uin;
  
  static
  {
    AppMethodBeat.i(206775);
    PHr = new a((byte)0);
    AppMethodBeat.o(206775);
  }
  
  public e(long paramLong)
  {
    AppMethodBeat.i(206774);
    this.uin = paramLong;
    this.PHp = g.ar((a)new b(this));
    this.PHq = g.ar((a)g.PHB);
    AppMethodBeat.o(206774);
  }
  
  private final long gSF()
  {
    AppMethodBeat.i(206768);
    long l = ((Number)this.PHp.getValue()).longValue();
    AppMethodBeat.o(206768);
    return l;
  }
  
  private final long getSampleRate()
  {
    AppMethodBeat.i(206769);
    long l = ((Number)this.PHq.getValue()).longValue();
    AppMethodBeat.o(206769);
    return l;
  }
  
  public final void a(final int paramInt1, final String paramString1, final String paramString2, final String paramString3, final int paramInt2, final int paramInt3, final boolean paramBoolean)
  {
    AppMethodBeat.i(206770);
    if (!cin())
    {
      AppMethodBeat.o(206770);
      return;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(206770);
      return;
    }
    com.tencent.e.h.ZvG.d((Runnable)new d(this, paramString2, paramInt1, paramString1, paramBoolean, paramString3, paramInt2, paramInt3), "MicroMsg.WebPageErrorMonitor");
    AppMethodBeat.o(206770);
  }
  
  final boolean cin()
  {
    AppMethodBeat.i(206773);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || ((Log.getLogLevel() <= 1) && (WeChatEnvironment.hasDebugger())))
    {
      AppMethodBeat.o(206773);
      return true;
    }
    if ((gSF() == 0L) || (gSF() == -1L))
    {
      AppMethodBeat.o(206773);
      return true;
    }
    if ((gSF() <= 0L) || (getSampleRate() <= 0L))
    {
      AppMethodBeat.o(206773);
      return false;
    }
    if (gSF() % getSampleRate() == 0L)
    {
      AppMethodBeat.o(206773);
      return true;
    }
    AppMethodBeat.o(206773);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor$Companion;", "", "()V", "COMM_FAST_LOAD", "", "DEFAULT_REPORT_SAMPLE_RATE", "", "DEFAULT_UIN", "DEFAULT_UN_LOGIN_UIN", "ERROR_TYPE_HTTP", "ERROR_TYPE_LOAD_ERROR", "ERROR_TYPE_NORMAL", "ERROR_TYPE_SSL", "LOG_ID", "MP_FAST_LOAD", "NORMAL_LOAD", "PAGE_ICON_SUFFIX", "", "SYS_KERNEL", "TAG", "UNKNOWN_KERNEL", "X5_KERNEL", "XWEB_KERNEL", "getWebCoreType", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "webview-sdk_release"})
  public static final class a
  {
    public static int e(MMWebView paramMMWebView)
    {
      AppMethodBeat.i(213856);
      if (paramMMWebView == null)
      {
        AppMethodBeat.o(213856);
        return 0;
      }
      if (paramMMWebView.getIsX5Kernel())
      {
        AppMethodBeat.o(213856);
        return 1;
      }
      if (paramMMWebView.isXWalkKernel())
      {
        AppMethodBeat.o(213856);
        return 2;
      }
      AppMethodBeat.o(213856);
      return 3;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Long>
  {
    b(e parame)
    {
      super();
    }
    
    private long gSG()
    {
      AppMethodBeat.i(206448);
      long l1 = 0L;
      try
      {
        String str = com.tencent.mm.b.p.getString((int)this.PHs.uin);
        kotlin.g.b.p.j(str, "UIN.getString(uin.toInt())");
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
      AppMethodBeat.o(206448);
      return l1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3) {}
    
    public final void run()
    {
      AppMethodBeat.i(213996);
      Object localObject1 = null;
      try
      {
        localObject2 = Uri.parse(this.PHt);
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject2;
          Log.e("MicroMsg.WebPageErrorMonitor", "onReceivedError, parse uri error:" + this.PHt);
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ((Uri)localObject1).getHost();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      kotlin.g.b.p.j(localObject1, "uri?.host ?: \"\"");
      com.tencent.mm.plugin.report.service.h.IzE.a(22086, new Object[] { Integer.valueOf(4), Integer.valueOf(this.yfb), localObject1, e.bjy(this.PHt), e.bjy(this.PHu), Integer.valueOf(1), this.cBD, Integer.valueOf(this.PHv), Integer.valueOf(this.PHw) });
      AppMethodBeat.o(213996);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(e parame, String paramString1, int paramInt1, String paramString2, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3) {}
    
    public final void run()
    {
      AppMethodBeat.i(211038);
      Object localObject1 = null;
      try
      {
        localObject2 = Uri.parse(paramString2);
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject2;
          int j;
          String str1;
          String str2;
          Log.e("MicroMsg.WebPageErrorMonitor", "onReceivedError, parse uri error:" + paramString2);
          continue;
          int i = 0;
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ((Uri)localObject1).getHost();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      kotlin.g.b.p.j(localObject1, "uri?.host ?: \"\"");
      localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
      j = paramInt1;
      str1 = e.bjy(paramString2);
      str2 = e.bjy(paramString1);
      if (paramBoolean)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject2).a(22086, new Object[] { Integer.valueOf(1), Integer.valueOf(j), localObject1, str1, str2, Integer.valueOf(i), paramString3, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        AppMethodBeat.o(211038);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(e parame, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, String paramString, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(205528);
      if (!this.PHy.isForMainFrame())
      {
        localObject1 = this.PHy.getUrl();
        if (localObject1 != null)
        {
          localObject1 = ((Uri)localObject1).getPath();
          if ((localObject1 != null) && (n.pu((String)localObject1, ".ico") == true))
          {
            AppMethodBeat.o(205528);
            return;
          }
        }
      }
      Object localObject1 = this.PHy.getUrl();
      kotlin.g.b.p.j(localObject1, "request.url");
      Object localObject2 = ((Uri)localObject1).getHost();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      kotlin.g.b.p.j(localObject1, "request.url.host ?: \"\"");
      localObject2 = this.PHy.getUrl();
      String str;
      int i;
      if (localObject2 != null)
      {
        localObject2 = ((Uri)localObject2).toString();
        str = e.bjy((String)localObject2);
        localObject2 = this.PHz;
        if (localObject2 == null) {
          break label279;
        }
        i = ((WebResourceResponse)localObject2).getStatusCode();
        label145:
        WebResourceResponse localWebResourceResponse = this.PHz;
        localObject2 = localObject3;
        if (localWebResourceResponse != null) {
          localObject2 = localWebResourceResponse.getReasonPhrase();
        }
        localObject2 = e.bjy((String)localObject2);
        if (!this.PHy.isForMainFrame()) {
          break label284;
        }
      }
      label279:
      label284:
      for (int j = 1;; j = 0)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(22086, new Object[] { Integer.valueOf(2), Integer.valueOf(i), localObject1, str, localObject2, Integer.valueOf(j), this.cBD, Integer.valueOf(this.PHv), Integer.valueOf(this.PHw) });
        AppMethodBeat.o(205528);
        return;
        localObject2 = null;
        break;
        i = -1;
        break label145;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(e parame, SslError paramSslError, String paramString, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(215776);
      Object localObject2 = this.PHA.getUrl();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      try
      {
        localObject2 = Uri.parse((String)localObject1);
        if (localObject2 != null)
        {
          localObject4 = ((Uri)localObject2).getHost();
          localObject2 = localObject4;
          if (localObject4 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        kotlin.g.b.p.j(localObject2, "uri?.host ?: \"\"");
        int i = this.PHA.getPrimaryError();
        Object localObject4 = this.PHA.getCertificate();
        if (localObject4 != null) {
          str = ((SslCertificate)localObject4).toString();
        }
        str = e.bjy(str);
        com.tencent.mm.plugin.report.service.h.IzE.a(22086, new Object[] { Integer.valueOf(3), Integer.valueOf(i), localObject2, e.bjy((String)localObject1), str, Integer.valueOf(1), this.cBD, Integer.valueOf(this.PHv), Integer.valueOf(this.PHw) });
        AppMethodBeat.o(215776);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("MicroMsg.WebPageErrorMonitor", "onReceivedError, parse uri error:".concat(String.valueOf(localObject1)));
          Object localObject3 = null;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<Long>
  {
    public static final g PHB;
    
    static
    {
      AppMethodBeat.i(207235);
      PHB = new g();
      AppMethodBeat.o(207235);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.e
 * JD-Core Version:    0.7.0.1
 */