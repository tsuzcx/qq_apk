package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dsf;
import com.tencent.mm.protocal.protobuf.dsg;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetBeatTrack;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicTotalDuration", "", "mvHashCode", "pageHashCode", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;III)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getMusicTotalDuration", "()I", "getMvHashCode", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetBeatTrackReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetBeatTrackResp;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends a
{
  public static final a LYU;
  public final boo LWI;
  public final int LYV;
  public final int LYW;
  private dsf LYX;
  public dsg LYY;
  private com.tencent.mm.am.h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(286274);
    LYU = new a((byte)0);
    AppMethodBeat.o(286274);
  }
  
  public h(boo paramboo, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3);
    AppMethodBeat.i(286266);
    this.LWI = paramboo;
    this.LYV = paramInt1;
    this.LYW = paramInt2;
    paramboo = new dsf();
    paramboo.aaXV = this.LWI.mLQ;
    paramboo.ZTw = this.LWI.songName;
    paramboo.rDl = this.LWI.rDl;
    paramboo.aaYa = this.LWI.musicDataUrl;
    paramboo.xmo = this.LWI.ZWR;
    paramboo.aaYb = this.LYV;
    paramboo.LWI = this.LWI;
    this.oDw = a.a(paramboo);
    ah localah = ah.aiuX;
    this.LYX = paramboo;
    AppMethodBeat.o(286266);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(286285);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(286285);
    return i;
  }
  
  public final int getType()
  {
    return 5904;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(286296);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetBeatTrack", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(286296);
      return;
    }
    params = c.c.b(this.oDw.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetBeatTrackResp");
      AppMethodBeat.o(286296);
      throw paramString;
    }
    this.LYY = ((dsg)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(286296);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetBeatTrack$Companion;", "", "()V", "TAG", "", "createCommReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetBeatTrackReq;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static c a(dsf paramdsf)
    {
      AppMethodBeat.i(286246);
      kotlin.g.b.s.u(paramdsf, "request");
      c.a locala = new c.a();
      locala.funcId = 5904;
      locala.uri = "/cgi-bin/micromsg-bin/musiclivegetbeattrack";
      locala.otE = ((com.tencent.mm.bx.a)paramdsf);
      locala.otF = ((com.tencent.mm.bx.a)new dsg());
      paramdsf = locala.bEF();
      kotlin.g.b.s.s(paramdsf, "commReqRespBuilder.buildInstance()");
      AppMethodBeat.o(286246);
      return paramdsf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.h
 * JD-Core Version:    0.7.0.1
 */