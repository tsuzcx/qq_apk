package com.tencent.mm.plugin.mv.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvCheckPermission;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionReq;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionReq;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionReq;)V", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionResp;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionResp;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionResp;)V", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-mv_release"})
public final class a
  extends m
{
  private crw Aqm;
  public crx Aqn;
  private final axy Aqo;
  private final String TAG;
  private i callback;
  private d iUB;
  
  public a(axy paramaxy, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(258859);
    this.Aqo = paramaxy;
    this.TAG = "MicroMsg.Mv.NetSceneMusicMvCheckPermission";
    paramaxy = new d.a();
    paramaxy.sG(5286);
    paramaxy.MB("/cgi-bin/micromsg-bin/musiclivecheckpermission");
    paramaxy.c((com.tencent.mm.bw.a)new crw());
    paramaxy.d((com.tencent.mm.bw.a)new crx());
    paramaxy = paramaxy.aXF();
    p.g(paramaxy, "commReqResp");
    Object localObject = paramaxy.aYJ();
    if (localObject == null)
    {
      paramaxy = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveCheckPermissionReq");
      AppMethodBeat.o(258859);
      throw paramaxy;
    }
    this.Aqm = ((crw)localObject);
    localObject = this.Aqm;
    if (localObject != null) {
      ((crw)localObject).MwY = this.Aqo;
    }
    this.iUB = paramaxy;
    AppMethodBeat.o(258859);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(256812);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(256812);
    return i;
  }
  
  public final int getType()
  {
    return 5286;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256813);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i(this.TAG, "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(256813);
        return;
      }
      AppMethodBeat.o(256813);
      return;
    }
    params = this.iUB;
    if (params != null) {}
    for (params = params.aYK(); params == null; params = null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveCheckPermissionResp");
      AppMethodBeat.o(256813);
      throw paramString;
    }
    this.Aqn = ((crx)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(256813);
      return;
    }
    AppMethodBeat.o(256813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a.a
 * JD-Core Version:    0.7.0.1
 */