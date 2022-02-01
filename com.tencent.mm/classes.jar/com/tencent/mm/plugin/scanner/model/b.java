package com.tencent.mm.plugin.scanner.model;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.plugin.scanner.api.c;
import com.tencent.mm.plugin.scanner.api.d;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.util.p.a;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callbackMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "Lkotlin/collections/HashMap;", "requestMap", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader$ScanOpImageRequestWrapper;", "cancel", "", "session", "doUploadImage", "requestWrapper", "onFailedWrapper", "opImageType", "", "errType", "errCode", "errMsg", "", "onPreviewScanSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageScenePreviewResponse;", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSuccessWrapper", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onUploadScanSuccess", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSceneResponse;", "release", "uploadImage", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "callback", "Companion", "ScanOpImageRequestWrapper", "plugin-scan_release"})
public final class b
  implements com.tencent.mm.ak.f
{
  public static final b.a yCj;
  private HashMap<Long, e> gsk;
  private HashMap<Long, b> kMk;
  
  static
  {
    AppMethodBeat.i(189551);
    yCj = new b.a((byte)0);
    AppMethodBeat.o(189551);
  }
  
  public b()
  {
    AppMethodBeat.i(189550);
    this.kMk = new HashMap();
    this.gsk = new HashMap();
    com.tencent.mm.kernel.g.ajj().a(1100, (com.tencent.mm.ak.f)this);
    com.tencent.mm.kernel.g.ajj().a(5079, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(189550);
  }
  
  private final void b(final long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(189549);
    ae.e("MicroMsg.AiScanImageSceneUploader", "onScanFailed session: %d, errCode: %d, errMsg: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt3), paramString });
    d locald = new d();
    locald.yzN = paramInt1;
    locald.dmK = paramLong;
    locald.success = false;
    locald.errType = paramInt2;
    locald.errCode = paramInt3;
    locald.errMsg = paramString;
    h.MqF.aM((Runnable)new d(this, paramLong, locald));
    AppMethodBeat.o(189549);
  }
  
  private final void b(final long paramLong, d paramd)
  {
    AppMethodBeat.i(189548);
    h.MqF.aM((Runnable)new e(this, paramLong, paramd));
    AppMethodBeat.o(189548);
  }
  
  public final void a(final long paramLong, c paramc, e parame)
  {
    AppMethodBeat.i(189545);
    p.h(parame, "callback");
    if (paramc == null)
    {
      AppMethodBeat.o(189545);
      return;
    }
    ((Map)this.gsk).put(Long.valueOf(paramLong), parame);
    parame = (Map)this.kMk;
    b localb = new b();
    localb.yCk = paramc;
    parame.put(Long.valueOf(paramLong), localb);
    h.MqF.aQ((Runnable)new f(this, paramLong));
    AppMethodBeat.o(189545);
  }
  
  public final void cancel(long paramLong)
  {
    AppMethodBeat.i(189546);
    ae.i("MicroMsg.AiScanImageSceneUploader", "cancel");
    this.gsk.remove(Long.valueOf(paramLong));
    b localb = (b)this.kMk.remove(Long.valueOf(paramLong));
    if (localb != null)
    {
      int i = localb.yCl;
      com.tencent.mm.kernel.g.ajj().cancel(i);
      AppMethodBeat.o(189546);
      return;
    }
    AppMethodBeat.o(189546);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(189547);
    if ((paramn != null) && (paramn.getType() == 1100))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject2 = (f)paramn;
        paramString = (String)localObject1;
        if (((f)localObject2).rr.aEV() != null)
        {
          paramString = ((f)localObject2).rr.aEV();
          if (paramString == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageSceneResponse");
            AppMethodBeat.o(189547);
            throw paramString;
          }
          paramString = (mk)paramString;
        }
        if ((paramString != null) && (paramString.FXv == ((f)paramn).dmK))
        {
          ae.d("MicroMsg.AiScanImageSceneUploader", "uploadImage onSceneEnd sessionId: %s, seqNum: %s", new Object[] { Long.valueOf(paramString.FXv), Integer.valueOf(paramString.FTU) });
          localObject2 = new d();
          ((d)localObject2).yzN = 1;
          ((d)localObject2).dmK = paramString.FXv;
          ((d)localObject2).success = true;
          ((d)localObject2).errType = 0;
          ((d)localObject2).errCode = 0;
          ((d)localObject2).errMsg = "";
          ((d)localObject2).dmw = paramString.dwj;
          ((d)localObject2).jumpType = paramString.FXF;
          localObject1 = paramString.FXV;
          paramn = (n)localObject1;
          if (localObject1 == null) {
            paramn = "";
          }
          ((d)localObject2).yzR = paramn;
          b(paramString.FXv, (d)localObject2);
          AppMethodBeat.o(189547);
          return;
        }
        ae.w("MicroMsg.AiScanImageSceneUploader", "uploadImage onSceneEnd success sessionId not the same");
        AppMethodBeat.o(189547);
        return;
      }
      b(((f)paramn).dmK, 1, paramInt1, paramInt2, paramString);
      AppMethodBeat.o(189547);
      return;
    }
    if (paramn != null)
    {
      if (paramn.getType() != 5079) {
        break label565;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label537;
      }
      localObject1 = (g)paramn;
      paramString = (String)localObject2;
      if (((g)localObject1).rr.aEV() == null) {
        break label378;
      }
      paramString = ((g)localObject1).rr.aEV();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageScenePreviewResponse");
        AppMethodBeat.o(189547);
        throw paramString;
      }
    }
    else
    {
      AppMethodBeat.o(189547);
      return;
    }
    paramString = (mi)paramString;
    label378:
    if ((paramString != null) && (paramString.FXv == ((g)paramn).dmK))
    {
      ae.d("MicroMsg.AiScanImageSceneUploader", "previewImage onSceneEnd sessionId: %s, seqNum: %s", new Object[] { Long.valueOf(paramString.FXv), Integer.valueOf(paramString.FTU) });
      localObject2 = new d();
      ((d)localObject2).yzN = 2;
      ((d)localObject2).dmK = paramString.FXv;
      ((d)localObject2).success = true;
      ((d)localObject2).errType = 0;
      ((d)localObject2).errCode = 0;
      ((d)localObject2).errMsg = "";
      localObject1 = paramString.FXS;
      paramn = (n)localObject1;
      if (localObject1 == null) {
        paramn = "";
      }
      ((d)localObject2).yzS = paramn;
      b(paramString.FXv, (d)localObject2);
      AppMethodBeat.o(189547);
      return;
    }
    ae.w("MicroMsg.AiScanImageSceneUploader", "previewImage onSceneEnd success sessionId not the same");
    AppMethodBeat.o(189547);
    return;
    label537:
    long l;
    if ((paramn instanceof f)) {
      l = ((f)paramn).dmK;
    }
    for (;;)
    {
      b(l, 2, paramInt1, paramInt2, paramString);
      label565:
      AppMethodBeat.o(189547);
      return;
      if ((paramn instanceof g)) {
        l = ((g)paramn).dmK;
      } else {
        l = 0L;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader$ScanOpImageRequestWrapper;", "", "()V", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "getRequest", "()Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "setRequest", "(Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;)V", "sceneHashCode", "", "getSceneHashCode", "()I", "setSceneHashCode", "(I)V", "plugin-scan_release"})
  static final class b
  {
    c yCk;
    int yCl;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "sucess", "", "image", "", "kotlin.jvm.PlatformType", "onCompressEnd"})
  static final class c
    implements p.a
  {
    c(b paramb, c paramc, long paramLong, b.b paramb1) {}
    
    public final void a(boolean paramBoolean, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(189541);
      if ((paramBoolean) && (paramArrayOfByte != null))
      {
        int i = this.yCn.mode;
        Object localObject2;
        if (this.yCn.yzQ == null)
        {
          localObject1 = this.yCn;
          localObject2 = aa.yDM;
          localObject2 = this.yCn.imagePath;
          p.g(localObject2, "request.imagePath");
          ((c)localObject1).yzQ = aa.axW((String)localObject2);
        }
        int j = paramArrayOfByte.length;
        long l = this.yCo;
        Object localObject1 = this.yCn.yzQ;
        if (localObject1 != null)
        {
          localObject1 = ((ScanImagePHashInfo)localObject1).pHash;
          localObject2 = this.yCn.yzQ;
          if (localObject2 == null) {
            break label258;
          }
          localObject2 = ((ScanImagePHashInfo)localObject2).pHashVersion;
          label120:
          ae.i("MicroMsg.AiScanImageSceneUploader", "doUploadImage imageData: %d, session: %d, mode: %d, frameId: %d, pHash: %s, %s", new Object[] { Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(0), localObject1, localObject2 });
          if (this.yCn.yzN != 1) {
            break label264;
          }
          paramArrayOfByte = new f(paramArrayOfByte, this.yCo, i, this.yCn.yzO, this.yCn.yzP, this.yCn.yzQ);
        }
        for (;;)
        {
          paramArrayOfByte = (n)paramArrayOfByte;
          if (paramArrayOfByte == null) {
            break label302;
          }
          this.yCp.yCl = paramArrayOfByte.hashCode();
          com.tencent.mm.kernel.g.ajj().b(paramArrayOfByte);
          AppMethodBeat.o(189541);
          return;
          localObject1 = null;
          break;
          label258:
          localObject2 = null;
          break label120;
          label264:
          if (this.yCn.yzN == 2) {
            paramArrayOfByte = new g(this.yCo, this.yCn.yzQ);
          } else {
            paramArrayOfByte = null;
          }
        }
        label302:
        AppMethodBeat.o(189541);
        return;
      }
      b.a(this.yCm, this.yCo, this.yCn.yzN, "decode image failed");
      AppMethodBeat.o(189541);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(b paramb, long paramLong, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(189542);
      Object localObject = (b.b)b.a(this.yCm).remove(Long.valueOf(paramLong));
      if (localObject != null)
      {
        d locald = this.yCq;
        localObject = ((b.b)localObject).yCk;
        if (localObject != null)
        {
          String str = ((c)localObject).imagePath;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        locald.imagePath = ((String)localObject);
      }
      localObject = (e)b.b(this.yCm).remove(Long.valueOf(paramLong));
      if (localObject != null)
      {
        ((e)localObject).a(paramLong, this.yCq);
        AppMethodBeat.o(189542);
        return;
      }
      AppMethodBeat.o(189542);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(b paramb, long paramLong, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(189543);
      Object localObject = (b.b)b.a(this.yCm).remove(Long.valueOf(paramLong));
      if (localObject != null)
      {
        d locald = this.yCq;
        localObject = ((b.b)localObject).yCk;
        if (localObject != null)
        {
          String str = ((c)localObject).imagePath;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        locald.imagePath = ((String)localObject);
      }
      localObject = (e)b.b(this.yCm).remove(Long.valueOf(paramLong));
      ae.i("MicroMsg.AiScanImageSceneUploader", "onScanSuccess session: %d, callback: %s", new Object[] { Long.valueOf(paramLong), localObject });
      if (localObject != null)
      {
        ((e)localObject).a(paramLong, this.yCq);
        AppMethodBeat.o(189543);
        return;
      }
      AppMethodBeat.o(189543);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(b paramb, long paramLong) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(189544);
      Object localObject3 = (b.b)b.a(this.yCm).get(Long.valueOf(paramLong));
      if (localObject3 == null)
      {
        AppMethodBeat.o(189544);
        return;
      }
      if (((b.b)localObject3).yCk == null)
      {
        AppMethodBeat.o(189544);
        return;
      }
      Object localObject1 = ((b.b)localObject3).yCk;
      int i;
      label98:
      Object localObject4;
      if (localObject1 != null)
      {
        localObject1 = ((c)localObject1).imagePath;
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label217;
        }
        i = 1;
        if (i != 0)
        {
          localObject1 = ((b.b)localObject3).yCk;
          if (localObject1 == null) {
            p.gkB();
          }
          localObject4 = aa.yDM;
          localObject4 = ((b.b)localObject3).yCk;
          if (localObject4 == null) {
            break label222;
          }
        }
      }
      label217:
      label222:
      for (long l = ((c)localObject4).msgId;; l = 0L)
      {
        ((c)localObject1).imagePath = aa.A(l, true);
        localObject1 = ((b.b)localObject3).yCk;
        if ((localObject1 == null) || (((c)localObject1).yzN != 1))
        {
          localObject1 = ((b.b)localObject3).yCk;
          if ((localObject1 == null) || (((c)localObject1).yzN != 2)) {
            break label227;
          }
        }
        b.a(this.yCm, paramLong, (b.b)localObject3);
        AppMethodBeat.o(189544);
        return;
        localObject1 = null;
        break;
        i = 0;
        break label98;
      }
      label227:
      localObject3 = ((b.b)localObject3).yCk;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((c)localObject3).yzN);
      }
      ae.e("MicroMsg.AiScanImageSceneUploader", "alvinluo uploadImage unknown opImageType: %d", new Object[] { localObject1 });
      AppMethodBeat.o(189544);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.b
 * JD-Core Version:    0.7.0.1
 */