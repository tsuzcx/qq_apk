package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dbb;
import com.tencent.mm.protocal.protobuf.dbc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetSongStatus;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCommReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "setCommReqResp", "(Lcom/tencent/mm/modelbase/CommReqResp;)V", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusReq;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusReq;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusReq;)V", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusResp;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusResp;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusResp;)V", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-mv_release"})
public final class k
  extends a
{
  private final bds GaB;
  private dbb Gdy;
  public dbc Gdz;
  private final String TAG;
  private i callback;
  private d lKU;
  
  public k(bds parambds, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(230046);
    this.GaB = parambds;
    this.TAG = "MicroMsg.Mv.NetSceneMusicMvGetSongStatus";
    parambds = new d.a();
    parambds.vD(5292);
    parambds.TW("/cgi-bin/micromsg-bin/musiclivegetsongstatus");
    parambds.c((com.tencent.mm.cd.a)new dbb());
    parambds.d((com.tencent.mm.cd.a)new dbc());
    parambds = parambds.bgN();
    p.j(parambds, "commReqResp");
    Object localObject = parambds.bhX();
    if (localObject == null)
    {
      parambds = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetSongStatusReq");
      AppMethodBeat.o(230046);
      throw parambds;
    }
    this.Gdy = ((dbb)localObject);
    localObject = this.Gdy;
    if (localObject != null) {
      ((dbb)localObject).TIm = this.GaB.kkU;
    }
    localObject = this.Gdy;
    if (localObject != null) {
      ((dbb)localObject).TIA = this.GaB.SOJ;
    }
    localObject = this.Gdy;
    if (localObject != null) {
      ((dbb)localObject).TIB = this.GaB.SOK;
    }
    localObject = this.Gdy;
    if (localObject != null) {
      ((dbb)localObject).TIn = this.GaB;
    }
    this.lKU = parambds;
    Log.i(this.TAG, "create NetSceneMusicMvGetSongStatus " + this.GaB.kkU + ' ' + this.GaB.HLH + ' ' + this.GaB.ozs);
    AppMethodBeat.o(230046);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(230043);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(230043);
    return i;
  }
  
  public final int getType()
  {
    return 5292;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(230045);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i(this.TAG, "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(230045);
        return;
      }
      AppMethodBeat.o(230045);
      return;
    }
    params = this.lKU;
    if (params != null) {}
    for (params = params.bhY(); params == null; params = null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetSongStatusResp");
      AppMethodBeat.o(230045);
      throw paramString;
    }
    this.Gdz = ((dbc)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(230045);
      return;
    }
    AppMethodBeat.o(230045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.k
 * JD-Core Version:    0.7.0.1
 */