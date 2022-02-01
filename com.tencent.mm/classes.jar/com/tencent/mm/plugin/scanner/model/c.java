package com.tencent.mm.plugin.scanner.model;

import android.os.Bundle;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.ma;
import com.tencent.mm.protocal.protobuf.mb;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;", "", "source", "", "callback", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "(ILcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;)V", "count", "currentSession", "", "isCancelled", "", "isFinished", "locationInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "needLocation", "runningRequest", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "scanResultCallback", "waitingRequest", "cancelResult", "", "session", "doHandleResult", "result", "Landroid/os/Bundle;", "finishResult", "success", "getAdInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "getJsApiInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;", "getScanGoodsRequest", "handleResult", "notifyEvent", "event", "onError", "onScanFailed", "errCode", "errMsg", "", "onScanSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "onSceneEnd", "errType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveTimeOut", "timeOut", "setLocation", "location", "uploadImage", "frameId", "imageData", "", "mode", "requestType", "originWidth", "originHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "usingAI", "isAiCrop", "adInfo", "jsApiInfo", "uploadNext", "AiScanImageUploadCallback", "Companion", "Event", "RequestInfo", "plugin-scan_release"})
public final class c
{
  public static final c.b yCv;
  private int doj;
  private boolean gJv;
  private boolean isCancelled;
  private boolean oDz;
  private long yCr;
  private final a yCs;
  private c yCt;
  private c yCu;
  public mc yzP;
  
  static
  {
    AppMethodBeat.i(52157);
    yCv = new c.b((byte)0);
    AppMethodBeat.o(52157);
  }
  
  public c(int paramInt, a parama)
  {
    AppMethodBeat.i(52156);
    this.doj = paramInt;
    this.yCs = parama;
    AppMethodBeat.o(52156);
  }
  
