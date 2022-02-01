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
import com.tencent.mm.protocal.protobuf.dsb;
import com.tencent.mm.protocal.protobuf.dsc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneMusicMvCheckPermission;", "Lcom/tencent/mm/plugin/mv/model/netscene/BaseMvNetScene;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "pageHashCode", "", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionReq;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionReq;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionReq;)V", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionResp;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionResp;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveCheckPermissionResp;)V", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
{
  private final boo LWI;
  private dsb LYO;
  public dsc LYP;
  private final String TAG;
  private h callback;
  private c oDw;
  
  public f(boo paramboo, int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(286262);
    this.LWI = paramboo;
    this.TAG = "MicroMsg.Mv.NetSceneMusicMvCheckPermission";
    paramboo = new c.a();
    paramboo.funcId = 5286;
    paramboo.uri = "/cgi-bin/micromsg-bin/musiclivecheckpermission";
    paramboo.otE = ((com.tencent.mm.bx.a)new dsb());
    paramboo.otF = ((com.tencent.mm.bx.a)new dsc());
    paramboo = paramboo.bEF();
    Object localObject = c.b.b(paramboo.otB);
    if (localObject == null)
    {
      paramboo = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveCheckPermissionReq");
      AppMethodBeat.o(286262);
      throw paramboo;
    }
    this.LYO = ((dsb)localObject);
    localObject = this.LYO;
    if (localObject != null) {
      ((dsb)localObject).aaXW = this.LWI;
    }
    localObject = ah.aiuX;
    this.oDw = paramboo;
    AppMethodBeat.o(286262);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(286265);
    this.callback = paramh;
    int i = dispatch(paramg, (s)this.oDw, (m)this);
    AppMethodBeat.o(286265);
    return i;
  }
  
  public final int getType()
  {
    return 5286;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(286281);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    Log.i(this.TAG, "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params != null) {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(286281);
      return;
    }
    params = this.oDw;
    if (params == null) {}
    for (params = null; params == null; params = c.c.b(params.otC))
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveCheckPermissionResp");
      AppMethodBeat.o(286281);
      throw paramString;
    }
    this.LYP = ((dsc)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(286281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.f
 * JD-Core Version:    0.7.0.1
 */