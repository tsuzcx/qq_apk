package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListenerImpl;", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "scene", "", "(I)V", "afterCloseStream", "", "afterGetResponseCode", "afterOpenConnection", "afterReadStreamData", "beforeCloseStream", "beforeGetResponseCode", "beforeOpenConnection", "beforeReadStreamData", "canReport", "", "downloadEnd", "downloadStart", "forceNormal", "id", "", "requestImageType", "startDownload", "url", "urlKey", "onAfterCloseStream", "", "onAfterGetResponseCode", "onAfterOpenConnection", "connection", "Ljava/net/HttpURLConnection;", "onAfterReadStreamData", "onBeforeCloseStream", "onBeforeGetResponseCode", "onBeforeOpenConnection", "onBeforeReadStreamData", "onDisconnect", "onRequest", "imageType", "onResult", "success", "onResultError", "responseCode", "onResultSuccess", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onRetry", "onStart", "key", "requestUrl", "Companion", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements j
{
  public static final k.a Ybx;
  private String XUX;
  private long YbA;
  private long YbB;
  private long YbC;
  private long YbD;
  private long YbE;
  private long YbF;
  private long YbG;
  private long YbH;
  private boolean Ybv;
  private int Ybw;
  private long Yby;
  private long Ybz;
  private long hUa;
  private final String id;
  private boolean mwk;
  private int scene;
  private String url;
  
  static
  {
    AppMethodBeat.i(124893);
    Ybx = new k.a((byte)0);
    AppMethodBeat.o(124893);
  }
  
  public k(int paramInt)
  {
    AppMethodBeat.i(124892);
    this.scene = paramInt;
    g localg = g.Ybp;
    this.mwk = g.awl(paramInt);
    this.id = String.valueOf(hashCode());
    AppMethodBeat.o(124892);
  }
  
  private final void cqs()
  {
    AppMethodBeat.i(124891);
    Object localObject = g.Ybp;
    if (g.awm(this.scene))
    {
      localObject = e.XQp;
      e.dW(3, this.XUX);
    }
    AppMethodBeat.o(124891);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(124889);
    s.u(paramb, "response");
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultSuccess id: %s, contentType: %s, cost: %d", new Object[] { this.id, paramb.contentType, Long.valueOf(l - this.hUa) });
    this.YbH = System.currentTimeMillis();
    Object localObject;
    if (this.mwk)
    {
      localObject = f.Ybo;
      f.cq(this.Ybw, true);
      localObject = f.Ybo;
      int i = this.Ybw;
      localObject = paramb.contentType;
      Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType requestImageType: %d, responseContentType: %s", new Object[] { Integer.valueOf(i), localObject });
      g localg;
      if (i == 1) {
        localg = g.Ybp;
      }
      switch (g.bqV((String)localObject))
      {
      default: 
        Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType responseContentType: %s", new Object[] { localObject });
        localg = g.Ybp;
        switch (g.bqV((String)localObject))
        {
        }
        break;
      }
    }
    for (;;)
    {
      localObject = f.Ybo;
      f.ck(paramb.contentType, this.YbH - this.YbG);
      if ((this.Ybv) && (paramb.data != null))
      {
        paramb = f.Ybo;
        f.cr(this.Ybw, true);
      }
      cqs();
      AppMethodBeat.o(124889);
      return;
      h.OAn.p(1111L, 7L, 1L);
      break;
      h.OAn.p(1111L, 8L, 1L);
      break;
      h.OAn.p(1111L, 17L, 1L);
      continue;
      h.OAn.p(1111L, 19L, 1L);
      continue;
      h.OAn.p(1111L, 36L, 1L);
    }
  }
  
  public final void awn(int paramInt)
  {
    AppMethodBeat.i(124890);
    Log.e("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultError id: %s, requestImageType: %d, responseCode: %d", new Object[] { this.id, Integer.valueOf(this.Ybw), Integer.valueOf(paramInt) });
    this.YbH = System.currentTimeMillis();
    if (this.mwk)
    {
      f localf = f.Ybo;
      f.cq(this.Ybw, false);
      if (this.Ybv)
      {
        localf = f.Ybo;
        f.cr(this.Ybw, false);
      }
    }
    cqs();
    AppMethodBeat.o(124890);
  }
  
  public final void ct(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(124879);
    Log.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onRequest id: %s, imageType: %d, forceNormal: %b, url: %s", new Object[] { this.id, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), this.url });
    this.Ybw = paramInt;
    this.Ybv = paramBoolean;
    this.YbG = System.currentTimeMillis();
    if (this.mwk)
    {
      f localf = f.Ybo;
      f.iKX();
      localf = f.Ybo;
      f.awj(this.Ybw);
      if (this.Ybv)
      {
        localf = f.Ybo;
        f.awk(this.Ybw);
      }
    }
    AppMethodBeat.o(124879);
  }
  
  public final void fd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124877);
    this.XUX = paramString1;
    this.url = paramString2;
    this.hUa = System.currentTimeMillis();
    paramString1 = g.Ybp;
    if (g.awm(this.scene))
    {
      paramString1 = e.XQp;
      e.dV(3, this.XUX);
    }
    Log.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onStart id: %s", new Object[] { this.id });
    AppMethodBeat.o(124877);
  }
  
  public final void iLa()
  {
    AppMethodBeat.i(124878);
    Object localObject = g.Ybp;
    if (g.awm(this.scene))
    {
      localObject = e.XQp;
      e.bpq(this.XUX);
    }
    AppMethodBeat.o(124878);
  }
  
  public final void iLb()
  {
    AppMethodBeat.i(124880);
    this.Yby = System.currentTimeMillis();
    AppMethodBeat.o(124880);
  }
  
  public final void iLc()
  {
    AppMethodBeat.i(124881);
    this.Ybz = System.currentTimeMillis();
    Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onAfterOpenConnection id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.Ybz - this.Yby) });
    AppMethodBeat.o(124881);
  }
  
  public final void iLd()
  {
    AppMethodBeat.i(124882);
    this.YbA = System.currentTimeMillis();
    AppMethodBeat.o(124882);
  }
  
  public final void iLe()
  {
    AppMethodBeat.i(124883);
    this.YbB = System.currentTimeMillis();
    Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo getResponseCode id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.YbB - this.YbA) });
    AppMethodBeat.o(124883);
  }
  
  public final void iLf()
  {
    AppMethodBeat.i(124884);
    this.YbC = System.currentTimeMillis();
    AppMethodBeat.o(124884);
  }
  
  public final void iLg()
  {
    AppMethodBeat.i(124885);
    this.YbD = System.currentTimeMillis();
    Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo readStreamData id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.YbD - this.YbC) });
    AppMethodBeat.o(124885);
  }
  
  public final void iLh()
  {
    AppMethodBeat.i(124886);
    this.YbE = System.currentTimeMillis();
    AppMethodBeat.o(124886);
  }
  
  public final void iLi()
  {
    AppMethodBeat.i(124887);
    this.YbF = System.currentTimeMillis();
    Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo closeStream id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.YbF - this.YbE) });
    AppMethodBeat.o(124887);
  }
  
  public final void iLj()
  {
    AppMethodBeat.i(124888);
    Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onDisconnect id: %s", new Object[] { this.id });
    AppMethodBeat.o(124888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.k
 * JD-Core Version:    0.7.0.1
 */