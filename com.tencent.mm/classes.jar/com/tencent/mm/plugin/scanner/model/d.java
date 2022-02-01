package com.tencent.mm.plugin.scanner.model;

import android.os.Bundle;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.ms;
import com.tencent.mm.protocal.protobuf.mt;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;", "", "source", "", "callback", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "(ILcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;)V", "count", "currentSession", "", "isCancelled", "", "isFinished", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "needLocation", "runningRequest", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "scanResultCallback", "waitingRequest", "cancelResult", "", "session", "doHandleResult", "result", "Landroid/os/Bundle;", "finishResult", "success", "getAdInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "getJsApiInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;", "getScanGoodsRequest", "handleResult", "notifyEvent", "event", "onError", "onScanFailed", "errCode", "errMsg", "", "onScanSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveTimeOut", "timeOut", "setLocation", "location", "uploadImage", "frameId", "imageData", "", "mode", "requestType", "originWidth", "originHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "usingAI", "isAiCrop", "adInfo", "jsApiInfo", "uploadNext", "AiScanImageUploadCallback", "Companion", "Event", "RequestInfo", "plugin-scan_release"})
public final class d
{
  public static final d.b CFk;
  public mu CAV;
  private long CFg;
  private final a CFh;
  private c CFi;
  private c CFj;
  private boolean isCancelled;
  private boolean isFinished;
  private boolean pRi;
  private int source;
  
  static
  {
    AppMethodBeat.i(52157);
    CFk = new d.b((byte)0);
    AppMethodBeat.o(52157);
  }
  
  public d(int paramInt, a parama)
  {
    AppMethodBeat.i(52156);
    this.source = paramInt;
    this.CFh = parama;
    AppMethodBeat.o(52156);
  }
  
