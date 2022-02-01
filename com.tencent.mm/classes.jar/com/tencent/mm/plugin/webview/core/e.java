package com.tencent.mm.plugin.webview.core;

import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;", "", "uin", "", "(J)V", "realUin", "getRealUin", "()J", "realUin$delegate", "Lkotlin/Lazy;", "sampleRate", "getSampleRate", "sampleRate$delegate", "getUin", "reportReceivedError", "", "errorCode", "", "description", "", "failingUrl", "reportReceivedHttpError", "request", "Lcom/tencent/xweb/WebResourceRequest;", "response", "Lcom/tencent/xweb/WebResourceResponse;", "reportReceivedReceivedSslError", "error", "Landroid/net/http/SslError;", "shouldReport", "", "urlEncode", "Companion", "webview-sdk_release"})
public final class e
{
  public static final a ILt;
  private final f ILr;
  private final f ILs;
  final long uin;
  
  static
  {
    AppMethodBeat.i(225041);
    ILt = new a((byte)0);
    AppMethodBeat.o(225041);
  }
  
  public e(long paramLong)
  {
    AppMethodBeat.i(225040);
    this.uin = paramLong;
    this.ILr = g.ah((a)new b(this));
    this.ILs = g.ah((a)f.ILA);
    AppMethodBeat.o(225040);
  }
  
  private final long fZN()
  {
    AppMethodBeat.i(225037);
    long l = ((Number)this.ILr.getValue()).longValue();
    AppMethodBeat.o(225037);
    return l;
  }
  
  private final long getSampleRate()
  {
    AppMethodBeat.i(225038);
    long l = ((Number)this.ILs.getValue()).longValue();
    AppMethodBeat.o(225038);
    return l;
  }
  
  final boolean bVc()
  {
    AppMethodBeat.i(225039);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || ((Log.getLogLevel() <= 1) && (WeChatEnvironment.hasDebugger())))
    {
      AppMethodBeat.o(225039);
      return true;
    }
    if ((fZN() == 0L) || (fZN() == -1L))
    {
      AppMethodBeat.o(225039);
      return true;
    }
    if ((fZN() <= 0L) || (getSampleRate() <= 0L))
    {
      AppMethodBeat.o(225039);
      return false;
    }
    if (fZN() % getSampleRate() == 0L)
    {
      AppMethodBeat.o(225039);
      return true;
    }
    AppMethodBeat.o(225039);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor$Companion;", "", "()V", "DEFAULT_REPORT_SAMPLE_RATE", "", "DEFAULT_UIN", "DEFAULT_UN_LOGIN_UIN", "ERROR_TYPE_HTTP", "", "ERROR_TYPE_NORMAL", "ERROR_TYPE_SSL", "LOG_ID", "PAGE_ICON_SUFFIX", "", "TAG", "webview-sdk_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Long>
  {
    b(e parame)
    {
      super();
    }
    
    private long fZO()
    {
      AppMethodBeat.i(225031);
      long l1 = 0L;
      try
      {
        String str = com.tencent.mm.b.p.getString((int)this.ILu.uin);
        kotlin.g.b.p.g(str, "UIN.getString(uin.toInt())");
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
      AppMethodBeat.o(225031);
      return l1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame, String paramString1, int paramInt, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(225032);
      Object localObject1 = null;
      try
      {
        localObject2 = Uri.parse(this.ILv);
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject2;
          Log.e("MicroMsg.WebPageErrorMonitor", "onReceivedError, parse uri error:" + this.ILv);
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
      kotlin.g.b.p.g(localObject1, "uri?.host ?: \"\"");
      h.CyF.a(22086, new Object[] { Integer.valueOf(1), Integer.valueOf(this.tyb), localObject1, e.aXE(this.ILv), e.aXE(this.ILw) });
      AppMethodBeat.o(225032);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(e parame, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse) {}
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(225033);
      if (!this.ILx.isForMainFrame())
      {
        localObject1 = this.ILx.getUrl();
        if (localObject1 != null)
        {
          localObject1 = ((Uri)localObject1).getPath();
          if ((localObject1 != null) && (n.K((String)localObject1, ".ico", false) == true))
          {
            AppMethodBeat.o(225033);
            return;
          }
        }
      }
      Object localObject1 = this.ILx.getUrl();
      kotlin.g.b.p.g(localObject1, "request.url");
      Object localObject2 = ((Uri)localObject1).getHost();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      kotlin.g.b.p.g(localObject1, "request.url.host ?: \"\"");
      localObject2 = this.ILx.getUrl();
      String str;
      if (localObject2 != null)
      {
        localObject2 = ((Uri)localObject2).toString();
        str = e.aXE((String)localObject2);
        localObject2 = this.ILy;
        if (localObject2 == null) {
          break label211;
        }
      }
      label211:
      for (int i = ((WebResourceResponse)localObject2).getStatusCode();; i = -1)
      {
        WebResourceResponse localWebResourceResponse = this.ILy;
        localObject2 = localObject3;
        if (localWebResourceResponse != null) {
          localObject2 = localWebResourceResponse.getReasonPhrase();
        }
        localObject2 = e.aXE((String)localObject2);
        h.CyF.a(22086, new Object[] { Integer.valueOf(2), Integer.valueOf(i), localObject1, str, localObject2 });
        AppMethodBeat.o(225033);
        return;
        localObject2 = null;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(e parame, SslError paramSslError) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(225034);
      Object localObject2 = this.ILz.getUrl();
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
        kotlin.g.b.p.g(localObject2, "uri?.host ?: \"\"");
        int i = this.ILz.getPrimaryError();
        Object localObject4 = this.ILz.getCertificate();
        if (localObject4 != null) {
          str = ((SslCertificate)localObject4).toString();
        }
        str = e.aXE(str);
        h.CyF.a(22086, new Object[] { Integer.valueOf(3), Integer.valueOf(i), localObject2, e.aXE((String)localObject1), str });
        AppMethodBeat.o(225034);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<Long>
  {
    public static final f ILA;
    
    static
    {
      AppMethodBeat.i(225036);
      ILA = new f();
      AppMethodBeat.o(225036);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.e
 * JD-Core Version:    0.7.0.1
 */