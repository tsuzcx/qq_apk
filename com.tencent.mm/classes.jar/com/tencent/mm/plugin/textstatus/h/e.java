package com.tencent.mm.plugin.textstatus.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetFriendInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetFriendInfoReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetFriendInfoResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetFriendInfoResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetFriendInfoResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends p
  implements m
{
  public static final a TmJ;
  
  static
  {
    AppMethodBeat.i(290585);
    TmJ = new a((byte)0);
    AppMethodBeat.o(290585);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(290597);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    AppMethodBeat.o(290597);
    throw null;
  }
  
  public final int getType()
  {
    return 6253;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(290612);
    kotlin.g.b.s.u(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusLike", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AppMethodBeat.o(290612);
    throw null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetFriendInfo$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.e
 * JD-Core Version:    0.7.0.1
 */