package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.bp;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.ms;
import com.tencent.mm.protocal.protobuf.mt;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.protocal.protobuf.mv;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "source", "", "mode", "requestType", "sessionId", "", "frameId", "usingAI", "", "isAiCrop", "originImageWidth", "originImageHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "adInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "jsApiInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;", "location", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "([BIIIJIZZIILcom/tencent/mm/protocal/protobuf/GoodsObject;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "getSession", "getSource", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"})
public final class g
  extends q
  implements m
{
  public static final g.a CFz;
  private i callback;
  long dDZ;
  final d rr;
  public int source;
  
  static
  {
    AppMethodBeat.i(52161);
    CFz = new g.a((byte)0);
    AppMethodBeat.o(52161);
  }
  
  public g(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, int paramInt6, GoodsObject paramGoodsObject, ms paramms, mt parammt, mu parammu)
  {
    AppMethodBeat.i(240402);
    this.source = paramInt1;
    this.dDZ = paramLong;
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new mv());
    ((d.a)localObject).d((a)new mw());
    ((d.a)localObject).MB("/cgi-bin/mmbiz-bin/usrmsg/aiscan_image");
    ((d.a)localObject).sG(2580);
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    localObject = this.rr.aYJ();
    if (localObject == null)
    {
      paramArrayOfByte = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRequest");
      AppMethodBeat.o(240402);
      throw paramArrayOfByte;
    }
    localObject = (mv)localObject;
    ((mv)localObject).mode = paramInt2;
    ((mv)localObject).type = paramInt3;
    ((mv)localObject).KRc = b.cD(paramArrayOfByte);
    ((mv)localObject).KRi = paramLong;
    ((mv)localObject).KRh = paramInt4;
    ((mv)localObject).KRk = paramBoolean1;
    ((mv)localObject).KRj = paramBoolean2;
    ((mv)localObject).KRm = paramInt5;
    ((mv)localObject).KRn = paramInt6;
    if (paramGoodsObject != null) {
      ((mv)localObject).KRl = paramGoodsObject;
    }
    ((mv)localObject).KRp = paramms;
    ((mv)localObject).KRq = parammt;
    ((mv)localObject).KRo = parammu;
    ((mv)localObject).KRr = bp.aVP();
    if (parammu != null)
    {
      paramGoodsObject = Float.valueOf(parammu.latitude);
      if (parammu == null) {
        break label459;
      }
      paramms = Float.valueOf(parammu.dTj);
      label285:
      if (parammu == null) {
        break label465;
      }
    }
    label459:
    label465:
    for (parammt = Float.valueOf(parammu.KRb);; parammt = null)
    {
      Log.v("MicroMsg.NetSceneAiScanImage", "alvinluo uploadImage location: %s, %s, %s", new Object[] { paramGoodsObject, paramms, parammt });
      Log.i("MicroMsg.NetSceneAiScanImage", "alvinluo NetSceneAiScanImage imageSize: %d, sessionId: %d, scanId: %s, requestType: %d, mode: %d, source: %d, usingAI: %b, isAiCrop: %b, originWidth: %d, originHeight: %d, mode: %d, send_srv_time: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Long.valueOf(paramLong), Integer.valueOf(((mv)localObject).KRh), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(((mv)localObject).mode), Long.valueOf(((mv)localObject).KRr) });
      AppMethodBeat.o(240402);
      return;
      paramGoodsObject = null;
      break;
      paramms = null;
      break label285;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(52159);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(52159);
    return i;
  }
  
  public final int getType()
  {
    return 2580;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52158);
    Log.i("MicroMsg.NetSceneAiScanImage", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(52158);
      return;
    }
    AppMethodBeat.o(52158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.g
 * JD-Core Version:    0.7.0.1
 */