package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dta;
import com.tencent.mm.protocal.protobuf.dtc;
import com.tencent.mm.protocal.protobuf.dtd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvPostLiveMsg;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "msg", "Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLivePostLiveMsgReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLivePostLiveMsgResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends a
{
  public static final a LZv;
  private dtc LZw;
  public dtd LZx;
  private h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(286264);
    LZv = new a((byte)0);
    AppMethodBeat.o(286264);
  }
  
  public r(dta paramdta, boo paramboo)
  {
    super(1);
    AppMethodBeat.i(286258);
    Object localObject = new c.a();
    ((c.a)localObject).funcId = 6672;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/musiclivepostlivemsg";
    ((c.a)localObject).otE = ((com.tencent.mm.bx.a)new dtc());
    ((c.a)localObject).otF = ((com.tencent.mm.bx.a)new dtd());
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "commReqRespBuilder.buildInstance()");
    this.oDw = ((c)localObject);
    localObject = c.b.b(this.oDw.otB);
    if (localObject == null)
    {
      paramdta = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLivePostLiveMsgReq");
      AppMethodBeat.o(286258);
      throw paramdta;
    }
    this.LZw = ((dtc)localObject);
    localObject = this.LZw;
    if (localObject != null) {
      ((dtc)localObject).aaYD = paramdta;
    }
    paramdta = this.LZw;
    if (paramdta != null) {
      paramdta.aaXW = paramboo;
    }
    AppMethodBeat.o(286258);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(286276);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(286276);
    return i;
  }
  
  public final int getType()
  {
    return 6672;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(286283);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvPostLiveMsg", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(286283);
      return;
    }
    params = c.c.b(this.oDw.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLivePostLiveMsgResp");
      AppMethodBeat.o(286283);
      throw paramString;
    }
    this.LZx = ((dtd)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(286283);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvPostLiveMsg$Companion;", "", "()V", "TAG", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.r
 * JD-Core Version:    0.7.0.1
 */