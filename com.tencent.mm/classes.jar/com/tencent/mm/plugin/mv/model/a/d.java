package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.dsh;
import com.tencent.mm.protocal.protobuf.dsi;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicInterAction;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "app_name", "", "entity_id", "pageHashCode", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getApp_name", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCommReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "getEntity_id", "req", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetInteractionInfoReq;", "getReq", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveGetInteractionInfoReq;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  private final String GaE;
  private final dsh LYM;
  private h callback;
  public final c oDw;
  private final String xlJ;
  
  public d(String paramString1, String paramString2, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(286270);
    this.xlJ = paramString1;
    this.GaE = paramString2;
    paramString1 = new c.a();
    paramString1.funcId = 8967;
    paramString1.uri = "/cgi-bin/micromsg-bin/musiclivegetinteractioninfo";
    paramString1.otE = ((com.tencent.mm.bx.a)new dsh());
    paramString1.otF = ((com.tencent.mm.bx.a)new dsi());
    paramString1 = paramString1.bEF();
    kotlin.g.b.s.s(paramString1, "commReqRespBuilder.buildInstance()");
    this.oDw = paramString1;
    paramString1 = c.b.b(this.oDw.otB);
    if (paramString1 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetInteractionInfoReq");
      AppMethodBeat.o(286270);
      throw paramString1;
    }
    this.LYM = ((dsh)paramString1);
    this.LYM.xlJ = this.xlJ;
    this.LYM.GaE = this.GaE;
    AppMethodBeat.o(286270);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(286282);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(286282);
    return i;
  }
  
  public final int getType()
  {
    return 8967;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(286290);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(286290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.d
 * JD-Core Version:    0.7.0.1
 */