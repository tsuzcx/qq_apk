package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.mv.model.c;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderFeedDetail;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "feedId", "", "nonceId", "", "musicMvHashCode", "", "pageHashCode", "(JLjava/lang/String;II)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFeedId", "()J", "getMusicMvHashCode", "()I", "getNonceId", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-mv_release"})
public final class h
  extends a
{
  public att GaS;
  private ats Gds;
  public final int Gdt;
  private final String TAG;
  private com.tencent.mm.an.i callback;
  private final long feedId;
  private final com.tencent.mm.an.d lKU;
  private final String nonceId;
  
  public h(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    super(paramInt2);
    AppMethodBeat.i(233805);
    this.feedId = paramLong;
    this.nonceId = paramString;
    this.Gdt = paramInt1;
    this.TAG = ("MicroMsg.NetSceneMusicMvGetFinderFeedDetail@" + hashCode());
    paramString = new d.a();
    paramString.vD(3763);
    paramString.TW("/cgi-bin/micromsg-bin/findergetcommentdetail");
    paramString.c((com.tencent.mm.cd.a)new ats());
    paramString.d((com.tencent.mm.cd.a)new att());
    paramString = paramString.bgN();
    p.j(paramString, "commReqRespBuilder.buildInstance()");
    this.lKU = paramString;
    paramString = this.lKU.bhX();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetCommentDetailRequest");
      AppMethodBeat.o(233805);
      throw paramString;
    }
    this.Gds = ((ats)paramString);
    paramString = this.Gds;
    if (paramString != null) {
      paramString.xbk = this.feedId;
    }
    paramString = this.Gds;
    if (paramString != null) {
      paramString.objectNonceId = this.nonceId;
    }
    paramString = this.Gds;
    if (paramString != null)
    {
      paramString.SGs = 1;
      AppMethodBeat.o(233805);
      return;
    }
    AppMethodBeat.o(233805);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(233800);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(233800);
    return i;
  }
  
  public final int getType()
  {
    return 3763;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(233803);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i(this.TAG, "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(233803);
        return;
      }
      AppMethodBeat.o(233803);
      return;
    }
    params = this.lKU.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetCommentDetailResponse");
      AppMethodBeat.o(233803);
      throw paramString;
    }
    this.GaS = ((att)params);
    paramArrayOfByte = new att();
    params = this.GaS;
    if (params != null) {}
    for (params = params.toByteArray();; params = null)
    {
      paramArrayOfByte.parseFrom(params);
      params = com.tencent.mm.plugin.mv.model.i.GbW;
      long l1 = this.feedId;
      String str = this.nonceId;
      p.k(str, "nonceId");
      p.k(paramArrayOfByte, "response");
      if (com.tencent.mm.plugin.mv.model.i.pvA)
      {
        long l2 = Util.currentTicks();
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "putFinderFeedDetail, feedId:" + l1 + ", nonceId:" + str + ", response:" + paramArrayOfByte.hashCode() + ",timestamp:" + l2);
        com.tencent.mm.plugin.mv.model.i.GbT.put(new com.tencent.mm.plugin.mv.model.d(l1, str), new c(paramArrayOfByte, l2));
        params.OI(l2);
      }
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(233803);
      return;
    }
    AppMethodBeat.o(233803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.h
 * JD-Core Version:    0.7.0.1
 */