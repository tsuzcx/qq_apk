package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.pluginsdk.model.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListenerImpl;", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "scene", "", "(I)V", "afterCloseStream", "", "afterGetResponseCode", "afterOpenConnection", "afterReadStreamData", "beforeCloseStream", "beforeGetResponseCode", "beforeOpenConnection", "beforeReadStreamData", "canReport", "", "downloadEnd", "downloadStart", "forceNormal", "id", "", "requestImageType", "startDownload", "url", "urlKey", "onAfterCloseStream", "", "onAfterGetResponseCode", "onAfterOpenConnection", "connection", "Ljava/net/HttpURLConnection;", "onAfterReadStreamData", "onBeforeCloseStream", "onBeforeGetResponseCode", "onBeforeOpenConnection", "onBeforeReadStreamData", "onDisconnect", "onRequest", "imageType", "onResult", "success", "onResultError", "responseCode", "onResultSuccess", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onRetry", "onStart", "key", "requestUrl", "Companion", "plugin-biz_release"})
public final class k
  implements j
{
  public static final k.a RfA;
  private String QYU;
  private boolean Rfn;
  private int Rfo;
  private long Rfq;
  private long Rfr;
  private long Rfs;
  private long Rft;
  private long Rfu;
  private long Rfv;
  private long Rfw;
  private long Rfx;
  private long Rfy;
  private long Rfz;
  private long fOi;
  private final String id;
  private boolean jWq;
  private int scene;
  private String url;
  
  static
  {
    AppMethodBeat.i(124893);
    RfA = new k.a((byte)0);
    AppMethodBeat.o(124893);
  }
  
  public k(int paramInt)
  {
    AppMethodBeat.i(124892);
    this.scene = paramInt;
    g localg = g.Rfj;
    this.jWq = g.aqh(paramInt);
    this.id = String.valueOf(hashCode());
    AppMethodBeat.o(124892);
  }
  
  private final void bQw()
  {
    AppMethodBeat.i(124891);
    Object localObject = g.Rfj;
    if (g.aqi(this.scene))
    {
      localObject = c.QUt;
      c.de(3, this.QYU);
    }
    AppMethodBeat.o(124891);
  }
  
  public final void aqj(int paramInt)
  {
    AppMethodBeat.i(124890);
    Log.e("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultError id: %s, requestImageType: %d, responseCode: %d", new Object[] { this.id, Integer.valueOf(this.Rfo), Integer.valueOf(paramInt) });
    this.Rfz = System.currentTimeMillis();
    if (this.jWq)
    {
      f localf = f.Rfh;
      f.bI(this.Rfo, false);
      if (this.Rfn)
      {
        localf = f.Rfh;
        f.bJ(this.Rfo, false);
      }
    }
    bQw();
    AppMethodBeat.o(124890);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(124889);
    p.k(paramb, "response");
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultSuccess id: %s, contentType: %s, cost: %d", new Object[] { this.id, paramb.contentType, Long.valueOf(l - this.fOi) });
    this.Rfz = System.currentTimeMillis();
    Object localObject;
    if (this.jWq)
    {
      localObject = f.Rfh;
      f.bI(this.Rfo, true);
      localObject = f.Rfh;
      int i = this.Rfo;
      localObject = paramb.contentType;
      Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType requestImageType: %d, responseContentType: %s", new Object[] { Integer.valueOf(i), localObject });
      g localg;
      if (i == 1) {
        localg = g.Rfj;
      }
      switch (g.brh((String)localObject))
      {
      default: 
        Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType responseContentType: %s", new Object[] { localObject });
        localg = g.Rfj;
        switch (g.brh((String)localObject))
        {
        }
        break;
      }
    }
    for (;;)
    {
      localObject = f.Rfh;
      f.bY(paramb.contentType, this.Rfz - this.Rfy);
      if ((this.Rfn) && (paramb.data != null))
      {
        paramb = f.Rfh;
        f.bJ(this.Rfo, true);
      }
      bQw();
      AppMethodBeat.o(124889);
      return;
      h.IzE.p(1111L, 7L, 1L);
      break;
      h.IzE.p(1111L, 8L, 1L);
      break;
      h.IzE.p(1111L, 17L, 1L);
      continue;
      h.IzE.p(1111L, 19L, 1L);
      continue;
      h.IzE.p(1111L, 36L, 1L);
    }
  }
  
  public final void bL(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(124879);
    Log.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onRequest id: %s, imageType: %d, forceNormal: %b, url: %s", new Object[] { this.id, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), this.url });
    this.Rfo = paramInt;
    this.Rfn = paramBoolean;
    this.Rfy = System.currentTimeMillis();
    if (this.jWq)
    {
      f localf = f.Rfh;
      f.hkf();
      localf = f.Rfh;
      f.aqf(this.Rfo);
      if (this.Rfn)
      {
        localf = f.Rfh;
        f.aqg(this.Rfo);
      }
    }
    AppMethodBeat.o(124879);
  }
  
  public final void eM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124877);
    this.QYU = paramString1;
    this.url = paramString2;
    this.fOi = System.currentTimeMillis();
    paramString1 = g.Rfj;
    if (g.aqi(this.scene))
    {
      paramString1 = c.QUt;
      c.dd(3, this.QYU);
    }
    Log.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onStart id: %s", new Object[] { this.id });
    AppMethodBeat.o(124877);
  }
  
  public final void hki()
  {
    AppMethodBeat.i(124878);
    Object localObject = g.Rfj;
    if (g.aqi(this.scene))
    {
      localObject = c.QUt;
      localObject = this.QYU;
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label101;
      }
    }
    label101:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.d("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload id: %s, url: %s", new Object[] { c.bpB((String)localObject), localObject });
        c.u((Runnable)new c.i((String)localObject, System.currentTimeMillis()));
      }
      AppMethodBeat.o(124878);
      return;
    }
  }
  
  public final void hkj()
  {
    AppMethodBeat.i(124880);
    this.Rfq = System.currentTimeMillis();
    AppMethodBeat.o(124880);
  }
  
  public final void hkk()
  {
    AppMethodBeat.i(124881);
    this.Rfr = System.currentTimeMillis();
    Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onAfterOpenConnection id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.Rfr - this.Rfq) });
    AppMethodBeat.o(124881);
  }
  
  public final void hkl()
  {
    AppMethodBeat.i(124882);
    this.Rfs = System.currentTimeMillis();
    AppMethodBeat.o(124882);
  }
  
  public final void hkm()
  {
    AppMethodBeat.i(124883);
    this.Rft = System.currentTimeMillis();
    Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo getResponseCode id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.Rft - this.Rfs) });
    AppMethodBeat.o(124883);
  }
  
  public final void hkn()
  {
    AppMethodBeat.i(124884);
    this.Rfu = System.currentTimeMillis();
    AppMethodBeat.o(124884);
  }
  
  public final void hko()
  {
    AppMethodBeat.i(124885);
    this.Rfv = System.currentTimeMillis();
    Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo readStreamData id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.Rfv - this.Rfu) });
    AppMethodBeat.o(124885);
  }
  
  public final void hkp()
  {
    AppMethodBeat.i(124886);
    this.Rfw = System.currentTimeMillis();
    AppMethodBeat.o(124886);
  }
  
  public final void hkq()
  {
    AppMethodBeat.i(124887);
    this.Rfx = System.currentTimeMillis();
    Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo closeStream id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.Rfx - this.Rfw) });
    AppMethodBeat.o(124887);
  }
  
  public final void hkr()
  {
    AppMethodBeat.i(124888);
    Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onDisconnect id: %s", new Object[] { this.id });
    AppMethodBeat.o(124888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.k
 * JD-Core Version:    0.7.0.1
 */