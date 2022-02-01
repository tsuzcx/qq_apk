package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.aw.f;
import com.tencent.mm.network.g;
import com.tencent.mm.protocal.protobuf.dsj;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.protocal.protobuf.dsl;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetJoinMemberShip;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "wrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "pageHashCode", "", "(Lcom/tencent/mm/modelmusic/MusicWrapper;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetJoinMembershipInfoReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetJoinMembershipInfoResp;", "getWrapper", "()Lcom/tencent/mm/modelmusic/MusicWrapper;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends a
{
  public static final a LZj;
  private dsj LZk;
  public dsl LZl;
  private h callback;
  private final f hRG;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(286340);
    LZj = new a((byte)0);
    AppMethodBeat.o(286340);
  }
  
  public m(f paramf, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(286334);
    this.hRG = paramf;
    paramf = new c.a();
    paramf.funcId = 6448;
    paramf.uri = "/cgi-bin/micromsg-bin/musiclivegetjoinmembershipinfo";
    paramf.otE = ((com.tencent.mm.bx.a)new dsj());
    paramf.otF = ((com.tencent.mm.bx.a)new dsl());
    paramf = paramf.bEF();
    kotlin.g.b.s.s(paramf, "commReqRespBuilder.buildInstance()");
    this.oDw = paramf;
    paramf = c.b.b(this.oDw.otB);
    if (paramf == null)
    {
      paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetJoinMembershipInfoReq");
      AppMethodBeat.o(286334);
      throw paramf;
    }
    this.LZk = ((dsj)paramf);
    paramf = new dsk();
    paramf.appid = this.hRG.oOI;
    paramf.oOZ = this.hRG.oOZ;
    dsj localdsj = this.LZk;
    if (localdsj != null) {
      localdsj.aaYg = paramf;
    }
    AppMethodBeat.o(286334);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(286354);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(286354);
    return i;
  }
  
  public final int getType()
  {
    return 6448;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(286363);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvGetMVRecommendList", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(286363);
      return;
    }
    params = c.c.b(this.oDw.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetJoinMembershipInfoResp");
      AppMethodBeat.o(286363);
      throw paramString;
    }
    this.LZl = ((dsl)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(286363);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetJoinMemberShip$Companion;", "", "()V", "TAG", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.m
 * JD-Core Version:    0.7.0.1
 */