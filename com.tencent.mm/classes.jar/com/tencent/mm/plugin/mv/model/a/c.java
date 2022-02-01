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
import com.tencent.mm.protocal.protobuf.dat;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvCheckPermission;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionReq;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionReq;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionReq;)V", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionResp;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionResp;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionResp;)V", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-mv_release"})
public final class c
  extends a
{
  private final bds GaB;
  private dat Gdc;
  public dau Gdd;
  private final String TAG;
  private i callback;
  private d lKU;
  
  public c(bds parambds, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(229921);
    this.GaB = parambds;
    this.TAG = "MicroMsg.Mv.NetSceneMusicMvCheckPermission";
    parambds = new d.a();
    parambds.vD(5286);
    parambds.TW("/cgi-bin/micromsg-bin/musiclivecheckpermission");
    parambds.c((com.tencent.mm.cd.a)new dat());
    parambds.d((com.tencent.mm.cd.a)new dau());
    parambds = parambds.bgN();
    p.j(parambds, "commReqResp");
    Object localObject = parambds.bhX();
    if (localObject == null)
    {
      parambds = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveCheckPermissionReq");
      AppMethodBeat.o(229921);
      throw parambds;
    }
    this.Gdc = ((dat)localObject);
    localObject = this.Gdc;
    if (localObject != null) {
      ((dat)localObject).TIn = this.GaB;
    }
    this.lKU = parambds;
    AppMethodBeat.o(229921);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(229916);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(229916);
    return i;
  }
  
  public final int getType()
  {
    return 5286;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(229919);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i(this.TAG, "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(229919);
        return;
      }
      AppMethodBeat.o(229919);
      return;
    }
    params = this.lKU;
    if (params != null) {}
    for (params = params.bhY(); params == null; params = null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveCheckPermissionResp");
      AppMethodBeat.o(229919);
      throw paramString;
    }
    this.Gdd = ((dau)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(229919);
      return;
    }
    AppMethodBeat.o(229919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.c
 * JD-Core Version:    0.7.0.1
 */