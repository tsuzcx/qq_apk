package com.tencent.mm.plugin.mv.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csk;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.protocal.protobuf.csn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvPostLiveMsg;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "msg", "Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLivePostLiveMsgReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLivePostLiveMsgResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class l
  extends m
{
  public static final a AqX;
  private csm AqV;
  public csn AqW;
  private i callback;
  private final d iUB;
  
  static
  {
    AppMethodBeat.i(256857);
    AqX = new a((byte)0);
    AppMethodBeat.o(256857);
  }
  
  public l(csk paramcsk, axy paramaxy, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(258866);
    Object localObject = new d.a();
    ((d.a)localObject).sG(6672);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/musiclivepostlivemsg");
    ((d.a)localObject).c((a)new csm());
    ((d.a)localObject).d((a)new csn());
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "commReqRespBuilder.buildInstance()");
    this.iUB = ((d)localObject);
    localObject = this.iUB.aYJ();
    if (localObject == null)
    {
      paramcsk = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLivePostLiveMsgReq");
      AppMethodBeat.o(258866);
      throw paramcsk;
    }
    this.AqV = ((csm)localObject);
    localObject = this.AqV;
    if (localObject != null) {
      ((csm)localObject).Mxx = paramcsk;
    }
    paramcsk = this.AqV;
    if (paramcsk != null)
    {
      paramcsk.MwY = paramaxy;
      AppMethodBeat.o(258866);
      return;
    }
    AppMethodBeat.o(258866);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(256854);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(256854);
    return i;
  }
  
  public final int getType()
  {
    return 6672;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256855);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvPostLiveMsg", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(256855);
        return;
      }
      AppMethodBeat.o(256855);
      return;
    }
    params = this.iUB.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLivePostLiveMsgResp");
      AppMethodBeat.o(256855);
      throw paramString;
    }
    this.AqW = ((csn)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(256855);
      return;
    }
    AppMethodBeat.o(256855);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvPostLiveMsg$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a.l
 * JD-Core Version:    0.7.0.1
 */