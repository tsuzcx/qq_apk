package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.mx;
import com.tencent.mm.protocal.protobuf.my;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/NetSceneBizAiScanImageRetrieval;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "requestId", "", "requestJson", "type", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRequestId", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageRetrievalResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-scan_release"})
public final class j
  extends q
  implements m
{
  public static final a CFC;
  private i callback;
  public String dPI;
  public final d iUB;
  
  static
  {
    AppMethodBeat.i(52165);
    CFC = new a((byte)0);
    AppMethodBeat.o(52165);
  }
  
  public j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52164);
    this.dPI = paramString1;
    paramString1 = new d.a();
    paramString1.c((a)new mx());
    paramString1.d((a)new my());
    paramString1.MB("/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_retrieval");
    paramString1.sG(1532);
    paramString1.sI(0);
    paramString1.sJ(0);
    paramString1 = paramString1.aXF();
    p.g(paramString1, "builder.buildInstance()");
    this.iUB = paramString1;
    paramString1 = this.iUB.aYJ();
    if (paramString1 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRetrievalRequest");
      AppMethodBeat.o(52164);
      throw paramString1;
    }
    paramString1 = (mx)paramString1;
    paramString1.KRB = paramString2;
    paramString1.type = 1;
    Log.d("MicroMsg.NetSceneBizAiScanImageRetrieval", "alvinluo AiScanImageRetrieval requestJson: %s, type: %d", new Object[] { paramString2, Integer.valueOf(1) });
    AppMethodBeat.o(52164);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(52162);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (m)this);
    AppMethodBeat.o(52162);
    return i;
  }
  
  public final int getType()
  {
    return 1532;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52163);
    Log.i("MicroMsg.NetSceneBizAiScanImageRetrieval", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(52163);
      return;
    }
    AppMethodBeat.o(52163);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/NetSceneBizAiScanImageRetrieval$Companion;", "", "()V", "AI_SCAN_IMAGE_TYPE_RETRIEVAL_BY_KEY", "", "AI_SCAN_IMAGE_TYPE_UNKNOWN", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.j
 * JD-Core Version:    0.7.0.1
 */