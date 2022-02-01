package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.mv.model.d;
import com.tencent.mm.plugin.mv.model.i;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderFeedDetail;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "feedId", "", "nonceId", "", "musicMvHashCode", "", "pageHashCode", "(JLjava/lang/String;II)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFeedId", "()J", "getMusicMvHashCode", "()I", "getNonceId", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends a
{
  public ayl LWS;
  public final int LZe;
  private ayk LZf;
  private final String TAG;
  private h callback;
  private final long feedId;
  private final String nonceId;
  private final com.tencent.mm.am.c oDw;
  
  public k(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    super(paramInt2);
    AppMethodBeat.i(286335);
    this.feedId = paramLong;
    this.nonceId = paramString;
    this.LZe = paramInt1;
    this.TAG = kotlin.g.b.s.X("MicroMsg.NetSceneMusicMvGetFinderFeedDetail@", Integer.valueOf(hashCode()));
    paramString = new c.a();
    paramString.funcId = 3763;
    paramString.uri = "/cgi-bin/micromsg-bin/findergetcommentdetail";
    paramString.otE = ((com.tencent.mm.bx.a)new ayk());
    paramString.otF = ((com.tencent.mm.bx.a)new ayl());
    paramString = paramString.bEF();
    kotlin.g.b.s.s(paramString, "commReqRespBuilder.buildInstance()");
    this.oDw = paramString;
    paramString = c.b.b(this.oDw.otB);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetCommentDetailRequest");
      AppMethodBeat.o(286335);
      throw paramString;
    }
    this.LZf = ((ayk)paramString);
    paramString = this.LZf;
    if (paramString != null) {
      paramString.hKN = this.feedId;
    }
    paramString = this.LZf;
    if (paramString != null) {
      paramString.objectNonceId = this.nonceId;
    }
    paramString = this.LZf;
    if (paramString != null) {
      paramString.ZJf = 1;
    }
    paramString = this.LZf;
    if (paramString != null)
    {
      bi localbi = bi.ABn;
      paramString.ZDQ = bi.bTZ();
    }
    AppMethodBeat.o(286335);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(286352);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(286352);
    return i;
  }
  
  public final int getType()
  {
    return 3763;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(286366);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i(this.TAG, "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(286366);
      return;
    }
    params = c.c.b(this.oDw.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetCommentDetailResponse");
      AppMethodBeat.o(286366);
      throw paramString;
    }
    this.LWS = ((ayl)params);
    paramArrayOfByte = new ayl();
    params = this.LWS;
    if (params == null) {}
    for (params = null;; params = params.toByteArray())
    {
      paramArrayOfByte.parseFrom(params);
      params = i.LXD;
      long l1 = this.feedId;
      String str = this.nonceId;
      kotlin.g.b.s.u(str, "nonceId");
      kotlin.g.b.s.u(paramArrayOfByte, "response");
      if (i.sAG)
      {
        long l2 = Util.currentTicks();
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "putFinderFeedDetail, feedId:" + l1 + ", nonceId:" + str + ", response:" + paramArrayOfByte.hashCode() + ",timestamp:" + l2);
        i.LXE.put(new d(l1, str), new com.tencent.mm.plugin.mv.model.c(paramArrayOfByte, l2));
        params.sG(l2);
      }
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(286366);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.k
 * JD-Core Version:    0.7.0.1
 */