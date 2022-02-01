package com.tencent.mm.plugin.textstatus.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.textstatus.proto.aj;
import com.tencent.mm.plugin.textstatus.proto.ak;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfLikeds;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "statusId", "", "context", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfLikedsResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfLikedsResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetSelfLikedsResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends p
  implements m
{
  public static final a TmQ;
  public ak TmR;
  private h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(290566);
    TmQ = new a((byte)0);
    AppMethodBeat.o(290566);
  }
  
  public i(String paramString, b paramb)
  {
    AppMethodBeat.i(290559);
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/textstatusgetselflikeds";
    ((c.a)localObject).otE = ((a)new aj());
    ((c.a)localObject).otF = ((a)new ak());
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "commReqRespBuilder.buildInstance()");
    this.oDw = ((c)localObject);
    localObject = c.b.b(this.oDw.otB);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfLikedsReq");
      AppMethodBeat.o(290559);
      throw paramString;
    }
    localObject = (aj)localObject;
    ((aj)localObject).ToK = paramString;
    ((aj)localObject).TpC = paramb;
    AppMethodBeat.o(290559);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(290577);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(290577);
    return i;
  }
  
  public final int getType()
  {
    return 6621;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(290586);
    kotlin.g.b.s.u(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusGetSelfLikeds", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.oDw.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetSelfLikedsResp");
        AppMethodBeat.o(290586);
        throw paramString;
      }
      this.TmR = ((ak)params);
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(290586);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetSelfLikeds$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.i
 * JD-Core Version:    0.7.0.1
 */