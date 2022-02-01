package com.tencent.mm.plugin.scanner.model;

import android.os.Bundle;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.ma;
import com.tencent.mm.protocal.protobuf.mb;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;", "", "source", "", "callback", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "(ILcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;)V", "count", "currentSession", "", "isCancelled", "", "isFinished", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "needLocation", "runningRequest", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "scanResultCallback", "waitingRequest", "cancelResult", "", "session", "doHandleResult", "result", "Landroid/os/Bundle;", "finishResult", "success", "getAdInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "getJsApiInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;", "getScanGoodsRequest", "handleResult", "notifyEvent", "event", "onError", "onScanFailed", "errCode", "errMsg", "", "onScanSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveTimeOut", "timeOut", "setLocation", "location", "uploadImage", "frameId", "imageData", "", "mode", "requestType", "originWidth", "originHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "usingAI", "isAiCrop", "adInfo", "jsApiInfo", "uploadNext", "AiScanImageUploadCallback", "Companion", "Event", "RequestInfo", "plugin-scan_release"})
public final class c
{
  public static final c.b ymx;
  private int dnh;
  private boolean gGM;
  private boolean isCancelled;
  private boolean owX;
  public mc yjS;
  private long ymt;
  private final a ymu;
  private c ymv;
  private c ymw;
  
  static
  {
    AppMethodBeat.i(52157);
    ymx = new c.b((byte)0);
    AppMethodBeat.o(52157);
  }
  
  public c(int paramInt, a parama)
  {
    AppMethodBeat.i(52156);
    this.dnh = paramInt;
    this.ymu = parama;
    AppMethodBeat.o(52156);
  }
  
