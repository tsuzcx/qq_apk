package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.api.e.a;
import com.tencent.mm.plugin.scanner.util.f.a;
import com.tencent.mm.protocal.protobuf.na;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.protocal.protobuf.pa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.d.b.a.b;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.bn;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callbackMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "Lkotlin/collections/HashMap;", "cdnMediaMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "imageHandleCache", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader$ImageHandleResult;", "requestMap", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader$ScanOpImageRequestWrapper;", "cancel", "", "session", "doUploadImage", "requestWrapper", "onFailedWrapper", "opImageType", "", "errType", "errCode", "errMsg", "onPreviewScanSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageScenePreviewResponse;", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSuccessWrapper", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onUploadOcrSuccess", "Lcom/tencent/mm/protocal/protobuf/BizOcrChatImageResponse;", "onUploadScanSuccess", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSceneResponse;", "release", "uploadCdnImage", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "uploadImage", "callback", "Companion", "ImageHandleResult", "ScanOpImageRequestWrapper", "plugin-scan_release"})
public final class c
  implements com.tencent.mm.ak.i
{
  public static final c.a CEU;
  private final ConcurrentHashMap<String, b> CES;
  private final ConcurrentHashMap<Long, String> CET;
  private HashMap<Long, com.tencent.mm.plugin.scanner.api.g> hdu;
  private HashMap<Long, c> lQW;
  
  static
  {
    AppMethodBeat.i(240394);
    CEU = new c.a((byte)0);
    AppMethodBeat.o(240394);
  }
  
  public c()
  {
    AppMethodBeat.i(240393);
    this.lQW = new HashMap();
    this.hdu = new HashMap();
    this.CES = new ConcurrentHashMap();
    this.CET = new ConcurrentHashMap();
    com.tencent.mm.kernel.g.azz().a(1100, (com.tencent.mm.ak.i)this);
    com.tencent.mm.kernel.g.azz().a(5079, (com.tencent.mm.ak.i)this);
    com.tencent.mm.kernel.g.azz().a(5131, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(240393);
  }
  
  private final void b(final long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(240392);
    Log.e("MicroMsg.AiScanImageSceneUploader", "onScanFailed session: %d, errCode: %d, errMsg: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt3), paramString });
    com.tencent.mm.plugin.scanner.api.f localf = new com.tencent.mm.plugin.scanner.api.f();
    localf.CAT = paramInt1;
    localf.dDZ = paramLong;
    localf.success = false;
    localf.errType = paramInt2;
    localf.errCode = paramInt3;
    localf.errMsg = paramString;
    com.tencent.f.h.RTc.aV((Runnable)new e(this, paramLong, localf));
    AppMethodBeat.o(240392);
  }
  
  private final void b(final long paramLong, com.tencent.mm.plugin.scanner.api.f paramf)
  {
    AppMethodBeat.i(240391);
    com.tencent.f.h.RTc.aV((Runnable)new f(this, paramLong, paramf));
    AppMethodBeat.o(240391);
  }
  
  public final void a(final long paramLong, final e parame, com.tencent.mm.plugin.scanner.api.g paramg)
  {
    AppMethodBeat.i(240388);
    p.h(paramg, "callback");
    if (parame == null)
    {
      AppMethodBeat.o(240388);
      return;
    }
    ((Map)this.hdu).put(Long.valueOf(paramLong), paramg);
    paramg = (Map)this.lQW;
    c localc = new c();
    localc.CEZ = parame;
    paramg.put(Long.valueOf(paramLong), localc);
    Log.i("MicroMsg.AiScanImageSceneUploader", "alvinluo uploadImage session: %s, useCache: %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(parame.efT) });
    if ((parame.CAT == 1) || (parame.CAT == 3))
    {
      if (parame == null)
      {
        AppMethodBeat.o(240388);
        return;
      }
      paramg = new c();
      paramg.CEZ = parame;
      kotlinx.coroutines.f.b((ai)bn.TUK, null, (m)new g(this, parame, paramLong, paramg, null), 3);
      AppMethodBeat.o(240388);
      return;
    }
    com.tencent.f.h.RTc.aZ((Runnable)new h(this, paramLong));
    AppMethodBeat.o(240388);
  }
  
  public final void cancel(long paramLong)
  {
    AppMethodBeat.i(240389);
    Log.i("MicroMsg.AiScanImageSceneUploader", "cancel");
    this.hdu.remove(Long.valueOf(paramLong));
    Object localObject = (c)this.lQW.remove(Long.valueOf(paramLong));
    if (localObject != null)
    {
      int i = ((c)localObject).CFa;
      com.tencent.mm.kernel.g.azz().cancel(i);
    }
    localObject = (String)this.CET.remove(Long.valueOf(paramLong));
    if (localObject != null)
    {
      p.g(localObject, "mediaId");
      a.aMw((String)localObject);
      AppMethodBeat.o(240389);
      return;
    }
    AppMethodBeat.o(240389);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(240390);
    if ((paramq != null) && (paramq.getType() == 1100))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject2 = (h)paramq;
        paramString = (String)localObject1;
        if (((h)localObject2).rr.aYK() != null)
        {
          paramString = ((h)localObject2).rr.aYK();
          if (paramString == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageSceneResponse");
            AppMethodBeat.o(240390);
            throw paramString;
          }
          paramString = (nc)paramString;
        }
        if ((paramString != null) && (paramString.KRi == ((h)paramq).dDZ))
        {
          Log.d("MicroMsg.AiScanImageSceneUploader", "uploadImage onSceneEnd sessionId: %s, seqNum: %s", new Object[] { Long.valueOf(paramString.KRi), Integer.valueOf(paramString.KND) });
          localObject2 = new com.tencent.mm.plugin.scanner.api.f();
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).CAT = 1;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).dDZ = paramString.KRi;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).success = true;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).errType = 0;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).errCode = 0;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).errMsg = "";
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).dDL = paramString.dNQ;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).jumpType = paramString.KRs;
          localObject1 = paramString.KRM;
          paramq = (q)localObject1;
          if (localObject1 == null) {
            paramq = "";
          }
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).CBa = paramq;
          b(paramString.KRi, (com.tencent.mm.plugin.scanner.api.f)localObject2);
          AppMethodBeat.o(240390);
          return;
        }
        Log.w("MicroMsg.AiScanImageSceneUploader", "uploadImage onSceneEnd success sessionId not the same");
        AppMethodBeat.o(240390);
        return;
      }
      b(((h)paramq).dDZ, 1, paramInt1, paramInt2, paramString);
      AppMethodBeat.o(240390);
      return;
    }
    if ((paramq != null) && (paramq.getType() == 5079))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = (i)paramq;
        paramString = (String)localObject2;
        if (((i)localObject1).rr.aYK() != null)
        {
          paramString = ((i)localObject1).rr.aYK();
          if (paramString == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageScenePreviewResponse");
            AppMethodBeat.o(240390);
            throw paramString;
          }
          paramString = (na)paramString;
        }
        if ((paramString != null) && (paramString.KRi == ((i)paramq).dDZ))
        {
          Log.d("MicroMsg.AiScanImageSceneUploader", "previewImage onSceneEnd sessionId: %s, seqNum: %s", new Object[] { Long.valueOf(paramString.KRi), Integer.valueOf(paramString.KND) });
          localObject2 = new com.tencent.mm.plugin.scanner.api.f();
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).CAT = 2;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).dDZ = paramString.KRi;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).success = true;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).errType = 0;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).errCode = 0;
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).errMsg = "";
          localObject1 = paramString.KRF;
          paramq = (q)localObject1;
          if (localObject1 == null) {
            paramq = "";
          }
          ((com.tencent.mm.plugin.scanner.api.f)localObject2).CBb = paramq;
          b(paramString.KRi, (com.tencent.mm.plugin.scanner.api.f)localObject2);
          AppMethodBeat.o(240390);
          return;
        }
        Log.w("MicroMsg.AiScanImageSceneUploader", "previewImage onSceneEnd success sessionId not the same");
        AppMethodBeat.o(240390);
        return;
      }
      b(((i)paramq).dDZ, 2, paramInt1, paramInt2, paramString);
      AppMethodBeat.o(240390);
      return;
    }
    if (paramq != null)
    {
      if (paramq.getType() != 5131) {
        break label827;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label811;
      }
      paramString = (com.tencent.mm.plugin.scanner.e.f)paramq;
      if (paramString.rr.aYK() == null) {
        break label791;
      }
      paramString = paramString.rr.aYK();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizOcrChatImageResponse");
        AppMethodBeat.o(240390);
        throw paramString;
      }
    }
    else
    {
      AppMethodBeat.o(240390);
      return;
    }
    label791:
    for (paramString = (pa)paramString; (paramString != null) && (paramString.KRi == ((com.tencent.mm.plugin.scanner.e.f)paramq).dDZ); paramString = null)
    {
      Log.d("MicroMsg.AiScanImageSceneUploader", "previewImage onSceneEnd sessionId: %s, seqNum: %s", new Object[] { Long.valueOf(paramString.KRi), Integer.valueOf(paramString.KND) });
      paramq = new com.tencent.mm.plugin.scanner.api.f();
      paramq.CAT = 3;
      paramq.dDZ = paramString.KRi;
      paramq.success = true;
      paramq.errType = 0;
      paramq.errCode = 0;
      paramq.errMsg = "";
      paramq.dDL = paramString.dNQ;
      paramq.dZL = paramString.KRB;
      paramq.CBc = paramString.KVU;
      b(paramString.KRi, paramq);
      AppMethodBeat.o(240390);
      return;
    }
    Log.w("MicroMsg.AiScanImageSceneUploader", "uploadImageForOcr onSceneEnd success sessionId not the same");
    AppMethodBeat.o(240390);
    return;
    label811:
    b(((com.tencent.mm.plugin.scanner.e.f)paramq).dDZ, 3, paramInt1, paramInt2, paramString);
    label827:
    AppMethodBeat.o(240390);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader$ImageHandleResult;", "", "targetImagePath", "", "hashInfo", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "originWidth", "", "originHeight", "decodeResult", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "uploadResult", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;IILcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;)V", "getDecodeResult", "()Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "getHashInfo", "()Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "getOriginHeight", "()I", "getOriginWidth", "getTargetImagePath", "()Ljava/lang/String;", "getUploadResult", "()Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "plugin-scan_release"})
  public static final class b
  {
    final String CEV;
    final ScanImagePHashInfo CEW;
    final a.b CEX;
    final a.a CEY;
    private final int xlg;
    private final int xlh;
    
    public b(String paramString, ScanImagePHashInfo paramScanImagePHashInfo, int paramInt1, int paramInt2, a.b paramb, a.a parama)
    {
      this.CEV = paramString;
      this.CEW = paramScanImagePHashInfo;
      this.xlg = paramInt1;
      this.xlh = paramInt2;
      this.CEX = paramb;
      this.CEY = parama;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(240380);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.j(this.CEV, paramObject.CEV)) || (!p.j(this.CEW, paramObject.CEW)) || (this.xlg != paramObject.xlg) || (this.xlh != paramObject.xlh) || (!p.j(this.CEX, paramObject.CEX)) || (!p.j(this.CEY, paramObject.CEY))) {}
        }
      }
      else
      {
        AppMethodBeat.o(240380);
        return true;
      }
      AppMethodBeat.o(240380);
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      AppMethodBeat.i(240379);
      Object localObject = this.CEV;
      int i;
      int j;
      label42:
      int n;
      int i1;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.CEW;
        if (localObject == null) {
          break label129;
        }
        j = localObject.hashCode();
        n = this.xlg;
        i1 = this.xlh;
        localObject = this.CEX;
        if (localObject == null) {
          break label134;
        }
      }
      label129:
      label134:
      for (int k = localObject.hashCode();; k = 0)
      {
        localObject = this.CEY;
        if (localObject != null) {
          m = localObject.hashCode();
        }
        AppMethodBeat.o(240379);
        return (k + (((j + i * 31) * 31 + n) * 31 + i1) * 31) * 31 + m;
        i = 0;
        break;
        j = 0;
        break label42;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(240378);
      String str = "ImageHandleResult(targetImagePath=" + this.CEV + ", hashInfo=" + this.CEW + ", originWidth=" + this.xlg + ", originHeight=" + this.xlh + ", decodeResult=" + this.CEX + ", uploadResult=" + this.CEY + ")";
      AppMethodBeat.o(240378);
      return str;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader$ScanOpImageRequestWrapper;", "", "()V", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "getRequest", "()Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "setRequest", "(Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;)V", "sceneHashCode", "", "getSceneHashCode", "()I", "setSceneHashCode", "(I)V", "plugin-scan_release"})
  static final class c
  {
    e CEZ;
    int CFa;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "sucess", "", "image", "", "kotlin.jvm.PlatformType", "onCompressEnd"})
  static final class d
    implements f.a
  {
    d(c paramc, e parame, long paramLong, c.c paramc1) {}
    
    public final void a(boolean paramBoolean, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(240381);
      if ((paramBoolean) && (paramArrayOfByte != null))
      {
        int i = this.CFc.mode;
        Object localObject2;
        if (this.CFc.CAW == null)
        {
          localObject1 = this.CFc;
          localObject2 = ac.CGB;
          localObject2 = this.CFc.imagePath;
          p.g(localObject2, "request.imagePath");
          ((e)localObject1).CAW = ac.aMA((String)localObject2);
        }
        int j = paramArrayOfByte.length;
        long l = this.CFd;
        Object localObject1 = this.CFc.CAW;
        if (localObject1 != null)
        {
          localObject1 = ((ScanImagePHashInfo)localObject1).pHash;
          localObject2 = this.CFc.CAW;
          if (localObject2 == null) {
            break label265;
          }
          localObject2 = ((ScanImagePHashInfo)localObject2).pHashVersion;
          label120:
          Log.i("MicroMsg.AiScanImageSceneUploader", "doUploadImage imageData: %d, session: %d, mode: %d, frameId: %d, pHash: %s, %s", new Object[] { Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(0), localObject1, localObject2 });
          if (this.CFc.CAT != 1) {
            break label271;
          }
          paramArrayOfByte = new h(paramArrayOfByte, this.CFd, this.CFc.type, i, this.CFc.CAU, this.CFc.CAV, this.CFc.CAW);
        }
        for (;;)
        {
          paramArrayOfByte = (q)paramArrayOfByte;
          if (paramArrayOfByte == null) {
            break label346;
          }
          this.CFe.CFa = paramArrayOfByte.hashCode();
          com.tencent.mm.kernel.g.azz().b(paramArrayOfByte);
          AppMethodBeat.o(240381);
          return;
          localObject1 = null;
          break;
          label265:
          localObject2 = null;
          break label120;
          label271:
          if (this.CFc.CAT == 2) {
            paramArrayOfByte = new i(this.CFd, this.CFc.CAW);
          } else if (this.CFc.CAT == 3) {
            paramArrayOfByte = new com.tencent.mm.plugin.scanner.e.f(paramArrayOfByte, this.CFc.sessionId, this.CFc.source);
          } else {
            paramArrayOfByte = null;
          }
        }
        label346:
        AppMethodBeat.o(240381);
        return;
      }
      c.a(this.CFb, this.CFd, this.CFc.CAT, 3, 101, "decode image failed");
      AppMethodBeat.o(240381);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(c paramc, long paramLong, com.tencent.mm.plugin.scanner.api.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(240382);
      Object localObject = (c.c)c.a(this.CFb).remove(Long.valueOf(paramLong));
      if (localObject != null)
      {
        com.tencent.mm.plugin.scanner.api.f localf = this.CFf;
        localObject = ((c.c)localObject).CEZ;
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
      localObject = (com.tencent.mm.plugin.scanner.api.g)c.d(this.CFb).remove(Long.valueOf(paramLong));
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.scanner.api.g)localObject).a(paramLong, this.CFf);
        AppMethodBeat.o(240382);
        return;
      }
      AppMethodBeat.o(240382);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(c paramc, long paramLong, com.tencent.mm.plugin.scanner.api.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(240383);
      Object localObject2 = (c.c)c.a(this.CFb).remove(Long.valueOf(paramLong));
      Object localObject3;
      if (localObject2 != null)
      {
        com.tencent.mm.plugin.scanner.api.f localf = this.CFf;
        localObject1 = ((c.c)localObject2).CEZ;
        if (localObject1 != null)
        {
          localObject3 = ((e)localObject1).imagePath;
          localObject1 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localf.imagePath = ((String)localObject1);
      }
      for (Object localObject1 = localObject2;; localObject1 = null)
      {
        localObject2 = com.tencent.mm.plugin.scanner.e.a.CHU;
        long l = this.CFf.dDZ;
        localObject3 = new com.tencent.mm.plugin.scanner.e.a.a();
        if (localObject1 != null)
        {
          localObject1 = ((c.c)localObject1).CEZ;
          if (localObject1 != null)
          {
            localObject1 = ((e)localObject1).CAY;
            if (localObject1 != null)
            {
              localObject2 = ((e.a)localObject1).CAZ;
              localObject1 = localObject2;
              if (localObject2 != null) {
                break label135;
              }
            }
          }
        }
        localObject1 = "";
        label135:
        p.h(localObject1, "<set-?>");
        ((com.tencent.mm.plugin.scanner.e.a.a)localObject3).CAZ = ((String)localObject1);
        localObject2 = this.CFf.dZL;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        p.h(localObject1, "<set-?>");
        ((com.tencent.mm.plugin.scanner.e.a.a)localObject3).result = ((String)localObject1);
        com.tencent.mm.plugin.scanner.e.a.a(String.valueOf(l), (com.tencent.mm.plugin.scanner.e.a.a)localObject3);
        localObject1 = (com.tencent.mm.plugin.scanner.api.g)c.d(this.CFb).remove(Long.valueOf(paramLong));
        Log.i("MicroMsg.AiScanImageSceneUploader", "onScanSuccess session: %d, callback: %s", new Object[] { Long.valueOf(paramLong), localObject1 });
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.scanner.api.g)localObject1).a(paramLong, this.CFf);
        AppMethodBeat.o(240383);
        return;
      }
      AppMethodBeat.o(240383);
    }
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.scanner.model.AiScanImageSceneUploader$uploadCdnImage$1", f="AiScanImageSceneUploader.kt", hxM={165, 178}, m="invokeSuspend")
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class g
    extends j
    implements m<ai, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    Object pED;
    Object pEE;
    Object pEF;
    Object pEG;
    Object pEH;
    Object pEI;
    Object pEJ;
    
    g(c paramc, e parame, long paramLong, c.c paramc1, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240385);
      p.h(paramd, "completion");
      paramd = new g(this.CFb, parame, paramLong, this.CFe, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(240385);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(240386);
      paramObject1 = ((g)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(240386);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240384);
      kotlin.d.a.a locala = kotlin.d.a.a.SXO;
      Object localObject3;
      Object localObject1;
      Object localObject2;
      Object localObject4;
      label265:
      Object localObject5;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240384);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject3 = this.p$;
        paramObject = parame.imagePath;
        if ((paramObject != null) && (n.aL((CharSequence)paramObject) == true))
        {
          localObject1 = parame;
          paramObject = ac.CGB;
          long l = parame.msgId;
          paramObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(paramObject, "MMKernel.service(IMessengerStorage::class.java)");
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramObject).eiy().Hb(l);
          p.g(localObject2, "msg");
          if ((!((ca)localObject2).gAz()) && (!((ca)localObject2).gDr()))
          {
            paramObject = null;
            ((e)localObject1).imagePath = paramObject;
          }
        }
        else
        {
          localObject1 = parame.imagePath;
          paramObject = ac.CGB;
          paramObject = ac.G(parame.msgId, true);
          if (s.YS((String)localObject1)) {
            break label265;
          }
          Log.e("MicroMsg.AiScanImageSceneUploader", "image file not exist");
          paramObject = x.SXb;
          AppMethodBeat.o(240384);
          return paramObject;
        }
        paramObject = ac.d((ca)localObject2, true);
        localObject4 = (CharSequence)paramObject;
        if ((localObject4 == null) || (n.aL((CharSequence)localObject4))) {}
        for (int i = 1; i != 0; i = 0)
        {
          paramObject = ac.aN((ca)localObject2);
          break;
        }
        localObject4 = (c.b)c.b(this.CFb).get(localObject1);
        if ((!parame.efT) || (localObject4 == null) || (!s.YS(((c.b)localObject4).CEV)))
        {
          localObject2 = a.CEy;
          localObject2 = parame.imagePath;
          p.g(localObject2, "request.imagePath");
          this.L$0 = localObject3;
          this.pED = localObject1;
          this.pEE = paramObject;
          this.pEF = localObject4;
          this.label = 1;
          localObject2 = a.a((String)localObject2, this);
          if (localObject2 != locala) {
            break label1164;
          }
          AppMethodBeat.o(240384);
          return locala;
        }
        break;
      case 1: 
        localObject4 = (c.b)this.pEF;
        localObject2 = (String)this.pEE;
        localObject5 = (String)this.pED;
        localObject3 = (ai)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject5;
      }
      label1164:
      for (;;)
      {
        Object localObject6 = (a.b)localObject2;
        if (localObject6 != null) {}
        for (localObject2 = ((a.b)localObject6).CEz; localObject2 == null; localObject2 = null)
        {
          c.a(this.CFb, paramLong, parame.CAT, 3, 101, "decode image failed");
          paramObject = x.SXb;
          AppMethodBeat.o(240384);
          return paramObject;
        }
        String str = s.k((String)localObject2, false);
        localObject5 = a.CEy;
        if (str == null) {}
        for (localObject5 = "";; localObject5 = str)
        {
          localObject5 = a.aMv((String)localObject5);
          ((Map)c.c(this.CFb)).put(b.Pe(parame.sessionId), localObject5);
          this.L$0 = localObject3;
          this.pED = localObject1;
          this.pEE = paramObject;
          this.pEF = localObject4;
          this.pEG = localObject6;
          this.pEH = localObject2;
          this.pEI = str;
          this.pEJ = localObject5;
          this.label = 2;
          localObject5 = a.a(str, (String)localObject5, this);
          if (localObject5 == locala)
          {
            AppMethodBeat.o(240384);
            return locala;
            localObject2 = (String)this.pEH;
            localObject4 = (a.b)this.pEG;
            localObject1 = (String)this.pEE;
            localObject5 = (String)this.pED;
            ResultKt.throwOnFailure(paramObject);
            localObject3 = paramObject;
            paramObject = localObject5;
            localObject5 = localObject3;
            localObject3 = localObject4;
          }
          for (;;)
          {
            localObject5 = (a.a)localObject5;
            c.c(this.CFb).remove(b.Pe(parame.sessionId));
            if (((a.a)localObject5).errCode == 0)
            {
              localObject4 = ((a.a)localObject5).fileID;
              if ((localObject4 == null) || (n.aL((CharSequence)localObject4) != true)) {}
            }
            else
            {
              if (((a.a)localObject5).errCode == -1) {
                c.a(this.CFb, paramLong, parame.CAT, 4, 201, "upload cdn error");
              }
              for (;;)
              {
                paramObject = x.SXb;
                AppMethodBeat.o(240384);
                return paramObject;
                c.a(this.CFb, paramLong, parame.CAT, 3, 102, "cdn local error");
              }
            }
            parame.imagePath = ((String)localObject2);
            if ((parame.CAW == null) && (parame.CAX))
            {
              localObject6 = parame;
              localObject4 = ac.CGB;
              localObject4 = localObject1;
              if (localObject1 == null)
              {
                p.g(paramObject, "originImagePath");
                localObject4 = paramObject;
              }
              ((e)localObject6).CAW = ac.aMA((String)localObject4);
            }
            localObject1 = new c.b((String)localObject2, parame.CAW, ((a.b)localObject3).xlg, ((a.b)localObject3).xlh, (a.b)localObject3, (a.a)localObject5);
            localObject2 = (Map)c.b(this.CFb);
            p.g(paramObject, "originImagePath");
            ((Map)localObject2).put(paramObject, localObject1);
            paramObject = localObject1;
            parame.imagePath = paramObject.CEV;
            if (parame.CAT == 1)
            {
              paramObject = new h(null, paramLong, parame.type, parame.mode, parame.CAU, parame.CAV, paramObject.CEW, paramObject.CEX, paramObject.CEY);
              this.CFe.CFa = paramObject.hashCode();
              com.tencent.mm.kernel.g.azz().b((q)paramObject);
            }
            for (;;)
            {
              paramObject = x.SXb;
              AppMethodBeat.o(240384);
              return paramObject;
              Log.i("MicroMsg.AiScanImageSceneUploader", "hit cache");
              paramObject = localObject4;
              break;
              if (parame.CAT == 3)
              {
                paramObject = new com.tencent.mm.plugin.scanner.e.f(null, paramLong, parame.source, paramObject.CEX, paramObject.CEY);
                this.CFe.CFa = paramObject.hashCode();
                com.tencent.mm.kernel.g.azz().b((q)paramObject);
              }
            }
            localObject3 = localObject6;
            localObject4 = localObject1;
            localObject1 = paramObject;
            paramObject = localObject4;
          }
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(c paramc, long paramLong) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(240387);
      Object localObject3 = (c.c)c.a(this.CFb).get(Long.valueOf(paramLong));
      if (localObject3 == null)
      {
        AppMethodBeat.o(240387);
        return;
      }
      if (((c.c)localObject3).CEZ == null)
      {
        AppMethodBeat.o(240387);
        return;
      }
      Object localObject1 = ((c.c)localObject3).CEZ;
      int i;
      label98:
      Object localObject4;
      if (localObject1 != null)
      {
        localObject1 = ((e)localObject1).imagePath;
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label196;
        }
        i = 1;
        if (i != 0)
        {
          localObject1 = ((c.c)localObject3).CEZ;
          if (localObject1 == null) {
            p.hyc();
          }
          localObject4 = ac.CGB;
          localObject4 = ((c.c)localObject3).CEZ;
          if (localObject4 == null) {
            break label201;
          }
        }
      }
      label196:
      label201:
      for (long l = ((e)localObject4).msgId;; l = 0L)
      {
        ((e)localObject1).imagePath = ac.G(l, true);
        localObject1 = ((c.c)localObject3).CEZ;
        if ((localObject1 == null) || (((e)localObject1).CAT != 2)) {
          break label206;
        }
        c.a(this.CFb, paramLong, (c.c)localObject3);
        AppMethodBeat.o(240387);
        return;
        localObject1 = null;
        break;
        i = 0;
        break label98;
      }
      label206:
      localObject3 = ((c.c)localObject3).CEZ;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((e)localObject3).CAT);
      }
      Log.e("MicroMsg.AiScanImageSceneUploader", "alvinluo uploadImage unknown opImageType: %d", new Object[] { localObject1 });
      AppMethodBeat.o(240387);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.c
 * JD-Core Version:    0.7.0.1
 */