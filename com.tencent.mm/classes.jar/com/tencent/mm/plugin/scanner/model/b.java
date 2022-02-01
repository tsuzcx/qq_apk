package com.tencent.mm.plugin.scanner.model;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.c;
import com.tencent.mm.plugin.scanner.api.d;
import com.tencent.mm.plugin.scanner.c.a.b;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callbackMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/scanner/api/ScanUploadImageResultCallback;", "Lkotlin/collections/HashMap;", "requestMap", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader$ScanUploadImageRequestWrapper;", "cancel", "", "session", "doUploadImage", "requestWrapper", "onScanFailed", "errCode", "", "errMsg", "", "onScanSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSceneResponse;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "uploadImage", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanUploadImageRequest;", "callback", "Companion", "ScanUploadImageRequestWrapper", "plugin-scan_release"})
public final class b
  implements com.tencent.mm.al.f
{
  public static final b.a ymk;
  public HashMap<Long, d> gpP;
  public HashMap<Long, b> kIV;
  
  static
  {
    AppMethodBeat.i(186266);
    ymk = new b.a((byte)0);
    AppMethodBeat.o(186266);
  }
  
  public b()
  {
    AppMethodBeat.i(186265);
    this.kIV = new HashMap();
    this.gpP = new HashMap();
    g.aiU().a(1100, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(186265);
  }
  
  private final void f(final long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(186264);
    ad.e("MicroMsg.AiScanImageSceneUploader", "onScanFailed session: %d, errCode: %d, errMsg: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString });
    c localc = new c();
    localc.success = false;
    localc.errCode = paramInt;
    localc.errMsg = paramString;
    h.LTJ.aP((Runnable)new d(this, paramLong, localc));
    AppMethodBeat.o(186264);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(186263);
    if (paramn != null)
    {
      if (paramn.getType() != 1100) {
        break label270;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label256;
      }
      paramString = (f)paramn;
      if (paramString.rr.aEF() == null) {
        break label237;
      }
      paramString = paramString.rr.aEF();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageSceneResponse");
        AppMethodBeat.o(186263);
        throw paramString;
      }
    }
    else
    {
      AppMethodBeat.o(186263);
      return;
    }
    label237:
    for (paramString = (mi)paramString; (paramString != null) && (paramString.FFa == ((f)paramn).dlI); paramString = null)
    {
      ad.d("MicroMsg.AiScanImageSceneUploader", "uploadImage onSceneEnd sessionId: %s, seqNum: %s", new Object[] { Long.valueOf(paramString.FFa), Integer.valueOf(paramString.FBz) });
      final c localc = new c();
      localc.dlu = paramString.dve;
      localc.jumpType = paramString.FFk;
      String str = paramString.FFz;
      paramn = str;
      if (str == null) {
        paramn = "";
      }
      localc.yjT = paramn;
      localc.success = true;
      localc.errCode = 0;
      localc.errMsg = "";
      h.LTJ.aP((Runnable)new e(this, paramString, localc));
      AppMethodBeat.o(186263);
      return;
    }
    ad.w("MicroMsg.AiScanImageSceneUploader", "uploadImage onSceneEnd success sessionId not the same");
    AppMethodBeat.o(186263);
    return;
    label256:
    f(((f)paramn).dlI, paramInt2, paramString);
    label270:
    AppMethodBeat.o(186263);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader$ScanUploadImageRequestWrapper;", "", "()V", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanUploadImageRequest;", "getRequest", "()Lcom/tencent/mm/plugin/scanner/api/ScanUploadImageRequest;", "setRequest", "(Lcom/tencent/mm/plugin/scanner/api/ScanUploadImageRequest;)V", "sceneHashCode", "", "getSceneHashCode", "()I", "setSceneHashCode", "(I)V", "plugin-scan_release"})
  public static final class b
  {
    public com.tencent.mm.plugin.scanner.api.b yml;
    public int ymm;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "sucess", "", "image", "", "kotlin.jvm.PlatformType", "onCompressEnd"})
  static final class c
    implements a.b
  {
    c(b paramb, com.tencent.mm.plugin.scanner.api.b paramb1, long paramLong, b.b paramb2) {}
    
    public final void a(boolean paramBoolean, byte[] paramArrayOfByte)
    {
      String str = null;
      AppMethodBeat.i(186259);
      if ((paramBoolean) && (paramArrayOfByte != null))
      {
        int i = this.ymo.mode;
        Object localObject = z.ynN;
        localObject = this.ymo.imagePath;
        p.g(localObject, "request.imagePath");
        ScanImagePHashInfo localScanImagePHashInfo = z.awH((String)localObject);
        int j = paramArrayOfByte.length;
        long l = this.ymp;
        if (localScanImagePHashInfo != null) {}
        for (localObject = localScanImagePHashInfo.getPHash();; localObject = null)
        {
          if (localScanImagePHashInfo != null) {
            str = localScanImagePHashInfo.getPHashVersion();
          }
          ad.i("MicroMsg.AiScanImageSceneUploader", "doUploadImage imageData: %d, session: %d, mode: %d, frameId: %d, pHash: %s, %s", new Object[] { Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(0), localObject, str });
          paramArrayOfByte = new f(paramArrayOfByte, this.ymp, i, this.ymo.yjR, this.ymo.yjS, localScanImagePHashInfo);
          this.ymq.ymm = paramArrayOfByte.hashCode();
          g.aiU().b((n)paramArrayOfByte);
          AppMethodBeat.o(186259);
          return;
        }
      }
      b.a(this.ymn, this.ymp, "decode image failed");
      AppMethodBeat.o(186259);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(b paramb, long paramLong, c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(186260);
      Object localObject = (b.b)b.a(this.ymn).remove(Long.valueOf(paramLong));
      if (localObject != null)
      {
        c localc = this.ymr;
        localObject = ((b.b)localObject).yml;
        if (localObject != null)
        {
          String str = ((com.tencent.mm.plugin.scanner.api.b)localObject).imagePath;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localc.imagePath = ((String)localObject);
      }
      localObject = (d)b.b(this.ymn).remove(Long.valueOf(paramLong));
      if (localObject != null)
      {
        ((d)localObject).a(paramLong, this.ymr);
        AppMethodBeat.o(186260);
        return;
      }
      AppMethodBeat.o(186260);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(b paramb, mi parammi, c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(186261);
      Object localObject = (b.b)b.a(this.ymn).remove(Long.valueOf(paramString.FFa));
      if (localObject != null)
      {
        c localc = localc;
        localObject = ((b.b)localObject).yml;
        if (localObject != null)
        {
          String str = ((com.tencent.mm.plugin.scanner.api.b)localObject).imagePath;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localc.imagePath = ((String)localObject);
      }
      localObject = (d)b.b(this.ymn).remove(Long.valueOf(paramString.FFa));
      ad.i("MicroMsg.AiScanImageSceneUploader", "onScanSuccess session: %d, callback: %s", new Object[] { Long.valueOf(paramString.FFa), localObject });
      if (localObject != null)
      {
        ((d)localObject).a(paramString.FFa, localc);
        AppMethodBeat.o(186261);
        return;
      }
      AppMethodBeat.o(186261);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(b paramb, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(186262);
      b.b localb = (b.b)b.a(this.ymn).get(Long.valueOf(this.ymp));
      if (localb == null)
      {
        AppMethodBeat.o(186262);
        return;
      }
      if (localb.yml == null)
      {
        AppMethodBeat.o(186262);
        return;
      }
      com.tencent.mm.plugin.scanner.api.b localb1 = localb.yml;
      if (localb1 == null) {
        p.gfZ();
      }
      Object localObject = z.ynN;
      localObject = localb.yml;
      if (localObject != null) {}
      for (long l = ((com.tencent.mm.plugin.scanner.api.b)localObject).msgId;; l = 0L)
      {
        localb1.imagePath = z.yY(l);
        b.a(this.ymn, this.ymp, localb);
        AppMethodBeat.o(186262);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.b
 * JD-Core Version:    0.7.0.1
 */