  private static ma a(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(186272);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(186272);
      return null;
    }
    try
    {
      ma localma = new ma();
      localma.yXS = paramScanGoodsRequest.getExtra("key_sns_ad_ux_info", "");
      localma.FER = bt.aRe(paramScanGoodsRequest.getExtra("key_gesture_id", ""));
      ad.d("MicroMsg.AiScanImageUploader", "getAdInfo uxInfo: %s, gestureId: %s", new Object[] { localma.yXS, Integer.valueOf(localma.FER) });
      AppMethodBeat.o(186272);
      return localma;
    }
    catch (Exception paramScanGoodsRequest)
    {
      ad.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramScanGoodsRequest, "getAdInfo exception", new Object[0]);
      AppMethodBeat.o(186272);
    }
    return null;
  }
  
  private final void a(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, GoodsObject paramGoodsObject, boolean paramBoolean1, boolean paramBoolean2, ma paramma, mb parammb, mc parammc)
  {
    AppMethodBeat.i(186269);
    ad.i("MicroMsg.AiScanImageUploader", "alvinluo uploadImage imageData: %d, mode: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt2) });
    paramArrayOfByte = new e(paramArrayOfByte, paramInt4, paramInt2, paramInt3, paramLong, paramInt1, paramBoolean1, paramBoolean2, paramInt5, paramInt6, paramGoodsObject, paramma, parammb, parammc);
    paramGoodsObject = this.ymw;
    if (paramGoodsObject != null) {
      paramGoodsObject.ymy = ((n)paramArrayOfByte);
    }
    g.aiU().b((n)paramArrayOfByte);
    AppMethodBeat.o(186269);
  }
  
  private static ScanGoodsRequest ak(Bundle paramBundle)
  {
    AppMethodBeat.i(186271);
    if (paramBundle == null)
    {
      AppMethodBeat.o(186271);
      return null;
    }
    try
    {
      paramBundle = (ScanGoodsRequest)paramBundle.getParcelable("key_scan_request");
      AppMethodBeat.o(186271);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      ad.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramBundle, "getScanGoodsRequest exception", new Object[0]);
      AppMethodBeat.o(186271);
    }
    return null;
  }
  
  private static mb b(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(186273);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(186273);
      return null;
    }
    try
    {
      mb localmb = new mb();
      localmb.FES = paramScanGoodsRequest.extInfo;
      ad.d("MicroMsg.AiScanImageUploader", "getJsApiInfo %s", new Object[] { localmb.FES });
      AppMethodBeat.o(186273);
      return localmb;
    }
    catch (Exception paramScanGoodsRequest)
    {
      ad.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramScanGoodsRequest, "getJsApiInfo exception", new Object[0]);
      AppMethodBeat.o(186273);
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
    if (this.ymt != paramLong)
    {
      this.gGM = false;
      this.ymt = paramLong;
    }
    int j = paramBundle.getInt("scan_source", 0);
    byte[] arrayOfByte = paramBundle.getByteArray("result_best_img");
    int k = paramBundle.getInt("key_scan_goods_mode", 0);
    ScanGoodsRequest localScanGoodsRequest = ak(paramBundle);
    mb localmb = b(localScanGoodsRequest);
    int i;
    if (localScanGoodsRequest != null) {
      i = localScanGoodsRequest.requestType;
    }
    for (;;)
    {
      ad.i("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage doHandleResult session: %d, source: %d, mode: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(j), Integer.valueOf(k) });
      if (j == 1)
      {
        int m = paramBundle.getInt("result_best_img_id", 0);
        int n = paramBundle.getInt("result_img_origin_width", 0);
        int i1 = paramBundle.getInt("result_img_origin_height", 0);
        GoodsObject localGoodsObject = new GoodsObject();
        try
        {
          localGoodsObject.parseFrom(paramBundle.getByteArray("result_crop_object"));
          if (arrayOfByte != null)
          {
            paramBundle = a(localScanGoodsRequest);
            a(paramLong, m, arrayOfByte, k, i, j, n, i1, localGoodsObject, u.isUsingAI(), u.isAICrop(), paramBundle, localmb, this.yjS);
            AppMethodBeat.o(52151);
            return;
            i = 0;
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
    }
    if (j == 2)
    {
      if (arrayOfByte != null)
      {
        a(this, paramLong, arrayOfByte, k, i, j, localmb);
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
    this.ymu.dKP();
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
    if (this.ymw != null)
    {
      localc = this.ymw;
      if ((localc == null) || (localc.gGM != true)) {}
    }
    else
    {
      localc = new c();
      localc.dnh = i;
      localc.dlI = paramLong;
      localc.gGM = false;
      localc.dxT = paramBundle;
      this.ymw = localc;
      d(paramLong, paramBundle);
      AppMethodBeat.o(52147);
      return;
    }
    ad.i("MicroMsg.AiScanImageUploader", "alvinluo handleResult replace waiting request");
    if (this.ymv == null) {
      this.ymv = new c();
    }
    c localc = this.ymv;
    if (localc != null)
    {
      localc.dnh = i;
      localc.dlI = paramLong;
      localc.gGM = false;
      localc.dxT = paramBundle;
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
        break label718;
      }
      i = 1;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label540;
      }
      paramString = (e)paramn;
      if (paramString.rr.aEF() == null) {
        break label355;
      }
      paramString = paramString.rr.aEF();
      if (paramString == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageResponse");
        AppMethodBeat.o(52155);
        throw paramString;
      }
    }
    else
    {
      AppMethodBeat.o(52155);
      return;
    }
    paramString = (me)paramString;
    long l;
    if ((paramString != null) && (paramString.FFr == true) && (paramString.FFr != this.owX))
    {
      this.owX = true;
      paramInt1 = this.dnh;
      l = paramString.FFa;
      if ((this.gGM) || (this.isCancelled)) {
        ad.w("MicroMsg.AiScanImageUploader", "alvinluo notifyEvent isFinished and ignore");
      }
    }
    else
    {
      label153:
      if ((paramString == null) || (paramString.FFa != ((e)paramn).dlI)) {
        break label526;
      }
      ad.d("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd sessionId: %s, scanId: %s", new Object[] { Long.valueOf(paramString.FFa), Integer.valueOf(paramString.FEZ) });
      paramInt1 = this.dnh;
      ad.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, isFinished: %b, isCancelled: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(this.gGM), Boolean.valueOf(this.isCancelled) });
      if ((!this.gGM) && (!this.isCancelled)) {
        break label409;
      }
      ad.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess isFinished and ignore");
      paramInt1 = i;
    }
    for (;;)
    {
      this.ymw = null;
      if (paramInt1 == 0) {
        break label718;
      }
      ad.d("MicroMsg.AiScanImageUploader", "alvinluo uploadNext: %b, isCancelled: %b", new Object[] { Boolean.valueOf(this.gGM), Boolean.valueOf(this.isCancelled) });
      paramString = this.ymw;
      if (paramString != null) {
        paramString.gGM = true;
      }
      this.ymw = null;
      if ((!this.gGM) && (!this.isCancelled)) {
        break label637;
      }
      AppMethodBeat.o(52155);
      return;
      label355:
      paramString = null;
      break;
      ad.d("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage notifyEvent source: %d, session: %d, event: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l), Integer.valueOf(1) });
      this.ymu.av(paramInt1, l);
      break label153;
      label409:
      if (this.ymw != null)
      {
        paramn = this.ymw;
        if ((paramn == null) || (paramn.gGM != true)) {}
      }
      else
      {
        boolean bool;
        if (this.ymw == null)
        {
          bool = true;
          label446:
          paramString = this.ymw;
          if (paramString == null) {
            break label499;
          }
        }
        label499:
        for (paramString = Boolean.valueOf(paramString.gGM);; paramString = null)
        {
          ad.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess runningRequest invalid and ignore isNull: %b, isFinished: %s", new Object[] { Boolean.valueOf(bool), paramString });
          paramInt1 = i;
          break;
          bool = false;
          break label446;
        }
      }
      u.a((v)new d(this, paramString, paramInt1));
      paramInt1 = i;
      continue;
      label526:
      ad.w("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd success sessionId not the same");
      paramInt1 = i;
    }
    label540:
    if (paramInt2 == 1003) {}
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if ((!this.isCancelled) && (!this.gGM))
      {
        i = this.dnh;
        l = ((e)paramn).dlI;
        ad.e("MicroMsg.AiScanImageUploader", "alvinluo onScanFailed source: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2), paramString });
        if (i == 1) {
          u.dLb();
        }
        this.ymu.a(i, l, paramInt2, paramString);
      }
      break;
      label637:
      if (this.ymv != null)
      {
        paramString = this.ymv;
        if (paramString == null) {
          p.gfZ();
        }
        if (!paramString.gGM)
        {
          this.ymw = this.ymv;
          paramString = this.ymv;
          if (paramString == null) {
            p.gfZ();
          }
          l = paramString.dlI;
          paramString = this.ymv;
          if (paramString == null) {
            p.gfZ();
          }
          paramString = paramString.dxT;
          this.ymv = null;
          d(l, paramString);
        }
      }
      label718:
      AppMethodBeat.o(52155);
      return;
    }
  }
  
  public final void y(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(161972);
    ad.i("MicroMsg.AiScanImageUploader", "alvinluo finishResult current: %d, session: %d, success: %b", new Object[] { Long.valueOf(this.ymt), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    q localq;
    if (this.ymt == paramLong)
    {
      this.owX = false;
      this.gGM = true;
      localq = g.aiU();
      localObject = this.ymw;
      if (localObject == null) {
        break label108;
      }
    }
    label108:
    for (Object localObject = ((c)localObject).ymy;; localObject = null)
    {
      localq.a((n)localObject);
      this.ymv = null;
      this.ymw = null;
      AppMethodBeat.o(161972);
      return;
    }
  }
  
  public final void yX(long paramLong)
  {
    AppMethodBeat.i(52149);
    ad.i("MicroMsg.AiScanImageUploader", "alvinluo cancelResult session: %d", new Object[] { Long.valueOf(paramLong) });
    q localq;
    if (this.ymt == paramLong)
    {
      this.isCancelled = true;
      this.owX = false;
      localq = g.aiU();
      localObject = this.ymw;
      if (localObject == null) {
        break label86;
      }
    }
    label86:
    for (Object localObject = ((c)localObject).ymy;; localObject = null)
    {
      localq.a((n)localObject);
      this.ymv = null;
      this.ymw = null;
      AppMethodBeat.o(52149);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "", "onUploadError", "", "errCode", "", "onUploadEvent", "source", "session", "", "event", "onUploadFailed", "errMsg", "", "onUploadSuccess", "result", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, long paramLong, int paramInt2, String paramString);
    
    public abstract void a(w paramw);
    
    public abstract void av(int paramInt, long paramLong);
    
    public abstract void dKP();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "", "(Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;)V", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "isFinished", "", "()Z", "setFinished", "(Z)V", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getNetScene", "()Lcom/tencent/mm/modelbase/NetSceneBase;", "setNetScene", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "session", "", "getSession", "()J", "setSession", "(J)V", "source", "", "getSource", "()I", "setSource", "(I)V", "plugin-scan_release"})
  final class c
  {
    long dlI;
    int dnh;
    Bundle dxT;
    boolean gGM;
    n ymy;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements v
  {
    d(c paramc, me paramme, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(52146);
      final w localw = u.a(paramString, paramInt1);
      h.LTJ.aP((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52145);
          localw.dnh = this.ymC.ymB;
          ad.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, showResult: %b, isFinish: %b, isCancelled: %b", new Object[] { Integer.valueOf(this.ymC.ymB), Boolean.valueOf(localw.ynv), Boolean.valueOf(c.a(this.ymC.ymz)), Boolean.valueOf(c.b(this.ymC.ymz)) });
          if ((!c.a(this.ymC.ymz)) && (!c.b(this.ymC.ymz))) {
            c.c(this.ymC.ymz).a(localw);
          }
          AppMethodBeat.o(52145);
        }
      });
      AppMethodBeat.o(52146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.c
 * JD-Core Version:    0.7.0.1
 */