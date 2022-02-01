package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.a;
import com.tencent.mm.pluginsdk.model.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListenerImpl;", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "scene", "", "(I)V", "afterCloseStream", "", "afterGetResponseCode", "afterOpenConnection", "afterReadStreamData", "beforeCloseStream", "beforeGetResponseCode", "beforeOpenConnection", "beforeReadStreamData", "canReport", "", "downloadEnd", "downloadStart", "forceNormal", "id", "", "requestImageType", "startDownload", "url", "urlKey", "onAfterCloseStream", "", "onAfterGetResponseCode", "onAfterOpenConnection", "connection", "Ljava/net/HttpURLConnection;", "onAfterReadStreamData", "onBeforeCloseStream", "onBeforeGetResponseCode", "onBeforeOpenConnection", "onBeforeReadStreamData", "onDisconnect", "onRequest", "imageType", "onResult", "success", "onResultError", "responseCode", "onResultSuccess", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onRetry", "onStart", "key", "requestUrl", "Companion", "plugin-biz_release"})
public final class k
  implements j
{
  public static final k.a Dqy;
  private String Dkb;
  private boolean Dql;
  private int Dqm;
  private long Dqo;
  private long Dqp;
  private long Dqq;
  private long Dqr;
  private long Dqs;
  private long Dqt;
  private long Dqu;
  private long Dqv;
  private long Dqw;
  private long Dqx;
  private long dpY;
  private boolean gbD;
  private final String id;
  private int scene;
  private String url;
  
  static
  {
    AppMethodBeat.i(124893);
    Dqy = new k.a((byte)0);
    AppMethodBeat.o(124893);
  }
  
  public k(int paramInt)
  {
    AppMethodBeat.i(124892);
    this.scene = paramInt;
    g localg = g.Dqh;
    this.gbD = g.WS(paramInt);
    this.id = String.valueOf(hashCode());
    AppMethodBeat.o(124892);
  }
  
  private final void bfr()
  {
    AppMethodBeat.i(124891);
    Object localObject = g.Dqh;
    if (g.WT(this.scene))
    {
      localObject = a.Dgo;
      a.cD(3, this.Dkb);
    }
    AppMethodBeat.o(124891);
  }
  
  public final void WU(int paramInt)
  {
    AppMethodBeat.i(124890);
    ac.e("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultError id: %s, requestImageType: %d, responseCode: %d", new Object[] { this.id, Integer.valueOf(this.Dqm), Integer.valueOf(paramInt) });
    this.Dqx = System.currentTimeMillis();
    if (this.gbD)
    {
      f localf = f.Dqf;
      f.aP(this.Dqm, false);
      if (this.Dql)
      {
        localf = f.Dqf;
        f.aQ(this.Dqm, false);
      }
    }
    bfr();
    AppMethodBeat.o(124890);
  }
  
  public final void aS(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(124879);
    ac.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onRequest id: %s, imageType: %d, forceNormal: %b, url: %s", new Object[] { this.id, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), this.url });
    this.Dqm = paramInt;
    this.Dql = paramBoolean;
    this.Dqw = System.currentTimeMillis();
    if (this.gbD)
    {
      f localf = f.Dqf;
      f.eNl();
      localf = f.Dqf;
      f.WQ(this.Dqm);
      if (this.Dql)
      {
        localf = f.Dqf;
        f.WR(this.Dqm);
      }
    }
    AppMethodBeat.o(124879);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(124889);
    d.g.b.k.h(paramb, "response");
    long l = System.currentTimeMillis();
    ac.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultSuccess id: %s, contentType: %s, cost: %d", new Object[] { this.id, paramb.contentType, Long.valueOf(l - this.dpY) });
    this.Dqx = System.currentTimeMillis();
    Object localObject;
    if (this.gbD)
    {
      localObject = f.Dqf;
      f.aP(this.Dqm, true);
      localObject = f.Dqf;
      int i = this.Dqm;
      localObject = paramb.contentType;
      ac.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType requestImageType: %d, responseContentType: %s", new Object[] { Integer.valueOf(i), localObject });
      g localg;
      if (i == 1) {
        localg = g.Dqh;
      }
      switch (g.aHk((String)localObject))
      {
      default: 
        ac.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType responseContentType: %s", new Object[] { localObject });
        localg = g.Dqh;
        switch (g.aHk((String)localObject))
        {
        }
        break;
      }
    }
    for (;;)
    {
      localObject = f.Dqf;
      f.bL(paramb.contentType, this.Dqx - this.Dqw);
      if ((this.Dql) && (paramb.data != null))
      {
        paramb = f.Dqf;
        f.aQ(this.Dqm, true);
      }
      bfr();
      AppMethodBeat.o(124889);
      return;
      h.wUl.n(1111L, 7L, 1L);
      break;
      h.wUl.n(1111L, 8L, 1L);
      break;
      h.wUl.n(1111L, 17L, 1L);
      continue;
      h.wUl.n(1111L, 19L, 1L);
      continue;
      h.wUl.n(1111L, 36L, 1L);
    }
  }
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124877);
    this.Dkb = paramString1;
    this.url = paramString2;
    this.dpY = System.currentTimeMillis();
    paramString1 = g.Dqh;
    if (g.WT(this.scene))
    {
      paramString1 = a.Dgo;
      a.cC(3, this.Dkb);
    }
    ac.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onStart id: %s", new Object[] { this.id });
    AppMethodBeat.o(124877);
  }
  
  public final void eNo()
  {
    AppMethodBeat.i(124878);
    Object localObject = g.Dqh;
    if (g.WT(this.scene))
    {
      localObject = a.Dgo;
      localObject = this.Dkb;
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
        ac.d("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload id: %s, url: %s", new Object[] { a.aFT((String)localObject), localObject });
        a.v((Runnable)new a.i((String)localObject, System.currentTimeMillis()));
      }
      AppMethodBeat.o(124878);
      return;
    }
  }
  
  public final void eNp()
  {
    AppMethodBeat.i(124880);
    this.Dqo = System.currentTimeMillis();
    AppMethodBeat.o(124880);
  }
  
  public final void eNq()
  {
    AppMethodBeat.i(124881);
    this.Dqp = System.currentTimeMillis();
    ac.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onAfterOpenConnection id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.Dqp - this.Dqo) });
    AppMethodBeat.o(124881);
  }
  
  public final void eNr()
  {
    AppMethodBeat.i(124882);
    this.Dqq = System.currentTimeMillis();
    AppMethodBeat.o(124882);
  }
  
  public final void eNs()
  {
    AppMethodBeat.i(124883);
    this.Dqr = System.currentTimeMillis();
    ac.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo getResponseCode id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.Dqr - this.Dqq) });
    AppMethodBeat.o(124883);
  }
  
  public final void eNt()
  {
    AppMethodBeat.i(124884);
    this.Dqs = System.currentTimeMillis();
    AppMethodBeat.o(124884);
  }
  
  public final void eNu()
  {
    AppMethodBeat.i(124885);
    this.Dqt = System.currentTimeMillis();
    ac.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo readStreamData id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.Dqt - this.Dqs) });
    AppMethodBeat.o(124885);
  }
  
  public final void eNv()
  {
    AppMethodBeat.i(124886);
    this.Dqu = System.currentTimeMillis();
    AppMethodBeat.o(124886);
  }
  
  public final void eNw()
  {
    AppMethodBeat.i(124887);
    this.Dqv = System.currentTimeMillis();
    ac.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo closeStream id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.Dqv - this.Dqu) });
    AppMethodBeat.o(124887);
  }
  
  public final void eNx()
  {
    AppMethodBeat.i(124888);
    ac.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onDisconnect id: %s", new Object[] { this.id });
    AppMethodBeat.o(124888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.k
 * JD-Core Version:    0.7.0.1
 */