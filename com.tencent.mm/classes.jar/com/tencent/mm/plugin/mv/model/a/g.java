package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderFavFeed;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "finderUserName", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetFavListRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetFavListResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "()Ljava/lang/Integer;", "getMegaVideoCount", "getResponse", "getTotalCount", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class g
  extends a
{
  public static final a Gdr;
  private aua Gdp;
  public aub Gdq;
  private i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(225367);
    Gdr = new a((byte)0);
    AppMethodBeat.o(225367);
  }
  
  public g(String paramString, b paramb)
  {
    AppMethodBeat.i(225365);
    Object localObject = new d.a();
    ((d.a)localObject).vD(3966);
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/findergetfavlist");
    ((d.a)localObject).c((com.tencent.mm.cd.a)new aua());
    ((d.a)localObject).d((com.tencent.mm.cd.a)new aub());
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "commReqRespBuilder.buildInstance()");
    this.lKU = ((d)localObject);
    localObject = this.lKU.bhX();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListRequest");
      AppMethodBeat.o(225365);
      throw paramString;
    }
    this.Gdp = ((aua)localObject);
    localObject = this.Gdp;
    if (localObject != null) {
      ((aua)localObject).finderUsername = paramString;
    }
    paramString = this.Gdp;
    if (paramString != null) {
      paramString.lastBuffer = paramb;
    }
    paramString = this.Gdp;
    if (paramString != null) {
      paramString.fEH = 0;
    }
    paramString = this.Gdp;
    if (paramString != null)
    {
      paramb = new aqe();
      paramb.scene = 93;
      paramString.SDi = paramb;
      AppMethodBeat.o(225365);
      return;
    }
    AppMethodBeat.o(225365);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(225346);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(225346);
    return i;
  }
  
  public final int getType()
  {
    return 3966;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225353);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetFinderFavFeed", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(225353);
        return;
      }
      AppMethodBeat.o(225353);
      return;
    }
    params = this.lKU.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(225353);
      throw paramString;
    }
    this.Gdq = ((aub)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(225353);
      return;
    }
    AppMethodBeat.o(225353);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderFavFeed$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.g
 * JD-Core Version:    0.7.0.1
 */