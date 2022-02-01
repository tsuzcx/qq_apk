package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvGetSongStatus;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCommReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "setCommReqResp", "(Lcom/tencent/mm/modelbase/CommReqResp;)V", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusReq;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusReq;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusReq;)V", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusResp;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusResp;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveGetSongStatusResp;)V", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends a
{
  private final boo LWI;
  private dss LZn;
  public dst LZo;
  private final String TAG;
  private h callback;
  private c oDw;
  
  public o(boo paramboo, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(286279);
    this.LWI = paramboo;
    this.TAG = "MicroMsg.Mv.NetSceneMusicMvGetSongStatus";
    paramboo = new c.a();
    paramboo.funcId = 5292;
    paramboo.uri = "/cgi-bin/micromsg-bin/musiclivegetsongstatus";
    paramboo.otE = ((com.tencent.mm.bx.a)new dss());
    paramboo.otF = ((com.tencent.mm.bx.a)new dst());
    paramboo = paramboo.bEF();
    Object localObject = c.b.b(paramboo.otB);
    if (localObject == null)
    {
      paramboo = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetSongStatusReq");
      AppMethodBeat.o(286279);
      throw paramboo;
    }
    this.LZn = ((dss)localObject);
    localObject = this.LZn;
    if (localObject != null) {
      ((dss)localObject).aaXV = this.LWI.mLQ;
    }
    localObject = this.LZn;
    if (localObject != null) {
      ((dss)localObject).aaYp = this.LWI.ZWQ;
    }
    localObject = this.LZn;
    if (localObject != null) {
      ((dss)localObject).aaYq = this.LWI.ZWR;
    }
    localObject = this.LZn;
    if (localObject != null) {
      ((dss)localObject).aaXW = this.LWI;
    }
    localObject = ah.aiuX;
    this.oDw = paramboo;
    Log.i(this.TAG, "create NetSceneMusicMvGetSongStatus " + this.LWI.mLQ + ' ' + this.LWI.songName + ' ' + this.LWI.rDl);
    AppMethodBeat.o(286279);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(286288);
    this.callback = paramh;
    int i = dispatch(paramg, (s)this.oDw, (m)this);
    AppMethodBeat.o(286288);
    return i;
  }
  
  public final int getType()
  {
    return 5292;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(286302);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i(this.TAG, "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(286302);
      return;
    }
    params = this.oDw;
    if (params == null) {}
    for (params = null; params == null; params = c.c.b(params.otC))
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetSongStatusResp");
      AppMethodBeat.o(286302);
      throw paramString;
    }
    this.LZo = ((dst)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(286302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.o
 * JD-Core Version:    0.7.0.1
 */