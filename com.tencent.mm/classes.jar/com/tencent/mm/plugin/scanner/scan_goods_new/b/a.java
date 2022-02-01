package com.tencent.mm.plugin.scanner.scan_goods_new.b;

import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.d.b.1;
import com.tencent.mm.plugin.scanner.d.b.c;
import com.tencent.mm.plugin.scanner.model.ScanProductInfo;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.plugin.scanner.scan_goods_new.e;
import com.tencent.mm.plugin.scanner.scan_goods_new.h;
import com.tencent.mm.plugin.scanner.scan_goods_new.i;
import com.tencent.mm.plugin.scanner.scan_goods_new.j;
import com.tencent.mm.plugin.scanner.scan_goods_new.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageGetProductTask;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageTask;", "request", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageUploadRequest;", "getProductCallback", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageGetProductTask$AiScanImageGetProductCallback;", "(Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageUploadRequest;Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageGetProductTask$AiScanImageGetProductCallback;)V", "getRequest", "()Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageUploadRequest;", "retrievalCallback", "com/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageGetProductTask$retrievalCallback$1", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageGetProductTask$retrievalCallback$1;", "retrievalTask", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageRetrievalTask;", "uploadCallback", "com/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageGetProductTask$uploadCallback$1", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageGetProductTask$uploadCallback$1;", "uploadTask", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageUploadTask;", "cancel", "", "doRetrievalTask", "result", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeResult;", "run", "AiScanImageGetProductCallback", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  public static final a.b OWM;
  private final a OVG;
  public final e OWN;
  private b OWO;
  private d OWP;
  private d OWQ;
  private c OWR;
  
  static
  {
    AppMethodBeat.i(313944);
    OWM = new a.b((byte)0);
    AppMethodBeat.o(313944);
  }
  
  public a(e parame, a parama)
  {
    AppMethodBeat.i(313915);
    this.OWN = parame;
    this.OVG = parama;
    this.OWQ = new d(this);
    this.OWR = new c(this);
    AppMethodBeat.o(313915);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(313957);
    Log.v("MicroMsg.AiScanImageGetProductTask", "getProductTask cancel");
    Object localObject = this.OWP;
    if (localObject != null) {
      ((d)localObject).cancel();
    }
    localObject = this.OWO;
    if (localObject != null) {
      ((b)localObject).cancel();
    }
    if ((this.OWP == null) && (this.OWO == null)) {
      this.OVG.d((c)this);
    }
    AppMethodBeat.o(313957);
  }
  
  public final void run()
  {
    AppMethodBeat.i(313951);
    Log.i("MicroMsg.AiScanImageGetProductTask", "run getProductTask");
    d locald = new d(this.OWN.hBk, this.OWN, (d.a)this.OWQ);
    locald.run();
    ah localah = ah.aiuX;
    this.OWP = locald;
    AppMethodBeat.o(313951);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageGetProductTask$AiScanImageGetProductCallback;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageUploadTask$AiScanImageUploadCallback;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageRetrievalTask$AiScanImageRetrievalCallback;", "onAddScanProductResultForFullImage", "", "scanProductResult", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductResult;", "addResultCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
    extends b.a, d.a
  {
    public abstract void a(k paramk, kotlin.g.a.b<? super Boolean, ah> paramb);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageGetProductTask$retrievalCallback$1", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageRetrievalTask$AiScanImageRetrievalCallback;", "onRetrievalFailed", "", "result", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeResult;", "source", "", "session", "", "errCode", "errMsg", "", "onRetrievalStart", "request", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageRetrievalRequest;", "onRetrievalSuccess", "onTaskAdd", "task", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageTask;", "onTaskCancel", "onTaskFinish", "onTaskStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements b.a
  {
    c(a parama) {}
    
    public final void a(c paramc)
    {
      AppMethodBeat.i(313912);
      s.u(paramc, "task");
      AppMethodBeat.o(313912);
    }
    
    public final void a(com.tencent.mm.plugin.scanner.scan_goods_new.c paramc)
    {
      AppMethodBeat.i(313891);
      s.u(paramc, "request");
      a.a(this.OWS).a(paramc);
      AppMethodBeat.o(313891);
    }
    
    public final void b(c paramc)
    {
      AppMethodBeat.i(313918);
      s.u(paramc, "task");
      AppMethodBeat.o(313918);
    }
    
    public final void b(i parami, int paramInt1, long paramLong, int paramInt2, String paramString)
    {
      AppMethodBeat.i(313906);
      s.u(parami, "result");
      Log.e("MicroMsg.AiScanImageGetProductTask", "getProductTask onRetrievalFailed source: " + paramInt1 + ", session: " + paramLong + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      a.a(this.OWS).b(parami, paramInt1, paramLong, paramInt2, paramString);
      a.a(this.OWS).c((c)this.OWS);
      AppMethodBeat.o(313906);
    }
    
    public final void c(c paramc)
    {
      AppMethodBeat.i(313925);
      s.u(paramc, "task");
      AppMethodBeat.o(313925);
    }
    
    public final void d(c paramc)
    {
      AppMethodBeat.i(313930);
      s.u(paramc, "task");
      a.a(this.OWS).d((c)this.OWS);
      AppMethodBeat.o(313930);
    }
    
    public final void f(i parami)
    {
      AppMethodBeat.i(313900);
      s.u(parami, "result");
      Log.i("MicroMsg.AiScanImageGetProductTask", "getProductTask onRetrievalSuccess");
      a.a(this.OWS).f(parami);
      a.a(this.OWS).c((c)this.OWS);
      AppMethodBeat.o(313900);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageGetProductTask$uploadCallback$1", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageUploadTask$AiScanImageUploadCallback;", "onTaskAdd", "", "task", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageTask;", "onTaskCancel", "onTaskFinish", "onTaskStart", "onUploadFailed", "result", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeResult;", "source", "", "session", "", "errType", "errCode", "errMsg", "", "onUploadStart", "request", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageUploadRequest;", "onUploadSuccess", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements d.a
  {
    d(a parama) {}
    
    public final void a(c paramc)
    {
      AppMethodBeat.i(313916);
      s.u(paramc, "task");
      a.a(this.OWS).a((c)this.OWS);
      AppMethodBeat.o(313916);
    }
    
    public final void a(i parami, int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString)
    {
      AppMethodBeat.i(313909);
      s.u(parami, "result");
      a.a(this.OWS).a(parami, paramInt1, paramLong, paramInt2, paramInt3, paramString);
      a.a(this.OWS).c((c)this.OWS);
      if (parami.OVD != 1) {
        ac.gRj();
      }
      AppMethodBeat.o(313909);
    }
    
    public final void b(c paramc)
    {
      AppMethodBeat.i(313923);
      s.u(paramc, "task");
      a.a(this.OWS).b((c)this.OWS);
      AppMethodBeat.o(313923);
    }
    
    public final void b(e parame)
    {
      AppMethodBeat.i(313894);
      s.u(parame, "request");
      a.a(this.OWS).b(parame);
      AppMethodBeat.o(313894);
    }
    
    public final void c(c paramc)
    {
      AppMethodBeat.i(313929);
      s.u(paramc, "task");
      AppMethodBeat.o(313929);
    }
    
    public final void d(c paramc)
    {
      AppMethodBeat.i(313936);
      s.u(paramc, "task");
      a.a(this.OWS).d((c)this.OWS);
      AppMethodBeat.o(313936);
    }
    
    public final void e(i parami)
    {
      AppMethodBeat.i(313903);
      s.u(parami, "result");
      Log.i("MicroMsg.AiScanImageGetProductTask", "getProductTask onUploadSuccess and run imageRetrievalTask");
      a.a(this.OWS).e(parami);
      if (!this.OWS.OWN.OVT)
      {
        a.a(this.OWS).c((c)this.OWS);
        AppMethodBeat.o(313903);
        return;
      }
      if (parami.OVD == 1)
      {
        a.a(this.OWS, parami);
        AppMethodBeat.o(313903);
        return;
      }
      Object localObject = (h)p.oL((List)parami.OWf);
      if (localObject == null) {
        localObject = null;
      }
      while (localObject != null)
      {
        com.tencent.mm.plugin.scanner.d.b localb = com.tencent.mm.plugin.scanner.d.b.gQw();
        int i = this.OWS.OWN.OVP;
        parami = (b.c)new a(parami, this.OWS);
        if (!localb.OPe)
        {
          Log.e("MicroMsg.ReIdAiScanImageDecodeQueue", "decodeFullImage is not working");
          AppMethodBeat.o(313903);
          return;
          localObject = ((h)localObject).OWc;
        }
        else
        {
          com.tencent.mm.plugin.scanner.d.b.a(new b.1(localb, i, (RectF)localObject, parami));
          AppMethodBeat.o(313903);
          return;
        }
      }
      Log.e("MicroMsg.AiScanImageGetProductTask", "getProductTask uploadFullImage success but no goodsObject");
      ac.gRj();
      a.a(this.OWS).a(parami, parami.source, parami.hBk, 4, -1, "upload full image no goodsObject");
      a.a(this.OWS).c((c)this.OWS);
      AppMethodBeat.o(313903);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageGetProductTask$uploadCallback$1$onUploadSuccess$1", "Lcom/tencent/mm/plugin/scanner/decoder/ReIdAiScanImageDecodeQueue$ReIdAiScanImageDecodeCallback;", "onScanResult", "", "scanProductResult", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductResult;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements b.c
    {
      a(i parami, a parama) {}
      
      public final void a(k paramk)
      {
        AppMethodBeat.i(313888);
        if (paramk != null)
        {
          localObject1 = (Collection)paramk.OWA;
          if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
            break label133;
          }
        }
        Object localObject2;
        Object localObject3;
        label133:
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            com.tencent.mm.plugin.scanner.model.d.a(24, this.OWT.OWg);
          }
          ac.gRj();
          if (paramk == null) {
            break;
          }
          localObject1 = paramk.OWA;
          if (localObject1 == null) {
            break;
          }
          localObject2 = (Iterable)localObject1;
          localObject1 = this.OWS;
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (j)((Iterator)localObject2).next();
            ((j)localObject3).OWb = ((a)localObject1).OWN.OVS;
            ((j)localObject3).ORl = ((a)localObject1).OWN.ORl;
          }
        }
        Object localObject1 = ((Iterable)this.OWT.OWf).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if (i < 0) {
            p.kkW();
          }
          localObject2 = (h)localObject2;
          if (paramk != null)
          {
            localObject3 = paramk.OWA;
            if (localObject3 != null)
            {
              localObject3 = (j)p.ae((List)localObject3, i);
              if (localObject3 != null)
              {
                Log.i("MicroMsg.AiScanImageGetProductTask", "getProductTask uploadFullImage success set origin trackId: %s, trackId: %s, hashCode: %s", new Object[] { Integer.valueOf(((h)localObject2).trackId), Integer.valueOf(((j)localObject3).OWh.getId()), Integer.valueOf(((j)localObject3).hashCode()) });
                ((h)localObject2).trackId = ((j)localObject3).OWh.getId();
              }
            }
          }
          i += 1;
        }
        a.a(this.OWS).a(paramk, (kotlin.g.a.b)new a(this.OWS, this.OWT));
        AppMethodBeat.o(313888);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.b<Boolean, ah>
      {
        a(a parama, i parami)
        {
          super();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.b.a
 * JD-Core Version:    0.7.0.1
 */