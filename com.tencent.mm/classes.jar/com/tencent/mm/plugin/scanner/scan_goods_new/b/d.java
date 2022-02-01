package com.tencent.mm.plugin.scanner.scan_goods_new.b;

import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanProductInfo;
import com.tencent.mm.plugin.scanner.model.l;
import com.tencent.mm.plugin.scanner.scan_goods_new.a;
import com.tencent.mm.plugin.scanner.scan_goods_new.j;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.eui;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageUploadTask;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/BaseAiScanImageTask;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageUploadRequest;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "session", "", "request", "callback", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageUploadTask$AiScanImageUploadCallback;", "(JLcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageUploadRequest;Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageUploadTask$AiScanImageUploadCallback;)V", "isCancelled", "", "cancel", "", "doUploadImage", "fillBaseInfo", "productItem", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeItem;", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onUploadFailed", "source", "requestTrackIdList", "", "onUploadSuccessWrapper", "response", "Lcom/tencent/mm/protocal/protobuf/ScanV2UploadResponse;", "processCgiResult", "run", "uploadImage", "mode", "scanProductInfo", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;", "imageData", "", "width", "height", "adInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "jsApiInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "AiScanImageUploadCallback", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends e<com.tencent.mm.plugin.scanner.scan_goods_new.e>
  implements com.tencent.mm.am.h
{
  public static final d.b OWZ;
  private final com.tencent.mm.plugin.scanner.scan_goods_new.e OWN;
  private final a OXa;
  private final long hBk;
  private boolean isCancelled;
  
  static
  {
    AppMethodBeat.i(313965);
    OWZ = new d.b((byte)0);
    AppMethodBeat.o(313965);
  }
  
  public d(long paramLong, com.tencent.mm.plugin.scanner.scan_goods_new.e parame, a parama)
  {
    AppMethodBeat.i(313911);
    this.hBk = paramLong;
    this.OWN = parame;
    this.OXa = parama;
    AppMethodBeat.o(313911);
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, List<Integer> paramList)
  {
    AppMethodBeat.i(313920);
    com.tencent.threadpool.h.ahAA.bk(new d..ExternalSyntheticLambda1(paramInt1, this, paramList, paramInt2, paramInt3, paramString));
    this.OXa.c((c)this);
    AppMethodBeat.o(313920);
  }
  
  private static final void a(int paramInt, d paramd, eui parameui, List paramList, String paramString)
  {
    AppMethodBeat.i(313956);
    kotlin.g.b.s.u(paramd, "this$0");
    kotlin.g.b.s.u(parameui, "$response");
    kotlin.g.b.s.u(paramList, "$requestTrackIdList");
    com.tencent.mm.plugin.scanner.scan_goods_new.i locali = new com.tencent.mm.plugin.scanner.scan_goods_new.i(paramInt, paramd.hBk, paramd.OWN.OVD);
    kotlin.g.b.s.u(parameui, "response");
    locali.OWf.clear();
    parameui = parameui.abxk;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (parameui != null)
    {
      localObject2 = ((Iterable)parameui).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        parameui = (nm)((Iterator)localObject2).next();
        if (parameui != null)
        {
          parameui = parameui.YPw;
          if (parameui != null)
          {
            localObject3 = ((Iterable)parameui).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              nl localnl = (nl)((Iterator)localObject3).next();
              if (localnl != null)
              {
                ArrayList localArrayList = locali.OWf;
                com.tencent.mm.plugin.scanner.scan_goods_new.h localh = new com.tencent.mm.plugin.scanner.scan_goods_new.h();
                localh.OVD = locali.OVD;
                localObject1 = localnl.hMy;
                parameui = (eui)localObject1;
                if (localObject1 == null) {
                  parameui = "";
                }
                localh.setReqKey(parameui);
                localh.trackId = localnl.YPp;
                parameui = localnl.YPq;
                if (parameui != null) {
                  localh.OWc = new RectF(parameui.relative_minx, parameui.relative_miny, parameui.relative_maxx, parameui.relative_maxy);
                }
                Log.i("MicroMsg.ScanProductRecognizeResult", "convertFromUploadResponse reqKey: %s, trackId: %s, scanImageType: %s, goodsRect: %s", new Object[] { localh.hAT, Integer.valueOf(localh.trackId), Integer.valueOf(localh.OVD), localh.OWc });
                parameui = ah.aiuX;
                localArrayList.add(localh);
              }
            }
          }
        }
      }
    }
    locali.OWg = paramd.OWN.OVE.OWg;
    int i;
    if (!((Collection)locali.OWf).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      parameui = ((Iterable)locali.OWf).iterator();
      for (;;)
      {
        if (parameui.hasNext())
        {
          paramString = (com.tencent.mm.plugin.scanner.scan_goods_new.h)parameui.next();
          paramd.a(paramd.OWN, paramString);
          paramString.state = 2;
          continue;
          i = 0;
          break;
        }
      }
      Log.i("MicroMsg.AiScanImageUploadTask", "alvinluo onUploadSuccess source: %d, scanImageType: %s, requestTrackIdList: %s, isCancelled: %b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramd.OWN.OVD), kotlin.a.p.a((Iterable)paramList, (CharSequence)",", null, null, 0, null, null, 62), Boolean.valueOf(paramd.isCancelled) });
      if (paramd.isCancelled) {
        break label673;
      }
      paramd.OXa.e(locali);
      AppMethodBeat.o(313956);
      return;
    }
    parameui = ((Iterable)paramList).iterator();
    while (parameui.hasNext())
    {
      i = ((Number)parameui.next()).intValue();
      localObject1 = locali.OWf;
      localObject2 = new com.tencent.mm.plugin.scanner.scan_goods_new.h();
      paramd.a(paramd.OWN, (com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject2);
      ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject2).trackId = i;
      ((com.tencent.mm.plugin.scanner.scan_goods_new.h)localObject2).state = 3;
      localObject3 = ah.aiuX;
      ((ArrayList)localObject1).add(localObject2);
    }
    Log.e("MicroMsg.AiScanImageUploadTask", "alvinluo onUploadSuccessWrapper failed because of no req key, source: %d, scanImageType: %s, requestTrackIdList: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramd.OWN.OVD), kotlin.a.p.a((Iterable)paramList, (CharSequence)",", null, null, 0, null, null, 62) });
    if (!paramd.isCancelled) {
      paramd.OXa.a(locali, paramInt, paramd.hBk, 4, -1, paramString);
    }
    label673:
    AppMethodBeat.o(313956);
  }
  
  private static final void a(int paramInt1, d paramd, List paramList, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(313940);
    kotlin.g.b.s.u(paramd, "this$0");
    kotlin.g.b.s.u(paramList, "$requestTrackIdList");
    com.tencent.mm.plugin.scanner.scan_goods_new.i locali = new com.tencent.mm.plugin.scanner.scan_goods_new.i(paramInt1, paramd.hBk, paramd.OWN.OVD);
    locali.OWg = paramd.OWN.OVE.OWg;
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      ArrayList localArrayList = locali.OWf;
      com.tencent.mm.plugin.scanner.scan_goods_new.h localh = new com.tencent.mm.plugin.scanner.scan_goods_new.h();
      paramd.a(paramd.OWN, localh);
      localh.trackId = i;
      localh.state = 3;
      ah localah = ah.aiuX;
      localArrayList.add(localh);
    }
    Log.e("MicroMsg.AiScanImageUploadTask", "alvinluo onUploadFailed source: %d, scanImageType: %s, requestTrackIdList: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramd.OWN.OVD), kotlin.a.p.a((Iterable)paramList, (CharSequence)",", null, null, 0, null, null, 62) });
    paramd.OXa.a(locali, paramInt1, paramd.hBk, paramInt2, paramInt3, paramString);
    AppMethodBeat.o(313940);
  }
  
  private void a(com.tencent.mm.plugin.scanner.scan_goods_new.e parame, com.tencent.mm.plugin.scanner.scan_goods_new.h paramh)
  {
    AppMethodBeat.i(313928);
    kotlin.g.b.s.u(parame, "request");
    kotlin.g.b.s.u(paramh, "productItem");
    super.a((a)parame, paramh);
    paramh.OVE = parame.OVE;
    Log.v("MicroMsg.AiScanImageUploadTask", "fillBaseInfo %s", new Object[] { paramh.OVE });
    AppMethodBeat.o(313928);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(314006);
    Log.d("MicroMsg.AiScanImageUploadTask", kotlin.g.b.s.X("cancelImageUploadTask isFinished: ", Boolean.valueOf(gSg())));
    this.isCancelled = true;
    if (!isFinished()) {
      this.OXa.d((c)this);
    }
    com.tencent.mm.kernel.h.aZW().b(5105, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(this.OWN.ORg);
    AppMethodBeat.o(314006);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(314015);
    if (paramp == null)
    {
      localObject1 = null;
      localObject2 = this.OWN.ORg;
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
      AppMethodBeat.o(314015);
      return;
      localObject1 = Integer.valueOf(paramp.hashCode());
      break;
    }
    label74:
    localObject2 = new StringBuilder("uploadImage onSceneEnd errType: ").append(paramInt1).append(", errCode: ").append(paramInt2).append(", errMsg: ").append(paramString).append(", type: ");
    int i;
    if (paramp == null)
    {
      localObject1 = null;
      Log.i("MicroMsg.AiScanImageUploadTask", localObject1);
      com.tencent.mm.kernel.h.aZW().b(5105, (com.tencent.mm.am.h)this);
      if ((paramp == null) || (paramp.getType() != 5105)) {
        break label271;
      }
      i = 1;
      label172:
      if (i == 0) {
        break label414;
      }
      Cd(true);
      if (!(paramp instanceof l)) {
        break label277;
      }
      localObject1 = (l)paramp;
      label197:
      if (localObject1 != null) {
        break label283;
      }
    }
    label271:
    label277:
    label283:
    for (Object localObject1 = null;; localObject1 = (List)((l)localObject1).ORF)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (List)new ArrayList();
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label398;
      }
      if (paramp != null) {
        break label296;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneAiScanImageV2");
      AppMethodBeat.o(314015);
      throw paramString;
      localObject1 = Integer.valueOf(paramp.getType());
      break;
      i = 0;
      break label172;
      localObject1 = null;
      break label197;
    }
    label296:
    localObject1 = ((l)paramp).gQT();
    if (localObject1 != null)
    {
      Log.d("MicroMsg.AiScanImageUploadTask", "alvinluo AiScanImage onSceneEnd sessionId: %s", new Object[] { Long.valueOf(((l)paramp).hBk) });
      paramInt1 = this.OWN.source;
      com.tencent.threadpool.h.ahAA.bk(new d..ExternalSyntheticLambda0(paramInt1, this, (eui)localObject1, (List)localObject2, paramString));
      this.OXa.c((c)this);
      AppMethodBeat.o(314015);
      return;
    }
    Log.w("MicroMsg.AiScanImageUploadTask", "alvinluo AiScanImage onSceneEnd success resp null");
    label398:
    a(this.OWN.source, paramInt1, paramInt2, paramString, (List)localObject2);
    label414:
    AppMethodBeat.o(314015);
  }
  
  public final void run()
  {
    AppMethodBeat.i(313996);
    Log.d("MicroMsg.AiScanImageUploadTask", "runImageUploadTask");
    this.OXa.b((c)this);
    Cd(false);
    com.tencent.mm.kernel.h.aZW().a(5105, (com.tencent.mm.am.h)this);
    long l = this.hBk;
    Object localObject = this.OWN;
    int i = ((a)localObject).source;
    Log.i("MicroMsg.AiScanImageUploadTask", "doUploadImage session: %d, source: %d, scanImageType: %s, imageData: %s, %s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(((com.tencent.mm.plugin.scanner.scan_goods_new.e)localObject).OVD), Integer.valueOf(((com.tencent.mm.plugin.scanner.scan_goods_new.e)localObject).OVS.length), ((com.tencent.mm.plugin.scanner.scan_goods_new.e)localObject).OVS });
    switch (i)
    {
    default: 
      a(i, 3, -1, kotlin.g.b.s.X("source invalid: ", Integer.valueOf(i)), (List)kotlin.a.p.al(new Integer[] { Integer.valueOf(((com.tencent.mm.plugin.scanner.scan_goods_new.e)localObject).OVE.OWh.getId()) }));
      AppMethodBeat.o(313996);
      return;
    }
    i = ((a)localObject).mode;
    j localj = ((com.tencent.mm.plugin.scanner.scan_goods_new.e)localObject).OVE;
    byte[] arrayOfByte = ((com.tencent.mm.plugin.scanner.scan_goods_new.e)localObject).OVS;
    int j = ((com.tencent.mm.plugin.scanner.scan_goods_new.e)localObject).width;
    int k = ((com.tencent.mm.plugin.scanner.scan_goods_new.e)localObject).height;
    Log.i("MicroMsg.AiScanImageUploadTask", "alvinluo uploadImage imageData: %d, imageEncodeType: %s", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(this.OWN.ORl) });
    localObject = new l(arrayOfByte, j, k, i, this.OWN.OVD, l, localj.OWh);
    this.OWN.ORg = ((com.tencent.mm.am.p)localObject);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
    this.OXa.b(this.OWN);
    AppMethodBeat.o(313996);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageUploadTask$AiScanImageUploadCallback;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageTask$TaskCallback;", "onUploadFailed", "", "result", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeResult;", "source", "", "session", "", "errType", "errCode", "errMsg", "", "onUploadStart", "request", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageUploadRequest;", "onUploadSuccess", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
    extends c.b
  {
    public abstract void a(com.tencent.mm.plugin.scanner.scan_goods_new.i parami, int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString);
    
    public abstract void b(com.tencent.mm.plugin.scanner.scan_goods_new.e parame);
    
    public abstract void e(com.tencent.mm.plugin.scanner.scan_goods_new.i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.b.d
 * JD-Core Version:    0.7.0.1
 */