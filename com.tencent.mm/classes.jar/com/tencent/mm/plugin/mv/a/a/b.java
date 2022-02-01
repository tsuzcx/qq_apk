package com.tencent.mm.plugin.mv.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvFinderLike;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "finderFeedId", "", "finderNonceId", "", "likeIt", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFinderFeedId", "()J", "getFinderNonceId", "()Ljava/lang/String;", "likeId", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class b
  extends m
{
  public static final a Aqs;
  private static long tsS;
  private aup Aqp;
  private final long Aqq;
  private final String Aqr;
  private i callback;
  private final d iUB;
  private long tsR;
  private auo ttj;
  
  static
  {
    AppMethodBeat.i(256818);
    Aqs = new a((byte)0);
    AppMethodBeat.o(256818);
  }
  
  public b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(256817);
    this.Aqq = paramLong;
    this.Aqr = paramString;
    this.tsR = cl.aWz();
    paramString = new d.a();
    paramString.sG(3710);
    paramString.MB("/cgi-bin/micromsg-bin/finderlike");
    paramString.c((com.tencent.mm.bw.a)new auo());
    paramString.d((com.tencent.mm.bw.a)new aup());
    paramString = paramString.aXF();
    p.g(paramString, "commReqRespBuilder.buildInstance()");
    this.iUB = paramString;
    if (this.tsR < tsS)
    {
      paramLong = tsS;
      tsS = 1L + paramLong;
      this.tsR = paramLong;
    }
    tsS = this.tsR;
    paramString = this.iUB.aYJ();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLikeRequest");
      AppMethodBeat.o(256817);
      throw paramString;
    }
    this.ttj = ((auo)paramString);
    paramString = this.ttj;
    if (paramString != null) {
      paramString.hFK = this.Aqq;
    }
    paramString = this.ttj;
    if (paramString != null) {
      paramString.commentId = 0L;
    }
    paramString = this.ttj;
    if (paramString != null) {
      if (!paramBoolean) {
        break label398;
      }
    }
    label398:
    for (int i = 3;; i = 4)
    {
      paramString.opType = i;
      paramString = this.ttj;
      if (paramString != null) {
        paramString.tsR = this.tsR;
      }
      paramString = this.ttj;
      if (paramString != null) {
        paramString.LFu = z.aUg();
      }
      paramString = this.ttj;
      if (paramString != null) {
        paramString.scene = 91;
      }
      paramString = this.ttj;
      if (paramString != null) {
        paramString.objectNonceId = this.Aqr;
      }
      paramString = this.ttj;
      if (paramString != null) {
        paramString.LFu = "";
      }
      paramString = this.ttj;
      if (paramString != null) {
        paramString.vkk = 0;
      }
      paramString = this.ttj;
      if (paramString != null) {
        paramString.uFa = 0;
      }
      paramString = new aov();
      paramString.scene = 91;
      paramString.LAS = 1;
      Object localObject = this.ttj;
      if (localObject != null) {
        ((auo)localObject).uli = paramString;
      }
      paramString = this.ttj;
      if (paramString == null) {
        break;
      }
      localObject = k.vfA;
      paramString.sessionBuffer = k.G(this.Aqq, 91);
      AppMethodBeat.o(256817);
      return;
    }
    AppMethodBeat.o(256817);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(256815);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(256815);
    return i;
  }
  
  public final int getType()
  {
    return 3710;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256816);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvMVFinderLike", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(256816);
        return;
      }
      AppMethodBeat.o(256816);
      return;
    }
    params = this.iUB.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLikeResponse");
      AppMethodBeat.o(256816);
      throw paramString;
    }
    this.Aqp = ((aup)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    params = com.tencent.mm.plugin.finder.spam.a.vwk;
    com.tencent.mm.plugin.finder.spam.a.v(paramInt2, paramInt3, paramString);
    paramString = com.tencent.mm.plugin.finder.spam.a.vwk;
    com.tencent.mm.plugin.finder.spam.a.w(paramInt2, paramInt3, MMApplicationContext.getContext().getString(2131759835));
    paramString = com.tencent.mm.plugin.finder.spam.a.vwk;
    com.tencent.mm.plugin.finder.spam.a.x(paramInt2, paramInt3, MMApplicationContext.getContext().getString(2131759834));
    AppMethodBeat.o(256816);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvFinderLike$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a.b
 * JD-Core Version:    0.7.0.1
 */