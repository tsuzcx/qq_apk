package com.tencent.mm.plugin.scanner.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.plugin.scanner.api.g;
import com.tencent.mm.plugin.scanner.model.j;
import com.tencent.mm.plugin.scanner.model.k;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/uploader/AiScanImageSceneUploader;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callbackMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "Lkotlin/collections/HashMap;", "requestMap", "Lcom/tencent/mm/plugin/scanner/image/uploader/AiImageUploader$AiImageUploadRequestWrapper;", "cancel", "", "session", "getAiImageUploader", "Lcom/tencent/mm/plugin/scanner/image/uploader/AiImageUploader;", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "onFailedWrapper", "opImageType", "", "errType", "errCode", "errMsg", "", "onOcrUploadSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/BizOcrChatImageResponse;", "onPreviewUploadSuccess", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageScenePreviewResponse;", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchUploadSuccess", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSceneResponse;", "onSuccessWrapper", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "extraTask", "Lkotlin/Function1;", "release", "uploadImage", "callback", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements com.tencent.mm.am.h
{
  public static final d.a OQK;
  private HashMap<Long, g> mnT;
  private HashMap<Long, c.a> rRp;
  
  static
  {
    AppMethodBeat.i(313676);
    OQK = new d.a((byte)0);
    AppMethodBeat.o(313676);
  }
  
  public d()
  {
    AppMethodBeat.i(313616);
    this.rRp = new HashMap();
    this.mnT = new HashMap();
    com.tencent.mm.kernel.h.aZW().a(1100, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(5079, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(5131, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(313616);
  }
  
  private static c a(e parame)
  {
    AppMethodBeat.i(313626);
    if ((parame.OMG == 1) || (parame.OMG == 3))
    {
      parame = (c)a.OQD;
      AppMethodBeat.o(313626);
      return parame;
    }
    if (parame.OMG == 2)
    {
      parame = (c)b.OQH;
      AppMethodBeat.o(313626);
      return parame;
    }
    Log.e("MicroMsg.AiScanImageSceneUploader", "alvinluo uploadImage unknown opImageType: %d", new Object[] { Integer.valueOf(parame.OMG) });
    AppMethodBeat.o(313626);
    return null;
  }
  
  private final void a(long paramLong, f paramf, kotlin.g.a.b<? super c.a, ah> paramb)
  {
    AppMethodBeat.i(313632);
    com.tencent.threadpool.h.ahAA.bk(new d..ExternalSyntheticLambda1(this, paramLong, paramb, paramf));
    AppMethodBeat.o(313632);
  }
  
  private static final void a(d paramd, long paramLong, kotlin.g.a.b paramb, f paramf)
  {
    AppMethodBeat.i(313665);
    kotlin.g.b.s.u(paramd, "this$0");
    kotlin.g.b.s.u(paramb, "$extraTask");
    kotlin.g.b.s.u(paramf, "$result");
    c.a locala = (c.a)paramd.rRp.remove(Long.valueOf(paramLong));
    if (locala == null)
    {
      localObject = null;
      paramb.invoke(localObject);
      paramd = (g)paramd.mnT.remove(Long.valueOf(paramLong));
      Log.i("MicroMsg.AiScanImageSceneUploader", "onScanSuccess session: %d, callback: %s", new Object[] { Long.valueOf(paramLong), paramd });
      if (paramd != null) {
        paramd.onCallback(paramLong, paramf);
      }
      AppMethodBeat.o(313665);
      return;
    }
    Object localObject = locala.OQI;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      paramf.imagePath = ((String)localObject);
      localObject = locala;
      break;
      String str = ((e)localObject).imagePath;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  private static final void b(d paramd, long paramLong, f paramf)
  {
    AppMethodBeat.i(313671);
    kotlin.g.b.s.u(paramd, "this$0");
    kotlin.g.b.s.u(paramf, "$result");
    Object localObject = (c.a)paramd.rRp.remove(Long.valueOf(paramLong));
    if (localObject != null)
    {
      localObject = ((c.a)localObject).OQI;
      if (localObject != null) {
        break label93;
      }
      localObject = "";
    }
    for (;;)
    {
      paramf.imagePath = ((String)localObject);
      paramd = (g)paramd.mnT.remove(Long.valueOf(paramLong));
      if (paramd != null) {
        paramd.onCallback(paramLong, paramf);
      }
      AppMethodBeat.o(313671);
      return;
      label93:
      String str = ((e)localObject).imagePath;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  private final void c(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(313653);
    Log.e("MicroMsg.AiScanImageSceneUploader", "onScanFailed session: %d, opImageType: %s, errType: %s, errCode: %d, errMsg: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    f localf = new f();
    localf.OMG = paramInt1;
    localf.hBk = paramLong;
    localf.success = false;
    localf.errType = paramInt2;
    localf.errCode = paramInt3;
    localf.errMsg = paramString;
    com.tencent.threadpool.h.ahAA.bk(new d..ExternalSyntheticLambda0(this, paramLong, localf));
    AppMethodBeat.o(313653);
  }
  
  public final void a(long paramLong, e parame, g paramg)
  {
    AppMethodBeat.i(313692);
    kotlin.g.b.s.u(paramg, "callback");
    if (parame == null)
    {
      AppMethodBeat.o(313692);
      return;
    }
    c.a locala = new c.a();
    locala.OQI = parame;
    ((Map)this.mnT).put(Long.valueOf(paramLong), paramg);
    ((Map)this.rRp).put(Long.valueOf(paramLong), locala);
    c localc = a(parame);
    if (localc != null)
    {
      Log.i("MicroMsg.AiScanImageSceneUploader", "alvinluo uploadImage session: %s, opImageType: %s, useCdnOpt: %s, useCache: %s, uploader: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(parame.OMG), Boolean.valueOf(parame.OML), Boolean.valueOf(parame.igs), localc });
      localc.a(locala, paramg);
    }
    AppMethodBeat.o(313692);
  }
  
  public final void cancel(long paramLong)
  {
    AppMethodBeat.i(313699);
    Log.i("MicroMsg.AiScanImageSceneUploader", "cancel");
    this.mnT.remove(Long.valueOf(paramLong));
    Object localObject = (c.a)this.rRp.remove(Long.valueOf(paramLong));
    if (localObject != null)
    {
      Log.v("MicroMsg.AiScanImageSceneUploader", "alvinluo cancelUploadImage");
      com.tencent.mm.kernel.h.aZW().cancel(((c.a)localObject).OQJ);
      localObject = ((c.a)localObject).OQI;
      if (localObject != null)
      {
        localObject = a((e)localObject);
        if (localObject != null) {
          ((c)localObject).tN(paramLong);
        }
      }
    }
    AppMethodBeat.o(313699);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(313719);
    int i;
    if ((paramp != null) && (paramp.getType() == 1100)) {
      i = 1;
    }
    f localf;
    String str;
    while (i != 0) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramp == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneAiScanImageScene");
          AppMethodBeat.o(313719);
          throw paramString;
          i = 0;
        }
        else
        {
          paramString = (j)paramp;
          if (c.c.b(paramString.rr.otC) != null)
          {
            paramString = c.c.b(paramString.rr.otC);
            if (paramString == null)
            {
              paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageSceneResponse");
              AppMethodBeat.o(313719);
              throw paramString;
            }
            paramString = (ny)paramString;
            if ((paramString == null) || (paramString.YPK != ((j)paramp).hBk)) {
              break label299;
            }
          }
          label299:
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 == 0) {
              break label304;
            }
            Log.d("MicroMsg.AiScanImageSceneUploader", "uploadImageForSearch onSceneEnd sessionId: %s, seqNum: %s", new Object[] { Long.valueOf(paramString.YPK), Integer.valueOf(paramString.YLL) });
            localf = new f();
            localf.OMG = 1;
            localf.hBk = paramString.YPK;
            localf.success = true;
            localf.errType = 0;
            localf.errCode = 0;
            localf.errMsg = "";
            localf.hAT = paramString.hMy;
            localf.jumpType = paramString.YPT;
            str = paramString.YQn;
            paramp = str;
            if (str == null) {
              paramp = "";
            }
            localf.OMO = paramp;
            a(this, paramString.YPK, localf);
            AppMethodBeat.o(313719);
            return;
            paramString = null;
            break;
          }
          label304:
          Log.w("MicroMsg.AiScanImageSceneUploader", "uploadImageForSearch onSceneEnd success sessionId not the same");
          AppMethodBeat.o(313719);
        }
      }
      else
      {
        paramp = (j)paramp;
        if (paramp == null) {}
        for (l = 0L;; l = paramp.hBk)
        {
          c(l, 1, paramInt1, paramInt2, paramString);
          AppMethodBeat.o(313719);
          return;
        }
      }
    }
    if ((paramp != null) && (paramp.getType() == 5079)) {
      i = 1;
    }
    while (i != 0) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramp == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneAiScanImageScenePreview");
          AppMethodBeat.o(313719);
          throw paramString;
          i = 0;
        }
        else
        {
          paramString = (k)paramp;
          if (c.c.b(paramString.rr.otC) != null)
          {
            paramString = c.c.b(paramString.rr.otC);
            if (paramString == null)
            {
              paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageScenePreviewResponse");
              AppMethodBeat.o(313719);
              throw paramString;
            }
            paramString = (nw)paramString;
            if ((paramString == null) || (paramString.YPK != ((k)paramp).hBk)) {
              break label636;
            }
          }
          label636:
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 == 0) {
              break label641;
            }
            Log.d("MicroMsg.AiScanImageSceneUploader", "previewImage onSceneEnd sessionId: %s, seqNum: %s", new Object[] { Long.valueOf(paramString.YPK), Integer.valueOf(paramString.YLL) });
            localf = new f();
            localf.OMG = 2;
            localf.hBk = paramString.YPK;
            localf.success = true;
            localf.errType = 0;
            localf.errCode = 0;
            localf.errMsg = "";
            str = paramString.YQf;
            paramp = str;
            if (str == null) {
              paramp = "";
            }
            localf.OMP = paramp;
            a(this, paramString.YPK, localf);
            AppMethodBeat.o(313719);
            return;
            paramString = null;
            break;
          }
          label641:
          Log.w("MicroMsg.AiScanImageSceneUploader", "previewImage onSceneEnd success sessionId not the same");
          AppMethodBeat.o(313719);
        }
      }
      else
      {
        paramp = (k)paramp;
        if (paramp == null) {}
        for (l = 0L;; l = paramp.hBk)
        {
          c(l, 2, paramInt1, paramInt2, paramString);
          AppMethodBeat.o(313719);
          return;
        }
      }
    }
    if ((paramp != null) && (paramp.getType() == 5131)) {
      i = 1;
    }
    while (i != 0) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramp == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.ocr.NetSceneBizImageOCR");
          AppMethodBeat.o(313719);
          throw paramString;
          i = 0;
        }
        else
        {
          paramString = (com.tencent.mm.plugin.scanner.f.i)paramp;
          if (c.c.b(paramString.rr.otC) != null)
          {
            paramString = c.c.b(paramString.rr.otC);
            if (paramString == null)
            {
              paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizOcrChatImageResponse");
              AppMethodBeat.o(313719);
              throw paramString;
            }
            paramString = (qf)paramString;
            if ((paramString == null) || (paramString.YPK != ((com.tencent.mm.plugin.scanner.f.i)paramp).hBk)) {
              break label986;
            }
          }
          label986:
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 == 0) {
              break label991;
            }
            Log.d("MicroMsg.AiScanImageSceneUploader", "uploadImageForOcr onSceneEnd sessionId: %s, seqNum: %s", new Object[] { Long.valueOf(paramString.YPK), Integer.valueOf(paramString.YLL) });
            paramp = new f();
            paramp.OMG = 3;
            paramp.hBk = paramString.YPK;
            paramp.success = true;
            paramp.errType = 0;
            paramp.errCode = 0;
            paramp.errMsg = "";
            paramp.hAT = paramString.hMy;
            paramp.hZD = paramString.YQb;
            paramp.OMQ = paramString.YVa;
            a(paramString.YPK, paramp, (kotlin.g.a.b)new d.b(paramp));
            AppMethodBeat.o(313719);
            return;
            paramString = null;
            break;
          }
          label991:
          Log.w("MicroMsg.AiScanImageSceneUploader", "uploadImageForOcr onSceneEnd success sessionId not the same");
          AppMethodBeat.o(313719);
        }
      }
      else
      {
        paramp = (com.tencent.mm.plugin.scanner.f.i)paramp;
        if (paramp != null) {
          break label1038;
        }
      }
    }
    label1038:
    for (long l = 0L;; l = paramp.hBk)
    {
      c(l, 3, paramInt1, paramInt2, paramString);
      AppMethodBeat.o(313719);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a.d
 * JD-Core Version:    0.7.0.1
 */