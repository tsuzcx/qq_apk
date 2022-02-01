package com.tencent.mm.plugin.scanner.scan_goods_new.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.plugin.scanner.scan_goods_new.a;
import com.tencent.mm.plugin.scanner.scan_goods_new.j;
import com.tencent.mm.plugin.scanner.scan_goods_new.j.a;
import com.tencent.mm.protocal.protobuf.esg;
import com.tencent.mm.protocal.protobuf.euf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageRetrievalTask;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/BaseAiScanImageTask;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageRetrievalRequest;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "session", "", "request", "callback", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageRetrievalTask$AiScanImageRetrievalCallback;", "(JLcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageRetrievalRequest;Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageRetrievalTask$AiScanImageRetrievalCallback;)V", "isCancelled", "", "requestTrackIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "source", "cancel", "", "doRetrieval", "fillBaseInfo", "productItem", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeItem;", "onRetrievalFailed", "errCode", "errMsg", "", "onRetrievalSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/ScanV2RetrievalLiteResponse;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "processCgiResult", "run", "AiScanImageRetrievalCallback", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends e<com.tencent.mm.plugin.scanner.scan_goods_new.c>
  implements com.tencent.mm.am.h
{
  public static final b.b OWU;
  private final ArrayList<Integer> ORF;
  private final com.tencent.mm.plugin.scanner.scan_goods_new.c OWV;
  private final a OWW;
  private final long hBk;
  private boolean isCancelled;
  private final int source;
  
  static
  {
    AppMethodBeat.i(313974);
    OWU = new b.b((byte)0);
    AppMethodBeat.o(313974);
  }
  
  public b(long paramLong, com.tencent.mm.plugin.scanner.scan_goods_new.c paramc, a parama)
  {
    AppMethodBeat.i(313924);
    this.hBk = paramLong;
    this.OWV = paramc;
    this.OWW = parama;
    this.ORF = new ArrayList();
    this.source = this.OWV.source;
    AppMethodBeat.o(313924);
  }
  
  private final void N(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(313931);
    com.tencent.threadpool.h.ahAA.bk(new b..ExternalSyntheticLambda0(paramInt1, this, paramInt2, paramString));
    this.OWW.c((c)this);
    AppMethodBeat.o(313931);
  }
  
  private static final void a(int paramInt1, b paramb, int paramInt2, String paramString)
  {
    AppMethodBeat.i(313953);
    kotlin.g.b.s.u(paramb, "this$0");
    com.tencent.mm.plugin.scanner.scan_goods_new.i locali = new com.tencent.mm.plugin.scanner.scan_goods_new.i(paramInt1, paramb.hBk, paramb.OWV.gRK());
    locali.OWg = paramb.OWV.OVE.OWg;
    Iterator localIterator = ((Iterable)paramb.ORF).iterator();
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      ArrayList localArrayList = locali.OWf;
      com.tencent.mm.plugin.scanner.scan_goods_new.h localh = new com.tencent.mm.plugin.scanner.scan_goods_new.h();
      paramb.a(paramb.OWV, localh);
      localh.trackId = i;
      localh.state = 5;
      ah localah = ah.aiuX;
      localArrayList.add(localh);
    }
    Log.e("MicroMsg.AiScanImageRetrievalTask", "alvinluo onRetrievalFailed source: %d, requestTrackIdList: %s", new Object[] { Integer.valueOf(paramInt1), kotlin.a.p.a((Iterable)paramb.ORF, (CharSequence)",", null, null, 0, null, null, 62) });
    paramb.OWW.b(locali, paramInt1, paramb.hBk, paramInt2, paramString);
    AppMethodBeat.o(313953);
  }
  
  private static final void a(b paramb, euf parameuf, int paramInt)
  {
    AppMethodBeat.i(313966);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(parameuf, "$response");
    com.tencent.mm.plugin.scanner.scan_goods_new.i locali = paramb.OWV.OVN;
    kotlin.g.b.s.u(parameuf, "response");
    parameuf = parameuf.ZiE;
    kotlin.g.b.s.s(parameuf, "response.results");
    Iterator localIterator = ((Iterable)parameuf).iterator();
    int j = 0;
    Object localObject;
    if (localIterator.hasNext())
    {
      parameuf = localIterator.next();
      if (j < 0) {
        kotlin.a.p.kkW();
      }
      esg localesg = (esg)parameuf;
      com.tencent.mm.plugin.scanner.scan_goods_new.h localh = (com.tencent.mm.plugin.scanner.scan_goods_new.h)kotlin.a.p.ae((List)locali.OWf, j);
      int i;
      if (localh != null)
      {
        localObject = localesg.title;
        parameuf = (euf)localObject;
        if (localObject == null) {
          parameuf = "";
        }
        localh.setTitle(parameuf);
        localObject = localesg.IdD;
        parameuf = (euf)localObject;
        if (localObject == null) {
          parameuf = "";
        }
        localh.setImageUrl(parameuf);
        parameuf = j.a.OWl;
        switch (localesg.status)
        {
        default: 
          i = 0;
        }
      }
      for (;;)
      {
        localh.status = i;
        localh.OWd = localesg.YPt;
        Log.i("MicroMsg.ScanProductRecognizeResult", "updateFromRetrievalResponse scanImageType: " + localh.OVD + ", " + localh);
        j += 1;
        break;
        i = 1;
        continue;
        i = 2;
        continue;
        i = 3;
        continue;
        i = 4;
      }
    }
    parameuf = ((Iterable)locali.OWf).iterator();
    while (parameuf.hasNext())
    {
      localObject = (com.tencent.mm.plugin.scanner.scan_goods_new.h)parameuf.next();
      paramb.a(paramb.OWV, (com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject);
      ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject).state = 4;
    }
    Log.i("MicroMsg.AiScanImageRetrievalTask", "alvinluo onRetrievalSuccess source: %d, isCancelled: %b, requestTrackIdList: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramb.isCancelled), kotlin.a.p.a((Iterable)paramb.ORF, (CharSequence)",", null, null, 0, null, null, 62) });
    if (!paramb.isCancelled) {
      paramb.OWW.f(locali);
    }
    AppMethodBeat.o(313966);
  }
  
  private void a(com.tencent.mm.plugin.scanner.scan_goods_new.c paramc, com.tencent.mm.plugin.scanner.scan_goods_new.h paramh)
  {
    AppMethodBeat.i(313943);
    kotlin.g.b.s.u(paramc, "request");
    kotlin.g.b.s.u(paramh, "productItem");
    super.a((a)paramc, paramh);
    paramh.OVE = paramc.OVE;
    Log.v("MicroMsg.AiScanImageRetrievalTask", "fillBaseInfo %s", new Object[] { paramh.OVE });
    AppMethodBeat.o(313943);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(314010);
    Log.d("MicroMsg.AiScanImageRetrievalTask", kotlin.g.b.s.X("cancelImageRetrievalTask isFinished: ", Boolean.valueOf(gSg())));
    this.isCancelled = true;
    if (!isFinished()) {
      this.OWW.d((c)this);
    }
    com.tencent.mm.kernel.h.aZW().b(5107, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(this.OWV.ORg);
    AppMethodBeat.o(314010);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(314021);
    Object localObject1;
    if (paramp == null)
    {
      localObject1 = null;
      localObject2 = this.OWV.ORg;
      if (localObject2 != null) {
        break label61;
      }
    }
    label61:
    for (Object localObject2 = null;; localObject2 = Integer.valueOf(((com.tencent.mm.am.p)localObject2).hashCode()))
    {
      if (kotlin.g.b.s.p(localObject1, localObject2)) {
        break label74;
      }
      AppMethodBeat.o(314021);
      return;
      localObject1 = Integer.valueOf(paramp.hashCode());
      break;
    }
    label74:
    Cd(true);
    localObject2 = new StringBuilder("retrieval onSceneEnd errType: ").append(paramInt1).append(", errCode: ").append(paramInt2).append(", errMsg: ").append(paramString).append(", type: ");
    int i;
    if (paramp == null)
    {
      localObject1 = null;
      Log.i("MicroMsg.AiScanImageRetrievalTask", localObject1);
      com.tencent.mm.kernel.h.aZW().b(5107, (com.tencent.mm.am.h)this);
      if ((paramp == null) || (paramp.getType() != 5107)) {
        break label226;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramp == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneBizAiScanImageRetrievalV2");
            AppMethodBeat.o(314021);
            throw paramString;
            localObject1 = Integer.valueOf(paramp.getType());
            break;
            label226:
            i = 0;
            continue;
          }
          paramp = (n)paramp;
          if (c.c.b(paramp.oDw.otC) != null)
          {
            paramp = c.c.b(paramp.oDw.otC);
            if (paramp == null)
            {
              paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ScanV2RetrievalLiteResponse");
              AppMethodBeat.o(314021);
              throw paramString;
            }
          }
          for (paramp = (euf)paramp; paramp != null; paramp = null)
          {
            paramInt1 = this.source;
            com.tencent.threadpool.h.ahAA.bk(new b..ExternalSyntheticLambda1(this, paramp, paramInt1));
            this.OWW.c((c)this);
            AppMethodBeat.o(314021);
            return;
          }
          Log.w("MicroMsg.AiScanImageRetrievalTask", "alvinluo AiScanImage onSceneEnd success resp null");
        }
        N(this.source, paramInt2, paramString);
      }
    }
    AppMethodBeat.o(314021);
  }
  
  public final void run()
  {
    AppMethodBeat.i(314004);
    Log.d("MicroMsg.AiScanImageRetrievalTask", "runImageRetrievalTask");
    this.OWW.b((c)this);
    Cd(false);
    com.tencent.mm.kernel.h.aZW().a(5107, (com.tencent.mm.am.h)this);
    long l = this.hBk;
    com.tencent.mm.plugin.scanner.scan_goods_new.c localc = this.OWV;
    int i = localc.source;
    Log.i("MicroMsg.AiScanImageRetrievalTask", "doRetrieval session: %d, source: %d, reqKey size: %s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(localc.OVN.OWf.size()) });
    switch (i)
    {
    default: 
      N(i, -1, kotlin.g.b.s.X("invalid source: ", Integer.valueOf(i)));
      AppMethodBeat.o(314004);
      return;
    }
    Object localObject = new ArrayList();
    Iterator localIterator = ((Iterable)localc.OVN.OWf).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.scanner.scan_goods_new.h localh = (com.tencent.mm.plugin.scanner.scan_goods_new.h)localIterator.next();
      localh.state = 2;
      this.ORF.add(Integer.valueOf(localh.trackId));
      ((ArrayList)localObject).add(localh.hAT);
    }
    localObject = new n((List)localObject, false);
    localc.ORg = ((com.tencent.mm.am.p)localObject);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
    this.OWW.a(localc);
    AppMethodBeat.o(314004);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageRetrievalTask$AiScanImageRetrievalCallback;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageTask$TaskCallback;", "onRetrievalFailed", "", "result", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeResult;", "source", "", "session", "", "errCode", "errMsg", "", "onRetrievalStart", "request", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageRetrievalRequest;", "onRetrievalSuccess", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
    extends c.b
  {
    public abstract void a(com.tencent.mm.plugin.scanner.scan_goods_new.c paramc);
    
    public abstract void b(com.tencent.mm.plugin.scanner.scan_goods_new.i parami, int paramInt1, long paramLong, int paramInt2, String paramString);
    
    public abstract void f(com.tencent.mm.plugin.scanner.scan_goods_new.i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.b.b
 * JD-Core Version:    0.7.0.1
 */