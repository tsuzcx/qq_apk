package com.tencent.mm.plugin.scanner.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.protocal.protobuf.mt;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/uploader/AiScanImageSceneUploader;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callbackMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "Lkotlin/collections/HashMap;", "requestMap", "Lcom/tencent/mm/plugin/scanner/image/uploader/AiImageUploader$AiImageUploadRequestWrapper;", "cancel", "", "session", "getAiImageUploader", "Lcom/tencent/mm/plugin/scanner/image/uploader/AiImageUploader;", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "onFailedWrapper", "opImageType", "", "errType", "errCode", "errMsg", "", "onOcrUploadSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/BizOcrChatImageResponse;", "onPreviewUploadSuccess", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageScenePreviewResponse;", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchUploadSuccess", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSceneResponse;", "onSuccessWrapper", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "extraTask", "Lkotlin/Function1;", "release", "uploadImage", "callback", "Companion", "plugin-scan_release"})
public final class d
  implements com.tencent.mm.an.i
{
  public static final d.a IJY;
  private HashMap<Long, com.tencent.mm.plugin.scanner.api.g> jPb;
  private HashMap<Long, c.a> oNr;
  
  static
  {
    AppMethodBeat.i(217301);
    IJY = new d.a((byte)0);
    AppMethodBeat.o(217301);
  }
  
  public d()
  {
    AppMethodBeat.i(217299);
    this.oNr = new HashMap();
    this.jPb = new HashMap();
    com.tencent.mm.kernel.h.aGY().a(1100, (com.tencent.mm.an.i)this);
    com.tencent.mm.kernel.h.aGY().a(5079, (com.tencent.mm.an.i)this);
    com.tencent.mm.kernel.h.aGY().a(5131, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(217299);
  }
  
  private static c a(e parame)
  {
    AppMethodBeat.i(217291);
    if ((parame.IGy == 1) || (parame.IGy == 3)) {
      parame = a.IJR;
    }
    for (;;)
    {
      parame = (c)parame;
      AppMethodBeat.o(217291);
      return parame;
      if (parame.IGy == 2)
      {
        parame = b.IJV;
      }
      else
      {
        Log.e("MicroMsg.AiScanImageSceneUploader", "alvinluo uploadImage unknown opImageType: %d", new Object[] { Integer.valueOf(parame.IGy) });
        parame = null;
      }
    }
  }
  
  private final void a(final long paramLong, com.tencent.mm.plugin.scanner.api.f paramf, final kotlin.g.a.b<? super c.a, x> paramb)
  {
    AppMethodBeat.i(217294);
    com.tencent.e.h.ZvG.bc((Runnable)new e(this, paramLong, paramf, paramb));
    AppMethodBeat.o(217294);
  }
  
  private final void c(final long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(217298);
    Log.e("MicroMsg.AiScanImageSceneUploader", "onScanFailed session: %d, opImageType: %s, errType: %s, errCode: %d, errMsg: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    com.tencent.mm.plugin.scanner.api.f localf = new com.tencent.mm.plugin.scanner.api.f();
    localf.IGy = paramInt1;
    localf.fwK = paramLong;
    localf.success = false;
    localf.errType = paramInt2;
    localf.errCode = paramInt3;
    localf.errMsg = paramString;
    com.tencent.e.h.ZvG.bc((Runnable)new b(this, paramLong, localf));
    AppMethodBeat.o(217298);
  }
  
  public final void a(long paramLong, e parame, com.tencent.mm.plugin.scanner.api.g paramg)
  {
    AppMethodBeat.i(217289);
    p.k(paramg, "callback");
    if (parame == null)
    {
      AppMethodBeat.o(217289);
      return;
    }
    c.a locala = new c.a();
    locala.IJW = parame;
    ((Map)this.jPb).put(Long.valueOf(paramLong), paramg);
    ((Map)this.oNr).put(Long.valueOf(paramLong), locala);
    c localc = a(parame);
    if (localc != null)
    {
      Log.i("MicroMsg.AiScanImageSceneUploader", "alvinluo uploadImage session: %s, opImageType: %s, useCdnOpt: %s, useCache: %s, uploader: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(parame.IGy), Boolean.valueOf(parame.IGD), Boolean.valueOf(parame.gaj), localc });
      localc.a(locala, paramg);
      AppMethodBeat.o(217289);
      return;
    }
    AppMethodBeat.o(217289);
  }
  
  public final void cancel(long paramLong)
  {
    AppMethodBeat.i(217290);
    Log.i("MicroMsg.AiScanImageSceneUploader", "cancel");
    this.jPb.remove(Long.valueOf(paramLong));
    Object localObject = (c.a)this.oNr.remove(Long.valueOf(paramLong));
    if (localObject != null)
    {
      Log.v("MicroMsg.AiScanImageSceneUploader", "alvinluo cancelUploadImage");
      com.tencent.mm.kernel.h.aGY().cancel(((c.a)localObject).IJX);
      localObject = ((c.a)localObject).IJW;
      if (localObject != null)
      {
        localObject = a((e)localObject);
        if (localObject != null)
        {
          ((c)localObject).PL(paramLong);
          AppMethodBeat.o(217290);
          return;
        }
        AppMethodBeat.o(217290);
        return;
      }
      AppMethodBeat.o(217290);
      return;
    }
    AppMethodBeat.o(217290);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(217292);
    if ((paramq != null) && (paramq.getType() == 1100))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject2 = (com.tencent.mm.plugin.scanner.model.f)paramq;
        paramString = (String)localObject1;
        if (((com.tencent.mm.plugin.scanner.model.f)localObject2).rr.bhY() != null)
        {
          paramString = ((com.tencent.mm.plugin.scanner.model.f)localObject2).rr.bhY();
          if (paramString == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageSceneResponse");
            AppMethodBeat.o(217292);
            throw paramString;
          }
          paramString = (mt)paramString;
        }
        if ((paramString != null) && (paramString.RSk == ((com.tencent.mm.plugin.scanner.model.f)paramq).fwK))
        {
          Log.d("MicroMsg.AiScanImageSceneUploader", "uploadImageForSearch onSceneEnd sessionId: %s, seqNum: %s", new Object[] { Long.valueOf(paramString.RSk), Integer.valueOf(paramString.ROx) });
          localObject2 = new com.tencent.mm.plugin.scanner.api.f();
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).IGy = 1;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).fwK = paramString.RSk;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).success = true;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).errType = 0;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).errCode = 0;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).errMsg = "";
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).fwv = paramString.fHb;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).jumpType = paramString.RSt;
          localObject1 = paramString.RSN;
          paramq = (q)localObject1;
          if (localObject1 == null) {
            paramq = "";
          }
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).IGG = paramq;
          a(this, paramString.RSk, (com.tencent.mm.plugin.scanner.api.f)localObject2);
          AppMethodBeat.o(217292);
          return;
        }
        Log.w("MicroMsg.AiScanImageSceneUploader", "uploadImageForSearch onSceneEnd success sessionId not the same");
        AppMethodBeat.o(217292);
        return;
      }
      c(((com.tencent.mm.plugin.scanner.model.f)paramq).fwK, 1, paramInt1, paramInt2, paramString);
      AppMethodBeat.o(217292);
      return;
    }
    if ((paramq != null) && (paramq.getType() == 5079))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = (com.tencent.mm.plugin.scanner.model.g)paramq;
        paramString = (String)localObject2;
        if (((com.tencent.mm.plugin.scanner.model.g)localObject1).rr.bhY() != null)
        {
          paramString = ((com.tencent.mm.plugin.scanner.model.g)localObject1).rr.bhY();
          if (paramString == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageScenePreviewResponse");
            AppMethodBeat.o(217292);
            throw paramString;
          }
          paramString = (mr)paramString;
        }
        if ((paramString != null) && (paramString.RSk == ((com.tencent.mm.plugin.scanner.model.g)paramq).fwK))
        {
          Log.d("MicroMsg.AiScanImageSceneUploader", "previewImage onSceneEnd sessionId: %s, seqNum: %s", new Object[] { Long.valueOf(paramString.RSk), Integer.valueOf(paramString.ROx) });
          localObject2 = new com.tencent.mm.plugin.scanner.api.f();
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).IGy = 2;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).fwK = paramString.RSk;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).success = true;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).errType = 0;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).errCode = 0;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).errMsg = "";
          localObject1 = paramString.RSF;
          paramq = (q)localObject1;
          if (localObject1 == null) {
            paramq = "";
          }
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).IGH = paramq;
          a(this, paramString.RSk, (com.tencent.mm.plugin.scanner.api.f)localObject2);
          AppMethodBeat.o(217292);
          return;
        }
        Log.w("MicroMsg.AiScanImageSceneUploader", "previewImage onSceneEnd success sessionId not the same");
        AppMethodBeat.o(217292);
        return;
      }
      c(((com.tencent.mm.plugin.scanner.model.g)paramq).fwK, 2, paramInt1, paramInt2, paramString);
      AppMethodBeat.o(217292);
      return;
    }
    if (paramq != null)
    {
      if (paramq.getType() != 5131) {
        break label839;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label823;
      }
      paramString = (com.tencent.mm.plugin.scanner.f.i)paramq;
      if (paramString.rr.bhY() == null) {
        break label803;
      }
      paramString = paramString.rr.bhY();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizOcrChatImageResponse");
        AppMethodBeat.o(217292);
        throw paramString;
      }
    }
    else
    {
      AppMethodBeat.o(217292);
      return;
    }
    label803:
    for (paramString = (ow)paramString; (paramString != null) && (paramString.RSk == ((com.tencent.mm.plugin.scanner.f.i)paramq).fwK); paramString = null)
    {
      Log.d("MicroMsg.AiScanImageSceneUploader", "uploadImageForOcr onSceneEnd sessionId: %s, seqNum: %s", new Object[] { Long.valueOf(paramString.RSk), Integer.valueOf(paramString.ROx) });
      paramq = new com.tencent.mm.plugin.scanner.api.f();
      paramq.IGy = 3;
      paramq.fwK = paramString.RSk;
      paramq.success = true;
      paramq.errType = 0;
      paramq.errCode = 0;
      paramq.errMsg = "";
      paramq.fwv = paramString.fHb;
      paramq.fTF = paramString.RSB;
      paramq.IGI = paramString.RXi;
      a(paramString.RSk, paramq, (kotlin.g.a.b)new d.c(paramq));
      AppMethodBeat.o(217292);
      return;
    }
    Log.w("MicroMsg.AiScanImageSceneUploader", "uploadImageForOcr onSceneEnd success sessionId not the same");
    AppMethodBeat.o(217292);
    return;
    label823:
    c(((com.tencent.mm.plugin.scanner.f.i)paramq).fwK, 3, paramInt1, paramInt2, paramString);
    label839:
    AppMethodBeat.o(217292);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd, long paramLong, com.tencent.mm.plugin.scanner.api.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(219003);
      Object localObject = (c.a)d.a(this.IJZ).remove(Long.valueOf(paramLong));
      if (localObject != null)
      {
        com.tencent.mm.plugin.scanner.api.f localf = this.IKa;
        localObject = ((c.a)localObject).IJW;
        if (localObject != null)
        {
          String str = ((e)localObject).imagePath;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localf.imagePath = ((String)localObject);
      }
      localObject = (com.tencent.mm.plugin.scanner.api.g)d.b(this.IJZ).remove(Long.valueOf(paramLong));
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.scanner.api.g)localObject).a(paramLong, this.IKa);
        AppMethodBeat.o(219003);
        return;
      }
      AppMethodBeat.o(219003);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(d paramd, long paramLong, com.tencent.mm.plugin.scanner.api.f paramf, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(220879);
      c.a locala = (c.a)d.a(this.IJZ).remove(Long.valueOf(paramLong));
      if (locala != null)
      {
        com.tencent.mm.plugin.scanner.api.f localf = paramb;
        localObject = locala.IJW;
        if (localObject != null)
        {
          String str = ((e)localObject).imagePath;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localf.imagePath = ((String)localObject);
      }
      for (Object localObject = locala;; localObject = null)
      {
        this.IKc.invoke(localObject);
        localObject = (com.tencent.mm.plugin.scanner.api.g)d.b(this.IJZ).remove(Long.valueOf(paramLong));
        Log.i("MicroMsg.AiScanImageSceneUploader", "onScanSuccess session: %d, callback: %s", new Object[] { Long.valueOf(paramLong), localObject });
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.plugin.scanner.api.g)localObject).a(paramLong, paramb);
        AppMethodBeat.o(220879);
        return;
      }
      AppMethodBeat.o(220879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a.d
 * JD-Core Version:    0.7.0.1
 */