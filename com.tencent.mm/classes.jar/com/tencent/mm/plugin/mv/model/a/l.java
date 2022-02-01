package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderLikeFeed;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "finderUserName", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLikedListRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetLikedListResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "()Ljava/lang/Integer;", "getMegaVideoCount", "getNoMoreWording", "getResponse", "getTotalCount", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends a
{
  public static final a LZg;
  private azg LZh;
  public azh LZi;
  private h callback;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(286313);
    LZg = new a((byte)0);
    AppMethodBeat.o(286313);
  }
  
  public l(String paramString, b paramb)
  {
    AppMethodBeat.i(286311);
    Object localObject = new c.a();
    ((c.a)localObject).funcId = 3965;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/findergetlikedlist";
    ((c.a)localObject).otE = ((com.tencent.mm.bx.a)new azg());
    ((c.a)localObject).otF = ((com.tencent.mm.bx.a)new azh());
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "commReqRespBuilder.buildInstance()");
    this.oDw = ((c)localObject);
    localObject = c.b.b(this.oDw.otB);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListRequest");
      AppMethodBeat.o(286311);
      throw paramString;
    }
    this.LZh = ((azg)localObject);
    localObject = this.LZh;
    if (localObject != null) {
      ((azg)localObject).ZJD = 0L;
    }
    localObject = this.LZh;
    if (localObject != null) {
      ((azg)localObject).YIZ = paramString;
    }
    paramString = this.LZh;
    if (paramString != null) {
      paramString.lastBuffer = paramb;
    }
    paramString = this.LZh;
    if (paramString != null) {
      paramString.ACm = "";
    }
    paramString = this.LZh;
    if (paramString != null) {
      paramString.hJx = 0;
    }
    paramString = this.LZh;
    if (paramString != null)
    {
      paramb = new atz();
      paramb.scene = 93;
      localObject = ah.aiuX;
      paramString.CJv = paramb;
    }
    AppMethodBeat.o(286311);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(286317);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(286317);
    return i;
  }
  
  public final int getType()
  {
    return 3965;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(286324);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetFinderLikeFeed", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(286324);
      return;
    }
    params = c.c.b(this.oDw.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
      AppMethodBeat.o(286324);
      throw paramString;
    }
    this.LZi = ((azh)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(286324);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderLikeFeed$Companion;", "", "()V", "TAG", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.l
 * JD-Core Version:    0.7.0.1
 */