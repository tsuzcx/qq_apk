package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.cn;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.mv.model.i;
import com.tencent.mm.plugin.mv.model.j;
import com.tencent.mm.plugin.mv.model.k;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dsq;
import com.tencent.mm.protocal.protobuf.dsr;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetMVRecommendList;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "currentPageData", "Lcom/tencent/mm/protocal/protobuf/MvReportData;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "songInfoBase64", "", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/MvReportData;Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;Ljava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfoBase64", "()Ljava/lang/String;", "create", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "reportData", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends a
{
  public static final a LZm;
  private final boo LWI;
  public dsr LXH;
  private final String LXI;
  private dsq LZa;
  private h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(286297);
    LZm = new a((byte)0);
    AppMethodBeat.o(286297);
  }
  
  public n(dtk paramdtk, boo paramboo, String paramString, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(286291);
    this.LWI = paramboo;
    this.LXI = paramString;
    paramboo = new c.a();
    paramboo.funcId = 6860;
    paramboo.uri = "/cgi-bin/micromsg-bin/musiclivegetrelatedlist";
    paramboo.otE = ((com.tencent.mm.bx.a)new dsq());
    paramboo.otF = ((com.tencent.mm.bx.a)new dsr());
    paramboo = paramboo.bEF();
    kotlin.g.b.s.s(paramboo, "commReqRespBuilder.buildInstance()");
    this.oDw = paramboo;
    paramboo = c.b.b(this.oDw.otB);
    if (paramboo == null)
    {
      paramdtk = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListReq");
      AppMethodBeat.o(286291);
      throw paramdtk;
    }
    this.LZa = ((dsq)paramboo);
    paramboo = this.LZa;
    if (paramboo != null) {
      paramboo.scene = 102;
    }
    paramboo = this.LZa;
    if (paramboo != null)
    {
      paramString = new atz();
      if (paramdtk != null) {
        paramString.scene = paramdtk.aaYP;
      }
      paramString.Bjl = cn.bDv();
      paramboo.YIY = paramString;
    }
    paramdtk = new JSONObject();
    paramdtk.put("type", 2);
    paramboo = new JSONObject();
    paramboo.put("songid", this.LWI.mLQ);
    paramdtk.put("mvquery", paramboo);
    paramdtk.put("songinfobufferbase64", this.LXI);
    paramboo = this.LZa;
    if (paramboo != null) {
      paramboo.source = paramdtk.toString();
    }
    AppMethodBeat.o(286291);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(286305);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(286305);
    return i;
  }
  
  public final int getType()
  {
    return 6860;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(286308);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetMVRecommendList", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(286308);
      return;
    }
    params = c.c.b(this.oDw.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListResp");
      AppMethodBeat.o(286308);
      throw paramString;
    }
    this.LXH = ((dsr)params);
    paramArrayOfByte = new dsr();
    params = this.LXH;
    if (params == null) {}
    for (params = null;; params = params.toByteArray())
    {
      paramArrayOfByte.parseFrom(params);
      params = i.LXD;
      String str = this.LXI;
      kotlin.g.b.s.u(str, "songInfoBase64");
      kotlin.g.b.s.u(paramArrayOfByte, "response");
      if (i.sAG)
      {
        long l = Util.currentTicks();
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "putMvRecommendList, songInfoBase64:" + str.hashCode() + ", response:" + paramArrayOfByte.hashCode() + ", timestamp:" + l);
        i.LXF.put(new k(str), new j(paramArrayOfByte, l));
        params.sG(l);
      }
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(286308);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetMVRecommendList$Companion;", "", "()V", "TAG", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.n
 * JD-Core Version:    0.7.0.1
 */