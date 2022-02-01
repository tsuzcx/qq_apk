package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.protocal.protobuf.nu;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/NetSceneBizAiScanImageRetrieval;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "requestId", "", "requestJson", "type", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRequestId", "getResp", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageRetrievalResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends p
  implements com.tencent.mm.network.m
{
  public static final a ORG;
  private h callback;
  public String hOG;
  public final c oDw;
  
  static
  {
    AppMethodBeat.i(52165);
    ORG = new a((byte)0);
    AppMethodBeat.o(52165);
  }
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52164);
    this.hOG = paramString1;
    paramString1 = new c.a();
    paramString1.otE = ((a)new nt());
    paramString1.otF = ((a)new nu());
    paramString1.uri = "/cgi-bin/mmbiz-bin/usrmsg/aiscan_image_retrieval";
    paramString1.funcId = 1532;
    paramString1.otG = 0;
    paramString1.respCmdId = 0;
    paramString1 = paramString1.bEF();
    kotlin.g.b.s.s(paramString1, "builder.buildInstance()");
    this.oDw = paramString1;
    paramString1 = c.b.b(this.oDw.otB);
    if (paramString1 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAiScanImageRetrievalRequest");
      AppMethodBeat.o(52164);
      throw paramString1;
    }
    paramString1 = (nt)paramString1;
    paramString1.YQb = paramString2;
    paramString1.type = 1;
    Log.d("MicroMsg.NetSceneBizAiScanImageRetrieval", "alvinluo AiScanImageRetrieval requestJson: %s, type: %d", new Object[] { paramString2, Integer.valueOf(1) });
    AppMethodBeat.o(52164);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(52162);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(52162);
    return i;
  }
  
  public final int getType()
  {
    return 1532;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52163);
    Log.i("MicroMsg.NetSceneBizAiScanImageRetrieval", "alvinluo onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(52163);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/NetSceneBizAiScanImageRetrieval$Companion;", "", "()V", "AI_SCAN_IMAGE_TYPE_RETRIEVAL_BY_KEY", "", "AI_SCAN_IMAGE_TYPE_UNKNOWN", "TAG", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.m
 * JD-Core Version:    0.7.0.1
 */