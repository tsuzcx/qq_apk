package com.tencent.mm.plugin.mv.a.a;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerDataUIC;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csa;
import com.tencent.mm.protocal.protobuf.csb;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFeedRecommendList;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "context", "Landroid/content/Context;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Landroid/content/Context;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class d
  extends m
{
  public static final a Aqz;
  public csb Aqj;
  private csa Aqy;
  private i callback;
  private final com.tencent.mm.ak.d iUB;
  
  static
  {
    AppMethodBeat.i(256826);
    Aqz = new a((byte)0);
    AppMethodBeat.o(256826);
  }
  
  public d(Context paramContext, b paramb)
  {
    AppMethodBeat.i(256825);
    Object localObject1 = new com.tencent.mm.ak.d.a();
    ((com.tencent.mm.ak.d.a)localObject1).sG(6860);
    ((com.tencent.mm.ak.d.a)localObject1).MB("/cgi-bin/micromsg-bin/musiclivegetrelatedlist");
    ((com.tencent.mm.ak.d.a)localObject1).c((com.tencent.mm.bw.a)new csa());
    ((com.tencent.mm.ak.d.a)localObject1).d((com.tencent.mm.bw.a)new csb());
    localObject1 = ((com.tencent.mm.ak.d.a)localObject1).aXF();
    p.g(localObject1, "commReqRespBuilder.buildInstance()");
    this.iUB = ((com.tencent.mm.ak.d)localObject1);
    localObject1 = this.iUB.aYJ();
    if (localObject1 == null)
    {
      paramContext = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListReq");
      AppMethodBeat.o(256825);
      throw paramContext;
    }
    this.Aqy = ((csa)localObject1);
    localObject1 = this.Aqy;
    if (localObject1 != null) {
      ((csa)localObject1).scene = 101;
    }
    localObject1 = com.tencent.mm.ui.component.a.PRN;
    paramContext = (MusicMvMakerDataUIC)com.tencent.mm.ui.component.a.ko(paramContext).get(MusicMvMakerDataUIC.class);
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("bgmid", paramContext.Aqo.AqO);
    ((JSONObject)localObject2).put("songname", paramContext.Aqo.BPc);
    ((JSONObject)localObject2).put("singername", paramContext.Aqo.lDR);
    ((JSONObject)localObject2).put("songdesc", "");
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("type", 1);
    ((JSONObject)localObject1).put("bgmquery", localObject2);
    localObject2 = com.tencent.mm.plugin.mv.ui.a.ArA;
    ((JSONObject)localObject1).put("songinfobufferbase64", com.tencent.mm.plugin.mv.ui.a.b(paramContext.Aqo));
    localObject2 = this.Aqy;
    if (localObject2 != null) {
      ((csa)localObject2).source = ((JSONObject)localObject1).toString();
    }
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetMVRecommendList", "create NetSceneMusicMvGetFeedRecommendList songId:" + paramContext.Aqo.AqO);
    paramContext = this.Aqy;
    if (paramContext != null) {
      paramContext.LBM = new aov();
    }
    paramContext = this.Aqy;
    if (paramContext != null)
    {
      paramContext = paramContext.LBM;
      if (paramContext != null) {
        paramContext.scene = 93;
      }
    }
    paramContext = this.Aqy;
    if (paramContext != null)
    {
      paramContext = paramContext.LBM;
      if (paramContext != null) {
        paramContext.ulj = cl.aWz();
      }
    }
    paramContext = this.Aqy;
    if (paramContext != null)
    {
      paramContext.LDs = paramb;
      AppMethodBeat.o(256825);
      return;
    }
    AppMethodBeat.o(256825);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(256823);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(256823);
    return i;
  }
  
  public final int getType()
  {
    return 6860;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256824);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetMVRecommendList", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(256824);
        return;
      }
      AppMethodBeat.o(256824);
      return;
    }
    params = this.iUB.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListResp");
      AppMethodBeat.o(256824);
      throw paramString;
    }
    this.Aqj = ((csb)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(256824);
      return;
    }
    AppMethodBeat.o(256824);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFeedRecommendList$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a.d
 * JD-Core Version:    0.7.0.1
 */