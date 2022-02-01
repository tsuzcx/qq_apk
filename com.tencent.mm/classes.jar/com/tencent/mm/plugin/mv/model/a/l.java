package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dbd;
import com.tencent.mm.protocal.protobuf.dbe;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvHeartbeat;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songId", "", "cookie", "Lcom/tencent/mm/protobuf/ByteString;", "offline", "", "pageHashCode", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ZI)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCookie", "()Lcom/tencent/mm/protobuf/ByteString;", "getOffline", "()Z", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveHeartbeatReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveHeartbeatResp;", "getSongId", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "", "Companion", "plugin-mv_release"})
public final class l
  extends a
{
  public static final a GdD;
  private final boolean Gch;
  private dbd GdA;
  public dbe GdB;
  private final b GdC;
  private i callback;
  private final String kkU;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(231230);
    GdD = new a((byte)0);
    AppMethodBeat.o(231230);
  }
  
  public l(String paramString, b paramb, boolean paramBoolean)
  {
    super(0);
    AppMethodBeat.i(231229);
    this.kkU = paramString;
    this.GdC = paramb;
    this.Gch = paramBoolean;
    paramString = new d.a();
    paramString.vD(6820);
    paramString.TW("/cgi-bin/micromsg-bin/musicliveheartbeat");
    paramString.c((com.tencent.mm.cd.a)new dbd());
    paramString.d((com.tencent.mm.cd.a)new dbe());
    paramString = paramString.bgN();
    p.j(paramString, "commReqRespBuilder.buildInstance()");
    this.lKU = paramString;
    paramString = this.lKU.bhX();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveHeartbeatReq");
      AppMethodBeat.o(231229);
      throw paramString;
    }
    this.GdA = ((dbd)paramString);
    paramString = this.GdA;
    if (paramString != null) {
      paramString.TIm = this.kkU;
    }
    paramString = this.GdA;
    if (paramString != null) {
      paramString.GdC = this.GdC;
    }
    paramString = this.GdA;
    if (paramString != null)
    {
      paramString.Gch = this.Gch;
      AppMethodBeat.o(231229);
      return;
    }
    AppMethodBeat.o(231229);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(231226);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(231226);
    return i;
  }
  
  public final int getType()
  {
    return 6820;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(231227);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvHeartbeat", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(231227);
        return;
      }
      AppMethodBeat.o(231227);
      return;
    }
    params = this.lKU.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveHeartbeatResp");
      AppMethodBeat.o(231227);
      throw paramString;
    }
    this.GdB = ((dbe)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(231227);
      return;
    }
    AppMethodBeat.o(231227);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvHeartbeat$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.l
 * JD-Core Version:    0.7.0.1
 */