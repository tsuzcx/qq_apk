package com.tencent.mm.plugin.scanner.model;

import android.os.Bundle;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.mj;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.protocal.protobuf.ml;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;", "", "source", "", "callback", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "(ILcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;)V", "currentSession", "", "ignoreSuccessResult", "", "isCancelled", "isFinished", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "needLocation", "runningRequest", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "scanResultCallback", "waitingRequest", "cancelResult", "", "session", "doHandleResult", "result", "Landroid/os/Bundle;", "finishResult", "success", "getAdInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "getJsApiInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;", "getScanGoodsRequest", "handleResult", "notifyEvent", "event", "onError", "onScanFailed", "errCode", "errMsg", "", "onScanSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveTimeOut", "timeOut", "setLocation", "location", "uploadImage", "frameId", "imageData", "", "mode", "requestType", "originWidth", "originHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "usingAI", "isAiCrop", "adInfo", "jsApiInfo", "uploadNext", "AiScanImageUploadCallback", "Companion", "Event", "RequestInfo", "plugin-scan_release"})
public final class b
{
  public static final b.b IKw;
  public ml IGA;
  private long IKr;
  private a IKs;
  private boolean IKt;
  private c IKu;
  private c IKv;
  private boolean isCancelled;
  private boolean isFinished;
  private int source;
  private boolean tni;
  
  static
  {
    AppMethodBeat.i(52157);
    IKw = new b.b((byte)0);
    AppMethodBeat.o(52157);
  }
  
  public b(int paramInt, a parama)
  {
    AppMethodBeat.i(52156);
    this.source = paramInt;
    this.IKs = parama;
    AppMethodBeat.o(52156);
  }
  
