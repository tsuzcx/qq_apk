package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.bq;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.mj;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.protocal.protobuf.ml;
import com.tencent.mm.protocal.protobuf.mm;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "source", "", "mode", "requestType", "sessionId", "", "frameId", "usingAI", "", "isAiCrop", "originImageWidth", "originImageHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "adInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "jsApiInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;", "location", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "([BIIIJIZZIILcom/tencent/mm/protocal/protobuf/GoodsObject;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "getSession", "getSource", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"})
public final class e
  extends q
  implements m
{
  public static final a IKM;
  private i callback;
  long fwK;
  final d rr;
  public int source;
  
  static
  {
    AppMethodBeat.i(52161);
    IKM = new a((byte)0);
    AppMethodBeat.o(52161);
  }
  
  public e(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, int paramInt6, GoodsObject paramGoodsObject, mj parammj, mk parammk, ml paramml)
  {
    AppMethodBeat.i(218043);
    this.source = paramInt1;
    this.fwK = paramLong;
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new mm());
    ((d.a)localObject).d((a)new mn());
    ((d.a)localObject).TW("/cgi-bin/mmbiz-bin/usrmsg/aiscan_image");
    ((d.a)localObject).vD(2580);
    ((d.a)localObject).vF(0);
    ((d.a)localObject).vG(0);
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    localObject = this.rr.bhX();
    if (localObject == null)
    {
      paramArrayOfByte = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRequest");
      AppMethodBeat.o(218043);
      throw paramArrayOfByte;
    }
    localObject = (mm)localObject;
    ((mm)localObject).mode = paramInt2;
    ((mm)localObject).type = paramInt3;
    ((mm)localObject).RSg = b.cU(paramArrayOfByte);
    ((mm)localObject).RSk = paramLong;
    ((mm)localObject).RSj = paramInt4;
    ((mm)localObject).RSm = paramBoolean1;
    ((mm)localObject).RSl = paramBoolean2;
    ((mm)localObject).RSo = paramInt5;
    ((mm)localObject).RSp = paramInt6;
    if (paramGoodsObject != null) {
      ((mm)localObject).RSn = paramGoodsObject;
    }
    ((mm)localObject).RSq = parammj;
    ((mm)localObject).RSr = parammk;
    ((mm)localObject).IKy = paramml;
    ((mm)localObject).RSs = bq.beS();
    if (paramml != null)
    {
      paramGoodsObject = Float.valueOf(paramml.latitude);
      if (paramml == null) {
        break label459;
      }
      parammj = Float.valueOf(paramml.longitude);
      label285:
      if (paramml == null) {
        break label465;
      }
    }
    label459:
    label465:
    for (parammk = Float.valueOf(paramml.RSf);; parammk = null)
    {
      Log.v("MicroMsg.NetSceneAiScanImage", "alvinluo uploadImage location: %s, %s, %s", new Object[] { paramGoodsObject, parammj, parammk });
      Log.i("MicroMsg.NetSceneAiScanImage", "alvinluo NetSceneAiScanImage imageSize: %d, sessionId: %d, scanId: %s, requestType: %d, mode: %d, source: %d, usingAI: %b, isAiCrop: %b, originWidth: %d, originHeight: %d, mode: %d, send_srv_time: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Long.valueOf(paramLong), Integer.valueOf(((mm)localObject).RSj), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(((mm)localObject).mode), Long.valueOf(((mm)localObject).RSs) });
      AppMethodBeat.o(218043);
      return;
      paramGoodsObject = null;
      break;
      parammj = null;
      break label285;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(52159);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImage$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.e
 * JD-Core Version:    0.7.0.1
 */