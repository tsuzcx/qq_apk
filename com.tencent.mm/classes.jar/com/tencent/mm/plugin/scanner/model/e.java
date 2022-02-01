package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.protocal.protobuf.ln;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/NetSceneBizAiScanImageRetrieval;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "requestId", "", "requestJson", "type", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRequestId", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageRetrievalResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-scan_release"})
public final class e
  extends n
  implements com.tencent.mm.network.k
{
  public static final a vOz;
  private g callback;
  public String dnB;
  public final b hdD;
  
  static
  {
    AppMethodBeat.i(52165);
    vOz = new a((byte)0);
    AppMethodBeat.o(52165);
  }
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52164);
    this.dnB = paramString1;
    paramString1 = new b.a();
    paramString1.c((a)new lm());
    paramString1.d((a)new ln());
    paramString1.wg("/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_retrieval");
    paramString1.nB(1532);
    paramString1.nD(0);
    paramString1.nE(0);
    paramString1 = paramString1.atI();
    d.g.b.k.g(paramString1, "builder.buildInstance()");
    this.hdD = paramString1;
    paramString1 = this.hdD.auL();
    if (paramString1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRetrievalRequest");
      AppMethodBeat.o(52164);
      throw paramString1;
    }
    paramString1 = (lm)paramString1;
    paramString1.CHp = paramString2;
    paramString1.type = 1;
    ad.d("MicroMsg.NetSceneBizAiScanImageRetrieval", "alvinluo AiScanImageRetrieval requestJson: %s, type: %d", new Object[] { paramString2, Integer.valueOf(1) });
    AppMethodBeat.o(52164);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(52162);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.hdD, (com.tencent.mm.network.k)this);
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
    ad.i("MicroMsg.NetSceneBizAiScanImageRetrieval", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(52163);
      return;
    }
    AppMethodBeat.o(52163);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/NetSceneBizAiScanImageRetrieval$Companion;", "", "()V", "AI_SCAN_IMAGE_TYPE_RETRIEVAL_BY_KEY", "", "AI_SCAN_IMAGE_TYPE_UNKNOWN", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.e
 * JD-Core Version:    0.7.0.1
 */