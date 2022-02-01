package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dbj;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvPostLiveMsg;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "msg", "Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLivePostLiveMsgReq;", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLivePostLiveMsgResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-mv_release"})
public final class n
  extends a
{
  public static final a GdJ;
  private dbl GdH;
  public dbm GdI;
  private i callback;
  private final d lKU;
  
  static
  {
    AppMethodBeat.i(225441);
    GdJ = new a((byte)0);
    AppMethodBeat.o(225441);
  }
  
  public n(dbj paramdbj, bds parambds)
  {
    super(1);
    AppMethodBeat.i(225437);
    Object localObject = new d.a();
    ((d.a)localObject).vD(6672);
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/musiclivepostlivemsg");
    ((d.a)localObject).c((com.tencent.mm.cd.a)new dbl());
    ((d.a)localObject).d((com.tencent.mm.cd.a)new dbm());
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "commReqRespBuilder.buildInstance()");
    this.lKU = ((d)localObject);
    localObject = this.lKU.bhX();
    if (localObject == null)
    {
      paramdbj = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLivePostLiveMsgReq");
      AppMethodBeat.o(225437);
      throw paramdbj;
    }
    this.GdH = ((dbl)localObject);
    localObject = this.GdH;
    if (localObject != null) {
      ((dbl)localObject).TIN = paramdbj;
    }
    paramdbj = this.GdH;
    if (paramdbj != null)
    {
      paramdbj.TIn = parambds;
      AppMethodBeat.o(225437);
      return;
    }
    AppMethodBeat.o(225437);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(225429);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(225429);
    return i;
  }
  
  public final int getType()
  {
    return 6672;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225433);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i("MicroMsg.Mv.NetSceneMusicMvPostLiveMsg", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(225433);
        return;
      }
      AppMethodBeat.o(225433);
      return;
    }
    params = this.lKU.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLivePostLiveMsgResp");
      AppMethodBeat.o(225433);
      throw paramString;
    }
    this.GdI = ((dbm)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(225433);
      return;
    }
    AppMethodBeat.o(225433);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvPostLiveMsg$Companion;", "", "()V", "TAG", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.n
 * JD-Core Version:    0.7.0.1
 */