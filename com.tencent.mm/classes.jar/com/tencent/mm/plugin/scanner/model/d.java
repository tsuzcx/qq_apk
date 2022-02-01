package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.lk;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "source", "", "sessionId", "", "frameId", "usingAI", "", "isAiCrop", "originImageWidth", "originImageHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "([BIJIZZIILcom/tencent/mm/protocal/protobuf/GoodsObject;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "getSession", "getSource", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"})
public final class d
  extends n
  implements com.tencent.mm.network.k
{
  public static final d.a vOy;
  private g callback;
  long dcQ;
  public int dep;
  final com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(52161);
    vOy = new d.a((byte)0);
    AppMethodBeat.o(52161);
  }
  
  public d(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, int paramInt4, GoodsObject paramGoodsObject)
  {
    AppMethodBeat.i(52160);
    this.dep = paramInt1;
    this.dcQ = paramLong;
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new lk());
    ((b.a)localObject).d((a)new ll());
    ((b.a)localObject).wg("/cgi-bin/mmbiz-bin/usrmsg/aiscan_image");
    ((b.a)localObject).nB(2580);
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.al.b)localObject);
    localObject = this.rr.auL();
    if (localObject == null)
    {
      paramArrayOfByte = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRequest");
      AppMethodBeat.o(52160);
      throw paramArrayOfByte;
    }
    localObject = (lk)localObject;
    if (paramInt1 == 1) {
      ((lk)localObject).mode = 0;
    }
    for (;;)
    {
      ((lk)localObject).CGV = com.tencent.mm.bx.b.cd(paramArrayOfByte);
      ((lk)localObject).CHb = paramLong;
      ((lk)localObject).CHa = paramInt2;
      ((lk)localObject).CHd = paramBoolean1;
      ((lk)localObject).CHc = paramBoolean2;
      ((lk)localObject).CHf = paramInt3;
      ((lk)localObject).CHg = paramInt4;
      if (paramGoodsObject != null) {
        ((lk)localObject).CHe = paramGoodsObject;
      }
      ((lk)localObject).CHh = bi.asg();
      ad.i("MicroMsg.NetSceneAiScanImage", "alvinluo NetSceneAiScanImage imageSize: %d, sessionId: %d, scanId: %s, source: %d, usingAI: %b, isAiCrop: %b, originWidth: %d, originHeight: %d, mode: %d, send_srv_time: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Long.valueOf(paramLong), Integer.valueOf(((lk)localObject).CHa), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(((lk)localObject).mode), Long.valueOf(((lk)localObject).CHh) });
      AppMethodBeat.o(52160);
      return;
      if (paramInt1 == 2) {
        ((lk)localObject).mode = 1;
      }
    }
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
    ad.i("MicroMsg.NetSceneAiScanImage", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.d
 * JD-Core Version:    0.7.0.1
 */