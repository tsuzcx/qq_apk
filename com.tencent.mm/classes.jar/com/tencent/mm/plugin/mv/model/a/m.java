package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvJoin;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveJoinReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveJoinResp;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class m
  extends a
{
  public static final a GdG;
  private final bds GaB;
  private dbf GdE;
  public dbg GdF;
  private i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(231206);
    GdG = new a((byte)0);
    AppMethodBeat.o(231206);
  }
  
  public m(bds parambds)
  {
    super(1);
    AppMethodBeat.i(231204);
    this.GaB = parambds;
    parambds = new d.a();
    parambds.vD(6893);
    parambds.TW("/cgi-bin/micromsg-bin/musiclivejoin");
    parambds.c((com.tencent.mm.cd.a)new dbf());
    parambds.d((com.tencent.mm.cd.a)new dbg());
    parambds = parambds.bgN();
    p.j(parambds, "commReqRespBuilder.buildInstance()");
    this.lKU = parambds;
    parambds = this.lKU.bhX();
    if (parambds == null)
    {
      parambds = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveJoinReq");
      AppMethodBeat.o(231204);
      throw parambds;
    }
    this.GdE = ((dbf)parambds);
    parambds = this.GdE;
    if (parambds != null) {
      parambds.GaB = this.GaB;
    }
    Log.i("MicroMsg.Mv.NetSceneMusicMvJoin", "create NetSceneMusicMvJoin: " + this.GaB.kkU + ' ' + this.GaB.HLH);
    AppMethodBeat.o(231204);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(231201);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(231201);
    return i;
  }
  
  public final int getType()
  {
    return 6893;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(231203);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvJoin", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(231203);
        return;
      }
      AppMethodBeat.o(231203);
      return;
    }
    params = this.lKU.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveJoinResp");
      AppMethodBeat.o(231203);
      throw paramString;
    }
    this.GdF = ((dbg)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(231203);
      return;
    }
    AppMethodBeat.o(231203);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvJoin$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.m
 * JD-Core Version:    0.7.0.1
 */