package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.d.b;
import com.tencent.mm.pluginsdk.model.a;
import com.tencent.mm.pluginsdk.model.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListenerImpl;", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "scene", "", "(I)V", "afterCloseStream", "", "afterGetResponseCode", "afterOpenConnection", "afterReadStreamData", "beforeCloseStream", "beforeGetResponseCode", "beforeOpenConnection", "beforeReadStreamData", "canReport", "", "downloadEnd", "downloadStart", "forceNormal", "id", "", "requestImageType", "startDownload", "url", "urlKey", "onAfterCloseStream", "", "onAfterGetResponseCode", "onAfterOpenConnection", "connection", "Ljava/net/HttpURLConnection;", "onAfterReadStreamData", "onBeforeCloseStream", "onBeforeGetResponseCode", "onBeforeOpenConnection", "onBeforeReadStreamData", "onDisconnect", "onRequest", "imageType", "onResult", "success", "onResultError", "responseCode", "onResultSuccess", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onRetry", "onStart", "key", "requestUrl", "Companion", "plugin-biz_release"})
public final class k
  implements j
{
  public static final k.a EVB;
  private String EPe;
  private long EVA;
  private boolean EVo;
  private int EVp;
  private long EVr;
  private long EVs;
  private long EVt;
  private long EVu;
  private long EVv;
  private long EVw;
  private long EVx;
  private long EVy;
  private long EVz;
  private long dBL;
  private boolean gvn;
  private final String id;
  private int scene;
  private String url;
  
  static
  {
    AppMethodBeat.i(124893);
    EVB = new k.a((byte)0);
    AppMethodBeat.o(124893);
  }
  
  public k(int paramInt)
  {
    AppMethodBeat.i(124892);
    this.scene = paramInt;
    g localg = g.EVk;
    this.gvn = g.YO(paramInt);
    this.id = String.valueOf(hashCode());
    AppMethodBeat.o(124892);
  }
  
  private final void biU()
  {
    AppMethodBeat.i(124891);
    Object localObject = g.EVk;
    if (g.YP(this.scene))
    {
      localObject = a.EKY;
      a.cK(3, this.EPe);
    }
    AppMethodBeat.o(124891);
  }
  
  public final void YQ(int paramInt)
  {
    AppMethodBeat.i(124890);
    ad.e("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultError id: %s, requestImageType: %d, responseCode: %d", new Object[] { this.id, Integer.valueOf(this.EVp), Integer.valueOf(paramInt) });
    this.EVA = System.currentTimeMillis();
    if (this.gvn)
    {
      f localf = f.EVi;
      f.aW(this.EVp, false);
      if (this.EVo)
      {
        localf = f.EVi;
        f.aX(this.EVp, false);
      }
    }
    biU();
    AppMethodBeat.o(124890);
  }
  
  public final void aZ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(124879);
    ad.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onRequest id: %s, imageType: %d, forceNormal: %b, url: %s", new Object[] { this.id, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), this.url });
    this.EVp = paramInt;
    this.EVo = paramBoolean;
    this.EVz = System.currentTimeMillis();
    if (this.gvn)
    {
      f localf = f.EVi;
      f.fck();
      localf = f.EVi;
      f.YM(this.EVp);
      if (this.EVo)
      {
        localf = f.EVi;
        f.YN(this.EVp);
      }
    }
    AppMethodBeat.o(124879);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(124889);
    p.h(paramb, "response");
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultSuccess id: %s, contentType: %s, cost: %d", new Object[] { this.id, paramb.contentType, Long.valueOf(l - this.dBL) });
    this.EVA = System.currentTimeMillis();
    Object localObject;
    if (this.gvn)
    {
      localObject = f.EVi;
      f.aW(this.EVp, true);
      localObject = f.EVi;
      int i = this.EVp;
      localObject = paramb.contentType;
      ad.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType requestImageType: %d, responseContentType: %s", new Object[] { Integer.valueOf(i), localObject });
      g localg;
      if (i == 1) {
        localg = g.EVk;
      }
      switch (g.aMN((String)localObject))
      {
      default: 
        ad.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType responseContentType: %s", new Object[] { localObject });
        localg = g.EVk;
        switch (g.aMN((String)localObject))
        {
        }
        break;
      }
    }
    for (;;)
    {
      localObject = f.EVi;
      f.bP(paramb.contentType, this.EVA - this.EVz);
      if ((this.EVo) && (paramb.data != null))
      {
        paramb = f.EVi;
        f.aX(this.EVp, true);
      }
      biU();
      AppMethodBeat.o(124889);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.n(1111L, 7L, 1L);
      break;
      com.tencent.mm.plugin.report.service.g.yhR.n(1111L, 8L, 1L);
      break;
      com.tencent.mm.plugin.report.service.g.yhR.n(1111L, 17L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.g.yhR.n(1111L, 19L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.g.yhR.n(1111L, 36L, 1L);
    }
  }
  
  public final void ef(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124877);
    this.EPe = paramString1;
    this.url = paramString2;
    this.dBL = System.currentTimeMillis();
    paramString1 = g.EVk;
    if (g.YP(this.scene))
    {
      paramString1 = a.EKY;
      a.cJ(3, this.EPe);
    }
    ad.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onStart id: %s", new Object[] { this.id });
    AppMethodBeat.o(124877);
  }
  
  public final void fcn()
  {
    AppMethodBeat.i(124878);
    Object localObject = g.EVk;
    if (g.YP(this.scene))
    {
      localObject = a.EKY;
      localObject = this.EPe;
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
        ad.d("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload id: %s, url: %s", new Object[] { a.aLt((String)localObject), localObject });
        a.v((Runnable)new a.i((String)localObject, System.currentTimeMillis()));
      }
      AppMethodBeat.o(124878);
      return;
    }
  }
  
  public final void fco()
  {
    AppMethodBeat.i(124880);
    this.EVr = System.currentTimeMillis();
    AppMethodBeat.o(124880);
  }
  
  public final void fcp()
  {
    AppMethodBeat.i(124881);
    this.EVs = System.currentTimeMillis();
    ad.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onAfterOpenConnection id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.EVs - this.EVr) });
    AppMethodBeat.o(124881);
  }
  
  public final void fcq()
  {
    AppMethodBeat.i(124882);
    this.EVt = System.currentTimeMillis();
    AppMethodBeat.o(124882);
  }
  
  public final void fcr()
  {
    AppMethodBeat.i(124883);
    this.EVu = System.currentTimeMillis();
    ad.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo getResponseCode id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.EVu - this.EVt) });
    AppMethodBeat.o(124883);
  }
  
  public final void fcs()
  {
    AppMethodBeat.i(124884);
    this.EVv = System.currentTimeMillis();
    AppMethodBeat.o(124884);
  }
  
  public final void fct()
  {
    AppMethodBeat.i(124885);
    this.EVw = System.currentTimeMillis();
    ad.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo readStreamData id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.EVw - this.EVv) });
    AppMethodBeat.o(124885);
  }
  
  public final void fcu()
  {
    AppMethodBeat.i(124886);
    this.EVx = System.currentTimeMillis();
    AppMethodBeat.o(124886);
  }
  
  public final void fcv()
  {
    AppMethodBeat.i(124887);
    this.EVy = System.currentTimeMillis();
    ad.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo closeStream id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.EVy - this.EVx) });
    AppMethodBeat.o(124887);
  }
  
  public final void fcw()
  {
    AppMethodBeat.i(124888);
    ad.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onDisconnect id: %s", new Object[] { this.id });
    AppMethodBeat.o(124888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.k
 * JD-Core Version:    0.7.0.1
 */