package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.q;
import com.tencent.mm.model.cm;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.mv.model.k;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.daz;
import com.tencent.mm.protocal.protobuf.dba;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetMVRecommendList;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "currentPageData", "Lcom/tencent/mm/protocal/protobuf/MvReportData;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "songInfoBase64", "", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/MvReportData;Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;Ljava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfoBase64", "()Ljava/lang/String;", "create", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "reportData", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class j
  extends a
{
  public static final a Gdx;
  private final bds GaB;
  public dba GbX;
  private final String GbY;
  private daz Gdn;
  private com.tencent.mm.an.i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(226674);
    Gdx = new a((byte)0);
    AppMethodBeat.o(226674);
  }
  
  public j(dbs paramdbs, bds parambds, String paramString, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(226672);
    this.GaB = parambds;
    this.GbY = paramString;
    parambds = new d.a();
    parambds.vD(6860);
    parambds.TW("/cgi-bin/micromsg-bin/musiclivegetrelatedlist");
    parambds.c((com.tencent.mm.cd.a)new daz());
    parambds.d((com.tencent.mm.cd.a)new dba());
    parambds = parambds.bgN();
    p.j(parambds, "commReqRespBuilder.buildInstance()");
    this.lKU = parambds;
    parambds = this.lKU.bhX();
    if (parambds == null)
    {
      paramdbs = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListReq");
      AppMethodBeat.o(226672);
      throw paramdbs;
    }
    this.Gdn = ((daz)parambds);
    parambds = this.Gdn;
    if (parambds != null) {
      parambds.scene = 102;
    }
    parambds = this.Gdn;
    if (parambds != null)
    {
      paramString = new aqe();
      if (paramdbs != null) {
        paramString.scene = paramdbs.TIZ;
      }
      paramString.yjR = cm.bfD();
      parambds.RLM = paramString;
    }
    paramdbs = new JSONObject();
    paramdbs.put("type", 2);
    parambds = new JSONObject();
    parambds.put("songid", this.GaB.kkU);
    paramdbs.put("mvquery", parambds);
    paramdbs.put("songinfobufferbase64", this.GbY);
    parambds = this.Gdn;
    if (parambds != null)
    {
      parambds.source = paramdbs.toString();
      AppMethodBeat.o(226672);
      return;
    }
    AppMethodBeat.o(226672);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(226661);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(226661);
    return i;
  }
  
  public final int getType()
  {
    return 6860;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(226665);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetMVRecommendList", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(226665);
        return;
      }
      AppMethodBeat.o(226665);
      return;
    }
    params = this.lKU.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListResp");
      AppMethodBeat.o(226665);
      throw paramString;
    }
    this.GbX = ((dba)params);
    paramArrayOfByte = new dba();
    params = this.GbX;
    if (params != null) {}
    for (params = params.toByteArray();; params = null)
    {
      paramArrayOfByte.parseFrom(params);
      params = com.tencent.mm.plugin.mv.model.i.GbW;
      String str = this.GbY;
      p.k(str, "songInfoBase64");
      p.k(paramArrayOfByte, "response");
      if (com.tencent.mm.plugin.mv.model.i.pvA)
      {
        long l = Util.currentTicks();
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "putMvRecommendList, songInfoBase64:" + str.hashCode() + ", response:" + paramArrayOfByte.hashCode() + ", timestamp:" + l);
        com.tencent.mm.plugin.mv.model.i.GbU.put(new k(str), new com.tencent.mm.plugin.mv.model.j(paramArrayOfByte, l));
        params.OI(l);
      }
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(226665);
      return;
    }
    AppMethodBeat.o(226665);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetMVRecommendList$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.j
 * JD-Core Version:    0.7.0.1
 */