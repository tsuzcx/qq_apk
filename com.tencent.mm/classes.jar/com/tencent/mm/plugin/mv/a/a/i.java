package com.tencent.mm.plugin.mv.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetSongStatus;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCommReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "setCommReqResp", "(Lcom/tencent/mm/modelbase/CommReqResp;)V", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusReq;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusReq;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusReq;)V", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusResp;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusResp;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusResp;)V", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-mv_release"})
public final class i
  extends m
{
  private csc AqK;
  public csd AqL;
  private final axy Aqo;
  private final String TAG;
  private com.tencent.mm.ak.i callback;
  private d iUB;
  
  public i(axy paramaxy, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(258863);
    this.Aqo = paramaxy;
    this.TAG = "MicroMsg.Mv.NetSceneMusicMvGetSongStatus";
    paramaxy = new d.a();
    paramaxy.sG(5292);
    paramaxy.MB("/cgi-bin/micromsg-bin/musiclivegetsongstatus");
    paramaxy.c((a)new csc());
    paramaxy.d((a)new csd());
    paramaxy = paramaxy.aXF();
    p.g(paramaxy, "commReqResp");
    Object localObject = paramaxy.aYJ();
    if (localObject == null)
    {
      paramaxy = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetSongStatusReq");
      AppMethodBeat.o(258863);
      throw paramaxy;
    }
    this.AqK = ((csc)localObject);
    localObject = this.AqK;
    if (localObject != null) {
      ((csc)localObject).MwX = this.Aqo.AqO;
    }
    localObject = this.AqK;
    if (localObject != null) {
      ((csc)localObject).Mxj = this.Aqo.LIf;
    }
    localObject = this.AqK;
    if (localObject != null) {
      ((csc)localObject).Mxk = this.Aqo.LIg;
    }
    localObject = this.AqK;
    if (localObject != null) {
      ((csc)localObject).MwY = this.Aqo;
    }
    this.iUB = paramaxy;
    Log.i(this.TAG, "create NetSceneMusicMvGetSongStatus " + this.Aqo.AqO + ' ' + this.Aqo.BPc + ' ' + this.Aqo.lDR);
    AppMethodBeat.o(258863);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(256843);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(256843);
    return i;
  }
  
  public final int getType()
  {
    return 5292;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256844);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i(this.TAG, "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(256844);
        return;
      }
      AppMethodBeat.o(256844);
      return;
    }
    params = this.iUB;
    if (params != null) {}
    for (params = params.aYK(); params == null; params = null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetSongStatusResp");
      AppMethodBeat.o(256844);
      throw paramString;
    }
    this.AqL = ((csd)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(256844);
      return;
    }
    AppMethodBeat.o(256844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a.i
 * JD-Core Version:    0.7.0.1
 */