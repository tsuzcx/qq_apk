package com.tencent.mm.plugin.mv.model.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.protocal.protobuf.awu;
import com.tencent.mm.protocal.protobuf.awv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvFinderLike;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "finderFeedId", "", "finderNonceId", "", "likeIt", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFinderFeedId", "()J", "getFinderNonceId", "()Ljava/lang/String;", "likeId", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class d
  extends a
{
  public static final a Gdh;
  private static long xaH;
  private awv Gde;
  private final long Gdf;
  private final String Gdg;
  private i callback;
  private final com.tencent.mm.an.d lKU;
  private long xaG;
  private awu xba;
  
  static
  {
    AppMethodBeat.i(229067);
    Gdh = new a((byte)0);
    AppMethodBeat.o(229067);
  }
  
  public d(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(229065);
    this.Gdf = paramLong;
    this.Gdg = paramString;
    this.xaG = cm.bfD();
    paramString = new com.tencent.mm.an.d.a();
    paramString.vD(3710);
    paramString.TW("/cgi-bin/micromsg-bin/finderlike");
    paramString.c((com.tencent.mm.cd.a)new awu());
    paramString.d((com.tencent.mm.cd.a)new awv());
    paramString = paramString.bgN();
    p.j(paramString, "commReqRespBuilder.buildInstance()");
    this.lKU = paramString;
    if (this.xaG < xaH)
    {
      paramLong = xaH;
      xaH = 1L + paramLong;
      this.xaG = paramLong;
    }
    xaH = this.xaG;
    paramString = this.lKU.bhX();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLikeRequest");
      AppMethodBeat.o(229065);
      throw paramString;
    }
    this.xba = ((awu)paramString);
    paramString = this.xba;
    if (paramString != null) {
      paramString.xbk = this.Gdf;
    }
    paramString = this.xba;
    if (paramString != null) {
      paramString.commentId = 0L;
    }
    paramString = this.xba;
    if (paramString != null) {
      if (!paramBoolean) {
        break label441;
      }
    }
    label441:
    for (int i = 3;; i = 4)
    {
      paramString.opType = i;
      paramString = this.xba;
      if (paramString != null) {
        paramString.xaG = this.xaG;
      }
      paramString = this.xba;
      if (paramString != null) {
        paramString.SJv = z.bdh();
      }
      paramString = this.xba;
      if (paramString != null) {
        paramString.scene = 91;
      }
      paramString = this.xba;
      if (paramString != null) {
        paramString.objectNonceId = this.Gdg;
      }
      paramString = this.xba;
      if (paramString != null) {
        paramString.SJv = "";
      }
      paramString = this.xba;
      if (paramString != null) {
        paramString.yBs = 0;
      }
      paramString = this.xba;
      if (paramString != null) {
        paramString.ziS = 0;
      }
      paramString = ao.xcj;
      paramString = ao.dnO();
      paramString.scene = 91;
      paramString.SDt = 1;
      Object localObject = this.xba;
      if (localObject != null) {
        ((awu)localObject).yjp = paramString;
      }
      paramString = this.xba;
      if (paramString != null)
      {
        localObject = n.zWF;
        paramString.sessionBuffer = n.N(this.Gdf, 91);
      }
      paramString = this.xba;
      if (paramString == null) {
        break;
      }
      localObject = ao.xcj;
      ao.a(paramString.yjp, j.listOf(new o(Integer.valueOf(91), Long.valueOf(this.Gdf))));
      AppMethodBeat.o(229065);
      return;
    }
    AppMethodBeat.o(229065);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(229044);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(229044);
    return i;
  }
  
  public final int getType()
  {
    return 3710;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(229051);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvMVFinderLike", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(229051);
        return;
      }
      AppMethodBeat.o(229051);
      return;
    }
    params = this.lKU.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLikeResponse");
      AppMethodBeat.o(229051);
      throw paramString;
    }
    this.Gde = ((awv)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    params = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    com.tencent.mm.plugin.findersdk.c.a.x(paramInt2, paramInt3, paramString);
    paramString = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    com.tencent.mm.plugin.findersdk.c.a.y(paramInt2, paramInt3, MMApplicationContext.getContext().getString(b.j.finder_like_failed_of_blacklist));
    paramString = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    com.tencent.mm.plugin.findersdk.c.a.z(paramInt2, paramInt3, MMApplicationContext.getContext().getString(b.j.finder_like_failed_not_realname));
    AppMethodBeat.o(229051);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvFinderLike$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.d
 * JD-Core Version:    0.7.0.1
 */