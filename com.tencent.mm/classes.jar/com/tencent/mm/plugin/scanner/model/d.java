package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.lq;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "source", "", "mode", "sessionId", "", "frameId", "usingAI", "", "isAiCrop", "originImageWidth", "originImageHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "adInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "([BIIJIZZIILcom/tencent/mm/protocal/protobuf/GoodsObject;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "getSession", "getSource", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"})
public final class d
  extends n
  implements com.tencent.mm.network.k
{
  public static final d.a wYU;
  private g callback;
  long dao;
  public int dbL;
  final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(52161);
    wYU = new d.a((byte)0);
    AppMethodBeat.o(52161);
  }
  
  public d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, int paramInt5, GoodsObject paramGoodsObject, lq paramlq)
  {
    AppMethodBeat.i(199583);
    this.dbL = paramInt1;
    this.dao = paramLong;
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new lr());
    ((b.a)localObject).d((a)new ls());
    ((b.a)localObject).Am("/cgi-bin/mmbiz-bin/usrmsg/aiscan_image");
    ((b.a)localObject).op(2580);
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.b)localObject);
    localObject = this.rr.aBC();
    if (localObject == null)
    {
      paramArrayOfByte = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRequest");
      AppMethodBeat.o(199583);
      throw paramArrayOfByte;
    }
    localObject = (lr)localObject;
    ((lr)localObject).mode = paramInt2;
    ((lr)localObject).DZw = com.tencent.mm.bw.b.cc(paramArrayOfByte);
    ((lr)localObject).DZC = paramLong;
    ((lr)localObject).DZB = paramInt3;
    ((lr)localObject).DZE = paramBoolean1;
    ((lr)localObject).DZD = paramBoolean2;
    ((lr)localObject).DZG = paramInt4;
    ((lr)localObject).DZH = paramInt5;
    if (paramGoodsObject != null) {
      ((lr)localObject).DZF = paramGoodsObject;
    }
    ((lr)localObject).DZI = paramlq;
    ((lr)localObject).DZJ = bi.ayX();
    ac.i("MicroMsg.NetSceneAiScanImage", "alvinluo NetSceneAiScanImage imageSize: %d, sessionId: %d, scanId: %s, mode: %d, source: %d, usingAI: %b, isAiCrop: %b, originWidth: %d, originHeight: %d, mode: %d, send_srv_time: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Long.valueOf(paramLong), Integer.valueOf(((lr)localObject).DZB), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(((lr)localObject).mode), Long.valueOf(((lr)localObject).DZJ) });
    AppMethodBeat.o(199583);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(52159);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(52159);
    return i;
  }
  
  public final int getType()
  {
    return 2580;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52158);
    ac.i("MicroMsg.NetSceneAiScanImage", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(52158);
      return;
    }
    AppMethodBeat.o(52158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.d
 * JD-Core Version:    0.7.0.1
 */