  private static ms a(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(240400);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(240400);
      return null;
    }
    try
    {
      ms localms = new ms();
      localms.gTk = paramScanGoodsRequest.getExtra("key_sns_ad_ux_info", "");
      localms.KQZ = Util.safeParseInt(paramScanGoodsRequest.getExtra("key_gesture_id", ""));
      Log.d("MicroMsg.AiScanImageUploader", "getAdInfo uxInfo: %s, gestureId: %s", new Object[] { localms.gTk, Integer.valueOf(localms.KQZ) });
      AppMethodBeat.o(240400);
      return localms;
    }
    catch (Exception paramScanGoodsRequest)
    {
      Log.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramScanGoodsRequest, "getAdInfo exception", new Object[0]);
      AppMethodBeat.o(240400);
    }
    return null;
  }
  
  private final void a(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, GoodsObject paramGoodsObject, boolean paramBoolean1, boolean paramBoolean2, ms paramms, mt parammt, mu parammu)
  {
    AppMethodBeat.i(240397);
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo uploadImage imageData: %d, mode: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt2) });
    paramArrayOfByte = new g(paramArrayOfByte, paramInt4, paramInt2, paramInt3, paramLong, paramInt1, paramBoolean1, paramBoolean2, paramInt5, paramInt6, paramGoodsObject, paramms, parammt, parammu);
    paramGoodsObject = this.CFj;
    if (paramGoodsObject != null) {
      paramGoodsObject.CFl = ((q)paramArrayOfByte);
    }
    com.tencent.mm.kernel.g.azz().b((q)paramArrayOfByte);
    AppMethodBeat.o(240397);
  }
  
  private static ScanGoodsRequest ax(Bundle paramBundle)
  {
    AppMethodBeat.i(240399);
    if (paramBundle == null)
    {
      AppMethodBeat.o(240399);
      return null;
    }
    try
    {
      paramBundle = (ScanGoodsRequest)paramBundle.getParcelable("key_scan_request");
      AppMethodBeat.o(240399);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      Log.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramBundle, "getScanGoodsRequest exception", new Object[0]);
      AppMethodBeat.o(240399);
    }
    return null;
  }
  
  private static mt b(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(240401);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(240401);
      return null;
    }
    try
    {
      mt localmt = new mt();
      localmt.KRa = paramScanGoodsRequest.extInfo;
      Log.d("MicroMsg.AiScanImageUploader", "getJsApiInfo %s", new Object[] { localmt.KRa });
      AppMethodBeat.o(240401);
      return localmt;
    }
    catch (Exception paramScanGoodsRequest)
    {
      Log.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramScanGoodsRequest, "getJsApiInfo exception", new Object[0]);
      AppMethodBeat.o(240401);
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
    if (this.CFg != paramLong)
    {
      this.isFinished = false;
      this.CFg = paramLong;
    }
    int j = paramBundle.getInt("scan_source", 0);
    byte[] arrayOfByte = paramBundle.getByteArray("result_best_img");
    int k = paramBundle.getInt("key_scan_goods_mode", 0);
    ScanGoodsRequest localScanGoodsRequest = ax(paramBundle);
    mt localmt = b(localScanGoodsRequest);
    int i;
    if (localScanGoodsRequest != null) {
      i = localScanGoodsRequest.requestType;
    }
    for (;;)
    {
      Log.i("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage doHandleResult session: %d, source: %d, mode: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(j), Integer.valueOf(k) });
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
            a(paramLong, m, arrayOfByte, k, i, j, n, i1, localGoodsObject, x.isUsingAI(), x.isAICrop(), paramBundle, localmt, this.CAV);
            AppMethodBeat.o(52151);
            return;
            i = 0;
          }
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramBundle, "alvinluo handleResult cropObject parseFrom exception", new Object[0]);
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
        a(this, paramLong, arrayOfByte, k, i, j, localmt);
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
    this.CFh.ePM();
    AppMethodBeat.o(52152);
  }
  
  public static void release()
  {
    AppMethodBeat.i(52150);
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo release");
    AppMethodBeat.o(52150);
  }
  
  public final void F(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(161972);
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo finishResult current: %d, session: %d, success: %b", new Object[] { Long.valueOf(this.CFg), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    com.tencent.mm.ak.t localt;
    if (this.CFg == paramLong)
    {
      this.pRi = false;
      this.isFinished = true;
      localt = com.tencent.mm.kernel.g.azz();
      localObject = this.CFj;
      if (localObject == null) {
        break label108;
      }
    }
    label108:
    for (Object localObject = ((c)localObject).CFl;; localObject = null)
    {
      localt.a((q)localObject);
      this.CFi = null;
      this.CFj = null;
      AppMethodBeat.o(161972);
      return;
    }
  }
  
  public final void Ix(long paramLong)
  {
    AppMethodBeat.i(52149);
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo cancelResult session: %d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.ak.t localt;
    if (this.CFg == paramLong)
    {
      this.isCancelled = true;
      this.pRi = false;
      localt = com.tencent.mm.kernel.g.azz();
      localObject = this.CFj;
      if (localObject == null) {
        break label86;
      }
    }
    label86:
    for (Object localObject = ((c)localObject).CFl;; localObject = null)
    {
      localt.a((q)localObject);
      this.CFi = null;
      this.CFj = null;
      AppMethodBeat.o(52149);
      return;
    }
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
    if (this.CFj != null)
    {
      localc = this.CFj;
      if ((localc == null) || (localc.isFinished != true)) {}
    }
    else
    {
      localc = new c();
      localc.source = i;
      localc.dDZ = paramLong;
      localc.isFinished = false;
      localc.dQL = paramBundle;
      this.CFj = localc;
      d(paramLong, paramBundle);
      AppMethodBeat.o(52147);
      return;
    }
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo handleResult replace waiting request");
    if (this.CFi == null) {
      this.CFi = new c();
    }
    c localc = this.CFi;
    if (localc != null)
    {
      localc.source = i;
      localc.dDZ = paramLong;
      localc.isFinished = false;
      localc.dQL = paramBundle;
      AppMethodBeat.o(52147);
      return;
    }
    AppMethodBeat.o(52147);
  }
  
  public final void onSceneEnd(final int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(52155);
    int i;
    if (paramq != null)
    {
      if (paramq.getType() != 2580) {
        break label718;
      }
      i = 1;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label540;
      }
      paramString = (g)paramq;
      if (paramString.rr.aYK() == null) {
        break label355;
      }
      paramString = paramString.rr.aYK();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageResponse");
        AppMethodBeat.o(52155);
        throw paramString;
      }
    }
    else
    {
      AppMethodBeat.o(52155);
      return;
    }
    paramString = (mw)paramString;
    long l;
    if ((paramString != null) && (paramString.KRz == true) && (paramString.KRz != this.pRi))
    {
      this.pRi = true;
      paramInt1 = this.source;
      l = paramString.KRi;
      if ((this.isFinished) || (this.isCancelled)) {
        Log.w("MicroMsg.AiScanImageUploader", "alvinluo notifyEvent isFinished and ignore");
      }
    }
    else
    {
      label153:
      if ((paramString == null) || (paramString.KRi != ((g)paramq).dDZ)) {
        break label526;
      }
      Log.d("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd sessionId: %s, scanId: %s", new Object[] { Long.valueOf(paramString.KRi), Integer.valueOf(paramString.KRh) });
      paramInt1 = this.source;
      Log.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, isFinished: %b, isCancelled: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(this.isFinished), Boolean.valueOf(this.isCancelled) });
      if ((!this.isFinished) && (!this.isCancelled)) {
        break label409;
      }
      Log.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess isFinished and ignore");
      paramInt1 = i;
    }
    for (;;)
    {
      this.CFj = null;
      if (paramInt1 == 0) {
        break label718;
      }
      Log.d("MicroMsg.AiScanImageUploader", "alvinluo uploadNext: %b, isCancelled: %b", new Object[] { Boolean.valueOf(this.isFinished), Boolean.valueOf(this.isCancelled) });
      paramString = this.CFj;
      if (paramString != null) {
        paramString.isFinished = true;
      }
      this.CFj = null;
      if ((!this.isFinished) && (!this.isCancelled)) {
        break label637;
      }
      AppMethodBeat.o(52155);
      return;
      label355:
      paramString = null;
      break;
      Log.d("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage notifyEvent source: %d, session: %d, event: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l), Integer.valueOf(1) });
      this.CFh.aD(paramInt1, l);
      break label153;
      label409:
      if (this.CFj != null)
      {
        paramq = this.CFj;
        if ((paramq == null) || (paramq.isFinished != true)) {}
      }
      else
      {
        boolean bool;
        if (this.CFj == null)
        {
          bool = true;
          label446:
          paramString = this.CFj;
          if (paramString == null) {
            break label499;
          }
        }
        label499:
        for (paramString = Boolean.valueOf(paramString.isFinished);; paramString = null)
        {
          Log.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess runningRequest invalid and ignore isNull: %b, isFinished: %s", new Object[] { Boolean.valueOf(bool), paramString });
          paramInt1 = i;
          break;
          bool = false;
          break label446;
        }
      }
      x.a((y)new d(this, paramString, paramInt1));
      paramInt1 = i;
      continue;
      label526:
      Log.w("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd success sessionId not the same");
      paramInt1 = i;
    }
    label540:
    if (paramInt2 == 1003) {}
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if ((!this.isCancelled) && (!this.isFinished))
      {
        i = this.source;
        l = ((g)paramq).dDZ;
        Log.e("MicroMsg.AiScanImageUploader", "alvinluo onScanFailed source: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2), paramString });
        if (i == 1) {
          x.ePZ();
        }
        this.CFh.a(i, l, paramInt2, paramString);
      }
      break;
      label637:
      if (this.CFi != null)
      {
        paramString = this.CFi;
        if (paramString == null) {
          p.hyc();
        }
        if (!paramString.isFinished)
        {
          this.CFj = this.CFi;
          paramString = this.CFi;
          if (paramString == null) {
            p.hyc();
          }
          l = paramString.dDZ;
          paramString = this.CFi;
          if (paramString == null) {
            p.hyc();
          }
          paramString = paramString.dQL;
          this.CFi = null;
          d(l, paramString);
        }
      }
      label718:
      AppMethodBeat.o(52155);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "", "onUploadError", "", "errCode", "", "onUploadEvent", "source", "session", "", "event", "onUploadFailed", "errMsg", "", "onUploadSuccess", "result", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, long paramLong, int paramInt2, String paramString);
    
    public abstract void a(z paramz);
    
    public abstract void aD(int paramInt, long paramLong);
    
    public abstract void ePM();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "", "(Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;)V", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "isFinished", "", "()Z", "setFinished", "(Z)V", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getNetScene", "()Lcom/tencent/mm/modelbase/NetSceneBase;", "setNetScene", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "session", "", "getSession", "()J", "setSession", "(J)V", "source", "", "getSource", "()I", "setSource", "(I)V", "plugin-scan_release"})
  final class c
  {
    q CFl;
    long dDZ;
    Bundle dQL;
    boolean isFinished;
    int source;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements y
  {
    d(d paramd, mw parammw, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(52146);
      final z localz = x.a(paramString, paramInt1);
      h.RTc.aV((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52145);
          localz.source = this.CFp.CFo;
          Log.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, showResult: %b, isFinish: %b, isCancelled: %b", new Object[] { Integer.valueOf(this.CFp.CFo), Boolean.valueOf(localz.CGj), Boolean.valueOf(d.a(this.CFp.CFm)), Boolean.valueOf(d.b(this.CFp.CFm)) });
          if ((!d.a(this.CFp.CFm)) && (!d.b(this.CFp.CFm))) {
            d.c(this.CFp.CFm).a(localz);
          }
          AppMethodBeat.o(52145);
        }
      });
      AppMethodBeat.o(52146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.d
 * JD-Core Version:    0.7.0.1
 */