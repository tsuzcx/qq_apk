package com.tencent.mm.plugin.textstatus.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.textstatus.g.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetFriendInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetFriendInfoReq;", "response", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetFriendInfoResp;", "getResponse", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetFriendInfoResp;", "setResponse", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetFriendInfoResp;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-textstatus_release"})
public final class c
  extends q
  implements m
{
  public static final a FYT;
  private h FYS;
  private i callback;
  private final d iUB;
  
  static
  {
    AppMethodBeat.i(216181);
    FYT = new a((byte)0);
    AppMethodBeat.o(216181);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(216179);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (m)this);
    AppMethodBeat.o(216179);
    return i;
  }
  
  public final int getType()
  {
    return 6253;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(216180);
    p.h(params, "rr");
    Log.i("MicroMsg.TxtStatus.NetSceneTextStatusLike", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.iUB.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.proto.TextStatusGetFriendInfoResp");
      AppMethodBeat.o(216180);
      throw paramString;
    }
    this.FYS = ((h)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(216180);
      return;
    }
    AppMethodBeat.o(216180);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/NetSceneTextStatusGetFriendInfo$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.c
 * JD-Core Version:    0.7.0.1
 */