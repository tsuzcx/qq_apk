package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/NetSceneBizAiScanImageRetrieval;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "requestId", "", "requestJson", "type", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRequestId", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageRetrievalResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-scan_release"})
public final class h
  extends n
  implements k
{
  public static final a yCN;
  private f callback;
  public String dyb;
  public final b hZD;
  
  static
  {
    AppMethodBeat.i(52165);
    yCN = new a((byte)0);
    AppMethodBeat.o(52165);
  }
  
  public h(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52164);
    this.dyb = paramString1;
    paramString1 = new b.a();
    paramString1.c((a)new mf());
    paramString1.d((a)new mg());
    paramString1.DN("/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_retrieval");
    paramString1.oS(1532);
    paramString1.oU(0);
    paramString1.oV(0);
    paramString1 = paramString1.aDS();
    p.g(paramString1, "builder.buildInstance()");
    this.hZD = paramString1;
    paramString1 = this.hZD.aEU();
    if (paramString1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRetrievalRequest");
      AppMethodBeat.o(52164);
      throw paramString1;
    }
    paramString1 = (mf)paramString1;
    paramString1.FXO = paramString2;
    paramString1.type = 1;
    ae.d("MicroMsg.NetSceneBizAiScanImageRetrieval", "alvinluo AiScanImageRetrieval requestJson: %s, type: %d", new Object[] { paramString2, Integer.valueOf(1) });
    AppMethodBeat.o(52164);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(52162);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.hZD, (k)this);
    AppMethodBeat.o(52162);
    return i;
  }
  
  public final int getType()
  {
    return 1532;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52163);
    ae.i("MicroMsg.NetSceneBizAiScanImageRetrieval", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(52163);
      return;
    }
    AppMethodBeat.o(52163);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/NetSceneBizAiScanImageRetrieval$Companion;", "", "()V", "AI_SCAN_IMAGE_TYPE_RETRIEVAL_BY_KEY", "", "AI_SCAN_IMAGE_TYPE_UNKNOWN", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.h
 * JD-Core Version:    0.7.0.1
 */