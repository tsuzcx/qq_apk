package com.tencent.mm.plugin.scanner.scan_goods_new;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanProductInfo;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.plugin.scanner.scan_goods_new.b.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageGetProductManager;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageGetProductTask$AiScanImageGetProductCallback;", "getProductCallback", "(Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageGetProductTask$AiScanImageGetProductCallback;)V", "getProductWaitingTaskList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageGetProductTask;", "Lkotlin/collections/ArrayList;", "isCancelled", "", "lastRunTimestamp", "", "runTaskMinDurationInMs", "", "runningTaskList", "runningTaskMaxLimit", "cancel", "", "doNextTask", "isRunningQueueFull", "onAddScanProductResultForFullImage", "scanProductResult", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductResult;", "addResultCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "onRetrievalFailed", "result", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeResult;", "source", "session", "errCode", "errMsg", "", "onRetrievalStart", "request", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageRetrievalRequest;", "onRetrievalSuccess", "onTaskAdd", "task", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageTask;", "onTaskCancel", "onTaskFinish", "onTaskStart", "onUploadFailed", "errType", "onUploadStart", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageUploadRequest;", "onUploadSuccess", "requestGetProduct", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a.a
{
  public static final b.a OVF;
  private final a.a OVG;
  private int OVH;
  private int OVI;
  private ArrayList<com.tencent.mm.plugin.scanner.scan_goods_new.b.a> OVJ;
  private ArrayList<com.tencent.mm.plugin.scanner.scan_goods_new.b.a> OVK;
  private long OVL;
  private boolean isCancelled;
  
  static
  {
    AppMethodBeat.i(313939);
    OVF = new b.a((byte)0);
    AppMethodBeat.o(313939);
  }
  
  public b(a.a parama)
  {
    AppMethodBeat.i(313856);
    this.OVG = parama;
    this.OVH = 2;
    this.OVI = 1000;
    this.OVJ = new ArrayList();
    this.OVK = new ArrayList();
    this.OVL = -1L;
    this.OVI = ac.gRf();
    Log.i("MicroMsg.AiScanImageGetProductManager", s.X("runTaskMinDurationInMs ", Integer.valueOf(this.OVI)));
    AppMethodBeat.o(313856);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(313876);
    s.u(paramb, "this$0");
    Iterator localIterator = ((Iterable)paramb.OVK).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.scanner.scan_goods_new.b.a)localIterator.next()).cancel();
    }
    paramb.OVK.clear();
    localIterator = ((Iterable)paramb.OVJ).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.scanner.scan_goods_new.b.a)localIterator.next()).cancel();
    }
    paramb.OVJ.clear();
    AppMethodBeat.o(313876);
  }
  
  private static final void a(b paramb, com.tencent.mm.plugin.scanner.scan_goods_new.b.c paramc)
  {
    AppMethodBeat.i(313926);
    s.u(paramb, "this$0");
    s.u(paramc, "$task");
    if (paramb.isCancelled)
    {
      Log.i("MicroMsg.AiScanImageGetProductManager", "onTaskFinish isCancelled and ignore");
      AppMethodBeat.o(313926);
      return;
    }
    paramb.OVG.c(paramc);
    AppMethodBeat.o(313926);
  }
  
  private static final void a(b paramb, i parami)
  {
    AppMethodBeat.i(313899);
    s.u(paramb, "this$0");
    s.u(parami, "$result");
    if (paramb.isCancelled)
    {
      Log.i("MicroMsg.AiScanImageGetProductManager", "onUploadSuccess isCancelled and ignore");
      AppMethodBeat.o(313899);
      return;
    }
    paramb.OVG.e(parami);
    AppMethodBeat.o(313899);
  }
  
  private static final void a(b paramb, i parami, int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(313905);
    s.u(paramb, "this$0");
    s.u(parami, "$result");
    if (paramb.isCancelled)
    {
      Log.i("MicroMsg.AiScanImageGetProductManager", "onUploadFailed isCancelled and ignore");
      AppMethodBeat.o(313905);
      return;
    }
    paramb.OVG.a(parami, paramInt1, paramLong, paramInt2, paramInt3, paramString);
    AppMethodBeat.o(313905);
  }
  
  private static final void a(b paramb, i parami, int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    AppMethodBeat.i(313919);
    s.u(paramb, "this$0");
    s.u(parami, "$result");
    if (paramb.isCancelled)
    {
      Log.i("MicroMsg.AiScanImageGetProductManager", "onRetrievalFailed isCancelled and ignore");
      AppMethodBeat.o(313919);
      return;
    }
    paramb.OVG.b(parami, paramInt1, paramLong, paramInt2, paramString);
    AppMethodBeat.o(313919);
  }
  
  private static final void a(b paramb, k paramk, kotlin.g.a.b paramb1)
  {
    AppMethodBeat.i(313892);
    s.u(paramb, "this$0");
    s.u(paramb1, "$addResultCallback");
    if (paramb.isCancelled)
    {
      Log.i("MicroMsg.AiScanImageGetProductManager", "onAddScanProductResultForFullImage isCancelled and ignore");
      AppMethodBeat.o(313892);
      return;
    }
    paramb.OVG.a(paramk, paramb1);
    AppMethodBeat.o(313892);
  }
  
  private static final void a(e parame, b paramb)
  {
    AppMethodBeat.i(313871);
    s.u(parame, "$request");
    s.u(paramb, "this$0");
    Log.i("MicroMsg.AiScanImageGetProductManager", "alvinluo requestGetProduct trackId: %s, session: %s", new Object[] { Integer.valueOf(parame.OVE.OWh.getId()), Long.valueOf(parame.hBk) });
    ArrayList localArrayList = paramb.OVJ;
    parame = new com.tencent.mm.plugin.scanner.scan_goods_new.b.a(parame, (a.a)paramb);
    paramb.a((com.tencent.mm.plugin.scanner.scan_goods_new.b.c)parame);
    ah localah = ah.aiuX;
    localArrayList.add(parame);
    paramb.gRL();
    AppMethodBeat.o(313871);
  }
  
  private static final void b(b paramb)
  {
    AppMethodBeat.i(313882);
    com.tencent.mm.plugin.scanner.scan_goods_new.b.a locala = (com.tencent.mm.plugin.scanner.scan_goods_new.b.a)p.oH((List)paramb.OVJ);
    if (locala != null)
    {
      Log.i("MicroMsg.AiScanImageGetProductManager", "doRunNextTask task: %s, trackId: %s, session: %s", new Object[] { Integer.valueOf(locala.hashCode()), Integer.valueOf(locala.OWN.OVE.OWh.getId()), Long.valueOf(locala.OWN.hBk) });
      paramb.OVK.add(locala);
      paramb.OVL = System.currentTimeMillis();
      locala.run();
    }
    AppMethodBeat.o(313882);
  }
  
  private static final void b(b paramb, com.tencent.mm.plugin.scanner.scan_goods_new.b.c paramc)
  {
    AppMethodBeat.i(313932);
    s.u(paramb, "this$0");
    s.u(paramc, "$task");
    Collection localCollection = (Collection)paramb.OVK;
    if (localCollection == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
      AppMethodBeat.o(313932);
      throw paramb;
    }
    an.hA(localCollection).remove(paramc);
    paramb.gRL();
    AppMethodBeat.o(313932);
  }
  
  private static final void b(b paramb, i parami)
  {
    AppMethodBeat.i(313910);
    s.u(paramb, "this$0");
    s.u(parami, "$result");
    if (paramb.isCancelled)
    {
      Log.i("MicroMsg.AiScanImageGetProductManager", "onRetrievalSuccess isCancelled and ignore");
      AppMethodBeat.o(313910);
      return;
    }
    paramb.OVG.f(parami);
    AppMethodBeat.o(313910);
  }
  
  private static final void c(b paramb)
  {
    AppMethodBeat.i(313886);
    s.u(paramb, "this$0");
    b(paramb);
    AppMethodBeat.o(313886);
  }
  
  private final void gRL()
  {
    AppMethodBeat.i(313864);
    int i;
    if (this.OVK.size() >= this.OVH) {
      i = 1;
    }
    while (i == 0)
    {
      long l = System.currentTimeMillis();
      if ((this.OVL < 0L) || (l - this.OVL >= this.OVI))
      {
        Log.v("MicroMsg.AiScanImageGetProductManager", "doNextTask direct run");
        b(this);
        AppMethodBeat.o(313864);
        return;
        i = 0;
      }
      else
      {
        if (!((Collection)this.OVJ).isEmpty()) {
          i = 1;
        }
        while (i != 0)
        {
          l = this.OVL + this.OVI - l;
          Log.v("MicroMsg.AiScanImageGetProductManager", "doNextTask run delay: " + l + ", waiting size: %s", new Object[] { Integer.valueOf(this.OVJ.size()) });
          b..ExternalSyntheticLambda1 localExternalSyntheticLambda1 = new b..ExternalSyntheticLambda1(this);
          s.u(localExternalSyntheticLambda1, "task");
          if (l > 0L)
          {
            h.ahAA.a(localExternalSyntheticLambda1, l, "AiScanImageGetProductManager");
            AppMethodBeat.o(313864);
            return;
            i = 0;
          }
          else
          {
            h.ahAA.g(localExternalSyntheticLambda1, "AiScanImageGetProductManager");
            AppMethodBeat.o(313864);
            return;
          }
        }
        Log.v("MicroMsg.AiScanImageGetProductManager", "doNextTask no waiting task");
        AppMethodBeat.o(313864);
        return;
      }
    }
    Log.w("MicroMsg.AiScanImageGetProductManager", "doNextTask running queue full and skip");
    AppMethodBeat.o(313864);
  }
  
  public final void a(com.tencent.mm.plugin.scanner.scan_goods_new.b.c paramc)
  {
    AppMethodBeat.i(314052);
    s.u(paramc, "task");
    if (this.isCancelled)
    {
      Log.i("MicroMsg.AiScanImageGetProductManager", "onTaskAdd isCancelled and ignore");
      AppMethodBeat.o(314052);
      return;
    }
    this.OVG.a(paramc);
    AppMethodBeat.o(314052);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(314043);
    s.u(paramc, "request");
    if (this.isCancelled)
    {
      Log.i("MicroMsg.AiScanImageGetProductManager", "onRetrievalStart isCancelled and ignore");
      AppMethodBeat.o(314043);
      return;
    }
    this.OVG.a(paramc);
    AppMethodBeat.o(314043);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(314012);
    s.u(parame, "request");
    b.a.y(new b..ExternalSyntheticLambda9(parame, this));
    AppMethodBeat.o(314012);
  }
  
  public final void a(i parami, int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(314038);
    s.u(parami, "result");
    h.ahAA.bk(new b..ExternalSyntheticLambda6(this, parami, paramInt1, paramLong, paramInt2, paramInt3, paramString));
    AppMethodBeat.o(314038);
  }
  
  public final void a(k paramk, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(314024);
    s.u(paramb, "addResultCallback");
    h.ahAA.bk(new b..ExternalSyntheticLambda8(this, paramk, paramb));
    AppMethodBeat.o(314024);
  }
  
  public final void b(com.tencent.mm.plugin.scanner.scan_goods_new.b.c paramc)
  {
    AppMethodBeat.i(314054);
    s.u(paramc, "task");
    if (this.isCancelled)
    {
      Log.i("MicroMsg.AiScanImageGetProductManager", "onTaskStart isCancelled and ignore");
      AppMethodBeat.o(314054);
      return;
    }
    this.OVG.b(paramc);
    AppMethodBeat.o(314054);
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(314030);
    s.u(parame, "request");
    if (this.isCancelled)
    {
      Log.i("MicroMsg.AiScanImageGetProductManager", "onUploadStart isCancelled and ignore");
      AppMethodBeat.o(314030);
      return;
    }
    this.OVG.b(parame);
    AppMethodBeat.o(314030);
  }
  
  public final void b(i parami, int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    AppMethodBeat.i(314050);
    s.u(parami, "result");
    h.ahAA.bk(new b..ExternalSyntheticLambda7(this, parami, paramInt1, paramLong, paramInt2, paramString));
    AppMethodBeat.o(314050);
  }
  
  public final void c(com.tencent.mm.plugin.scanner.scan_goods_new.b.c paramc)
  {
    AppMethodBeat.i(314061);
    s.u(paramc, "task");
    h.ahAA.bk(new b..ExternalSyntheticLambda3(this, paramc));
    b.a.y(new b..ExternalSyntheticLambda2(this, paramc));
    AppMethodBeat.o(314061);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(314018);
    Log.i("MicroMsg.AiScanImageGetProductManager", "getProduct cancel");
    this.isCancelled = true;
    b.a.y(new b..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(314018);
  }
  
  public final void d(com.tencent.mm.plugin.scanner.scan_goods_new.b.c paramc)
  {
    AppMethodBeat.i(314063);
    s.u(paramc, "task");
    this.OVG.d(paramc);
    AppMethodBeat.o(314063);
  }
  
  public final void e(i parami)
  {
    AppMethodBeat.i(314034);
    s.u(parami, "result");
    h.ahAA.bk(new b..ExternalSyntheticLambda5(this, parami));
    AppMethodBeat.o(314034);
  }
  
  public final void f(i parami)
  {
    AppMethodBeat.i(314047);
    s.u(parami, "result");
    h.ahAA.bk(new b..ExternalSyntheticLambda4(this, parami));
    AppMethodBeat.o(314047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.b
 * JD-Core Version:    0.7.0.1
 */