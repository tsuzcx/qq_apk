package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.proto.r;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfHistories;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "context", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfHistoriesResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfHistoriesResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfHistoriesResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class g
  extends com.tencent.mm.an.q
  implements m
{
  public static final a MDl;
  public r MDk;
  private i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(232786);
    MDl = new a((byte)0);
    AppMethodBeat.o(232786);
  }
  
  public g(b paramb)
  {
    AppMethodBeat.i(232784);
    Object localObject = new d.a();
    ((d.a)localObject).vD(getType());
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/textstatusgetselfhistories");
    ((d.a)localObject).c((a)new com.tencent.mm.plugin.textstatus.proto.q());
    ((d.a)localObject).d((a)new r());
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "commReqRespBuilder.buildInstance()");
    this.lKU = ((d)localObject);
    localObject = this.lKU.bhX();
    if (localObject == null)
    {
      paramb = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfHistoriesReq");
      AppMethodBeat.o(232784);
      throw paramb;
    }
    ((com.tencent.mm.plugin.textstatus.proto.q)localObject).MFp = paramb;
    AppMethodBeat.o(232784);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(232782);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(232782);
    return i;
  }
  
  public final int getType()
  {
    return 4245;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(232783);
    p.k(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetSelfHistories", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.lKU.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfHistoriesResp");
        AppMethodBeat.o(232783);
        throw paramString;
      }
      this.MDk = ((r)params);
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.an.q)this);
      AppMethodBeat.o(232783);
      return;
    }
    AppMethodBeat.o(232783);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfHistories$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.g
 * JD-Core Version:    0.7.0.1
 */