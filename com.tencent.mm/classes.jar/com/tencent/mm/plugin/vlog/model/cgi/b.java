package com.tencent.mm.plugin.vlog.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGetClientConfFromServer;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetClientConfFromServerReq;", "response", "Lcom/tencent/mm/protocal/protobuf/GetClientConfFromServerResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends p
  implements m
{
  public static final b.a Ubp;
  private chk Ubq;
  public chl Ubr;
  private h callback;
  private c nao;
  
  static
  {
    AppMethodBeat.i(110962);
    Ubp = new b.a((byte)0);
    AppMethodBeat.o(110962);
  }
  
  public b()
  {
    AppMethodBeat.i(110961);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new chk());
    ((c.a)localObject).otF = ((a)new chl());
    ((c.a)localObject).funcId = 2972;
    ((c.a)localObject).uri = "/cgi-bin/spr-bin/getclientconffromserver";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).otG = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.nao = ((c)localObject);
    localObject = c.b.b(this.nao.otB);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetClientConfFromServerReq");
      AppMethodBeat.o(110961);
      throw ((Throwable)localObject);
    }
    this.Ubq = ((chk)localObject);
    AppMethodBeat.o(110961);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(110959);
    Log.i("MicroMsg.NetSceneGetClientConfFromServer", "do scene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(110959);
    return i;
  }
  
  public final int getType()
  {
    return 2972;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(110960);
    Log.i("MicroMsg.NetSceneGetClientConfFromServer", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(110960);
      throw paramString;
    }
    params = c.c.b(((c)params).otC);
    if (params == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetClientConfFromServerResp");
      AppMethodBeat.o(110960);
      throw paramString;
    }
    this.Ubr = ((chl)params);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(110960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.cgi.b
 * JD-Core Version:    0.7.0.1
 */