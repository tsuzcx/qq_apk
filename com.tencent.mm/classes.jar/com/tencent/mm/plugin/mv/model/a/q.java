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
import com.tencent.mm.protocal.protobuf.dsw;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvJoin;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveJoinReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveJoinResp;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends a
{
  public static final a LZs;
  private final boo LWI;
  private dsw LZt;
  public dsx LZu;
  private h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(286294);
    LZs = new a((byte)0);
    AppMethodBeat.o(286294);
  }
  
  public q(boo paramboo)
  {
    super(1);
    AppMethodBeat.i(286286);
    this.LWI = paramboo;
    paramboo = new c.a();
    paramboo.funcId = 6893;
    paramboo.uri = "/cgi-bin/micromsg-bin/musiclivejoin";
    paramboo.otE = ((com.tencent.mm.bx.a)new dsw());
    paramboo.otF = ((com.tencent.mm.bx.a)new dsx());
    paramboo = paramboo.bEF();
    kotlin.g.b.s.s(paramboo, "commReqRespBuilder.buildInstance()");
    this.oDw = paramboo;
    paramboo = c.b.b(this.oDw.otB);
    if (paramboo == null)
    {
      paramboo = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveJoinReq");
      AppMethodBeat.o(286286);
      throw paramboo;
    }
    this.LZt = ((dsw)paramboo);
    paramboo = this.LZt;
    if (paramboo != null) {
      paramboo.LWI = this.LWI;
    }
    Log.i("MicroMsg.Mv.NetSceneMusicMvJoin", "create NetSceneMusicMvJoin: " + this.LWI.mLQ + ' ' + this.LWI.songName);
    AppMethodBeat.o(286286);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(286304);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(286304);
    return i;
  }
  
  public final int getType()
  {
    return 6893;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(286307);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvJoin", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(286307);
      return;
    }
    params = c.c.b(this.oDw.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveJoinResp");
      AppMethodBeat.o(286307);
      throw paramString;
    }
    this.LZu = ((dsx)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(286307);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvJoin$Companion;", "", "()V", "TAG", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.q
 * JD-Core Version:    0.7.0.1
 */