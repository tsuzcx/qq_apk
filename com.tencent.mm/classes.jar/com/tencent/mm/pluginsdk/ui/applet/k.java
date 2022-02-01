package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.a;
import com.tencent.mm.pluginsdk.model.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListenerImpl;", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "scene", "", "(I)V", "afterCloseStream", "", "afterGetResponseCode", "afterOpenConnection", "afterReadStreamData", "beforeCloseStream", "beforeGetResponseCode", "beforeOpenConnection", "beforeReadStreamData", "canReport", "", "downloadEnd", "downloadStart", "forceNormal", "id", "", "requestImageType", "startDownload", "url", "urlKey", "onAfterCloseStream", "", "onAfterGetResponseCode", "onAfterOpenConnection", "connection", "Ljava/net/HttpURLConnection;", "onAfterReadStreamData", "onBeforeCloseStream", "onBeforeGetResponseCode", "onBeforeOpenConnection", "onBeforeReadStreamData", "onDisconnect", "onRequest", "imageType", "onResult", "success", "onResultError", "responseCode", "onResultSuccess", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onRetry", "onStart", "key", "requestUrl", "Companion", "plugin-biz_release"})
public final class k
  implements j
{
  public static final k.a KeM;
  private String JYs;
  private int KeA;
  private long KeC;
  private long KeD;
  private long KeE;
  private long KeF;
  private long KeG;
  private long KeH;
  private long KeI;
  private long KeJ;
  private long KeK;
  private long KeL;
  private boolean Kez;
  private long dUG;
  private boolean hkH;
  private final String id;
  private int scene;
  private String url;
  
  static
  {
    AppMethodBeat.i(124893);
    KeM = new k.a((byte)0);
    AppMethodBeat.o(124893);
  }
  
  public k(int paramInt)
  {
    AppMethodBeat.i(124892);
    this.scene = paramInt;
    g localg = g.Kev;
    this.hkH = g.aif(paramInt);
    this.id = String.valueOf(hashCode());
    AppMethodBeat.o(124892);
  }
  
  private final void bES()
  {
    AppMethodBeat.i(124891);
    Object localObject = g.Kev;
    if (g.aig(this.scene))
    {
      localObject = a.JUl;
      a.de(3, this.JYs);
    }
    AppMethodBeat.o(124891);
  }
  
  public final void aih(int paramInt)
  {
    AppMethodBeat.i(124890);
    Log.e("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultError id: %s, requestImageType: %d, responseCode: %d", new Object[] { this.id, Integer.valueOf(this.KeA), Integer.valueOf(paramInt) });
    this.KeL = System.currentTimeMillis();
    if (this.hkH)
    {
      f localf = f.Ket;
      f.bw(this.KeA, false);
      if (this.Kez)
      {
        localf = f.Ket;
        f.bx(this.KeA, false);
      }
    }
    bES();
    AppMethodBeat.o(124890);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(124889);
    p.h(paramb, "response");
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onResultSuccess id: %s, contentType: %s, cost: %d", new Object[] { this.id, paramb.contentType, Long.valueOf(l - this.dUG) });
    this.KeL = System.currentTimeMillis();
    Object localObject;
    if (this.hkH)
    {
      localObject = f.Ket;
      f.bw(this.KeA, true);
      localObject = f.Ket;
      int i = this.KeA;
      localObject = paramb.contentType;
      Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType requestImageType: %d, responseContentType: %s", new Object[] { Integer.valueOf(i), localObject });
      g localg;
      if (i == 1) {
        localg = g.Kev;
      }
      switch (g.beL((String)localObject))
      {
      default: 
        Log.v("MicroMsg.BizImageDownloadReporter", "alvinluo reportDownloadImageType responseContentType: %s", new Object[] { localObject });
        localg = g.Kev;
        switch (g.beL((String)localObject))
        {
        }
        break;
      }
    }
    for (;;)
    {
      localObject = f.Ket;
      f.bR(paramb.contentType, this.KeL - this.KeK);
      if ((this.Kez) && (paramb.data != null))
      {
        paramb = f.Ket;
        f.bx(this.KeA, true);
      }
      bES();
      AppMethodBeat.o(124889);
      return;
      h.CyF.n(1111L, 7L, 1L);
      break;
      h.CyF.n(1111L, 8L, 1L);
      break;
      h.CyF.n(1111L, 17L, 1L);
      continue;
      h.CyF.n(1111L, 19L, 1L);
      continue;
      h.CyF.n(1111L, 36L, 1L);
    }
  }
  
  public final void bz(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(124879);
    Log.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onRequest id: %s, imageType: %d, forceNormal: %b, url: %s", new Object[] { this.id, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), this.url });
    this.KeA = paramInt;
    this.Kez = paramBoolean;
    this.KeK = System.currentTimeMillis();
    if (this.hkH)
    {
      f localf = f.Ket;
      f.gph();
      localf = f.Ket;
      f.aid(this.KeA);
      if (this.Kez)
      {
        localf = f.Ket;
        f.aie(this.KeA);
      }
    }
    AppMethodBeat.o(124879);
  }
  
  public final void ey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124877);
    this.JYs = paramString1;
    this.url = paramString2;
    this.dUG = System.currentTimeMillis();
    paramString1 = g.Kev;
    if (g.aig(this.scene))
    {
      paramString1 = a.JUl;
      a.dd(3, this.JYs);
    }
    Log.i("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo BizImage download onStart id: %s", new Object[] { this.id });
    AppMethodBeat.o(124877);
  }
  
  public final void gpk()
  {
    AppMethodBeat.i(124878);
    Object localObject = g.Kev;
    if (g.aig(this.scene))
    {
      localObject = a.JUl;
      localObject = this.JYs;
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
        Log.d("MicroMsg.BizImageBlankReporter", "alvinluo retryDownload id: %s, url: %s", new Object[] { a.bdl((String)localObject), localObject });
        a.v((Runnable)new a.i((String)localObject, System.currentTimeMillis()));
      }
      AppMethodBeat.o(124878);
      return;
    }
  }
  
  public final void gpl()
  {
    AppMethodBeat.i(124880);
    this.KeC = System.currentTimeMillis();
    AppMethodBeat.o(124880);
  }
  
  public final void gpm()
  {
    AppMethodBeat.i(124881);
    this.KeD = System.currentTimeMillis();
    Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onAfterOpenConnection id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.KeD - this.KeC) });
    AppMethodBeat.o(124881);
  }
  
  public final void gpn()
  {
    AppMethodBeat.i(124882);
    this.KeE = System.currentTimeMillis();
    AppMethodBeat.o(124882);
  }
  
  public final void gpo()
  {
    AppMethodBeat.i(124883);
    this.KeF = System.currentTimeMillis();
    Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo getResponseCode id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.KeF - this.KeE) });
    AppMethodBeat.o(124883);
  }
  
  public final void gpp()
  {
    AppMethodBeat.i(124884);
    this.KeG = System.currentTimeMillis();
    AppMethodBeat.o(124884);
  }
  
  public final void gpq()
  {
    AppMethodBeat.i(124885);
    this.KeH = System.currentTimeMillis();
    Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo readStreamData id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.KeH - this.KeG) });
    AppMethodBeat.o(124885);
  }
  
  public final void gpr()
  {
    AppMethodBeat.i(124886);
    this.KeI = System.currentTimeMillis();
    AppMethodBeat.o(124886);
  }
  
  public final void gps()
  {
    AppMethodBeat.i(124887);
    this.KeJ = System.currentTimeMillis();
    Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo closeStream id: %s, cost: %d", new Object[] { this.id, Long.valueOf(this.KeJ - this.KeI) });
    AppMethodBeat.o(124887);
  }
  
  public final void gpt()
  {
    AppMethodBeat.i(124888);
    Log.v("MicroMsg.BizImageHttpUrlConnectionListenerImpl", "alvinluo onDisconnect id: %s", new Object[] { this.id });
    AppMethodBeat.o(124888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.k
 * JD-Core Version:    0.7.0.1
 */