package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.a;
import com.tencent.mm.pluginsdk.model.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListenerImpl;", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "scene", "", "(I)V", "afterCloseStream", "", "afterGetResponseCode", "afterOpenConnection", "afterReadStreamData", "beforeCloseStream", "beforeGetResponseCode", "beforeOpenConnection", "beforeReadStreamData", "canReport", "", "downloadEnd", "downloadStart", "forceNormal", "id", "", "requestImageType", "startDownload", "url", "urlKey", "onAfterCloseStream", "", "onAfterGetResponseCode", "onAfterOpenConnection", "connection", "Ljava/net/HttpURLConnection;", "onAfterReadStreamData", "onBeforeCloseStream", "onBeforeGetResponseCode", "onBeforeOpenConnection", "onBeforeReadStreamData", "onDisconnect", "onRequest", "imageType", "onResult", "success", "onResultError", "responseCode", "onResultSuccess", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onRetry", "onStart", "key", "requestUrl", "Companion", "plugin-biz_release"})
public final class k
  implements j
{
  public static final k.a BYh;
  private String BRL;
  private boolean BXU;
  private int BXV;
  private long BXX;
  private long BXY;
  private long BXZ;
  private long BYa;
  private long BYb;
  private long BYc;
  private long BYd;
  private long BYe;
  private long BYf;
  private long BYg;
  private long dsn;
  private boolean fWW;
  private final String id;
  private int scene;
  private String url;
  
  static
  {
    AppMethodBeat.i(124893);
    BYh = new k.a((byte)0);
    AppMethodBeat.o(124893);
  }
  
  public k(int paramInt)
  {
    AppMethodBeat.i(124892);
    this.scene = paramInt;
    g localg = g.BXQ;
    this.fWW = g.UI(paramInt);
    this.id = String.valueOf(hashCode());
    AppMethodBeat.o(124892);
  }
  
  private final void aYu()
  {
    AppMethodBeat.i(124891);
    Object localObject = g.BXQ;
    if (g.UJ(this.scene))
    {
      localObject = a.BOa;
      a.cA(3, this.BRL);
    }
    AppMethodBeat.o(124891);
  }
  
  public final void UK(int paramInt)
  {
    AppMethodBeat.i(124890);
    ad.e("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultError id: %s, requestImageType: %d, responseCode: %d", new Object[] { this.id, Integer.valueOf(this.BXV), Integer.valueOf(paramInt) });
    this.BYg = System.currentTimeMillis();
    if (this.fWW)
    {
      f localf = f.BXO;
      f.aL(this.BXV, false);
      if (this.BXU)
      {
        localf = f.BXO;
        f.aM(this.BXV, false);
      }
    }
    aYu();
    AppMethodBeat.o(124890);
  }
  
  public final void aO(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(124879);
    ad.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onRequest id: %s, imageType: %d, forceNormal: %b, url: %s", new Object[] { this.id, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), this.url });
    this.BXV = paramInt;
    this.BXU = paramBoolean;
    this.BYf = System.currentTimeMillis();
    if (this.fWW)
    {
      f localf = f.BXO;
      f.exR();
      localf = f.BXO;
      f.UG(this.BXV);
      if (this.BXU)
      {
        localf = f.BXO;
        f.UH(this.BXV);
      }
    }
    AppMethodBeat.o(124879);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(124889);
    d.g.b.k.h(paramb, "response");
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultSuccess id: %s, contentType: %s, cost: %d", new Object[] { this.id, paramb.bxn, Long.valueOf(l - this.dsn) });
    this.BYg = System.currentTimeMillis();
    Object localObject;
    if (this.fWW)
    {
      localObject = f.BXO;
      f.aL(this.BXV, true);
      localObject = f.BXO;
      int i = this.BXV;
      localObject = paramb.bxn;
      ad.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType requestImageType: %d, responseContentType: %s", new Object[] { Integer.valueOf(i), localObject });
      g localg;
      if (i == 1) {
        localg = g.BXQ;
      }
      switch (g.aBS((String)localObject))
      {
      default: 
        ad.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType responseContentType: %s", new Object[] { localObject });
        localg = g.BXQ;
        switch (g.aBS((String)localObject))
        {
        }
        break;
      }
    }
    for (;;)
    {
      localObject = f.BXO;
      f.bJ(paramb.bxn, this.BYg - this.BYf);
      if ((this.BXU) && (paramb.data != null))
      {
        paramb = f.BXO;
        f.aM(this.BXV, true);
      }
      aYu();
      AppMethodBeat.o(124889);
      return;
      h.vKh.m(1111L, 7L, 1L);
      break;
      h.vKh.m(1111L, 8L, 1L);
      break;
      h.vKh.m(1111L, 17L, 1L);
      continue;
      h.vKh.m(1111L, 19L, 1L);
      continue;
      h.vKh.m(1111L, 36L, 1L);
    }
  }
  
  public final void dJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124877);
    this.BRL = paramString1;
    this.url = paramString2;
    this.dsn = System.currentTimeMillis();
    paramString1 = g.BXQ;
    if (g.UJ(this.scene))
    {
      paramString1 = a.BOa;
      a.cz(3, this.BRL);
    }
    ad.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onStart id: %s", new Object[] { this.id });
    AppMethodBeat.o(124877);
  }
  
  public final void exU()
  {
    AppMethodBeat.i(124878);
    Object localObject = g.BXQ;
    if (g.UJ(this.scene))
    {
      localObject = a.BOa;
      localObject = this.BRL;
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
        ad.d("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload id: %s, url: %s", new Object[] { a.aAB((String)localObject), localObject });
        a.u((Runnable)new a.i((String)localObject, System.currentTimeMillis()));
      }
      AppMethodBeat.o(124878);
      return;
    }
  }
  
  public final void exV()
  {
    AppMethodBeat.i(124880);
    this.BXX = System.currentTimeMillis();
    AppMethodBeat.o(124880);
  }
  
  public final void exW()
  {
    AppMethodBeat.i(124881);
    this.BXY = System.currentTimeMillis();
    ad.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onAfterOpenConnection id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.BXY - this.BXX) });
    AppMethodBeat.o(124881);
  }
  
  public final void exX()
  {
    AppMethodBeat.i(124882);
    this.BXZ = System.currentTimeMillis();
    AppMethodBeat.o(124882);
  }
  
  public final void exY()
  {
    AppMethodBeat.i(124883);
    this.BYa = System.currentTimeMillis();
    ad.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo getResponseCode id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.BYa - this.BXZ) });
    AppMethodBeat.o(124883);
  }
  
  public final void exZ()
  {
    AppMethodBeat.i(124884);
    this.BYb = System.currentTimeMillis();
    AppMethodBeat.o(124884);
  }
  
  public final void eya()
  {
    AppMethodBeat.i(124885);
    this.BYc = System.currentTimeMillis();
    ad.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo readStreamData id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.BYc - this.BYb) });
    AppMethodBeat.o(124885);
  }
  
  public final void eyb()
  {
    AppMethodBeat.i(124886);
    this.BYd = System.currentTimeMillis();
    AppMethodBeat.o(124886);
  }
  
  public final void eyc()
  {
    AppMethodBeat.i(124887);
    this.BYe = System.currentTimeMillis();
    ad.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo closeStream id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.BYe - this.BYd) });
    AppMethodBeat.o(124887);
  }
  
  public final void eyd()
  {
    AppMethodBeat.i(124888);
    ad.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onDisconnect id: %s", new Object[] { this.id });
    AppMethodBeat.o(124888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.k
 * JD-Core Version:    0.7.0.1
 */