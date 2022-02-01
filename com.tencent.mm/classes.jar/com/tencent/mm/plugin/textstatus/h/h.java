package com.tencent.mm.plugin.textstatus.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.textstatus.proto.af;
import com.tencent.mm.plugin.textstatus.proto.ag;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfHistories;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "context", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfHistoriesResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfHistoriesResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfHistoriesResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends p
  implements m
{
  public static final a TmO;
  public ag TmP;
  private com.tencent.mm.am.h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(290596);
    TmO = new a((byte)0);
    AppMethodBeat.o(290596);
  }
  
  public h(b paramb)
  {
    AppMethodBeat.i(290573);
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/textstatusgetselfhistories";
    ((c.a)localObject).otE = ((a)new af());
    ((c.a)localObject).otF = ((a)new ag());
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "commReqRespBuilder.buildInstance()");
    this.oDw = ((c)localObject);
    localObject = c.b.b(this.oDw.otB);
    if (localObject == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfHistoriesReq");
      AppMethodBeat.o(290573);
      throw paramb;
    }
    ((af)localObject).TpC = paramb;
    AppMethodBeat.o(290573);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(290623);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(290623);
    return i;
  }
  
  public final int getType()
  {
    return 4245;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(290631);
    kotlin.g.b.s.u(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetSelfHistories", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.oDw.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfHistoriesResp");
        AppMethodBeat.o(290631);
        throw paramString;
      }
      this.TmP = ((ag)params);
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(290631);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfHistories$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.h
 * JD-Core Version:    0.7.0.1
 */