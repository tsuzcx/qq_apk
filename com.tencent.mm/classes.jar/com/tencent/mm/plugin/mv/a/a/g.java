package com.tencent.mm.plugin.mv.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.protocal.protobuf.aso;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderLikeFeed;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "finderUserName", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLikedListRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetLikedListResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "()Ljava/lang/Integer;", "getMegaVideoCount", "getNoMoreWording", "getResponse", "getTotalCount", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class g
  extends m
{
  public static final a AqI;
  private asn AqG;
  public aso AqH;
  private i callback;
  private final d iUB;
  
  static
  {
    AppMethodBeat.i(256838);
    AqI = new a((byte)0);
    AppMethodBeat.o(256838);
  }
  
  public g(String paramString, b paramb)
  {
    AppMethodBeat.i(256837);
    Object localObject = new d.a();
    ((d.a)localObject).sG(3965);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/findergetlikedlist");
    ((d.a)localObject).c((a)new asn());
    ((d.a)localObject).d((a)new aso());
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "commReqRespBuilder.buildInstance()");
    this.iUB = ((d)localObject);
    localObject = this.iUB.aYJ();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListRequest");
      AppMethodBeat.o(256837);
      throw paramString;
    }
    this.AqG = ((asn)localObject);
    localObject = this.AqG;
    if (localObject != null) {
      ((asn)localObject).LDu = 0L;
    }
    localObject = this.AqG;
    if (localObject != null) {
      ((asn)localObject).LAt = paramString;
    }
    paramString = this.AqG;
    if (paramString != null) {
      paramString.lastBuffer = paramb;
    }
    paramString = this.AqG;
    if (paramString != null) {
      paramString.tvp = "";
    }
    paramString = this.AqG;
    if (paramString != null) {
      paramString.dLS = 0;
    }
    paramString = this.AqG;
    if (paramString != null)
    {
      paramb = new aov();
      paramb.scene = 93;
      paramString.uli = paramb;
      AppMethodBeat.o(256837);
      return;
    }
    AppMethodBeat.o(256837);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(256835);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(256835);
    return i;
  }
  
  public final int getType()
  {
    return 3965;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256836);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetFinderLikeFeed", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(256836);
        return;
      }
      AppMethodBeat.o(256836);
      return;
    }
    params = this.iUB.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(256836);
      throw paramString;
    }
    this.AqH = ((aso)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(256836);
      return;
    }
    AppMethodBeat.o(256836);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderLikeFeed$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a.g
 * JD-Core Version:    0.7.0.1
 */