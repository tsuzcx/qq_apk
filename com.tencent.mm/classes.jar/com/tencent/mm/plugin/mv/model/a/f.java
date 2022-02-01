package com.tencent.mm.plugin.mv.model.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.daz;
import com.tencent.mm.protocal.protobuf.dba;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.t;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFeedRecommendList;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "context", "Landroid/content/Context;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Landroid/content/Context;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class f
  extends a
{
  public static final a Gdo;
  public dba GbX;
  private daz Gdn;
  private i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(225136);
    Gdo = new a((byte)0);
    AppMethodBeat.o(225136);
  }
  
  public f(Context paramContext, b paramb)
  {
    AppMethodBeat.i(225134);
    Object localObject1 = new d.a();
    ((d.a)localObject1).vD(6860);
    ((d.a)localObject1).TW("/cgi-bin/micromsg-bin/musiclivegetrelatedlist");
    ((d.a)localObject1).c((com.tencent.mm.cd.a)new daz());
    ((d.a)localObject1).d((com.tencent.mm.cd.a)new dba());
    localObject1 = ((d.a)localObject1).bgN();
    p.j(localObject1, "commReqRespBuilder.buildInstance()");
    this.lKU = ((d)localObject1);
    localObject1 = this.lKU.bhX();
    if (localObject1 == null)
    {
      paramContext = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListReq");
      AppMethodBeat.o(225134);
      throw paramContext;
    }
    this.Gdn = ((daz)localObject1);
    localObject1 = this.Gdn;
    if (localObject1 != null) {
      ((daz)localObject1).scene = 101;
    }
    localObject1 = com.tencent.mm.ui.component.g.Xox;
    paramContext = (com.tencent.mm.plugin.mv.ui.uic.l)com.tencent.mm.ui.component.g.lm(paramContext).i(com.tencent.mm.plugin.mv.ui.uic.l.class);
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("bgmid", paramContext.GaB.kkU);
    ((JSONObject)localObject2).put("songname", paramContext.GaB.HLH);
    ((JSONObject)localObject2).put("singername", paramContext.GaB.ozs);
    ((JSONObject)localObject2).put("songdesc", "");
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("type", 1);
    ((JSONObject)localObject1).put("bgmquery", localObject2);
    localObject2 = com.tencent.mm.plugin.mv.ui.a.Gfi;
    ((JSONObject)localObject1).put("songinfobufferbase64", com.tencent.mm.plugin.mv.ui.a.a(paramContext.GaB));
    localObject2 = this.Gdn;
    if (localObject2 != null) {
      ((daz)localObject2).source = ((JSONObject)localObject1).toString();
    }
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetMVRecommendList", "create NetSceneMusicMvGetFeedRecommendList songId:" + paramContext.GaB.kkU);
    paramContext = this.Gdn;
    if (paramContext != null) {
      paramContext.RLM = new aqe();
    }
    paramContext = this.Gdn;
    if (paramContext != null)
    {
      paramContext = paramContext.RLM;
      if (paramContext != null) {
        paramContext.scene = 93;
      }
    }
    paramContext = this.Gdn;
    if (paramContext != null)
    {
      paramContext = paramContext.RLM;
      if (paramContext != null) {
        paramContext.yjR = cm.bfD();
      }
    }
    paramContext = this.Gdn;
    if (paramContext != null)
    {
      paramContext.SDI = paramb;
      AppMethodBeat.o(225134);
      return;
    }
    AppMethodBeat.o(225134);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(225111);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(225111);
    return i;
  }
  
  public final int getType()
  {
    return 6860;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225120);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetMVRecommendList", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(225120);
        return;
      }
      AppMethodBeat.o(225120);
      return;
    }
    params = this.lKU.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListResp");
      AppMethodBeat.o(225120);
      throw paramString;
    }
    this.GbX = ((dba)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(225120);
      return;
    }
    AppMethodBeat.o(225120);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFeedRecommendList$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.f
 * JD-Core Version:    0.7.0.1
 */