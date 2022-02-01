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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetFriendInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetFriendInfoReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetFriendInfoResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetFriendInfoResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetFriendInfoResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class d
  extends q
  implements m
{
  public static final a MDf;
  
  static
  {
    AppMethodBeat.i(234936);
    MDf = new a((byte)0);
    AppMethodBeat.o(234936);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(234928);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    AppMethodBeat.o(234928);
    throw null;
  }
  
  public final int getType()
  {
    return 6253;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(234932);
    p.k(params, "rr");
    Log.i("MicroMsg.TextStatus.NetSceneTextStatusLike", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AppMethodBeat.o(234932);
    throw null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetFriendInfo$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.d
 * JD-Core Version:    0.7.0.1
 */