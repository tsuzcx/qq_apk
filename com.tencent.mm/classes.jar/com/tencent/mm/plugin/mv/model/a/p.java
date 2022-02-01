package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.dsu;
import com.tencent.mm.protocal.protobuf.dsv;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvHeartbeat;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songId", "", "cookie", "Lcom/tencent/mm/protobuf/ByteString;", "offline", "", "pageHashCode", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ZI)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCookie", "()Lcom/tencent/mm/protobuf/ByteString;", "getOffline", "()Z", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveHeartbeatReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveHeartbeatResp;", "getSongId", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends a
{
  public static final a LZp;
  private final boolean LXS;
  private dsu LZq;
  public dsv LZr;
  private h callback;
  private final b cookie;
  private final String mLQ;
  private final c oDw;
  
  static
  {
    AppMethodBeat.i(286312);
    LZp = new a((byte)0);
    AppMethodBeat.o(286312);
  }
  
  public p(String paramString, b paramb, boolean paramBoolean)
  {
    super(0);
    AppMethodBeat.i(286310);
    this.mLQ = paramString;
    this.cookie = paramb;
    this.LXS = paramBoolean;
    paramString = new c.a();
    paramString.funcId = 6820;
    paramString.uri = "/cgi-bin/micromsg-bin/musicliveheartbeat";
    paramString.otE = ((com.tencent.mm.bx.a)new dsu());
    paramString.otF = ((com.tencent.mm.bx.a)new dsv());
    paramString = paramString.bEF();
    kotlin.g.b.s.s(paramString, "commReqRespBuilder.buildInstance()");
    this.oDw = paramString;
    paramString = c.b.b(this.oDw.otB);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveHeartbeatReq");
      AppMethodBeat.o(286310);
      throw paramString;
    }
    this.LZq = ((dsu)paramString);
    paramString = this.LZq;
    if (paramString != null) {
      paramString.aaXV = this.mLQ;
    }
    paramString = this.LZq;
    if (paramString != null) {
      paramString.cookie = this.cookie;
    }
    paramString = this.LZq;
    if (paramString != null) {
      paramString.LXS = this.LXS;
    }
    AppMethodBeat.o(286310);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(286316);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(286316);
    return i;
  }
  
  public final int getType()
  {
    return 6820;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(286321);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvHeartbeat", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
      }
      AppMethodBeat.o(286321);
      return;
    }
    params = c.c.b(this.oDw.otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveHeartbeatResp");
      AppMethodBeat.o(286321);
      throw paramString;
    }
    this.LZr = ((dsv)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
    }
    AppMethodBeat.o(286321);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvHeartbeat$Companion;", "", "()V", "TAG", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.p
 * JD-Core Version:    0.7.0.1
 */