  private static mj a(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(217106);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(217106);
      return null;
    }
    try
    {
      mj localmj = new mj();
      localmj.jDL = paramScanGoodsRequest.getExtra("key_sns_ad_ux_info", "");
      localmj.RSd = Util.safeParseInt(paramScanGoodsRequest.getExtra("key_gesture_id", ""));
      Log.d("MicroMsg.AiScanImageUploader", "getAdInfo uxInfo: %s, gestureId: %s", new Object[] { localmj.jDL, Integer.valueOf(localmj.RSd) });
      AppMethodBeat.o(217106);
      return localmj;
    }
    catch (Exception paramScanGoodsRequest)
    {
      Log.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramScanGoodsRequest, "getAdInfo exception", new Object[0]);
      AppMethodBeat.o(217106);
    }
    return null;
  }
  
  private final void a(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, GoodsObject paramGoodsObject, boolean paramBoolean1, boolean paramBoolean2, mj parammj, mk parammk, ml paramml)
  {
    AppMethodBeat.i(217103);
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo uploadImage imageData: %d, mode: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt2) });
    paramArrayOfByte = new e(paramArrayOfByte, paramInt4, paramInt2, paramInt3, paramLong, paramInt1, paramBoolean1, paramBoolean2, paramInt5, paramInt6, paramGoodsObject, parammj, parammk, paramml);
    paramGoodsObject = this.IKv;
    if (paramGoodsObject != null) {
      paramGoodsObject.IKx = ((q)paramArrayOfByte);
    }
    com.tencent.mm.kernel.h.aGY().b((q)paramArrayOfByte);
    AppMethodBeat.o(217103);
  }
  
  private static ScanGoodsRequest at(Bundle paramBundle)
  {
    AppMethodBeat.i(217105);
    if (paramBundle == null)
    {
      AppMethodBeat.o(217105);
      return null;
    }
    try
    {
      paramBundle = (ScanGoodsRequest)paramBundle.getParcelable("key_scan_request");
      AppMethodBeat.o(217105);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      Log.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramBundle, "getScanGoodsRequest exception", new Object[0]);
      AppMethodBeat.o(217105);
    }
    return null;
  }
  
  private static mk b(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(217108);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(217108);
      return null;
    }
    try
    {
      mk localmk = new mk();
      localmk.RSe = paramScanGoodsRequest.extInfo;
      Log.d("MicroMsg.AiScanImageUploader", "getJsApiInfo %s", new Object[] { localmk.RSe });
      AppMethodBeat.o(217108);
      return localmk;
    }
    catch (Exception paramScanGoodsRequest)
    {
      Log.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramScanGoodsRequest, "getJsApiInfo exception", new Object[0]);
      AppMethodBeat.o(217108);
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
    if (this.IKr != paramLong)
    {
      this.isFinished = false;
      this.IKr = paramLong;
    }
    int j = paramBundle.getInt("scan_source", 0);
    byte[] arrayOfByte = paramBundle.getByteArray("result_best_img");
    int k = paramBundle.getInt("key_scan_goods_mode", 0);
    Object localObject = at(paramBundle);
    mk localmk = b((ScanGoodsRequest)localObject);
    int i;
    if (localObject != null) {
      i = ((ScanGoodsRequest)localObject).requestType;
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
            localObject = a((ScanGoodsRequest)localObject);
            boolean bool1 = v.isUsingAI();
            boolean bool2 = v.isAICrop();
            paramBundle = this.IKv;
            if (paramBundle != null)
            {
              paramBundle = paramBundle.IKy;
              a(paramLong, m, arrayOfByte, k, i, j, n, i1, localGoodsObject, bool1, bool2, (mj)localObject, localmk, paramBundle);
              AppMethodBeat.o(52151);
              return;
              i = 0;
            }
          }
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramBundle, "alvinluo handleResult cropObject parseFrom exception", new Object[0]);
            continue;
            paramBundle = null;
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
        a(this, paramLong, arrayOfByte, k, i, j, localmk);
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
    a locala = this.IKs;
    if (locala != null)
    {
      locala.fCH();
      AppMethodBeat.o(52152);
      return;
    }
    AppMethodBeat.o(52152);
  }
  
  public final void G(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(161972);
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo finishResult current: %d, session: %d, success: %b", new Object[] { Long.valueOf(this.IKr), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    com.tencent.mm.an.t localt;
    if (this.IKr == paramLong)
    {
      this.tni = false;
      this.isFinished = true;
      localt = com.tencent.mm.kernel.h.aGY();
      localObject = this.IKv;
      if (localObject == null) {
        break label108;
      }
    }
    label108:
    for (Object localObject = ((c)localObject).IKx;; localObject = null)
    {
      localt.a((q)localObject);
      this.IKu = null;
      this.IKv = null;
      AppMethodBeat.o(161972);
      return;
    }
  }
  
  public final void PR(long paramLong)
  {
    AppMethodBeat.i(52149);
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo cancelResult session: %d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.an.t localt;
    if (this.IKr == paramLong)
    {
      this.isCancelled = true;
      this.tni = false;
      localt = com.tencent.mm.kernel.h.aGY();
      localObject = this.IKv;
      if (localObject == null) {
        break label86;
      }
    }
    label86:
    for (Object localObject = ((c)localObject).IKx;; localObject = null)
    {
      localt.a((q)localObject);
      this.IKu = null;
      this.IKv = null;
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
    if (this.IKv != null)
    {
      localc = this.IKv;
      if ((localc == null) || (localc.isFinished != true)) {}
    }
    else
    {
      localc = new c();
      localc.source = i;
      localc.fwK = paramLong;
      localc.isFinished = false;
      localc.fKb = paramBundle;
      localc.IKy = this.IGA;
      this.IKv = localc;
      d(paramLong, paramBundle);
      AppMethodBeat.o(52147);
      return;
    }
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo handleResult replace waiting request");
    if (this.IKu == null) {
      this.IKu = new c();
    }
    c localc = this.IKu;
    if (localc != null)
    {
      localc.source = i;
      localc.fwK = paramLong;
      localc.isFinished = false;
      localc.fKb = paramBundle;
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
        break label826;
      }
      i = 1;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label619;
      }
      paramString = (e)paramq;
      if (paramString.rr.bhY() == null) {
        break label365;
      }
      paramString = paramString.rr.bhY();
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
    paramString = (mn)paramString;
    long l;
    if ((paramString != null) && (paramString.RSz == true) && (paramString.RSz != this.tni))
    {
      this.tni = true;
      paramInt1 = this.source;
      l = paramString.RSk;
      if ((this.isFinished) || (this.isCancelled)) {
        Log.w("MicroMsg.AiScanImageUploader", "alvinluo notifyEvent isFinished and ignore");
      }
    }
    else
    {
      label153:
      if ((paramString == null) || (paramString.RSk != ((e)paramq).fwK)) {
        break label605;
      }
      Log.d("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd sessionId: %s, scanId: %s, needLocation: %s", new Object[] { Long.valueOf(paramString.RSk), Integer.valueOf(paramString.RSj), Boolean.valueOf(this.tni) });
      paramInt1 = this.source;
      Log.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, isFinished: %b, isCancelled: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(this.isFinished), Boolean.valueOf(this.isCancelled) });
      if ((!this.isFinished) && (!this.isCancelled)) {
        break label428;
      }
      Log.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess isFinished and ignore");
      paramInt1 = i;
    }
    for (;;)
    {
      this.IKv = null;
      if (paramInt1 == 0) {
        break label826;
      }
      Log.d("MicroMsg.AiScanImageUploader", "alvinluo uploadNext: %b, isCancelled: %b", new Object[] { Boolean.valueOf(this.isFinished), Boolean.valueOf(this.isCancelled) });
      paramString = this.IKv;
      if (paramString != null) {
        paramString.isFinished = true;
      }
      this.IKv = null;
      if ((!this.isFinished) && (!this.isCancelled)) {
        break label728;
      }
      AppMethodBeat.o(52155);
      return;
      label365:
      paramString = null;
      break;
      Log.d("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage notifyEvent source: %d, session: %d, event: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l), Integer.valueOf(1) });
      a locala = this.IKs;
      if (locala == null) {
        break label153;
      }
      locala.aP(paramInt1, l);
      break label153;
      label428:
      if (this.IKv != null)
      {
        paramq = this.IKv;
        if ((paramq == null) || (paramq.isFinished != true)) {}
      }
      else
      {
        boolean bool;
        if (this.IKv == null)
        {
          bool = true;
          label465:
          paramString = this.IKv;
          if (paramString == null) {
            break label518;
          }
        }
        for (paramString = Boolean.valueOf(paramString.isFinished);; paramString = null)
        {
          Log.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess runningRequest invalid and ignore isNull: %b, isFinished: %s", new Object[] { Boolean.valueOf(bool), paramString });
          paramInt1 = i;
          break;
          bool = false;
          break label465;
        }
      }
      label518:
      if ((paramInt1 == 1) && (!this.IKt))
      {
        paramq = this.IKv;
        if (paramq == null) {
          p.iCn();
        }
        if ((paramq.IKy == null) && (paramString.RSz))
        {
          Log.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess need_poi and ignore current success result");
          this.IKt = true;
          paramInt1 = i;
          continue;
        }
      }
      v.a((w)new d(this, paramString, paramInt1));
      paramInt1 = i;
      continue;
      label605:
      Log.w("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd success sessionId not the same");
      paramInt1 = i;
    }
    label619:
    if (paramInt2 == 1003) {}
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if ((!this.isCancelled) && (!this.isFinished))
      {
        i = this.source;
        l = ((e)paramq).fwK;
        Log.e("MicroMsg.AiScanImageUploader", "alvinluo onScanFailed source: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2), paramString });
        if (i == 1) {
          v.fCU();
        }
        paramq = this.IKs;
        if (paramq != null)
        {
          paramq.a(i, l, paramInt2, paramString);
          break;
        }
      }
      break;
      label728:
      if (this.IKu != null)
      {
        paramString = this.IKu;
        if (paramString == null) {
          p.iCn();
        }
        if (!paramString.isFinished)
        {
          this.IKv = this.IKu;
          paramString = this.IKv;
          if (paramString != null) {
            paramString.IKy = this.IGA;
          }
          paramString = this.IKu;
          if (paramString == null) {
            p.iCn();
          }
          l = paramString.fwK;
          paramString = this.IKu;
          if (paramString == null) {
            p.iCn();
          }
          paramString = paramString.fKb;
          this.IKu = null;
          d(l, paramString);
        }
      }
      label826:
      AppMethodBeat.o(52155);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(52150);
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo release");
    this.IKs = null;
    AppMethodBeat.o(52150);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "", "onUploadError", "", "errCode", "", "onUploadEvent", "source", "session", "", "event", "onUploadFailed", "errMsg", "", "onUploadSuccess", "result", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, long paramLong, int paramInt2, String paramString);
    
    public abstract void a(x paramx);
    
    public abstract void aP(int paramInt, long paramLong);
    
    public abstract void fCH();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "", "(Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;)V", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "isFinished", "", "()Z", "setFinished", "(Z)V", "location", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;)V", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getNetScene", "()Lcom/tencent/mm/modelbase/NetSceneBase;", "setNetScene", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "session", "", "getSession", "()J", "setSession", "(J)V", "source", "", "getSource", "()I", "setSource", "(I)V", "plugin-scan_release"})
  final class c
  {
    q IKx;
    ml IKy;
    Bundle fKb;
    long fwK;
    boolean isFinished;
    int source;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements w
  {
    d(b paramb, mn parammn, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(52146);
      final x localx = v.a(paramString, paramInt1);
      com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52145);
          localx.source = this.IKC.IKB;
          Log.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, showResult: %b, isFinish: %b, isCancelled: %b", new Object[] { Integer.valueOf(this.IKC.IKB), Boolean.valueOf(localx.ILv), Boolean.valueOf(b.a(this.IKC.IKz)), Boolean.valueOf(b.b(this.IKC.IKz)) });
          if ((!b.a(this.IKC.IKz)) && (!b.b(this.IKC.IKz)))
          {
            b.a locala = b.c(this.IKC.IKz);
            if (locala != null)
            {
              locala.a(localx);
              AppMethodBeat.o(52145);
              return;
            }
          }
          AppMethodBeat.o(52145);
        }
      });
      AppMethodBeat.o(52146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.b
 * JD-Core Version:    0.7.0.1
 */