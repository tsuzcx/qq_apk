package com.tencent.mm.plugin.scanner.scan_goods_new;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.d.b.b;
import com.tencent.mm.plugin.scanner.model.ScanFastFocusEngineNative;
import com.tencent.mm.plugin.scanner.model.ScanProductInfo;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.plugin.scanner.model.am;
import com.tencent.mm.plugin.scanner.model.d.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.aa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/NewAiImageHandler;", "Lcom/tencent/mm/plugin/scanner/result/ResultHandler;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductResult;", "handleCallback", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanProductHandleCallback;", "(Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanProductHandleCallback;)V", "getProductCallback", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageGetProductTask$AiScanImageGetProductCallback;", "getProductManager", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageGetProductManager;", "trackIdManager", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageTrackIdManager;", "getTrackIdManager", "()Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageTrackIdManager;", "trackIdManager$delegate", "Lkotlin/Lazy;", "addTrackId", "", "trackId", "", "checkTrackIdExist", "", "destroy", "encodeImage", "Lkotlin/Pair;", "", "imageData", "originImageType", "imageEncodeType", "imageSize", "Landroid/graphics/Point;", "getScanProductRecognizeItemProductInfo", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;", "result", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeResult;", "handleResult", "session", "", "scanProductResult", "onAddScanProduct", "updateDebugView", "scanProductInfo", "uploadFullImage", "uploadImageForGallery", "uploadNormalImage", "requestInfo", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.mm.plugin.scanner.g.f<k>
{
  public static final g.a OVU;
  private final com.tencent.mm.plugin.scanner.scan_goods_new.b.a.a OVG;
  private final f OVV;
  private final b OVW;
  private final kotlin.j OVX;
  
  static
  {
    AppMethodBeat.i(314029);
    OVU = new g.a((byte)0);
    AppMethodBeat.o(314029);
  }
  
  public g(f paramf)
  {
    AppMethodBeat.i(313875);
    this.OVV = paramf;
    this.OVX = kotlin.k.cm((kotlin.g.a.a)g.b.OVZ);
    this.OVG = ((com.tencent.mm.plugin.scanner.scan_goods_new.b.a.a)new com.tencent.mm.plugin.scanner.scan_goods_new.b.a.a()
    {
      private static final void a(k paramAnonymousk, g paramAnonymousg, kotlin.g.a.b paramAnonymousb)
      {
        Object localObject3 = null;
        AppMethodBeat.i(313858);
        s.u(paramAnonymousg, "this$0");
        s.u(paramAnonymousb, "$addResultCallback");
        Object localObject1;
        ScanProductInfo localScanProductInfo;
        label35:
        Object localObject2;
        label53:
        label74:
        label96:
        label118:
        int i;
        if (paramAnonymousk == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label296;
          }
          localScanProductInfo = null;
          StringBuilder localStringBuilder = new StringBuilder("onAddScanProductResultForFullImage source: ");
          if (paramAnonymousk != null) {
            break label306;
          }
          localObject2 = null;
          localStringBuilder = localStringBuilder.append(localObject2).append(", session: ");
          if (paramAnonymousk != null) {
            break label318;
          }
          localObject2 = null;
          localStringBuilder = localStringBuilder.append(localObject2).append(", trackId: ");
          if (localScanProductInfo != null) {
            break label330;
          }
          localObject2 = null;
          localObject2 = localStringBuilder.append(localObject2).append(", detectByServer: ");
          if (localObject1 != null) {
            break label343;
          }
          localObject1 = null;
          localObject2 = localObject1 + ", scanProductInfo: %s";
          if (localScanProductInfo != null) {
            break label356;
          }
          localObject1 = localObject3;
          label144:
          Log.i("MicroMsg.NewAiImageHandler", (String)localObject2, new Object[] { localObject1 });
          if (localScanProductInfo == null) {
            break label410;
          }
          localObject1 = com.tencent.mm.plugin.scanner.d.b.gQw();
          if (((com.tencent.mm.plugin.scanner.d.b)localObject1).OPd != null)
          {
            if (((com.tencent.mm.plugin.scanner.d.b)localObject1).OPd.OPI <= 0) {
              break label369;
            }
            i = 1;
            label191:
            if (i == 0) {
              ((com.tencent.mm.plugin.scanner.d.b)localObject1).OPd.OPJ = ((com.tencent.mm.plugin.scanner.d.b)localObject1).OPd.OPG;
            }
            localObject1 = ((com.tencent.mm.plugin.scanner.d.b)localObject1).OPd;
            ((b.b)localObject1).OPI += 1;
          }
          if (g.a(paramAnonymousg, localScanProductInfo.getId())) {
            break label394;
          }
          g.b(paramAnonymousg, localScanProductInfo.getId());
          if (!g.a(paramAnonymousg, paramAnonymousk)) {
            break label374;
          }
          g.b(paramAnonymousg, localScanProductInfo.getId());
          paramAnonymousb.invoke(Boolean.TRUE);
        }
        for (;;)
        {
          g.gRP();
          AppMethodBeat.o(313858);
          return;
          localObject1 = paramAnonymousk.gRQ();
          break;
          label296:
          localScanProductInfo = ((j)localObject1).OWh;
          break label35;
          label306:
          localObject2 = Integer.valueOf(paramAnonymousk.source);
          break label53;
          label318:
          localObject2 = Long.valueOf(paramAnonymousk.hBk);
          break label74;
          label330:
          localObject2 = Integer.valueOf(localScanProductInfo.getId());
          break label96;
          label343:
          localObject1 = Boolean.valueOf(((j)localObject1).OWi);
          break label118;
          label356:
          localObject1 = Integer.valueOf(localScanProductInfo.hashCode());
          break label144;
          label369:
          i = 0;
          break label191;
          label374:
          Log.w("MicroMsg.NewAiImageHandler", "onAddScanProductResultForFullImage addScanProduct failed");
          paramAnonymousb.invoke(Boolean.FALSE);
        }
        label394:
        paramAnonymousb.invoke(Boolean.FALSE);
        AppMethodBeat.o(313858);
        return;
        label410:
        com.tencent.mm.plugin.scanner.d.b.gQw().gQz();
        paramAnonymousb.invoke(Boolean.FALSE);
        AppMethodBeat.o(313858);
      }
      
      public final void a(com.tencent.mm.plugin.scanner.scan_goods_new.b.c paramAnonymousc)
      {
        AppMethodBeat.i(314001);
        s.u(paramAnonymousc, "task");
        if ((paramAnonymousc instanceof com.tencent.mm.plugin.scanner.scan_goods_new.b.a)) {
          ((com.tencent.mm.plugin.scanner.scan_goods_new.b.a)paramAnonymousc).OWN.OVE.OWk.OWm = System.currentTimeMillis();
        }
        AppMethodBeat.o(314001);
      }
      
      public final void a(c paramAnonymousc)
      {
        AppMethodBeat.i(313907);
        s.u(paramAnonymousc, "request");
        Log.d("MicroMsg.NewAiImageHandler", "onRetrievalStart");
        paramAnonymousc.OVE.OWk.OWo = System.currentTimeMillis();
        AppMethodBeat.o(313907);
      }
      
      public final void a(i paramAnonymousi, int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString)
      {
        AppMethodBeat.i(313896);
        s.u(paramAnonymousi, "result");
        Log.e("MicroMsg.NewAiImageHandler", "onUploadFailed source: " + paramAnonymousi.source + ", session: " + paramAnonymousi.hBk + ", scanImageType: " + paramAnonymousi.OVD + ", errType: " + paramAnonymousInt2 + ", errCode: " + paramAnonymousInt3 + ", errMsg: " + paramAnonymousString);
        g.a(this.OVY).a(paramAnonymousi, paramAnonymousInt3, paramAnonymousString);
        com.tencent.mm.plugin.scanner.d.b.gQw().gQz();
        if (paramAnonymousi.OVD == 1)
        {
          com.tencent.mm.plugin.scanner.model.d.a(13, paramAnonymousi.OWg);
          AppMethodBeat.o(313896);
          return;
        }
        switch (paramAnonymousInt1)
        {
        }
        label241:
        label244:
        for (;;)
        {
          AppMethodBeat.o(313896);
          return;
          com.tencent.mm.plugin.scanner.model.d.a(23, paramAnonymousi.OWg);
          AppMethodBeat.o(313896);
          return;
          if (paramAnonymousInt3 != 1003)
          {
            paramAnonymousString = (Collection)paramAnonymousi.OWf;
            if ((paramAnonymousString != null) && (!paramAnonymousString.isEmpty())) {
              break label241;
            }
          }
          for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
          {
            if (paramAnonymousInt1 == 0) {
              break label244;
            }
            com.tencent.mm.plugin.scanner.model.d.a(43, paramAnonymousi.OWg);
            break;
          }
        }
      }
      
      public final void a(k paramAnonymousk, kotlin.g.a.b<? super Boolean, ah> paramAnonymousb)
      {
        AppMethodBeat.i(313960);
        s.u(paramAnonymousb, "addResultCallback");
        com.tencent.mm.plugin.scanner.d.b.a(new g.1..ExternalSyntheticLambda0(paramAnonymousk, this.OVY, paramAnonymousb));
        AppMethodBeat.o(313960);
      }
      
      public final void b(com.tencent.mm.plugin.scanner.scan_goods_new.b.c paramAnonymousc)
      {
        AppMethodBeat.i(313988);
        s.u(paramAnonymousc, "task");
        if (((paramAnonymousc instanceof com.tencent.mm.plugin.scanner.scan_goods_new.b.a)) && (((com.tencent.mm.plugin.scanner.scan_goods_new.b.a)paramAnonymousc).OWN.OVE.OWk.OWm > 0L)) {
          ((com.tencent.mm.plugin.scanner.scan_goods_new.b.a)paramAnonymousc).OWN.OVE.OWk.OWv = (System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.scan_goods_new.b.a)paramAnonymousc).OWN.OVE.OWk.OWm);
        }
        AppMethodBeat.o(313988);
      }
      
      public final void b(e paramAnonymouse)
      {
        AppMethodBeat.i(313872);
        s.u(paramAnonymouse, "request");
        Log.d("MicroMsg.NewAiImageHandler", "onUploadStart");
        paramAnonymouse.OVE.OWk.OWn = System.currentTimeMillis();
        AppMethodBeat.o(313872);
      }
      
      public final void b(i paramAnonymousi, int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(313950);
        s.u(paramAnonymousi, "result");
        Log.e("MicroMsg.NewAiImageHandler", "onRetrievalFailed source: " + paramAnonymousi.source + ", session: " + paramAnonymousi.hBk + ", scanImageType: " + paramAnonymousi.OVD + ", errCode: " + paramAnonymousInt2 + ", errMsg: " + paramAnonymousString);
        g.a(this.OVY).d(paramAnonymousi);
        if (paramAnonymousi.OVD == 1)
        {
          com.tencent.mm.plugin.scanner.model.d.a(15, paramAnonymousi.OWg);
          AppMethodBeat.o(313950);
          return;
        }
        com.tencent.mm.plugin.scanner.model.d.a(26, paramAnonymousi.OWg);
        AppMethodBeat.o(313950);
      }
      
      public final void c(com.tencent.mm.plugin.scanner.scan_goods_new.b.c paramAnonymousc)
      {
        AppMethodBeat.i(313973);
        s.u(paramAnonymousc, "task");
        Log.i("MicroMsg.NewAiImageHandler", "getProductTask onTaskFinish %d", new Object[] { Integer.valueOf(paramAnonymousc.hashCode()) });
        AppMethodBeat.o(313973);
      }
      
      public final void d(com.tencent.mm.plugin.scanner.scan_goods_new.b.c paramAnonymousc)
      {
        AppMethodBeat.i(314011);
        s.u(paramAnonymousc, "task");
        if ((paramAnonymousc instanceof com.tencent.mm.plugin.scanner.scan_goods_new.b.a))
        {
          Log.w("MicroMsg.NewAiImageHandler", "getProductTask onTaskCancel %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.scanner.scan_goods_new.b.a)paramAnonymousc).OWN.OVD) });
          if (((com.tencent.mm.plugin.scanner.scan_goods_new.b.a)paramAnonymousc).OWN.OVD == 1)
          {
            com.tencent.mm.plugin.scanner.model.d.a(16, ((com.tencent.mm.plugin.scanner.scan_goods_new.b.a)paramAnonymousc).OWN.OVE.OWg);
            AppMethodBeat.o(314011);
            return;
          }
          com.tencent.mm.plugin.scanner.model.d.a(27, ((com.tencent.mm.plugin.scanner.scan_goods_new.b.a)paramAnonymousc).OWN.OVE.OWg);
        }
        AppMethodBeat.o(314011);
      }
      
      public final void e(i paramAnonymousi)
      {
        Object localObject1 = null;
        AppMethodBeat.i(313883);
        s.u(paramAnonymousi, "result");
        Object localObject2 = g.g(paramAnonymousi);
        if (localObject2 != null) {
          ((j)localObject2).OWk.OWw = (System.currentTimeMillis() - ((j)localObject2).OWk.OWn);
        }
        StringBuilder localStringBuilder = new StringBuilder("onUploadSuccess source: ").append(paramAnonymousi.source).append(", session: ").append(paramAnonymousi.hBk).append(", scanImageType: ").append(paramAnonymousi.OVD).append(", uploadDuration: ");
        if (localObject2 == null) {}
        for (;;)
        {
          Log.i("MicroMsg.NewAiImageHandler", localObject1);
          g.a(this.OVY).b(paramAnonymousi);
          AppMethodBeat.o(313883);
          return;
          localObject2 = ((j)localObject2).OWk;
          if (localObject2 != null) {
            localObject1 = Long.valueOf(((j.a)localObject2).OWw);
          }
        }
      }
      
      public final void f(i paramAnonymousi)
      {
        AppMethodBeat.i(313934);
        s.u(paramAnonymousi, "result");
        Log.i("MicroMsg.NewAiImageHandler", "onRetrievalSuccess source: " + paramAnonymousi.source + ", session: " + paramAnonymousi.hBk + ", scanImageType: " + paramAnonymousi.OVD);
        g.a(this.OVY).c(paramAnonymousi);
        Object localObject1 = g.g(paramAnonymousi);
        Object localObject2;
        Object localObject3;
        if (localObject1 != null)
        {
          localObject2 = ((j)localObject1).OWk;
          localObject3 = String.valueOf(paramAnonymousi.hBk);
          s.u(localObject3, "<set-?>");
          ((j.a)localObject2).OWp = ((String)localObject3);
          ((j)localObject1).OWk.OWx = (System.currentTimeMillis() - ((j)localObject1).OWk.OWo);
          if (paramAnonymousi.OVD != 1) {
            break label443;
          }
          ((j)localObject1).OWk.OWq = 1;
        }
        for (;;)
        {
          ((j)localObject1).OWk.OOK = com.tencent.mm.plugin.scanner.util.i.gUb();
          localObject2 = ((j)localObject1).OWk;
          localObject3 = com.tencent.qbar.b.a.ahrN;
          ((j.a)localObject2).OWz = com.tencent.qbar.b.a.a.jWZ();
          localObject2 = com.tencent.mm.plugin.scanner.model.e.ORp;
          localObject1 = ((j)localObject1).OWk;
          if (localObject1 != null)
          {
            int i = ((j.a)localObject1).OPw;
            localObject2 = ((j.a)localObject1).OWp;
            int j = ((j.a)localObject1).OWq;
            long l1 = ((j.a)localObject1).OWr;
            long l2 = ((j.a)localObject1).OWs;
            long l3 = ((j.a)localObject1).OWt;
            int k = ((j.a)localObject1).OWu;
            long l4 = ((j.a)localObject1).OWv;
            long l5 = ((j.a)localObject1).OWw;
            long l6 = ((j.a)localObject1).OWx;
            int m = ((j.a)localObject1).OWy;
            int n = ((j.a)localObject1).OWz;
            int i1 = ((j.a)localObject1).OOK;
            com.tencent.mm.plugin.report.service.h.OAn.b(24129, new Object[] { Integer.valueOf(i), localObject2, Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(k), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Integer.valueOf(m), "", Integer.valueOf(n), Integer.valueOf(i1) });
          }
          if (paramAnonymousi.OVD != 1) {
            break;
          }
          com.tencent.mm.plugin.scanner.model.d.a(19, paramAnonymousi.OWg);
          AppMethodBeat.o(313934);
          return;
          label443:
          if (paramAnonymousi.OVD == 2) {
            ((j)localObject1).OWk.OWq = 2;
          } else if (paramAnonymousi.OVD == 3) {
            ((j)localObject1).OWk.OWq = 3;
          }
        }
        com.tencent.mm.plugin.scanner.model.d.a(34, paramAnonymousi.OWg);
        AppMethodBeat.o(313934);
      }
    });
    this.OVW = new b(this.OVG);
    AppMethodBeat.o(313875);
  }
  
  private static kotlin.r<byte[], Integer> a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Point paramPoint)
  {
    int j = 1;
    AppMethodBeat.i(313913);
    Object localObject = null;
    byte[] arrayOfByte = null;
    int i = -1;
    if (paramInt2 == 1)
    {
      if (paramInt1 != 1) {
        break label153;
      }
      localObject = com.tencent.mm.plugin.scanner.util.r.a(paramArrayOfByte, paramPoint);
      paramInt1 = j;
    }
    for (;;)
    {
      paramArrayOfByte = new kotlin.r(localObject, Integer.valueOf(paramInt1));
      AppMethodBeat.o(313913);
      return paramArrayOfByte;
      switch (paramInt1)
      {
      default: 
        paramInt2 = i;
      }
      for (;;)
      {
        i = paramInt2;
        localObject = arrayOfByte;
        if (arrayOfByte != null) {
          break label153;
        }
        Log.e("MicroMsg.NewAiImageHandler", "convertYUVToWxam failed use jpeg");
        am.gRw();
        i = paramInt2;
        localObject = arrayOfByte;
        if (paramInt1 != 1) {
          break label153;
        }
        localObject = com.tencent.mm.plugin.scanner.util.r.a(paramArrayOfByte, paramPoint);
        paramInt1 = 3;
        break;
        arrayOfByte = com.tencent.mm.plugin.scanner.util.r.b(paramArrayOfByte, paramPoint);
        paramInt2 = 2;
        continue;
        arrayOfByte = com.tencent.mm.plugin.scanner.util.r.c(paramArrayOfByte, paramPoint);
        paramInt2 = 2;
      }
      label153:
      paramInt1 = i;
    }
  }
  
  private static final void a(g paramg, k paramk, ScanProductInfo paramScanProductInfo)
  {
    AppMethodBeat.i(313948);
    s.u(paramg, "this$0");
    s.u(paramk, "$scanProductResult");
    s.u(paramScanProductInfo, "$scanProductInfo");
    paramg = paramg.OVV;
    paramk = new i(paramk.source, paramk.hBk, 1);
    ArrayList localArrayList = paramk.OWf;
    h localh = new h();
    localh.trackId = paramScanProductInfo.getId();
    paramScanProductInfo = ah.aiuX;
    localArrayList.add(localh);
    paramScanProductInfo = ah.aiuX;
    paramg.a(paramk, 1001, "convert yuv to jpg failed");
    AppMethodBeat.o(313948);
  }
  
  private final void a(j paramj, k paramk)
  {
    AppMethodBeat.i(313898);
    ScanProductInfo localScanProductInfo = paramj.OWh;
    Log.i("MicroMsg.NewAiImageHandler", "uploadNormalImage shouldShow: %s, source: %s, session: %s, tracId: %s", new Object[] { Boolean.valueOf(localScanProductInfo.getShouldShow()), Integer.valueOf(paramk.source), Long.valueOf(paramk.hBk), Integer.valueOf(localScanProductInfo.getId()) });
    if ((localScanProductInfo.getShouldShow()) && (!ail(localScanProductInfo.getId())))
    {
      int i = com.tencent.mm.plugin.scanner.c.a.gQp();
      long l1 = System.currentTimeMillis();
      ScanFastFocusEngineNative localScanFastFocusEngineNative;
      long l2;
      byte[] arrayOfByte;
      switch (i)
      {
      default: 
        i = 1;
        localScanFastFocusEngineNative = ac.getCropYUVByTrackId(localScanProductInfo.getId(), localScanProductInfo.getX1(), localScanProductInfo.getY1(), localScanProductInfo.getX2(), localScanProductInfo.getY2());
        l2 = System.currentTimeMillis();
        if (localScanFastFocusEngineNative == null) {
          arrayOfByte = null;
        }
        break;
      }
      for (;;)
      {
        label161:
        if (arrayOfByte != null)
        {
          int j = com.tencent.mm.plugin.scanner.c.a.gQo();
          long l3 = System.currentTimeMillis();
          arrayOfByte = localScanFastFocusEngineNative.bestImageData;
          s.s(arrayOfByte, "result.bestImageData");
          Object localObject1 = a(arrayOfByte, i, j, new Point(localScanFastFocusEngineNative.width, localScanFastFocusEngineNative.height));
          arrayOfByte = (byte[])((kotlin.r)localObject1).bsC;
          i = ((Number)((kotlin.r)localObject1).bsD).intValue();
          long l4 = System.currentTimeMillis();
          if (arrayOfByte != null)
          {
            paramj.OWk.OWs = (l2 - l1);
            paramj.OWk.OWt = (l4 - l3);
            paramj.OWk.OWu = arrayOfByte.length;
            localObject1 = paramj.OWk;
            Object localObject2 = j.a.OWl;
            ((j.a)localObject1).OWy = j.a.a.aim(i);
            localObject1 = ((Iterable)paramk.OWA).iterator();
            for (;;)
            {
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (j)((Iterator)localObject1).next();
                if (((j)localObject2).OWh.getId() == localScanProductInfo.getId())
                {
                  Log.v("MicroMsg.NewAiImageHandler", "handleResult shouldShow: %s, trackId: %s", new Object[] { Boolean.valueOf(localScanProductInfo.getShouldShow()), Integer.valueOf(localScanProductInfo.getId()) });
                  ((j)localObject2).OWb = arrayOfByte;
                  ((j)localObject2).ORl = i;
                  continue;
                  localScanFastFocusEngineNative = ac.getCropYUVByTrackId(localScanProductInfo.getId(), localScanProductInfo.getX1(), localScanProductInfo.getY1(), localScanProductInfo.getX2(), localScanProductInfo.getY2());
                  break;
                  localScanFastFocusEngineNative = ac.getCropRGBAByTrackId(localScanProductInfo.getId(), localScanProductInfo.getX1(), localScanProductInfo.getY1(), localScanProductInfo.getX2(), localScanProductInfo.getY2());
                  break;
                  arrayOfByte = localScanFastFocusEngineNative.bestImageData;
                  break label161;
                }
              }
            }
            localObject1 = paramj.OWg;
            if (localObject1 != null)
            {
              ((d.a)localObject1).ORl = paramj.OWk.OWy;
              ((d.a)localObject1).ORm = paramj.OWk.OWu;
            }
            if (e(paramk))
            {
              com.tencent.mm.plugin.scanner.model.d.a(10, paramj.OWg);
              aij(localScanProductInfo.getId());
              paramj = new e(paramj, 1, arrayOfByte, i, localScanFastFocusEngineNative.width, localScanFastFocusEngineNative.height);
              paramj.source = paramk.source;
              paramj.hBk = paramk.hBk;
              paramj.mode = 0;
              this.OVW.a(paramj);
              AppMethodBeat.o(313898);
              return;
            }
            Log.w("MicroMsg.NewAiImageHandler", "uploadNormalImage addScanProduct failed");
            AppMethodBeat.o(313898);
            return;
          }
          Log.e("MicroMsg.NewAiImageHandler", "handleResult get jpg failed");
          com.tencent.mm.plugin.scanner.model.d.a(11, paramj.OWg);
          com.tencent.threadpool.h.ahAA.bk(new g..ExternalSyntheticLambda1(this, paramk, localScanProductInfo));
        }
      }
    }
    AppMethodBeat.o(313898);
  }
  
  private static final void a(k paramk, g paramg)
  {
    AppMethodBeat.i(313972);
    s.u(paramk, "$scanProductResult");
    s.u(paramg, "this$0");
    int k = com.tencent.mm.plugin.scanner.c.a.gQp();
    Object localObject1 = com.tencent.mm.plugin.scanner.d.b.gQw();
    if (((com.tencent.mm.plugin.scanner.d.b)localObject1).OPd != null)
    {
      localObject1 = ((com.tencent.mm.plugin.scanner.d.b)localObject1).OPd;
      ((b.b)localObject1).OPG += 1;
    }
    Log.w("MicroMsg.NewAiImageHandler", "uploadFullImage fullImageData: %s, source: %s, session: %s, originImageType: %d", new Object[] { paramk.OWD, Integer.valueOf(paramk.source), Long.valueOf(paramk.hBk), Integer.valueOf(k) });
    int i;
    d.a locala;
    int j;
    int m;
    if (paramk.OWD == null)
    {
      i = 1;
      locala = new d.a();
      localObject1 = paramk.OWD;
      j = i;
      if (localObject1 != null)
      {
        m = paramg.gRN().gRM();
        long l1 = System.currentTimeMillis();
        switch (k)
        {
        default: 
          j = 1;
          localObject1 = ac.ab((byte[])localObject1, m);
          label183:
          long l2 = System.currentTimeMillis();
          if (localObject1 != null)
          {
            Point localPoint = ac.gRk();
            k = com.tencent.mm.plugin.scanner.c.a.gQo();
            long l3 = System.currentTimeMillis();
            Object localObject2 = a((byte[])localObject1, j, k, localPoint);
            long l4 = System.currentTimeMillis();
            localObject1 = (byte[])((kotlin.r)localObject2).bsC;
            j = ((Number)((kotlin.r)localObject2).bsD).intValue();
            if (localObject1 != null)
            {
              localObject2 = new ScanProductInfo();
              ((ScanProductInfo)localObject2).setId(m);
              Log.d("MicroMsg.NewAiImageHandler", "uploadFullImage localTrackId: %s", new Object[] { Integer.valueOf(((ScanProductInfo)localObject2).getId()) });
              Object localObject3 = ah.aiuX;
              localObject2 = new j((ScanProductInfo)localObject2);
              ((j)localObject2).OWk.OWs = (l2 - l1);
              ((j)localObject2).OWk.OWt = (l4 - l3);
              ((j)localObject2).OWk.OWu = localObject1.length;
              localObject3 = ((j)localObject2).OWk;
              j.a.a locala1 = j.a.OWl;
              ((j.a)localObject3).OWy = j.a.a.aim(j);
              locala.ORl = ((j)localObject2).OWk.OWy;
              locala.ORm = ((j)localObject2).OWk.OWu;
              localObject3 = ah.aiuX;
              ((j)localObject2).OWg = locala;
              com.tencent.mm.plugin.scanner.model.d.a(20, ((j)localObject2).OWg);
              paramg = paramg.OVW;
              localObject1 = new e((j)localObject2, 3, (byte[])localObject1, j, localPoint.x, localPoint.y);
              ((e)localObject1).OVP = m;
              ((a)localObject1).source = paramk.source;
              ((a)localObject1).hBk = paramk.hBk;
              ((a)localObject1).mode = 0;
              paramk = ah.aiuX;
              paramg.a((e)localObject1);
              j = i;
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      if (j != 0) {
        com.tencent.mm.plugin.scanner.model.d.a(21, locala);
      }
      AppMethodBeat.o(313972);
      return;
      i = 0;
      break;
      localObject1 = ac.ab((byte[])localObject1, m);
      j = k;
      break label183;
      localObject1 = ac.ac((byte[])localObject1, m);
      j = k;
      break label183;
      j = 1;
      com.tencent.mm.plugin.scanner.d.b.gQw().gQz();
      continue;
      j = 1;
      com.tencent.mm.plugin.scanner.d.b.gQw().gQz();
    }
  }
  
  private final void a(k paramk, j paramj)
  {
    AppMethodBeat.i(313922);
    if (paramj.OWj != null)
    {
      byte[] arrayOfByte = paramj.OWj;
      s.checkNotNull(arrayOfByte);
      paramj = new e(paramj, 2, arrayOfByte, 1, 0, 0);
      paramj.source = paramk.source;
      paramj.hBk = paramk.hBk;
      paramj.mode = 1;
      paramj.OVT = false;
      this.OVW.a(paramj);
    }
    AppMethodBeat.o(313922);
  }
  
  private final void aij(int paramInt)
  {
    AppMethodBeat.i(313941);
    Log.i("MicroMsg.NewAiImageHandler", "addTrackId: %s", new Object[] { Integer.valueOf(paramInt) });
    gRN().aij(paramInt);
    AppMethodBeat.o(313941);
  }
  
  private final boolean ail(int paramInt)
  {
    AppMethodBeat.i(313933);
    boolean bool = gRN().aik(paramInt);
    AppMethodBeat.o(313933);
    return bool;
  }
  
  private final void d(k paramk)
  {
    AppMethodBeat.i(313904);
    if (BuildInfo.DEBUG) {
      MMHandlerThread.postToMainThread(g..ExternalSyntheticLambda2.INSTANCE);
    }
    com.tencent.mm.plugin.scanner.d.b.a(new g..ExternalSyntheticLambda0(paramk, this));
    AppMethodBeat.o(313904);
  }
  
  private final boolean e(k paramk)
  {
    AppMethodBeat.i(313927);
    boolean bool = this.OVV.b(paramk);
    if (bool)
    {
      paramk = paramk.gRQ();
      if (paramk != null) {
        break label45;
      }
    }
    label45:
    for (paramk = null;; paramk = paramk.OWg)
    {
      com.tencent.mm.plugin.scanner.model.d.a(2, paramk);
      AppMethodBeat.o(313927);
      return bool;
    }
  }
  
  private final d gRN()
  {
    AppMethodBeat.i(313880);
    d locald = (d)this.OVX.getValue();
    AppMethodBeat.o(313880);
    return locald;
  }
  
  private static final void gRO()
  {
    AppMethodBeat.i(313954);
    aa.showTextToast(MMApplicationContext.getContext(), "触发后台识别");
    AppMethodBeat.o(313954);
  }
  
  public final void c(k paramk)
  {
    AppMethodBeat.i(314049);
    if (paramk == null)
    {
      AppMethodBeat.o(314049);
      return;
    }
    if (paramk.OWC)
    {
      d(paramk);
      AppMethodBeat.o(314049);
      return;
    }
    j localj = paramk.gRQ();
    if (localj == null)
    {
      AppMethodBeat.o(314049);
      return;
    }
    if (localj.OWg == null) {
      localj.OWg = new d.a();
    }
    if (paramk.source == 3)
    {
      a(localj, paramk);
      AppMethodBeat.o(314049);
      return;
    }
    if (paramk.source == 4) {
      a(paramk, localj);
    }
    AppMethodBeat.o(314049);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(314053);
    Log.i("MicroMsg.NewAiImageHandler", "destroy NewAiImageHandler");
    this.OVW.cancel();
    Object localObject1 = gRN();
    synchronized (((d)localObject1).OVQ)
    {
      ((d)localObject1).OVQ.clear();
      ah localah = ah.aiuX;
    }
    synchronized (Integer.valueOf(((d)localObject1).OVP))
    {
      ((d)localObject1).OVP = 0;
      localObject1 = ah.aiuX;
      AppMethodBeat.o(314053);
      return;
      localObject2 = finally;
      AppMethodBeat.o(314053);
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.g
 * JD-Core Version:    0.7.0.1
 */