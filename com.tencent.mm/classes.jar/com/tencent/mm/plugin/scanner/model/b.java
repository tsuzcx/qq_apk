package com.tencent.mm.plugin.scanner.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;", "", "source", "", "callback", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "(ILcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;)V", "currentSession", "", "isCancelled", "", "isFinished", "runningRequest", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "scanResultCallback", "waitingRequest", "cancelResult", "", "session", "doHandleResult", "result", "Landroid/os/Bundle;", "finishResult", "success", "handleResult", "onError", "onScanFailed", "errCode", "errMsg", "", "onScanSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveTimeOut", "timeOut", "uploadImage", "frameId", "imageData", "", "originWidth", "originHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "usingAI", "isAiCrop", "uploadNext", "AiScanImageUploadCallback", "Companion", "RequestInfo", "plugin-scan_release"})
public final class b
{
  public static final b.b vOj;
  private int dep;
  private boolean goa;
  private boolean isCancelled;
  private long vOf;
  private final a vOg;
  private c vOh;
  private c vOi;
  
  static
  {
    AppMethodBeat.i(52157);
    vOj = new b.b((byte)0);
    AppMethodBeat.o(52157);
  }
  
  public b(int paramInt, a parama)
  {
    AppMethodBeat.i(52156);
    this.dep = paramInt;
    this.vOg = parama;
    AppMethodBeat.o(52156);
  }
  
