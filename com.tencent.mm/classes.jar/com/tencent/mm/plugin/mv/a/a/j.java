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
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvHeartbeat;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songId", "", "cookie", "Lcom/tencent/mm/protobuf/ByteString;", "offline", "", "pageHashCode", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ZI)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCookie", "()Lcom/tencent/mm/protobuf/ByteString;", "getOffline", "()Z", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveHeartbeatReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveHeartbeatResp;", "getSongId", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "", "Companion", "plugin-mv_release"})
public final class j
  extends m
{
  public static final a AqR;
  private cse AqM;
  public csf AqN;
  private final String AqO;
  private final b AqP;
  private final boolean AqQ;
  private i callback;
  private final d iUB;
  
  static
  {
    AppMethodBeat.i(256849);
    AqR = new a((byte)0);
    AppMethodBeat.o(256849);
  }
  
  public j(String paramString, b paramb, boolean paramBoolean, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(258864);
    this.AqO = paramString;
    this.AqP = paramb;
    this.AqQ = paramBoolean;
    paramString = new d.a();
    paramString.sG(6820);
    paramString.MB("/cgi-bin/micromsg-bin/musicliveheartbeat");
    paramString.c((a)new cse());
    paramString.d((a)new csf());
    paramString = paramString.aXF();
    p.g(paramString, "commReqRespBuilder.buildInstance()");
    this.iUB = paramString;
    paramString = this.iUB.aYJ();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveHeartbeatReq");
      AppMethodBeat.o(258864);
      throw paramString;
    }
    this.AqM = ((cse)paramString);
    paramString = this.AqM;
    if (paramString != null) {
      paramString.MwX = this.AqO;
    }
    paramString = this.AqM;
    if (paramString != null) {
      paramString.AqP = this.AqP;
    }
    paramString = this.AqM;
    if (paramString != null)
    {
      paramString.AqQ = this.AqQ;
      AppMethodBeat.o(258864);
      return;
    }
    AppMethodBeat.o(258864);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(256846);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(256846);
    return i;
  }
  
  public final int getType()
  {
    return 6820;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256847);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvHeartbeat", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(256847);
        return;
      }
      AppMethodBeat.o(256847);
      return;
    }
    params = this.iUB.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveHeartbeatResp");
      AppMethodBeat.o(256847);
      throw paramString;
    }
    this.AqN = ((csf)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(256847);
      return;
    }
    AppMethodBeat.o(256847);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvHeartbeat$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a.j
 * JD-Core Version:    0.7.0.1
 */