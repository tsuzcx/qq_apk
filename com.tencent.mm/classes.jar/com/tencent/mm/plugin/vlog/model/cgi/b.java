package com.tencent.mm.plugin.vlog.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bli;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGetClientConfFromServer;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetClientConfFromServerReq;", "response", "Lcom/tencent/mm/protocal/protobuf/GetClientConfFromServerResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class b
  extends q
  implements m
{
  public static final a GAi;
  private bli GAg;
  public blj GAh;
  private i callback;
  private d hJu;
  
  static
  {
    AppMethodBeat.i(110962);
    GAi = new a((byte)0);
    AppMethodBeat.o(110962);
  }
  
  public b()
  {
    AppMethodBeat.i(110961);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new bli());
    ((d.a)localObject).d((a)new blj());
    ((d.a)localObject).sG(2972);
    ((d.a)localObject).MB("/cgi-bin/spr-bin/getclientconffromserver");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sI(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetClientConfFromServerReq");
      AppMethodBeat.o(110961);
      throw ((Throwable)localObject);
    }
    this.GAg = ((bli)localObject);
    AppMethodBeat.o(110961);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(110959);
    Log.i("MicroMsg.NetSceneGetClientConfFromServer", "do scene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(110959);
    return i;
  }
  
  public final int getType()
  {
    return 2972;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(110960);
    Log.i("MicroMsg.NetSceneGetClientConfFromServer", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(110960);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetClientConfFromServerResp");
      AppMethodBeat.o(110960);
      throw paramString;
    }
    this.GAh = ((blj)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(110960);
      return;
    }
    AppMethodBeat.o(110960);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGetClientConfFromServer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.cgi.b
 * JD-Core Version:    0.7.0.1
 */