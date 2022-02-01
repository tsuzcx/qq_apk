package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetHistory;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "topicId", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetHistory$TextStatusGetHistoryReq;", "<set-?>", "Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetHistory$TextStatusGetHistoryResp;", "response", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetHistory$TextStatusGetHistoryResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "TextStatusGetHistoryReq", "TextStatusGetHistoryResp", "plugin-textstatus_release"})
public final class e
  extends q
  implements m
{
  public static final a MDg;
  
  static
  {
    AppMethodBeat.i(235575);
    MDg = new a((byte)0);
    AppMethodBeat.o(235575);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(235570);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    AppMethodBeat.o(235570);
    throw null;
  }
  
  public final int getType()
  {
    return 6253;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(235574);
    p.k(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetHistory", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AppMethodBeat.o(235574);
    throw null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetHistory$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.e
 * JD-Core Version:    0.7.0.1
 */