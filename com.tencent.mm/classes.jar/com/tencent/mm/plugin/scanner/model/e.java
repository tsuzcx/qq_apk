package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.bj;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.ma;
import com.tencent.mm.protocal.protobuf.mb;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "source", "", "mode", "requestType", "sessionId", "", "frameId", "usingAI", "", "isAiCrop", "originImageWidth", "originImageHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "adInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "jsApiInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;", "location", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "([BIIIJIZZIILcom/tencent/mm/protocal/protobuf/GoodsObject;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "getSession", "getSource", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"})
public final class e
  extends n
  implements k
{
  public static final e.a ymM;
  private f callback;
  long dlI;
  public int dnh;
  final com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(52161);
    ymM = new e.a((byte)0);
    AppMethodBeat.o(52161);
  }
  
  public e(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, int paramInt6, GoodsObject paramGoodsObject, ma paramma, mb parammb, mc parammc)
  {
    AppMethodBeat.i(186274);
    this.dnh = paramInt1;
    this.dlI = paramLong;
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new md());
    ((b.a)localObject).d((a)new me());
    ((b.a)localObject).Dl("/cgi-bin/mmbiz-bin/usrmsg/aiscan_image");
    ((b.a)localObject).oP(2580);
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.al.b)localObject);
    localObject = this.rr.aEE();
    if (localObject == null)
    {
      paramArrayOfByte = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRequest");
      AppMethodBeat.o(186274);
      throw paramArrayOfByte;
    }
    localObject = (md)localObject;
    ((md)localObject).mode = paramInt2;
    ((md)localObject).type = paramInt3;
    ((md)localObject).FEU = com.tencent.mm.bx.b.cj(paramArrayOfByte);
    ((md)localObject).FFa = paramLong;
    ((md)localObject).FEZ = paramInt4;
    ((md)localObject).FFc = paramBoolean1;
    ((md)localObject).FFb = paramBoolean2;
    ((md)localObject).FFe = paramInt5;
    ((md)localObject).FFf = paramInt6;
    if (paramGoodsObject != null) {
      ((md)localObject).FFd = paramGoodsObject;
    }
    ((md)localObject).FFh = paramma;
    ((md)localObject).FFi = parammb;
    ((md)localObject).FFg = parammc;
    ((md)localObject).FFj = bj.aCb();
    if (parammc != null)
    {
      paramGoodsObject = Float.valueOf(parammc.dyz);
      if (parammc == null) {
        break label459;
      }
      paramma = Float.valueOf(parammc.dAp);
      label285:
      if (parammc == null) {
        break label465;
      }
    }
    label459:
    label465:
    for (parammb = Float.valueOf(parammc.FET);; parammb = null)
    {
      ad.v("MicroMsg.NetSceneAiScanImage", "alvinluo uploadImage location: %s, %s, %s", new Object[] { paramGoodsObject, paramma, parammb });
      ad.i("MicroMsg.NetSceneAiScanImage", "alvinluo NetSceneAiScanImage imageSize: %d, sessionId: %d, scanId: %s, requestType: %d, mode: %d, source: %d, usingAI: %b, isAiCrop: %b, originWidth: %d, originHeight: %d, mode: %d, send_srv_time: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Long.valueOf(paramLong), Integer.valueOf(((md)localObject).FEZ), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(((md)localObject).mode), Long.valueOf(((md)localObject).FFj) });
      AppMethodBeat.o(186274);
      return;
      paramGoodsObject = null;
      break;
      paramma = null;
      break label285;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(52159);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.e
 * JD-Core Version:    0.7.0.1
 */