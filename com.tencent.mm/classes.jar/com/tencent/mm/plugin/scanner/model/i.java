package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.br;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.protocal.protobuf.nr;
import com.tencent.mm.protocal.protobuf.ns;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "source", "", "mode", "requestType", "sessionId", "", "frameId", "usingAI", "", "isAiCrop", "originImageWidth", "originImageHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "adInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "jsApiInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;", "location", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "([BIIIJIZZIILcom/tencent/mm/protocal/protobuf/GoodsObject;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "getSession", "getSource", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends p
  implements m
{
  public static final i.a ORA;
  private h callback;
  long hBk;
  final c rr;
  public int source;
  
  static
  {
    AppMethodBeat.i(52161);
    ORA = new i.a((byte)0);
    AppMethodBeat.o(52161);
  }
  
  public i(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, int paramInt6, GoodsObject paramGoodsObject, no paramno, np paramnp, nq paramnq)
  {
    AppMethodBeat.i(314386);
    this.source = paramInt1;
    this.hBk = paramLong;
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new nr());
    ((c.a)localObject).otF = ((a)new ns());
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/aiscan_image";
    ((c.a)localObject).funcId = 2580;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.rr = ((c)localObject);
    localObject = c.b.b(this.rr.otB);
    if (localObject == null)
    {
      paramArrayOfByte = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRequest");
      AppMethodBeat.o(314386);
      throw paramArrayOfByte;
    }
    localObject = (nr)localObject;
    ((nr)localObject).mode = paramInt2;
    ((nr)localObject).type = paramInt3;
    ((nr)localObject).YPG = b.cX(paramArrayOfByte);
    ((nr)localObject).YPK = paramLong;
    ((nr)localObject).YPJ = paramInt4;
    ((nr)localObject).YPM = paramBoolean1;
    ((nr)localObject).YPL = paramBoolean2;
    ((nr)localObject).YPO = paramInt5;
    ((nr)localObject).YPP = paramInt6;
    if (paramGoodsObject != null) {
      ((nr)localObject).YPN = paramGoodsObject;
    }
    ((nr)localObject).YPQ = paramno;
    ((nr)localObject).YPR = paramnp;
    ((nr)localObject).ORh = paramnq;
    ((nr)localObject).YPS = br.bCJ();
    if (paramnq == null)
    {
      paramGoodsObject = null;
      if (paramnq != null) {
        break label448;
      }
      paramno = null;
      label274:
      if (paramnq != null) {
        break label461;
      }
    }
    label448:
    label461:
    for (paramnp = null;; paramnp = Float.valueOf(paramnq.YPF))
    {
      Log.v("MicroMsg.NetSceneAiScanImage", "alvinluo uploadImage location: %s, %s, %s", new Object[] { paramGoodsObject, paramno, paramnp });
      Log.i("MicroMsg.NetSceneAiScanImage", "alvinluo NetSceneAiScanImage imageSize: %d, sessionId: %d, scanId: %s, requestType: %d, mode: %d, source: %d, usingAI: %b, isAiCrop: %b, originWidth: %d, originHeight: %d, mode: %d, send_srv_time: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Long.valueOf(paramLong), Integer.valueOf(((nr)localObject).YPJ), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(((nr)localObject).mode), Long.valueOf(((nr)localObject).YPS) });
      AppMethodBeat.o(314386);
      return;
      paramGoodsObject = Float.valueOf(paramnq.latitude);
      break;
      paramno = Float.valueOf(paramnq.longitude);
      break label274;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(52159);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(52159);
    return i;
  }
  
  public final int getType()
  {
    return 2580;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52158);
    Log.i("MicroMsg.NetSceneAiScanImage", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(52158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.i
 * JD-Core Version:    0.7.0.1
 */