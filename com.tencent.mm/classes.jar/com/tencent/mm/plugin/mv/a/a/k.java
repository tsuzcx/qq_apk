package com.tencent.mm.plugin.mv.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvJoin;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveJoinReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveJoinResp;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class k
  extends m
{
  public static final a AqU;
  private csg AqS;
  public csh AqT;
  private final axy Aqo;
  private i callback;
  private final d iUB;
  
  static
  {
    AppMethodBeat.i(256853);
    AqU = new a((byte)0);
    AppMethodBeat.o(256853);
  }
  
  public k(axy paramaxy, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(258865);
    this.Aqo = paramaxy;
    paramaxy = new d.a();
    paramaxy.sG(6893);
    paramaxy.MB("/cgi-bin/micromsg-bin/musiclivejoin");
    paramaxy.c((a)new csg());
    paramaxy.d((a)new csh());
    paramaxy = paramaxy.aXF();
    p.g(paramaxy, "commReqRespBuilder.buildInstance()");
    this.iUB = paramaxy;
    paramaxy = this.iUB.aYJ();
    if (paramaxy == null)
    {
      paramaxy = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveJoinReq");
      AppMethodBeat.o(258865);
      throw paramaxy;
    }
    this.AqS = ((csg)paramaxy);
    paramaxy = this.AqS;
    if (paramaxy != null) {
      paramaxy.Aqo = this.Aqo;
    }
    Log.i("MicroMsg.Mv.NetSceneMusicMvJoin", "create NetSceneMusicMvJoin: " + this.Aqo.AqO + ' ' + this.Aqo.BPc);
    AppMethodBeat.o(258865);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(256850);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(256850);
    return i;
  }
  
  public final int getType()
  {
    return 6893;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256851);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvJoin", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(256851);
        return;
      }
      AppMethodBeat.o(256851);
      return;
    }
    params = this.iUB.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveJoinResp");
      AppMethodBeat.o(256851);
      throw paramString;
    }
    this.AqT = ((csh)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(256851);
      return;
    }
    AppMethodBeat.o(256851);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvJoin$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a.k
 * JD-Core Version:    0.7.0.1
 */