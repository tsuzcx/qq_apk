package com.tencent.mm.plugin.mv.model.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.mv.ui.uic.j;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dsq;
import com.tencent.mm.protocal.protobuf.dsr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFeedRecommendList;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "context", "Landroid/content/Context;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Landroid/content/Context;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends a
{
  public static final a LYZ;
  public dsr LXH;
  private dsq LZa;
  private h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(286277);
    LYZ = new a((byte)0);
    AppMethodBeat.o(286277);
  }
  
  public i(Context paramContext, b paramb)
  {
    AppMethodBeat.i(286269);
    Object localObject1 = new c.a();
    ((c.a)localObject1).funcId = 6860;
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/musiclivegetrelatedlist";
    ((c.a)localObject1).otE = ((com.tencent.mm.bx.a)new dsq());
    ((c.a)localObject1).otF = ((com.tencent.mm.bx.a)new dsr());
    localObject1 = ((c.a)localObject1).bEF();
    kotlin.g.b.s.s(localObject1, "commReqRespBuilder.buildInstance()");
    this.oDw = ((c)localObject1);
    localObject1 = c.b.b(this.oDw.otB);
    if (localObject1 == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListReq");
      AppMethodBeat.o(286269);
      throw paramContext;
    }
    this.LZa = ((dsq)localObject1);
    localObject1 = this.LZa;
    if (localObject1 != null) {
      ((dsq)localObject1).scene = 101;
    }
    localObject1 = k.aeZF;
    paramContext = (j)k.nq(paramContext).q(j.class);
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("bgmid", paramContext.LWI.mLQ);
    ((JSONObject)localObject2).put("songname", paramContext.LWI.songName);
    ((JSONObject)localObject2).put("singername", paramContext.LWI.rDl);
    ((JSONObject)localObject2).put("songdesc", "");
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("type", 1);
    ((JSONObject)localObject1).put("bgmquery", localObject2);
    localObject2 = com.tencent.mm.plugin.mv.ui.a.Maz;
    ((JSONObject)localObject1).put("songinfobufferbase64", com.tencent.mm.plugin.mv.ui.a.a(paramContext.LWI));
    localObject2 = this.LZa;
    if (localObject2 != null) {
      ((dsq)localObject2).source = ((JSONObject)localObject1).toString();
    }
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetMVRecommendList", kotlin.g.b.s.X("create NetSceneMusicMvGetFeedRecommendList songId:", paramContext.LWI.mLQ));
    paramContext = this.LZa;
    if (paramContext != null) {
      paramContext.YIY = new atz();
    }
    paramContext = this.LZa;
    if (paramContext == null)
    {
      paramContext = null;
      if (paramContext != null) {
        paramContext.scene = 93;
      }
      paramContext = this.LZa;
      if (paramContext != null) {
        break label388;
      }
    }
    label388:
    for (paramContext = null;; paramContext = paramContext.YIY)
    {
      if (paramContext != null) {
        paramContext.Bjl = cn.bDv();
      }
      paramContext = this.LZa;
      if (paramContext != null) {
        paramContext.ZEQ = paramb;
      }
      AppMethodBeat.o(286269);
      return;
      paramContext = paramContext.YIY;
      break;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(286289);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(286289);
    return i;
  }
  
  public final int getType()
  {
    return 6860;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(286300);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetMVRecommendList", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(286300);
      return;
    }
    params = c.c.b(this.oDw.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetRelatedListResp");
      AppMethodBeat.o(286300);
      throw paramString;
    }
    this.LXH = ((dsr)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(286300);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFeedRecommendList$Companion;", "", "()V", "TAG", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.i
 * JD-Core Version:    0.7.0.1
 */