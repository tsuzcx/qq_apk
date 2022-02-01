package com.tencent.mm.plugin.mv.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.asa;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderFavFeed;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "finderUserName", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetFavListRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetFavListResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "()Ljava/lang/Integer;", "getMegaVideoCount", "getResponse", "getTotalCount", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class e
  extends m
{
  public static final a AqC;
  private arz AqA;
  public asa AqB;
  private i callback;
  private final d iUB;
  
  static
  {
    AppMethodBeat.i(256830);
    AqC = new a((byte)0);
    AppMethodBeat.o(256830);
  }
  
  public e(String paramString, b paramb)
  {
    AppMethodBeat.i(256829);
    Object localObject = new d.a();
    ((d.a)localObject).sG(3966);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/findergetfavlist");
    ((d.a)localObject).c((a)new arz());
    ((d.a)localObject).d((a)new asa());
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "commReqRespBuilder.buildInstance()");
    this.iUB = ((d)localObject);
    localObject = this.iUB.aYJ();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListRequest");
      AppMethodBeat.o(256829);
      throw paramString;
    }
    this.AqA = ((arz)localObject);
    localObject = this.AqA;
    if (localObject != null) {
      ((arz)localObject).finderUsername = paramString;
    }
    paramString = this.AqA;
    if (paramString != null) {
      paramString.lastBuffer = paramb;
    }
    paramString = this.AqA;
    if (paramString != null) {
      paramString.dLS = 0;
    }
    paramString = this.AqA;
    if (paramString != null)
    {
      paramb = new aov();
      paramb.scene = 93;
      paramString.LAI = paramb;
      AppMethodBeat.o(256829);
      return;
    }
    AppMethodBeat.o(256829);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(256827);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(256827);
    return i;
  }
  
  public final int getType()
  {
    return 3966;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256828);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetFinderFavFeed", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(256828);
        return;
      }
      AppMethodBeat.o(256828);
      return;
    }
    params = this.iUB.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
      AppMethodBeat.o(256828);
      throw paramString;
    }
    this.AqB = ((asa)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(256828);
      return;
    }
    AppMethodBeat.o(256828);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetFinderFavFeed$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a.e
 * JD-Core Version:    0.7.0.1
 */