  private final void a(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, GoodsObject paramGoodsObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(52153);
    ad.i("MicroMsg.AiScanImageUploader", "alvinluo uploadImage imageData: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    paramArrayOfByte = new d(paramArrayOfByte, paramInt2, paramLong, paramInt1, paramBoolean1, paramBoolean2, paramInt3, paramInt4, paramGoodsObject);
    paramGoodsObject = this.vOi;
    if (paramGoodsObject != null) {
      paramGoodsObject.vOk = ((n)paramArrayOfByte);
    }
    g.aeS().b((n)paramArrayOfByte);
    AppMethodBeat.o(52153);
  }
  
  private final void d(long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(52151);
    if (paramBundle == null)
    {
      AppMethodBeat.o(52151);
      return;
    }
    if (this.vOf != paramLong)
    {
      this.goa = false;
      this.vOf = paramLong;
    }
    int i = paramBundle.getInt("scan_source", 0);
    byte[] arrayOfByte = paramBundle.getByteArray("result_best_img");
    ad.i("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage doHandleResult session: %d, source: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
    if (i == 1)
    {
      int j = paramBundle.getInt("result_best_img_id", 0);
      int k = paramBundle.getInt("result_img_origin_width", 0);
      int m = paramBundle.getInt("result_img_origin_height", 0);
      GoodsObject localGoodsObject = new GoodsObject();
      try
      {
        localGoodsObject.parseFrom(paramBundle.getByteArray("result_crop_object"));
        if (arrayOfByte != null)
        {
          a(paramLong, j, arrayOfByte, i, k, m, localGoodsObject, s.isUsingAI(), s.isAICrop());
          AppMethodBeat.o(52151);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramBundle, "alvinluo handleResult cropObject parseFrom exception", new Object[0]);
        }
        onError();
        AppMethodBeat.o(52151);
        return;
      }
    }
    if (i == 2)
    {
      if (arrayOfByte != null)
      {
        a(this, paramLong, arrayOfByte, i);
        AppMethodBeat.o(52151);
        return;
      }
      onError();
      AppMethodBeat.o(52151);
      return;
    }
    onError();
    AppMethodBeat.o(52151);
  }
  
  private final void onError()
  {
    AppMethodBeat.i(52152);
    this.vOg.dlp();
    AppMethodBeat.o(52152);
  }
  
  public static void release()
  {
    AppMethodBeat.i(52150);
    ad.i("MicroMsg.AiScanImageUploader", "alvinluo release");
    AppMethodBeat.o(52150);
  }
  
  public final void c(long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(52147);
    if (paramBundle == null)
    {
      AppMethodBeat.o(52147);
      return;
    }
    int i = paramBundle.getInt("scan_source", 0);
    if (this.vOi != null)
    {
      localc = this.vOi;
      if ((localc == null) || (localc.goa != true)) {}
    }
    else
    {
      localc = new c();
      localc.dep = i;
      localc.dcQ = paramLong;
      localc.goa = false;
      localc.dow = paramBundle;
      this.vOi = localc;
      d(paramLong, paramBundle);
      AppMethodBeat.o(52147);
      return;
    }
    ad.i("MicroMsg.AiScanImageUploader", "alvinluo handleResult replace waiting request");
    if (this.vOh == null) {
      this.vOh = new c();
    }
    c localc = this.vOh;
    if (localc != null)
    {
      localc.dep = i;
      localc.dcQ = paramLong;
      localc.goa = false;
      localc.dow = paramBundle;
      AppMethodBeat.o(52147);
      return;
    }
    AppMethodBeat.o(52147);
  }
  
  public final void onSceneEnd(final int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(52155);
    int i;
    if (paramn != null)
    {
      if (paramn.getType() != 2580) {
        break label608;
      }
      i = 1;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label430;
      }
      paramString = (d)paramn;
      if (paramString.rr.auM() == null) {
        break label294;
      }
      paramString = paramString.rr.auM();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageResponse");
        AppMethodBeat.o(52155);
        throw paramString;
      }
    }
    else
    {
      AppMethodBeat.o(52155);
      return;
    }
    paramString = (ll)paramString;
    if ((paramString != null) && (paramString.CHb == ((d)paramn).dcQ))
    {
      ad.d("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd sessionId: %s, scanId: %s", new Object[] { Long.valueOf(paramString.CHb), Integer.valueOf(paramString.CHa) });
      paramInt1 = this.dep;
      ad.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, isFinished: %b, isCancelled: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(this.goa), Boolean.valueOf(this.isCancelled) });
      if ((this.goa) || (this.isCancelled))
      {
        ad.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess isFinished and ignore");
        paramInt1 = i;
      }
    }
    for (;;)
    {
      this.vOi = null;
      if (paramInt1 == 0) {
        break label608;
      }
      ad.d("MicroMsg.AiScanImageUploader", "alvinluo uploadNext: %b, isCancelled: %b", new Object[] { Boolean.valueOf(this.goa), Boolean.valueOf(this.isCancelled) });
      paramString = this.vOi;
      if (paramString != null) {
        paramString.goa = true;
      }
      this.vOi = null;
      if ((!this.goa) && (!this.isCancelled)) {
        break label527;
      }
      AppMethodBeat.o(52155);
      return;
      label294:
      paramString = null;
      break;
      if (this.vOi != null)
      {
        paramn = this.vOi;
        if ((paramn == null) || (paramn.goa != true)) {}
      }
      else
      {
        boolean bool;
        if (this.vOi == null)
        {
          bool = true;
          label336:
          paramString = this.vOi;
          if (paramString == null) {
            break label389;
          }
        }
        label389:
        for (paramString = Boolean.valueOf(paramString.goa);; paramString = null)
        {
          ad.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess runningRequest invalid and ignore isNull: %b, isFinished: %s", new Object[] { Boolean.valueOf(bool), paramString });
          paramInt1 = i;
          break;
          bool = false;
          break label336;
        }
      }
      s.a((t)new d(this, paramString, paramInt1));
      paramInt1 = i;
      continue;
      ad.w("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd success sessionId not the same");
      paramInt1 = i;
    }
    label430:
    if (paramInt2 == 1003) {}
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      long l;
      if ((!this.isCancelled) && (!this.goa))
      {
        i = this.dep;
        l = ((d)paramn).dcQ;
        ad.e("MicroMsg.AiScanImageUploader", "alvinluo onScanFailed source: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2), paramString });
        if (i == 1) {
          s.dlz();
        }
        this.vOg.b(i, l, paramInt2, paramString);
      }
      break;
      label527:
      if (this.vOh != null)
      {
        paramString = this.vOh;
        if (paramString == null) {
          k.fvU();
        }
        if (!paramString.goa)
        {
          this.vOi = this.vOh;
          paramString = this.vOh;
          if (paramString == null) {
            k.fvU();
          }
          l = paramString.dcQ;
          paramString = this.vOh;
          if (paramString == null) {
            k.fvU();
          }
          paramString = paramString.dow;
          this.vOh = null;
          d(l, paramString);
        }
      }
      label608:
      AppMethodBeat.o(52155);
      return;
    }
  }
  
  public final void rY(long paramLong)
  {
    AppMethodBeat.i(52149);
    ad.i("MicroMsg.AiScanImageUploader", "alvinluo cancelResult session: %d", new Object[] { Long.valueOf(paramLong) });
    q localq;
    if (this.vOf == paramLong)
    {
      this.isCancelled = true;
      localq = g.aeS();
      localObject = this.vOi;
      if (localObject == null) {
        break label81;
      }
    }
    label81:
    for (Object localObject = ((c)localObject).vOk;; localObject = null)
    {
      localq.a((n)localObject);
      this.vOh = null;
      this.vOi = null;
      AppMethodBeat.o(52149);
      return;
    }
  }
  
  public final void y(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(161972);
    ad.i("MicroMsg.AiScanImageUploader", "alvinluo finishResult current: %d, session: %d, success: %b", new Object[] { Long.valueOf(this.vOf), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    q localq;
    if (this.vOf == paramLong)
    {
      this.goa = true;
      localq = g.aeS();
      localObject = this.vOi;
      if (localObject == null) {
        break label103;
      }
    }
    label103:
    for (Object localObject = ((c)localObject).vOk;; localObject = null)
    {
      localq.a((n)localObject);
      this.vOh = null;
      this.vOi = null;
      AppMethodBeat.o(161972);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "", "onUploadError", "", "errCode", "", "onUploadFailed", "source", "session", "", "errMsg", "", "onUploadSuccess", "result", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(u paramu);
    
    public abstract void b(int paramInt1, long paramLong, int paramInt2, String paramString);
    
    public abstract void dlp();
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "", "(Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;)V", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "isFinished", "", "()Z", "setFinished", "(Z)V", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getNetScene", "()Lcom/tencent/mm/modelbase/NetSceneBase;", "setNetScene", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "session", "", "getSession", "()J", "setSession", "(J)V", "source", "", "getSource", "()I", "setSource", "(I)V", "plugin-scan_release"})
  final class c
  {
    long dcQ;
    int dep;
    Bundle dow;
    boolean goa;
    n vOk;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements t
  {
    d(b paramb, ll paramll, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(52146);
      aq.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52145);
          this.vOp.dep = this.vOo.vOn;
          ad.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, showResult: %b, isFinish: %b, isCancelled: %b", new Object[] { Integer.valueOf(this.vOo.vOn), Boolean.valueOf(this.vOp.vPd), Boolean.valueOf(b.a(this.vOo.vOl)), Boolean.valueOf(b.b(this.vOo.vOl)) });
          if ((!b.a(this.vOo.vOl)) && (!b.b(this.vOo.vOl))) {
            b.c(this.vOo.vOl).a(this.vOp);
          }
          AppMethodBeat.o(52145);
        }
      });
      AppMethodBeat.o(52146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.b
 * JD-Core Version:    0.7.0.1
 */