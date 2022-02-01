package com.tencent.mm.plugin.mv.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.mv.a.j;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csa;
import com.tencent.mm.protocal.protobuf.csb;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetMVRecommendList;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "currentPageData", "Lcom/tencent/mm/protocal/protobuf/MvReportData;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "songInfoBase64", "", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/MvReportData;Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;Ljava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfoBase64", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class h
  extends m
{
  public static final a AqJ;
  public csb Aqj;
  private final String Aqk;
  private final axy Aqo;
  private csa Aqy;
  private com.tencent.mm.ak.i callback;
  private final d iUB;
  
  static
  {
    AppMethodBeat.i(256842);
    AqJ = new a((byte)0);
    AppMethodBeat.o(256842);
  }
  
  public h(cst paramcst, axy paramaxy, String paramString, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(258862);
    this.Aqo = paramaxy;
    this.Aqk = paramString;
    paramaxy = new d.a();
    paramaxy.sG(6860);
    paramaxy.MB("/cgi-bin/micromsg-bin/musiclivegetrelatedlist");
    paramaxy.c((a)new csa());
    paramaxy.d((a)new csb());
    paramaxy = paramaxy.aXF();
    p.g(paramaxy, "commReqRespBuilder.buildInstance()");
    this.iUB = paramaxy;
    paramaxy = this.iUB.aYJ();
    if (paramaxy == null)
    {
      paramcst = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListReq");
      AppMethodBeat.o(258862);
      throw paramcst;
    }
    this.Aqy = ((csa)paramaxy);
    paramaxy = this.Aqy;
    if (paramaxy != null) {
      paramaxy.scene = 102;
    }
    paramaxy = this.Aqy;
    if (paramaxy != null)
    {
      paramString = am.tuw;
      paramaxy.LBM = am.a(paramcst);
    }
    paramcst = new JSONObject();
    paramcst.put("type", 2);
    paramaxy = new JSONObject();
    paramaxy.put("songid", this.Aqo.AqO);
    paramcst.put("mvquery", paramaxy);
    paramcst.put("songinfobufferbase64", this.Aqk);
    paramaxy = this.Aqy;
    if (paramaxy != null)
    {
      paramaxy.source = paramcst.toString();
      AppMethodBeat.o(258862);
      return;
    }
    AppMethodBeat.o(258862);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(256839);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(256839);
    return i;
  }
  
  public final int getType()
  {
    return 6860;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256840);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetMVRecommendList", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(256840);
        return;
      }
      AppMethodBeat.o(256840);
      return;
    }
    params = this.iUB.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListResp");
      AppMethodBeat.o(256840);
      throw paramString;
    }
    this.Aqj = ((csb)params);
    paramArrayOfByte = new csb();
    params = this.Aqj;
    if (params != null) {}
    for (params = params.toByteArray();; params = null)
    {
      paramArrayOfByte.parseFrom(params);
      params = com.tencent.mm.plugin.mv.a.h.Aqi;
      String str = this.Aqk;
      p.h(str, "songInfoBase64");
      p.h(paramArrayOfByte, "response");
      if (com.tencent.mm.plugin.mv.a.h.mxg)
      {
        long l = Util.currentTicks();
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "putMvRecommendList, songInfoBase64:" + str.hashCode() + ", response:" + paramArrayOfByte.hashCode() + ", timestamp:" + l);
        com.tencent.mm.plugin.mv.a.h.Aqg.put(new j(str), new com.tencent.mm.plugin.mv.a.i(paramArrayOfByte, l));
        params.Hs(l);
      }
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(256840);
      return;
    }
    AppMethodBeat.o(256840);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetMVRecommendList$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a.h
 * JD-Core Version:    0.7.0.1
 */