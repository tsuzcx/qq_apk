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
import com.tencent.mm.protocal.protobuf.dax;
import com.tencent.mm.protocal.protobuf.day;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetBeatTrack;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicTotalDuration", "", "mvHashCode", "pageHashCode", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;III)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getMusicTotalDuration", "()I", "getMvHashCode", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetBeatTrackReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetBeatTrackResp;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class e
  extends a
{
  public static final a Gdm;
  public final bds GaB;
  private dax Gdi;
  public day Gdj;
  public final int Gdk;
  public final int Gdl;
  private i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(225581);
    Gdm = new a((byte)0);
    AppMethodBeat.o(225581);
  }
  
  public e(bds parambds, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3);
    AppMethodBeat.i(225580);
    this.GaB = parambds;
    this.Gdk = paramInt1;
    this.Gdl = paramInt2;
    parambds = new dax();
    parambds.TIm = this.GaB.kkU;
    parambds.SMU = this.GaB.HLH;
    parambds.ozs = this.GaB.ozs;
    parambds.TIr = this.GaB.musicDataUrl;
    parambds.ugh = this.GaB.SOK;
    parambds.TIs = this.Gdk;
    parambds.GaB = this.GaB;
    this.lKU = a.a(parambds);
    this.Gdi = parambds;
    AppMethodBeat.o(225580);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(225575);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(225575);
    return i;
  }
  
  public final int getType()
  {
    return 5904;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225578);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetBeatTrack", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(225578);
        return;
      }
      AppMethodBeat.o(225578);
      return;
    }
    params = this.lKU.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetBeatTrackResp");
      AppMethodBeat.o(225578);
      throw paramString;
    }
    this.Gdj = ((day)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(225578);
      return;
    }
    AppMethodBeat.o(225578);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetBeatTrack$Companion;", "", "()V", "TAG", "", "createCommReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetBeatTrackReq;", "plugin-mv_release"})
  public static final class a
  {
    public static d a(dax paramdax)
    {
      AppMethodBeat.i(228809);
      p.k(paramdax, "request");
      d.a locala = new d.a();
      locala.vD(5904);
      locala.TW("/cgi-bin/micromsg-bin/musiclivegetbeattrack");
      locala.c((com.tencent.mm.cd.a)paramdax);
      locala.d((com.tencent.mm.cd.a)new day());
      paramdax = locala.bgN();
      p.j(paramdax, "commReqRespBuilder.buildInstance()");
      AppMethodBeat.o(228809);
      return paramdax;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.e
 * JD-Core Version:    0.7.0.1
 */