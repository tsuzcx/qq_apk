package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderLikeFeed;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "finderUserName", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLikedListRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetLikedListResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "()Ljava/lang/Integer;", "getMegaVideoCount", "getNoMoreWording", "getResponse", "getTotalCount", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class i
  extends a
{
  public static final a Gdw;
  private auo Gdu;
  public aup Gdv;
  private com.tencent.mm.an.i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(230810);
    Gdw = new a((byte)0);
    AppMethodBeat.o(230810);
  }
  
  public i(String paramString, b paramb)
  {
    AppMethodBeat.i(230808);
    Object localObject = new d.a();
    ((d.a)localObject).vD(3965);
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/findergetlikedlist");
    ((d.a)localObject).c((com.tencent.mm.cd.a)new auo());
    ((d.a)localObject).d((com.tencent.mm.cd.a)new aup());
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "commReqRespBuilder.buildInstance()");
    this.lKU = ((d)localObject);
    localObject = this.lKU.bhX();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListRequest");
      AppMethodBeat.o(230808);
      throw paramString;
    }
    this.Gdu = ((auo)localObject);
    localObject = this.Gdu;
    if (localObject != null) {
      ((auo)localObject).SGM = 0L;
    }
    localObject = this.Gdu;
    if (localObject != null) {
      ((auo)localObject).RLN = paramString;
    }
    paramString = this.Gdu;
    if (paramString != null) {
      paramString.lastBuffer = paramb;
    }
    paramString = this.Gdu;
    if (paramString != null) {
      paramString.xcW = "";
    }
    paramString = this.Gdu;
    if (paramString != null) {
      paramString.fEH = 0;
    }
    paramString = this.Gdu;
    if (paramString != null)
    {
      paramb = new aqe();
      paramb.scene = 93;
      paramString.yjp = paramb;
      AppMethodBeat.o(230808);
      return;
    }
    AppMethodBeat.o(230808);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(230806);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(230806);
    return i;
  }
  
  public final int getType()
  {
    return 3965;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(230807);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetFinderLikeFeed", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(230807);
        return;
      }
      AppMethodBeat.o(230807);
      return;
    }
    params = this.lKU.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(230807);
      throw paramString;
    }
    this.Gdv = ((aup)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(230807);
      return;
    }
    AppMethodBeat.o(230807);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderLikeFeed$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.i
 * JD-Core Version:    0.7.0.1
 */