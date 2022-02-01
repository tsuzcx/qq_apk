package com.tencent.mm.plugin.mv.model.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.protocal.protobuf.bcr;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvFinderLike;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "finderFeedId", "", "finderNonceId", "", "likeIt", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFinderFeedId", "()J", "getFinderNonceId", "()Ljava/lang/String;", "likeId", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
{
  private static long AyQ;
  public static final a LYQ;
  private long AyP;
  private bcr AzE;
  private final long LYR;
  private final String LYS;
  private bcs LYT;
  private h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(286275);
    LYQ = new a((byte)0);
    AppMethodBeat.o(286275);
  }
  
  public g(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(286268);
    this.LYR = paramLong;
    this.LYS = paramString;
    this.AyP = cn.bDv();
    paramString = new c.a();
    paramString.funcId = 3710;
    paramString.uri = "/cgi-bin/micromsg-bin/finderlike";
    paramString.otE = ((com.tencent.mm.bx.a)new bcr());
    paramString.otF = ((com.tencent.mm.bx.a)new bcs());
    paramString = paramString.bEF();
    kotlin.g.b.s.s(paramString, "commReqRespBuilder.buildInstance()");
    this.oDw = paramString;
    if (this.AyP < AyQ)
    {
      paramLong = AyQ;
      AyQ = 1L + paramLong;
      this.AyP = paramLong;
    }
    AyQ = this.AyP;
    paramString = c.b.b(this.oDw.otB);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLikeRequest");
      AppMethodBeat.o(286268);
      throw paramString;
    }
    this.AzE = ((bcr)paramString);
    paramString = this.AzE;
    if (paramString != null) {
      paramString.hKN = this.LYR;
    }
    paramString = this.AzE;
    if (paramString != null) {
      paramString.commentId = 0L;
    }
    paramString = this.AzE;
    if (paramString != null) {
      if (!paramBoolean) {
        break label444;
      }
    }
    label444:
    for (int i = 3;; i = 4)
    {
      paramString.opType = i;
      paramString = this.AzE;
      if (paramString != null) {
        paramString.AyP = this.AyP;
      }
      paramString = this.AzE;
      if (paramString != null) {
        paramString.ZNF = com.tencent.mm.model.z.bAW();
      }
      paramString = this.AzE;
      if (paramString != null) {
        paramString.scene = 91;
      }
      paramString = this.AzE;
      if (paramString != null) {
        paramString.objectNonceId = this.LYS;
      }
      paramString = this.AzE;
      if (paramString != null) {
        paramString.ZNF = "";
      }
      paramString = this.AzE;
      if (paramString != null) {
        paramString.Dom = 0;
      }
      paramString = this.AzE;
      if (paramString != null) {
        paramString.Eis = 0;
      }
      paramString = bi.ABn;
      paramString = bi.dVu();
      paramString.scene = 91;
      paramString.ZEr = 1;
      Object localObject = this.AzE;
      if (localObject != null) {
        ((bcr)localObject).CJv = paramString;
      }
      paramString = this.AzE;
      if (paramString != null)
      {
        localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
        paramString.sessionBuffer = com.tencent.mm.plugin.finder.report.z.p(this.LYR, 91);
      }
      paramString = this.AzE;
      if (paramString != null)
      {
        localObject = bi.ABn;
        bi.a(paramString.CJv, kotlin.a.p.listOf(new r(Integer.valueOf(91), Long.valueOf(this.LYR))));
      }
      AppMethodBeat.o(286268);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(286287);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(286287);
    return i;
  }
  
  public final int getType()
  {
    return 3710;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(286298);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvMVFinderLike", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      }
      AppMethodBeat.o(286298);
      return;
    }
    params = c.c.b(this.oDw.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLikeResponse");
      AppMethodBeat.o(286298);
      throw paramString;
    }
    this.LYT = ((bcs)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
    }
    params = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    com.tencent.mm.plugin.findersdk.d.a.B(paramInt2, paramInt3, paramString);
    paramString = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    com.tencent.mm.plugin.findersdk.d.a.C(paramInt2, paramInt3, MMApplicationContext.getContext().getString(e.h.finder_like_failed_of_blacklist));
    paramString = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    com.tencent.mm.plugin.findersdk.d.a.D(paramInt2, paramInt3, MMApplicationContext.getContext().getString(e.h.finder_like_failed_not_realname));
    AppMethodBeat.o(286298);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvFinderLike$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "TAG", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.g
 * JD-Core Version:    0.7.0.1
 */