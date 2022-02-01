package com.tencent.mm.plugin.scanner.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.protocal.protobuf.ns;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;", "", "source", "", "callback", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "(ILcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;)V", "currentSession", "", "ignoreSuccessResult", "", "isCancelled", "isFinished", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "needLocation", "runningRequest", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "scanResultCallback", "waitingRequest", "cancelResult", "", "session", "doHandleResult", "result", "Landroid/os/Bundle;", "finishResult", "success", "getAdInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "getJsApiInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;", "getScanGoodsRequest", "handleResult", "notifyEvent", "event", "onError", "onScanFailed", "errCode", "errMsg", "", "onScanSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveTimeOut", "timeOut", "setLocation", "location", "uploadImage", "frameId", "imageData", "", "mode", "requestType", "originWidth", "originHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "usingAI", "isAiCrop", "adInfo", "jsApiInfo", "uploadNext", "AiScanImageUploadCallback", "Companion", "Event", "RequestInfo", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.b ORa;
  public nq OMI;
  private long ORb;
  private a ORc;
  private boolean ORd;
  private c ORe;
  private c ORf;
  private boolean isCancelled;
  private boolean isFinished;
  private int source;
  private boolean wrJ;
  
  static
  {
    AppMethodBeat.i(52157);
    ORa = new b.b((byte)0);
    AppMethodBeat.o(52157);
  }
  
  public b(int paramInt, a parama)
  {
    AppMethodBeat.i(52156);
    this.source = paramInt;
    this.ORc = parama;
    AppMethodBeat.o(52156);
  }
  
  private static no a(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(314390);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(314390);
      return null;
    }
    try
    {
      no localno = new no();
      localno.mdG = paramScanGoodsRequest.getExtra("key_sns_ad_ux_info", "");
      localno.YPD = Util.safeParseInt(paramScanGoodsRequest.getExtra("key_gesture_id", ""));
      Log.d("MicroMsg.AiScanImageUploader", "getAdInfo uxInfo: %s, gestureId: %s", new Object[] { localno.mdG, Integer.valueOf(localno.YPD) });
      AppMethodBeat.o(314390);
      return localno;
    }
    catch (Exception paramScanGoodsRequest)
    {
      Log.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramScanGoodsRequest, "getAdInfo exception", new Object[0]);
      AppMethodBeat.o(314390);
    }
    return null;
  }
  
  private final void a(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, GoodsObject paramGoodsObject, boolean paramBoolean1, boolean paramBoolean2, no paramno, np paramnp, nq paramnq)
  {
    AppMethodBeat.i(314372);
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo uploadImage imageData: %d, mode: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt2) });
    paramArrayOfByte = new i(paramArrayOfByte, paramInt4, paramInt2, paramInt3, paramLong, paramInt1, paramBoolean1, paramBoolean2, paramInt5, paramInt6, paramGoodsObject, paramno, paramnp, paramnq);
    paramGoodsObject = this.ORf;
    if (paramGoodsObject != null) {
      paramGoodsObject.ORg = ((p)paramArrayOfByte);
    }
    com.tencent.mm.kernel.h.aZW().a((p)paramArrayOfByte, 0);
    AppMethodBeat.o(314372);
  }
  
  private static final void a(ae paramae, int paramInt, b paramb)
  {
    AppMethodBeat.i(314401);
    kotlin.g.b.s.u(paramae, "$result");
    kotlin.g.b.s.u(paramb, "this$0");
    paramae.source = paramInt;
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, showResult: %b, isFinish: %b, isCancelled: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramae.OSy), Boolean.valueOf(paramb.isFinished), Boolean.valueOf(paramb.isCancelled) });
    if ((!paramb.isFinished) && (!paramb.isCancelled))
    {
      paramb = paramb.ORc;
      if (paramb != null) {
        paramb.a(paramae);
      }
    }
    AppMethodBeat.o(314401);
  }
  
  private static final void a(ns paramns, int paramInt, b paramb)
  {
    AppMethodBeat.i(314408);
    kotlin.g.b.s.u(paramns, "$response");
    kotlin.g.b.s.u(paramb, "this$0");
    paramns = ac.a(paramns, paramInt);
    com.tencent.threadpool.h.ahAA.bk(new b..ExternalSyntheticLambda1(paramns, paramInt, paramb));
    AppMethodBeat.o(314408);
  }
  
  private static ScanGoodsRequest aT(Bundle paramBundle)
  {
    AppMethodBeat.i(314382);
    if (paramBundle == null)
    {
      AppMethodBeat.o(314382);
      return null;
    }
    try
    {
      paramBundle = (ScanGoodsRequest)paramBundle.getParcelable("key_scan_request");
      AppMethodBeat.o(314382);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      Log.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramBundle, "getScanGoodsRequest exception", new Object[0]);
      AppMethodBeat.o(314382);
    }
    return null;
  }
  
  private final void atR()
  {
    AppMethodBeat.i(52152);
    a locala = this.ORc;
    if (locala != null) {
      locala.gQI();
    }
    AppMethodBeat.o(52152);
  }
  
  private static np b(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(314396);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(314396);
      return null;
    }
    try
    {
      np localnp = new np();
      localnp.YPE = paramScanGoodsRequest.extInfo;
      Log.d("MicroMsg.AiScanImageUploader", "getJsApiInfo %s", new Object[] { localnp.YPE });
      AppMethodBeat.o(314396);
      return localnp;
    }
    catch (Exception paramScanGoodsRequest)
    {
      Log.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramScanGoodsRequest, "getJsApiInfo exception", new Object[0]);
      AppMethodBeat.o(314396);
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
    if (this.ORb != paramLong)
    {
      this.isFinished = false;
      this.ORb = paramLong;
    }
    int j = paramBundle.getInt("scan_source", 0);
    byte[] arrayOfByte = paramBundle.getByteArray("result_best_img");
    int k = paramBundle.getInt("key_scan_goods_mode", 0);
    Object localObject = aT(paramBundle);
    np localnp = b((ScanGoodsRequest)localObject);
    if (localObject == null) {}
    for (int i = 0;; i = ((ScanGoodsRequest)localObject).requestType)
    {
      Log.i("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage doHandleResult session: %d, source: %d, mode: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(j), Integer.valueOf(k) });
      switch (j)
      {
      default: 
        atR();
        AppMethodBeat.o(52151);
        return;
      }
    }
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
        boolean bool1 = ac.isUsingAI();
        boolean bool2 = ac.isAICrop();
        paramBundle = this.ORf;
        if (paramBundle == null)
        {
          paramBundle = null;
          a(paramLong, m, arrayOfByte, k, i, j, n, i1, localGoodsObject, bool1, bool2, (no)localObject, localnp, paramBundle);
          AppMethodBeat.o(52151);
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramBundle, "alvinluo handleResult cropObject parseFrom exception", new Object[0]);
        continue;
        paramBundle = paramBundle.ORh;
      }
      atR();
      AppMethodBeat.o(52151);
      return;
    }
    if (arrayOfByte != null)
    {
      a(this, paramLong, arrayOfByte, k, i, j, localnp);
      AppMethodBeat.o(52151);
      return;
    }
    atR();
    AppMethodBeat.o(52151);
  }
  
  public final void Q(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(161972);
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo finishResult current: %d, session: %d, success: %b", new Object[] { Long.valueOf(this.ORb), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    com.tencent.mm.am.s locals;
    if (this.ORb == paramLong)
    {
      this.wrJ = false;
      this.isFinished = true;
      locals = com.tencent.mm.kernel.h.aZW();
      localObject = this.ORf;
      if (localObject != null) {
        break label104;
      }
    }
    label104:
    for (Object localObject = null;; localObject = ((c)localObject).ORg)
    {
      locals.a((p)localObject);
      this.ORe = null;
      this.ORf = null;
      AppMethodBeat.o(161972);
      return;
    }
  }
  
  public final void c(long paramLong, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(52147);
    if (paramBundle == null)
    {
      AppMethodBeat.o(52147);
      return;
    }
    int j = paramBundle.getInt("scan_source", 0);
    if (this.ORf != null)
    {
      localc = this.ORf;
      if ((localc == null) || (localc.isFinished != true)) {
        break label130;
      }
    }
    while (i != 0)
    {
      localc = new c();
      localc.source = j;
      localc.hBk = paramLong;
      localc.isFinished = false;
      localc.hPH = paramBundle;
      localc.ORh = this.OMI;
      ah localah = ah.aiuX;
      this.ORf = localc;
      d(paramLong, paramBundle);
      AppMethodBeat.o(52147);
      return;
      label130:
      i = 0;
    }
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo handleResult replace waiting request");
    if (this.ORe == null) {
      this.ORe = new c();
    }
    c localc = this.ORe;
    if (localc != null)
    {
      localc.source = j;
      localc.hBk = paramLong;
      localc.isFinished = false;
      localc.hPH = paramBundle;
    }
    AppMethodBeat.o(52147);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(52155);
    int i;
    if ((paramp != null) && (paramp.getType() == 2580)) {
      i = 1;
    }
    label143:
    long l;
    while (i != 0)
    {
      i = 1;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramp == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneAiScanImage");
          AppMethodBeat.o(52155);
          throw paramString;
          i = 0;
        }
        else
        {
          paramString = (i)paramp;
          if (c.c.b(paramString.rr.otC) != null)
          {
            paramString = c.c.b(paramString.rr.otC);
            if (paramString == null)
            {
              paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageResponse");
              AppMethodBeat.o(52155);
              throw paramString;
            }
            paramString = (ns)paramString;
            if ((paramString == null) || (paramString.YPZ != true)) {
              break label419;
            }
            paramInt1 = 1;
            if ((paramInt1 != 0) && (paramString.YPZ != this.wrJ))
            {
              this.wrJ = true;
              paramInt1 = this.source;
              l = paramString.YPK;
              if ((!this.isFinished) && (!this.isCancelled)) {
                break label424;
              }
              Log.w("MicroMsg.AiScanImageUploader", "alvinluo notifyEvent isFinished and ignore");
            }
            label196:
            if ((paramString == null) || (paramString.YPK != ((i)paramp).hBk)) {
              break label482;
            }
            paramInt1 = 1;
            label218:
            if (paramInt1 == 0) {
              break label669;
            }
            Log.d("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd sessionId: %s, scanId: %s, needLocation: %s", new Object[] { Long.valueOf(paramString.YPK), Integer.valueOf(paramString.YPJ), Boolean.valueOf(this.wrJ) });
            paramInt2 = this.source;
            Log.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, isFinished: %b, isCancelled: %b", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(this.isFinished), Boolean.valueOf(this.isCancelled) });
            if ((!this.isFinished) && (!this.isCancelled)) {
              break label487;
            }
            Log.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess isFinished and ignore");
            paramInt1 = i;
          }
          for (;;)
          {
            this.ORf = null;
            if (paramInt1 == 0) {
              break label902;
            }
            Log.d("MicroMsg.AiScanImageUploader", "alvinluo uploadNext: %b, isCancelled: %b", new Object[] { Boolean.valueOf(this.isFinished), Boolean.valueOf(this.isCancelled) });
            paramString = this.ORf;
            if (paramString != null) {
              paramString.isFinished = true;
            }
            this.ORf = null;
            if ((!this.isFinished) && (!this.isCancelled)) {
              break label813;
            }
            AppMethodBeat.o(52155);
            return;
            paramString = null;
            break;
            label419:
            paramInt1 = 0;
            break label143;
            label424:
            Log.d("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage notifyEvent source: %d, session: %d, event: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l), Integer.valueOf(1) });
            a locala = this.ORc;
            if (locala == null) {
              break label196;
            }
            locala.aW(paramInt1, l);
            break label196;
            label482:
            paramInt1 = 0;
            break label218;
            label487:
            boolean bool;
            if (this.ORf != null)
            {
              paramp = this.ORf;
              if ((paramp != null) && (paramp.isFinished == true))
              {
                paramInt1 = 1;
                label516:
                if (paramInt1 == 0) {
                  break label593;
                }
              }
            }
            else
            {
              if (this.ORf != null) {
                break label576;
              }
              bool = true;
              label530:
              paramString = this.ORf;
              if (paramString != null) {
                break label582;
              }
            }
            label576:
            label582:
            for (paramString = null;; paramString = Boolean.valueOf(paramString.isFinished))
            {
              Log.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess runningRequest invalid and ignore isNull: %b, isFinished: %s", new Object[] { Boolean.valueOf(bool), paramString });
              paramInt1 = i;
              break;
              paramInt1 = 0;
              break label516;
              bool = false;
              break label530;
            }
            label593:
            if ((paramInt2 == 1) && (!this.ORd))
            {
              paramp = this.ORf;
              kotlin.g.b.s.checkNotNull(paramp);
              if ((paramp.ORh == null) && (paramString.YPZ))
              {
                Log.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess need_poi and ignore current success result");
                this.ORd = true;
                paramInt1 = i;
                continue;
              }
            }
            ac.a(new b..ExternalSyntheticLambda0(paramString, paramInt2, this));
            paramInt1 = i;
            continue;
            label669:
            Log.w("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd success sessionId not the same");
            paramInt1 = i;
          }
        }
      }
      else {
        if (paramInt2 != 1003) {
          break label909;
        }
      }
    }
    label902:
    label909:
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if ((!this.isCancelled) && (!this.isFinished))
      {
        i = this.source;
        if (paramp == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneAiScanImage");
          AppMethodBeat.o(52155);
          throw paramString;
        }
        l = ((i)paramp).hBk;
        Log.e("MicroMsg.AiScanImageUploader", "alvinluo onScanFailed source: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2), paramString });
        if (i == 1) {
          ac.gQZ();
        }
        paramp = this.ORc;
        if (paramp != null) {
          paramp.a(i, l, paramInt2, paramString);
        }
      }
      break;
      label813:
      if (this.ORe != null)
      {
        paramString = this.ORe;
        kotlin.g.b.s.checkNotNull(paramString);
        if (!paramString.isFinished)
        {
          this.ORf = this.ORe;
          paramString = this.ORf;
          if (paramString != null) {
            paramString.ORh = this.OMI;
          }
          paramString = this.ORe;
          kotlin.g.b.s.checkNotNull(paramString);
          l = paramString.hBk;
          paramString = this.ORe;
          kotlin.g.b.s.checkNotNull(paramString);
          paramString = paramString.hPH;
          this.ORe = null;
          d(l, paramString);
        }
      }
      AppMethodBeat.o(52155);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(52150);
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo release");
    this.ORc = null;
    AppMethodBeat.o(52150);
  }
  
  public final void tV(long paramLong)
  {
    AppMethodBeat.i(52149);
    Log.i("MicroMsg.AiScanImageUploader", "alvinluo cancelResult session: %d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.am.s locals;
    if (this.ORb == paramLong)
    {
      this.isCancelled = true;
      this.wrJ = false;
      locals = com.tencent.mm.kernel.h.aZW();
      localObject = this.ORf;
      if (localObject != null) {
        break label83;
      }
    }
    label83:
    for (Object localObject = null;; localObject = ((c)localObject).ORg)
    {
      locals.a((p)localObject);
      this.ORe = null;
      this.ORf = null;
      AppMethodBeat.o(52149);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "", "onUploadError", "", "errCode", "", "onUploadEvent", "source", "session", "", "event", "onUploadFailed", "errMsg", "", "onUploadSuccess", "result", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, long paramLong, int paramInt2, String paramString);
    
    public abstract void a(ae paramae);
    
    public abstract void aW(int paramInt, long paramLong);
    
    public abstract void gQI();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "", "(Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;)V", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "isFinished", "", "()Z", "setFinished", "(Z)V", "location", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;)V", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getNetScene", "()Lcom/tencent/mm/modelbase/NetSceneBase;", "setNetScene", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "session", "", "getSession", "()J", "setSession", "(J)V", "source", "", "getSource", "()I", "setSource", "(I)V", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class c
  {
    p ORg;
    nq ORh;
    long hBk;
    Bundle hPH;
    boolean isFinished;
    int source;
    
    public c()
    {
      AppMethodBeat.i(314231);
      AppMethodBeat.o(314231);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.b
 * JD-Core Version:    0.7.0.1
 */