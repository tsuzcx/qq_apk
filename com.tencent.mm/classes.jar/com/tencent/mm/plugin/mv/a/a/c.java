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
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.crz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetBeatTrack;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicTotalDuration", "", "mvHashCode", "pageHashCode", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;III)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getMusicTotalDuration", "()I", "getMvHashCode", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetBeatTrackReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetBeatTrackResp;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class c
  extends m
{
  public static final a Aqx;
  public final axy Aqo;
  private cry Aqt;
  public crz Aqu;
  public final int Aqv;
  public final int Aqw;
  private i callback;
  private final d iUB;
  
  static
  {
    AppMethodBeat.i(256822);
    Aqx = new a((byte)0);
    AppMethodBeat.o(256822);
  }
  
  public c(axy paramaxy, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3);
    AppMethodBeat.i(258860);
    this.Aqo = paramaxy;
    this.Aqv = paramInt1;
    this.Aqw = paramInt2;
    paramaxy = new d.a();
    paramaxy.sG(5904);
    paramaxy.MB("/cgi-bin/micromsg-bin/musiclivegetbeattrack");
    paramaxy.c((a)new cry());
    paramaxy.d((a)new crz());
    paramaxy = paramaxy.aXF();
    p.g(paramaxy, "commReqRespBuilder.buildInstance()");
    this.iUB = paramaxy;
    paramaxy = this.iUB.aYJ();
    if (paramaxy == null)
    {
      paramaxy = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetBeatTrackReq");
      AppMethodBeat.o(258860);
      throw paramaxy;
    }
    this.Aqt = ((cry)paramaxy);
    paramaxy = this.Aqt;
    if (paramaxy != null) {
      paramaxy.MwX = this.Aqo.AqO;
    }
    paramaxy = this.Aqt;
    if (paramaxy != null) {
      paramaxy.MqW = this.Aqo.BPc;
    }
    paramaxy = this.Aqt;
    if (paramaxy != null) {
      paramaxy.lDR = this.Aqo.lDR;
    }
    paramaxy = this.Aqt;
    if (paramaxy != null) {
      paramaxy.Mxa = this.Aqo.musicDataUrl;
    }
    paramaxy = this.Aqt;
    if (paramaxy != null) {
      paramaxy.qHg = this.Aqo.LIg;
    }
    paramaxy = this.Aqt;
    if (paramaxy != null) {
      paramaxy.Mxb = this.Aqv;
    }
    paramaxy = this.Aqt;
    if (paramaxy != null)
    {
      paramaxy.Aqo = this.Aqo;
      AppMethodBeat.o(258860);
      return;
    }
    AppMethodBeat.o(258860);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(256819);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(256819);
    return i;
  }
  
  public final int getType()
  {
    return 5904;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256820);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetBeatTrack", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(256820);
        return;
      }
      AppMethodBeat.o(256820);
      return;
    }
    params = this.iUB.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetBeatTrackResp");
      AppMethodBeat.o(256820);
      throw paramString;
    }
    this.Aqu = ((crz)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(256820);
      return;
    }
    AppMethodBeat.o(256820);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetBeatTrack$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a.c
 * JD-Core Version:    0.7.0.1
 */