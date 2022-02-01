package com.tencent.mm.plugin.vlog.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.azz;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGetClientConfFromServer;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetClientConfFromServerReq;", "response", "Lcom/tencent/mm/protocal/protobuf/GetClientConfFromServerResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class b
  extends n
  implements k
{
  public static final a BYB;
  public azz BYA;
  private azy BYz;
  private f callback;
  private com.tencent.mm.ak.b gRX;
  
  static
  {
    AppMethodBeat.i(110962);
    BYB = new a((byte)0);
    AppMethodBeat.o(110962);
  }
  
  public b()
  {
    AppMethodBeat.i(110961);
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).c((a)new azy());
    ((com.tencent.mm.ak.b.a)localObject).d((a)new azz());
    ((com.tencent.mm.ak.b.a)localObject).oS(2972);
    ((com.tencent.mm.ak.b.a)localObject).DN("/cgi-bin/spr-bin/getclientconffromserver");
    ((com.tencent.mm.ak.b.a)localObject).oU(0);
    ((com.tencent.mm.ak.b.a)localObject).oU(0);
    localObject = ((com.tencent.mm.ak.b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((com.tencent.mm.ak.b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetClientConfFromServerReq");
      AppMethodBeat.o(110961);
      throw ((Throwable)localObject);
    }
    this.BYz = ((azy)localObject);
    AppMethodBeat.o(110961);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(110959);
    ae.i("MicroMsg.NetSceneGetClientConfFromServer", "do scene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(110959);
    return i;
  }
  
  public final int getType()
  {
    return 2972;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(110960);
    ae.i("MicroMsg.NetSceneGetClientConfFromServer", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(110960);
      throw paramString;
    }
    paramq = ((com.tencent.mm.ak.b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetClientConfFromServerResp");
      AppMethodBeat.o(110960);
      throw paramString;
    }
    this.BYA = ((azz)paramq);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(110960);
      return;
    }
    AppMethodBeat.o(110960);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/cgi/NetSceneGetClientConfFromServer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.cgi.b
 * JD-Core Version:    0.7.0.1
 */