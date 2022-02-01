package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.pluginsdk.model.a;
import com.tencent.mm.pluginsdk.model.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListenerImpl;", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "scene", "", "(I)V", "afterCloseStream", "", "afterGetResponseCode", "afterOpenConnection", "afterReadStreamData", "beforeCloseStream", "beforeGetResponseCode", "beforeOpenConnection", "beforeReadStreamData", "canReport", "", "downloadEnd", "downloadStart", "forceNormal", "id", "", "requestImageType", "startDownload", "url", "urlKey", "onAfterCloseStream", "", "onAfterGetResponseCode", "onAfterOpenConnection", "connection", "Ljava/net/HttpURLConnection;", "onAfterReadStreamData", "onBeforeCloseStream", "onBeforeGetResponseCode", "onBeforeOpenConnection", "onBeforeReadStreamData", "onDisconnect", "onRequest", "imageType", "onResult", "success", "onResultError", "responseCode", "onResultSuccess", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onRetry", "onStart", "key", "requestUrl", "Companion", "plugin-biz_release"})
public final class k
  implements j
{
  public static final k.a FnW;
  private String Fhz;
  private boolean FnJ;
  private int FnK;
  private long FnM;
  private long FnN;
  private long FnO;
  private long FnP;
  private long FnQ;
  private long FnR;
  private long FnS;
  private long FnT;
  private long FnU;
  private long FnV;
  private long dCQ;
  private boolean gxU;
  private final String id;
  private int scene;
  private String url;
  
  static
  {
    AppMethodBeat.i(124893);
    FnW = new k.a((byte)0);
    AppMethodBeat.o(124893);
  }
  
  public k(int paramInt)
  {
    AppMethodBeat.i(124892);
    this.scene = paramInt;
    g localg = g.FnF;
    this.gxU = g.Zu(paramInt);
    this.id = String.valueOf(hashCode());
    AppMethodBeat.o(124892);
  }
  
  private final void bjD()
  {
    AppMethodBeat.i(124891);
    Object localObject = g.FnF;
    if (g.Zv(this.scene))
    {
      localObject = a.Fdw;
      a.cK(3, this.Fhz);
    }
    AppMethodBeat.o(124891);
  }
  
  public final void Zw(int paramInt)
  {
    AppMethodBeat.i(124890);
    ae.e("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultError id: %s, requestImageType: %d, responseCode: %d", new Object[] { this.id, Integer.valueOf(this.FnK), Integer.valueOf(paramInt) });
    this.FnV = System.currentTimeMillis();
    if (this.gxU)
    {
      f localf = f.FnD;
      f.bc(this.FnK, false);
      if (this.FnJ)
      {
        localf = f.FnD;
        f.bd(this.FnK, false);
      }
    }
    bjD();
    AppMethodBeat.o(124890);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(124889);
    p.h(paramb, "response");
    long l = System.currentTimeMillis();
    ae.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultSuccess id: %s, contentType: %s, cost: %d", new Object[] { this.id, paramb.contentType, Long.valueOf(l - this.dCQ) });
    this.FnV = System.currentTimeMillis();
    Object localObject;
    if (this.gxU)
    {
      localObject = f.FnD;
      f.bc(this.FnK, true);
      localObject = f.FnD;
      int i = this.FnK;
      localObject = paramb.contentType;
      ae.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType requestImageType: %d, responseContentType: %s", new Object[] { Integer.valueOf(i), localObject });
      g localg;
      if (i == 1) {
        localg = g.FnF;
      }
      switch (g.aOj((String)localObject))
      {
      default: 
        ae.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType responseContentType: %s", new Object[] { localObject });
        localg = g.FnF;
        switch (g.aOj((String)localObject))
        {
        }
        break;
      }
    }
    for (;;)
    {
      localObject = f.FnD;
      f.bQ(paramb.contentType, this.FnV - this.FnU);
      if ((this.FnJ) && (paramb.data != null))
      {
        paramb = f.FnD;
        f.bd(this.FnK, true);
      }
      bjD();
      AppMethodBeat.o(124889);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.n(1111L, 7L, 1L);
      break;
      com.tencent.mm.plugin.report.service.g.yxI.n(1111L, 8L, 1L);
      break;
      com.tencent.mm.plugin.report.service.g.yxI.n(1111L, 17L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.n(1111L, 19L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.n(1111L, 36L, 1L);
    }
  }
  
  public final void bf(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(124879);
    ae.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onRequest id: %s, imageType: %d, forceNormal: %b, url: %s", new Object[] { this.id, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), this.url });
    this.FnK = paramInt;
    this.FnJ = paramBoolean;
    this.FnU = System.currentTimeMillis();
    if (this.gxU)
    {
      f localf = f.FnD;
      f.ffY();
      localf = f.FnD;
      f.Zs(this.FnK);
      if (this.FnJ)
      {
        localf = f.FnD;
        f.Zt(this.FnK);
      }
    }
    AppMethodBeat.o(124879);
  }
  
  public final void eh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124877);
    this.Fhz = paramString1;
    this.url = paramString2;
    this.dCQ = System.currentTimeMillis();
    paramString1 = g.FnF;
    if (g.Zv(this.scene))
    {
      paramString1 = a.Fdw;
      a.cJ(3, this.Fhz);
    }
    ae.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onStart id: %s", new Object[] { this.id });
    AppMethodBeat.o(124877);
  }
  
  public final void fgb()
  {
    AppMethodBeat.i(124878);
    Object localObject = g.FnF;
    if (g.Zv(this.scene))
    {
      localObject = a.Fdw;
      localObject = this.Fhz;
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
        ae.d("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload id: %s, url: %s", new Object[] { a.aMP((String)localObject), localObject });
        a.t((Runnable)new a.i((String)localObject, System.currentTimeMillis()));
      }
      AppMethodBeat.o(124878);
      return;
    }
  }
  
  public final void fgc()
  {
    AppMethodBeat.i(124880);
    this.FnM = System.currentTimeMillis();
    AppMethodBeat.o(124880);
  }
  
  public final void fgd()
  {
    AppMethodBeat.i(124881);
    this.FnN = System.currentTimeMillis();
    ae.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onAfterOpenConnection id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.FnN - this.FnM) });
    AppMethodBeat.o(124881);
  }
  
  public final void fge()
  {
    AppMethodBeat.i(124882);
    this.FnO = System.currentTimeMillis();
    AppMethodBeat.o(124882);
  }
  
  public final void fgf()
  {
    AppMethodBeat.i(124883);
    this.FnP = System.currentTimeMillis();
    ae.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo getResponseCode id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.FnP - this.FnO) });
    AppMethodBeat.o(124883);
  }
  
  public final void fgg()
  {
    AppMethodBeat.i(124884);
    this.FnQ = System.currentTimeMillis();
    AppMethodBeat.o(124884);
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(124885);
    this.FnR = System.currentTimeMillis();
    ae.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo readStreamData id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.FnR - this.FnQ) });
    AppMethodBeat.o(124885);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(124886);
    this.FnS = System.currentTimeMillis();
    AppMethodBeat.o(124886);
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(124887);
    this.FnT = System.currentTimeMillis();
    ae.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo closeStream id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.FnT - this.FnS) });
    AppMethodBeat.o(124887);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(124888);
    ae.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onDisconnect id: %s", new Object[] { this.id });
    AppMethodBeat.o(124888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.k
 * JD-Core Version:    0.7.0.1
 */