  private static ma a(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(189557);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(189557);
      return null;
    }
    try
    {
      ma localma = new ma();
      localma.zot = paramScanGoodsRequest.getExtra("key_sns_ad_ux_info", "");
      localma.FXm = bu.aSB(paramScanGoodsRequest.getExtra("key_gesture_id", ""));
      ae.d("MicroMsg.AiScanImageUploader", "getAdInfo uxInfo: %s, gestureId: %s", new Object[] { localma.zot, Integer.valueOf(localma.FXm) });
      AppMethodBeat.o(189557);
      return localma;
    }
    catch (Exception paramScanGoodsRequest)
    {
      ae.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramScanGoodsRequest, "getAdInfo exception", new Object[0]);
      AppMethodBeat.o(189557);
    }
    return null;
  }
  
  private final void a(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, GoodsObject paramGoodsObject, boolean paramBoolean1, boolean paramBoolean2, ma paramma, mb parammb, mc parammc)
  {
    AppMethodBeat.i(189554);
    ae.i("MicroMsg.AiScanImageUploader", "alvinluo uploadImage imageData: %d, mode: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt2) });
    paramArrayOfByte = new e(paramArrayOfByte, paramInt4, paramInt2, paramInt3, paramLong, paramInt1, paramBoolean1, paramBoolean2, paramInt5, paramInt6, paramGoodsObject, paramma, parammb, parammc);
    paramGoodsObject = this.yCu;
    if (paramGoodsObject != null) {
      paramGoodsObject.yCw = ((n)paramArrayOfByte);
    }
    g.ajj().b((n)paramArrayOfByte);
    AppMethodBeat.o(189554);
  }
  
  private static ScanGoodsRequest al(Bundle paramBundle)
  {
    AppMethodBeat.i(189556);
    if (paramBundle == null)
    {
      AppMethodBeat.o(189556);
      return null;
    }
    try
    {
      paramBundle = (ScanGoodsRequest)paramBundle.getParcelable("key_scan_request");
      AppMethodBeat.o(189556);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      ae.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramBundle, "getScanGoodsRequest exception", new Object[0]);
      AppMethodBeat.o(189556);
    }
    return null;
  }
  
  private static mb b(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(189558);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(189558);
      return null;
    }
    try
    {
      mb localmb = new mb();
      localmb.FXn = paramScanGoodsRequest.extInfo;
      ae.d("MicroMsg.AiScanImageUploader", "getJsApiInfo %s", new Object[] { localmb.FXn });
      AppMethodBeat.o(189558);
      return localmb;
    }
    catch (Exception paramScanGoodsRequest)
    {
      ae.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramScanGoodsRequest, "getJsApiInfo exception", new Object[0]);
      AppMethodBeat.o(189558);
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
    if (this.yCr != paramLong)
    {
      this.gJv = false;
      this.yCr = paramLong;
    }
    int j = paramBundle.getInt("scan_source", 0);
    byte[] arrayOfByte = paramBundle.getByteArray("result_best_img");
    int k = paramBundle.getInt("key_scan_goods_mode", 0);
    ScanGoodsRequest localScanGoodsRequest = al(paramBundle);
    mb localmb = b(localScanGoodsRequest);
    int i;
    if (localScanGoodsRequest != null) {
      i = localScanGoodsRequest.requestType;
    }
    for (;;)
    {
      ae.i("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage doHandleResult session: %d, source: %d, mode: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(j), Integer.valueOf(k) });
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
            a(paramLong, m, arrayOfByte, k, i, j, n, i1, localGoodsObject, v.isUsingAI(), v.isAICrop(), paramBundle, localmb, this.yzP);
            AppMethodBeat.o(52151);
            return;
            i = 0;
          }
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.AiScanImageUploader", (Throwable)paramBundle, "alvinluo handleResult cropObject parseFrom exception", new Object[0]);
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
    this.yCs.dOh();
    AppMethodBeat.o(52152);
  }
  
  public static void release()
  {
    AppMethodBeat.i(52150);
    ae.i("MicroMsg.AiScanImageUploader", "alvinluo release");
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
    if (this.yCu != null)
    {
      localc = this.yCu;
      if ((localc == null) || (localc.gJv != true)) {}
    }
    else
    {
      localc = new c();
      localc.doj = i;
      localc.dmK = paramLong;
      localc.gJv = false;
      localc.dyY = paramBundle;
      this.yCu = localc;
      d(paramLong, paramBundle);
      AppMethodBeat.o(52147);
      return;
    }
    ae.i("MicroMsg.AiScanImageUploader", "alvinluo handleResult replace waiting request");
    if (this.yCt == null) {
      this.yCt = new c();
    }
    c localc = this.yCt;
    if (localc != null)
    {
      localc.doj = i;
      localc.dmK = paramLong;
      localc.gJv = false;
      localc.dyY = paramBundle;
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
      if (paramString.rr.aEV() == null) {
        break label355;
      }
      paramString = paramString.rr.aEV();
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
    if ((paramString != null) && (paramString.FXM == true) && (paramString.FXM != this.oDz))
    {
      this.oDz = true;
      paramInt1 = this.doj;
      l = paramString.FXv;
      if ((this.gJv) || (this.isCancelled)) {
        ae.w("MicroMsg.AiScanImageUploader", "alvinluo notifyEvent isFinished and ignore");
      }
    }
    else
    {
      label153:
      if ((paramString == null) || (paramString.FXv != ((e)paramn).dmK)) {
        break label526;
      }
      ae.d("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd sessionId: %s, scanId: %s", new Object[] { Long.valueOf(paramString.FXv), Integer.valueOf(paramString.FXu) });
      paramInt1 = this.doj;
      ae.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, isFinished: %b, isCancelled: %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(this.gJv), Boolean.valueOf(this.isCancelled) });
      if ((!this.gJv) && (!this.isCancelled)) {
        break label409;
      }
      ae.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess isFinished and ignore");
      paramInt1 = i;
    }
    for (;;)
    {
      this.yCu = null;
      if (paramInt1 == 0) {
        break label718;
      }
      ae.d("MicroMsg.AiScanImageUploader", "alvinluo uploadNext: %b, isCancelled: %b", new Object[] { Boolean.valueOf(this.gJv), Boolean.valueOf(this.isCancelled) });
      paramString = this.yCu;
      if (paramString != null) {
        paramString.gJv = true;
      }
      this.yCu = null;
      if ((!this.gJv) && (!this.isCancelled)) {
        break label637;
      }
      AppMethodBeat.o(52155);
      return;
      label355:
      paramString = null;
      break;
      ae.d("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage notifyEvent source: %d, session: %d, event: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l), Integer.valueOf(1) });
      this.yCs.av(paramInt1, l);
      break label153;
      label409:
      if (this.yCu != null)
      {
        paramn = this.yCu;
        if ((paramn == null) || (paramn.gJv != true)) {}
      }
      else
      {
        boolean bool;
        if (this.yCu == null)
        {
          bool = true;
          label446:
          paramString = this.yCu;
          if (paramString == null) {
            break label499;
          }
        }
        label499:
        for (paramString = Boolean.valueOf(paramString.gJv);; paramString = null)
        {
          ae.w("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess runningRequest invalid and ignore isNull: %b, isFinished: %s", new Object[] { Boolean.valueOf(bool), paramString });
          paramInt1 = i;
          break;
          bool = false;
          break label446;
        }
      }
      v.a((w)new d(this, paramString, paramInt1));
      paramInt1 = i;
      continue;
      label526:
      ae.w("MicroMsg.AiScanImageUploader", "alvinluo AiScanImage onSceneEnd success sessionId not the same");
      paramInt1 = i;
    }
    label540:
    if (paramInt2 == 1003) {}
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if ((!this.isCancelled) && (!this.gJv))
      {
        i = this.doj;
        l = ((e)paramn).dmK;
        ae.e("MicroMsg.AiScanImageUploader", "alvinluo onScanFailed source: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2), paramString });
        if (i == 1) {
          v.dOt();
        }
        this.yCs.a(i, l, paramInt2, paramString);
      }
      break;
      label637:
      if (this.yCt != null)
      {
        paramString = this.yCt;
        if (paramString == null) {
          p.gkB();
        }
        if (!paramString.gJv)
        {
          this.yCu = this.yCt;
          paramString = this.yCt;
          if (paramString == null) {
            p.gkB();
          }
          l = paramString.dmK;
          paramString = this.yCt;
          if (paramString == null) {
            p.gkB();
          }
          paramString = paramString.dyY;
          this.yCt = null;
          d(l, paramString);
        }
      }
      label718:
      AppMethodBeat.o(52155);
      return;
    }
  }
  
  public final void z(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(161972);
    ae.i("MicroMsg.AiScanImageUploader", "alvinluo finishResult current: %d, session: %d, success: %b", new Object[] { Long.valueOf(this.yCr), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    q localq;
    if (this.yCr == paramLong)
    {
      this.oDz = false;
      this.gJv = true;
      localq = g.ajj();
      localObject = this.yCu;
      if (localObject == null) {
        break label108;
      }
    }
    label108:
    for (Object localObject = ((c)localObject).yCw;; localObject = null)
    {
      localq.a((n)localObject);
      this.yCt = null;
      this.yCu = null;
      AppMethodBeat.o(161972);
      return;
    }
  }
  
  public final void zv(long paramLong)
  {
    AppMethodBeat.i(52149);
    ae.i("MicroMsg.AiScanImageUploader", "alvinluo cancelResult session: %d", new Object[] { Long.valueOf(paramLong) });
    q localq;
    if (this.yCr == paramLong)
    {
      this.isCancelled = true;
      this.oDz = false;
      localq = g.ajj();
      localObject = this.yCu;
      if (localObject == null) {
        break label86;
      }
    }
    label86:
    for (Object localObject = ((c)localObject).yCw;; localObject = null)
    {
      localq.a((n)localObject);
      this.yCt = null;
      this.yCu = null;
      AppMethodBeat.o(52149);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$AiScanImageUploadCallback;", "", "onUploadError", "", "errCode", "", "onUploadEvent", "source", "session", "", "event", "onUploadFailed", "errMsg", "", "onUploadSuccess", "result", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, long paramLong, int paramInt2, String paramString);
    
    public abstract void a(x paramx);
    
    public abstract void av(int paramInt, long paramLong);
    
    public abstract void dOh();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader$RequestInfo;", "", "(Lcom/tencent/mm/plugin/scanner/model/AiScanImageUploader;)V", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "isFinished", "", "()Z", "setFinished", "(Z)V", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getNetScene", "()Lcom/tencent/mm/modelbase/NetSceneBase;", "setNetScene", "(Lcom/tencent/mm/modelbase/NetSceneBase;)V", "session", "", "getSession", "()J", "setSession", "(J)V", "source", "", "getSource", "()I", "setSource", "(I)V", "plugin-scan_release"})
  final class c
  {
    long dmK;
    int doj;
    Bundle dyY;
    boolean gJv;
    n yCw;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements w
  {
    d(c paramc, me paramme, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(52146);
      final x localx = v.a(paramString, paramInt1);
      h.MqF.aM((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52145);
          localx.doj = this.yCA.yCz;
          ae.i("MicroMsg.AiScanImageUploader", "alvinluo onScanSuccess source: %d, showResult: %b, isFinish: %b, isCancelled: %b", new Object[] { Integer.valueOf(this.yCA.yCz), Boolean.valueOf(localx.yDu), Boolean.valueOf(c.a(this.yCA.yCx)), Boolean.valueOf(c.b(this.yCA.yCx)) });
          if ((!c.a(this.yCA.yCx)) && (!c.b(this.yCA.yCx))) {
            c.c(this.yCA.yCx).a(localx);
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