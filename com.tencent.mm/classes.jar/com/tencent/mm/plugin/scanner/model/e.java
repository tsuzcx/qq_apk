package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.bl;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.ma;
import com.tencent.mm.protocal.protobuf.mb;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/NetSceneAiScanImage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "imageData", "", "source", "", "mode", "requestType", "sessionId", "", "frameId", "usingAI", "", "isAiCrop", "originImageWidth", "originImageHeight", "cropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "adInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;", "jsApiInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;", "location", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;", "([BIIIJIZZIILcom/tencent/mm/protocal/protobuf/GoodsObject;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageAdInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageJsapiInfo;Lcom/tencent/mm/protocal/protobuf/BizAiScanImageLocation;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "session", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "getSession", "getSource", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "Companion", "plugin-scan_release"})
public final class e
  extends n
  implements k
{
  public static final e.a yCK;
  private f callback;
  long dmK;
  public int doj;
  final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(52161);
    yCK = new e.a((byte)0);
    AppMethodBeat.o(52161);
  }
  
  public e(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, int paramInt6, GoodsObject paramGoodsObject, ma paramma, mb parammb, mc parammc)
  {
    AppMethodBeat.i(189559);
    this.doj = paramInt1;
    this.dmK = paramLong;
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new md());
    ((b.a)localObject).d((a)new me());
    ((b.a)localObject).DN("/cgi-bin/mmbiz-bin/usrmsg/aiscan_image");
    ((b.a)localObject).oS(2580);
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.b)localObject);
    localObject = this.rr.aEU();
    if (localObject == null)
    {
      paramArrayOfByte = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRequest");
      AppMethodBeat.o(189559);
      throw paramArrayOfByte;
    }
    localObject = (md)localObject;
    ((md)localObject).mode = paramInt2;
    ((md)localObject).type = paramInt3;
    ((md)localObject).FXp = com.tencent.mm.bw.b.cm(paramArrayOfByte);
    ((md)localObject).FXv = paramLong;
    ((md)localObject).FXu = paramInt4;
    ((md)localObject).FXx = paramBoolean1;
    ((md)localObject).FXw = paramBoolean2;
    ((md)localObject).FXz = paramInt5;
    ((md)localObject).FXA = paramInt6;
    if (paramGoodsObject != null) {
      ((md)localObject).FXy = paramGoodsObject;
    }
    ((md)localObject).FXC = paramma;
    ((md)localObject).FXD = parammb;
    ((md)localObject).FXB = parammc;
    ((md)localObject).FXE = bl.aCr();
    if (parammc != null)
    {
      paramGoodsObject = Float.valueOf(parammc.dzE);
      if (parammc == null) {
        break label459;
      }
      paramma = Float.valueOf(parammc.dBu);
      label285:
      if (parammc == null) {
        break label465;
      }
    }
    label459:
    label465:
    for (parammb = Float.valueOf(parammc.FXo);; parammb = null)
    {
      ae.v("MicroMsg.NetSceneAiScanImage", "alvinluo uploadImage location: %s, %s, %s", new Object[] { paramGoodsObject, paramma, parammb });
      ae.i("MicroMsg.NetSceneAiScanImage", "alvinluo NetSceneAiScanImage imageSize: %d, sessionId: %d, scanId: %s, requestType: %d, mode: %d, source: %d, usingAI: %b, isAiCrop: %b, originWidth: %d, originHeight: %d, mode: %d, send_srv_time: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Long.valueOf(paramLong), Integer.valueOf(((md)localObject).FXu), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(((md)localObject).mode), Long.valueOf(((md)localObject).FXE) });
      AppMethodBeat.o(189559);
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
    ae.i("MicroMsg.NetSceneAiScanImage", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
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
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.e
 * JD-Core Version:    0.7.0.1
 */