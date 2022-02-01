package com.tencent.mm.plugin.scanner.model;

import android.os.Bundle;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.lq;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;", "", "source", "", "callback", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "(ILcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;)V", "currentSession", "", "isCancelled", "", "isFinished", "runningRequest", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "scanResultCallback", "waitingRequest", "cancelResult", "", "session", "doHandleResult", "result", "Landroid/os/Bundle;", "finishResult", "success", "getAdInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "handleResult", "onError", "onScanFailed", "errCode", "errMsg", "", "onScanSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveTimeOut", "timeOut", "uploadImage", "frameId", "imageData", "", "mode", "originWidth", "originHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "usingAI", "isAiCrop", "adInfo", "uploadNext", "AiScanImageUploadCallback", "Companion", "RequestInfo", "plugin-scan_release"})
public final class b
{
  public static final b.b wYF;
  private int dbL;
  private boolean gnd;
  private boolean isCancelled;
  private long wYB;
  private final a wYC;
  private c wYD;
  private c wYE;
  
  static
  {
    AppMethodBeat.i(52157);
    wYF = new b.b((byte)0);
    AppMethodBeat.o(52157);
  }
  
  public b(int paramInt, a parama)
  {
    AppMethodBeat.i(52156);
    this.dbL = paramInt;
    this.wYC = parama;
    AppMethodBeat.o(52156);
  }
  
  private final void a(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5, GoodsObject paramGoodsObject, boolean paramBoolean1, boolean paramBoolean2, lq paramlq)
  {
    AppMethodBeat.i(199580);
    ac.i("MicroMsg.AiScanImageUploader", "alvinluo uploadImage imageData: %d, mode: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt2) });
    paramArrayOfByte = new d(paramArrayOfByte, paramInt3, paramInt2, paramLong, paramInt1, paramBoolean1, paramBoolean2, paramInt4, paramInt5, paramGoodsObject, paramlq);
    paramGoodsObject = this.wYE;
    if (paramGoodsObject != null) {
      paramGoodsObject.wYG = ((n)paramArrayOfByte);
    }
    g.agi().b((n)paramArrayOfByte);
    AppMethodBeat.o(199580);
  }
  
  private static lq ah(Bundle paramBundle)
  {
    AppMethodBeat.i(199582);
    if (paramBundle == null)
    {
      AppMethodBeat.o(199582);
      return null;
    }
    try
    {
      paramBundle = (ScanGoodsRequest)paramBundle.getParcelable("key_scan_request");
      lq locallq = new lq();
      if ((paramBundle instanceof ScanGoodsRequest))
      {
        locallq.xID = paramBundle.iN("key_sns_ad_ux_info", "");
        locallq.DZv = bs.aLy(paramBundle.iN("key_gesture_id", ""));
        ac.d("MicroMsg.AiScanImageUploader", "getAdInfo uxInfo: %s, gestureId: %s", new Object[] { locallq.xID, Integer.valueOf(locallq.DZv) });
      }
      AppMethodBeat.o(199582);
      return locallq;
    }
    catch (Exception paramBundle)
    {
      ac.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramBundle, "getAdInfo exception", new Object[0]);
      AppMethodBeat.o(199582);
    }
    return null;
  }
  
