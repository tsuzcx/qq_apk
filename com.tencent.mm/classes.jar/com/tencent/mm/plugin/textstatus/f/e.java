package com.tencent.mm.plugin.textstatus.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.g.j;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfHistories;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "context", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfHistoriesResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfHistoriesResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfHistoriesResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class e
  extends q
  implements m
{
  public static final a FYX;
  public j FYW;
  private com.tencent.mm.ak.i callback;
  private final d iUB;
  
  static
  {
    AppMethodBeat.i(216188);
    FYX = new a((byte)0);
    AppMethodBeat.o(216188);
  }
  
  public e(b paramb)
  {
    AppMethodBeat.i(216187);
    Object localObject = new d.a();
    ((d.a)localObject).sG(getType());
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/textstatusgetselfhistories");
    ((d.a)localObject).c((a)new com.tencent.mm.plugin.textstatus.g.i());
    ((d.a)localObject).d((a)new j());
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "commReqRespBuilder.buildInstance()");
    this.iUB = ((d)localObject);
    localObject = this.iUB.aYJ();
    if (localObject == null)
    {
      paramb = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfHistoriesReq");
      AppMethodBeat.o(216187);
      throw paramb;
    }
    ((com.tencent.mm.plugin.textstatus.g.i)localObject).GaF = paramb;
    AppMethodBeat.o(216187);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(216185);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (m)this);
    AppMethodBeat.o(216185);
    return i;
  }
  
  public final int getType()
  {
    return 4245;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(216186);
    p.h(params, "rr");
    Log.i("MicroMsg.TxtStatus.NetSceneTextStatusGetSelfHistories", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.iUB.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfHistoriesResp");
        AppMethodBeat.o(216186);
        throw paramString;
      }
      this.FYW = ((j)params);
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(216186);
      return;
    }
    AppMethodBeat.o(216186);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfHistories$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.e
 * JD-Core Version:    0.7.0.1
 */