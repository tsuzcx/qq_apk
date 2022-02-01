package com.tencent.mm.plugin.mv.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.mv.a.b;
import com.tencent.mm.plugin.mv.a.c;
import com.tencent.mm.plugin.mv.a.h;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderFeedDetail;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "feedId", "", "nonceId", "", "musicMvHashCode", "", "pageHashCode", "(JLjava/lang/String;II)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFeedId", "()J", "getMusicMvHashCode", "()I", "getNonceId", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-mv_release"})
public final class f
  extends m
{
  public ars Apk;
  private arr AqD;
  public final int AqE;
  private final String TAG;
  private i callback;
  private final long feedId;
  private final String hwg;
  private final d iUB;
  
  public f(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    super(paramInt2);
    AppMethodBeat.i(258861);
    this.feedId = paramLong;
    this.hwg = paramString;
    this.AqE = paramInt1;
    this.TAG = ("MicroMsg.NetSceneMusicMvGetFinderFeedDetail@" + hashCode());
    paramString = new d.a();
    paramString.sG(3763);
    paramString.MB("/cgi-bin/micromsg-bin/findergetcommentdetail");
    paramString.c((a)new arr());
    paramString.d((a)new ars());
    paramString = paramString.aXF();
    p.g(paramString, "commReqRespBuilder.buildInstance()");
    this.iUB = paramString;
    paramString = this.iUB.aYJ();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetCommentDetailRequest");
      AppMethodBeat.o(258861);
      throw paramString;
    }
    this.AqD = ((arr)paramString);
    paramString = this.AqD;
    if (paramString != null) {
      paramString.hFK = this.feedId;
    }
    paramString = this.AqD;
    if (paramString != null) {
      paramString.objectNonceId = this.hwg;
    }
    paramString = this.AqD;
    if (paramString != null)
    {
      paramString.LDb = 1;
      AppMethodBeat.o(258861);
      return;
    }
    AppMethodBeat.o(258861);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(256831);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(256831);
    return i;
  }
  
  public final int getType()
  {
    return 3763;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256832);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i(this.TAG, "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(256832);
        return;
      }
      AppMethodBeat.o(256832);
      return;
    }
    params = this.iUB.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetCommentDetailResponse");
      AppMethodBeat.o(256832);
      throw paramString;
    }
    this.Apk = ((ars)params);
    paramArrayOfByte = new ars();
    params = this.Apk;
    if (params != null) {}
    for (params = params.toByteArray();; params = null)
    {
      paramArrayOfByte.parseFrom(params);
      params = h.Aqi;
      long l1 = this.feedId;
      String str = this.hwg;
      p.h(str, "nonceId");
      p.h(paramArrayOfByte, "response");
      if (h.mxg)
      {
        long l2 = Util.currentTicks();
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "putFinderFeedDetail, feedId:" + l1 + ", nonceId:" + str + ", response:" + paramArrayOfByte.hashCode() + ",timestamp:" + l2);
        h.Aqf.put(new c(l1, str), new b(paramArrayOfByte, l2));
        params.Hs(l2);
      }
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(256832);
      return;
    }
    AppMethodBeat.o(256832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a.f
 * JD-Core Version:    0.7.0.1
 */