  private final void d(long paramLong, Bundle paramBundle)
  {
    AppMethodBeat.i(52151);
    if (paramBundle == null)
    {
      AppMethodBeat.o(52151);
      return;
    }
    if (this.wYB != paramLong)
    {
      this.gnd = false;
      this.wYB = paramLong;
    }
    int i = paramBundle.getInt("scan_source", 0);
    byte[] arrayOfByte = paramBundle.getByteArray("result_best_img");
    int j = paramBundle.getInt("key_scan_goods_mode", 0);
    ac.i("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage doHandleResult session: %d, source: %d, mode: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(j) });
    if (i == 1)
    {
      int k = paramBundle.getInt("result_best_img_id", 0);
      int m = paramBundle.getInt("result_img_origin_width", 0);
      int n = paramBundle.getInt("result_img_origin_height", 0);
      GoodsObject localGoodsObject = new GoodsObject();
      try
      {
        localGoodsObject.parseFrom(paramBundle.getByteArray("result_crop_object"));
        if (arrayOfByte != null)
        {
          a(paramLong, k, arrayOfByte, j, i, m, n, localGoodsObject, s.isUsingAI(), s.isAICrop(), ah(paramBundle));
          AppMethodBeat.o(52151);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)localException, "alvinluo handleResult cropObject parseFrom exception", new Object[0]);
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
        a(this, paramLong, arrayOfByte, j, i);
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
    this.wYC.dzr();
    AppMethodBeat.o(52152);
  }
  
  public static void release()
  {
    AppMethodBeat.i(52150);
    ac.i("MicroMsg.AiScanImageUploader", "alvinluo release");
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
    if (this.wYE != null)
    {
      localc = this.wYE;
      if ((localc == null) || (localc.gnd != true)) {}
    }
    else
    {
      localc = new c();
      localc.dbL = i;
      localc.dao = paramLong;
      localc.gnd = false;
      localc.dmf = paramBundle;
      this.wYE = localc;
      d(paramLong, paramBundle);
      AppMethodBeat.o(52147);
      return;
    }
    ac.i("MicroMsg.AiScanImageUploader", "alvinluo handleResult replace waiting request");
    if (this.wYD == null) {
      this.wYD = new c();
    }
    c localc = this.wYD;
    if (localc != null)
    {
      localc.dbL = i;
      localc.dao = paramLong;
      localc.gnd = false;
      localc.dmf = paramBundle;
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
      if (paramString.rr.aBD() == null) {
        break label294;
      }
      paramString = paramString.rr.aBD();
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
    paramString = (ls)paramString;
    if ((paramString != null) && (paramString.DZC == ((d)paramn).dao))
    {
      ac.d("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd sessionId: %s, scanId: %s", new Object[] { Long.valueOf(paramString.DZC), Integer.valueOf(paramString.DZB) });
      paramInt1 = this.dbL;
      ac.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, isFinished: %b, isCancelled: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(this.gnd), Boolean.valueOf(this.isCancelled) });
      if ((this.gnd) || (this.isCancelled))
      {
        ac.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess isFinished and ignore");
        paramInt1 = i;
      }
    }
    for (;;)
    {
      this.wYE = null;
      if (paramInt1 == 0) {
        break label608;
      }
      ac.d("MicroMsg.AiScanImageUploader", "alvinluo uploadNext: %b, isCancelled: %b", new Object[] { Boolean.valueOf(this.gnd), Boolean.valueOf(this.isCancelled) });
      paramString = this.wYE;
      if (paramString != null) {
        paramString.gnd = true;
      }
      this.wYE = null;
      if ((!this.gnd) && (!this.isCancelled)) {
        break label527;
      }
      AppMethodBeat.o(52155);
      return;
      label294:
      paramString = null;
      break;
      if (this.wYE != null)
      {
        paramn = this.wYE;
        if ((paramn == null) || (paramn.gnd != true)) {}
      }
      else
      {
        boolean bool;
        if (this.wYE == null)
        {
          bool = true;
          label336:
          paramString = this.wYE;
          if (paramString == null) {
            break label389;
          }
        }
        label389:
        for (paramString = Boolean.valueOf(paramString.gnd);; paramString = null)
        {
          ac.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess runningRequest invalid and ignore isNull: %b, isFinished: %s", new Object[] { Boolean.valueOf(bool), paramString });
          paramInt1 = i;
          break;
          bool = false;
          break label336;
        }
      }
      s.a((t)new d(this, paramString, paramInt1));
      paramInt1 = i;
      continue;
      ac.w("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd success sessionId not the same");
      paramInt1 = i;
    }
    label430:
    if (paramInt2 == 1003) {}
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      long l;
      if ((!this.isCancelled) && (!this.gnd))
      {
        i = this.dbL;
        l = ((d)paramn).dao;
        ac.e("MicroMsg.AiScanImageUploader", "alvinluo onScanFailed source: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2), paramString });
        if (i == 1) {
          s.dzB();
        }
        this.wYC.a(i, l, paramInt2, paramString);
      }
      break;
      label527:
      if (this.wYD != null)
      {
        paramString = this.wYD;
        if (paramString == null) {
          k.fOy();
        }
        if (!paramString.gnd)
        {
          this.wYE = this.wYD;
          paramString = this.wYD;
          if (paramString == null) {
            k.fOy();
          }
          l = paramString.dao;
          paramString = this.wYD;
          if (paramString == null) {
            k.fOy();
          }
          paramString = paramString.dmf;
          this.wYD = null;
          d(l, paramString);
        }
      }
      label608:
      AppMethodBeat.o(52155);
      return;
    }
  }
  
  public final void wB(long paramLong)
  {
    AppMethodBeat.i(52149);
    ac.i("MicroMsg.AiScanImageUploader", "alvinluo cancelResult session: %d", new Object[] { Long.valueOf(paramLong) });
    q localq;
    if (this.wYB == paramLong)
    {
      this.isCancelled = true;
      localq = g.agi();
      localObject = this.wYE;
      if (localObject == null) {
        break label81;
      }
    }
    label81:
    for (Object localObject = ((c)localObject).wYG;; localObject = null)
    {
      localq.a((n)localObject);
      this.wYD = null;
      this.wYE = null;
      AppMethodBeat.o(52149);
      return;
    }
  }
  
  public final void y(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(161972);
    ac.i("MicroMsg.AiScanImageUploader", "alvinluo finishResult current: %d, session: %d, success: %b", new Object[] { Long.valueOf(this.wYB), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    q localq;
    if (this.wYB == paramLong)
    {
      this.gnd = true;
      localq = g.agi();
      localObject = this.wYE;
      if (localObject == null) {
        break label103;
      }
    }
    label103:
    for (Object localObject = ((c)localObject).wYG;; localObject = null)
    {
      localq.a((n)localObject);
      this.wYD = null;
      this.wYE = null;
      AppMethodBeat.o(161972);
      return;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "", "onUploadError", "", "errCode", "", "onUploadFailed", "source", "session", "", "errMsg", "", "onUploadSuccess", "result", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, long paramLong, int paramInt2, String paramString);
    
    public abstract void a(u paramu);
    
    public abstract void dzr();
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "", "(Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;)V", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "isFinished", "", "()Z", "setFinished", "(Z)V", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getNetScene", "()Lcom/tencent/mm/modelbase/NetSceneBase;", "setNetScene", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "session", "", "getSession", "()J", "setSession", "(J)V", "source", "", "getSource", "()I", "setSource", "(I)V", "plugin-scan_release"})
  final class c
  {
    long dao;
    int dbL;
    Bundle dmf;
    boolean gnd;
    n wYG;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements t
  {
    d(b paramb, ls paramls, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(52146);
      final u localu = s.a(paramString, paramInt1);
      h.JZN.aQ((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52145);
          localu.dbL = this.wYK.wYJ;
          ac.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, showResult: %b, isFinish: %b, isCancelled: %b", new Object[] { Integer.valueOf(this.wYK.wYJ), Boolean.valueOf(localu.wZz), Boolean.valueOf(b.a(this.wYK.wYH)), Boolean.valueOf(b.b(this.wYK.wYH)) });
          if ((!b.a(this.wYK.wYH)) && (!b.b(this.wYK.wYH))) {
            b.c(this.wYK.wYH).a(localu);
          }
          AppMethodBeat.o(52145);
        }
      });
      AppMethodBeat.o(52146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.b
 * JD-Core Version:    0.7.0.1
 */